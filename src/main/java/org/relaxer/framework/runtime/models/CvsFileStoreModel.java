/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models;

import java.util.Map;

import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.models.fs.FileStoreModel;

/**
 * CvsFileStoreModel
 *
 * @since   Mar. 22, 2004
 * @version Aug. 19, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class CvsFileStoreModel extends FileStoreModel {
    public CvsFileStoreModel(Map properties, IRModelContext context) throws RModelException {
		super(properties, context);
	}

	protected IRTreeModelNode _newNode(String name) throws RModelException {
        return new CvsFileNode(name, this);
    }
/*
    public IRTreeModelNode newNode(String name) throws RModelException {
        return (new CvsFileNode(name, this));
    }
*/
}
