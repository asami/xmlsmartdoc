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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import com.AsamiOffice.jaba2.util.PropertyList;

/**
 * PropertyValue
 *
 * @since   Jul. 12, 1998
 * @version Oct.  2, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public interface PropertyValue extends java.io.Serializable, Cloneable {
/*
    void addPropertyChangeListener(PropertyChangeListener listener);
    void addPropertyChangeListener(String name,
				   PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(String name,
				      PropertyChangeListener listener);
*/
    boolean hasViewer();
    boolean hasWideViewer();
    boolean hasEditor();
    boolean hasWideEditor();
    boolean hasEditorDialog();
    Component getViewer();
    Component getWideViewer();
    Component getEditor();
    Component getWideEditor();
    Dialog getEditorDialog(Component parent);
    String getString();
    PropertyValue clone(PropertyList properties);
}
