/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2000  ASAMI, Tomoharu (tasami@ibm.net)
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

import java.util.*;
import java.io.*;
import java.net.URL;
import com.AsamiOffice.jaba2.j2fw.*;
import com.AsamiOffice.jaba2.j2fw.generator.*;
import com.AsamiOffice.jaba2.util.*;

/**
 * TranslatorConfig
 *
 * @since   Jul. 25, 1999
 * @version Jan. 18, 2000
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public abstract class TranslatorConfig extends GeneratorConfig {
    private ImporterFactory importerFactory_;
    private URL source_;
    private URL target_;
    private LocaleMap inputEncodings_;
    private LocaleMap outputEncodings_;

    protected TranslatorConfig() {
    }

    protected TranslatorConfig(ParameterInfo info)
	throws IOException, UnsupportedEncodingException {

	_setup(info);
    }

    protected void _setup(ParameterInfo info)
	throws IOException, UnsupportedEncodingException {

	super._setup(info);
	String initImporter = info_.getParameterAsString("importerInit");
	if (initImporter != null) {
	    URL url = getClass().getResource(initImporter); // XXX
	    if (url != null) {
		importerFactory_ = new ImporterFactory(url);
	    }
	}
	source_ = info.getArgumentAsURLFromFileOrURL(0);
	target_ = info.getArgumentAsURLFromFileOrURL(1);
	inputEncodings_ = info_.getParameterAsLocaleMap("encoding.in");
	outputEncodings_ = info_.getParameterAsLocaleMap("encoding.out");
    }

    public IImporter[] getImporters() {
	return (importerFactory_.getImporters());
    }

    public final URL getSource() {
	return (source_);
    }

    public final URL getTarget() {
	return (target_);
    }

    public String getInputEncoding(Locale locale) {
	if (inputEncodings_ == null) {
	    return (null);
	}
	if (locale == null) {
	    return ((String)inputEncodings_.getDefault());
	}
	return ((String)inputEncodings_.get(locale));
    }

    public String getOutputEncoding(Locale locale) {
	if (outputEncodings_ == null) {
	    return (null);
	}
	if (locale == null) {
	    return ((String)outputEncodings_.getDefault());
	}
	return ((String)outputEncodings_.get(locale));
    }
}
