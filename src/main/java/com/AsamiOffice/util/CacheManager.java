package com.AsamiOffice.util;

import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * CacheManager
 *
 * @since   Sep. 22, 2005
 * @version Sep. 30, 2005
 * @author  ASAMI, Tomoharu (asami@asamioffice.com)
 */
public class CacheManager {
    private LinkedList lru_ = new LinkedList();
    private int maxSize_ = 10;

    public Object get(Object owner, String usage) {
        Iterator iter = lru_.iterator();
        while (iter.hasNext()) {
            Info info = (Info)iter.next();
            if (info.owner == owner && info.usage.equals(usage)) {
                iter.remove();
                Object data = info.getData();
                if (data != null) {
                    lru_.addFirst(info);
                    return data;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public void add(Object owner, String usage, Object data) {
        Iterator iter = lru_.iterator();
        while (iter.hasNext()) {
            Info info = (Info)iter.next();
            if (info.owner == owner && info.usage.equals(usage)) {
                iter.remove();
                info.setData(data);
                lru_.addFirst(info);
                return;
            }
        }
        Info info = new Info();
        info.owner = owner;
        info.usage = usage;
        info.setData(data);
        lru_.add(info);
        if (isFull_()) {
            lru_.removeLast();
        }
    }

    private boolean isFull_() {
        return lru_.size() > getMaxSize_();
    }

    private int getMaxSize_() {
        return maxSize_ ;
    }

    public void clear(Object owner) {
        Iterator iter = lru_.iterator();
        while (iter.hasNext()) {
            Info info = (Info)iter.next();
            if (info.owner == owner) {
                iter.remove();
            }
        }
    }

    static class Info {
        private static final int SMALL_BINARY_SIZE = 8192;
        private static final int SMALL_TEXT_SIZE = 8192;

        Object owner;
        String usage;
        private Object data;
        private SoftReference ref;

        public void setData(Object data) {
            if (isSmallData_(data)) {
                this.data = data; 
                this.ref = null;
            } else {
                this.ref = new SoftReference(data);
                this.data = null;
            }
        }

        private boolean isSmallData_(Object data) {
            if (data instanceof byte[]) {
                return ((byte[])data).length <= SMALL_BINARY_SIZE;
            } else if (data instanceof String) {
                return ((String)data).length() <= SMALL_TEXT_SIZE;
            } else {
                return false;
            }
        }

        public Object getData() {
            if (ref != null) {
                return ref.get();
            } else {
                return data;
            }
        }
    }
}
