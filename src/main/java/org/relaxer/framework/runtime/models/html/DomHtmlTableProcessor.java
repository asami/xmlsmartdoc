package org.relaxer.framework.runtime.models.html;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.AsamiOffice.util.ArrayMap;
import com.AsamiOffice.xml.sax.DOMSAXProducer;
import com.AsamiOffice.xml.visitor.DOMVisitorBase;
import com.AsamiOffice.xml.visitor.DOMVisitorException;

/**
 * HtmlTableProcessor
 *
 * @since   Sep.  7, 2005
 * @version Sep. 14, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class DomHtmlTableProcessor extends DOMVisitorBase {
    private ArrayMap tables_ = new ArrayMap();

    public boolean enter(Element element) {
        String localName = getLocalName_(element);
        if ("table".equals(localName)) {
            HtmlTableBuilder builder = new HtmlTableBuilder();
            DOMSAXProducer producer = new DOMSAXProducer(element);
            producer.setContentHandler(builder);
            try {
                producer.makeEvent();
                tables_.put(element, builder.getHtmlTable());
            } catch (SAXException e) {
                throw new DOMVisitorException(e);
            }
            return false;
        } else {
            return true;
        }
    }

    private String getLocalName_(Element element) {
        String name = element.getLocalName();
        if (name == null) {
            name = element.getTagName();
        }
        return name.toLowerCase();
    }

    public HtmlTable[] getHtmlTables() {
        HtmlTable[] result = new HtmlTable[tables_.size()];
        return (HtmlTable[])tables_.toValueArray(result);
    }
}
