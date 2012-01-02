/*
 * org.xmlsmartdoc.goldenport
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.xmlsmartdoc.goldenport.adapters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xmlsmartdoc.goldenport.adapter.AbstractAdapter;
import org.xmlsmartdoc.goldenport.engine.GoldenportException;
import org.xmlsmartdoc.goldenport.engine.PortContext;
import org.xmlsmartdoc.goldenport.engine.PortNodeList;

import com.AsamiOffice.util.UArray;
import com.AsamiOffice.xml.UDOM;

/**
 * SmartDocAdapter
 *
 * @since   Apr. 13, 2004
 * @version Jul.  6, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class SmartDocAdapter extends AbstractAdapter {
    public static final String SMARTDOC_NS = "http://www.xmlsmartdoc.org/xmlns/smartdoc";
    public static final String PROPERTY_ADJUST_IDS = "adjust-ids";

    public SmartDocAdapter() {
    }

    public void endElement(
        Element element,
        PortNodeList halfResult,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException {
        super.endElement(element, halfResult, context, result);
        String ns = element.getNamespaceURI();
        String localName = element.getLocalName();
        if ("pre".equals(localName) ||
            "program".equals(localName) ||
            "console".equals(localName) ||
            "native".equals(localName)) {
            adjustLink_(element, context, result);
        } else {
            importSdoc_(element, context, result);
        }
    }

    private void adjustLink_(
        Element element, 
        PortContext context, 
        PortNodeList result
    ) throws GoldenportException {
        Attr attr = element.getAttributeNode("src");
        if (attr != null) {
            try {
                String uri = attr.getNodeValue();
                uri = context.getAdjustedUri(uri);
                result.setAttribute("src", uri);
            } catch (MalformedURLException e) {
                throw (new GoldenportException(e));
            } finally {
            }
        }        
    }

    private void importSdoc_(
        Element element,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException {
        Attr attr = element.getAttributeNode("src");
        if (attr != null) {
            try {
                String uri = attr.getNodeValue();
                if (!uri.endsWith(".sdoc")) {
                    adjustLink_(element, context, result);
                    return;
                }
                Document doc = context.loadDocument(uri);
                Element root = doc.getDocumentElement();
                Element[] goldenport = UDOM.getElements(root, PORT_NS, "goldenport");
                Element[] oldGoldenport = UDOM.getElements(root, "http://www.relaxer.org/xmlns/goldenport", "macro");
                Element[] heads = UDOM.getElements(root, "head");
                Element[] titles = getLocaledTitles_(heads);
                Element body = UDOM.getFirstElement(root, "body");
                PortContext newContext = new PortContext(context);
                newContext.setBaseUri(uri);
                if (isAdjustIds_()) {
                    adjustIds_(body, newContext);
                }
                insertElements_(body, goldenport);
                insertElements_(body, oldGoldenport);
                Node evaluated = context.getEngine().executeAdapters(body, newContext);
                result.addChildren(titles);
                result.addChildren(evaluated);
                result.removeAttribute("src");
            } catch (SAXException e) {
                throw (new GoldenportException(e));
            } catch (IOException e) {
                throw (new GoldenportException(e));
            }
        }
    }

    private boolean isAdjustIds_() {
        return (getBooleanProperty(PROPERTY_ADJUST_IDS, true));
    }

    private Element[] getLocaledTitles_(Element[] heads) {
        List list = new ArrayList();
        for (int i = 0;i < heads.length;i++) {
            getLocaledTitles_(heads[i], list);
        }
        Element[] result = new Element[list.size()];
        return ((Element[])list.toArray(result));
    }

    private void getLocaledTitles_(Element head, List list) {
        Attr locale = head.getAttributeNode("locale");
        Element[] titles = UDOM.getElements(head, "title");
        if (locale != null) {
            String value = locale.getNodeValue(); 
            for (int i = 0;i < titles.length;i++) {
                Element title = titles[i];
                Attr titleLocale = title.getAttributeNode("locale");
                if (titleLocale == null) {
                    title.setAttribute("locale", value);
                }
                list.add(title);
            }
        } else {
            UArray.addAll(list, titles);
        }
    }

    private void insertElements_(Element body, Element[] children) {
        Element first = UDOM.getFirstElement(body);
        for (int i = 0;i < children.length;i++) {
            body.insertBefore(children[i], first);
        }
    }

    private void adjustIds_(Element element, PortContext newContext) {
        if ("true".equals(element.getAttribute("id.absolute"))) {
            return;
        }
        Attr attr = element.getAttributeNode("id");
        if (attr != null) {
            attr.setNodeValue(newContext.getAdjustedId(attr.getNodeValue()));
        }
        attr = element.getAttributeNode("idref");
        if (attr != null) {
            attr.setNodeValue(newContext.getAdjustedId(attr.getNodeValue()));
        }
        attr = element.getAttributeNode("href");
        if (attr != null) {
            String value = attr.getNodeValue();
            if (value.startsWith("#")) {
                value = value.substring(1);
                attr.setNodeValue("#" + newContext.getAdjustedId(value));
            }
        }
        Element[] children = UDOM.getElements(element);
        for (int i = 0;i < children.length;i++) {
            adjustIds_(children[i], newContext);
        }
    }
}
