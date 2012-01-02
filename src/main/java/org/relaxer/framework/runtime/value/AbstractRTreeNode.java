package org.relaxer.framework.runtime.value;

/**
 * AbstractRTreeNode
 *
 * @since   Jan. 24, 2006
 * @version Jan. 24, 2006
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRTreeNode implements IRTreeNode {
    public String getPathName() {
        throw new UnsupportedOperationException("AbstractRTreeNode.getPathName");
    }

    public boolean isRoot() {
        throw new UnsupportedOperationException("AbstractRTreeNode.isRoot");
    }

    public boolean isContainer() {
        throw new UnsupportedOperationException("AbstractRTreeNode.isContainer");
    }

    public boolean isLeaf() {
        throw new UnsupportedOperationException("AbstractRTreeNode.isLeaf");
    }

    public IRTreeNode getParent() {
        throw new UnsupportedOperationException("AbstractRTreeNode.getParent");
    }

    public int getLength() {
        throw new UnsupportedOperationException("AbstractRTreeNode.getLength");
    }

    public IRTreeNode addChild() {
        throw new UnsupportedOperationException("AbstractRTreeNode.addChild");
    }

    public IRTreeNode addChild(String name) {
        throw new UnsupportedOperationException("AbstractRTreeNode.addChild");
    }

    public IRTreeNode addChild(IRTreeNode node) {
        throw new UnsupportedOperationException("AbstractRTreeNode.addChild");
    }

    public IRTreeNode getNode(String pathName) {
        throw new UnsupportedOperationException("AbstractRTreeNode.getNode");
    }

    public IRTreeNode addNode(String pathName) {
        throw new UnsupportedOperationException("AbstractRTreeNode.addNode");
    }

    public IRTreeNode addNode(String pathName, Object content) {
        throw new UnsupportedOperationException("AbstractRTreeNode.addNode");
    }

    public IRTreeNode removeChild(String pathName) {
        throw new UnsupportedOperationException("AbstractRTreeNode.removeChild");
    }

    public IRTreeNode removeChild(IRTreeNode child) {
        throw new UnsupportedOperationException("AbstractRTreeNode.removeChild");
    }

    public void removeChildren() {
        throw new UnsupportedOperationException(
                "AbstractRTreeNode.removeChildren");
    }

    public IRTreeNode copyChild(IRTreeNode child) {
        throw new UnsupportedOperationException("AbstractRTreeNode.copyChild");
    }

    public IRTreeNode copyNode(String pathName, IRTreeNode child) {
        throw new UnsupportedOperationException("AbstractRTreeNode.copyNode");
    }

    public boolean start(IRTreeVisitor visitor) {
        return visitor.start(this);
    }

    public void end(IRTreeVisitor visitor) {
        visitor.end(this);
    }

    public boolean enter(IRTreeVisitor visitor) {
        return visitor.enter(this);
    }

    public boolean stay(IRTreeVisitor visitor, int index, IRTreeNode prev,
            IRTreeNode next) {
        return visitor.stay(this, index, prev, next);
    }

    public void leave(IRTreeVisitor visitor) {
        visitor.leave(this);
    }

}
