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

import cz.fi.muni.pv097.Gui.TetroTab;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author 410134
 */
public class TetroTabKeyStrokes extends AbstractAction {

    private final TetroTab parent;
    private final KeyEvent type;

    public TetroTabKeyStrokes(TetroTab alg, int type) {
        this.parent = alg;
        this.type = new KeyEvent(this.parent, this.parent.hashCode(), 0, type, type);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        parent.getAlgorithm().formKeyPressed(type);
    }

}
