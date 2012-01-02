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
import com.AsamiOffice.jaba2.j2fw.generator.*;

/**
 * AbstractSmartTableGenerator
 *
 * @since   Jul. 30, 1999
 * @version Jan. 17, 2000
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public abstract class AbstractSmartTableGenerator extends AbstractGenerator {
    protected SmartTableModel model_;

    // AbstractGenerator
    public void setup(GeneratorModel model) {
	model_ = (SmartTableModel)model;
	super.setup(model);
    }
}
