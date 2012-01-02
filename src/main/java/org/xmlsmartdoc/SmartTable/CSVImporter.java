/*
 * SmartTable
 *  Copyright (C) 1999-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
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

import java.io.IOException;
import java.net.URL;

import com.AsamiOffice.jaba2.j2fw.translator.AbstractImporter;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.util.UCSV;
import com.AsamiOffice.util.D2Array;

/**
 * CSVImporter
 *
 * @since   Aug.  3, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class CSVImporter extends AbstractImporter {
    public String getID() {
        return ("csv");
    }

    public String getName() {
        return ("CSV Importer");
    }

    public boolean canImport(URL url) {
        String suffix = UString.getSuffix(url.toExternalForm());
        return ("csv".equals(suffix));
    }

    public void importSource(URL url) throws IOException {
        SmartTableModel model = (SmartTableModel)model_;
        Metadata metadata = model.getMetadataIn(); // XXX : use	
        String encoding = model_.getInputEncoding();
        String csv = UString.makeStringFromURL(url, encoding);
        D2Array d2 = UCSV.csv2Data(csv); // XXX : use metadata
        model.setData(d2);
    }
}
