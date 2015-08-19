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
package cz.fi.muni.pv097.Algorithms;

import cz.fi.muni.pv097.CoreComponents.AbstractFiller;
import cz.fi.muni.pv097.Canvases.ImageGeneratorPreview;
import cz.fi.muni.pv097.Gui.SideBars.ManualSideBar;
import cz.fi.muni.pv097.Gui.TetroTab;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author 410134
 */
public class Manual extends AbstractFiller {

    private final ManualSideBar sideBar;

    /**
     * Creates manual control of generation
     *
     * @param can canvas
     * @param pa tetroTab
     */
    public Manual(ImageGeneratorPreview can, TetroTab pa) {
        super(can, pa, "Manual");
        this.sideBar = new ManualSideBar(can, this);
    }

    @Override
    public JPanel getSideBar() {
        return this.sideBar;
    }

    @Override
    public void compute() {
        if (sideBar.getGravity()) {
            timer.start();
            topParent.setProgresBar(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (sideBar.getGravity()) {
            if (!canvas.move(2)) {
                if (!canvas.addPart()) {
                    stop();
                } else {
                    canvas.repaint();
                }
            } else {
                canvas.repaint();
            }
        }
    }

    @Override
    public void formKeyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_CONTROL:
                canvas.rotateRight();
                canvas.repaint();
                break;
            case KeyEvent.VK_LEFT:
                canvas.move(-1);
                canvas.repaint();
                break;
            case KeyEvent.VK_UP:
                canvas.move(-2);
                canvas.repaint();
                break;
            case KeyEvent.VK_DOWN:
                canvas.move(2);
                canvas.repaint();
                break;
            case KeyEvent.VK_RIGHT:
                canvas.move(1);
                canvas.repaint();
                break;
            case KeyEvent.VK_SHIFT:
                canvas.addPart();
                canvas.repaint();
                break;
        }
    }
}
