/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1999  ASAMI, Tomoharu (tasami@ibm.net)
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

package com.AsamiOffice.jaba2.j2fw;

import java.util.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.*;

/**
 * AbstractGUIView
 *
 * @since   Jun. 21, 1999
 * @version Jun. 21, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public abstract class AbstractGUIView extends JPanel implements J2View {
    protected J2Config config_;
    protected J2Model model_;
    protected J2Controller controller_;

    protected AbstractGUIView(
	J2Config config,
	J2Model model,
	J2Controller controller
    ) {
	config_ = config;
	model_ = model;
	controller_ = controller;
	_setMenuBar();
	_setToolBar();
    }

    public void run() {
	JFrame frame = new JFrame(config_.getName());
	frame.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent evt) {
		controller_.exit();
	    }
	});
	frame.getContentPane().add(this);
	frame.pack();
	frame.show();
    }

    protected void _setMenuBar() {
	// integrate xml menu
    }

    protected void _setToolBar() {
	// integrate xml tool
    }
}
