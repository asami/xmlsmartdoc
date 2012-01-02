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

package org.xmlsmartdoc.SmartDoc;

import java.util.*;
import java.io.*;
import java.text.*;

/**
 * SmartDocResource_fr
 *
 * @since   Mar. 12, 2003
 * @version Oct. 22, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SmartDocResource_fr extends AbstractSmartDocResource {
    public SmartDocResource_fr() throws IOException {
        super(
            "/org/xmlsmartdoc/SmartDoc/SmartDocDefaults_fr.properties",
            "/org/xmlsmartdoc/SmartDoc/messages_fr"
        );
    }

    public String getPartLabel(int number) {
        return ("Part " + number);
    }

    public String getChapterLabel(int number) {
        return ("Chapter " + number);
    }

    public String getSectionLabel(int number) {
        return ("Section " + number);
    }

    public String getSubSectionLabel(int section, int subSection) {
        return ("Section " + section + "." + subSection);
    }

    public String getSubSubSectionLabel(
        int section,
        int subSection,
        int subSubSection
    ) {
        return ("Section " + section + "." +
                subSection + "." + subSubSection);
    }

    public String[] getLabelParts(String key) {
        String[] parts = new String[2];
        parts[0] = getLabel(key);
        parts[1] = null;
        return (parts);
    }

    public String getYearLabel(int year) {
        return (Integer.toString(year));
    }

    public String getMonthLabel(int month) {
        DateFormatSymbols symbols = new DateFormatSymbols(Locale.ENGLISH);
        return (symbols.getShortMonths()[month - 1] + ".");
    }

    public String getEditionLabel(int edition) {
        switch (edition) {
        case 1:
            return ("1st");
        case 2:
            return ("2nd");
        case 3:
            return ("3rd");
        default:
            return (edition + "th");
        }
    }

    public String getEditorLabel() {
        return ("(ed.)");
    }

    public String getEditorsLabel() {
        return ("(eds.)");
    }
}
