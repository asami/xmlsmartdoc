/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.powerpoint;

import java.io.OutputStream;

import org.relaxer.framework.runtime.model.AbstractRTreeModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * PowerPointXmlTreeModel
 *
 * @since   Aug. 16, 2005
 * @version Aug. 19, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class PowerPointXml_2002_Model extends AbstractRTreeModel {
    public PowerPointXml_2002_Model(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

	public PowerPointXml_2002_Model(String fileName, IRModelContext context) throws RModelException {
		super(context);
		setProperty(PROPERTY_FILE, fileName);
	}

    protected void _open_tree() throws RModelException {
        // TODO Auto-generated method stub
        super._open_tree();
    }

    protected void _writeContent_tree(OutputStream out) {
        
    }
}
