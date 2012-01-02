package org.relaxer.framework.runtime.values;

import java.util.Iterator;
import java.util.List;

import org.relaxer.framework.runtime.value.AbstractRMutableTable;

/**
 * PlainTable
 *
 * @since   Oct. 29, 2005
 * @version Jan. 26, 2006
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class PlainTable extends AbstractRMutableTable {
    private int width_;
    private int height_;
    private int allocWidth_;
    private int allocHeight_;
    private Object[][] contents_;

    public PlainTable() {
        _init(0, 0);
    }

    public PlainTable(int width, int height) {
        _init(width, height);
    }

    public PlainTable(PlainTable d2array) {
        contents_ = cloneMatrix_(d2array.contents_);
    }

    private Object[][] cloneMatrix_(Object[][] contents) {
        throw new UnsupportedOperationException("PlainTable.cloneMatrix_");
    }

    private void _init(int width, int height) {
        width_ = width;
        height_ = height;
        if (width == 0) {
            allocWidth_ = 10;
        } else {
            allocWidth_ = width;
        }
        if (height == 0) {
            allocHeight_ = 10;
        } else {
            allocHeight_ = height;
        }
        contents_ = createMatrix_(allocHeight_, allocWidth_);
    }

    private void ensureSpace_(int height, int width) {
        if ((allocWidth_ >= width) && (allocHeight_ >= height)) {
            return;
        }
        int newWidth;
        int newHeight;
        if (allocWidth_ < width) {
            newWidth = allocWidth_ * 2;
            while (newWidth < width) {
                newWidth *= 2;
            }
        } else {
            newWidth = allocWidth_;
        }
        if (allocHeight_ < height) {
            newHeight = allocHeight_ * 2;
            while (newHeight < height) {
                newHeight *= 2;
            }
        } else {
            newHeight = allocHeight_;
        }
        Object[][] newContents = createMatrix_(newHeight, newWidth);
        for (int y = 0; y < height_; y++) {
            for (int x = 0; x < width_; x++) {
                newContents[y][x] = contents_[y][x];
            }
        }
        contents_ = newContents;
        allocWidth_ = newWidth;
        allocHeight_ = newHeight;
    }

    private Object[][] createMatrix_(int height, int width) {
        return (Object[][])new Object[height][width];
    }

    public int getWidth() {
        return width_;
    }

    public int getHeight() {
        return height_;
    }

    public Object get(int x, int y) {
        return contents_[y][x];
    }

    public Object put(int x, int y, Object value) {
        ensureSpace_(y + 1, x + 1);
        Object old = contents_[y][x];
        contents_[y][x] = value;
        if (x >= width_) {
            width_ = x + 1;
        }
        if (y >= height_) {
            height_ = y + 1;
        }
        return old;
    }

    public Object remove(int x, int y) {
        return put(x, y, null);
    }

    public boolean inbound(int x, int y) {
        return x < width_ && y < height_;
    }

    public Iterator getRowIterator(int y) {
        throw new UnsupportedOperationException("PlainTable.getRowIterator");
    }

    public List getRowList(int y) {
        throw new UnsupportedOperationException("PlainTable.getRowList");
    }

    public Object[] getRowArray(int y) {
        throw new UnsupportedOperationException("PlainTable.getRowArray");
    }
}
