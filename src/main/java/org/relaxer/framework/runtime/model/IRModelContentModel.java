package org.relaxer.framework.runtime.model;

/**
 * IRModelNodeModel
 *
 * @since   Aug.  2, 2005
 * @version Aug.  2, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRModelContentModel {
    // Model
    boolean isModel();
    IRModel getModel() throws RModelException;
    // List
    boolean isList();
    IRListModel getList() throws RModelException;
    // Table
    boolean isTable();
    IRTableModel getTable() throws RModelException;
    // Tree
    boolean isTree();
    IRTreeModel getTree() throws RModelException;
}
