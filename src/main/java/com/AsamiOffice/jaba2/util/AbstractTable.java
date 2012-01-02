/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1994  ASAMI, Tomoharu (asami@asamiOffice.com)
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

package com.AsamiOffice.jaba2.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.AsamiOffice.util.D2Array;

/**
 * CSVTable
 *
 * @since   May. 25, 1999
 * @version Jan.  7, 2004
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public class AbstractTable extends AbstractTableModel {
    protected D2Array data_;

    protected AbstractTable() {
    }

    protected AbstractTable(D2Array data) {
        data_ = data;
    }

    protected AbstractTable(D2Array data, List columnNames) {
        data_ = data;
    }

    protected void _setup(D2Array data) {
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
