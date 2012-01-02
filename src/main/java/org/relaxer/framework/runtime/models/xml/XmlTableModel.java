/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.xml;

import java.io.IOException;

import org.relaxer.framework.runtime.model.AbstractRTableModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;
import org.xml.sax.SAXException;

/**
 * XmlTableModel
 *
 * @since   Aug. 16, 2005
 * @version Aug. 19, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class XmlTableModel extends AbstractRTableModel {
    private XmlTableModelSchema schema_ = null;

    public XmlTableModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

	public XmlTableModel(String fileName, IRModelContext context) throws RModelException {
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
            if (schema_ == null) {
                XmlTableModelSchemaMaker schemaMaker = new XmlTableModelSchemaMaker();
                source.parse(schemaMaker);
            }
            XmlTableModelBuilder builder = schema_.getBuilder(this);
            source.parse(builder);
        }
    }

    protected void _commitDirty_table() throws RModelException {
        // TODO Auto-generated method stub
        super._commitDirty_table();
    }

    protected IRModelContent _getModelContent_table() throws RModelException {
        // TODO Auto-generated method stub
        return super._getModelContent();
    }
}
