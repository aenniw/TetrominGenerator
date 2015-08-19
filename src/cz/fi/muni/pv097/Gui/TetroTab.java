package cz.fi.muni.pv097.Gui;

import cz.fi.muni.pv097.Canvases.ObjectGallery;
import cz.fi.muni.pv097.Canvases.Listeners.TetroTabKeyStrokes;
import cz.fi.muni.pv097.Canvases.ObjectCreator;
import cz.fi.muni.pv097.Canvases.ImageGeneratorPreview;
import cz.fi.muni.pv097.CoreComponents.AbstractFiller;
import cz.fi.muni.pv097.Algorithms.Manual;
import cz.fi.muni.pv097.Algorithms.PageRank;
import cz.fi.muni.pv097.Algorithms.Random;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.InputMap;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.KeyStroke;

/**
 *
 * @author 410134
 */
public class TetroTab extends JPanel {

    private Point lastClick;
    private static Image background;
    private final HashMap<String, AbstractFiller> fillers;
    private String activFiller = "Manual";

    public TetroTab(String name) {
        this.fillers = new HashMap<>();
        super.setName(name);
        initComponents();
        this.initFillers();
        this.cardLayoutInit();
        this.setKeyStrokes();
    }

    private void initFillers() {
        AbstractFiller manual = new Manual((ImageGeneratorPreview) this.preview, this);
        AbstractFiller random = new Random((ImageGeneratorPreview) this.preview, this);
        AbstractFiller pageRank = new PageRank((ImageGeneratorPreview) this.preview, this);
        fillers.put(manual.getName(), manual);
        fillers.put(random.getName(), random);
        fillers.put(pageRank.getName(), pageRank);

    }

    private void cardLayoutInit() {
        for (AbstractFiller f : this.fillers.values()) {
            sideBar.add(f.getSideBar(), f.getName());
        }
        ((CardLayout) sideBar.getLayout()).show(sideBar, activFiller);
        this.FillingAlgorithmComboBox.setSelectedItem(activFiller);
    }

    private void setKeyStrokes() {
        InputMap inputMap = this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "LEFT");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "RIGHT");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "UP");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "DOWN");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_CONTROL, 0, true), "CTRL");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SHIFT, 0, true), "SHIFT");
        this.getActionMap().put("LEFT", new TetroTabKeyStrokes(this, KeyEvent.VK_LEFT));
        this.getActionMap().put("RIGHT", new TetroTabKeyStrokes(this, KeyEvent.VK_RIGHT));
        this.getActionMap().put("UP", new TetroTabKeyStrokes(this, KeyEvent.VK_UP));
        this.getActionMap().put("DOWN", new TetroTabKeyStrokes(this, KeyEvent.VK_DOWN));
        this.getActionMap().put("CTRL", new TetroTabKeyStrokes(this, KeyEvent.VK_CONTROL));
        this.getActionMap().put("SHIFT", new TetroTabKeyStrokes(this, KeyEvent.VK_SHIFT));
    }

    /**
     * Gets selected algorithm
     *
     * @return algorithm
     */
    public AbstractFiller getAlgorithm() {
        return fillers.get(activFiller);
    }

    /**
     * Sets bakground image of Tab
     *
     * @param back image
     */
    public static void setBackgroundImage(Image back) {
        TetroTab.background = back;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        grphcs.drawImage(background, 0, 0, this);
        super.paintComponent(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preview = new cz.fi.muni.pv097.Canvases.ImageGeneratorPreview();
        ObjectCreator = new ObjectCreator();
        statusLabel = new javax.swing.JLabel();
        InnerColorButton = new javax.swing.JButton();
        borderColorButton = new javax.swing.JButton();
        resetObjectCreatorButton = new javax.swing.JButton();
        addObjectButton = new javax.swing.JButton();
        gallery = new cz.fi.muni.pv097.Canvases.ObjectGallery();
        previevObjectSlider = new javax.swing.JSlider();
        editObjectButton = new javax.swing.JButton();
        removeObjectButton = new javax.swing.JButton();
        generatePreviewButton = new javax.swing.JButton();
        generatorSpeedSlider = new javax.swing.JSlider();
        FillingAlgorithmComboBox = new javax.swing.JComboBox();
        borderSizeSpinner = new javax.swing.JSpinner();
        tetrominSquarePreview = new SquarePreview();
        resolutionChangerComboBox = new javax.swing.JComboBox();
        BackgroundColorButton = new javax.swing.JButton();
        fillingjLabel = new javax.swing.JLabel();
        ressolutionjLabel = new javax.swing.JLabel();
        sideBar = new JPanel(new CardLayout());
        partSizejSpinner = new javax.swing.JSpinner();
        jCheckBox1 = new javax.swing.JCheckBox();

        setBackground(new Color(0,0,0,0));
        setMinimumSize(new java.awt.Dimension(950, 556));
        setPreferredSize(new java.awt.Dimension(950, 556));
        setLayout(null);

        preview.setBackground(new java.awt.Color(255, 255, 255));
        preview.setMinimumSize(new java.awt.Dimension(425, 450));
        preview.setPreferredSize(new java.awt.Dimension(425, 450));
        preview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                previewMousePressed(evt);
            }
        });
        preview.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                previewMouseDragged(evt);
            }
        });
        preview.setLayout(null);
        add(preview);
        preview.setBounds(354, 45, 425, 450);

        ObjectCreator.setBackground(new java.awt.Color(255, 255, 255));
        ObjectCreator.setMinimumSize(new java.awt.Dimension(150, 200));
        ObjectCreator.setOpaque(false);
        ObjectCreator.setPreferredSize(new java.awt.Dimension(150, 225));
        ObjectCreator.setLayout(null);
        add(ObjectCreator);
        ObjectCreator.setBounds(91, 34, 150, 225);

        statusLabel.setBackground(new Color(255,255,255,125));
        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        statusLabel.setText("Create parts of tetromino. ");
        statusLabel.setOpaque(true);
        add(statusLabel);
        statusLabel.setBounds(24, 8, 320, 14);

        InnerColorButton.setText("Inner Color");
        InnerColorButton.setToolTipText("Sets color of square.");
        InnerColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InnerColorButtonActionPerformed(evt);
            }
        });
        add(InnerColorButton);
        InnerColorButton.setBounds(247, 34, 95, 23);

        borderColorButton.setText("Outer Color");
        borderColorButton.setToolTipText("Sets color of border.");
        borderColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borderColorButtonActionPerformed(evt);
            }
        });
        add(borderColorButton);
        borderColorButton.setBounds(247, 75, 95, 23);

        resetObjectCreatorButton.setText("Reset");
        resetObjectCreatorButton.setToolTipText("Sets creation board to default.");
        resetObjectCreatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetObjectCreatorButtonActionPerformed(evt);
            }
        });
        add(resetObjectCreatorButton);
        resetObjectCreatorButton.setBounds(24, 34, 63, 23);

        addObjectButton.setText("Add");
        addObjectButton.setToolTipText("Adds object to gallery.\\n(object must be solid)");
        addObjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addObjectButtonActionPerformed(evt);
            }
        });
        add(addObjectButton);
        addObjectButton.setBounds(101, 270, 130, 23);

        gallery.setBackground(new Color(0,0,0,125));
        gallery.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gallery.setMinimumSize(new java.awt.Dimension(300, 200));
        gallery.setLayout(null);
        add(gallery);
        gallery.setBounds(24, 301, 300, 200);

        previevObjectSlider.setMaximum(0);
        previevObjectSlider.setToolTipText("Select object.");
        previevObjectSlider.setDoubleBuffered(true);
        previevObjectSlider.setOpaque(false);
        previevObjectSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                previevObjectSliderStateChanged(evt);
            }
        });
        add(previevObjectSlider);
        previevObjectSlider.setBounds(103, 508, 163, 24);

        editObjectButton.setText("Edit");
        editObjectButton.setToolTipText("Reedit selected object.");
        editObjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editObjectButtonActionPerformed(evt);
            }
        });
        add(editObjectButton);
        editObjectButton.setBounds(272, 508, 53, 23);

        removeObjectButton.setText("Remove");
        removeObjectButton.setToolTipText("Delete selected object.");
        removeObjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeObjectButtonActionPerformed(evt);
            }
        });
        add(removeObjectButton);
        removeObjectButton.setBounds(24, 508, 73, 23);

        generatePreviewButton.setText("Generate");
        generatePreviewButton.setToolTipText("Start generation of image.");
        generatePreviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatePreviewButtonActionPerformed(evt);
            }
        });
        add(generatePreviewButton);
        generatePreviewButton.setBounds(690, 500, 86, 23);

        generatorSpeedSlider.setMaximum(500);
        generatorSpeedSlider.setToolTipText("Speed of generating.");
        generatorSpeedSlider.setValue(250);
        generatorSpeedSlider.setOpaque(false);
        generatorSpeedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                generatorSpeedSliderStateChanged(evt);
            }
        });
        add(generatorSpeedSlider);
        generatorSpeedSlider.setBounds(480, 500, 200, 24);

        FillingAlgorithmComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manual", "Random", "Page Rank" }));
        FillingAlgorithmComboBox.setToolTipText("Change generation method.");
        FillingAlgorithmComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FillingAlgorithmComboBoxItemStateChanged(evt);
            }
        });
        add(FillingAlgorithmComboBox);
        FillingAlgorithmComboBox.setBounds(645, 6, 128, 22);

        borderSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(2, 0, 12, 1));
        borderSizeSpinner.setToolTipText("Change size of square border.");
        borderSizeSpinner.setDoubleBuffered(true);
        borderSizeSpinner.setMinimumSize(new java.awt.Dimension(25, 25));
        borderSizeSpinner.setPreferredSize(new java.awt.Dimension(25, 25));
        borderSizeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                borderSizeSpinnerStateChanged(evt);
            }
        });
        add(borderSizeSpinner);
        borderSizeSpinner.setBounds(300, 116, 38, 25);

        tetrominSquarePreview.setBackground(new Color(0,0,0,0));
        tetrominSquarePreview.setMaximumSize(new java.awt.Dimension(35, 35));
        tetrominSquarePreview.setMinimumSize(new java.awt.Dimension(15, 15));
        tetrominSquarePreview.setOpaque(false);
        tetrominSquarePreview.setPreferredSize(new java.awt.Dimension(35, 35));
        tetrominSquarePreview.setLayout(null);
        add(tetrominSquarePreview);
        tetrominSquarePreview.setBounds(259, 116, 35, 35);

        resolutionChangerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "425×450", "640×480", "800×600", "1024×600", "1024×768", "1152×864", "1280×720", "1280×768", "1280×800", "1280×960", "1280×1024", "1360×768", "1366×768", "1400×1050", "1440×900", "1600×900", "1600×1200", "1680×1050", "1920×1080", "1920×1200", "2048×1152", "2560×1440", "2560×1600" }));
        resolutionChangerComboBox.setToolTipText("Change resolution of image.");
        resolutionChangerComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                resolutionChangerComboBoxItemStateChanged(evt);
            }
        });
        add(resolutionChangerComboBox);
        resolutionChangerComboBox.setBounds(433, 6, 101, 22);

        BackgroundColorButton.setText("Background Color");
        BackgroundColorButton.setToolTipText("Sets background color of image.");
        BackgroundColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackgroundColorButtonActionPerformed(evt);
            }
        });
        add(BackgroundColorButton);
        BackgroundColorButton.setBounds(360, 500, 119, 23);

        fillingjLabel.setBackground(new Color(255,255,255,125));
        fillingjLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        fillingjLabel.setText("Filling :");
        fillingjLabel.setOpaque(true);
        add(fillingjLabel);
        fillingjLabel.setBounds(597, 8, 38, 16);

        ressolutionjLabel.setBackground(new Color(255,255,255,125));
        ressolutionjLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        ressolutionjLabel.setText("Resolution :");
        ressolutionjLabel.setOpaque(true);
        add(ressolutionjLabel);
        ressolutionjLabel.setBounds(363, 8, 66, 16);

        sideBar.setBackground(new Color(0,0,0,75));
        sideBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        sideBar.setMaximumSize(new java.awt.Dimension(176, 450));
        sideBar.setMinimumSize(new java.awt.Dimension(176, 450));
        add(sideBar);
        sideBar.setBounds(787, 45, 157, 450);

        partSizejSpinner.setModel(new javax.swing.SpinnerNumberModel(25, 15, 35, 1));
        partSizejSpinner.setToolTipText("Changes size of square.");
        partSizejSpinner.setMinimumSize(new java.awt.Dimension(25, 25));
        partSizejSpinner.setOpaque(false);
        partSizejSpinner.setPreferredSize(new java.awt.Dimension(25, 25));
        partSizejSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                partSizejSpinnerStateChanged(evt);
            }
        });
        add(partSizejSpinner);
        partSizejSpinner.setBounds(37, 68, 36, 25);

        jCheckBox1.setBackground(new Color(0,0,0,0));
        jCheckBox1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Draw generation");
        jCheckBox1.setToolTipText("Show generation proces ?");
        jCheckBox1.setFocusable(false);
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        add(jCheckBox1);
        jCheckBox1.setBounds(810, 500, 119, 25);

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void InnerColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InnerColorButtonActionPerformed
        Color getColor = JColorChooser.showDialog(ObjectCreator, "Choose color.", Color.black);
        if (getColor != null) {
            ((ObjectCreator) this.ObjectCreator).changeColorOfSquare(getColor, null);
            ((SquarePreview) this.tetrominSquarePreview).setColor(getColor, null);
            this.tetrominSquarePreview.repaint();
        }
    }//GEN-LAST:event_InnerColorButtonActionPerformed

    private void borderColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borderColorButtonActionPerformed
        Color getColor = JColorChooser.showDialog(ObjectCreator, "Choose color.", Color.black);
        ((ObjectCreator) this.ObjectCreator).changeColorOfSquare(null, getColor);
        ((SquarePreview) this.tetrominSquarePreview).setColor(null, getColor);
        this.tetrominSquarePreview.repaint();
    }//GEN-LAST:event_borderColorButtonActionPerformed

    private void resetObjectCreatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetObjectCreatorButtonActionPerformed
        ((ObjectCreator) this.ObjectCreator).resetColor();
        setStatusLabel("Editor cleared");
    }//GEN-LAST:event_resetObjectCreatorButtonActionPerformed

    private void addObjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addObjectButtonActionPerformed
        if (((ObjectCreator) this.ObjectCreator).testConection()) {
            //send to gallery
            ((ObjectGallery) this.gallery).addObject(((ObjectCreator) this.ObjectCreator).getObject());
            ((ObjectCreator) this.ObjectCreator).resetColor();
            this.editGalery();
            setStatusLabel("Object added to gallery.");
        } else {
            setStatusLabel("Object cannot be added.");
        }
    }//GEN-LAST:event_addObjectButtonActionPerformed

    private void editObjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editObjectButtonActionPerformed
        ((ObjectCreator) this.ObjectCreator).setBoard(((ObjectGallery) this.gallery).getObject());
        this.editGalery();
        setStatusLabel("Part removed for editing.");
    }//GEN-LAST:event_editObjectButtonActionPerformed

    private void removeObjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeObjectButtonActionPerformed
        ((ObjectGallery) this.gallery).getObject();
        this.editGalery();
        setStatusLabel("Object removed from gallery.");
    }//GEN-LAST:event_removeObjectButtonActionPerformed

    private void editGalery() {
        if (((ObjectGallery) this.gallery).gallerySize() > 1) {
            this.previevObjectSlider.setMaximum(((ObjectGallery) this.gallery).gallerySize() - 1);
            this.previevObjectSlider.setValue(((ObjectGallery) this.gallery).getSelectedIndex());
        } else {
            this.previevObjectSlider.setMaximum(0);
            this.previevObjectSlider.setValue(0);
        }
    }

    private void generatePreviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePreviewButtonActionPerformed
        if (((ObjectGallery) this.gallery).gallerySize() > 0) {
            ((ImageGeneratorPreview) this.preview).addParts(((ObjectGallery) this.gallery).exportGallery());
            this.fillers.get(activFiller).compute();
            setStatusLabel("Generating.");
        }

    }//GEN-LAST:event_generatePreviewButtonActionPerformed

    private void previevObjectSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_previevObjectSliderStateChanged
        JSlider source = (JSlider) evt.getSource();
        if (source.getValueIsAdjusting()) {
            ((ObjectGallery) this.gallery).setSelectedIndex(this.previevObjectSlider.getValue());
            this.repaint();
        }
    }//GEN-LAST:event_previevObjectSliderStateChanged

    private void borderSizeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_borderSizeSpinnerStateChanged
        this.setBorders();
        setStatusLabel("Border set to : " + (int) this.borderSizeSpinner.getValue() + ".");
    }//GEN-LAST:event_borderSizeSpinnerStateChanged

    private void resolutionChangerComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_resolutionChangerComboBoxItemStateChanged
        String[] parse = evt.getItem().toString().split("×");
        ((ImageGeneratorPreview) this.preview).setSizeBounds(Integer.parseInt(parse[0]), Integer.parseInt(parse[1]));
    }//GEN-LAST:event_resolutionChangerComboBoxItemStateChanged

    private void previewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previewMousePressed
        this.lastClick = evt.getPoint();
    }//GEN-LAST:event_previewMousePressed

    private void previewMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previewMouseDragged
        ((ImageGeneratorPreview) this.preview).changeOff(-this.lastClick.x + evt.getPoint().x, -this.lastClick.y + evt.getPoint().y, 2);
    }//GEN-LAST:event_previewMouseDragged

    private void BackgroundColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackgroundColorButtonActionPerformed
        Color getColor = JColorChooser.showDialog(ObjectCreator, "Choose color.", Color.black);
        if (getColor != null) {
            ((ImageGeneratorPreview) this.preview).setBackground(getColor);
            setStatusLabel("Backgorund color of image changed.");
        }
    }//GEN-LAST:event_BackgroundColorButtonActionPerformed

    private void FillingAlgorithmComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FillingAlgorithmComboBoxItemStateChanged
        if (!activFiller.equals(evt.getItem().toString())) {
            this.fillers.get(activFiller).stop();
            activFiller = evt.getItem().toString();
            ((CardLayout) this.sideBar.getLayout()).show(sideBar, activFiller);
            this.fillers.get(activFiller).setDelay(this.generatorSpeedSlider.getValue());
            setStatusLabel("Algorithm changed to " + activFiller + ".");
        }
    }//GEN-LAST:event_FillingAlgorithmComboBoxItemStateChanged

    private void partSizejSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_partSizejSpinnerStateChanged
        if ((int) this.partSizejSpinner.getValue() % 2 == 1) {
            this.borderSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(2, 0, (int) this.partSizejSpinner.getValue() / 2, 1));
        } else {
            this.borderSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(2, 0, ((int) this.partSizejSpinner.getValue() / 2) - 1, 1));
        }
        this.setBorders();
        ((SquarePreview) this.tetrominSquarePreview).setSize((int) this.partSizejSpinner.getValue());
        ((ObjectGallery) this.gallery).setPartSize(((ObjectCreator) this.ObjectCreator).setPartSize((int) this.partSizejSpinner.getValue()));
        ((ImageGeneratorPreview) this.preview).changePartSize((int) this.partSizejSpinner.getValue());
        ((ImageGeneratorPreview) this.preview).addParts(null);
        setStatusLabel("Size set to : " + (int) this.partSizejSpinner.getValue() + ".");

    }//GEN-LAST:event_partSizejSpinnerStateChanged

    private void generatorSpeedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_generatorSpeedSliderStateChanged
        if (this.generatorSpeedSlider.getValueIsAdjusting()) {
            this.fillers.get(activFiller).setDelay(this.generatorSpeedSlider.getValue());
        }
    }//GEN-LAST:event_generatorSpeedSliderStateChanged

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        ((ImageGeneratorPreview) this.preview).setPaint(this.jCheckBox1.isSelected());
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void setStatusLabel(String text) {
        this.statusLabel.setText(text);
        this.repaint();
    }

    private void setBorders() {
        ((ObjectCreator) this.ObjectCreator).setBorder((int) this.borderSizeSpinner.getValue());
        ((SquarePreview) this.tetrominSquarePreview).setBorderOfSquare((int) this.borderSizeSpinner.getValue());
    }

    /**
     * Save image generated by algorithm
     *
     * @param f file where to save
     * @param ext extension of file
     * @throws IOException
     */
    public void saveImage(File f, String ext) throws IOException {
        ((ImageGeneratorPreview) this.preview).save(f, ext);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackgroundColorButton;
    private javax.swing.JComboBox FillingAlgorithmComboBox;
    private javax.swing.JButton InnerColorButton;
    private javax.swing.JPanel ObjectCreator;
    private javax.swing.JButton addObjectButton;
    private javax.swing.JButton borderColorButton;
    private javax.swing.JSpinner borderSizeSpinner;
    private javax.swing.JButton editObjectButton;
    private javax.swing.JLabel fillingjLabel;
    private javax.swing.JPanel gallery;
    private javax.swing.JButton generatePreviewButton;
    private javax.swing.JSlider generatorSpeedSlider;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JSpinner partSizejSpinner;
    private javax.swing.JSlider previevObjectSlider;
    private javax.swing.JPanel preview;
    private javax.swing.JButton removeObjectButton;
    private javax.swing.JButton resetObjectCreatorButton;
    private javax.swing.JComboBox resolutionChangerComboBox;
    private javax.swing.JLabel ressolutionjLabel;
    private javax.swing.JPanel sideBar;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel tetrominSquarePreview;
    // End of variables declaration//GEN-END:variables
}
