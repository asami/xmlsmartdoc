/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2000  ASAMI, Tomoharu (tasami@ibm.net)
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

package com.AsamiOffice.jaba2.j2fw.generator.packager;

import java.io.*;
import com.AsamiOffice.jaba2.j2fw.generator.*;

/**
 * StdoutPackager
 *
 * @since   May. 26, 1999
 * @version Feb. 10, 2000
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class StdoutPackager implements IPackager {
    public void pack(
	GeneratorArtifact[] artifacts,
	GeneratorResult result,
	String id,
	Object arg,
	File dest
    ) throws IOException {
	for (int i = 0;i < artifacts.length;i++) {
	    GeneratorArtifact artifact = artifacts[i];
	    artifact.outputStream(System.out);
/*
	    if (!"link".equals(artifact.encoding)) {
		OutputStreamWriter out;
		if (artifact.encoding == null) {
		    out = new OutputStreamWriter(System.out);
		} else {
		    out = new OutputStreamWriter(
			System.out,
			artifact.encoding
		    );
		}
		out.write(artifact.content);
		out.flush();
	    }
*/
	}
    }
}
