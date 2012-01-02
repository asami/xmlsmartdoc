/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
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
import org.w3c.dom.*;

/**
 * CSSStyle
 * 
 * @since   Jan. 10, 1999
 * @version Aug. 28, 2004
 * @author ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class CSSStyle {
    protected String text_;

    protected CSSColor color_;

    protected CSSColor backgroundColor_;

    protected CSSLength width_;

    protected CSSLength height_;

    protected CSSFont font_;

    protected String textAlign_;

    protected String floatStyle_;

    protected float scale_;

    protected float rotate_;

    protected String listStyleType_;

    public CSSStyle() {
        text_ = null;
    }

    public CSSStyle(String text) {
        text_ = text;
        StringTokenizer st = new StringTokenizer(text, ";");
        Properties properties = new Properties();
        while (st.hasMoreTokens()) {
            String slot = st.nextToken();
            int offset = slot.indexOf(':');
            properties.setProperty(slot.substring(0, offset).trim(), slot
                    .substring(offset + 1).trim());
        }
        String color = properties.getProperty("color");
        if (color != null) {
            color_ = new CSSColor(color);
        }
        String background = properties.getProperty("background");
        if (background != null) {
            backgroundColor_ = new CSSColor(background);
        }
        String width = properties.getProperty("width");
        if (width != null) {
            width_ = new CSSLength(width);
        }
        String height = properties.getProperty("height");
        if (height != null) {
            height_ = new CSSLength(height);
        }
        try {
            String scale = properties.getProperty("scale");
            if (scale != null) {
                scale_ = Float.parseFloat(scale);
            }
        } catch (NumberFormatException e) {
        }
        try {
            String rotate = properties.getProperty("rotate");
            if (rotate != null) {
                rotate_ = Float.parseFloat(rotate);
            }
        } catch (NumberFormatException e) {
        }
        font_ = CSSFont.create(properties);
        textAlign_ = properties.getProperty("text-align");
        floatStyle_ = properties.getProperty("float");
        listStyleType_ = properties.getProperty("list-style-type");
    }

    public String getText() {
        return (text_);
    }

    public CSSColor getColor() {
        return (color_);
    }

    public CSSColor getBackgroundColor() {
        return (backgroundColor_);
    }

    public CSSLength getWidth() {
        return (width_);
    }

    public CSSLength getHeight() {
        return (height_);
    }

    public CSSFont getFont() {
        return (font_);
    }

    public String getTextAlign() {
        return (textAlign_);
    }

    public String getFloat() {
        return (floatStyle_);
    }
    
    public String getListStyleType() {
        return (listStyleType_);
    }
}