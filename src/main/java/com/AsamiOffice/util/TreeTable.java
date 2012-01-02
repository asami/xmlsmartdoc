package com.AsamiOffice.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * TreeTable
 *
 * @since   Sep. 30, 2005
 * @version Oct. 12, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class TreeTable {
    private RTNode root_ = new RTNode();
    private transient D2Array coarseTable_;
    private transient D2Array rowspanTable_;
    private transient D2Array colspanTable_;

    public D2Array getCoarseTable() {
        ensure_();
        return coarseTable_;
    }

    public D2Array getDenseTable() {
        throw new UnsupportedOperationException();
    }

    public D2Array getRowSpanTable() {
        ensure_();
        return rowspanTable_;
    }

    public String[] getLeafPathNames() {
        LeafPathNameMaker maker = new LeafPathNameMaker();
        root_.traverse(maker);
        return maker.getNames();
    }

    public D2Array getColSpanTable() {
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
        rowspanTable_ = new D2Array();
        colspanTable_ = new D2Array();
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

    public Cursor getCursor() {
        return new Cursor(root_);
    }

    public class Cursor {
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

    public class RTNode {
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

    public class CoarseTableMaker extends AbstractRTVisitor {
        private D2Array array_ = new D2Array();
        private int y_ = 0;
        private XHolder xHolder_ = new XHolder();

        public D2Array getTable() {
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
}
