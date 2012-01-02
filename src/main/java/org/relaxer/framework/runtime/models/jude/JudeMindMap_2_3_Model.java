/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.jude;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.relaxer.framework.RelaxerFrameworkErrorException;
import org.relaxer.framework.runtime.model.AbstractRTreeModel;
import org.relaxer.framework.runtime.model.AbstractRTreeModelNode;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.IRTreeModel;
import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.AsamiOffice.xml.UDOM;

/**
 * JudeMindMapModel
 *
 * @since   Aug. 16, 2005
 * @version Aug. 19, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class JudeMindMap_2_3_Model extends AbstractRTreeModel {
    public static final String JUDE_NS = "http://objectclub.esm.co.jp/Jude/namespace/";

    public JudeMindMap_2_3_Model(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

    protected void _open_tree() throws RModelException {
        try {
            IRDataSource ds = _getDataSource();
            Document doc = ds.getDocument();
            Element root = doc.getDocumentElement();
            if (!"XMI".equals(root.getTagName())) {
                throw new RelaxerFrameworkErrorException();
            }
            NodeList maps = root.getElementsByTagNameNS(JUDE_NS, "MindMap");
            int size = maps.getLength();
            if (size == 0) {
                throw new RelaxerFrameworkErrorException();
            }
            build_((Element)maps.item(0)); // TODO
        } catch (SAXException e) {
            throw new RModelException(e);
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

    private void build_(Element element) throws RModelException {
        Element presentations = UDOM.getFirstElement(element, JUDE_NS, "MindMap.presentations");
        Element topic = UDOM.getFirstElement(presentations, JUDE_NS, "MMTopicPresentation");
        String label = topic.getAttribute("label");
        setName(decode_(label));
        build_(_root, topic);
    }

    private void build_(IRTreeModelNode target, Element source) throws RModelException {
        Element childrenNode = UDOM.getFirstElement(source, JUDE_NS, "MMTopicPresentation.children");
        if (childrenNode == null) {
            return;
        }
        Element[] children = UDOM.getElements(childrenNode, JUDE_NS, "MMTopicPresentation");
        for (int i = 0;i < children.length;i++) {
            Element child = children[i];
            String label = child.getAttribute("label");
            IRTreeModelNode topic = target.addNode(decode_(label));
            build_(topic, child);
        }
    }

    private String decode_(String label) throws RModelException {
        if (label.indexOf('%') == -1 &&
                label.indexOf('+') == -1) {
            return label;
        }
        char[] chars = label.toCharArray();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int index = 0;
        while (index < chars.length) {
            char c = chars[index++];
            if (c == '%') {
                byte high = getByte_(chars[index++]);
                byte low = getByte_(chars[index++]); 
                int value = (high << 4) + low;
                out.write(value);
            } else if (c == '+') {
                out.write(' ');
            } else {
                out.write(c);
            }
        }
        try {
            byte[] bytes = out.toByteArray();
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RModelException(e);
        }
    }

    private byte getByte_(char c) {
        switch (c) {
        case '0':
            return 0;
        case '1':
            return 1;
        case '2':
            return 2;
        case '3':
            return 3;
        case '4':
            return 4;
        case '5':
            return 5;
        case '6':
            return 6;
        case '7':
            return 7;
        case '8':
            return 8;
        case '9':
            return 9;
        case 'A':
        case 'a':
            return 10;
        case 'B':
        case 'b':
            return 11;
        case 'C':
        case 'c':
            return 12;
        case 'D':
        case 'd':
            return 13;
        case 'E':
        case 'e':
            return 14;
        case 'F':
        case 'f':
            return 15;
        default:
            throw new RelaxerFrameworkErrorException();
        }
    }
}
