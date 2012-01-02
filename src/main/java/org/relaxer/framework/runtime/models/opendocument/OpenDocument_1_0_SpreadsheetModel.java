/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.opendocument;

import java.io.OutputStream;

import org.relaxer.framework.runtime.model.AbstractRMapModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * OpenDocument_1_0_PresentationModel
 *
 * @since   Aug. 19, 2005
 * @version Aug. 19, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class OpenDocument_1_0_SpreadsheetModel extends AbstractRMapModel {
    public OpenDocument_1_0_SpreadsheetModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

	public OpenDocument_1_0_SpreadsheetModel(String fileName, IRModelContext context) throws RModelException {
		super(context);
		setProperty(PROPERTY_FILE, fileName);
	}

    protected void _open_map() throws RModelException {
    }

    protected void _writeContent_map(OutputStream out) throws RModelException {
        
    }
}
