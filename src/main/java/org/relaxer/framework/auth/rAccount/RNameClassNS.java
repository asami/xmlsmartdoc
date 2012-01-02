package org.relaxer.framework.auth.rAccount;

import java.util.*;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.*;

/**
 * RNameClassNS
 *
 * @since   May. 19, 2002
 * @version May. 17, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class RNameClassNS {
    private Node pattern_;
    private String ns_;

    public RNameClassNS(String config, String ns) {
	try {
	    Document doc = UJAXP.getDocument(new StringReader(config));
	    ns_ = ns;
	    pattern_ = _makePattern(doc.getDocumentElement());
	} catch (IOException e) {
	    throw (new IllegalArgumentException());
	} catch (SAXException e) {
	    throw (new IllegalArgumentException());
	} catch (ParserConfigurationException e) {
	    throw (new IllegalArgumentException());
	}
    }

    private Node _makePattern(Element element) {
	String tagName = element.getTagName();
	Node node;
	if ("anyName".equals(tagName)) {
	    node = new AnyName();
	} else if ("nsName".equals(tagName)) {
	    Attr attr = element.getAttributeNode("ns");
	    if (attr != null) {
		node = new NsName(attr.getValue());
	    } else {
		node = new NsName(ns_);
	    }
	} else if ("name".equals(tagName)) {
	    String name = URelaxer.getElementPropertyAsString(element);
	    Attr attr = element.getAttributeNode("ns");
	    if (attr != null) {
		node = new Name(attr.getValue(), name);
	    } else {
		node = new Name(ns_, name);
	    }
	    return (node);
	} else if ("choice".equals(tagName)) {
	    node = new Choice();
	} else if ("except".equals(tagName)) {
	    node = new Except();
	} else {
	    throw (new IllegalArgumentException());
	}
	Element[] children = URelaxer.getElements(element);
	for (int i = 0;i < children.length;i++) {
	    node.addChild(_makePattern(children[i]));
	}
	return (node);
    }

    public boolean isMatchElement(Element element) {
	String ns = element.getNamespaceURI();
	if (ns == null) {
	    ns = "";
	}
	return (pattern_.eval(ns, element.getLocalName()));
    }

/*
    public boolean isMatchAttribute(Element element, String name) {
	return (
	    pattern_.eval(
		element.getNamespaceURI(),
		element.getLocalName()
	    )
	);
    }
*/

    public boolean isMatchAttributeHungry(RStack stack) {
	Element element = stack.getContextElement();
	NamedNodeMap attrs = element.getAttributes();
	int size = attrs.getLength();
	for (int i = 0;i < size;i++) {
	    Attr attr = (Attr)attrs.item(i);
	    if ("xmlns".equals(attr.getPrefix())) {
		continue;
	    }
	    if ("xmlns".equals(attr.getName())) {
		continue;
	    }
	    String ns = attr.getNamespaceURI();
	    if (ns == null) {
		ns = "";
	    }
	    if (stack.isConsumedAttribute(attr)) {
		continue;
	    }
	    String attrName = attr.getLocalName();
	    if (pattern_.eval(ns, attrName)) {
		stack.consumeAttribute(attr);
		return (true);
	    }
	}
	return (false);
    }

    public String[] getAttributeHungry(RStack stack) {
	Element element = stack.getContextElement();
	NamedNodeMap attrs = element.getAttributes();
	int size = attrs.getLength();
	for (int i = 0;i < size;i++) {
	    Attr attr = (Attr)attrs.item(i);
	    if ("xmlns".equals(attr.getPrefix())) {
		continue;
	    }
	    String ns = attr.getNamespaceURI();
	    if (ns == null) {
		ns = "";
	    }
	    if (stack.isConsumedAttribute(attr)) {
		continue;
	    }
	    String attrName = attr.getLocalName();
	    if (attrName == null) {
		attrName = attr.getName();
	    }
	    if (pattern_.eval(ns, attrName)) {
		stack.consumeAttribute(attr);
		String[] result = new String[3];
		result[0] = ns;
		result[1] = attrName;
		if ("".equals(ns)) {
		    result[2] = element.getAttribute(attrName);
		} else {
		    result[2] = element.getAttributeNS(ns, attrName);
		}
		return (result);
	    }
	}
	return (null);
    }

    public static class Node {
	protected List children_ = new ArrayList();

	public void addChild(Node child) {
	    children_.add(child);
	}

	public boolean eval(String ns, String local) {
	    if (!_evalBody(ns, local)) {
		return (false);
	    }
	    return (_evalChildren(ns, local));
	}

	protected boolean _evalBody(String ns, String local) {
	    return (true);
	}

	protected boolean _evalChildren(String ns, String local) {
	    int size = children_.size();
	    for (int i = 0;i < size;i++) {
		Node node = (Node)children_.get(i);
		if (!node.eval(ns, local)) {
		    return (false);
		}
	    }
	    return (true);
	}
    }

    public static class AnyName extends Node {
    }

    public static class NsName extends Node {
	private String ns_;

	public NsName(String ns) {
	    ns_ = ns;
	}

	protected boolean _evalBody(String ns, String local) {
	    return (ns_.equals(ns));
	}
    }

    public static class Name extends Node {
	private String ns_;
	private String name_;

	public Name(String ns, String name) {
	    ns_ = ns;
	    name_ = name;
	}

	protected boolean _evalBody(String ns, String local) {
	    return (ns_.equals(ns) && name_.equals(local));
	}
    }

    public static class Choice extends Node {
	public boolean eval(String ns, String local) {
	    int size = children_.size();
	    for (int i = 0;i < size;i++) {
		Node node = (Node)children_.get(i);
		if (node.eval(ns, local)) {
		    return (true);
		}
	    }
	    return (false);
	}	    
    }

    public static class Except extends Node {
	protected boolean _evalChildren(String ns, String local) {
	    int size = children_.size();
	    for (int i = 0;i < size;i++) {
		Node node = (Node)children_.get(i);
		if (node.eval(ns, local)) {
		    return (false);
		}
	    }
	    return (true);
	}
    }
}
