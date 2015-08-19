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
package cz.fi.muni.pv097.Canvases.Listeners;

import cz.fi.muni.pv097.Canvases.ObjectCreator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author 410134
 */
public class ObjectCreatorListener extends MouseAdapter {

    private final ObjectCreator parent;

    public ObjectCreatorListener(ObjectCreator parent) {
        this.parent = parent;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()) {
            case 1:
                //left
                parent.changeColor(e.getPoint());
                break;
            case 2:
                //midle
                break;
            case 3:
                //right
                parent.setDefaultSquare(e.getPoint());
                break;
        }
    }

}
