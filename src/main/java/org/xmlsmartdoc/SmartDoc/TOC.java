/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

/**
 * TOC
 *
 * @since   Sep. 25, 1998
 * @version Sep. 13, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
// make TOC hear (currently HTMLGenerater does it)
public class TOC extends Content {
    protected TOCNode root_;
    protected int part_;
    protected int chapter_;
    protected int section_;
    protected int subsection_;
    protected int subsubsection_;

    public TOC(Doc doc) {
	root_ = UDoc.getTOCTree(doc);
    }

    // Content
    public int getEntityType() {
	return (ENTITY_CONTAINER);
    }

    public TOCNode getTOCRoot() {
	return (root_);
    }

    public void calcSeqNumber(Doc doc) {
	part_ = 1;
	chapter_ = 1;
	section_ = 1;
	subsection_ = 1;
	subsubsection_ = 1;
	_calcSeqNumber(doc);
    }

    protected void _calcSeqNumber(Container container) {
	Content[] contents = container.getContents();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof TitledBlock) {
		_calcSeqNumber((TitledBlock)content);
	    }
	    if (content instanceof Container) {
		_calcSeqNumber((Container)content);
	    }
	}
    }

    private void _calcSeqNumber(TitledBlock content) {
	if (!content.isSequencable()) {
	    return;
	}
	if (content instanceof Part) {
	    Part part = (Part)content;
	    part.setSeqNumber(part_++);
//	    chapter_ = 1;
	    section_ = 1;
	    subsection_ = 1;
	    subsubsection_ = 1;
	} else if (content instanceof Chapter) {
	    Chapter chapter = (Chapter)content;
	    chapter.setSeqNumber(chapter_++);
	    section_ = 1;
	    subsection_ = 1;
	    subsubsection_ = 1;
	} else if (content instanceof Section) {
	    Section section = (Section)content;
	    section.setSeqNumber(section_++);
	    subsection_ = 1;
	    subsubsection_ = 1;
	} else if (content instanceof SubSection) {
	    SubSection subsection = (SubSection)content;
	    subsection.setSeqNumber(subsection_++);
	    subsubsection_ = 1;
	} else if (content instanceof SubSubSection) {
	    SubSubSection subsubsection = (SubSubSection)content;
	    subsubsection.setSeqNumber(subsubsection_++);
	} else if (content instanceof Appendix) {
	    chapter_ = 1;
	    section_ = 1;
	    subsection_ = 1;
	    subsubsection_ = 1;
        }
    }
}
