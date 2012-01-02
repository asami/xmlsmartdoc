/*
 * SmartTable
 *  Copyright (C) 1999-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import org.w3c.dom.Document;

import com.AsamiOffice.util.D2Array;
import com.AsamiOffice.xml.UXMLMaker;

/**
 * HTMLTableGenerator
 *
 * @since   Aug.  8, 1999
 * @version Oct. 19, 2003
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class HTMLTableGenerator extends AbstractSmartTableGenerator {
    public String getID() {
	return ("htmltable");
    }

    public String getName() {
	return ("HTMLTable Generator");
    }

    public GeneratorResult generate(IGeneratorParameter param) {
	String encoding = model_.getOutputEncoding();
	Metadata metadata = model_.getMetadataOut();
	D2Array d2 = model_.getData();
	Document doc = metadata.d2Array2HTMLTable(d2);
	GeneratorResult result = new GeneratorResult();
	result.addArtifact(
	    model_.getProject() + ".xml",
	    UXMLMaker.getXMLVisualText(doc, encoding),
	    encoding
	);
	return (result);
    }
}
