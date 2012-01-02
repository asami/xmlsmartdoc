package org.relaxer.framework.runtime.models.smartdoc;

import org.relaxer.framework.runtime.model.IRListModel;
import org.relaxer.framework.runtime.model.IRMapModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.IRTableModel;
import org.relaxer.framework.runtime.model.IRTreeModel;
import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.RTreeModelVisitorBase;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.value.ICursor;
import org.relaxer.framework.runtime.value.IRTable;
import org.relaxer.framework.runtime.value.IRTree;
import org.relaxer.framework.runtime.values.PlainTable;
import org.relaxer.framework.runtime.values.TreeTable;

/**
 * TableNode
 *
 * @since   Sep. 28, 2005
 * @version Feb.  4, 2006
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class TableNode extends ContentNode {
    private IModelContainer contentModel_;
    private String title_ = null;
    private TreeTable head_ = null;

    public TableNode(SmartDocModel model) {
        this("table" + ++counter__, model);
    }

    public TableNode(String id, IRTreeModel model) {
        super(id, model);
    }

    protected void _dispose_content() {
        contentModel_ = null;
    }
    
    public void setTitle(String title) {
        title_ = title;
    }

    public void setHead(TreeTable head) {
        head_ = head;
    }

    public void setHead(String[] head) {
        head_ = new TreeTable();
        ICursor cursor = head_.getCursor();
        for (int i = 0;i < head.length;i++) {
            cursor.add(head[i]);
        }
    }

    public void setTableModel(IRTableModel model) throws RModelException {
        model.open();
        contentModel_ = new TableModelContainer(model);
    }

    public void setTreeModel(IRTreeModel model) throws RModelException {
        model.open();
        contentModel_ = new TreeModelContainer(model);
    }
    
    public void setMapModel(IRMapModel model) throws RModelException {
        model.open();
        contentModel_ = new MapModelContainer(model);
    }
    
    public void setListModel(IRListModel model) throws RModelException {
        model.open();
        contentModel_ = new ListModelContainer(model);
    }
    
    interface IModelContainer {
        String getTitle();
        IRTree getHead() throws RModelException;
        IRTable getBody() throws RModelException;
    }

    class TableModelContainer implements IModelContainer {
        private final IRTableModel tableModel_;

        public TableModelContainer(IRTableModel model) {
            tableModel_ = model;
        }

        public String getTitle() {
            return tableModel_.getName();
        }

        public IRTree getHead() throws RModelException {
            return tableModel_.getHead();
        }

        public IRTable getBody() throws RModelException {
            int width = tableModel_.getWidth();
            int height = tableModel_.getHeight();
            PlainTable table = new PlainTable();
            for (int y = 0;y < height;y++) {
                for (int x = 0;x < width;x++) {
                    table.put(x, y, getString_(x, y));
                }
            }
            return table;
        }

        private String getString_(int x, int y) throws RModelException {
            IRModelNode node = tableModel_.get(x, y);
            if (node == null) {
                return null;
            }
            return node.getContent().getText();
        }
    }

    class TreeModelContainer implements IModelContainer {
        private final IRTreeModel treeModel_;

        public TreeModelContainer(IRTreeModel model) {
            treeModel_ = model;
        }

        public String getTitle() {
            return treeModel_.getName();
        }

        public IRTree getHead() throws RModelException {
            return null;
        }

        public IRTable getBody() throws RModelException {
            TreeTableMaker maker = new TreeTableMaker();
            treeModel_.traverse(maker);
            return tarnspose_(maker.getTreeTable().getCoarseTable());
        }

        private IRTable tarnspose_(IRTable source) {
            PlainTable target = new PlainTable();
            int height = source.getHeight();
            int width = source.getWidth();
            for (int y = 0;y < height;y++) {
                for (int x = 0;x < width;x++) {
                    target.put(y, x, source.get(x, y));
                }
            }
            return target;
        }

        public class TreeTableMaker extends RTreeModelVisitorBase {
            private TreeTable tree_ = new TreeTable();
            private final ICursor cursor_;

            public TreeTableMaker() {
                cursor_ = tree_.getCursor();
            }

            public TreeTable getTreeTable() {
                return tree_;
            }

            public boolean enter(IRTreeModelNode node) throws RModelException {
                IRModelContent content = node.getContent();
                if (content == null) {
                    cursor_.add("*N/A*"); // XXX 
                } else {
                    cursor_.add(content.getText());
                }
                cursor_.enter();
                return true;
            }

            public void leave(IRTreeModelNode node) throws RModelException {
                cursor_.leave();
            }
        }
    }

    class MapModelContainer implements IModelContainer {
        private final IRMapModel mapModel_;

        public MapModelContainer(IRMapModel model) {
            mapModel_ = model;
        }

        public String getTitle() {
            throw new UnsupportedOperationException("MapModelContainer.getTitle");
        }

        public IRTree getHead() {
            throw new UnsupportedOperationException("MapModelContainer.getHead");
        }

        public IRTable getBody() {
            throw new UnsupportedOperationException("MapModelContainer.getBody");
        }
    }

    class ListModelContainer implements IModelContainer {
        private final IRListModel listModel_;

        public ListModelContainer(IRListModel model) {
            listModel_ = model;
        }

        public String getTitle() {
            throw new UnsupportedOperationException("ListModelContainer.getTitle");
        }

        public IRTree getHead() {
            throw new UnsupportedOperationException("ListModelContainer.getHead");
        }

        public IRTable getBody() {
            throw new UnsupportedOperationException("ListModelContainer.getBody");
        }
    }

    public String getTitle() {
        if (title_ != null) {
            return title_;
        } else {
            return contentModel_.getTitle();
        }
    }

    public IRTree getHead() throws RModelException {
        if (head_ != null) {
            return head_;
        } else {
            return contentModel_.getHead();
        }
    }

    public IRTable getBody() throws RModelException {
        IRTable body = contentModel_.getBody();
        if (head_ != null) {
            int targetWidth = head_.getWidth();
            int sourceWidth = body.getWidth();
            if (sourceWidth == targetWidth) {
                return body;
            }
            int height = body.getHeight();
            PlainTable target = new PlainTable();
            for (int y = 0;y < height;y++) {
                for (int x = 0;x < targetWidth;x++) {
                    if (x >= sourceWidth) {
                        target.put(x, y, _getNASymbol());
                    } else {
                        Object value = body.get(x, y);
                        target.put(x, y, value);
                    }
                }
            }
            return target;
        } else {
            return contentModel_.getBody();
        }
    }

    private String _getNASymbol() {
        return "N/A";
    }

    private static int counter__ = 0;
}
