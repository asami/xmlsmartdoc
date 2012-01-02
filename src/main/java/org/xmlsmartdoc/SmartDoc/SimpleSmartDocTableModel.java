/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998  ASAMI, Tomoharu (tasami@ibm.net)
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
import javax.swing.table.AbstractTableModel;

import com.AsamiOffice.util.D2Array;

/**
 * SimpleSmartDocTableModel
 *
 * @deprecated
 * @since   Nov. 10, 1998
 * @version May. 25, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class SimpleSmartDocTableModel extends AbstractTableModel
    implements SmartDocTableModel {

    protected D2Array data_;

    public SimpleSmartDocTableModel(D2Array data) {
	data_ = data;
    }

    public SimpleSmartDocTableModel(D2Array data, List columnNames) {
	data_ = data;
    }

    // AbstractTableModel
    public int getRowCount() {
	return (data_.getHeight());
    }

    // AbstractTableModel
    public int getColumnCount() {
	return (data_.getWidth());
    }

    // AbstractTableModel
    public Object getValueAt(int row, int column) {
	return (data_.get(column, row));
    }
}
