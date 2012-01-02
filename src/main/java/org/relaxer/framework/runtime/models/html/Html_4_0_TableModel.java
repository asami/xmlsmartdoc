/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.html;

import java.io.BufferedWriter;
import java.io.IOException;

import org.cyberneko.html.parsers.DOMParser;
import org.relaxer.framework.runtime.model.AbstractRTableModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;
import org.relaxer.framework.runtime.models.workspace.WorkspaceBag;
import org.relaxer.framework.runtime.models.workspace.WorkspaceContent;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.AsamiOffice.xml.visitor.UDOMVisitor;

/**
 * HtmlTableModel
 *
 * @since   Aug. 16, 2005
 * @version Sep. 15, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class Html_4_0_TableModel extends AbstractRTableModel {
    private Document doc_;

    public Html_4_0_TableModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

	public Html_4_0_TableModel(String fileName, IRModelContext context) throws RModelException {
		super(context);
		setProperty(PROPERTY_FILE, fileName);
	}

    protected final void _open_table() throws RModelException {
        try {
            open_(_getDataSource());
        } catch (IOException e) {
            throw new RModelException(e);
        } catch (SAXException e) {
            throw new RModelException(e);
        }
    }

    private void open_(IRDataSource source) throws IOException, SAXException {
        if (source.isExist()) {
            open_(source.getInputSource());
        }
    }

    private void open_(InputSource inputSource) throws SAXException, IOException {
        DOMParser parser = new DOMParser();
        parser.parse(inputSource);
        doc_ = parser.getDocument();
        DomHtmlTableProcessor processor = new DomHtmlTableProcessor();
        UDOMVisitor.traverse(doc_, processor);
        HtmlTable[] tables = processor.getHtmlTables();
        buildTable_(tables[0]);
    }

    private void buildTable_(HtmlTable table) throws RModelException {
        int width = table.getWidth();
        int height = table.getHeight();
        for (int y = 0;y < height;y++) {
            for (int x = 0;x < width;x++) {
                String data = table.get(x, y);
                setString(x, y, data);
            }
        }
    }

    protected final void _close_table() {
        doc_ = null;
    }

    protected void _commitDirty_table() throws RModelException {
        IRDataSource ds = _getDataSource();
        BufferedWriter writer = null;
        try {
            writer = ds.openBufferedWriter();
            writeTable_(writer);
        } catch (IOException e) {
            throw new RModelException(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private void writeTable_(BufferedWriter writer) throws RModelException, IOException {
        throw new UnsupportedOperationException();
    }

    protected IRModelContent _getModelContent_table() throws RModelException {
        WorkspaceBag bag = new WorkspaceBag();
        BufferedWriter writer = null;
        try {
            writer = bag.openBufferedWriter();
            writeTable_(writer);
        } catch (IOException e) {
            throw new RModelException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
            }
        }
        return new WorkspaceContent(bag, _context);
    }
}
