/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.smartdoc;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.parsers.ParserConfigurationException;

import org.relaxer.framework.runtime.model.AbstractRTreeModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.w3c.dom.Document;

import com.AsamiOffice.xml.XMLMaker;
import com.AsamiOffice.xml.visitor.UDOMVisitor;

/**
 * SmartDocModel
 *
 * @since   Sep. 27, 2005
 * @version Sep. 30, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class SmartDocModel extends AbstractRTreeModel {
    public SmartDocModel(IRModelContext context) throws RModelException {
        super(context);
    }

    public SmartDocModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

    protected void _commitAlways_tree() throws RModelException {
        SmartDocMaker maker = new SmartDocMaker(getName());
        traverse(maker);
        OutputStream out = null;
        Writer writer = null;
        try {
            out = _getDataSource().openOutputStream();
            writer = new OutputStreamWriter(out, "UTF-8");
            writeXml_(writer, maker);
            writer.flush();
        } catch (IOException e) {
            throw new RModelException(e);
        } catch (ParserConfigurationException e) {
            throw new RModelException(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RModelException(e);
                }
            } else if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RModelException(e);
                }
            }
        }
    }

    private void writeXml_(Writer writer, SmartDocMaker maker) throws ParserConfigurationException, IOException {
        maker.write(writer);
    }    

    private void writeXml0_(Writer writer, SmartDocMaker maker) throws ParserConfigurationException {
        Document doc = maker.make();
        XMLMaker xmlMaker = new XMLMaker(writer);
        xmlMaker.setVisual(true);
        xmlMaker.setEmptyElementTag(true);
        UDOMVisitor.traverse(doc, xmlMaker);
    }

    public Cursor getCursor() throws RModelException {
        return new Cursor();
    }

    public class Cursor {
        private IRTreeModelNode current_;

        public Cursor() throws RModelException {
            current_ = getRoot();
        }

        public void enterDivision(String name) throws RModelException {
            DivisionNode node = new DivisionNode(name, SmartDocModel.this);
            current_.addChild(node);
            current_ = node;
        }

        public void leaveDivision() throws RModelException {
            current_ = current_.getParent();
        }

        public MapNode addMapNode() throws RModelException {
            MapNode map = new MapNode(SmartDocModel.this);
            current_.addChild(map);
            return map;
        }

        public TableNode addTableNode() throws RModelException {
            TableNode table = new TableNode(SmartDocModel.this);
            current_.addChild(table);
            return table;
        }
    }
}
