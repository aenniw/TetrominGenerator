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
import cz.fi.muni.pv097.CoreComponents.TetroPart;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author 410134
 */
public class ObjectGallery extends JPanel {

    private final ArrayList<TetroSquare[][]> Objects;
    private int collums = 6, lines = 9, activ = 0;

    /**
     * Default empty gallery to containg a reshow editable objects generated
     * from ObjectCreator
     */
    public ObjectGallery() {
        super();
        Objects = new ArrayList<>();
    }

    /**
     * After change of TetroSquare size clears old parts and setup new dimension
     * of panel
     *
     * @param d size of default panel containg objects
     */
    public void setPartSize(Dimension d) {
        this.collums = d.width;
        this.lines = d.height;
        this.activ = 0;
        this.Objects.clear();
        this.repaint();
    }

    /**
     * Adds new object to collection
     *
     * @param object to be added
     */
    public void addObject(TetroSquare[][] object) {
        this.Objects.add(object);
        this.setSelectedIndex(this.Objects.size() - 1);
    }

    /**
     *
     * @return selected index
     */
    public int getSelectedIndex() {
        return this.activ;
    }

    /**
     * Set selected object in gallery
     *
     * @param newActiv number of object to be selected
     */
    public void setSelectedIndex(int newActiv) {
        this.activ = newActiv;
        this.repaint();
    }

    /**
     * Removes object from gallery for purpose of editing mainly
     *
     * @return return object from gallery
     */
    public TetroSquare[][] getObject() {
        if (!this.Objects.isEmpty()) {
            TetroSquare[][] help = this.Objects.remove(activ);
            this.setSelectedIndex(this.Objects.size() - 1);
            return help;
        }
        return null;
    }

    /**
     * Exports data for algorythm
     *
     * @return data for next job
     */
    public ArrayList<TetroPart> exportGallery() {
        ArrayList<TetroPart> export = new ArrayList<>();
        for (TetroSquare[][] part : this.Objects) {
            export.add(new TetroPart(part));
        }
        return export;
    }

    /**
     *
     * @return number of objects in gallery
     */
    public int gallerySize() {
        return this.Objects.size();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (!this.Objects.isEmpty()) {
            if ((activ - 1 >= 0) && (activ - 1 < this.Objects.size()) && (this.Objects.get(activ - 1) != null)) {
                for (int collum = 0; collum < collums; collum++) {
                    for (int line = 0; line < lines; line++) {
                        if (this.Objects.get(activ - 1)[collum][line].isSelected()) {
                            this.Objects.get(activ - 1)[collum][line].paintSquare(g, 0.5, 9, 43);
                        }
                    }
                }

            }
            if ((activ >= 0) && (activ < this.Objects.size()) && (this.Objects.get(activ) != null)) {
                for (int collum = 0; collum < collums; collum++) {
                    for (int line = 0; line < lines; line++) {
                        if (this.Objects.get(activ)[collum][line].isSelected()) {
                            this.Objects.get(activ)[collum][line].paintSquare(g, 0.75, 93, 15);
                        }
                    }
                }
            }
            if ((activ + 1 >= 0) && (activ + 1 < this.Objects.size()) && (this.Objects.get(activ + 1) != null)) {
                for (int collum = 0; collum < collums; collum++) {
                    for (int line = 0; line < lines; line++) {
                        if (this.Objects.get(activ + 1)[collum][line].isSelected()) {
                            this.Objects.get(activ + 1)[collum][line].paintSquare(g, 0.5, 216, 43);
                        }
                    }
                }
            }
        }
    }

}
