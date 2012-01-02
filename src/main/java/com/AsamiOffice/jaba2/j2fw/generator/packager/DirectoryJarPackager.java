/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import java.io.File;
import java.io.IOException;

import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.IPackager;

/**
 * DirectoryJarPackager
 *
 * @since   May. 15, 1999
 * @version Oct. 15, 2003
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class DirectoryJarPackager implements IPackager {
    protected JarPackager jarPackager_ = new JarPackager();

    public void pack(
        GeneratorArtifact[] artifacts,
        GeneratorResult result,
        String id,
        Object arg,
        File dest)
        throws IOException {
        File dir = new File(dest, id);
        if (!dir.exists()) {
            dir.mkdir();
        }
        jarPackager_.pack(artifacts, result, id, arg, dir);
    }
}
