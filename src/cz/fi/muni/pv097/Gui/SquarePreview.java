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
package cz.fi.muni.pv097.Gui;

import cz.fi.muni.pv097.CoreComponents.TetroSquare;
import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author 410134
 */
public class SquarePreview extends javax.swing.JPanel {

    private final TetroSquare preview;

    /**
     * Preview of tetrominSquare
     */
    public SquarePreview() {
        preview = new TetroSquare(10, 0, 25, 2);
        preview.setColor(Color.red, Color.white);
        initComponents();
    }

    /**
     * Changes size of shown square
     *
     * @param i size to be set
     */
    public void setSize(int i) {
        preview.getColision().setLocation(this.getWidth() - i, 0);
        preview.getColision().setSize(i, i);
    }

    /**
     * Changes size of square boreder
     *
     * @param border size of new border
     */
    public void setBorderOfSquare(int border) {
        preview.setBorder(border);
    }

    /**
     * Changes colors of square
     *
     * @param inner color
     * @param outer color
     */
    public void setColor(Color inner, Color outer) {
        preview.setColor(inner, outer);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        preview.paintSquare(g, 1, 0, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new Color(0,0,0,0));
        setMaximumSize(new java.awt.Dimension(26, 26));
        setMinimumSize(new java.awt.Dimension(25, 25));
        setPreferredSize(new java.awt.Dimension(26, 26));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
