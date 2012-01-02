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

import java.awt.Component;
import java.awt.Dialog;
import javax.swing.JLabel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observable;
import com.AsamiOffice.jaba2.util.PropertyList;
import com.AsamiOffice.jaba2.awt.property.StringPropertyViewer;

/**
 * AbstractPropertyValue
 *
 * @since   Jul. 12, 1998
 * @version Nov. 20, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public abstract class AbstractPropertyValue extends Observable
    implements PropertyValue {

/* XXX : Observable ?
    protected PropertyChangeSupport support_ = null;

    // PropertyValue
    public void addPropertyChangeListener(PropertyChangeListener listener) {
	if (support_ == null) {
	    support_ = new PropertyChangeSupport(this);
	}
	support_.addPropertyChangeListener(listener);
    }

    // PropertyValue
    public void addPropertyChangeListener(
	String propertyName,
	PropertyChangeListener listener
    ) {
	if (support_ == null) {
	    support_ = new PropertyChangeSupport(this);
	}
	support_.addPropertyChangeListener(propertyName, listener);
    }

    // PropertyValue
    public void removePropertyChangeListener(PropertyChangeListener listener) {
	support_.removePropertyChangeListener(listener);
    }

    // PropertyValue
    public void removePropertyChangeListener(
	String propertyName,
	PropertyChangeListener listener
    ) {
	support_.removePropertyChangeListener(propertyName, listener);
    }

    protected void _firePropertyChange(
	String propertyName,
	Object oldValue,
	Object newValue
    ) {
	if (support_ != null) {
	    support_.firePropertyChange(propertyName, oldValue, newValue);
	}
    }
*/
    // PropertyValue
    public boolean hasViewer() {
	return (true);
    }

    // PropertyValue
    public boolean hasWideViewer() {
	return (false);
    }

    // PropertyValue
    public boolean hasEditor() {
	return (false);
    }

    // PropertyValue
    public boolean hasWideEditor() {
	return (false);
    }

    // PropertyValue
    public boolean hasEditorDialog() {
	return (false);
    }

    // PropertyValue
    public Component getViewer() {
	StringPropertyViewer viewer = new StringPropertyViewer(getString());
//	addPropertyListener(viewer);
	return (viewer);
    }

    // PropertyValue
    public Component getWideViewer() {
	return (null);
    }

    // PropertyValue
    public Component getEditor() {
	return (null);
    }

    // PropertyValue
    public Component getWideEditor() {
	return (null);
    }

    // PropertyValue
    public Dialog getEditorDialog(Component parent) {
	return (null);
    }

    // PropertyValue
    public PropertyValue clone(PropertyList properties) {
	Object cloned;
	try {
	    cloned = super.clone();
	} catch (CloneNotSupportedException e) {
	    throw (new InternalError(e.getMessage()));
	}
	return ((PropertyValue)cloned);
    }

    // Object
    public String toString() {
	return (getString());
    }
}
