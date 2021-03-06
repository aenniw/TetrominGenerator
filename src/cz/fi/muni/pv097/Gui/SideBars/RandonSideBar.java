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

import cz.fi.muni.pv097.Algorithms.Random;

/**
 *
 * @author 410134
 */
public class RandonSideBar extends javax.swing.JPanel {

    private final Random alg;

    /**
     * Creates side bar which contains setting for algorithm
     *
     * @param gen algorithm
     */
    public RandonSideBar(Random gen) {
        super();
        this.alg = gen;
        initComponents();

    }

    /**
     *
     * @return is algorithm 1 activ
     */
    public boolean getAlg1() {
        return algToggleButton1.isSelected();
    }

    /**
     *
     * @return is algorithm 2 activ
     */
    public boolean getAlg2() {
        return algToggleButton2.isSelected();
    }

    /**
     *
     * @return is algorithm 3 activ
     */
    public boolean getAlg3() {
        return algToggleButton3.isSelected();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        algToggleButton1 = new javax.swing.JToggleButton();
        algToggleButton2 = new javax.swing.JToggleButton();
        algToggleButton3 = new javax.swing.JToggleButton();
        modulFirstLeftSpinner = new javax.swing.JSpinner();
        modulFirstComboBox = new javax.swing.JComboBox();
        modulSecondLeftSpinner = new javax.swing.JSpinner();
        modulFirstRightSpinner = new javax.swing.JSpinner();
        modulSecondRightSpinner = new javax.swing.JSpinner();
        rotateCountSpinner = new javax.swing.JSpinner();
        modulSecondComboBox = new javax.swing.JComboBox();
        modulThirdLeftSpinner = new javax.swing.JSpinner();
        modulThirdComboBox = new javax.swing.JComboBox();
        modulThirdRightSpinner = new javax.swing.JSpinner();
        borderToggleButton2 = new javax.swing.JToggleButton();
        borderToggleButton1 = new javax.swing.JToggleButton();
        modulFourthLeftSpinner = new javax.swing.JSpinner();
        modulFourthComboBox = new javax.swing.JComboBox();
        modulFourthRightSpinner = new javax.swing.JSpinner();
        modulFiftLeftSpinner = new javax.swing.JSpinner();
        modulFiftComboBox = new javax.swing.JComboBox();
        modulFiftRightSpinner = new javax.swing.JSpinner();
        modulSixtLeftSpinner = new javax.swing.JSpinner();
        modulSixtComboBox = new javax.swing.JComboBox();
        modulSixtRightSpinner = new javax.swing.JSpinner();
        diagonalLeftSpinner = new javax.swing.JSpinner();
        diagonalRightSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(176, 450));
        setMinimumSize(new java.awt.Dimension(176, 450));
        setOpaque(false);
        setLayout(null);

        algToggleButton1.setBackground(new java.awt.Color(255, 0, 0));
        algToggleButton1.setSelected(true);
        algToggleButton1.setToolTipText("Algorithm ONE");
        algToggleButton1.setFocusable(false);
        algToggleButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                algToggleButton1ItemStateChanged(evt);
            }
        });
        add(algToggleButton1);
        algToggleButton1.setBounds(130, 0, 20, 150);

        algToggleButton2.setBackground(new java.awt.Color(255, 255, 0));
        algToggleButton2.setToolTipText("Algorithm");
        algToggleButton2.setFocusable(false);
        algToggleButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                algToggleButton2ItemStateChanged(evt);
            }
        });
        add(algToggleButton2);
        algToggleButton2.setBounds(130, 150, 20, 150);

        algToggleButton3.setBackground(new java.awt.Color(0, 204, 0));
        algToggleButton3.setToolTipText("Algorithm");
        algToggleButton3.setFocusable(false);
        algToggleButton3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                algToggleButton3ItemStateChanged(evt);
            }
        });
        add(algToggleButton3);
        algToggleButton3.setBounds(130, 300, 20, 140);

        modulFirstLeftSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulFirstLeftSpinner.setModel(new javax.swing.SpinnerNumberModel(3, 3, 20, 1));
        modulFirstLeftSpinner.setFocusable(false);
        add(modulFirstLeftSpinner);
        modulFirstLeftSpinner.setBounds(10, 60, 38, 20);

        modulFirstComboBox.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulFirstComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "==", "!=", "<", ">" }));
        modulFirstComboBox.setBorder(null);
        modulFirstComboBox.setFocusable(false);
        add(modulFirstComboBox);
        modulFirstComboBox.setBounds(50, 60, 38, 18);

        modulSecondLeftSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulSecondLeftSpinner.setModel(new javax.swing.SpinnerNumberModel(3, 3, 20, 1));
        modulSecondLeftSpinner.setFocusable(false);
        add(modulSecondLeftSpinner);
        modulSecondLeftSpinner.setBounds(10, 100, 38, 20);

        modulFirstRightSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulFirstRightSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        modulFirstRightSpinner.setFocusable(false);
        add(modulFirstRightSpinner);
        modulFirstRightSpinner.setBounds(90, 60, 38, 20);

        modulSecondRightSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulSecondRightSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        modulSecondRightSpinner.setFocusable(false);
        add(modulSecondRightSpinner);
        modulSecondRightSpinner.setBounds(90, 100, 38, 20);

        rotateCountSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        rotateCountSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));
        rotateCountSpinner.setFocusable(false);
        add(rotateCountSpinner);
        rotateCountSpinner.setBounds(40, 20, 60, 20);

        modulSecondComboBox.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulSecondComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "==", "!=", "<", ">" }));
        modulSecondComboBox.setBorder(null);
        modulSecondComboBox.setFocusable(false);
        add(modulSecondComboBox);
        modulSecondComboBox.setBounds(50, 100, 38, 18);

        modulThirdLeftSpinner.setVisible(false);
        modulThirdLeftSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulThirdLeftSpinner.setModel(new javax.swing.SpinnerNumberModel(6, 3, 20, 1));
        modulThirdLeftSpinner.setFocusable(false);
        add(modulThirdLeftSpinner);
        modulThirdLeftSpinner.setBounds(10, 170, 38, 20);

        modulThirdComboBox.setVisible(false);
        modulThirdComboBox.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulThirdComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "==", "!=", "<", ">" }));
        modulThirdComboBox.setBorder(null);
        modulThirdComboBox.setFocusable(false);
        add(modulThirdComboBox);
        modulThirdComboBox.setBounds(50, 170, 38, 18);

        modulThirdRightSpinner.setVisible(false);
        modulThirdRightSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulThirdRightSpinner.setModel(new javax.swing.SpinnerNumberModel(3, 1, 20, 1));
        modulThirdRightSpinner.setFocusable(false);
        add(modulThirdRightSpinner);
        modulThirdRightSpinner.setBounds(90, 170, 38, 20);

        borderToggleButton2.setVisible(false);
        borderToggleButton2.setText("Spin One");
        borderToggleButton2.setFocusable(false);
        add(borderToggleButton2);
        borderToggleButton2.setBounds(10, 210, 110, 23);

        borderToggleButton1.setVisible(false);
        borderToggleButton1.setText("Spin Two");
        borderToggleButton1.setFocusable(false);
        add(borderToggleButton1);
        borderToggleButton1.setBounds(10, 250, 110, 23);

        modulFourthLeftSpinner.setVisible(false);
        modulFourthLeftSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulFourthLeftSpinner.setModel(new javax.swing.SpinnerNumberModel(3, 3, 20, 1));
        modulFourthLeftSpinner.setFocusable(false);
        add(modulFourthLeftSpinner);
        modulFourthLeftSpinner.setBounds(10, 320, 38, 20);

        modulFourthComboBox.setVisible(false);
        modulFourthComboBox.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulFourthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "==", "!=", "<", ">" }));
        modulFourthComboBox.setBorder(null);
        modulFourthComboBox.setFocusable(false);
        add(modulFourthComboBox);
        modulFourthComboBox.setBounds(50, 320, 38, 18);

        modulFourthRightSpinner.setVisible(false);
        modulFourthRightSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulFourthRightSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        modulFourthRightSpinner.setFocusable(false);
        add(modulFourthRightSpinner);
        modulFourthRightSpinner.setBounds(90, 320, 38, 20);

        modulFiftLeftSpinner.setVisible(false);
        modulFiftLeftSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulFiftLeftSpinner.setModel(new javax.swing.SpinnerNumberModel(2, 2, 20, 1));
        modulFiftLeftSpinner.setFocusable(false);
        add(modulFiftLeftSpinner);
        modulFiftLeftSpinner.setBounds(10, 350, 38, 20);

        modulFiftComboBox.setVisible(false);
        modulFiftComboBox.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulFiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "==", "!=", "<", ">" }));
        modulFiftComboBox.setBorder(null);
        modulFiftComboBox.setFocusable(false);
        add(modulFiftComboBox);
        modulFiftComboBox.setBounds(50, 350, 38, 18);

        modulFiftRightSpinner.setVisible(false);
        modulFiftRightSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulFiftRightSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        modulFiftRightSpinner.setFocusable(false);
        add(modulFiftRightSpinner);
        modulFiftRightSpinner.setBounds(90, 350, 38, 20);

        modulSixtLeftSpinner.setVisible(false);
        modulSixtLeftSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulSixtLeftSpinner.setModel(new javax.swing.SpinnerNumberModel(3, 3, 20, 1));
        modulSixtLeftSpinner.setFocusable(false);
        add(modulSixtLeftSpinner);
        modulSixtLeftSpinner.setBounds(10, 380, 38, 20);

        modulSixtComboBox.setVisible(false);
        modulSixtComboBox.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulSixtComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "==", "!=", "<", ">" }));
        modulSixtComboBox.setBorder(null);
        modulSixtComboBox.setFocusable(false);
        add(modulSixtComboBox);
        modulSixtComboBox.setBounds(50, 380, 38, 18);

        modulSixtRightSpinner.setVisible(false);
        modulSixtRightSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        modulSixtRightSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        modulSixtRightSpinner.setFocusable(false);
        add(modulSixtRightSpinner);
        modulSixtRightSpinner.setBounds(90, 380, 38, 20);

        diagonalLeftSpinner.setVisible(false);
        diagonalLeftSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        diagonalLeftSpinner.setModel(new javax.swing.SpinnerNumberModel(2, 1, 20, 1));
        diagonalLeftSpinner.setFocusable(false);
        add(diagonalLeftSpinner);
        diagonalLeftSpinner.setBounds(10, 410, 50, 20);

        diagonalRightSpinner.setVisible(false);
        diagonalRightSpinner.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        diagonalRightSpinner.setModel(new javax.swing.SpinnerNumberModel(2, 1, 20, 1));
        diagonalRightSpinner.setFocusable(false);
        add(diagonalRightSpinner);
        diagonalRightSpinner.setBounds(80, 410, 50, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Settings");
        add(jLabel1);
        jLabel1.setBounds(10, 0, 110, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void algToggleButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_algToggleButton1ItemStateChanged
        if (algToggleButton1.isSelected()) {
            algToggleButton2.setSelected(false);
            algToggleButton3.setSelected(false);
        }
    }//GEN-LAST:event_algToggleButton1ItemStateChanged

    private void algToggleButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_algToggleButton2ItemStateChanged
        if (algToggleButton2.isSelected()) {
            algToggleButton1.setSelected(false);
            algToggleButton3.setSelected(false);
            this.modulThirdComboBox.setVisible(true);
            this.modulThirdLeftSpinner.setVisible(true);
            this.modulThirdRightSpinner.setVisible(true);
            this.borderToggleButton1.setVisible(true);
            this.borderToggleButton2.setVisible(true);

        } else {
            this.modulThirdComboBox.setVisible(false);
            this.modulThirdLeftSpinner.setVisible(false);
            this.modulThirdRightSpinner.setVisible(false);
            this.borderToggleButton1.setVisible(false);
            this.borderToggleButton2.setVisible(false);
        }
        alg.repaintParent();
    }//GEN-LAST:event_algToggleButton2ItemStateChanged

    private void algToggleButton3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_algToggleButton3ItemStateChanged
        if (algToggleButton3.isSelected()) {
            algToggleButton1.setSelected(false);
            algToggleButton2.setSelected(false);
            this.modulThirdComboBox.setVisible(true);
            this.modulThirdLeftSpinner.setVisible(true);
            this.modulThirdRightSpinner.setVisible(true);
            this.borderToggleButton1.setVisible(true);
            this.borderToggleButton2.setVisible(true);
            //tretie
            this.modulFourthComboBox.setVisible(true);
            this.modulFourthLeftSpinner.setVisible(true);
            this.modulFourthRightSpinner.setVisible(true);
            this.modulFiftComboBox.setVisible(true);
            this.modulFiftLeftSpinner.setVisible(true);
            this.modulFiftRightSpinner.setVisible(true);
            this.modulSixtComboBox.setVisible(true);
            this.modulSixtLeftSpinner.setVisible(true);
            this.modulSixtRightSpinner.setVisible(true);
            this.diagonalLeftSpinner.setVisible(true);
            this.diagonalRightSpinner.setVisible(true);
        } else {
            this.modulThirdComboBox.setVisible(false);
            this.modulThirdLeftSpinner.setVisible(false);
            this.modulThirdRightSpinner.setVisible(false);
            this.borderToggleButton1.setVisible(false);
            this.borderToggleButton2.setVisible(false);
            //tretie
            this.modulFourthComboBox.setVisible(false);
            this.modulFourthLeftSpinner.setVisible(false);
            this.modulFourthRightSpinner.setVisible(false);
            this.modulFiftComboBox.setVisible(false);
            this.modulFiftLeftSpinner.setVisible(false);
            this.modulFiftRightSpinner.setVisible(false);
            this.modulSixtComboBox.setVisible(false);
            this.modulSixtLeftSpinner.setVisible(false);
            this.modulSixtRightSpinner.setVisible(false);
            this.diagonalLeftSpinner.setVisible(false);
            this.diagonalRightSpinner.setVisible(false);
        }
        alg.repaintParent();
    }//GEN-LAST:event_algToggleButton3ItemStateChanged

    public int modulFirstLeftSpinner() {
        return (int) this.modulFirstLeftSpinner.getValue();
    }

    public int modulSecondLeftSpinner() {
        return (int) this.modulSecondLeftSpinner.getValue();
    }

    public int modulFirstRightSpinner() {
        return (int) this.modulFirstRightSpinner.getValue();
    }

    public int modulSecondRightSpinner() {
        return (int) this.modulSecondRightSpinner.getValue();
    }

    public int rotateCountSpinner() {
        return (int) this.rotateCountSpinner.getValue();
    }

    public int modulFirstComboBox() {
        return modulFirstComboBox.getSelectedIndex();
    }

    public int modulSecondComboBox() {
        return modulSecondComboBox.getSelectedIndex();
    }

    public int modulThirdLeftSpinner() {
        return (int) this.modulThirdLeftSpinner.getValue();
    }

    public int modulThirdRightSpinner() {
        return (int) this.modulThirdRightSpinner.getValue();
    }

    public int modulThirdComboBox() {
        return modulThirdComboBox.getSelectedIndex();
    }

    public boolean borderToggleButton1() {
        return !borderToggleButton1.isSelected();
    }

    public boolean borderToggleButton2() {
        return !borderToggleButton2.isSelected();
    }

    public int modulFourthLeftSpinner() {
        return (int) this.modulFourthLeftSpinner.getValue();
    }

    public int modulFourthRightSpinner() {
        return (int) this.modulFourthRightSpinner.getValue();
    }

    public int modulFourthComboBox() {
        return modulFourthComboBox.getSelectedIndex();
    }

    public int modulFiftLeftSpinner() {
        return (int) this.modulFiftLeftSpinner.getValue();
    }

    public int modulFiftRightSpinner() {
        return (int) this.modulFiftRightSpinner.getValue();
    }

    public int modulFiftComboBox() {
        return modulFiftComboBox.getSelectedIndex();
    }

    public int modulSixtLeftSpinner() {
        return (int) this.modulSixtLeftSpinner.getValue();
    }

    public int modulSixtRightSpinner() {
        return (int) this.modulSixtRightSpinner.getValue();
    }

    public int modulSixtComboBox() {
        return modulSixtComboBox.getSelectedIndex();
    }

    public int diagonalLeftSpinner() {
        return (int) this.diagonalLeftSpinner.getValue();
    }

    public int diagonalRightSpinner() {
        return (int) this.diagonalRightSpinner.getValue();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton algToggleButton1;
    private javax.swing.JToggleButton algToggleButton2;
    private javax.swing.JToggleButton algToggleButton3;
    private javax.swing.JToggleButton borderToggleButton1;
    private javax.swing.JToggleButton borderToggleButton2;
    private javax.swing.JSpinner diagonalLeftSpinner;
    private javax.swing.JSpinner diagonalRightSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox modulFiftComboBox;
    private javax.swing.JSpinner modulFiftLeftSpinner;
    private javax.swing.JSpinner modulFiftRightSpinner;
    private javax.swing.JComboBox modulFirstComboBox;
    private javax.swing.JSpinner modulFirstLeftSpinner;
    private javax.swing.JSpinner modulFirstRightSpinner;
    private javax.swing.JComboBox modulFourthComboBox;
    private javax.swing.JSpinner modulFourthLeftSpinner;
    private javax.swing.JSpinner modulFourthRightSpinner;
    private javax.swing.JComboBox modulSecondComboBox;
    private javax.swing.JSpinner modulSecondLeftSpinner;
    private javax.swing.JSpinner modulSecondRightSpinner;
    private javax.swing.JComboBox modulSixtComboBox;
    private javax.swing.JSpinner modulSixtLeftSpinner;
    private javax.swing.JSpinner modulSixtRightSpinner;
    private javax.swing.JComboBox modulThirdComboBox;
    private javax.swing.JSpinner modulThirdLeftSpinner;
    private javax.swing.JSpinner modulThirdRightSpinner;
    private javax.swing.JSpinner rotateCountSpinner;
    // End of variables declaration//GEN-END:variables
}
