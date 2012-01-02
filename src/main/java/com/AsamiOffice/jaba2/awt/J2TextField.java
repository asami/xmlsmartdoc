/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1998  ASAMI, Tomoharu (tasami@ibm.net)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package com.AsamiOffice.jaba2.awt;

import java.awt.event.*;
import javax.swing.JTextField;

/**
 * PropertySheet
 *
 * @since   Oct.  9, 1998
 * @version Nov. 20, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class J2TextField extends JTextField {
    public J2TextField(String text) {
	super(text);
	_init();
    }

    public J2TextField(String text, int column) {
	super(text, column);
	_init();
    }

    private void _init() {
	addKeyListener(new KeyAdapter() {
	    public void keyReleased(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
		    setText("");
		}
	    }
	});
    }
}

