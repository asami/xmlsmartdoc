package com.AsamiOffice.util;

/**
 * 1Array is a 1-dimensional extensible array.
 *
 * @since   Sep.  4, 2005
 * @version Sep.  4, 2005
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class D1Array {
    protected int size_;
    protected int allocSize_;
    protected Object[] contents_;

    public D1Array() {
        _init(0);
    }

    public D1Array(int size) {
        _init(size);
    }

    public D1Array(D1Array d1array) {
        contents_ = (Object[])d1array.contents_.clone();
    }

    private void _init(int size) {
        size_ = size;
        if (size == 0) {
            allocSize_ = 10;
        } else {
            allocSize_ = size;
        }
        contents_ = new Object[allocSize_];
    }

    public Object get(int i) {
        return (contents_[i]);
    }

    public Object put(int i, Object obj) {
        _ensureSpace(i + 1);
        contents_[i] = obj;
        if (i >= size_) {
            size_ = i + 1;
        }
        return (obj);
    }

    public Object remove(int i) {
        Object obj = contents_[i];
        contents_[i] = null;
        return (obj);
    }

    public int getSize() {
        return (size_);
    }

    protected void _ensureSpace(int size) {
        if ((allocSize_ >= size)) {
            return;
        }
        int newSize;
        if (allocSize_ < size) {
            newSize = allocSize_ * 2;
            while (newSize < size) {
                newSize *= 2;
            }
        } else {
            newSize = allocSize_;
        }
        Object[] newContents = new Object[newSize];
        for (int i = 0; i < size_; i++) {
            newContents[i] = contents_[i];
        }
        contents_ = newContents;
        allocSize_ = newSize;
    }
}
