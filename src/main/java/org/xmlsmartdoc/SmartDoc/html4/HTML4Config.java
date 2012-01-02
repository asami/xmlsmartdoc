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

package org.xmlsmartdoc.SmartDoc.html4;

import java.io.File;
import java.io.IOException;

import org.xmlsmartdoc.SmartDoc.AbstractSmartDocFormatConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import org.xmlsmartdoc.SmartDoc.xhtml.IXHTMLDynamicHandler;
import com.AsamiOffice.jaba2.util.AppParameterInfo;
import com.AsamiOffice.jaba2.util.ParameterInfo;

/**
 * HTML4Config
 *
 * @since   Oct. 27, 1998
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class HTML4Config extends AbstractSmartDocFormatConfig {
    protected IXHTMLDynamicHandler dynamicHandler_;
    protected String cssURL_;
    protected String cssInclude_;
    protected boolean cssCopy_;
    protected String[] imageCandidates_;
    protected boolean numberedTitle_;
    protected String figureTitle_;
    protected boolean refTitle_;
    protected String tableAttrs_;
    protected String dtdType_;
    protected boolean nnLink_;
    protected boolean ohp_;
    protected String browser_;
    protected boolean isXhtml_;
    protected boolean negotiation_;

    // SmartDocFormatConfig
    public void setup(SmartDocConfig config, String[] args)
        throws IOException {

        ParameterInfo info = new AppParameterInfo(
            "org.xmlsmartdoc.SmartDoc",
            args,
            "org.xmlsmartdoc.SmartDoc.html4.HTML4Defaults",
            new File("SmartDoc.properties")
        );
        info.addPackage("org.xmlsmartdoc.SmartDoc.html4");
        info.addPackage("org.xmlsmartdoc.SmartDoc.html4.handler");
        dynamicHandler_ = (IXHTMLDynamicHandler)info.getParameterAsNewInstance(
            "html4.dynamic"
        );
        imageCandidates_ = info.getParameterAsStringList("html4.imageFormat");
        cssURL_ = info.getParameterAsString("html4.css.url");
        cssInclude_ = info.getParameterAsString("html4.css.include");
        cssCopy_ = info.getParameterAsBoolean("html4.css.copy");
        numberedTitle_ = info.getParameterAsBoolean("html4.titleNumber");
        if (numberedTitle_ == false) {
            numberedTitle_ = info.getParameterAsBoolean("html4.numberedTitle");
        }
        figureTitle_ = info.getParameterAsString("html4.figureTitle");
        refTitle_ = info.getParameterAsBoolean("html4.refTitle");
        tableAttrs_ = info.getParameterAsString("html4.tableAttrs");
        dtdType_ = info.getParameterAsString("html4.dtd.type");
        nnLink_ = info.getParameterAsBoolean("html4.nnLink");
        ohp_ = info.getParameterAsBoolean("html4.ohp");
        browser_ = info.getParameterAsString("html4.browser");
        isXhtml_ = info.getParameterAsBoolean("html4.xhtml");
        negotiation_ = info.getParameterAsBoolean("html4.negotiation");
        _init(config, "html4", info);
    }

    // SmartDocFormatConfig
    public String getID() {
        return ("html4");
    }

    // SmartDocFormatConfig
    public String getName() {
        return ("HTML4.0");
    }

    // SmartDocFormatConfig
    public String[] getImageCandidates() {
        return (imageCandidates_);
    }

    public IXHTMLDynamicHandler getDynamicHandler() {
        return (dynamicHandler_);
    }

    public String getCSSURL() {
        return (cssURL_);
    }

    public String getCSSInclude() {
        return (cssInclude_);
    }

    public boolean isCopyCSS() {
        return (cssCopy_);
    }

    public boolean isNumberedTitle() { // XXX : XHTMLFormatConfig?
        return (numberedTitle_);
    }

    public String getFigureTitle() {
        return (figureTitle_);
    }

    public boolean isRefTitle() {
        return (refTitle_);
    }

    public String getTableAttrs() {
        return (tableAttrs_);
    }

    public boolean isStrictDTD() {
        return ("strict".equals(dtdType_));
    }

    public boolean isNNLink() {
        return (nnLink_);
    }

    public boolean isOHP() {
        return (ohp_);
    }

    public String getBrowser() {
        return (browser_);
    }

    public boolean isXhtml() {
        return (isXhtml_);
    }

    public boolean isNegotiation() {
        return (negotiation_);
    }
}
