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
import cz.fi.muni.pv097.Gui.SideBars.PageRankSideBar;
import cz.fi.muni.pv097.Gui.TetroTab;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.JPanel;

/**
 *
 * @author 410134
 */
public class PageRank extends AbstractFiller {

    private final PageRankSideBar sideBar;
    private int layout[], stepX = -1, rRotation = 0, lRotation = 0;
    private boolean inicialized = false;

    /**
     * Create algorithm acording page rang algorithm
     *
     * @param can canvas
     * @param pa tab
     */
    public PageRank(ImageGeneratorPreview can, TetroTab pa) {
        super(can, pa, "Page Rank");
        sideBar = new PageRankSideBar(can, this);
        layout = setDefaultLayout();
    }

    private int[] setDefaultLayout() {
        return new int[canvas.getBoundsRectangle().width / canvas.getPartSize()];
    }

    @Override
    public JPanel getSideBar() {
        return sideBar;
    }

    @Override
    public void formKeyPressed(KeyEvent evt) {
    }

    @Override
    public void compute() {
        if (timer.isRunning()) {
            stop();
            inicialized = false;
        } else {
            layout = setDefaultLayout();
            timer.start();
            topParent.setProgresBar(true);
        }
    }

    private int[] getDisCount(int off, int part[]) {
        int hlp[] = new int[part.length];
        for (int c = 0; c < part.length; c++) {
            if (off + c < layout.length) {
                hlp[c] = layout[off + c] - part[c];
            }
        }
        return hlp;
    }

    private int getMax(int l[]) {
        int hlp = 0;
        for (int in : l) {
            hlp = Math.max(hlp, in);
        }
        return hlp;
    }

    private int[] getVolume(int max, int invP[], int p[], boolean parcial) {
        int hlp[] = new int[invP.length];
        if (!parcial) {
            for (int c = 0; c < invP.length; c++) {
                hlp[c] = max - invP[c] - p[c];
            }
        } else {
            for (int c = 0; c < invP.length; c++) {
                hlp[c] = max - invP[c];
            }
        }
        return hlp;
    }

    private int filled(int disC[]) {
        int result = 0;
        SortedSet<Integer> h = new TreeSet<>();
        for (int c = 0; c < disC.length; c++) {
            if (c == 0) {
                result++;
            } else if (disC[c - 1] == disC[c]) {
                result++;
            } else {
                result = 1;
                h.add(result);
            }
        }
        h.add(result);
        return h.first() - disC.length;
    }

    /**
     * Create plan of filling
     */
    public void scanner() {
        ArrayList<TreeMap<Integer, Integer>> direction = new ArrayList<>();
        for (int cc = 0; cc < sideBar.getscannerDepth(); cc++) {
            direction.add(new TreeMap<Integer, Integer>(Collections.reverseOrder()));
            for (int c = 0; c <= (canvas.getBoundsRectangle().width - canvas.getAtivePart().getWidth()) / canvas.getPartSize(); c++) {
                direction.get(cc).put(c, filled(getDisCount(c, canvas.getAtivePart().getRanks()[cc])));
            }
            canvas.rotateRight();
        }
        int[] maxDirection = new int[4];
        ArrayList<ArrayList<Integer>> keys = new ArrayList<>();
        for (int cc = 0; cc < sideBar.getscannerDepth(); cc++) {
            keys.add(new ArrayList<Integer>());
            boolean bigest = false;
            for (int c = 0; !bigest && c > -canvas.getAtivePart().getWidth() / canvas.getPartSize(); c--) {
                for (Entry<Integer, Integer> m : direction.get(cc).entrySet()) {
                    if (c == m.getValue()) {
                        keys.get(cc).add(m.getKey());
                        maxDirection[cc] = c;
                        bigest = true;
                    }
                }
            }
            canvas.rotateRight();
        }
        int max = Integer.MIN_VALUE;
        for (int c : maxDirection) {
            max = Math.max(max, c);
        }
        int keyDirection = 0, key = 0, value = Integer.MAX_VALUE;
        if (max == sideBar.getChoiceSpliter()) {
            for (int cc = 0; cc < sideBar.getscannerDepth(); cc++) {
                if (max == maxDirection[cc]) {
                    for (int c : keys.get(cc)) {
                        if (value > layout[c]) {
                            keyDirection = cc;
                            key = c;
                            value = layout[key];
                        }
                    }
                }
            }
        } else {
            for (int cc = 0; cc < sideBar.getscannerDepth(); cc++) {
                for (int c : keys.get(cc)) {
                    if (value > layout[c]) {
                        keyDirection = cc;
                        key = c;
                        value = layout[key];
                    }
                }
            }
        }
        switch (keyDirection) {
            case 1:
                rRotation = 1;
                break;
            case 2:
                rRotation = 2;
                break;
            case 3:
                lRotation = 1;
                break;
        }
        stepX = key;
    }

    private void addPart(int off) {
        int disC[] = getDisCount(off, canvas.getAtivePart().getRank());
        int max = getMax(disC);
        int maxSize = canvas.getAtivePart().getHeight() / canvas.getPartSize();
        int volumeTotal[] = getVolume(maxSize, canvas.getAtivePart().getInverseRank(), canvas.getAtivePart().getRank(), false);
        int volumeParcial[] = getVolume(maxSize, canvas.getAtivePart().getInverseRank(), canvas.getAtivePart().getRank(), true);
        for (int c = 0; c < disC.length; c++) {
            if (max == disC[c]) {
                layout[off + c] = layout[off + c] + volumeTotal[c];
            } else {
                layout[off + c] = layout[off + c] + volumeParcial[c] + (max - layout[off + c]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (rRotation > 0) {
            canvas.rotateRight();
            rRotation--;
        } else if (lRotation > 0) {
            canvas.rotateLeft();
            lRotation--;
        } else if (stepX > 0) {
            canvas.move(1);
            stepX--;
        } else if (!canvas.move(2)) {
            if (inicialized) {
                addPart(canvas.getAtivePart().getX() / canvas.getPartSize());
            }
            if (!canvas.addPart()) {
                stop();
                inicialized = false;
            } else {
                inicialized = true;
                scanner();
            }
        }
        canvas.repaint();
    }

}
