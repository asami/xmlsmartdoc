package org.relaxer.framework.runtime.models.smartdoc;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.relaxer.framework.RelaxerFrameworkErrorException;
import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.IRTreeModelVisitor;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.value.IRTable;
import org.relaxer.framework.runtime.value.IRTree;
import org.relaxer.vocabulary.smartdoc_1_0.SDDl;
import org.relaxer.vocabulary.smartdoc_1_0.SDDoc;
import org.relaxer.vocabulary.smartdoc_1_0.SDHead;
import org.relaxer.vocabulary.smartdoc_1_0.SDHeadTitle;
import org.relaxer.vocabulary.smartdoc_1_0.SDSection;
import org.relaxer.vocabulary.smartdoc_1_0.SDSectionBody;
import org.relaxer.vocabulary.smartdoc_1_0.SDSubsection;
import org.relaxer.vocabulary.smartdoc_1_0.SDSubsubsection;
import org.relaxer.vocabulary.smartdoc_1_0.SDTable;
import org.relaxer.vocabulary.smartdoc_1_0.SDUl;
import org.w3c.dom.Document;

/**
 * SmartDocMaker
 *
 * @since   Sep. 29, 2005
 * @version Jan. 25, 2006
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class SmartDocMaker implements IRTreeModelVisitor {
    private SDDoc doc_;
    private SDSectionBody body_;    
    private SDSection section_ = null;
    private SDSubsection subsection_ = null;
    private SDSubsubsection subsubsection_ = null;

    public SmartDocMaker(String title) {
        doc_ = new SDDoc();
        SDHeadTitle headTitle = new SDHeadTitle();
        headTitle.setContent(title);
        SDHead head = new SDHead();
        head.setHeadTitle(headTitle);
        doc_.setHead(head);
        body_ = new SDSectionBody();
        doc_.setContent(body_);
    }

    public Document make() throws ParserConfigurationException {
        return doc_.makeDocument();
    }

    public void write(Writer writer) throws IOException {
        doc_.makeTextElement(writer);
    }

    public boolean start(IRTreeModelNode root) throws RModelException {
        return true;
    }

    public void end(IRTreeModelNode root) throws RModelException {
    }
private static int counter__ = 0;
    public boolean enter(IRTreeModelNode node) throws RModelException {
        System.out.println("enter:" + ++counter__);
        if (node instanceof DivisionNode) {
            enter_((DivisionNode)node);
        } else if (node instanceof ListNode) {
            enter_((ListNode)node);
        } else if (node instanceof MapNode) {
            enter_((MapNode)node);
        } else if (node instanceof NativeNode) {
            enter_((NativeNode)node);
        } else if (node instanceof ParagraphNode) {
            enter_((ParagraphNode)node);
        } else if (node instanceof TableNode) {
            enter_((TableNode)node);
        } else {
            throw new RelaxerFrameworkErrorException();
        }
        return true;
    }
private static int sc__ = 0;
    private void enter_(DivisionNode node) {
        if (section_ == null) {
            section_ = new SDSection();
            section_.setTitle(node.getName());
            body_.addContent(section_);
System.out.println("section(" + sc__++ + ") " + node.getName());
        } else if (subsection_ == null) {
            subsection_ = new SDSubsection();
            subsection_.setTitle(node.getName());
            section_.addContent(subsection_);
        } else if (subsubsection_ == null) {
            subsubsection_ = new SDSubsubsection();
            subsubsection_.setTitle(node.getName());
            subsection_.addContent(subsubsection_);
        } else {
            throw new UnsupportedOperationException("SmartDocMaker.enter_");
        }
    }

    private void enter_(ListNode node) {
        List list = node.getList();
        String[] array = new String[list.size()];
        ListIterator iter = list.listIterator();
        int i = 0;
        while (iter.hasNext()) {
            array[i++] = iter.next().toString();
        }
        SDUl ul = USmartDoc.makeUl(array);
        add_(ul);
    }

    private void add_(SDUl ul) {
        if (subsubsection_ != null) {
            subsubsection_.addContent(ul);
        } else if (subsection_ != null) {
            subsection_.addContent(ul);
        } else if (section_ != null) {
            section_.addContent(ul);
        } else {
            body_.addContent(ul);
        }
    }

    private void enter_(MapNode node) {
        Map map = node.getMap();
        SDDl dl = USmartDoc.makeDl(map);
        add_(dl);
    }

    private void add_(SDDl dl) {
        if (subsubsection_ != null) {
            subsubsection_.addContent(dl);
        } else if (subsection_ != null) {
            subsection_.addContent(dl);
        } else if (section_ != null) {
            section_.addContent(dl);
        } else {
            body_.addContent(dl);
        }
    }

    private void enter_(NativeNode node) {
        throw new UnsupportedOperationException("SmartDocMaker.enter_");
    }

    private void enter_(ParagraphNode node) {
        throw new UnsupportedOperationException("SmartDocMaker.enter_");
    }

    private void enter_(TableNode node) throws RModelException {
        IRTree head = node.getHead();
        IRTable body = node.getBody();
        SDTable table = USmartDoc.makeTable(head, body);
        table.setTitle(node.getTitle());
        addTable_(table);
    }

    private void addTable_(SDTable table) {
        if (subsubsection_ != null) {
            subsubsection_.addContent(table);
        } else if (subsection_ != null) {
            subsection_.addContent(table);
        } else if (section_ != null) {
            section_.addContent(table);
        } else {
            body_.addContent(table);
        }
    }

    public boolean stay(IRTreeModelNode node, int index, IRTreeModelNode prev, IRTreeModelNode next) {
        return true;
    }

    public void leave(IRTreeModelNode node) throws RModelException {
        if (node instanceof DivisionNode) {
            leave_((DivisionNode)node);
        } else if (node instanceof ListNode) {
            leave_((ListNode)node);
        } else if (node instanceof MapNode) {
            leave_((MapNode)node);
        } else if (node instanceof NativeNode) {
            leave_((NativeNode)node);
        } else if (node instanceof ParagraphNode) {
            leave_((ParagraphNode)node);
        } else if (node instanceof TableNode) {
            leave_((TableNode)node);
        } else {
            throw new RelaxerFrameworkErrorException();
        }
        if (true) {
            node.removeChildren(); // XXX
            node.dispose();
        } 
    }

    private void leave_(DivisionNode node) throws RModelException {
        if (subsubsection_ != null) {
            subsubsection_ = null;
        } else if (subsection_ != null) {
            subsection_ = null;
        } else if (section_ != null) {
            section_ = null;
        } else {
            throw new UnsupportedOperationException("SmartDocMaker.leave_");
        }
    }

    private void leave_(ListNode node) {
    }

    private void leave_(MapNode node) {
    }

    private void leave_(NativeNode node) {
    }

    private void leave_(ParagraphNode node) {
    }

    private void leave_(TableNode node) {
    }
}
