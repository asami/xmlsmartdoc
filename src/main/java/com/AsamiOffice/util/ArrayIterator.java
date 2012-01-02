package com.AsamiOffice.util;

import java.util.Iterator;

/**
 * ArrayIterator
 *
 * @since   Aug. 24, 2005
 * @version Aug. 24, 2005
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class ArrayIterator implements Iterator {
    private final Object[] array_;
    private int index_;

    public ArrayIterator(Object[] array) {
        array_ = array;
        index_ = 0;
    }

    public boolean hasNext() {
        return index_ < array_.length;
    }

    public Object next() {
        return array_[index_++];
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
