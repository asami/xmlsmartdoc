/*
 * SmartDoc : Ultimate document format based on XML
 *	Copyright (C) 1998-2004	 ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.	 See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.xmlsmartdoc.SmartDoc.normalizer;

import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import com.AsamiOffice.text.UString;
import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.normalizer.hilight.*;

/**
 * HilightNormalizer
 *
 * @author	SAKURAI, Masashi (m.sakurai@dream.com)
 */
public class HilightNormalizer extends AbstractNormalizer {

	protected static HashMap hilightMakerMap = new HashMap();

	protected static HilightData hilightData = null;

	protected Content[] _normalize(Content[] contents,Content parent,
								   DocContext context ) {
		String syntaxType = 
			UString.checkNull(parent.getAttribute("syntaxType"));
		if (syntaxType != null) {
			String text = UDoc.makeInlineText((Container)parent);
			parent.setText(null);	// XXX
			List list = new ArrayList();
			makeHilight(text,list,syntaxType);
			return (UDoc.list2Contents(list));
		} else {
			return contents;
		}
	}

	protected void makeHilight(String text,List list,
									  String syntaxType) {
		HilightMaker maker = getHilightMaker(syntaxType);
		if (maker != null) {
			maker.makeHilight(text,list);
		}
	}

	protected HilightMaker getHilightMaker(String syntaxType) {
		HilightMaker maker = (HilightMaker)hilightMakerMap.get(syntaxType);
		if (maker == null) {
			Syntax syntax = getSyntax(syntaxType);
			if (syntax == null) {
				USmartDoc.warning("no such hilight-syntax: " + syntaxType);
				return null;
			}
			maker = new HilightMaker(syntax);
			hilightMakerMap.put(syntaxType,maker);
		}
		return maker;
	}

	protected Syntax getSyntax(String name) {
		HilightData data = getHilightData(this);
		//System.out.println("HS:["+data.getSyntaxCount()+"]");
		for (int i=0;i<data.getSyntaxCount();i++) {
			Syntax syntax = data.getSyntax(i);
			//System.out.println("HNAME:["+syntax.getName()+"]");
			if (syntax.getName().equals(name)) {
				return syntax;
			}
		}
		return null;
	}

	protected static HilightData getHilightData(HilightNormalizer me) {
		if (hilightData == null) {
			try {
				hilightData = new HilightData(me.getClass().getResource("/org/xmlsmartdoc/SmartDoc/normalizer/hilight/hilightData.xml"));
			} catch (SAXException e) {
				throw new SmartDocErrorException(e);
			} catch (ParserConfigurationException e) {
				throw new SmartDocErrorException(e);
			} catch (IOException e) {
				throw new SmartDocErrorException(e);
			}
		}
		return hilightData;
	}

}

