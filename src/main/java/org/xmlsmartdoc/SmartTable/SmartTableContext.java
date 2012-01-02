/*
 * SmartTable
 *  Copyright (C) 1999,2000  ASAMI, Tomoharu (tasami@ibm.net)
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

package org.xmlsmartdoc.SmartTable;

import com.AsamiOffice.jaba2.j2fw.*;

/**
 * SmartTableContext
 *
 * @since   Jul. 24, 1999
 * @version Jan. 17, 2000
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class SmartTableContext extends J2Context {
    protected SmartTableConfig config_;
    protected SmartTableModel model_;
    protected SmartTableController controller_;
    protected TTYView view_;

    public SmartTableContext() {
    }

    public SmartTableContext(
	SmartTableConfig config,
	SmartTableModel model,
	SmartTableController controller
    ) {
	super(config, model, controller);
	config_ = config;
	model_ = model;
	controller_ = controller;
    }

    public void setConfig(SmartTableConfig config) {
	setJ2Config(config);
	config_ = config;
    }

    public void setModel(SmartTableModel model) {
	setJ2Model(model);
	model_ = model;
    }

    public void setController(SmartTableController controller) {
	setJ2Controller(controller);
	controller_ = controller;
    }

    public void setView(TTYView view) {
	setJ2View(view);
	view_ = view;
    }

    public SmartTableConfig getConfig() {
	return (config_);
    }

    public SmartTableModel getModel() {
	return (model_);
    }

    public SmartTableController getController() {
	return (controller_);
    }

    public TTYView getView() {
	return (view_);
    }

    public J2Monitor getMonitor() {
	return (getJ2Monitor());
    }

    protected static SmartTableContext context__;

    public static SmartTableContext getContext() {
	return (context__);
    }

    public static void setContext(SmartTableContext context) {
	J2Context.setJ2Context(context);
	context__ = context;
    }
}
