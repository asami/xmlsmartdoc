/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.plain;

import java.io.File;
import java.io.IOException;

import org.xmlsmartdoc.SmartDoc.AbstractSmartDocFormatConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import com.AsamiOffice.jaba2.util.AppParameterInfo;
import com.AsamiOffice.jaba2.util.ParameterInfo;

/**
 * PlainConfig
 *
 * @since   Jun. 21, 1999
 * @version May.  6, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class PlainConfig extends AbstractSmartDocFormatConfig {
    private int layoutWidth_ = 70;
    private String keisenStyle_;
    private boolean useUnderlineHilight_;
    private String thickUnderline_;
    private String thinUnderline_;
    private String newline_;
    private String quotePrologue_;
    private String quoteEpilogue_;
    private boolean natural_;

    // SmartDocFormatConfig
    public void setup(SmartDocConfig config, String[] args)
        throws IOException {

        ParameterInfo info = new AppParameterInfo(
            "org.xmlsmartdoc.SmartDoc",
            args,
            "org.xmlsmartdoc.SmartDoc.plain.PlainDefaults",
            new File("SmartDoc.properties")
        );
        info.addPackage("org.xmlsmartdoc.SmartDoc.plain");
        info.addPackage("org.xmlsmartdoc.SmartDoc.plain.handler");
        _init(config, "plain", info);
        layoutWidth_ = info.getParameterAsInt("plain.width");
        keisenStyle_ = info.getParameterAsString("plain.keisen");
        useUnderlineHilight_ = info.getParameterAsBoolean("plain.underline");
        if ("jis".equals(keisenStyle_)) {
            thickUnderline_ = "\u2501";
            thinUnderline_ = "\u2500";
        } else {
            thickUnderline_ = "=";
            thinUnderline_ = "-";
        }
        String newline = info.getParameterAsString("plain.newline");
        if ("lf".equals(newline)) {
            newline_ = "\n";
        } else if ("crlf".equals(newline)) {
            newline_ = "\r\n";
        } else if ("cr".equals(newline)) {
            newline_ = "\r";
        } else {
            newline_ = "\n";
        }
        quotePrologue_ = info.getParameterAsString("plain.quotePrologue");
        quoteEpilogue_ = info.getParameterAsString("plain.quoteEpilogue");
        String quote = info.getParameterAsString("plain.quote");
        if (quotePrologue_ == null) {
            quotePrologue_ = quote;
        }
        if (quoteEpilogue_ == null) {
            quoteEpilogue_ = quote;
        }
        natural_ = info.getParameterAsBoolean("plain.natural");
    }

    // SmartDocFormatConfig
    public String getID() {
        return ("plain");
    }

    // SmartDocFormatConfig
    public String getName() {
        return ("Plain");
    }

    // SmartDocFormatConfig
    public String[] getImageCandidates() {
        return (new String[] { "gif", "jpeg", "png" });
    }

    public final int getLayoutWidth() {
        return (layoutWidth_);
    }

    public final String getKeisenStyle() {
        return (keisenStyle_);
    }

    public final String getThinUnderline() {
        if (!useUnderlineHilight_) {
            return (null);
        } else {
            return (thinUnderline_);
        }
    }

    public final String getThickUnderline() {
        if (!useUnderlineHilight_) {
            return (null);
        } else {
            return (thickUnderline_);
        }
    }

    public final String getNewline() {
        return (newline_);
    }

    public final String getQuotePrologue() {
        return (quotePrologue_);
    }

    public final String getQuoteEpilogue() {
        return (quoteEpilogue_);
    }

    public boolean isNatural() {
        return (natural_);
    }
}
