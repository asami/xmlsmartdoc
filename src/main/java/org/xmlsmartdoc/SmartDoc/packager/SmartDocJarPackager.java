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
import java.util.Locale;

import org.xmlsmartdoc.SmartDoc.Doc;
import org.xmlsmartdoc.SmartDoc.DocContext;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.packager.JarPackager;

/**
 * JarPackager
 *
 * @since   May. 10, 1999
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class SmartDocJarPackager extends JarPackager {
    public void pack(
    	GeneratorArtifact[] artifacts,
    	GeneratorResult result,
    	String id,
    	Object arg,
    	File dest
    ) throws IOException {
    	Doc doc = (Doc)arg;
    	DocContext context = doc.getDocContext();
    	String project = context.getProject();
    	Locale locale = context.getLocale();
    	String jarfile;
    	if (locale == null) {
	       jarfile = project + ".jar";
	   } else {
	       jarfile = project + "_" + locale.toString() + ".jar";
	   }
	   super.pack(artifacts, result, id, jarfile, dest);
    }
}
