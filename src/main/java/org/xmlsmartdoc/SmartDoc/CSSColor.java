/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998,1999  ASAMI, Tomoharu (tasami@ibm.net)
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

/**
 * CSSColor
 *
 * @since   Jan. 10, 1999
 * @version Mar. 24, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class CSSColor {
    protected int red_;
    protected int green_;
    protected int blue_;
    protected String name_ = null;

    public CSSColor(int red, int green, int blue) {
	red_ = red;
	green_ = green;
	blue_ = blue;
    }

    public CSSColor(String name) throws IllegalArgumentException {
	if (name.startsWith("#")) {
	    try {
		int rgb = Integer.parseInt(name.substring(1), 16);
		red_ = (rgb >> 16) & 0xff;
		green_ = (rgb >> 8) & 0xff;
		blue_ = rgb & 0xff;
	    } catch (NumberFormatException e) {
		USmartDoc.warning("bad format : " + name);
	    }
	} else {
	    Entry entry = (Entry)entryByName__.get(name);
	    if (entry == null) {
		USmartDoc.warning("bad format : " + name);
	    }
	    name_ = name;
	    red_ = entry.red;
	    green_ = entry.green;
	    blue_ = entry.blue;
	}
    }

    public int getRed() {
	return (red_);
    }

    public int getGreen() {
	return (green_);
    }

    public int getBlue() {
	return (blue_);
    }

    public int getRgb() {
	return ((red_ << 16) + (green_ << 8) + blue_);
    }

    protected static Entry[] entries__;
    protected static Map entryByName__ = new HashMap();

    {
	List entries = new ArrayList();
	entries.add(new Entry("white", 0xff, 0xff, 0xff));
	entries.add(new Entry("whitesmoke", 0xf5, 0xf5, 0xf5));
	entries.add(new Entry("gainsboro", 0xdc, 0xdc, 0xdc));
	entries.add(new Entry("lightgrey", 0xd3, 0xd3, 0xd3));
	entries.add(new Entry("silver", 0xc0, 0xc0, 0xc0));
	entries.add(new Entry("darkgray", 0xa9, 0xa9, 0xa9));
	entries.add(new Entry("gray", 0x80, 0x80, 0x80));
	entries.add(new Entry("dimgray", 0x69, 0x69, 0x69));
	entries.add(new Entry("black", 0x00, 0x00, 0x00));
	entries.add(new Entry("snow", 0xff, 0xfa, 0xfa));
	entries.add(new Entry("ghostwhite", 0xf8, 0xf8, 0xff));
	entries.add(new Entry("mintcream", 0xf5, 0xff, 0xfa));
	entries.add(new Entry("azure", 0xf0, 0xff, 0xff));
	entries.add(new Entry("ivory", 0xff, 0xff, 0xf0));
	entries.add(new Entry("floralwhite", 0xff, 0xfa, 0xf0));
	entries.add(new Entry("aliceblue", 0xf0, 0xf8, 0xff));
	entries.add(new Entry("lavenderblush", 0xff, 0xf0, 0xf5));
	entries.add(new Entry("seashell", 0xff, 0xf5, 0xee));
	entries.add(new Entry("honeydew", 0xf0, 0xff, 0xf0));
	entries.add(new Entry("lightyellow", 0xff, 0xff, 0xe0));
	entries.add(new Entry("lightcyan", 0xe0, 0xff, 0xff));
	entries.add(new Entry("oldlace", 0xfd, 0xf5, 0xe6));
	entries.add(new Entry("cornsilk", 0xff, 0xf8, 0xdc));
	entries.add(new Entry("linen", 0xfa, 0xf0, 0xe6));
	entries.add(new Entry("lemonchiffon", 0xff, 0xfa, 0xcd));
	entries.add(new Entry("lavender", 0xe6, 0xe6, 0xfa));
	entries.add(new Entry("beige", 0xf5, 0xf5, 0xdc));
	entries.add(new Entry("lightgoldenrodyellow", 0xfa, 0xfa, 0xd2));
	entries.add(new Entry("mistyrose", 0xff, 0xe4, 0xe1));
	entries.add(new Entry("papayawhip", 0xff, 0xef, 0xd5));
	entries.add(new Entry("antiquewhite", 0xfa, 0xeb, 0xd7));
	entries.add(new Entry("pink", 0xff, 0xc0, 0xcb));
	entries.add(new Entry("lightpink", 0xff, 0xb6, 0xc1));
	entries.add(new Entry("hotpink", 0xff, 0x69, 0xb4));
	entries.add(new Entry("orchid", 0xda, 0x70, 0xd6));
	entries.add(new Entry("palevioletred", 0xdb, 0x70, 0x93));
	entries.add(new Entry("deeppink", 0xff, 0x14, 0x93));
	entries.add(new Entry("mediumvioletred", 0xc7, 0x15, 0x85));
	entries.add(new Entry("crimson", 0xdc, 0x14, 0x3c));
	entries.add(new Entry("lightcoral", 0xf0, 0x80, 0x80));
	entries.add(new Entry("rosybrown", 0xbc, 0x8f, 0x8f));
	entries.add(new Entry("indianred", 0xcd, 0x5c, 0x5c));
	entries.add(new Entry("brown", 0xa5, 0x2a, 0x2a));
	entries.add(new Entry("firebrick", 0xb2, 0x22, 0x22));
	entries.add(new Entry("red", 0xff, 0x00, 0x00));
	entries.add(new Entry("darkred", 0x8b, 0x00, 0x00));
	entries.add(new Entry("maroon", 0x80, 0x00, 0x00));
	entries.add(new Entry("blanchedalmond", 0xff, 0xeb, 0xcd));
	entries.add(new Entry("bisque", 0xff, 0xe4, 0xc4));
	entries.add(new Entry("moccasin", 0xff, 0xe4, 0xb5));
	entries.add(new Entry("peachpuff", 0xff, 0xda, 0xb9));
	entries.add(new Entry("navajowhite", 0xff, 0xde, 0xad));
	entries.add(new Entry("wheat", 0xf5, 0xde, 0xb3));
	entries.add(new Entry("palegoldenrod", 0xee, 0xe8, 0xaa));
	entries.add(new Entry("khaki", 0xf0, 0xe6, 0x8c));
	entries.add(new Entry("gold", 0xff, 0xd7, 0x00));
	entries.add(new Entry("burlywood", 0xde, 0xb8, 0x87));
	entries.add(new Entry("tan", 0xd2, 0xb4, 0x8c));
	entries.add(new Entry("darkkhaki", 0xbd, 0xb7, 0x6b));
	entries.add(new Entry("sandybrown", 0xf4, 0xa4, 0x60));
	entries.add(new Entry("orange", 0xff, 0xa5, 0x00));
	entries.add(new Entry("lightsalmon", 0xff, 0xa0, 0x7a));
	entries.add(new Entry("darksalmon", 0xe9, 0x96, 0x7a));
	entries.add(new Entry("goldenrod", 0xda, 0xa5, 0x20));
	entries.add(new Entry("salmon", 0xfa, 0x80, 0x72));
	entries.add(new Entry("darkorange", 0xff, 0x8c, 0x00));
	entries.add(new Entry("coral", 0xff, 0x7f, 0x50));
	entries.add(new Entry("peru", 0xcd, 0x85, 0x3f));
	entries.add(new Entry("tomato", 0xff, 0x63, 0x47));
	entries.add(new Entry("darkgoldenrod", 0xb8, 0x86, 0x0b));
	entries.add(new Entry("orangered", 0xff, 0x45, 0x00));
	entries.add(new Entry("chocolate", 0xd2, 0x69, 0x1e));
	entries.add(new Entry("sienna", 0xa0, 0x52, 0x2d));
	entries.add(new Entry("saddlebrown", 0x8b, 0x45, 0x13));
	entries.add(new Entry("yellow", 0xff, 0xff, 0x00));
	entries.add(new Entry("olive", 0x80, 0x80, 0x00));
	entries.add(new Entry("greenyellow", 0xad, 0xff, 0x2f));
	entries.add(new Entry("chartreuse", 0x7f, 0xff, 0x2f));
	entries.add(new Entry("lawngreen", 0x7c, 0xfc, 0x00));
	entries.add(new Entry("yellowgreen", 0x9a, 0xcd, 0x32));
	entries.add(new Entry("olivedrab", 0x6b, 0x8e, 0x23));
	entries.add(new Entry("darkolivegreen", 0x55, 0x6b, 0x2f));
	entries.add(new Entry("palegreen", 0x98, 0xfb, 0x98));
	entries.add(new Entry("lightgreen", 0x90, 0xee, 0x90));
	entries.add(new Entry("lime", 0x00, 0xff, 0x00));
	entries.add(new Entry("darkseagreen", 0x8f, 0xbc, 0x8f));
	entries.add(new Entry("limegreen", 0x32, 0xcd, 0x32));
	entries.add(new Entry("forestgreen", 0x22, 0x8b, 0x22));
	entries.add(new Entry("green", 0x00, 0x80, 0x00));
	entries.add(new Entry("darkgreen", 0x00, 0x64, 0x00));
	entries.add(new Entry("aquamarine", 0x7f, 0xff, 0xd4));
	entries.add(new Entry("honeydewtab", 0x1e, 0xde, 0xaa));
	entries.add(new Entry("mediumaquamarine", 0x66, 0xcd, 0xaa));
	entries.add(new Entry("mediumturquoise", 0x48, 0xd1, 0xcc));
	entries.add(new Entry("mediumspringgreen", 0x00, 0xfa, 0x9a));
	entries.add(new Entry("springgreen", 0x00, 0xff, 0x7f));
	entries.add(new Entry("turquoise", 0x40, 0xe0, 0xd0));
	entries.add(new Entry("lightseagreen", 0x20, 0xb2, 0xaa));
	entries.add(new Entry("seagreen", 0x2e, 0x8b, 0x57));
	entries.add(new Entry("mediumseagreen", 0x3c, 0xb3, 0x71));
	entries.add(new Entry("paleturquoise", 0xaf, 0xee, 0xee));
	entries.add(new Entry("cyan", 0x00, 0xff, 0xff));
	entries.add(new Entry("aqua", 0x00, 0xff, 0xff));
	entries.add(new Entry("darkcyan", 0x00, 0x8b, 0x8b));
	entries.add(new Entry("teal", 0x00, 0x80, 0x80));
	entries.add(new Entry("darkslategray", 0x2f, 0x4f, 0x4f));
	entries.add(new Entry("powderblue", 0xb0, 0xe0, 0xe6));
	entries.add(new Entry("lightblue", 0xad, 0xd8, 0xe6));
	entries.add(new Entry("lightsteelblue", 0xb0, 0xc4, 0xde));
	entries.add(new Entry("lightskyblue", 0x87, 0xce, 0xfa));
	entries.add(new Entry("skyblue", 0x87, 0xce, 0xeb));
	entries.add(new Entry("deepskyblue", 0x00, 0xbf, 0xff));
	entries.add(new Entry("darkturquoise", 0x00, 0xce, 0xd1));
	entries.add(new Entry("cornflowerblue", 0x64, 0x95, 0xed));
	entries.add(new Entry("cadetblue", 0x5f, 0x9e, 0xa0));
	entries.add(new Entry("dodgerblue", 0x1e, 0x90, 0xff));
	entries.add(new Entry("lightslategray", 0x77, 0x88, 0x99));
	entries.add(new Entry("slategray", 0x70, 0x80, 0x90));
	entries.add(new Entry("royalblue", 0x41, 0x69, 0xe1));
	entries.add(new Entry("steelblue", 0x46, 0x82, 0xb4));
	entries.add(new Entry("blue", 0x00, 0x00, 0xff));
	entries.add(new Entry("mediumblue", 0x00, 0x00, 0xcd));
	entries.add(new Entry("darkblue", 0x00, 0x00, 0x8b));
	entries.add(new Entry("navy", 0x00, 0x00, 0x80));
	entries.add(new Entry("midnightblue", 0x19, 0x19, 0x70));
	entries.add(new Entry("mediummorchid", 0xba, 0x55, 0xd3));
	entries.add(new Entry("mediumpurple", 0x93, 0x70, 0xdb));
	entries.add(new Entry("mediumslateblue", 0x7b, 0x68, 0xee));
	entries.add(new Entry("slateblue", 0x6a, 0x5a, 0xcd));
	entries.add(new Entry("blueviolet", 0x8a, 0x2b, 0xe2));
	entries.add(new Entry("darkviolet", 0x94, 0x00, 0xd3));
	entries.add(new Entry("darkorchid", 0x99, 0x32, 0xcc));
	entries.add(new Entry("darkslateblue", 0x48, 0x3d, 0x8b));
	entries.add(new Entry("indigo", 0x4b, 0x00, 0x82));
	entries.add(new Entry("thistle", 0xd8, 0xbf, 0xd8));
	entries.add(new Entry("plum", 0xdd, 0xa0, 0xdd));
	entries.add(new Entry("violet", 0xee, 0x82, 0xee));
	entries.add(new Entry("magenta", 0xff, 0x00, 0xff));
	entries.add(new Entry("fuchsia", 0xff, 0x00, 0xff));
	entries.add(new Entry("darkmagenta", 0x8b, 0x00, 0x8b));
	entries.add(new Entry("purple", 0x80, 0x00, 0x80));

	entries__ = new Entry[entries.size()];
	entries.toArray(entries__);

	for (int i = 0;i < entries__.length;i++) {
	    Entry entry = entries__[i];
	    entryByName__.put(entry.name, entry);
	}
    }

    static class Entry {
	public Entry(String name, int red, int green, int blue) {
	    this.name = name;
	    this.red = red;
	    this.green = green;
	    this.blue = blue;
	}

	String name;
	int red;
	int green;
	int blue;
    }
}
