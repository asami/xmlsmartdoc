/*
 * SmartTable
 *  Copyright (C) 1999,2000  ASAMI, Tomoharu (tasami@ibm.net)
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

import java.io.*;
import java.net.URL;
import org.w3c.dom.*;
import com.AsamiOffice.jaba2.j2fw.generator.*;
import com.AsamiOffice.jaba2.j2fw.translator.*;
import com.AsamiOffice.jaba2.util.*;
import com.AsamiOffice.jaba2.text.UString;
import com.AsamiOffice.jaba2.xml.*;
import com.AsamiOffice.util.*;

/**
 * AutoGenerator
 *
 * @since   Aug.  5, 1999
 * @version Jan. 17, 2000
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class AutoGenerator extends AbstractSmartTableGenerator {
    public String getID() {
	return ("auto");
    }

    public String getName() {
	return ("Auto Generator");
    }

    public GeneratorResult generate(IGeneratorParameter param) {
	URL source = model_.getSource();
	URL target = model_.getTarget();
	String command = null;
	if (target != null) {
	    if (USmartTable.isXMLFile(target)) {
		command = "xml";
	    } else if (USmartTable.isCSVFile(target)) {
		command = "csv";
	    } else if (USmartTable.isJDBCFile(target)) {
		command = "jdbc";
	    }
	} else {
	    if (USmartTable.isXMLFile(source)) {
		command = "csv";
	    } else {
		command = "xml";
	    }
	}
	if (command == null) {
	    throw (new InternalError()); // XXX
	}
	IGenerator generator = model_.getGenerator(command);
	if (generator == null) {
	    throw (new InternalError());
	}
	return (generator.generate(param));
    }
}
