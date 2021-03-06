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
package cz.fi.muni.pv097.Gui.SideBars;

import cz.fi.muni.pv097.Canvases.ImageGeneratorPreview;
import cz.fi.muni.pv097.Algorithms.PageRank;

/**
 *
 * @author 410134
 */
public class PageRankSideBar extends javax.swing.JPanel {

    private final ImageGeneratorPreview canvas;
    private final PageRank alg;

    public PageRankSideBar(ImageGeneratorPreview pr, PageRank alg) {
        super();
        initComponents();
        canvas = pr;
        this.alg = alg;
    }

    /**
     *
     * @return current value
     */
    public int getChoiceSpliter() {
        return (int) choiceSpliterSpinner.getValue();
    }

    /**
     *
     * @return current value
     */
    public int getscannerDepth() {
        return (int) scannerDepthSpinner.getValue();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choiceSpliterSpinner = new javax.swing.JSpinner();
        scannerDepthSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(176, 450));
        setMinimumSize(new java.awt.Dimension(176, 450));
        setOpaque(false);
        setLayout(null);

        choiceSpliterSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(1)));
        add(choiceSpliterSpinner);
        choiceSpliterSpinner.setBounds(110, 160, 40, 20);

        scannerDepthSpinner.setModel(new javax.swing.SpinnerNumberModel(4, 0, 4, 1));
        add(scannerDepthSpinner);
        scannerDepthSpinner.setBounds(110, 190, 40, 20);

        jLabel1.setText("Scanner depth :");
        add(jLabel1);
        jLabel1.setBounds(20, 190, 80, 20);

        jLabel2.setText("Choice spliter :");
        add(jLabel2);
        jLabel2.setBounds(20, 160, 80, 20);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner choiceSpliterSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner scannerDepthSpinner;
    // End of variables declaration//GEN-END:variables
}
