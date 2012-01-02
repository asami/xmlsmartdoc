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

import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.IGeneratorParameter;
import com.AsamiOffice.jaba2.util.UCSV;
import com.AsamiOffice.util.D2Array;

/**
 * CSVGenerator
 *
 * @since   Jul. 29, 1999
 * @version Jan.  7, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class CSVGenerator extends AbstractSmartTableGenerator {
    public String getID() {
        return ("csv");
    }

    public String getName() {
        return ("CSV Generator");
    }

    public GeneratorResult generate(IGeneratorParameter param) {
        Metadata metadata = model_.getMetadataOut(); // XXX : use
        D2Array d2 = model_.getData();
        String csv = UCSV.data2CSV(d2); // XXX : use metadata
        GeneratorResult result = new GeneratorResult();
        result.addArtifact(
            model_.getProject() + ".csv",
            csv,
            model_.getOutputEncoding());
        return (result);
    }
}
