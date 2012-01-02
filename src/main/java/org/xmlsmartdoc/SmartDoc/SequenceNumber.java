/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@zeomtech.com)
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

import java.util.Locale;
import com.AsamiOffice.jaba2.util.LocaleMap;

/**
 * SequenceNumber
 *
 * @since   May. 23, 2000
 * @version Sep. 13, 2003
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class SequenceNumber {
    private String name_;
    private LocaleMap labels_ = new LocaleMap();
    private int numberInDoc_ = 0;
    private int numberInPart_ = 0;
    private int numberInChapter_ = 0;
    private int numberInSection_ = 0;
    private int numberInSubSection_ = 0;
    private int numberInSubSubSection_ = 0;
    private int numberInAppendix_ = 0;

    public SequenceNumber(String name) {
	name_ = name;
    }

    public String getName() {
	return (name_);
    }

    public String getLabel() {
	return ((String)labels_.getDefault());
    }

    public String getLabel(Locale locale) {
	return ((String)labels_.get(locale));
    }

    public void setNumberInDoc(int number) {
	numberInDoc_ = number;
    }

    public void setNumberInPart(int number) {
	numberInPart_ = number;
    }

    public void setNumberInChapter(int number) {
	numberInChapter_ = number;
    }

    public void setNumberInSection(int number) {
	numberInSection_ = number;
    }

    public void setNumberInSubSection(int number) {
	numberInSubSection_ = number;
    }

    public void setNumberInSubSubSection(int number) {
	numberInSubSubSection_ = number;
    }

    public void setNumberInAppendix(int number) {
	numberInAppendix_ = number;
    }

    public int getNumberInDoc() {
	return (numberInDoc_);
    }

    public int getNumberInPart() {
	return (numberInPart_);
    }

    public int getNumberInChapter() {
	return (numberInChapter_);
    }

    public int getNumberInSection() {
	return (numberInSection_);
    }

    public int getNumberInSubSection() {
	return (numberInSubSection_);
    }

    public int getNumberInSubSubSection() {
	return (numberInSubSubSection_);
    }

    public int getNumberInAppendix() {
        return (numberInAppendix_);
    }
}
