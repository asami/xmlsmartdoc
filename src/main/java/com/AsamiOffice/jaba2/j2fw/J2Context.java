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

/**
 * J2Context
 *
 * @since   Nov. 21, 1998
 * @version Jun. 21, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public abstract class J2Context {
    protected J2Monitor j2monitor_;
    protected J2Config j2config_;
    protected J2Model j2model_;
    protected J2Controller j2controller_;
    protected J2View j2view_;

    public J2Context() {
	j2monitor_ = new J2Monitor();
    }

    public J2Context(
	J2Config config,
	J2Model model,
	J2Controller controller
    ) {
	j2monitor_ = new J2Monitor(config);
	j2config_ = config;
	j2model_ = model;
	j2controller_ = controller;
    }

    public J2Context(
	J2Config config,
	J2Model model,
	J2Controller controller,
	J2View view
    ) {
	j2monitor_ = new J2Monitor(config);
	j2config_ = config;
	j2model_ = model;
	j2controller_ = controller;
	j2view_ = view;
    }

    public void setJ2Config(J2Config config) {
	j2config_ = config;
	j2monitor_.setConfig(config);
    }

    public void setJ2Model(J2Model model) {
	j2model_ = model;
    }

    public void setJ2Controller(J2Controller controller) {
	j2controller_ = controller;
    }

    public void setJ2View(J2View view) {
	j2view_ = view;
    }

    public J2Monitor getJ2Monitor() {
	return (j2monitor_);
    }

    public J2Config getJ2Config() {
	return (j2config_);
    }

    public J2Model getJ2Model() {
	return (j2model_);
    }

    public J2Controller getJ2Controller() {
	return (j2controller_);
    }

    public J2View getJ2View() {
	return (j2view_);
    }

    // class scope
    protected static J2Context j2context__;

    public static J2Context getJ2Context() {
	return (j2context__);
    }

    public static void setJ2Context(J2Context context) {
	j2context__ = context;
    }
}
