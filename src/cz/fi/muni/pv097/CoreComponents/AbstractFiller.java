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

import cz.fi.muni.pv097.Canvases.ImageGeneratorPreview;
import cz.fi.muni.pv097.Gui.TetroGui;
import cz.fi.muni.pv097.Gui.TetroTab;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author 410134
 */
public abstract class AbstractFiller implements ActionListener, Serializable {

    protected static TetroGui topParent;
    protected final TetroTab parent;
    protected final Timer timer = new Timer(250, this);
    private final String name;
    protected final ImageGeneratorPreview canvas;
    protected static final Random i = new Random(System.nanoTime());

    public AbstractFiller(ImageGeneratorPreview can, TetroTab pa, String name) {
        super();
        this.name = name;
        this.parent = pa;
        this.canvas = can;
    }

    /**
     * Sets top parrent for progres bar manipulation
     *
     * @param p JFrame window
     */
    public static void setTopParent(TetroGui p) {
        topParent = p;
    }

    /**
     * Repaint tab
     */
    public void repaintParent() {
        parent.repaint();
    }

    /**
     * Gets Specific for algorithm
     *
     * @return side bar
     */
    public abstract JPanel getSideBar();

    /**
     * Sets delay of 1 step in miliseconds
     *
     * @param i size of new delay
     */
    public void setDelay(int i) {
        timer.setDelay(i);
    }

    /**
     * Start Algorithm
     */
    public void compute() {
        if (timer.isRunning()) {
            stop();
        } else {
            timer.start();
            topParent.setProgresBar(true);
        }
    }

    /**
     * Stops running thread
     */
    public void stop() {
        if (timer.isRunning()) {
            timer.stop();
            topParent.setProgresBar(false);
            canvas.setPaint(true);
            canvas.repaint();
        }
    }

    /**
     * Gets name of algorithm
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Input key handler
     *
     * @param evt
     */
    public abstract void formKeyPressed(KeyEvent evt);

    @Override
    public abstract void actionPerformed(ActionEvent ae);

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractFiller other = (AbstractFiller) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        return hash;
    }

}
