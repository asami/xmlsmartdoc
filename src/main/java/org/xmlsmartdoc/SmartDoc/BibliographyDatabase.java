/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2002  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import java.util.*;
import java.io.IOException;
import java.net.URL;
import org.w3c.dom.*;
import com.AsamiOffice.jaba2.xml.*;

/**
 * BibliographyDatabase
 *
 * @since   Nov.  4, 1998
 * @version Mar. 15, 2002
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class BibliographyDatabase {
    protected List DBs_ = new ArrayList(); // <Bibliopole>

    public BibliographyDatabase(URL[] urls) {
	this(urls, null);
    }

    public BibliographyDatabase(URL[] urls, String parserName) {
	for (int i = 0;i < urls.length;i++) {
	    try {
		IProcessor processor;
		if (parserName != null) {
		    processor = ProcessorFactory.getProcessor(parserName);
		} else {
		    processor = ProcessorFactory.getProcessor();
		}
		Document doc = processor.parseDocument(urls[i]);
		Bibliopole bib = new Bibliopole(doc.getDocumentElement());
		addBibliopole(bib);
	    } catch (IOException e) {
		_warning("Can't load bibliopole:" + e.getMessage());
	    }
	}
    }

    public void addBibliopole(Bibliopole bib) {
	DBs_.add(bib);
    }

    public void setup() {
	List list = new ArrayList();
	int nBibs = DBs_.size();
	for (int i = 0;i < nBibs;i++) {
	    Bibliopole bib = (Bibliopole)DBs_.get(i);
	    _collectRefs(bib, list);
	}
	int nRefs = list.size();
	for (int i = 0;i < nRefs;i++) {
	    Content ref = (Content)list.get(i);
	    int nDBs = DBs_.size();
	    for (int j = 0;j < nDBs;j++) {
		Bibliopole bib = (Bibliopole)DBs_.get(j);
		_resolveLinkIdref(bib, ref);
		if (ref.getLink() != null) {
		    break;
		}
	    }
	}
    }

    public Bibitem get(String id) {
	if (id.startsWith("#")) {
	    id = id.substring(1);
	}
	int size = DBs_.size();
	for (int i = 0;i < size;i++) {
	    Bibliopole bib = (Bibliopole)DBs_.get(i);
	    Content[] contents = bib.getContents();
	    for (int j = 0;j < contents.length;j++) {
		Content content = contents[j];
		if (content instanceof Bibitem) {
		    if (id.equals(content.getID())) {
			return ((Bibitem)content);
		    }
		}
	    }
	}
	return (null);
    }

    // same as SmartModel's method
    protected void _collectRefs(Container container, List list) {
	Content[] contents = container.getContents();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Ref) { // XXX
		list.add(content);
	    } else if (content.getIdref() != null) {
		list.add(content);
	    } else if (content instanceof Container) {
		_collectRefs((Container)content, list);
	    }
	}
    }

    protected void _resolveLinkIdref(Container container, Content ref) {
	_resolveLinkIDIdrefExternalContext(container, ref, false);
    }

    // same as SmartModel's method
    protected boolean _resolveLinkIDIdrefExternalContext(
	Container container,
	Content ref,
	boolean isResolved
    ) {
	String href = ref.getIdref();
	Content[] contents = container.getContents();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    String id = content.getID();
	    if (href.equals(id)) {
		if (isResolved) {
		    _warning("Duplicate link id = " + href);
		} else {
		    ref.setLink(content);
		    content.addReferer(ref);
		    isResolved = true;
		}
	    }
	    if (content instanceof Container) {
		isResolved = _resolveLinkIDIdrefExternalContext(
		    (Container)content,
		    ref,
		    isResolved
		);
	    }
	}
	return (isResolved);
    }

    // same as SmartModel's method
    protected void _resolveLink(Container container, Ref ref) {// XXX
	String href = ref.getHref();
	Content[] contents = container.getContents();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    String id = content.getID();
	    if (href.equals(id)) {
		ref.setLink(content);
		return;		// XXX : check duplicate id
	    }
	    if (content instanceof FloatingObject) {
		String caption = ((FloatingObject)content).getTitle();
		if (href.equals(caption)) {
		    ref.setLink(content);
		    return;
		}
	    } else if (content instanceof Container) {
		_resolveLink((Container)content, ref);
	    }
	}
    }

    private void _warning(String message) {
	USmartDoc.warningMessage(message);
    }
}
