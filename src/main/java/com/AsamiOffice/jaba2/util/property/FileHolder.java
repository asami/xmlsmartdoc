/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1998  ASAMI, Tomoharu (tasami@ibm.net)
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

package com.AsamiOffice.jaba2.util.property;

import java.io.File;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.FileDialog;
import javax.swing.JOptionPane;

/**
 * FileHolder
 *
 * @since   Jul. 30, 1998
 * @version Nov. 20, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class FileHolder extends AbstractPropertyValue {
    protected File file_;

    public FileHolder() {
	_init(null);
    }

    public FileHolder(String file) {
	_init(new File(file));
    }

    public FileHolder(File file) {
	_init(file);
    }

    private void _init(File file) {
	file_ = file;
    }

    // PropertyValue
    public String getString() {
	if (file_ == null) {
	    return (null);
	}
	return (file_.toString());
    }

    // AbstractPropertyValue
    public boolean hasEditorDialog() {
	return (true);
    }

    // AbstractPropertyValue
    public Dialog getEditorDialog(Component parent) {
	Frame frame = JOptionPane.getFrameForComponent(parent);
	return (new FileHolderEditor(frame, file_));
    }

    class FileHolderEditor extends FileDialog implements PropertyValueEditor {
	FileHolderEditor(Frame frame, File file) {
	    super(frame, "File");
	    if (file != null) {
		setFile(file.toString());
	    }
	}

	// PropertyValueEditor
	public Object getValue() {
	    return (new FileHolder(getFile()));
	}
    }
}
