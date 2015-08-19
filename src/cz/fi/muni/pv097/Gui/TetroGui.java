package cz.fi.muni.pv097.Gui;

import cz.fi.muni.pv097.CoreComponents.AbstractFiller;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author 410134
 */
public class TetroGui extends javax.swing.JFrame {

    private Image iconImage;
    private Image background;
    private int runningAlgs = 0;

    public TetroGui() {
        AbstractFiller.setTopParent(this);
        this.setLocationByPlatform(true);
        this.loadImages();
        initComponents();
        TetroTab.setBackgroundImage(background);
    }

    /**
     * Sets up progres bar acording calculations
     *
     * @param op state of bar
     */
    public void setProgresBar(boolean op) {
        if (op) {
            runningAlgs++;
        } else if (runningAlgs > 0) {
            runningAlgs--;
        }
        if (runningAlgs > 0 && !this.jProgressBar1.isIndeterminate()) {
            this.jProgressBar1.setIndeterminate(true);
        } else if (runningAlgs == 0 && this.jProgressBar1.isIndeterminate()) {
            this.jProgressBar1.setIndeterminate(false);
        }
    }

    private void loadImages() {
        try {
            this.iconImage = ImageIO.read(this.getClass().getClassLoader().getResource("TetrominoGeneratorIcon.png"));
            this.background = ImageIO.read(this.getClass().getClassLoader().getResource("TetrisTabBackground.png"));
        } catch (IOException ex) {
            System.err.println("File doesnt exist" + ex);
        }
    }

    private int closeDialog() {
        if (this.jTabbedPanel.getTabCount() > 0) {
            if (JOptionPane.showConfirmDialog(this, "Are you sure to quit?", "WARNING Opened Tabs",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                return 1;
            } else {
                return 0;
            }
        }
        return 1;
    }

    private File saveFile(String label, String ext) {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showDialog(this, label);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (!file.getName().endsWith(ext)) {
                file = new File(file + ext);
            }
            if (!file.exists()) {
                return file;
            } else {
                if (JOptionPane.showConfirmDialog(this, "Are you sure to overwrite?", "File Exist",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    return file;
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPanel = new javax.swing.JTabbedPane();
        label1 = new java.awt.Label();
        jProgressBar1 = new javax.swing.JProgressBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jFile = new javax.swing.JMenu();
        jNewFile = new javax.swing.JMenuItem();
        jClose = new javax.swing.JMenuItem();
        jLoadFile = new javax.swing.JMenuItem();
        jSave = new javax.swing.JMenu();
        jSaveFile = new javax.swing.JMenuItem();
        jSaveImage = new javax.swing.JMenuItem();
        jExit = new javax.swing.JMenuItem();
        jHelp = new javax.swing.JMenu();
        jAbout = new javax.swing.JMenuItem();
        jHelpContent = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("TetrominGenerator");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(iconImage);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(950, 630));
        setPreferredSize(new java.awt.Dimension(950, 630));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPanel.setDoubleBuffered(true);
        jTabbedPanel.setMinimumSize(new java.awt.Dimension(950, 556));
        jTabbedPanel.setPreferredSize(new java.awt.Dimension(950, 556));

        label1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        label1.setText("Ready to work");

        jMenuBar1.setBorder(null);
        jMenuBar1.setBorderPainted(false);
        jMenuBar1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jMenuBar1.setDoubleBuffered(true);
        jMenuBar1.setFocusable(false);
        jMenuBar1.setOpaque(false);
        jMenuBar1.setRequestFocusEnabled(false);

        jFile.setText("File");

        jNewFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jNewFile.setText("New Tab");
        jNewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewFileActionPerformed(evt);
            }
        });
        jFile.add(jNewFile);

        jClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jClose.setText("Close Tab");
        jClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCloseActionPerformed(evt);
            }
        });
        jFile.add(jClose);

        jLoadFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jLoadFile.setMnemonic('V');
        jLoadFile.setText("Load File");
        jLoadFile.setToolTipText("");
        jLoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoadFileActionPerformed(evt);
            }
        });
        jFile.add(jLoadFile);

        jSave.setText("Save");

        jSaveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jSaveFile.setText("Save File");
        jSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveFileActionPerformed(evt);
            }
        });
        jSave.add(jSaveFile);

        jSaveImage.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jSaveImage.setText("Save Image");
        jSaveImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveImageActionPerformed(evt);
            }
        });
        jSave.add(jSaveImage);

        jFile.add(jSave);

        jExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jExit.setText("Exit");
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });
        jFile.add(jExit);

        jMenuBar1.add(jFile);

        jHelp.setText("Help");

        jAbout.setText("About");
        jAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAboutActionPerformed(evt);
            }
        });
        jHelp.add(jAbout);

        jHelpContent.setText("Help");
        jHelpContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHelpContentActionPerformed(evt);
            }
        });
        jHelp.add(jHelpContent);

        jMenuBar1.add(jHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        label1.getAccessibleContext().setAccessibleName("actionLabel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAboutActionPerformed
        JOptionPane.showMessageDialog(this, "Creator : Martin Mihálek\nCreated for : PV097\nAt Masaryk's University", "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jAboutActionPerformed

    private void jHelpContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHelpContentActionPerformed
        JOptionPane.showMessageDialog(this, "Program creates algorithmically filled space,\nwith custom generated tetromin shapes.\n"
                + "For usage info see enclosed documentation.", "Help", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jHelpContentActionPerformed

    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        if (this.closeDialog() == 1) {
            System.exit(0);
        }
    }//GEN-LAST:event_jExitActionPerformed

    private void jSaveImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveImageActionPerformed
        if (this.jTabbedPanel.getTabCount() > 0) {
            File outFile = this.saveFile("Save IMAGE", ".png");
            if (outFile != null) {
                try {
                    ((TetroTab) this.jTabbedPanel.getComponentAt(this.jTabbedPanel.getSelectedIndex())).saveImage(outFile, "png");
                } catch (IOException ex) {
                    System.err.println("Error saving tab " + outFile + "\n" + ex);
                }
            }
        }

    }//GEN-LAST:event_jSaveImageActionPerformed

    private void jSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveFileActionPerformed
        if (this.jTabbedPanel.getTabCount() > 0) {
            File outFile = this.saveFile("Save", ".ttr");
            if (outFile != null) {
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outFile))) {
                    out.writeObject(((TetroTab) this.jTabbedPanel.getComponentAt(this.jTabbedPanel.getSelectedIndex())));
                    out.flush();
                    this.label1.setText("File " + outFile.getName() + " saved.");
                } catch (IOException ex) {
                    System.err.println("Error saving tab " + outFile + "\n" + ex);
                }
            }
        }
    }//GEN-LAST:event_jSaveFileActionPerformed

    private void jLoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoadFileActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Tetromin file", new String[]{"ttr", "TTR"}));
        int returnVal = fc.showDialog(this, "Open");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (file.exists()) {
                this.label1.setText("Loading: " + file.getName());
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                    TetroTab tab = (TetroTab) in.readObject();;
                    this.jTabbedPanel.add(file.getName(), tab);
                    this.label1.setText("File " + file.getName() + " loaded.");
                } catch (IOException ex) {
                    System.err.println("Error loading file" + file + "\n" + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("Error loading file corrupted data" + file + "\n" + ex);
                }
            } else {
                this.label1.setText("Open command cancelled by user.");
            }
        }
    }//GEN-LAST:event_jLoadFileActionPerformed

    private void jCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCloseActionPerformed
        if (this.jTabbedPanel.getTabCount() > 0) {
            this.jTabbedPanel.removeTabAt(this.jTabbedPanel.getSelectedIndex());
            this.label1.setText("Tab Removed.");
        }
    }//GEN-LAST:event_jCloseActionPerformed

    private void jNewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewFileActionPerformed
        if (this.jTabbedPanel.getTabCount() < 9) {
            String nameOfTab = JOptionPane.showInputDialog(this, "Name of project: ");
            if (nameOfTab == null || nameOfTab.isEmpty()) {
                this.label1.setText("Cannot create Tab without propriet name.");
                return;
            }
            for (int i = 0; i < this.jTabbedPanel.getComponentCount(); i++) {
                if (this.jTabbedPanel.getComponent(i).getName().equalsIgnoreCase(nameOfTab)) {
                    this.label1.setText("Tab with that name exists.");
                    return;
                }
            }
            Component comp = new TetroTab(nameOfTab);
            this.jTabbedPanel.addTab(comp.getName(), comp);
            this.label1.setText("New tab " + nameOfTab + " added.");
            this.jTabbedPanel.setSelectedIndex(this.jTabbedPanel.getTabCount() - 1);
        }
    }//GEN-LAST:event_jNewFileActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (this.closeDialog() == 1) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TetroGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TetroGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jAbout;
    private javax.swing.JMenuItem jClose;
    private javax.swing.JMenuItem jExit;
    private javax.swing.JMenu jFile;
    private javax.swing.JMenu jHelp;
    private javax.swing.JMenuItem jHelpContent;
    private javax.swing.JMenuItem jLoadFile;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jNewFile;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JMenu jSave;
    private javax.swing.JMenuItem jSaveFile;
    private javax.swing.JMenuItem jSaveImage;
    private javax.swing.JTabbedPane jTabbedPanel;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
