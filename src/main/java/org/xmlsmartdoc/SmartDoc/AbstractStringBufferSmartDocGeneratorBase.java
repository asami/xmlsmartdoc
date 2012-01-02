/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2005  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import java.util.Date;
import java.util.List;

import org.w3c.dom.Element;

import com.AsamiOffice.xml.UDOM;
import com.AsamiOffice.xml.UXMLMaker;

/**
 * AbstractStringBufferSmartDocGeneratorBase
 *
 * @since   Nov. 12, 1998
 * @version Jun. 17, 2005
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class AbstractStringBufferSmartDocGeneratorBase
    extends AbstractSmartDocGeneratorBase {

    protected void _makeDoc(Doc doc, StringBuffer buffer) {
        Head head = doc.getHead();
        Body body = doc.getBody();
        Indexdef indexdef = doc.getIndexdef();
        Bibliography bib = doc.getBibliography();
        _makePrologue(head, buffer);
        _makeHead(head, buffer);
        _makeBody(head, body, bib, indexdef, buffer);
        if (bib != null) {
            _makeBibliography(bib, buffer);
        }
        _makeEpilogue(head, buffer);
    }

    protected void _makeBody(// _makeWholePage
        Head head,
        Body body,
        Bibliography bib,
        Indexdef indexdef,
        StringBuffer buffer
    ) {
        _makeBodyPrologue(head, body, buffer);
        _makePageHeader(head, body, buffer);
        _makePower(buffer);
        _makeLanguageIndicator(head, body, buffer);
        //	_makeIndicatorTop(head, body, buffer);
        _makeTitle(head, body, buffer);
        _makeArticlePrologue(head, body, buffer);
        if (makeTOC_) {
            _makeTOC(body.getDoc(), buffer);
        }
        _makeText(body, buffer);
        /*
        	if (bib != null) {
        	    _makeBibliography(bib, buffer);
        	}
        */
        if (config_.makeIndex()) {
            if (indexdef != null) {
                _makeIndex(head, body, indexdef, buffer);
            }
        }
        _makeArticleEpilogue(head, body, buffer);
        //	_makeIndicatorBottom(head, body, buffer);
        _makePageFooter(head, body, buffer);
        _makeBodyEpilogue(head, body, buffer);
    }

    protected void _makeTitlePage(Doc doc, StringBuffer buffer) {
        Head head = doc.getHead();
        Body body = doc.getBody();
        Indexdef indexdef = doc.getIndexdef(); // XXX : move another page
        Bibliography bib = doc.getBibliography(); // XXX : move another page
        _makePrologue(head, buffer);
        _makeHead(head, buffer);
        _makeBodyPrologue(head, body, buffer);
        _makePageHeader(head, body, buffer);
        _makePower(buffer);
        _makeLanguageIndicator(head, body, buffer);
        _makeIndicatorTop(head, body, buffer);
        _makeTitle(head, body, buffer);
        _makeArticlePrologue(head, body, buffer);
        if (makeTOC_) {
            _makeTOC(body.getDoc(), buffer);
        }
        _makeText(body, buffer);
        /*
        	if (bib != null) {
        	    _makeBibliography(bib, buffer);
        	}
        */
        if (config_.makeIndex()) {
            if (indexdef != null) {
                _makeIndex(head, body, indexdef, buffer);
            }
        }
        _makeArticleEpilogue(head, body, buffer);
        _makeIndicatorBottom(head, body, buffer);
        _makePageFooter(head, body, buffer);
        _makeBodyEpilogue(head, body, buffer);
        _makeEpilogue(head, buffer);
    }

    protected void _makePartTitlePage(
        Doc doc,
        Part part,
        StringBuffer buffer) {
        _makePartPage(doc, part, buffer);
    }

    protected void _makePartPage(Doc doc, Part part, StringBuffer buffer) {
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, buffer);
        _makeHead(head, buffer);
        _makeBodyPrologue(head, body, buffer);
        _makePageHeader(head, part, buffer);
        _makePower(buffer);
        _makeLanguageIndicator(head, body, buffer);
        _makeIndicatorTop(head, part, buffer);
        _makeArticlePrologue(head, part, buffer);
        _makePartPrologue(part, buffer);
        if (makeTOC_) {
            _makeTitleTOC(part, buffer);
        }
        _makeText(part, buffer);
        _makePartEpilogue(part, buffer);
        _makeArticleEpilogue(head, part, buffer);
        _makeIndicatorBottom(head, part, buffer);
        _makePageFooter(head, part, buffer);
        _makeBodyEpilogue(head, body, buffer);
        _makeEpilogue(head, buffer);
    }

    protected void _makeChapterTitlePage(
        Doc doc,
        Chapter chapter,
        StringBuffer buffer) {
        _makeChapterPage(doc, chapter, buffer);
    }

    protected void _makeChapterPage(
        Doc doc,
        Chapter chapter,
        StringBuffer buffer) {
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, buffer);
        _makeHead(head, buffer);
        _makeBodyPrologue(head, body, buffer);
        _makePageHeader(head, chapter, buffer);
        _makePower(buffer);
        _makeLanguageIndicator(head, body, buffer);
        _makeIndicatorTop(head, chapter, buffer);
        _makeArticlePrologue(head, chapter, buffer);
        _makeChapterPrologue(chapter, buffer);
        if (makeTOC_) {
            _makeTitleTOC(chapter, buffer);
        }
        _makeText(chapter, buffer);
        _makeChapterEpilogue(chapter, buffer);
        _makeArticleEpilogue(head, chapter, buffer);
        _makeIndicatorBottom(head, chapter, buffer);
        _makePageFooter(head, chapter, buffer);
        _makeBodyEpilogue(head, body, buffer);
        _makeEpilogue(head, buffer);
    }

    protected void _makeSectionTitlePage(
        Doc doc,
        Section section,
        StringBuffer buffer
    ) {
        _makeSectionPage(doc, section, buffer);
    }

    protected void _makeSectionPage(
        Doc doc,
        Section section,
        StringBuffer buffer
    ) {
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, buffer);
        _makeHead(head, buffer);
        _makeBodyPrologue(head, body, buffer);
        _makePageHeader(head, section, buffer);
        _makePower(buffer);
        _makeLanguageIndicator(head, body, buffer);
        _makeIndicatorTop(head, section, buffer);
        _makeArticlePrologue(head, section, buffer);
        _makeSectionPrologue(section, buffer);
        if (makeTOC_) {
            _makeTitleTOC(section, buffer);
        }
        _makeText(section, buffer);
        _makeSectionEpilogue(section, buffer);
        _makeArticleEpilogue(head, section, buffer);
        _makeIndicatorBottom(head, section, buffer);
        _makePageFooter(head, section, buffer);
        _makeBodyEpilogue(head, body, buffer);
        _makeEpilogue(head, buffer);
    }

    protected void _makeSubSectionTitlePage(
        Doc doc,
        SubSection subsection,
        StringBuffer buffer
    ) {
        _makeSubSectionPage(doc, subsection, buffer);
    }

    protected void _makeSubSectionPage(
        Doc doc,
        SubSection subsection,
        StringBuffer buffer
    ) {
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, buffer);
        _makeHead(head, buffer);
        _makeBodyPrologue(head, body, buffer);
        _makePageHeader(head, subsection, buffer);
        _makePower(buffer);
        _makeLanguageIndicator(head, body, buffer);
        _makeIndicatorTop(head, subsection, buffer);
        _makeArticlePrologue(head, subsection, buffer);
        _makeSubSectionPrologue(subsection, buffer);
        if (makeTOC_) {
            _makeTitleTOC(subsection, buffer);
        }
        _makeText(subsection, buffer);
        _makeSubSectionEpilogue(subsection, buffer);
        _makeArticleEpilogue(head, subsection, buffer);
        _makeIndicatorBottom(head, subsection, buffer);
        _makePageFooter(head, subsection, buffer);
        _makeBodyEpilogue(head, body, buffer);
        _makeEpilogue(head, buffer);
    }

    protected void _makeSubSubSectionTitlePage(
        Doc doc,
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
        _makeSubSubSectionPage(doc, subsubsection, buffer);
    }

    protected void _makeSubSubSectionPage(
        Doc doc,
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, buffer);
        _makeHead(head, buffer);
        _makeBodyPrologue(head, body, buffer);
        _makePageHeader(head, subsubsection, buffer);
        _makePower(buffer);
        _makeLanguageIndicator(head, body, buffer);
        _makeIndicatorTop(head, subsubsection, buffer);
        _makeArticlePrologue(head, subsubsection, buffer);
        _makeSubSubSectionPrologue(subsubsection, buffer);
        if (makeTOC_) {
            _makeTitleTOC(subsubsection, buffer);
        }
        _makeText(subsubsection, buffer);
        _makeSubSubSectionEpilogue(subsubsection, buffer);
        _makeArticleEpilogue(head, subsubsection, buffer);
        _makeIndicatorBottom(head, subsubsection, buffer);
        _makePageFooter(head, subsubsection, buffer);
        _makeBodyEpilogue(head, body, buffer);
        _makeEpilogue(head, buffer);
    }

    protected void _makeBibliographyPage(
        Doc doc,
        Bibliography bib,
        StringBuffer buffer
    ) {
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, buffer);
        _makeHead(head, buffer);
        _makeBodyPrologue(head, body, buffer);
        _makePageHeader(head, bib, buffer);
        _makePower(buffer);
        _makeLanguageIndicator(head, body, buffer);
        _makeIndicatorTop(head, bib, buffer);
        _makeArticlePrologue(head, bib, buffer);
        _makeBibliography(bib, buffer);
        _makeArticleEpilogue(head, bib, buffer);
        _makeIndicatorBottom(head, bib, buffer);
        _makePageFooter(head, bib, buffer);
        _makeBodyEpilogue(head, body, buffer);
        _makeEpilogue(head, buffer);
    }

    protected abstract void _makePrologue(Head head, StringBuffer buffer);
    protected abstract void _makeEpilogue(Head head, StringBuffer buffer);
    protected abstract void _makeHead(Head head, StringBuffer buffer);
    protected abstract void _makeBodyPrologue(
        Head head,
        Body body,
        StringBuffer buffer
    );
    protected abstract void _makeBodyEpilogue(
        Head head,
        Body body,
        StringBuffer buffer
    );

    protected void _makePageHeader(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        Header header = head.getHeader();
        if (header != null) {
            _makeText(header, buffer);
        }
    }

    protected void _makePageFooter(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        Footer footer = head.getFooter();
        if (footer != null) {
            _makeText(footer, buffer);
        }
    }

    protected void _makeArticlePrologue(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        Prologue prologue = head.getPrologue();
        if (prologue != null) {
            _makeText(prologue, buffer);
        }
    }

    protected void _makeArticleEpilogue(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
    }

    protected void _makeIndicatorTop(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        _makeIndicator(head, container, buffer);
    }

    protected void _makeIndicatorBottom(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        _makeIndicator(head, container, buffer);
    }

    protected void _makeIndicator(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
    }

    protected void _makePower(StringBuffer buffer) {
    }

    protected void _makeLanguageIndicator(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
    }

    protected abstract void _makeTitle(
        Head head,
        Container container,
        StringBuffer buffer
    );
    protected abstract void _makeTOC(Container container, StringBuffer buffer);
    // used by deployed page
    protected void _makeTitleTOC(Container container, StringBuffer buffer) {
    }
    protected abstract void _makeBibliographyPrologue(
        Bibliography bib,
        StringBuffer buffer
    );
    protected abstract void _makeBibliographyEpilogue(
        Bibliography bib,
        StringBuffer buffer
    );
    protected abstract void _makeBook(Book book, StringBuffer buffer);
    protected abstract void _makeArticle(Article article, StringBuffer buffer);
    protected abstract void _makeJournal(Journal journal, StringBuffer buffer);
    protected abstract void _makeBibMisc(BibMisc bibMisc, StringBuffer buffer);

    protected void _makeBibliography(Bibliography bib, StringBuffer buffer) {
        if (makeBibliography_ == false) {
            return;
        }
        _makeBibliographyPrologue(bib, buffer);
        Content[] entries = bib.getContents();
        for (int i = 0; i < entries.length; i++) {
            Content item = entries[i];
            if (item instanceof Book) {
                _makeBook((Book)item, buffer);
            } else if (item instanceof Article) {
                _makeArticle((Article)item, buffer);
            } else if (item instanceof Journal) {
                _makeJournal((Journal)item, buffer);
            } else if (item instanceof BibMisc) {
                _makeBibMisc((BibMisc)item, buffer);
            } else {
                throw (new InternalError("bad item = " + item));
            }
        }
        _makeBibliographyEpilogue(bib, buffer);
    }

    protected abstract void _makeIndex(
        Head head,
        Body body,
        Indexdef indexdef,
        StringBuffer buffer
    );

    protected abstract void _makeSentence(
        Sentence sentence,
        StringBuffer buffer
    );
    protected abstract void _makeParagraph(Paragraph p, StringBuffer buffer);

    protected void _makePart(Part part, StringBuffer buffer) {
        if (makePart_ == false) {
            return;
        }
        _makePartPrologue(part, buffer);
        _makeText(part, buffer);
        _makePartEpilogue(part, buffer);
    }

    protected abstract void _makePartPrologue(Part part, StringBuffer buffer);

    protected abstract void _makePartEpilogue(Part part, StringBuffer buffer);

    protected void _makeChapter(Chapter chapter, StringBuffer buffer) {
        if (makeChapter_ == false) {
            return;
        }
        _makeChapterPrologue(chapter, buffer);
        _makeText(chapter, buffer);
        _makeChapterEpilogue(chapter, buffer);
    }

    protected abstract void _makeChapterPrologue(
        Chapter chapter,
        StringBuffer buffer
    );

    protected abstract void _makeChapterEpilogue(
        Chapter chapter,
        StringBuffer buffer
    );

    protected void _makeSection(Section section, StringBuffer buffer) {
        if (makeSection_ == false) {
            return;
        }
        _makeSectionPrologue(section, buffer);
        _makeText(section, buffer);
        _makeSectionEpilogue(section, buffer);
    }

    protected abstract void _makeSectionPrologue(
        Section section,
        StringBuffer buffer
    );

    protected abstract void _makeSectionEpilogue(
        Section section,
        StringBuffer buffer
    );

    protected void _makeSubSection(
        SubSection subsection,
        StringBuffer buffer
    ) {
        if (makeSubSection_ == false) {
            return;
        }
        _makeSubSectionPrologue(subsection, buffer);
        _makeText(subsection, buffer);
        _makeSubSectionEpilogue(subsection, buffer);
    }

    protected abstract void _makeSubSectionPrologue(
        SubSection subsection,
        StringBuffer buffer
    );

    protected abstract void _makeSubSectionEpilogue(
        SubSection subsection,
        StringBuffer buffer
    );

    protected void _makeSubSubSection(
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
        if (makeSubSubSection_ == false) {
            return;
        }
        _makeSubSubSectionPrologue(subsubsection, buffer);
        _makeText(subsubsection, buffer);
        _makeSubSubSectionEpilogue(subsubsection, buffer);
    }

    protected abstract void _makeSubSubSectionPrologue(
        SubSubSection subsubsection,
        StringBuffer buffer
    );

    protected abstract void _makeSubSubSectionEpilogue(
        SubSubSection subsubsection,
        StringBuffer buffer
    );

    protected abstract void _makeAppendix(
        Appendix appendix,
        StringBuffer buffer
    );
    protected abstract void _makeFYI(FYI fyi, StringBuffer buffer);
    protected abstract void _makeUl(Ul ul, StringBuffer buffer);
    protected abstract void _makeOl(Ol ol, StringBuffer buffer);
    protected abstract void _makeLi(Li li, StringBuffer buffer);
    protected abstract void _makeDl(Dl dl, StringBuffer buffer);
    protected abstract void _makeDt(Dt dt, StringBuffer buffer);
    protected abstract void _makeDd(Dd dd, StringBuffer buffer);
    protected abstract void _makeTable(Table table, StringBuffer buffer);
    protected void _makeTHead(THead thead, StringBuffer buffer) {
    }
    protected void _makeTFoot(TFoot tfoot, StringBuffer buffer) {
    }
    protected void _makeTBody(TBody tbody, StringBuffer buffer) {
    }
    protected void _makeTr(Tr tr, StringBuffer buffer) {
    }
    protected void _makeTh(Th th, StringBuffer buffer) {
    }
    protected void _makeTd(Td td, StringBuffer buffer) {
    }
    protected abstract void _makeImg(Img image, StringBuffer buffer);
    protected abstract void _makeImage(ImageFigure image, StringBuffer buffer);
    protected abstract void _makeSpan(Span span, StringBuffer buffer);
    protected abstract void _makeTerm(Term term, StringBuffer buffer);
    protected abstract void _makeIndex(Index index, StringBuffer buffer);
    protected abstract void _makeBold(Bold bold, StringBuffer buffer);
    protected abstract void _makeItalic(Italic italic, StringBuffer buffer);
    protected abstract void _makeDfn(Dfn dfn, StringBuffer buffer);
    protected abstract void _makeTt(Tt em, StringBuffer buffer);
    protected abstract void _makeEm(Em em, StringBuffer buffer);
    protected abstract void _makeStrong(Strong strong, StringBuffer buffer);
    protected abstract void _makeAbbr(Abbr abbr, StringBuffer buffer);
    protected abstract void _makeAcronym(Acronym acronym, StringBuffer buffer);
    protected abstract void _makeCode(Code code, StringBuffer buffer);
    protected abstract void _makeBlockquote(
        Blockquote blockquote,
        StringBuffer buffer
    );
    protected abstract void _makeQuote(Quote quote, StringBuffer buffer);

    protected void _makeCharBlock(CharBlock cblock, StringBuffer buffer) {
        buffer.append(_escape(cblock.getText()));
    }

    protected abstract void _makeAnchor(Anchor anchor, StringBuffer buffer);
    protected abstract void _makePre(Pre pre, StringBuffer buffer);
    protected abstract void _makeProgram(Program program, StringBuffer buffer);
    protected abstract void _makeConsole(Console console, StringBuffer buffer);
    protected abstract void _makeEquation(
        Equation equation,
        StringBuffer buffer
    );
    protected abstract void _makeDiv(Div div, StringBuffer buffer);
    protected abstract void _makeRef(Ref ref, StringBuffer buffer);
    protected abstract void _makeCite(Cite cite, StringBuffer buffer);
    protected abstract void _makeComment(Comment comment, StringBuffer buffer);
    protected abstract void _makeNote(Note note, StringBuffer buffer);

    /*
        protected void _makeGroup(Group group, StringBuffer buffer) {
    	Content[] contents = group.getContents();
    	for (int i = 0;i < contents.length;i++) {
    	    Content content = contents[i];
    	    String format = content.getFormat();
    	    if (UDoc.isAvailableFormat(format, _getFormatNames())) {
    		_makeContent(content, buffer);
    		return;
    	    }
    	}
        }
    */

    protected void _makeNative(Native n, StringBuffer buffer) {
        String src = n.getSrc();
        String content = n.getText();
        /*
        	if (src != null) {
        	    String encoding = n.getEncoding();
        	    if (encoding != null) {
        		buffer.append(USmartDoc.importText(src, encoding));
        	    } else {
        		buffer.append(USmartDoc.importText(src));
        	    }
        	}
        */
        if (content != null) {
            buffer.append(content);
        }
    }

    protected void _makeTime(TimeCommand time, StringBuffer buffer) {
        buffer.append(new Date().toString()); // XXX
    }

    protected void _makeExternalElement(
        ExternalElement external,
        StringBuffer buffer) {
        Element element = external.getElement();
        buffer.append(UDOM.getDataValue(element));
        _info("external element : " + UXMLMaker.getXMLText(element));
    }

    protected void _collectNote(Container container, List list) {
        Content[] contents = container.getContents();
        for (int i = 0; i < contents.length; i++) {
            Content content = contents[i];
            if (content instanceof Note) {
                list.add(content);
            } else if (content instanceof Container) {
                _collectNote((Container)content, list);
            }
        }
    }

    protected abstract String _escape(String string);

    /**
     * @deprecated
     */
    protected void _makeEscapedString(Content content, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
        /*
        	StringBuffer temp = new StringBuffer();
        	_makeString(content, temp);
        	buffer.append(_escape(new String(temp)));
        */
    }

    /**
     * @deprecated
     */
    protected void _makeEscapedText(Content content, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
        /*
        	StringBuffer temp = new StringBuffer();
        	_makeText(content, temp);
        	buffer.append(_escape(new String(temp)));
        */
    }

    /**
     * @deprecated
     */
    protected String _getSentenceDelimiter() {
        throw (new UnsupportedOperationException());
    }

    /*
        protected void _makeString(Content content, StringBuffer buffer) {
    	_makeText(content, buffer);
    	// XXX : obsolete logic , currenty latex2e depends this logic.
    	String delimiter = _getSentenceDelimiter();
    	int length = buffer.length();
    	int delLength = delimiter.length();
    	if (length < delLength) {
    	    return;
    	}
    	int lastPos = length - delLength;
    	if (delimiter.equals(buffer.substring(lastPos))) {
    	    buffer.delete(lastPos, length);
    	}
        }
    */
    protected void _makeString(Content content, StringBuffer buffer) {
        StringBuffer temp = new StringBuffer();
        _makeText(content, temp);
        buffer.append(new String(temp).trim());
        //	buffer.append(new String(temp)); XXX check compatibility
    }

    protected void _makeText(Content content, StringBuffer buffer) {
        if (content instanceof Container) {
            _makeText((Container)content, buffer);
        } else {
            _makeContent(content, buffer);
        }
    }

    protected void _makeText(Container container, StringBuffer buffer) {
        Content[] contents = container.getContents();
        for (int i = 0; i < contents.length; i++) {
            _makeContent(contents[i], buffer);
        }
    }

    protected void _makeContent(Content content, StringBuffer buffer) {
        if (config_.isDebug()) {
            USmartDoc.traceEnter(this, content);
        }
        try {
            StringBuffer snapshot;
            if (!config_.isBigDocument()) {
                snapshot = new StringBuffer();
            } else {
                snapshot = buffer;
            }
            if (content instanceof Sentence) {
                _makeSentence((Sentence)content, snapshot);
            } else if (content instanceof Paragraph) {
                _makeParagraph((Paragraph)content, snapshot);
            } else if (content instanceof Part) {
                _makePart((Part)content, snapshot);
            } else if (content instanceof Chapter) {
                _makeChapter((Chapter)content, snapshot);
            } else if (content instanceof Section) {
                _makeSection((Section)content, snapshot);
            } else if (content instanceof SubSection) {
                _makeSubSection((SubSection)content, snapshot);
            } else if (content instanceof SubSubSection) {
                _makeSubSubSection((SubSubSection)content, snapshot);
            } else if (content instanceof Appendix) {
                _makeAppendix((Appendix)content, snapshot);
            } else if (content instanceof Bibliography) {
                _makeBibliography((Bibliography)content, snapshot);
            } else if (content instanceof Bibliopole) {
                // do nothing
            } else if (content instanceof FYI) {
                _makeFYI((FYI)content, snapshot);
            } else if (content instanceof Ul) {
                _makeUl((Ul)content, snapshot);
            } else if (content instanceof Ol) {
                _makeOl((Ol)content, snapshot);
            } else if (content instanceof Li) {
                _makeLi((Li)content, snapshot);
            } else if (content instanceof Dl) {
                _makeDl((Dl)content, snapshot);
            } else if (content instanceof Dt) {
                _makeDt((Dt)content, snapshot);
            } else if (content instanceof Dd) {
                _makeDd((Dd)content, snapshot);
            } else if (content instanceof Table) {
                _makeTable((Table)content, snapshot);
            } else if (content instanceof THead) {
                _makeTHead((THead)content, snapshot);
            } else if (content instanceof TFoot) {
                _makeTFoot((TFoot)content, snapshot);
            } else if (content instanceof TBody) {
                _makeTBody((TBody)content, snapshot);
            } else if (content instanceof Tr) {
                _makeTr((Tr)content, snapshot);
            } else if (content instanceof Th) {
                _makeTh((Th)content, snapshot);
            } else if (content instanceof Td) {
                _makeTd((Td)content, snapshot);
            } else if (content instanceof Img) {
                _makeImg((Img)content, snapshot);
            } else if (content instanceof ImageFigure) {
                _makeImage((ImageFigure)content, snapshot);
            } else if (content instanceof Span) {
                _makeSpan((Span)content, snapshot);
            } else if (content instanceof Term) {
                _makeTerm((Term)content, snapshot);
            } else if (content instanceof Index) {
                _makeIndex((Index)content, snapshot);
            } else if (content instanceof Bold) {
                _makeBold((Bold)content, snapshot);
            } else if (content instanceof Italic) {
                _makeItalic((Italic)content, snapshot);
            } else if (content instanceof Dfn) {
                _makeDfn((Dfn)content, snapshot);
            } else if (content instanceof Tt) {
                _makeTt((Tt)content, buffer);
            } else if (content instanceof Em) {
                _makeEm((Em)content, snapshot);
            } else if (content instanceof Strong) {
                _makeStrong((Strong)content, snapshot);
            } else if (content instanceof Abbr) {
                _makeAbbr((Abbr)content, snapshot);
            } else if (content instanceof Acronym) {
                _makeAcronym((Acronym)content, buffer);
            } else if (content instanceof Cite) {
                _makeCite((Cite)content, buffer);
            } else if (content instanceof Code) {
                _makeCode((Code)content, snapshot);
            } else if (content instanceof Blockquote) {
                _makeBlockquote((Blockquote)content, snapshot);
            } else if (content instanceof Quote) {
                _makeQuote((Quote)content, snapshot);
            } else if (content instanceof CharBlock) {
                _makeCharBlock((CharBlock)content, snapshot);
            } else if (content instanceof Anchor) {
                _makeAnchor((Anchor)content, snapshot);
            } else if (content instanceof Pre) {
                _makePre((Pre)content, snapshot);
            } else if (content instanceof Program) {
                _makeProgram((Program)content, snapshot);
            } else if (content instanceof Console) {
                _makeConsole((Console)content, snapshot);
            } else if (content instanceof Equation) {
                _makeEquation((Equation)content, snapshot);
            } else if (content instanceof Div) {
                _makeDiv((Div)content, snapshot);
            } else if (content instanceof Ref) {
                _makeRef((Ref)content, snapshot);
            } else if (content instanceof Comment) {
                _makeComment((Comment)content, snapshot);
            } else if (content instanceof Note) {
                _makeNote((Note)content, snapshot);
                //	    } else if (content instanceof Group) {
                //		_makeGroup((Group)content, snapshot);
            } else if (content instanceof Native) {
                _makeNative((Native)content, snapshot);
            } else if (content instanceof TimeCommand) {
                _makeTime((TimeCommand)content, snapshot);
            } else if (content instanceof ExternalElement) {
                _makeExternalElement((ExternalElement)content, snapshot);
            } else {
                throw (new InternalError(content.toString()));
            }
            if (!config_.isBigDocument()) {
                buffer.append((Object)snapshot);
            }
            //	    System.gc();	// XXX
        } catch (SmartDocWarningException e) {
            USmartDoc.warningMessage(e.getMessage()); // XXX
        }
        if (config_.isDebug()) {
            USmartDoc.traceLeave(this, content);
        }
    }

    /**
     * @deprecated
     * @see _makeString
     */
    protected void _makeLabel(Container container, StringBuffer buffer) {
        Content[] contents = container.getContents();
        for (int i = 0; i < contents.length; i++) {
            Content content = contents[i];
            if (content instanceof Sentence) {
                _makeLabel((Sentence)content, buffer);
            } else if (content instanceof Ul) {
                _makeUl((Ul)content, buffer);
            } else if (content instanceof Ol) {
                _makeOl((Ol)content, buffer);
            } else if (content instanceof Li) {
                _makeLi((Li)content, buffer);
            } else if (content instanceof Dl) {
                _makeDl((Dl)content, buffer);
            } else if (content instanceof Dt) {
                _makeDt((Dt)content, buffer);
            } else if (content instanceof Dd) {
                _makeDd((Dd)content, buffer);
            } else if (content instanceof Span) {
                _makeSpan((Span)content, buffer);
            } else if (content instanceof Term) {
                _makeTerm((Term)content, buffer);
            } else if (content instanceof Index) {
                _makeIndex((Index)content, buffer);
            } else if (content instanceof Bold) {
                _makeBold((Bold)content, buffer);
            } else if (content instanceof Italic) {
                _makeItalic((Italic)content, buffer);
            } else if (content instanceof Dfn) {
                _makeDfn((Dfn)content, buffer);
            } else if (content instanceof Tt) {
                _makeTt((Tt)content, buffer);
            } else if (content instanceof Em) {
                _makeEm((Em)content, buffer);
            } else if (content instanceof Strong) {
                _makeStrong((Strong)content, buffer);
            } else if (content instanceof Abbr) {
                _makeAbbr((Abbr)content, buffer);
            } else if (content instanceof Acronym) {
                _makeAcronym((Acronym)content, buffer);
            } else if (content instanceof Cite) {
                _makeCite((Cite)content, buffer);
            } else if (content instanceof Code) {
                _makeCode((Code)content, buffer);
            } else if (content instanceof CharBlock) {
                _makeCharBlock((CharBlock)content, buffer);
            } else if (content instanceof Anchor) {
                _makeAnchor((Anchor)content, buffer);
            } else if (content instanceof Div) {
                _makeDiv((Div)content, buffer);
            } else if (content instanceof Ref) {
                _makeRef((Ref)content, buffer);
            } else if (content instanceof Comment) {
                _makeComment((Comment)content, buffer);
            } else if (content instanceof Note) {
                _makeNote((Note)content, buffer);
                //	    } else if (content instanceof Group) {
                //		_makeGroup((Group)content, buffer);
            } else if (content instanceof Native) {
                _makeNative((Native)content, buffer);
            } else if (content instanceof TimeCommand) {
                _makeTime((TimeCommand)content, buffer);
            }
        }
    }

    // @deprecated
    protected String _makeTitleString(String text) {
        return (UDoc.makeTitleString(text));
    }

    // @deprecated
    protected String _adjustStringInContext(String text, Content content) {
        return (UDoc.adjustStringInContext(text, content));
    }

    protected String _getString(Container container) {
        StringBuffer buffer = new StringBuffer();
        _makeString(container, buffer);
        return (new String(buffer));
    }
}
