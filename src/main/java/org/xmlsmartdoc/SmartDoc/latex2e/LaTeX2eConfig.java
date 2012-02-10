/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.latex2e;

import java.util.*;
import java.io.*;
import com.AsamiOffice.jaba2.util.ParameterInfo;
import com.AsamiOffice.jaba2.util.AppParameterInfo;
import com.AsamiOffice.jaba2.util.LocaleString;
import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.latex2e.handler.*;

/**
 * LaTeX2eConfig
 *
 * @since   Oct. 19, 1998
 * @version Aug. 21, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class LaTeX2eConfig extends AbstractSmartDocFormatConfig {
    protected LaTeX2eImageFloatHandler imageFloatHandler_;
    protected LaTeX2eImageHandler imageHandler_;
    protected LaTeX2eBoxHandler boxHandler_;
    protected LaTeX2eTableFloatHandler tableFloatHandler_;
    protected LaTeX2eTableHandler tableHandler_;
    protected LaTeX2eRefHandler refHandler_;
    protected LaTeX2eProgramHandler programHandler_;
    protected LaTeX2eConsoleHandler consoleHandler_;
    protected LaTeX2eRubyHandler rubyHandler_;
    protected String documentType_;
    protected LocaleString documentClass_;
    protected LocaleString classArticle_;
    protected LocaleString classReport_;
    protected LocaleString classBook_;
    protected String styleUrl_;
    protected Set options_ = new TreeSet();
    protected Set packages_ = new TreeSet();
    protected String pageStyle_;
    protected String imageLoc_;
    protected String tableLoc_;
    protected String consoleLoc_;
    protected String fyiLoc_;
    protected String tocStyle_;
    protected LocaleString bibStyle_;
    protected String dvipsPackage_;
    protected String[] dvipsOptions_;
    protected String driver_;
    protected String graphicPackage_;
    protected String[] graphicOptions_;
    protected boolean graphicAutoResize_;
    protected String quotePrologue_;
    protected String quoteEpilogue_;
    protected String tabularType_;

    public void setup(SmartDocConfig config, String[] args)
	throws IOException {

	ParameterInfo info = new AppParameterInfo(
	    "org.xmlsmartdoc.SmartDoc",
	    args,
	    "org.xmlsmartdoc.SmartDoc.latex2e.LaTeX2eDefaults",
	    new File("SmartDoc.properties")
	);
	info.addPackage("org.xmlsmartdoc.SmartDoc.latex2e");
	info.addPackage("org.xmlsmartdoc.SmartDoc.latex2e.handler");
	imageFloatHandler_
	    = (LaTeX2eImageFloatHandler)info.getParameterAsNewInstance(
		"latex2e.imageFloat"
	    );
	imageHandler_ = (LaTeX2eImageHandler)info.getParameterAsNewInstance(
	    "latex2e.image"
	);
	boxHandler_ = (LaTeX2eBoxHandler)info.getParameterAsNewInstance(
	    "latex2e.box"
	);
	tableFloatHandler_
	    = (LaTeX2eTableFloatHandler)info.getParameterAsNewInstance(
	    "latex2e.tableFloat"
	);
	tableHandler_
	    = (LaTeX2eTableHandler)info.getParameterAsNewInstance(
	    "latex2e.table"
	);
	refHandler_
	    = (LaTeX2eRefHandler)info.getParameterAsNewInstance(
	    "latex2e.ref"
	);
	programHandler_
	    = (LaTeX2eProgramHandler)info.getParameterAsNewInstance(
	    "latex2e.program"
	);
	consoleHandler_
	    = (LaTeX2eConsoleHandler)info.getParameterAsNewInstance(
	    "latex2e.console"
	);
	rubyHandler_
	    = (LaTeX2eRubyHandler)info.getParameterAsNewInstance(
	    "latex2e.ruby"
	);
	documentType_ = info.getParameterAsString("latex2e.type");
	documentClass_ = info.getParameterAsLocaleString("latex2e.class");
	classArticle_
	    = info.getParameterAsLocaleString("latex2e.class.article");
	classReport_
	    = info.getParameterAsLocaleString("latex2e.class.report");
	classBook_ = info.getParameterAsLocaleString("latex2e.class.book");
	styleUrl_ = info.getParameterAsString("latex2e.style.url");
	_addOptions(info.getParameterAsStringList("latex2e.option"));
	_addPackages(info.getParameterAsStringList("latex2e.package"));
	pageStyle_ = info.getParameterAsString("latex2e.pagestyle");
//	_addPackages(imageHandler_.getPackages());
//	_addPackages(boxHandler_.getPackages());
	imageLoc_ = info.getParameterAsString("latex2e.imageLoc");
	tableLoc_ = info.getParameterAsString("latex2e.tableLoc");
	consoleLoc_ = info.getParameterAsString("latex2e.consoleLoc");
	fyiLoc_ = info.getParameterAsString("latex2e.fyiLoc");
	tocStyle_ = info.getParameterAsString("latex2e.tocStyle");
	bibStyle_ = info.getParameterAsLocaleString("latex2e.bibStyle");
	dvipsPackage_
	    = info.getParameterAsString("latex2e.dvips.package");
	dvipsOptions_
	    = info.getParameterAsStringList("latex2e.dvips.options");
	driver_ = info.getParameterAsString("latex2e.driver");
	if ("dvips".equals(driver_)) {
	    imageHandler_ = new DVIPSLaTeX2eImageHandler();
	    graphicPackage_ = "graphics";
	} else if ("dvi2ps".equals(driver_)) {
	    imageHandler_ = new DVI2PSLaTeX2eImageHandler();
	    // eclepsf
	} else if ("dvipdfm".equals(driver_)) {
	    imageHandler_ = new DVIPDFMLaTeX2eImageHandler();
	    graphicPackage_ = "graphicx";
	    graphicOptions_ = new String[] { "dvipdfm" };
	}
	String graphicPackage
	    = info.getParameterAsString("latex2e.graphic.package");
	if (graphicPackage != null) {
	    graphicPackage_ = graphicPackage;
	}
	String[] graphicOptions
	    = info.getParameterAsStringList("latex2e.graphic.options");
	if (graphicOptions != null) {
	    graphicOptions_ = graphicOptions;
	}
	graphicAutoResize_
	    = info.getParameterAsBoolean("latex2e.graphic.autoResize");
	quotePrologue_ = info.getParameterAsString("latex2e.quotePrologue");
	quoteEpilogue_ = info.getParameterAsString("latex2e.quoteEpilogue");
	String quote = info.getParameterAsString("latex2e.quote");
	if (quotePrologue_ == null) {
	    quotePrologue_ = quote;
	}
	if (quoteEpilogue_ == null) {
	    quoteEpilogue_ = quote;
	}
        tabularType_ = info.getParameterAsString("latex2e.tabular");
	_init(config, "latex2e", info);
    }

    // SmartDocFormatConfig
    public String getID() {
	return ("latex2e");
    }

    // SmartDocFormatConfig
    public String getName() {
	return ("LaTeX2e");
    }

    // SmartDocFormatConfig
    public String[] getImageCandidates() {
	return (imageHandler_.getImageCandidates());
    }

/*
    // SmartDocFormatConfig
    public SmartDocGenerator getGenerator() {
	return (generator_);
    }
*/

    // SmartDocFormatConfig
    public String getSuffix() {
	return (suffix_);
    }

    public LaTeX2eImageFloatHandler getImageFloatHandler() {
	return (imageFloatHandler_);
    }

    public LaTeX2eImageHandler getImageHandler() {
	return (imageHandler_);
    }

    public LaTeX2eBoxHandler getBoxHandler() {
	return (boxHandler_);
    }

    public LaTeX2eTableFloatHandler getTableFloatHandler() {
	return (tableFloatHandler_);
    }

    public LaTeX2eTableHandler getTableHandler() {
	return (tableHandler_);
    }

    public LaTeX2eRefHandler getRefHandler() {
	return (refHandler_);
    }

    public LaTeX2eProgramHandler getProgramHandler() {
	return (programHandler_);
    }

    public LaTeX2eConsoleHandler getConsoleHandler() {
	return (consoleHandler_);
    }

    public LaTeX2eRubyHandler getRubyHandler() {
	return (rubyHandler_);
    }

    public String getDocumentType() {
	return (documentType_);
    }

    public LocaleString getDocumentClass() {
	return (documentClass_);
    }

    public LocaleString getClassArticle() {
	return (classArticle_);
    }

    public LocaleString getClassReport() {
	return (classReport_);
    }

    public LocaleString getClassBook() {
	return (classBook_);
    }

    public String getStyleUrl() {
	return (styleUrl_);
    }

    public String[] getOptions() {
	String[] options = new String[options_.size()];
	return ((String[])options_.toArray(options));
    }

    public String[] getPackages() {
	String[] packages = new String[packages_.size()];
	return ((String[])packages_.toArray(packages));
    }

    public String getPageStyle() {
	return (pageStyle_);
    }

    public String getImageLoc() {
	return (imageLoc_);
    }

    public String getTableLoc() {
	return (tableLoc_);
    }

    public String getConsoleLoc() {
	return (consoleLoc_);
    }

    public String getFYILoc() {
	return (fyiLoc_);
    }

    public String getTocStyle() {
	return (tocStyle_);
    }

    public LocaleString getBibStyle() {
	return (bibStyle_);
    }

    public String getDvipsPackage() {
	return (dvipsPackage_);
    }

    public String[] getDvipsOptions() {
	return (dvipsOptions_);
    }

    public String getDriver() {
	return (driver_);
    }

    public String getGraphicPackage() {
	return (graphicPackage_);
    }

    public String[] getGraphicOptions() {
	return (graphicOptions_);
    }

    public boolean isGraphicAutoResize() {
	return (graphicAutoResize_);
    }

    public String getQuotePrologue() {
	return (quotePrologue_);
    }

    public String getQuoteEpilogue() {
	return (quoteEpilogue_);
    }

    public String getTabularType() {
        return (tabularType_);
    }        

    public String getTabularName() {
        return (tabularType_);
    }

    protected void _addOptions(String[] options) {
	if (options == null) {
	    return;
	}
	for (int i = 0;i < options.length;i++) {
	    options_.add(options[i]);
	}
    }

    protected void _addPackages(String[] packages) {
	if (packages == null) {
	    return;
	}
	for (int i = 0;i < packages.length;i++) {
	    packages_.add(packages[i]);
	}
    }
}
