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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import com.AsamiOffice.jaba2.util.PropertyList;

/**
 * LinkString
 *
 * @since   Jun. 26, 1998
 * @version Nov. 20, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class LinkString extends AbstractPropertyValue {
    protected boolean isLink_ = true;
    protected String value_ = null;
    protected String linkName_;
    protected PropertyList properties_;

    public LinkString(String linkName, PropertyList properties) {
	linkName_ = linkName;
	properties_ = properties;
    }

    public String getLinkName() {
	return (linkName_);
    }

    public String getValue() {
	if (isLink_) {
	    return ((String)properties_.get(linkName_));
	} else {
	    return (value_);
	}
    }

    public void setValue(String value) {
	value_ = value;
	isLink_ = false;
    }

    public boolean isLinked() {
	return (isLink_);
    }

    public void setLinked(boolean linked) {
	isLink_ = linked;
    }

    // PropertyValue
    public Component getViewer() {
	return (new JLabel(getValue()));
    }

    // PropertyValue
    public Component getEditor() {
	return (new LinkStringEditor());
    }

    // PropertyValue
    public String getString() {
	return (getValue());
    }

    // AbstractPropertyValue
    public PropertyValue clone(PropertyList properties) {
	LinkString cloned = new LinkString(linkName_, properties);
	cloned.isLink_ = isLink_;
	cloned.value_ = value_;
	return (cloned);
    }

    class LinkStringEditor extends JComponent {
	JCheckBox check_;
	JTextField string_;

	LinkStringEditor() {
	    setLayout(new FlowLayout(FlowLayout.LEFT));
	    check_ = new JCheckBox(
		"link(" + properties_.getLabel(linkName_) + ")",
		isLinked()
	    );
	    check_.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent evt) {
		    setLinked(check_.isSelected());
		    _update();
		}
	    });
	    string_ = new JTextField(20);
	    string_.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    setValue(string_.getText());
		    _update();
		}
	    });
	    add(check_);
	    add(string_);
	    properties_.addObserver(new Observer() {
		public void update(Observable o, Object arg) {
		    if (o == properties_ && linkName_.equals(arg)) {
			_update();
		    }
		}
	    });
	    _update();
	}

	private void _update() {
	    if (isLinked()) {
		string_.setEnabled(false);
		string_.setText(getValue());
	    } else {
		string_.setEnabled(true);
		string_.setText(getValue());
	    }
	}
    }
}
