package org.relaxer.framework.runtime.values;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.relaxer.framework.runtime.model.IRNodeFilter;
import org.relaxer.framework.runtime.value.AbstractRMutableTree;
import org.relaxer.framework.runtime.value.AbstractRTreeNode;
import org.relaxer.framework.runtime.value.ICursor;
import org.relaxer.framework.runtime.value.IRTable;
import org.relaxer.framework.runtime.value.IRTree;
import org.relaxer.framework.runtime.value.IRTreeNode;
import org.relaxer.framework.runtime.value.IRTreeVisitor;

/**
 * TreeTable
 *
 * @since   Oct. 29, 2005
 * @version Jan. 24, 2006
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class TreeTable extends AbstractRMutableTree {
    private RTNode root_ = new RTNode();
    private transient IRTable coarseTable_;
    private transient PlainTable rowspanTable_;
    private transient PlainTable colspanTable_;

    public IRTable getCoarseTable() {
        ensure_();
        return coarseTable_;
    }

    public IRTreeNode getRoot() {
        return root_;
    }

    public IRTable getDenseTable() {
        throw new UnsupportedOperationException();
    }

    public IRTable getRowSpanTable() {
        ensure_();
        return rowspanTable_;
    }

    public String[] getLeafPathNames() {
        LeafPathNameMaker maker = new LeafPathNameMaker();
        root_.traverse(maker);
        return maker.getNames();
    }

    public IRTable getColSpanTable() {
        ensure_();
        return colspanTable_;
    }

    public int getWidth() {
        ensure_();
        return coarseTable_.getWidth();
    }

    public int getHeight() {
        ensure_();
        return coarseTable_.getHeight();
    }

    private void ensure_() {
        if (coarseTable_ != null) {
            return;
        }
        CoarseTableMaker maker = new CoarseTableMaker();
        coarseTable_ = maker.getTable();
        rowspanTable_ = new PlainTable();
        colspanTable_ = new PlainTable();
        int height = coarseTable_.getHeight();
        int width = coarseTable_.getWidth();
        for (int y = 0;y < height;y++) {
            for (int x = 0;x < width;x++) {
                if (coarseTable_.get(x, y) == null) {
                    rowspanTable_.put(x, y, null);
                    colspanTable_.put(x, y, null);
                } else {
                    rowspanTable_.put(x, y, calcRowspan_(x, y, height));
                    colspanTable_.put(x, y, calcColspan_(x, y, width));
                }
            }
        }
    }

    private Integer calcRowspan_(int x, int y, int height) {
        int count = 1;
        for (int i = y + 1;i < height;i++) {
            if (coarseTable_.get(x, i) != null) {
                break;
            }
            count++;
        }
        return Integer.valueOf(count);
    }

    private Integer calcColspan_(int x, int y, int width) {
        int count = 1;
        for (int i = x + 1;i < width;i++) {
            if (coarseTable_.get(i, y) != null) {
                break;
            }
            count++;
        }
        return Integer.valueOf(count);
    }

    public ICursor getCursor() {
        return new Cursor(root_);
    }

    public class Cursor implements ICursor {
        private RTNode current_;
        private RTNode parent_;
        private Stack stack_ = new Stack();

        public Cursor(RTNode root) {
            parent_ = root;
            current_ = null;
        }

        public void add(Object data) {
            current_ = new RTNode(data);
            parent_.add(current_);
        }

        public void enter() {
            parent_ = current_;
            push_();
        }

        public void leave() {
            pop_();
            parent_ = current_.parent_;
        }

        private void push_() {
            stack_.push(current_);
            current_ = null;
        }

        private void pop_() {
            current_ = (RTNode)stack_.pop();
        }
    }

    public class RTNode extends AbstractRTreeNode {
        private Object data_;
        private RTNode parent_;
        private List children_ = new ArrayList();

        public RTNode(Object data) {
            data_ = data;
        }

        public RTNode() {
        }

        public Object getData() {
            return data_;
        }

        public void add(RTNode node) {
            children_.add(node);
            node.parent_ = this;
        }

        public void traverse(IRTVisitor visitor) {
            Object[] children = children_.toArray();
            for (int i = 0;i < children.length;i++) {
                RTNode node = (RTNode)children[i];
                visitor.enter(node);
                node.traverse(visitor);
                visitor.leave(node);
            }
        }

        public boolean isFirstNode() {
            return parent_.children_.get(0) == this;
        }

        public IRTreeNode[] getChildren() {
            IRTreeNode[] children = new IRTreeNode[children_.size()];
            return (IRTreeNode[])children_.toArray(children);
        }

        public Object getContent() {
            return data_;
        }
    }

    public interface IRTVisitor {
//        void start(RTNode node);
//        void end(RTNode node);
        void enter(RTNode node);
//        void stay(RTNode node, RTNode prev, RTNode next);
        void leave(RTNode node);
    }
    
    public abstract class AbstractRTVisitor implements IRTVisitor {
    }

    public class CoarseTableMakerNew extends AbstractRTVisitor {
        private PlainTable array_ = new PlainTable();
        private int x_ = 0;
        private YHolder yHolder_ = new YHolder();

        public IRTable getTable() {
            root_.traverse(this);
            return array_;
        }

        public void enter(RTNode node) {
            array_.put(x_, yHolder_.count(node), node.getData());
            x_++;
        }

        public void leave(RTNode node) {
            x_--;
        }

        class YHolder {
            int count_ = 0;
            
            public int count(RTNode node) {
                if (node.isFirstNode()) {
                    return count_;
                } else {
                    return ++count_;
                }
            }
        }
    }

    public class CoarseTableMaker extends AbstractRTVisitor {
        private PlainTable array_ = new PlainTable();
        private int y_ = 0;
        private XHolder xHolder_ = new XHolder();

        public IRTable getTable() {
            root_.traverse(this);
            return array_;
        }

        public void enter(RTNode node) {
            array_.put(xHolder_.count(node), y_, node.getData());
            y_++;
        }

        public void leave(RTNode node) {
            y_--;
        }

        class XHolder {
            int count_ = 0;
            
            public int count(RTNode node) {
                if (node.isFirstNode()) {
                    return count_;
                } else {
                    return ++count_;
                }
            }
        }
    }
    
    public class LeafPathNameMaker extends AbstractRTVisitor {
        List names_ = new ArrayList();

        public String[] getNames() {
            String[] result = new String[names_.size()];
            return (String[])names_.toArray(result);
        }

        public void enter(RTNode node) {
            if (node.children_.size() == 0) {
                LinkedList list = new LinkedList();
                while (node != root_) {
                    list.add(node.data_.toString());
                    node = node.parent_;
                }
                StringBuffer sb = new StringBuffer();
                String name = (String)list.removeLast();
                sb.append(name);
                while (!list.isEmpty()) {
                    name = (String)list.removeLast();
                    sb.append('/');
                    sb.append(name);
                }
                names_.add(sb.toString());
            }
        }

        public void leave(RTNode node) {
        }
    }

    public void setTree(IRTree tree) {
        throw new UnsupportedOperationException("TreeTable.setTree");
    }

    public IRTreeNode addNode(String path) {
        throw new UnsupportedOperationException("TreeTable.addNode");
    }

    public IRTreeNode addNode(String path, Object content) {
        throw new UnsupportedOperationException("TreeTable.addNode");
    }

    public IRTreeNode removeNode(String path) {
        throw new UnsupportedOperationException("TreeTable.removeNode");
    }

    public IRTreeNode newNode(String name) {
        throw new UnsupportedOperationException("TreeTable.newNode");
    }

    public IRTreeNode getNode(String path) {
        throw new UnsupportedOperationException("TreeTable.getNode");
    }
}
