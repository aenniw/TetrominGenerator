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

import cz.fi.muni.pv097.CoreComponents.TetroPart;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author 410134
 */
public class ImageGeneratorPreview extends JPanel {

    private final HashSet<TetroPart> pallete;
    private final ArrayList<TetroPart> parts;
    private final Rectangle bounds;
    private boolean paint = true;
    private int offX = 0, offY = 0, borderOffX = 0, borderOffY = 0, partSize = 25;

    /**
     * Creates Canvas for genarated image
     */
    public ImageGeneratorPreview() {
        super();
        parts = new ArrayList<>();
        pallete = new HashSet<>();
        this.setSize(425, 450);
        bounds = new Rectangle(-1, -1, this.getWidth() + 1, this.getHeight() + 2);
        this.computeOffSite();
    }

    /**
     *
     * @return bound of created image
     */
    public Rectangle getBoundsRectangle() {
        return bounds;
    }

    /**
     *
     * @return last added part
     */
    public TetroPart getAtivePart() {
        return parts.get(parts.size() - 1);
    }

    /**
     *
     * @return size of TetrominSquare object
     */
    public int getPartSize() {
        return partSize;
    }

    /**
     * Sets size of square
     *
     * @param i size
     */
    public void changePartSize(int i) {
        this.partSize = i;
        this.computeOffSite();
    }

    private void computeOffSite() {
        this.borderOffX = ((this.bounds.width - 1) % partSize) / 2;
        this.borderOffY = ((this.bounds.height - 2) % partSize) / 2;
    }

    /**
     * Sets resolution of generated image
     *
     * @param i width
     * @param i1 height
     */
    public void setSizeBounds(int i, int i1) {
        if ((i != bounds.width) && (i1 != bounds.height)) {
            bounds.setSize(i + 1, i1 + 2);
            this.computeOffSite();
            this.parts.clear();
            this.repaint();
        }
    }

    /**
     * Sets offsites for changing view of generated image
     *
     * @param xOff offsite of x coordinate
     * @param yOff offsite of y coordinate
     * @param resize value
     */
    public void changeOff(int xOff, int yOff, int resize) {
        if (offX + xOff / resize <= 0) {
            if (offX + xOff / resize > this.getWidth() - (this.bounds.width - 1)) {
                this.offX = offX + xOff / resize;
            } else {
                this.offX = this.getWidth() - this.bounds.width + 1;
            }
        } else {
            this.offX = 0;
        }
        if (offY + yOff / resize <= 0) {
            if (offY + yOff / resize > this.getHeight() - (this.bounds.height - 2)) {
                this.offY = offY + yOff / resize;
            } else {
                this.offY = this.getHeight() - this.bounds.height + 2;
            }
        } else {
            this.offY = 0;
        }
        this.repaint();
    }

    /**
     *
     * @param f file where to save
     * @param ext extension of file
     * @throws IOException
     */
    public void save(File f, String ext) throws IOException {
        BufferedImage bi = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_ARGB);
        Graphics ig2 = bi.createGraphics();
        ig2.setColor(this.getBackground());
        ig2.fillRect(0, 0, bounds.width, bounds.height);
        for (TetroPart part : this.parts) {
            part.paint(ig2, 1, 0, 0);
        }
        ImageIO.write(bi, ext, f);
    }

    /**
     * Add randon part from pallete of parts
     *
     * @return if part was added
     */
    public boolean addPart() {
        if (!this.pallete.isEmpty()) {
            Random out = new Random(System.nanoTime());
            TetroPart in = ((TetroPart) this.pallete.toArray()[Math.abs(out.nextInt() % this.pallete.size())]).copy();
            boolean add = !this.rotateAndColision(in);
            for (int i = 0; i < 3; i++) {
                if (add) {
                    in.setPos(this.borderOffX, this.borderOffY);
                    this.parts.add(in);
                    this.offX = this.borderOffX;
                    this.offY = this.borderOffY;
                    return true;
                } else {
                    add = !this.rotateAndColision(in);
                }
            }
            return this.addPartAll();
        }
        return false;
    }

    private boolean addPartAll() {
        for (TetroPart in : this.pallete) {
            boolean add = !this.rotateAndColision(in);
            for (int i = 0; i < 3; i++) {
                if (add) {
                    this.parts.add(in);
                    this.offX = 0;
                    this.offY = 0;
                    return true;
                } else {
                    add = !this.rotateAndColision(in);
                }
            }
        }
        return false;
    }

    private boolean rotateAndColision(TetroPart p) {
        for (TetroPart prt : this.parts) {
            if (prt.colision(p)) {
                p.rotateLeft();
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return have any part
     */
    public boolean empty() {
        return this.pallete.isEmpty();
    }

    /**
     * Adds new part to palete of parts
     *
     * @param parts to be added
     */
    public void addParts(ArrayList<TetroPart> parts) {
        this.pallete.clear();
        this.parts.clear();
        if (parts != null) {
            this.pallete.addAll(parts);
        }
    }

    /**
     * Rotate active part
     *
     * @return status of operation
     */
    public boolean rotateLeft() {
        if (!this.parts.isEmpty()) {
            this.parts.get(this.parts.size() - 1).rotateLeft();
            if (this.colision(this.parts.get(this.parts.size() - 1))) {
                //this.rotateRight();
                this.parts.get(this.parts.size() - 1).rotateRight();
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Rotate active part clokwise
     *
     * @return status of operation
     */
    public boolean rotateRight() {
        if (!this.parts.isEmpty()) {
            this.parts.get(this.parts.size() - 1).rotateRight();
            if (this.colision(this.parts.get(this.parts.size() - 1))) {
                //this.rotateLeft();
                this.parts.get(this.parts.size() - 1).rotateLeft();
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean colision(TetroPart p) {
        int counter = 0;
        for (TetroPart prt : this.parts) {
            if (counter != this.parts.size() - 1 && (p.equals(prt) || p.colision(prt))) {
                return true;
            }
            counter++;
        }
        return !p.contains(bounds);
    }

    /**
     * Move part to set direction
     *
     * @param i direction
     * @return state of operation
     */
    public boolean move(int i) {
        if (!this.parts.isEmpty()) {
            switch (i) {
                case 1:
                    this.parts.get(this.parts.size() - 1).setPos(this.parts.get(this.parts.size() - 1).getX() + partSize, this.parts.get(this.parts.size() - 1).getY());
                    if (this.colision(this.parts.get(this.parts.size() - 1))) {
                        this.parts.get(this.parts.size() - 1).setPos(this.parts.get(this.parts.size() - 1).getX() - partSize, this.parts.get(this.parts.size() - 1).getY());
                        return false;
                    }
                    if (this.parts.get(this.parts.size() - 1).getX() > this.getWidth() / 2) {
                        this.changeOff(-partSize, 0, 1);
                    }
                    return true;
                case -1:
                    this.parts.get(this.parts.size() - 1).setPos(this.parts.get(this.parts.size() - 1).getX() - partSize, this.parts.get(this.parts.size() - 1).getY());
                    if (this.colision(this.parts.get(this.parts.size() - 1))) {
                        this.parts.get(this.parts.size() - 1).setPos(this.parts.get(this.parts.size() - 1).getX() + partSize, this.parts.get(this.parts.size() - 1).getY());
                        return false;
                    }
                    if (this.parts.get(this.parts.size() - 1).getX() > this.getWidth() / 2) {
                        this.changeOff(partSize, 0, 1);
                    }
                    return true;
                case 2:
                    this.parts.get(this.parts.size() - 1).setPos(this.parts.get(this.parts.size() - 1).getX(), this.parts.get(this.parts.size() - 1).getY() + partSize);
                    if (this.colision(this.parts.get(this.parts.size() - 1))) {
                        this.parts.get(this.parts.size() - 1).setPos(this.parts.get(this.parts.size() - 1).getX(), this.parts.get(this.parts.size() - 1).getY() - partSize);
                        return false;
                    }
                    if (this.parts.get(this.parts.size() - 1).getY() > this.getHeight() / 2) {
                        this.changeOff(0, -partSize, 1);
                    }
                    return true;
                case -2:
                    this.parts.get(this.parts.size() - 1).setPos(this.parts.get(this.parts.size() - 1).getX(), this.parts.get(this.parts.size() - 1).getY() - partSize);
                    if (this.colision(this.parts.get(this.parts.size() - 1))) {
                        this.parts.get(this.parts.size() - 1).setPos(this.parts.get(this.parts.size() - 1).getX(), this.parts.get(this.parts.size() - 1).getY() + partSize);
                        return false;
                    }
                    if (this.parts.get(this.parts.size() - 1).getY() > this.getHeight() / 2) {
                        this.changeOff(0, partSize, 1);
                    }
                    return true;
            }
        }
        return false;
    }

    /**
     * Sets printing of generation
     *
     * @param b value
     */
    public void setPaint(boolean b) {
        this.paint = b;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (paint) {
            for (TetroPart part : this.parts) {
                part.paint(g, 1, offX, offY);
            }
        }
    }

}
