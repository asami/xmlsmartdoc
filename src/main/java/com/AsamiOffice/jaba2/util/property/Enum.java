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

import java.util.*;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * Enum
 *
 * @since   Jun. 18, 1998
 * @version Nov. 20, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class Enum extends AbstractPropertyValue
    implements javax.swing.ComboBoxModel {

    protected Object[] values_;
    protected Object selected_ = null;

    public Enum(Object[] values) {
	_init((Object[])values.clone(), null);
    }

    public Enum(Collection values) {
	_init(values.toArray(), null);
    }

    public Enum(Object[] values, Object selected) {
	_init((Object[])values.clone(), selected);
    }

    public Enum(Collection values, Object selected) {
	_init(values.toArray(), selected);
    }

    private void _init(Object[] values, Object selected) {
	values_ = values;
	if (selected != null) {
	    selected_ = selected;
	} else {
	    selected_ = values_[0];
	}
    }

    // ListModel
    public int getSize() {
	return (values_.length);
    }

    // ListModel
    public Object getElementAt(int index) {
	return (values_[index]);
    }

    // ListModel
    public void addListDataListener(ListDataListener listener) {
	// do nothing, because contents of the Enum is immutable.
    }

    // ListModel
    public void removeListDataListener(ListDataListener listener) {
	// do nothing, because contents of the Enum is immutable.
    }

    // ComobBoxModel
    public Object getSelectedItem() {
	return (selected_);
    }

    // ComboBoxModel
    public void setSelectedItem(Object item) {
	selected_ = item;
    }

    // PropertyValue
    public Component getViewer() {
	return (new JLabel(getSelectedItem().toString()));
    }

    // PropertyValue
    public Component getEditor() {
	return (new JComboBox(this));
    }

    // PropertyValue
    public String getString() {
	return (getSelectedItem().toString());
    }

    // Object
    public String toString() {
	return (getString());
    }	
}
