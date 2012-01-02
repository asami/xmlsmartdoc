/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

package com.AsamiOffice.jaba2.j2fw.translator;

import java.io.IOException;
import java.net.URL;

import com.AsamiOffice.jaba2.j2fw.J2Context;
import com.AsamiOffice.jaba2.j2fw.J2Monitor;
import com.AsamiOffice.jaba2.j2fw.J2View;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorController;

/**
 * TranslatorController
 *
 * @since   Jul. 25, 1999
 * @version Oct. 15, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public abstract class TranslatorController extends GeneratorController {
    protected TranslatorConfig config_;
    protected TranslatorModel model_;
    protected IImporter[] importers_;

    protected TranslatorController(
	TranslatorConfig config,
	TranslatorModel model
    ) {
	this(config, model, null);
    }

    protected TranslatorController(
	TranslatorConfig config,
	TranslatorModel model,
	J2View view
    ) {
	super(config, model, view);
	config_ = config;
	model_ = model;
    }

    public void setup() {	// XXX
	importers_ = config_.getImporters();
	for (int i = 0;i < importers_.length;i++) {
	    importers_[i].setup(model_);
	}
    }

    public void showPropertiesConsole() {
	super.showPropertiesConsole();
	J2Monitor monitor = J2Context.getJ2Context().getJ2Monitor();
	URL source = config_.getSource();
	if (source != null) {
	    monitor.println("Source file\t: " + source);
	}
    }

    // J2Controller
    public void executeCommand() 
	throws IllegalArgumentException {

	executeCommand(model_.getCommand());
    }

    public void importSource() throws IOException {
	URL source = model_.getSource();
	_importSource(source);
    }

    protected void _importSource(URL source) throws IOException {
	if (source == null) {
	    return;
	}
	for (int i = 0;i < importers_.length;i++) {
	    IImporter importer = importers_[i];
	    if (importer.canImport(source)) {
		importer.importSource(source);
		return;
	    }
	}
	throw (new IOException("can't import " + source));
    }
}
