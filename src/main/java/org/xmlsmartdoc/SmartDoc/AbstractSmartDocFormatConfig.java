/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asahi@xmlSmartDoc.org)
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

import java.util.Locale;

import com.AsamiOffice.jaba2.j2fw.generator.IGenerator;
import com.AsamiOffice.jaba2.util.LocaleMap;
import com.AsamiOffice.jaba2.util.ParameterInfo;
import com.AsamiOffice.util.ULocale;

/**
 * AbstractSmartDocFormatConfig
 *
 * @since   Apr. 30, 1999
 * @version Mar. 15, 2004
 * @author  ASAMI, Tomoharu (asahi@xmlSmartDoc.org)
 */
public abstract class AbstractSmartDocFormatConfig
    implements SmartDocFormatConfig {

    SmartDocConfig config_;
    ParameterInfo info_;
    protected SmartDocGenerator generator_;
    protected String suffix_;
    protected LocaleMap encodings_; // LocaleMap<Locale, String>
    protected boolean deploy_;
    protected boolean langDir_;
    protected boolean powered_;

    protected void _init(
	SmartDocConfig config,
	String prefix,
	ParameterInfo info
    ) {
	config_ = config;
	info_ = info;
	generator_ =
	    (SmartDocGenerator)info_.getParameterAsNewInstance(
		prefix + ".generator");
	suffix_ = info_.getParameterAsString(prefix + ".suffix");
	encodings_ = info_.getParameterAsLocaleMap(prefix + ".encoding");
	deploy_ = info_.getParameterAsBoolean(prefix + ".deploy");
	langDir_ = info_.getParameterAsBoolean(prefix + ".langDir");
	powered_ = info_.getParameterAsBoolean(prefix + ".powered");
	generator_.init(config_, this);
    }

    // IGeneratorConfigConfig
    public IGenerator getGenerator() {
	return (generator_);
    }

    // IGeneratorConfigConfig
    public String getSuffix() {
	return (suffix_);
    }

    public SmartDocConfig getSmartDocConfig() {
	return (config_);
    }

    // SmartDocFormatConfig
    public String getEncoding(Locale locale) {
	if (locale == null) {
	    return ((String)encodings_.getDefault());
	}
	return ((String)encodings_.get(locale));
    }

    // SmartDocFormatConfig
    public String getEncoding(Doc doc) {
	Locale locale = doc.getDocContext().getLocale();
	if (locale == null) {
	    String language = doc.getLanguage();
	    if (language != null) {
		locale = ULocale.makeLocale(language);
	    }
	}
	return (getEncoding(locale));
    }

    // SmartDocFormatConfig
    public boolean isDeploy() {
	return (deploy_);
    }

    // SmartDocFormatConfig
    public boolean isLanguageDirectory() {
	return (langDir_);
    }

    // SmartDocFormatConfig
    public boolean isPoweredLogo() {
	return (powered_);
    }
}
