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
package cz.fi.muni.pv097.Canvases;

import cz.fi.muni.pv097.CoreComponents.TetroSquare;
import cz.fi.muni.pv097.Canvases.Listeners.ObjectCreatorListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import javax.swing.JPanel;

/**
 *
 * @author 410134
 */
public class ObjectCreator extends JPanel {

    private TetroSquare[][] plate;
    private Point lastClick = null;
    private boolean removeSwitch = false;
    private Color inner = Color.red, outer = Color.white;
    private int border, active = 0, partSize = 25, collums = 6, lines = 9;

    /**
     * Plate for Creating objects for Tetromin Generation
     */
    public ObjectCreator() {
        super();
        this.border = 2;
        this.createPlate();
        this.addMouseListener(new ObjectCreatorListener(this));
    }

    private void createPlate() {
        this.plate = new TetroSquare[collums][lines];
        for (int collum = 0; collum < collums; collum++) {
            for (int line = 0; line < lines; line++) {
                this.plate[collum][line] = new TetroSquare(partSize * collum, partSize * line, partSize, border);
            }
        }
    }

    /**
     * After change of TetroSquare size clears old parts and setup new dimension
     * of panel
     *
     * @param size size of default panel containg objects
     * @return dimension of x and y change
     */
    public Dimension setPartSize(int size) {
        this.partSize = size;
        this.collums = this.getWidth() / this.partSize;
        this.lines = this.getHeight() / this.partSize;
        this.createPlate();
        this.resetColor();
        return new Dimension(collums, lines);
    }

    /**
     * Setup board with provided data
     *
     * @param board data of board
     */
    public void setBoard(TetroSquare[][] board) {
        if (board != null) {
            this.plate = board;
            this.active = 0;
            for (TetroSquare[] part : this.plate) {
                for (TetroSquare part1 : part) {
                    if (part1.isSelected()) {
                        this.active++;
                    }
                }
            }
            this.repaint();
        }
    }

    /**
     * Gets board with object
     *
     * @return board of data
     */
    public TetroSquare[][] getObject() {
        TetroSquare[][] help = new TetroSquare[collums][lines];
        for (int collum = 0; collum < collums; collum++) {
            for (int line = 0; line < lines; line++) {
                help[collum][line] = this.plate[collum][line].copy();
            }
        }
        return help;
    }

    /**
     * Sets default color
     */
    public void resetColor() {
        for (TetroSquare[] part : this.plate) {
            for (TetroSquare part1 : part) {
                part1.setColor(Color.white, Color.gray);
                part1.setSelected(false);
                part1.setBorder(2);
            }
        }
        this.active = 0;
        this.lastClick = null;
        this.repaint();
    }

    private void recursivTestConnetion(int collum, int line, HashSet<TetroSquare> counted) {
        if ((collum >= collums) || (collum < 0) || (line < 0) || (line >= lines)) {
            return;
        }
        if (plate[collum][line].isSelected()) {
            if (!counted.contains(plate[collum][line])) {
                counted.add(plate[collum][line]);
                this.recursivTestConnetion(collum, line + 1, counted);
                this.recursivTestConnetion(collum, line - 1, counted);
                this.recursivTestConnetion(collum + 1, line, counted);
                this.recursivTestConnetion(collum - 1, line, counted);
            }
        }
    }

    /**
     * Test if object is one solid piece
     *
     * @return if the object is solid
     */
    public boolean testConection() {
        for (int collum = 0; collum < collums; collum++) {
            for (int line = 0; line < lines; line++) {
                if (this.plate[collum][line].isSelected()) {
                    HashSet<TetroSquare> counted = new HashSet<>();
                    recursivTestConnetion(collum, line, counted);
                    return this.active == counted.size();
                }
            }
        }
        return false;
    }

    /**
     * Sets new size of border
     *
     * @param border size of border
     */
    public void setBorder(int border) {
        this.lastClick = null;
        this.border = border;
    }

    /**
     * Sets position of last clink on board
     *
     * @param position of last clik
     */
    public void setDefaultSquare(Point position) {
        this.lastClick = position;
        removeSwitch = true;
        this.repaint();
    }

    /**
     * Sets color scheme
     *
     * @param inner color to be setted
     * @param outer color to be setted
     */
    public void changeColorOfSquare(Color inner, Color outer) {
        if (inner != null) {
            this.inner = inner;
        }
        if (outer != null) {
            this.outer = outer;
        }
    }

    /**
     * Changes color of specified square
     *
     * @param position where to change color
     */
    public void changeColor(Point position) {
        this.lastClick = position;
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (TetroSquare[] part : this.plate) {
            for (TetroSquare part1 : part) {
                if (lastClick != null && part1.getColision(lastClick)) {
                    if (removeSwitch) {
                        part1.setColor(Color.white, Color.gray);
                        if (part1.isSelected()) {
                            this.active--;
                        }
                        part1.setSelected(false);
                        part1.setBorder(2);
                        this.removeSwitch = false;
                    } else {
                        part1.setBorder(border);
                        part1.setColor(inner, outer);
                        if (!part1.isSelected()) {
                            this.active++;
                        }
                        part1.setSelected(true);
                    }
                }
                part1.paintSquare(g, 1, (this.getWidth() % this.partSize) / 2, (this.getHeight() % this.partSize) / 2);
            }
        }
    }

}
