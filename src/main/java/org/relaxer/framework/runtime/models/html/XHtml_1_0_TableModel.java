/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.html;

import java.io.IOException;

import org.relaxer.framework.runtime.model.AbstractRTableModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.AsamiOffice.xml.visitor.UDOMVisitor;

/**
 * XHtmlTableModel
 *
 * @since   Aug. 16, 2005
 * @version Sep. 15, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class XHtml_1_0_TableModel extends AbstractRTableModel {
    private Document doc_;

    public XHtml_1_0_TableModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

	public XHtml_1_0_TableModel(String fileName, IRModelContext context) throws RModelException {
		super(context);
		setProperty(PROPERTY_FILE, fileName);
	}

    protected void _open_table() throws RModelException {
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
            open_(source.getDocument());
        }
    }

    private void open_(Document doc) throws SAXException, IOException {
        doc_ = doc;
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
}
