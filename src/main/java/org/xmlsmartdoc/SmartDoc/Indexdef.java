/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.xmlsmartdoc.SmartDoc;

import java.text.Collator;
import java.util.*;
import org.w3c.dom.Element;

/**
 * Indexdef
 *
 * @since   Sep. 25, 1998
 * @version May.  7, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class Indexdef extends Container {
    protected Map anchors_ = new HashMap(); // Map<String, Entry>

    public Indexdef() {
    }

    public Indexdef(Element element) {
        super(element);
    }

    // Content
    public int getEntityType() {
        return (ENTITY_CONTAINER);
    }

    // Container
    public void format() {
        super.format();
        int size = contents_.size();
        for (int i = 0; i < size; i++) {
            Content content = (Content)contents_.get(i);
            if (content instanceof IndexItem) {
                IndexItem item = (IndexItem)content;
                setIndexWord(item.getWord());
            } else if (content instanceof CharBlock) {
                // do nothing
            } else {
                throw (new InternalError("bad tag : " + content));
            }
        }
    }

    public void setIndexWord(String word) {
        Entry entry = (Entry)anchors_.get(word);
        if (entry != null) {
            _warning("already defined : " + word);
        }
        entry = new Entry(word);
        anchors_.put(word, entry);
    }

    public void setIndexWords(String[] words) {
        for (int i = 0; i < words.length; i++) {
            setIndexWord(words[i]);
        }
    }

    /*
        public void addAnchor(Anchor anchor) {
    	String word = anchor.getText();
    	Entry entry = (Entry)anchors_.get(word);
    	if (entry == null) {
    	    _warning("no entry : " + word);
    	}
    	entry.refs.add(anchor);
        }
    */

    public void addIndex(Index index) {
        Entry entry = _addIndex(index);
        entry.refs.add(index);
    }

    public void addDfn(Dfn dfn) {
        Entry entry = _addIndex(dfn);
        entry.dfn = dfn;
    }

    private Entry _addIndex(Content content) {
        String word = content.getText();
        Entry entry = (Entry)anchors_.get(word);
        if (entry == null) {
            entry = new Entry(word);
            anchors_.put(word, entry);
        }
        return (entry);
    }

    public String[] getIndexWords() {
        Collection values = anchors_.values();
        Entry[] entries = new Entry[values.size()];
        values.toArray(entries);
        Arrays.sort(entries, getComparator_());
        List list = new ArrayList();
        for (int i = 0; i < entries.length; i++) {
            list.add(entries[i].word);
        }
        String[] words = new String[list.size()];
        list.toArray(words);
        return (words);
    }

    private Comparator getComparator_() {
        Comparator comparator = new Comparator() {
            private Collator collator = Collator.getInstance(); // TODO I18N
            public int compare(Object lhs, Object rhs) {
                Entry lEntry = (Entry)lhs;
                Entry rEntry = (Entry)rhs; 
                String lText;
                if (lEntry.phonetic != null) {
                    lText = lEntry.phonetic;
                } else {
                    lText = lEntry.word;
                }
                String rText;
                if (rEntry.phonetic != null) {
                    rText = rEntry.phonetic;
                } else {
                    rText = rEntry.word;
                }
                return (collator.compare(lText, rText));
            }
        };
        return (comparator);
    }

    public Anchor getDefAnchor(String word) {
        Entry entry = (Entry)anchors_.get(word);
        if (entry == null) {
            _warning("no entry : " + word);
        }
        return (entry.dfn);
    }

    public Anchor[] getRefAnchors(String word) {
        Entry entry = (Entry)anchors_.get(word);
        if (entry == null) {
            _warning("no entry : " + word);
        }
        Anchor[] anchors = new Anchor[entry.refs.size()];
        return ((Anchor[])entry.refs.toArray(anchors));
    }

    public int calcNextRefNo(String word) {
        Entry entry = (Entry)anchors_.get(word);
        if (entry == null) {
            _warning("no entry : " + word);
        }
        return (entry.refs.size() + 1);
    }

    static class Entry {
        public String word;
        public String phonetic;
        Dfn dfn = null;
        // List<Content>
        List refs = new ArrayList();

        public Entry(String word) {
            this.word = word;
            this.phonetic = null;
        }
        
        public Entry(String word, String phonetic) {
            this.word = word;
            this.phonetic = phonetic;
        }
    }
}
