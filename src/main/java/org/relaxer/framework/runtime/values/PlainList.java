package org.relaxer.framework.runtime.values;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.relaxer.framework.runtime.value.AbstractRList;

/**
 * PlainList
 *
 * @since   Oct. 18, 2005
 * @version Nov. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class PlainList extends AbstractRList {
    protected int size_;
    protected int allocSize_;
    protected Object[] contents_;

    public PlainList() {
        _init(0);
    }

    public PlainList(int size) {
        _init(size);
    }

    public PlainList(PlainList list) {
        contents_ = (Object[])list.contents_.clone();
    }

    public PlainList(List list) {
        contents_ = list.toArray();
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

    public int size() {
        return (size_);
    }

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int arg0, Collection arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

    public Object get(int i) {
        return (contents_[i]);
    }

    public Object set(int i, Object obj) {
        _ensureSpace(i + 1);
        contents_[i] = obj;
        if (i >= size_) {
            size_ = i + 1;
        }
        return (obj);
    }

	public void add(int arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

    public Object remove(int i) {
        Object obj = contents_[i];
        contents_[i] = null;
        return (obj);
    }

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
