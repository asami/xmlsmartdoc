/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;
import org.w3c.dom.Node;

/**
 * IRModelNode
 *
 * @since   Mar. 18, 2004
 * @version Aug. 17, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRModelNode {
    IRModel mount() throws RModelException;
    void unmount() throws RModelException;
    IRModel getMountedModel();
    boolean isDirty();
    //
    String getName();
    String getSuffix() throws RModelException;
    IRDataSource getDataSource() throws RModelException;
    // getMimeType();
    IRModelContent getContent() throws RModelException;
    IRModelContent setContent(IRModelContent content) throws RModelException;
    IRModelContent setContent(byte[] content) throws RModelException;
    IRModelContent setContent(String content) throws RModelException;
    IRModelContent setContent(Node content) throws RModelException;
    //
    void delete() throws RModelException;
    //
    void commit() throws RModelException;
    void rollback() throws RModelException;
    //
    void dispose() throws RModelException;
    //
    void accept(IRListVisitor visitor, int index) throws RModelException;
    void accept(IRTableVisitor visitor, int x, int y) throws RModelException;
}
