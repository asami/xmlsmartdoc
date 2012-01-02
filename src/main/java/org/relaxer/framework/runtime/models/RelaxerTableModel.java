/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.relaxer.framework.runtime.model.AbstractRModel;
import org.relaxer.framework.runtime.model.IRListModel;
import org.relaxer.framework.runtime.model.IRListVisitor;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.IRModelRecord;
import org.relaxer.framework.runtime.model.IRNodeFilter;
import org.relaxer.framework.runtime.model.IRTableModel;
import org.relaxer.framework.runtime.model.IRTableVisitor;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.value.IRTree;
import org.w3c.dom.Node;

/**
 * RelaxerTableModel
 *
 * @since   Mar. 22, 2004
 * @version Nov. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RelaxerTableModel extends AbstractRModel 
  implements IRTableModel {

    protected RelaxerTableModel(Map properties, IRModelContext context) throws RModelException {
		super(properties, context);
	}

	public int getWidth() throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public int getHeight() throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public IRModelNode get(int x, int y) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void set(int x, int y, IRModelNode node) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void traverse(IRTableVisitor visitor) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void traverse(IRTableVisitor visitor, IRNodeFilter filter) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public IRModelNode[] getNodes() throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void traverse(IRListVisitor visitor) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void traverse(IRListVisitor visitor, IRNodeFilter filter) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    protected void _open() throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    protected void _close() throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    protected void _commitDirty() throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    protected void _rollback() throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    protected void _create() throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    protected void _delete() throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void set(Object key, IRModelNode value) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public IRModelNode get(Object key) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }
    public void addRecord(IRModelRecord record) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public IRModelRecord getRecord(int x) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void setContent(int x, int y, IRModelContent content)
        throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void setBinary(int x, int y, byte[] content)
        throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void setObject(int x, int y, Object content)
        throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void setRecord(int x, IRModelRecord record) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void setString(int x, int y, String content)
        throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void setXml(int x, int y, Node content) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void setHead(IRModelRecord record) throws RModelException {
        // TODO Auto-generated method stub
        
    }

    public void addHead(IRModelRecord record) throws RModelException {
        // TODO Auto-generated method stub
        
    }

    public void setTable(IRTableModel tableModel) {
        // TODO Auto-generated method stub
        
    }

    public void setList(IRListModel list) throws RModelException {
        // TODO Auto-generated method stub
        
    }

    public Iterator getRecordIterator(int y) throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.getRecordIterator");
    }

    public List getRecordList(int y) throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.getRecordList");
    }

    public Object[] getRecordArray(int y) throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.getRecordArray");
    }

    public void setRecordList(int y, List record) throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.setRecordList");
    }

    public void addRecordList(List record) throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.addRecordList");
    }

    public void setRecordArray(int y, Object[] record) throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.setRecordArray");
    }

    public void addRecordArray(Object[] record) throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.addRecordArray");
    }

    public void setHead(List head) throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.setHeadList");
    }

    public void addHeadList(List head) throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.addHeadList");
    }

    public void setHeadArray(Object[] head) throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.setHeadArray");
    }

    public IRTree getHead() throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.getHead");
    }

    public void addHeadArray(Object[] head) throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.addHeadArray");
    }

    public void setHead(String[] head) throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.setHeadArray");
    }

    public void setHead(IRTree head) throws RModelException {
        throw new UnsupportedOperationException("RelaxerTableModel.setHead");
    }
}
