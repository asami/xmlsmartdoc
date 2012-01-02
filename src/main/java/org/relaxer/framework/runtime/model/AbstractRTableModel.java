/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.content.ObjectContent;
import org.relaxer.framework.runtime.model.content.StringContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.value.ICursor;
import org.relaxer.framework.runtime.value.IRTree;
import org.relaxer.framework.runtime.values.PlainTable;
import org.relaxer.framework.runtime.values.TreeTable;
import org.relaxer.framework.runtime.values.TreeTable.Cursor;
import org.w3c.dom.Node;

/**
 * AbstractRTableModel
 *
 * @since   Mar. 18, 2004
 * @version Nov. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRTableModel extends AbstractRModel
  implements IRTableModel {
    private RTableModelMetaData metaData_;
    private IRTree headTree_;
    private IRTree sideTree_;
//    private final D2Array head_ = new D2Array();
//    private final D2Array side_ = new D2Array();
    private final PlainTable data_ = new PlainTable();

    protected AbstractRTableModel(IRModelContext context) throws RModelException {
    	super(context);
	}

    public AbstractRTableModel(IRModelContent content, IRModelContext context) throws RModelException {
        super(content, context);
    }

    public AbstractRTableModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

    protected AbstractRTableModel(Map properties, IRModelContext context) throws RModelException {
        super(properties, context);
    }
    
    protected final IRModelContent _getModelContent() throws RModelException {
        return _getModelContent_table();
    }

    protected IRModelContent _getModelContent_table() throws RModelException {
        return null;
    }

    protected final void _writeContent(OutputStream out) throws RModelException {
        _writeContent_table(out);
    }

    protected void _writeContent_table(OutputStream out) throws RModelException {
    }

    protected final void _open() throws RModelException {
        _open_table();
    }

    protected void _open_table() throws RModelException {
    }

    protected final void _close() throws RModelException {
        _close_table();
    }

    protected void _close_table() throws RModelException {
    }

    protected final void _commitDirty() throws RModelException {
        _commitDirty_table();
    }

    protected void _commitDirty_table() throws RModelException {
    }

    // IRListModel
    public IRModelNode[] getNodes() throws RModelException {
        int width = data_.getWidth();
        int height = data_.getHeight();
        IRModelNode[] nodes = new IRModelNode[width * height];
        int index = 0;
        for (int y = 0;y < height;y++) {
            for (int x = 0;x < width;x++) {
                nodes[index++] = (IRModelNode)data_.get(x, y);
            }
        }
        return (nodes);
    }

    public void traverse(IRListVisitor visitor) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void traverse(IRListVisitor visitor, IRNodeFilter filter)
        throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    // IRTableModel
    public final IRModelNode get(int x, int y) {
        return ((IRModelNode)data_.get(x, y));
    }

    public final int getHeight() throws RModelException {
        return (data_.getHeight());
    }

    public final int getWidth() throws RModelException {
        return (data_.getWidth());
    }

    public final void set(int x, int y, IRModelNode node) throws RModelException {
        _setDirty();
        if (y < data_.getHeight()) {
            if (data_.inbound(x, y)) {
                IRModelNode oldNode = (IRModelNode)data_.get(x, y);
                if (oldNode != null) {
                    oldNode.dispose();
                }
            }
        }
        data_.put(x, y, node);
    }

    public final void setContent(int x, int y, IRModelContent content) throws RModelException {
        if (content == null) {
            set(x, y, null);
        } else {
            content.open();
            set(x, y, new SimpleRModelNode(content, this));
        }
    }

    public void setBinary(int x, int y, byte[] content) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void setObject(int x, int y, Object content) throws RModelException {
        if (content == null) {
            set(x, y, null);
        } else {
            setContent(x, y, new ObjectContent(content, _context));
        }
    }

    public final void addRecordList(List record) throws RModelException {
        setRecordList(data_.getHeight(), record);
    }

    public final void setRecordList(int y, List record) throws RModelException {
        int width = record.size();
        for (int x = 0;x < width;x++) {
            setObject(x, y, record.get(x));
        }
    }

    public void addRecordArray(Object[] record) throws RModelException {
        setRecordArray(data_.getHeight(), record);
    }

    public void setRecordArray(int y, Object[] record) throws RModelException {
        for (int x = 0;x < record.length;x++) {
            setObject(x, y, record[x]);
        }
    }

    public final Iterator getRecordIterator(int y) throws RModelException {
        return data_.getRowIterator(y);
    }

    public final List getRecordList(int y) throws RModelException {
        return data_.getRowList(y);
    }
    
    public final Object[] getRecordArray(int y) throws RModelException {
        return data_.getRowArray(y);
    }

    // XXX
    public void setRecord(int y, IRModelRecord record) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    // XXX
    public void addRecord(IRModelRecord record) throws RModelException {
        int height = data_.getHeight();
        int width = record.getWidth();
        for (int i = 0;i < width;i++) {
            setObject(i, height, record.get(i));
        }
    }

    // XXX
    public IRModelRecord getRecord(int y) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void setString(int x, int y, String content) throws RModelException {
        _setDirty();
        if (content == null) {
            setContent(x, y, null);
        } else {
            setContent(x, y, new StringContent(content, getModelContext()));
        }
    }

    public void setXml(int x, int y, Node content) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void setHead(IRTree head) throws RModelException {
        headTree_ = head;
    }

    public void setHead(String[] head) throws RModelException {
        headTree_ = new TreeTable();
        ICursor cursor = headTree_.getCursor();
        for (int i = 0;i < head.length;i++) {
            cursor.add(head[i]);
        }
    }

    public void setHead(List head) throws RModelException {
        ICursor cursor = headTree_.getCursor();
        Iterator iter = head.iterator();
        while (iter.hasNext()) {
            cursor.add(iter.next());
        }
    }

    public IRTree getHead() throws RModelException {
        return headTree_;
    }

/*
    public void setNameVariable(String name, String value) {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void addHeadList(List head) throws RModelException {
        int y = head_.getHeight();
        int width = head.size();
        for (int x = 0;x < width;x++) {
            setObject(x, y, head.get(x));
        }
    }

    public void setHeadList(List head) throws RModelException {
        int y = 0;
        int width = head.size();
        for (int x = 0;x < width;x++) {
            setObject(x, y, head.get(x));
        }
    }

    public void addHeadArray(Object[] head) throws RModelException {
        int y = head_.getHeight();
        for (int x = 0;x < head.length;x++) {
            setObject(x, y, head[x]);
        }
    }

    public void setHeadArray(Object[] head) throws RModelException {
        int y = 0;
        for (int x = 0;x < head.length;x++) {
            setObject(x, y, head[x]);
        }
    }

    public final Iterator getHeadIterator(int y) throws RModelException {
        return head_.getRowIterator(y);
    }

    public final List getHeadList(int y) throws RModelException {
        return head_.getRowList(y);
    }

    public final Object[] getHeadArray(int y) throws RModelException {
        return head_.getRowArray(y);
    }

    // XXX
    public void setHead(IRModelRecord record) throws RModelException {
        _setDirty();
        int height = head_.getHeight();
        int width = record.getWidth();
        for (int i = 0;i < width;i++) {
            head_.put(i, height, record.get(i));
        }
    }

    // XXX
    public void addHead(IRModelRecord record) throws RModelException {
        _setDirty();
        int height = head_.getHeight();
        int width = record.getWidth();
        for (int i = 0;i < width;i++) {
            head_.put(i, height, record.get(i));
        }
    }
*/

    public void setTable(IRTableModel tableModel) throws RModelException {
        _setDirty();
        setName(tableModel.getName());
        int height = tableModel.getHeight();
        int width = tableModel.getWidth();
        for (int y = 0;y < height;y++) {
            for (int x = 0;x < width;x++) {
                IRModelNode node = tableModel.get(x, y);
                if (node == null) {
                    set(x, y, null); // XXX dirty
                } else {
                    IRModelContent content = node.getContent();
                    if (content == null) {
                        set(x, y, null); // adjust XXX dirty
                    } else {
                        setContent(x, y, content);
                    }
                }
            }
        }
    }

    public void traverse(IRTableVisitor visitor) throws RModelException {
        traverse(visitor, null);
    }

    public void traverse(IRTableVisitor visitor, IRNodeFilter filter)
        throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }
}
