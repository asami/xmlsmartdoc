/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2005  ASAMI, Tomoharu (asami@xmlsmartdoc.org)
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

package org.xmlsmartdoc.SmartDoc.normalizer;

import java.util.ArrayList;
import java.util.List;

import jp.gr.java_conf.ccs2.tool.tex2sdoc.math.TeX2MathMLException;
import jp.gr.java_conf.ccs2.tool.tex2sdoc.math.TeX2MathMLForSmartDoc;

import org.w3c.dom.Element;
import org.xmlsmartdoc.SmartDoc.CharBlock;
import org.xmlsmartdoc.SmartDoc.Container;
import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.DocContext;
import org.xmlsmartdoc.SmartDoc.Equation;
import org.xmlsmartdoc.SmartDoc.ExternalElement;
import org.xmlsmartdoc.SmartDoc.Native;
import org.xmlsmartdoc.SmartDoc.UDoc;

/**
 * TeX2MathMLNormalizer
 * 
 * @since   Jan. 15, 2001
 * @version Jul. 31, 2005
 * @author ASAMI, Tomoharu (asami@xmlsmartdoc.org)
 */
public class TeX2MathMLNormalizer extends AbstractNormalizer {
    protected Content[] _normalize(Content[] contents, Content parent,
        DocContext context) {
        Content[] exprs = _findMathML(contents);
        if (exprs != null) {
            return (exprs);
        } else if ("latex2e".equals(context.getFormat())) {
            return (_makeTeX(parent));
        } else if ("pdf".equals(context.getFormat())) {
            return (_makeTeX(parent));
        } else if ("plain".equals(context.getFormat())) {
            return (_makePlain(parent));
        } else {
            return (_makeMathML(parent));
        }
    }

    private Content[] _findMathML(Content[] contents) {
        List list = new ArrayList();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof ExternalElement) {
                Element element = ((ExternalElement)content).getElement();
                String uri = element.getNamespaceURI();
                if ("http://www.w3.org/1998/Math/MathML".equals(uri)) {
                    list.add(content);
                }
            }
        }
        if (list.size() == 0) {
            return (null);
        }
        Content[] result = new Content[list.size()];
        return ((Content[])list.toArray(result));
    }

    private Content[] _makeTeX(Content parent) {
        String text = UDoc.makeInlineText((Container)parent);
        TeX2MathMLForSmartDoc engine = new TeX2MathMLForSmartDoc();
        text = engine.normalize(text);
        if (UDoc.isAncestor(parent, Equation.class)) {
            // do nothing
        } else {
            text = "$" + text + "$";
        }
        Native n = new Native();
        n.addContent(new CharBlock(text));
        return (new Content[] { n });
    }

    private Content[] _makePlain(Content parent) {
        String text = UDoc.makeInlineText((Container)parent);
        Native n = new Native();
        n.addContent(new CharBlock(text));
        return (new Content[] { n });
    }

    private Content[] _makeMathML(Content parent) {
        try {
            String text = UDoc.makeInlineText((Container)parent);
            TeX2MathMLForSmartDoc engine = new TeX2MathMLForSmartDoc();
            System.err.println("TeX:" + text);
            String code = engine.translate(engine.normalize(text));
            //	    String code = engine.translate(text);
            Native n = new Native();
            n.addContent(new CharBlock(code));
            return (new Content[] { n });
        } catch (TeX2MathMLException e) {
            e.printStackTrace();
        }
        return (null);
    }

    /*
     * private Content[] _makeMathML(Content parent) { try { String text =
     * UDoc.makeInlineText((Container)parent); TeX2MathML engine = new
     * TeX2MathML(); String code = engine.translate(text); IProcessor processor =
     * ProcessorFactory.getProcessor(); Document doc =
     * processor.parseDocumentByText(code); Element math =
     * doc.getDocumentElement(); ExternalElement result = new
     * ExternalElement(math); return (new Content[] { result }); } catch
     * (ParseException e) { e.printStackTrace(); } catch (IOException e) {
     * e.printStackTrace(); } return (null); }
     */
}