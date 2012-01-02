/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.script;

import java.util.ArrayList;
import java.util.List;

/**
 * ScriptInOut
 *
 * @since   Jan.  8, 2004
 * @version Feb. 12, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptParameter {
    private List entries_ = new ArrayList(); 

    public void addEntryValue(String name, ScriptValue value) {
        Entry entry = new Entry(name);
        entry.value = value;
        entries_.add(entry);
    }

    public void addEntryText(String name, String value) {
        Entry entry = new Entry(name);
        entry.value = new ScriptValue(value);
        entries_.add(entry);
    }

    public void addEntryObject(String name, Object value) {
        Entry entry = new Entry(name);
        entry.value = new ScriptValue(value);
        entries_.add(entry);
    }

    public Entry[] getEntries() {
        Entry[] result = new Entry[entries_.size()];
        return ((Entry[])entries_.toArray(result));
    }

    public static class Entry {
        public String name;
        public ScriptValue value;

        public Entry(String name) {
            this.name = name;
        }

        public void toSlot(Slot slot) {
            slot.setValue(value);
        }

        public void fromSlot(Slot slot) {
            value = slot.getValue();
        }
    }

    public ScriptValue getValue(String name) {
        Object[] entries = entries_.toArray();
        for (int i = 0; i < entries.length; i++) {
            Entry entry = (Entry)entries[i];
            if (name.equals(entry.name)) {
                return (entry.value);
            }
        }
        return (null);
    }

}
