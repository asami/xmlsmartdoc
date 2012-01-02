/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998,1999  ASAMI, Tomoharu (tasami@ibm.net)
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

package org.xmlsmartdoc.SmartDoc;

import com.AsamiOffice.jaba2.j2fw.*;

/**
 * SmartDocContext
 *
 * @since   Sep. 23, 1998
 * @version Jun. 21, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class SmartDocContext extends J2Context {
    protected SmartDocConfig config_;
    protected SmartDocModel model_;
    protected SmartDocController controller_;
    protected TTYView view_;

    public SmartDocContext() {
    }

    public SmartDocContext(
	SmartDocConfig config,
	SmartDocModel model,
	SmartDocController controller
    ) {
	super(config, model, controller);
	config_ = config;
	model_ = model;
	controller_ = controller;
    }

    public void setConfig(SmartDocConfig config) {
	setJ2Config(config);
	config_ = config;
    }

    public void setModel(SmartDocModel model) {
	setJ2Model(model);
	model_ = model;
    }

    public void setController(SmartDocController controller) {
	setJ2Controller(controller);
	controller_ = controller;
    }

    public void setView(TTYView view) {
	setJ2View(view);
	view_ = view;
    }

    public SmartDocConfig getConfig() {
	return (config_);
    }

    public SmartDocModel getModel() {
	return (model_);
    }

    public SmartDocController getController() {
	return (controller_);
    }

    public TTYView getView() {
	return (view_);
    }

    public J2Monitor getMonitor() {
	return (getJ2Monitor());
    }

    protected static SmartDocContext context__;

    public static SmartDocContext getContext() {
	return (context__);
    }

    public static void setContext(SmartDocContext context) {
	J2Context.setJ2Context(context);
	context__ = context;
    }
}
