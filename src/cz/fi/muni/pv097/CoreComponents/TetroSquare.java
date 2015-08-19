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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author 410134
 */
public class TetroSquare implements Serializable {

    private final Rectangle colision;
    private Color colorInner, colorOuter;
    private int border = 0;
    private boolean activ = false;

    /**
     * Creates 2 colored square
     *
     * @param x coordina
     * @param y coordinate
     * @param width size of square
     */
    public TetroSquare(int x, int y, int width) {
        this.colision = new Rectangle(x, y, width, width);
        this.colorInner = Color.WHITE;
        this.colorOuter = Color.GRAY;
    }

    /**
     * Creates 2 colored square
     *
     * @param x coordina
     * @param y coordinate
     * @param width size of square
     * @param border size of border
     */
    public TetroSquare(int x, int y, int width, int border) {
        this(x, y, width);
        this.border = border;
    }

    private void paint(Graphics g, int offX, int offY) {
        if (this.border != 0) {
            g.setColor(this.colorOuter);
            g.fillRect(this.colision.x + offX, this.colision.y + offY,
                    this.colision.width, this.colision.height);
        }
        g.setColor(this.colorInner);
        g.fillRect(offX + this.colision.x + border, offY + this.colision.y + border,
                this.colision.width - 2 * border, this.colision.height - 2 * border);
    }

    /**
     * Paint square on screen
     *
     * @param g
     * @param resize value
     * @param offX offsite of x coordinate
     * @param offY offsite of y coordinate
     */
    public void paintSquare(Graphics g, double resize, int offX, int offY) {
        if (resize == 1) {
            paint(g, offX, offY);
        } else {
            int w = (int) (this.colision.width * resize);
            int h = (int) (this.colision.height * resize);
            if (this.border != 0) {
                g.setColor(this.colorOuter);
                g.fillRect((this.colision.x / this.colision.width) * w + offX, (this.colision.y / this.colision.height) * h + offY,
                        w, h);
            }
            int b = (int) (border * resize);
            g.setColor(this.colorInner);
            g.fillRect(offX + ((this.colision.x / this.colision.width) * w) + b, offY + ((this.colision.y / this.colision.height) * h) + b,
                    w - 2 * b, h - 2 * b);

        }
    }

    /**
     * Sets size square border
     *
     * @param border size
     */
    public void setBorder(int border) {
        this.border = border;
    }

    /**
     * Sets colors of square
     *
     * @param inner color
     * @param outer color
     */
    public void setColor(Color inner, Color outer) {
        if (inner != null) {
            this.colorInner = inner;
        }
        if (outer != null) {
            this.colorOuter = outer;
        }
    }

    /**
     * Returns if square is not deafult
     *
     * @param activ
     */
    public void setSelected(boolean activ) {
        this.activ = activ;
    }

    /**
     * Sets position of square in area
     *
     * @param x coordinate
     * @param y coordinate
     */
    public void setPosition(int x, int y) {
        this.colision.setLocation(x, y);
    }

    /**
     * Test if square colide with another square
     *
     * @param colision rectangle to be tested
     * @return
     */
    public boolean getColision(Rectangle colision) {
        return this.colision.intersects(colision);
    }

    /**
     * Test if square contains point
     *
     * @param p point to be tested
     * @return
     */
    public boolean getColision(Point p) {
        return this.colision.contains(p);
    }

    /**
     * Gets bounds of this square
     *
     * @return rectangle
     */
    public Rectangle getColision() {
        return this.colision;
    }

    /**
     *
     * @return if square is not default
     */
    public boolean isSelected() {
        return this.activ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TetroSquare other = (TetroSquare) obj;
        if (!Objects.equals(this.colision, other.colision)) {
            return false;
        }
        if (!Objects.equals(this.colorInner, other.colorInner)) {
            return false;
        }
        if (!Objects.equals(this.colorOuter, other.colorOuter)) {
            return false;
        }
        if (this.border != other.border) {
            return false;
        }
        return this.activ == other.activ;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.colision);
        hash = 67 * hash + Objects.hashCode(this.colorInner);
        hash = 67 * hash + Objects.hashCode(this.colorOuter);
        hash = 67 * hash + this.border;
        hash = 67 * hash + (this.activ ? 1 : 0);
        return hash;
    }

    /**
     * Gets copy of this square
     *
     * @return copy
     */
    public TetroSquare copy() {
        TetroSquare help = new TetroSquare(this.colision.x, this.colision.y, this.colision.width, this.border);
        help.setColor(this.colorInner, this.colorOuter);
        help.setSelected(this.activ);
        if (this.activ) {
            help.setSelected(true);
        }
        return help;
    }
}
