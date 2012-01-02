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

package org.xmlsmartdoc.SmartDoc.packager;

import java.io.File;
import java.io.IOException;

import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.IPackager;
import com.AsamiOffice.jaba2.j2fw.generator.XMLArtifact;
import com.AsamiOffice.jaba2.xml.IProcessor;
import com.AsamiOffice.jaba2.xml.ProcessorFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.AsamiOffice.io.UFile;
import com.AsamiOffice.xml.UElement;
import com.AsamiOffice.xml.UXMLMaker;

/**
 * CDFPackager
 *
 * @since   Sep.  5, 1999
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class CDFPackager implements IPackager {
    public void pack(
	GeneratorArtifact[] artifacts,
	GeneratorResult result,
	String id,
	Object arg,
	File dest
    ) throws IOException {
	IProcessor processor
	    = ProcessorFactory.getProcessor();
	for (int i = 0;i < artifacts.length;i++) {
	    GeneratorArtifact artifact = artifacts[i];
	    if (artifact instanceof XMLArtifact) {
		XMLArtifact xa = (XMLArtifact)artifact;
		Document doc = processor.parseDocument(
		    new File(xa.getName()).toURL()
		);
		Element item = (Element)xa.getNode();
		Element newItem = (Element)doc.importNode(item, true);
		Element root = doc.getDocumentElement();
		UElement.updateElement(root, newItem, "HREF");
		String encoding = xa.getEncoding();
		UFile.createFile(
		    new File(xa.getName()),
		    UXMLMaker.getXMLVisualText(doc, encoding),
		    encoding
		);
	    }
	}
    }
}
