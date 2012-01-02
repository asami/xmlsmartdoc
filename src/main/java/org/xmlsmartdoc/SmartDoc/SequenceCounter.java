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

import com.AsamiOffice.util.ElementCounter;

/**
 * SequenceCounter
 *
 * @since   May. 24, 2000
 * @version Oct. 15, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SequenceCounter extends SmartDocVisitorBase {
    private int part_ = 0;
    private int chapter_ = 0;
    private int section_ = 0;
    private int subsection_ = 0;
    private int subsubsection_ = 0;
    private ElementCounter docCounter_ = new ElementCounter();
    private ElementCounter partCounter_ = null;
    private ElementCounter chapterCounter_ = null;
    private ElementCounter sectionCounter_ = null;
    private ElementCounter subsectionCounter_ = null;
    private ElementCounter subsubsectionCounter_ = null;
    private ElementCounter appendixCounter_ = null;

    public boolean enter(Part part) {
        part_++;
        chapter_ = 0;
        section_ = 0;
        subsection_ = 0;
        subsubsection_ = 0;
        partCounter_ = new ElementCounter();
        return (true);
    }

    public boolean enter(Chapter chapter) {
        chapter_++;
        section_ = 0;
        subsection_ = 0;
        subsubsection_ = 0;
        chapterCounter_ = new ElementCounter();
        return (true);
    }

    public boolean enter(Section section) {
        section_++;
        subsection_ = 0;
        subsubsection_ = 0;
        sectionCounter_ = new ElementCounter();
        return (true);
    }

    public boolean enter(SubSection subsection) {
        subsection_++;
        subsubsection_ = 0;
        subsectionCounter_ = new ElementCounter();
        return (true);
    }

    public boolean enter(SubSubSection subsubsection) {
        subsubsection_++;
        subsubsectionCounter_ = new ElementCounter();
        return (true);
    }

    public boolean enter(Appendix appendix) {
        chapter_ = 0;
        section_ = 0;
        subsection_ = 0;
        subsubsection_ = 0;
        appendixCounter_ = new ElementCounter();
        return (true);
    }

    public boolean enter(Content content) {
        if (!(content instanceof Equation) && content.getTitle() == null) {

            return (true);
        }
        SequenceNumber number = content.getSequenceNumber();
        if (number != null) {
            visit(number);
        }
        return (!(content instanceof Bibitem));
    }

    public void leave(Part part) {
        partCounter_ = null;
    }

    public void leave(Chapter chapter) {
        chapterCounter_ = null;
    }

    public void leave(Section section) {
        sectionCounter_ = null;
    }

    public void leave(SubSection subsection) {
        subsectionCounter_ = null;
    }

    public void leave(SubSubSection subsubsection) {
        subsubsectionCounter_ = null;
    }

    public void leave(Appendix appendix) {
        appendixCounter_ = null;
    }

    public void visit(SequenceNumber sequence) {
        String name = sequence.getName();
        int count = docCounter_.getCount(name);
        sequence.setNumberInDoc(count + 1);
        docCounter_.add(name);
        if (partCounter_ != null) {
            count = partCounter_.getCount(name);
            sequence.setNumberInPart(count + 1);
            partCounter_.add(name);
        }
        if (chapterCounter_ != null) {
            count = chapterCounter_.getCount(name);
            sequence.setNumberInChapter(count + 1);
            chapterCounter_.add(name);
        }
        if (sectionCounter_ != null) {
            count = sectionCounter_.getCount(name);
            sequence.setNumberInSection(count + 1);
            sectionCounter_.add(name);
        }
        if (subsectionCounter_ != null) {
            count = subsectionCounter_.getCount(name);
            sequence.setNumberInSubSection(count + 1);
            subsectionCounter_.add(name);
        }
        if (subsubsectionCounter_ != null) {
            count = subsubsectionCounter_.getCount(name);
            sequence.setNumberInSubSubSection(count + 1);
            subsubsectionCounter_.add(name);
        }
        if (appendixCounter_ != null) {
            count = appendixCounter_.getCount(name);
            sequence.setNumberInAppendix(count + 1);
            appendixCounter_.add(name);
        }
    }
}
