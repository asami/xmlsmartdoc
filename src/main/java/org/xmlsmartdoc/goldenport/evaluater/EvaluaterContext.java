/*
 * org.xmlsmartdoc.goldenport
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.xmlsmartdoc.goldenport.evaluater;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xmlsmartdoc.goldenport.evaluater.pattern.ExprPattern;
import org.xmlsmartdoc.goldenport.evaluater.pattern.IPattern;

import com.AsamiOffice.xml.UDOM;

/**
 * EvaluaterContext
 *
 * @since   Apr.  9, 2004
 * @version Apr. 12, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class EvaluaterContext {
    // Map<String, Atom>
    private Map atoms_ = new HashMap();
    private EvaluaterContext parent_;

    public EvaluaterContext() {
    }

    public EvaluaterContext(EvaluaterContext ec) {
        parent_ = ec;        
    }

    public void setup(Node[] nodes) {
        for (int i = 0;i < nodes.length;i++) {
            setup(nodes[i]);
        }
    }

    public void setup(Node node) {
        if (node instanceof Document) {
            node = ((Document)node).getDocumentElement();
        }
        setupDefineSet_(node);
        setupDefine_(node);
    }
    
    private void setupDefineSet_(Node node) {
        Element[] macros = UDOM.getElements(
            node,
            "http://www.xmlsmartdoc.org/xmlns/goldenport",
            "goldenport"
        );
        for (int i = 0; i < macros.length; i++) {
            addDefineSet_(macros[i]);
        }
        macros = UDOM.getElements( // compatibility
            node,
            "http://www.xmlsmartdoc.org/xmlns/goldenport",
            "macro"
        );
        for (int i = 0; i < macros.length; i++) {
            addDefineSet_(macros[i]);
        }
        macros = UDOM.getElements( // compatibility
            node,
            "http://www.relaxer.org/xmlns/goldenport",
            "macro"
        );
        for (int i = 0; i < macros.length; i++) {
            addDefineSet_(macros[i]);
        }
        macros = UDOM.getElements( // compatibility
            node,
            "http://www.relaxer.org/xmlns/goldenport",
            "goldenport"
        );
        for (int i = 0; i < macros.length; i++) {
            addDefineSet_(macros[i]);
        }
    }

    private void addDefineSet_(Element macro) {
        String uri = macro.getAttribute("src");
        if (!"".equals(uri)) {
            try {
                Document doc = UDOM.loadDocumentNs(uri);
                Element root = doc.getDocumentElement();
                //System.out.println(root.getLocalName());
                if ("macro".equals(root.getLocalName())) {
                    addDefineSet_(root);
                } else if ("goldenport".equals(root.getLocalName())) {
                    addDefineSet_(root);
                }
            } catch (IOException e) {
            } catch (ParserConfigurationException e) {
            } catch (SAXException e) {
            }
        }
        setupDefine_(macro);
    }

    private void setupDefine_(Node node) {
        Element[] defines = UDOM.getElements(
            node,
            "http://www.xmlsmartdoc.org/xmlns/goldenport",
            "define"
        );
        for (int i = 0; i < defines.length; i++) {
            Element define = defines[i];
            addDefine_(define);
        }
        defines = UDOM.getElements( // compatibility
            node,
            "http://www.relaxer.org/xmlns/goldenport",
            "define"
        );
        for (int i = 0; i < defines.length; i++) {
            Element define = defines[i];
            addDefine_(define);
        }
        defines = UDOM.getElements( // compatibility
            node,
            "define"
        );
        for (int i = 0; i < defines.length; i++) {
            Element define = defines[i];
            addDefine_(define);
        }
    }

    private void addDefine_(Element define) {
        String name = define.getAttribute("name");
        Atom atom = makeAtom(name);
        atom.setPattern(new ExprPattern(define));
    }

    public Atom makeAtom(String name) {
        Atom atom = getAtom_(name);
        if (atom == null) {
            atom = new Atom(name);
        }
        addAtom(atom);
        return (atom);
    }

    public Atom getAtom(String name) {
        Atom atom = getAtom_(name);
        if (atom != null) {
            return (atom);
        } else if (parent_ != null) {
            return (parent_.getAtom(name));
        } else {
            return (null);
        }
    }
    
    private Atom getAtom_(String name) {
        return ((Atom)atoms_.get(name));
    }

    public void addAtom(Atom atom) {
        atoms_.put(atom.getName(), atom);
    }

    public void addDefine(String name, IPattern pattern) {
        Atom atom = makeAtom(name);
        atom.setPattern(pattern);
    }

    public EvaluaterContext getParent() {
        return (parent_);
    }
}
