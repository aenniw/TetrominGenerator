/*
 * Copyright (C) 2014 410134
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package cz.fi.muni.pv097.CoreComponents;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author 410134
 */
public class TetroPart implements Serializable {

    private final ArrayList<TetroSquare> parts;
    private final int size;
    private int rank[][], orientation;
    private Rectangle colisionObject = null;

    /**
     * Creates part form board
     *
     * @param oldPart board
     */
    public TetroPart(TetroSquare[][] oldPart) {
        if (oldPart == null) {
            throw new IllegalArgumentException("Old part array is null");
        }
        size = oldPart[0][0].getColision().width;
        int xMin = size * oldPart.length, yMin = size * oldPart[0].length;
        parts = new ArrayList<>();
        for (TetroSquare[] oldPart1 : oldPart) {
            for (TetroSquare oldPart2 : oldPart1) {
                if (oldPart2.isSelected()) {
                    if (this.colisionObject == null) {
                        this.colisionObject = oldPart2.getColision();
                    } else {
                        this.colisionObject = this.colisionObject.union(oldPart2.getColision());
                    }
                    xMin = Math.min(xMin, oldPart2.getColision().x);
                    yMin = Math.min(yMin, oldPart2.getColision().y);
                    this.parts.add(oldPart2.copy());
                }
            }
        }
        this.colisionObject = new Rectangle(0, 0, colisionObject.width, colisionObject.height);
        for (TetroSquare sq : this.parts) {
            sq.setPosition(this.colisionObject.x + sq.getColision().x - xMin, this.colisionObject.y + sq.getColision().y - yMin);
        }
        if (colisionObject.width < colisionObject.height) {
            this.rotateRight();
        }
        orientation = 2;
        computeRanks();
    }

    /**
     * Quick setup of part from existing part
     *
     * @param oldPart
     * @param colis
     * @param size
     * @param rank
     * @param or
     */
    public TetroPart(ArrayList<TetroSquare> oldPart, Rectangle colis, int size, int rank[][], int or) {
        if (oldPart == null) {
            throw new IllegalArgumentException("Old part array is null");
        }
        parts = new ArrayList<>();
        for (TetroSquare sq : oldPart) {
            this.parts.add(sq.copy());
        }
        this.colisionObject = new Rectangle(0, 0, colis.width, colis.height);
        this.size = size;
        this.rank = rank;
        orientation = or;
    }

    /**
     * Sets position of part in area
     *
     * @param x coordinate
     * @param y coordinate
     */
    public void setPos(int x, int y) {
        int chX = this.colisionObject.x - x;
        int chY = this.colisionObject.y - y;
        this.colisionObject.x = x;
        this.colisionObject.y = y;
        for (TetroSquare sq : this.parts) {
            sq.setPosition(sq.getColision().x - chX, sq.getColision().y - chY);
        }
    }

    /**
     *
     * @return wigth of part
     */
    public int getWidth() {
        return this.colisionObject.width;
    }

    /**
     *
     * @return height of part
     */
    public int getHeight() {
        return this.colisionObject.height;
    }

    /**
     *
     * @return x position in area
     */
    public int getX() {
        return this.colisionObject.x;
    }

    /**
     *
     * @return y position in area
     */
    public int getY() {
        return this.colisionObject.y;
    }

    /**
     *
     * @return rank of current orietation
     */
    public int[] getRank() {
        return rank[orientation];
    }

    /**
     *
     * @return ranks for all orientations
     */
    public int[][] getRanks() {
        return rank;
    }

    /**
     *
     * @return get oposite rank of current orientation
     */
    public int[] getInverseRank() {
        int l = rank[(orientation + 2) % 4].length;
        int hlp[] = new int[l];
        for (int i = 1; i <= l; i++) {
            hlp[l - i] = rank[(orientation + 2) % 4][i - 1];
        }
        return hlp;
    }

    /**
     * Test if Rectagle contains part
     *
     * @param r resctagle to be tested
     * @return
     */
    public boolean contains(Rectangle r) {
        return r.contains(this.colisionObject);
    }

    /**
     * Paint part on screen
     *
     * @param g
     * @param resize value
     * @param offX offsite on x coordinate
     * @param offY offsite on y coordinate
     */
    public void paint(Graphics g, double resize, int offX, int offY) {
        for (TetroSquare sq : this.parts) {
            sq.paintSquare(g, resize, offX, offY);
        }
    }

    /**
     * Test if rencangle intersects with part
     *
     * @param r resctangle to be tested
     * @return
     */
    public boolean colision(Rectangle r) {
        return this.colisionObject.intersects(r);
    }

    /**
     * Test if 2 tetroparts have colision
     *
     * @param part TetroPart to be tested
     * @return
     */
    public boolean colision(TetroPart part) {
        for (TetroSquare sqMy : this.parts) {
            for (TetroSquare sqPart : part.parts) {
                if (sqMy.getColision(sqPart.getColision())) {
                    return true;
                }
            }
        }

        return false;
    }

    private void computeRanks() {
        rank = new int[4][];
        for (int i = 0; i < 4; i++) {
            computeRank();
            rotateRight();
        }
        orientation = 0;
    }

    private void computeRank() {
        rank[orientation] = new int[this.colisionObject.width / size];
        for (int collum = 0; collum < colisionObject.width / size; collum++) {
            for (int line = 0; line < colisionObject.height / size; line++) {
                for (TetroSquare sq : parts) {
                    if (sq.getColision().x == collum * size && sq.getColision().y == line * size) {
                        rank[orientation][(colisionObject.width / size) - collum - 1] = line;
                        line = colisionObject.height / size;
                        break;
                    }
                }
            }
        }

    }

    private void orientationCorect() {
        if (orientation < 0) {
            orientation = 3;
        } else if (orientation > 3) {
            orientation = 0;
        }
    }

    /**
     * Rotate object allong direction of hour hand
     */
    public void rotateLeft() {
        if (this.parts.size() > 1) {
            int maxX = this.colisionObject.x + this.colisionObject.width;
            int diagonal = this.colisionObject.x - this.colisionObject.y;
            for (TetroSquare sq : this.parts) {
                sq.setPosition(this.colisionObject.x + maxX - (sq.getColision().x + this.size), sq.getColision().y);
                sq.setPosition(sq.getColision().y + diagonal, sq.getColision().x - diagonal);
            }
            this.colisionObject.setSize(this.colisionObject.height, this.colisionObject.width);
        }
        orientation--;
        orientationCorect();
    }

    /**
     * Rotate object allong reverse direction of hour hand
     */
    public void rotateRight() {
        if (this.parts.size() > 1) {
            int maxY = this.colisionObject.y + this.colisionObject.height;
            int diagonal = this.colisionObject.y - this.colisionObject.x;
            for (TetroSquare sq : this.parts) {
                sq.setPosition(sq.getColision().x, this.colisionObject.y + maxY - (sq.getColision().y + this.size));
                sq.setPosition(sq.getColision().y - diagonal, sq.getColision().x + diagonal);
            }
            this.colisionObject.setSize(this.colisionObject.height, this.colisionObject.width);
        }
        orientation++;
        orientationCorect();

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TetroPart other = (TetroPart) obj;
        if (!Objects.equals(this.parts, other.parts)) {
            return false;
        }
        return Objects.equals(this.colisionObject, other.colisionObject);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.parts);
        hash = 31 * hash + Objects.hashCode(this.colisionObject);
        return hash;
    }

    /**
     * Creates a copy of this part
     *
     * @return copy of part
     */
    public TetroPart copy() {
        return new TetroPart(this.parts, this.colisionObject, size, rank, orientation);
    }

}
