package org.relaxer.framework.xexpr;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import com.AsamiOffice.xml.visitor.DOMVisitorBase;
import com.AsamiOffice.xml.visitor.DOMVisitorException;
import com.AsamiOffice.xml.visitor.UDOMVisitor;

/**
 * XExprMaker
 *
 * @since   Sep. 20, 2005
 * @version Sep. 23, 2005
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class XExprMaker {
    private final Document doc_;

    public XExprMaker(Document doc) {
        doc_ = doc;
    }

    public String getText() {
        Maker maker = new Maker();
        UDOMVisitor.traverse(doc_, maker);
        return maker.make();
    }

    class Maker extends DOMVisitorBase {
        public boolean enter(Element element) {
            throw new UnsupportedOperationException("Maker.enter");
        }

        public boolean enter(Text text) {
            throw new UnsupportedOperationException("Maker.enter");
        }

        public void leave(Element element) {
            throw new UnsupportedOperationException("Maker.leave");
        }

        public void stay(Element node, Node prev, Node next) throws DOMVisitorException {
            throw new UnsupportedOperationException("Maker.stay");
        }

        public String make() {
            throw new UnsupportedOperationException("Maker.make");
        }
    }
}
