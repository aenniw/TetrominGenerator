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
import cz.fi.muni.pv097.Gui.SideBars.RandonSideBar;
import cz.fi.muni.pv097.Gui.TetroTab;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author 410134
 */
public class Random extends AbstractFiller {

    private final RandonSideBar sideBar;
    private boolean move, saveUp = false;
    private int spinC = Integer.MAX_VALUE, switchMove = 0, switchDiagonal = 0, frst = 1, scnd = 1;
    private final int maxPos[], pos[];

    /**
     * Create algorithm based on randon numbers
     *
     * @param can canvas
     * @param pa tab
     */
    public Random(ImageGeneratorPreview can, TetroTab pa) {
        super(can, pa, "Random");
        this.sideBar = new RandonSideBar(this);
        this.maxPos = new int[2];
        this.pos = new int[2];
    }

    private void computeMaxs() {
        maxPos[0] = (canvas.getBoundsRectangle().width / canvas.getPartSize()) - (canvas.getAtivePart().getWidth() / canvas.getPartSize());
        maxPos[1] = (canvas.getBoundsRectangle().height / canvas.getPartSize()) - (canvas.getAtivePart().getHeight() / canvas.getPartSize());
    }

    @Override
    public JPanel getSideBar() {
        return this.sideBar;
    }

    private boolean compare(int f, int s, int cmp, int t) {
        // ==, !=, <, >
        switch (cmp) {
            case 0:
                return f % s == t;
            case 1:
                return f % s != t;
            case 2:
                return f % s < t;
            case 3:
                return f % s > t;
        }
        return false;
    }

    @Override
    public void formKeyPressed(KeyEvent evt) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!canvas.move(frst)) {
            if (spinC < sideBar.rotateCountSpinner()) {
                if ((sideBar.borderToggleButton2() || pos[frst - 1] < maxPos[frst - 1]) && (canvas.rotateRight() || canvas.rotateLeft())) {
                    spinC++;
                } else {
                    spinC = Integer.MAX_VALUE;
                }
            } else {
                move = canvas.move(scnd);
                if (sideBar.borderToggleButton1() || (pos[scnd - 1] < maxPos[scnd - 1]) && (canvas.rotateRight() || canvas.rotateLeft())) {
                    spinC++;
                } else {
                    spinC = Integer.MAX_VALUE;
                }
                if (sideBar.getAlg2() && !move) {
                    canvas.rotateRight();
                    move = canvas.move(scnd);
                    if (!move) {
                        canvas.rotateLeft();
                        move = canvas.move(scnd);
                    }
                } else if (move) {
                    pos[scnd - 1]++;
                }
                spinC = 0;
            }
        } else {
            pos[frst - 1]++;
        }
        if (sideBar.getAlg2()) {
            if (!move && !saveUp) {
                canvas.move(-frst);
                canvas.move(-scnd);
                move = true;
                saveUp = true;
            }
            if (compare(switchMove, sideBar.modulThirdLeftSpinner(), sideBar.modulThirdComboBox(), sideBar.modulThirdRightSpinner())) {
                int hlp = frst;
                frst = scnd;
                scnd = hlp;
            }
        }
        if (sideBar.getAlg3()) {
            if (compare(switchDiagonal, sideBar.modulFourthLeftSpinner(), sideBar.modulFourthComboBox(), sideBar.modulFourthRightSpinner())) {
                switchMove++;
                if (compare(switchMove, sideBar.modulFiftLeftSpinner(), sideBar.modulFiftComboBox(), sideBar.modulFiftRightSpinner())) {
                    frst = 2;
                    scnd = 1;
                } else {
                    frst = 1;
                    scnd = 2;
                }
            } else if (compare(switchDiagonal, sideBar.modulSixtLeftSpinner(), sideBar.modulSixtComboBox(), sideBar.modulSixtRightSpinner())) {
                switchMove++;
                if (switchMove == switchDiagonal / sideBar.diagonalLeftSpinner()) {
                    switchDiagonal++;
                }
            } else {
                switchMove++;
                if (switchMove == switchDiagonal / sideBar.diagonalRightSpinner()) {
                    switchDiagonal++;
                }
            }
        }
        canvas.repaint();
        if (!move) {
            if (!canvas.addPart()) {
                stop();
            } else {
                this.computeMaxs();
                move = true;
                pos[0] = 0;
                pos[1] = 0;
                if (sideBar.getAlg1() || sideBar.getAlg2()) {
                    if (compare(switchMove, sideBar.modulFirstLeftSpinner(), sideBar.modulFirstComboBox(), sideBar.modulFirstRightSpinner())) {
                        frst = 2;
                        scnd = 1;
                    } else if (compare(switchMove, sideBar.modulSecondLeftSpinner(), sideBar.modulSecondComboBox(), sideBar.modulSecondRightSpinner())) {
                        frst = 1;
                        scnd = 2;
                    }
                    switchMove++;
                }
                if (sideBar.getAlg3()) {
                    switchDiagonal++;
                    switchMove = 0;
                }
            }
        }
    }
}
