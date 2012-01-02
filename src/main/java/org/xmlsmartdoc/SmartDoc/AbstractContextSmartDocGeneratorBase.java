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

/**
 * AbstractContextSmartDocGeneratorBase
 *
 * @since   May.  3, 2004
 * @version Jun. 17, 2005
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class AbstractContextSmartDocGeneratorBase
    extends AbstractSmartDocGeneratorBase {

    protected abstract Object _getRootContext(Doc doc);

    protected void _makeDoc(Doc doc, StringBuffer buffer) {
        Object context = _getRootContext(doc);
        Head head = doc.getHead();
        Body body = doc.getBody();
        Indexdef indexdef = doc.getIndexdef();
        Bibliography bib = doc.getBibliography();
        _makePrologue(head, context);
        _makeHead(head, context);
        _makeBody(head, body, bib, indexdef, context);
        if (bib != null) {
            _makeBibliography(bib, context);
        }
        _makeEpilogue(head, context);
        _makeBuffer(context, doc, buffer);
    }

    protected void _makeBody(// _makeWholePage
        Head head,
        Body body,
        Bibliography bib,
        Indexdef indexdef,
        Object context
    ) {
        _makeBodyPrologue(head, body, context);
        _makePageHeader(head, body, context);
        _makePower(context);
        _makeLanguageIndicator(head, body, context);
        //	_makeIndicatorTop(head, body, context);
        _makeTitle(head, body, context);
        _makeArticlePrologue(head, body, context);
        if (makeTOC_) {
            _makeTOC(body.getDoc(), context);
        }
        _makeArticleBody(body, context);
        /*
        	if (bib != null) {
        	    _makeBibliography(bib, context);
        	}
        */
        if (config_.makeIndex()) {
            if (indexdef != null) {
                _makeIndex(head, body, indexdef, context);
            }
        }
        _makeArticleEpilogue(head, body, context);
        //	_makeIndicatorBottom(head, body, context);
        _makePageFooter(head, body, context);
        _makeBodyEpilogue(head, body, context);
    }

    protected void _makeArticleBody(Body body, Object context) {
        _makeText(body, context);
    }

    protected void _makeTitlePage(Doc doc, StringBuffer buffer) {
        Object context = _getRootContext(doc);
        Head head = doc.getHead();
        Body body = doc.getBody();
        Indexdef indexdef = doc.getIndexdef(); // XXX : move another page
        Bibliography bib = doc.getBibliography(); // XXX : move another page
        _makePrologue(head, context);
        _makeHead(head, context);
        _makeBodyPrologue(head, body, context);
        _makePageHeader(head, body, context);
        _makePower(context);
        _makeLanguageIndicator(head, body, context);
        _makeIndicatorTop(head, body, context);
        _makeTitle(head, body, context);
        _makeArticlePrologue(head, body, context);
        if (makeTOC_) {
            _makeTOC(body.getDoc(), context);
        }
        _makeContainer(body, context);
        /*
        	if (bib != null) {
        	    _makeBibliography(bib, context);
        	}
        */
        if (config_.makeIndex()) {
            if (indexdef != null) {
                _makeIndex(head, body, indexdef, context);
            }
        }
        _makeArticleEpilogue(head, body, context);
        _makeIndicatorBottom(head, body, context);
        _makePageFooter(head, body, context);
        _makeBodyEpilogue(head, body, context);
        _makeEpilogue(head, context);
        _makeBuffer(context, doc, buffer);
    }

    protected void _makePartTitlePage(
        Doc doc,
        Part part,
        StringBuffer buffer
    ) {
        _makePartPage(doc, part, buffer);
    }

    protected void _makePartPage(Doc doc, Part part, StringBuffer buffer) {
        Object context = _getRootContext(doc);
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, context);
        _makeHead(head, context);
        _makeBodyPrologue(head, body, context);
        _makePageHeader(head, part, context);
        _makePower(context);
        _makeLanguageIndicator(head, body, context);
        _makeIndicatorTop(head, part, context);
        _makeArticlePrologue(head, part, context);
        _makePartPrologue(part, context);
        if (makeTOC_) {
            _makeTitleTOC(part, context);
        }
        _makePartBody(part, context);
        _makePartEpilogue(part, context);
        _makeArticleEpilogue(head, part, context);
        _makeIndicatorBottom(head, part, context);
        _makePageFooter(head, part, context);
        _makeBodyEpilogue(head, body, context);
        _makeEpilogue(head, context);
        _makeBuffer(context, doc, buffer);
    }

    protected void _makeChapterTitlePage(
        Doc doc,
        Chapter chapter,
        StringBuffer buffer
    ) {
        _makeChapterPage(doc, chapter, buffer);
    }

    protected void _makeChapterPage(
        Doc doc,
        Chapter chapter,
        StringBuffer buffer
    ) {
        Object context = _getRootContext(doc);
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, context);
        _makeHead(head, context);
        _makeBodyPrologue(head, body, context);
        _makePageHeader(head, chapter, context);
        _makePower(context);
        _makeLanguageIndicator(head, body, context);
        _makeIndicatorTop(head, chapter, context);
        _makeArticlePrologue(head, chapter, context);
        _makeChapterPrologue(chapter, context);
        if (makeTOC_) {
            _makeTitleTOC(chapter, context);
        }
        _makeChapterBody(chapter, context);
        _makeChapterEpilogue(chapter, context);
        _makeArticleEpilogue(head, chapter, context);
        _makeIndicatorBottom(head, chapter, context);
        _makePageFooter(head, chapter, context);
        _makeBodyEpilogue(head, body, context);
        _makeEpilogue(head, context);
        _makeBuffer(context, doc, buffer);
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
        Object context = _getRootContext(doc);
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, context);
        _makeHead(head, context);
        _makeBodyPrologue(head, body, context);
        _makePageHeader(head, section, context);
        _makePower(context);
        _makeLanguageIndicator(head, body, context);
        _makeIndicatorTop(head, section, context);
        _makeArticlePrologue(head, section, context);
        _makeSectionPrologue(section, context);
        if (makeTOC_) {
            _makeTitleTOC(section, context);
        }
        _makeSectionBody(section, context);
        _makeSectionEpilogue(section, context);
        _makeArticleEpilogue(head, section, context);
        _makeIndicatorBottom(head, section, context);
        _makePageFooter(head, section, context);
        _makeBodyEpilogue(head, body, context);
        _makeEpilogue(head, context);
        _makeBuffer(context, doc, buffer);
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
        Object context = _getRootContext(doc);
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, context);
        _makeHead(head, context);
        _makeBodyPrologue(head, body, context);
        _makePageHeader(head, subsection, context);
        _makePower(context);
        _makeLanguageIndicator(head, body, context);
        _makeIndicatorTop(head, subsection, context);
        _makeArticlePrologue(head, subsection, context);
        _makeSubSectionPrologue(subsection, context);
        if (makeTOC_) {
            _makeTitleTOC(subsection, context);
        }
        _makeSubSectionBody(subsection, context);
        _makeSubSectionEpilogue(subsection, context);
        _makeArticleEpilogue(head, subsection, context);
        _makeIndicatorBottom(head, subsection, context);
        _makePageFooter(head, subsection, context);
        _makeBodyEpilogue(head, body, context);
        _makeEpilogue(head, context);
        _makeBuffer(context, doc, buffer);
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
        Object context = _getRootContext(doc);
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, context);
        _makeHead(head, context);
        _makeBodyPrologue(head, body, context);
        _makePageHeader(head, subsubsection, context);
        _makePower(context);
        _makeLanguageIndicator(head, body, context);
        _makeIndicatorTop(head, subsubsection, context);
        _makeArticlePrologue(head, subsubsection, context);
        _makeSubSubSectionPrologue(subsubsection, context);
        if (makeTOC_) {
            _makeTitleTOC(subsubsection, context);
        }
        _makeSubSubSectionBody(subsubsection, context);
        _makeSubSubSectionEpilogue(subsubsection, context);
        _makeArticleEpilogue(head, subsubsection, context);
        _makeIndicatorBottom(head, subsubsection, context);
        _makePageFooter(head, subsubsection, context);
        _makeBodyEpilogue(head, body, context);
        _makeEpilogue(head, context);
        _makeBuffer(context, doc, buffer);
    }

    protected void _makeBibliographyPage(
        Doc doc,
        Bibliography bib,
        StringBuffer buffer
    ) {
        Object context = _getRootContext(doc);
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, context);
        _makeHead(head, context);
        _makeBodyPrologue(head, body, context);
        _makePageHeader(head, bib, context);
        _makePower(context);
        _makeLanguageIndicator(head, body, context);
        _makeIndicatorTop(head, bib, context);
        _makeArticlePrologue(head, bib, context);
        _makeBibliography(bib, context);
        _makeArticleEpilogue(head, bib, context);
        _makeIndicatorBottom(head, bib, context);
        _makePageFooter(head, bib, context);
        _makeBodyEpilogue(head, body, context);
        _makeEpilogue(head, context);
        _makeBuffer(context, doc, buffer);
    }

    protected void _makeBuffer(
        Object context,
        Doc doc,
        StringBuffer buffer
    ) {
        buffer.append(context.toString());
    }

    protected void _makePrologue(Head head, Object context) {
    }
    protected void _makeEpilogue(Head head, Object context) {
    }
    protected abstract void _makeHead(Head head, Object context);
    protected void _makeBodyPrologue(
        Head head,
        Body body,
        Object context
    ) {
    }
    protected void _makeBodyEpilogue(
        Head head,
        Body body,
        Object context
    ) {
    }

    protected void _makePageHeader(
        Head head,
        Container container,
        Object context
    ) {
        Header header = head.getHeader();
        if (header != null) {
            _makeContainer(header, context);
        }
    }

    protected void _makePageFooter(
        Head head,
        Container container,
        Object context
    ) {
        Footer footer = head.getFooter();
        if (footer != null) {
            _makeContainer(footer, context);
        }
    }

    protected void _makeArticlePrologue(
        Head head,
        Container container,
        Object context
    ) {
        Prologue prologue = head.getPrologue();
        if (prologue != null) {
            _makeContainer(prologue, context);
        }
    }

    protected void _makeArticleEpilogue(
        Head head,
        Container container,
        Object context
    ) {
    }

    protected void _makeIndicatorTop(
        Head head,
        Container container,
        Object context
    ) {
        _makeIndicator(head, container, context);
    }

    protected void _makeIndicatorBottom(
        Head head,
        Container container,
        Object context
    ) {
        _makeIndicator(head, container, context);
    }

    protected void _makeIndicator(
        Head head,
        Container container,
        Object context
    ) {
    }

    protected void _makePower(Object context) {
    }

    protected void _makeLanguageIndicator(
        Head head,
        Container container,
        Object context
    ) {
    }

    protected abstract void _makeTitle(
        Head head,
        Container container,
        Object context
    );
    protected abstract void _makeTOC(Container container, Object context);
    // used by deployed page
    protected void _makeTitleTOC(Container container, Object context) {
    }
    protected abstract void _makeBibliographyPrologue(
        Bibliography bib,
        Object context
    );
    protected abstract void _makeBibliographyEpilogue(
        Bibliography bib,
        Object context
    );
    protected abstract void _makeBook(Book book, Object context);
    protected abstract void _makeArticle(Article article, Object context);
    protected abstract void _makeJournal(Journal journal, Object context);
    protected abstract void _makeBibMisc(BibMisc bibMisc, Object context);

    protected void _makeBibliography(Bibliography bib, Object context) {
        if (makeBibliography_ == false) {
            return;
        }
        _makeBibliographyPrologue(bib, context);
        Content[] entries = bib.getContents();
        for (int i = 0; i < entries.length; i++) {
            Content item = entries[i];
            if (item instanceof Book) {
                _makeBook((Book)item, context);
            } else if (item instanceof Article) {
                _makeArticle((Article)item, context);
            } else if (item instanceof Journal) {
                _makeJournal((Journal)item, context);
            } else if (item instanceof BibMisc) {
                _makeBibMisc((BibMisc)item, context);
            } else {
                throw (new InternalError("bad item = " + item));
            }
        }
        _makeBibliographyEpilogue(bib, context);
    }

    protected abstract void _makeIndex(
        Head head,
        Body body,
        Indexdef indexdef,
        Object context
    );

    protected abstract void _makeSentence(
        Sentence sentence,
        Object context
    );
    protected abstract void _makeParagraph(Paragraph p, Object context);

    protected void _makePart(Part part, Object context) {
        if (makePart_ == false) {
            return;
        }
        _makePartPrologue(part, context);
        _makePartBody(part, context);
        _makePartEpilogue(part, context);
    }

    protected void _makePartPrologue(Part part, Object context) {
    }

    protected void _makePartBody(Part part, Object context) {
        _makeContainer(part, context);
    }

    protected void _makePartEpilogue(Part part, Object context) {
    }

    protected void _makeChapter(Chapter chapter, Object context) {
        if (makeChapter_ == false) {
            return;
        }
        _makeChapterPrologue(chapter, context);
        _makeChapterBody(chapter, context);
        _makeChapterEpilogue(chapter, context);
    }

    protected void _makeChapterPrologue(
        Chapter chapter,
        Object context
    ) {
    }

    protected void _makeChapterBody(Chapter chapter, Object context) {
        _makeContainer(chapter, context);
    }

    protected void _makeChapterEpilogue(
        Chapter chapter,
        Object context
    ) {
    }

    protected void _makeSection(Section section, Object context) {
        if (makeSection_ == false) {
            return;
        }
        _makeSectionPrologue(section, context);
        _makeSectionBody(section, context);
        _makeSectionEpilogue(section, context);
    }

    protected void _makeSectionPrologue(
        Section section,
        Object context
    ) {
    }

    protected void _makeSectionBody(Section section, Object context) {
        _makeContainer(section, context);
    }

    protected void _makeSectionEpilogue(
        Section section,
        Object context
    ) {
    }

    protected void _makeSubSection(
        SubSection subsection,
        Object context
    ) {
        if (makeSubSection_ == false) {
            return;
        }
        _makeSubSectionPrologue(subsection, context);
        _makeSubSectionBody(subsection, context);
        _makeSubSectionEpilogue(subsection, context);
    }

    protected void _makeSubSectionPrologue(
        SubSection subsection,
        Object context
    ) {
    }

    protected void _makeSubSectionBody(SubSection subsection, Object context) {
        _makeContainer(subsection, context);
    }

    protected void _makeSubSectionEpilogue(
        SubSection subsection,
        Object context
    ) {
    }

    protected void _makeSubSubSection(
        SubSubSection subsubsection,
        Object context
    ) {
        if (makeSubSubSection_ == false) {
            return;
        }
        _makeSubSubSectionPrologue(subsubsection, context);
        _makeSubSubSectionBody(subsubsection, context);
        _makeSubSubSectionEpilogue(subsubsection, context);
    }

    protected void _makeSubSubSectionPrologue(
        SubSubSection subsubsection,
        Object context
    ) {
    }

    protected void _makeSubSubSectionBody(
        SubSubSection subsubsection,
        Object context
    ) {
        _makeContainer(subsubsection, context);
    }

    protected void _makeSubSubSectionEpilogue(
        SubSubSection subsubsection,
        Object context
    ) {
    }

    protected abstract void _makeAppendix(
        Appendix appendix,
        Object context
    );
    protected abstract void _makeFYI(FYI fyi, Object context);
    protected abstract void _makeUl(Ul ul, Object context);
    protected abstract void _makeOl(Ol ol, Object context);
    protected abstract void _makeLi(Li li, Object context);
    protected abstract void _makeDl(Dl dl, Object context);
    protected abstract void _makeDt(Dt dt, Object context);
    protected abstract void _makeDd(Dd dd, Object context);
    protected abstract void _makeTable(Table table, Object context);
    protected void _makeTHead(THead thead, Object context) {
    }
    protected void _makeTFoot(TFoot tfoot, Object context) {
    }
    protected void _makeTBody(TBody tbody, Object context) {
    }
    protected void _makeTr(Tr tr, Object context) {
    }
    protected void _makeTh(Th th, Object context) {
    }
    protected void _makeTd(Td td, Object context) {
    }
    protected abstract void _makeImg(Img image, Object context);
    protected abstract void _makeImage(ImageFigure image, Object context);
    protected abstract void _makeSpan(Span span, Object context);
    protected abstract void _makeTerm(Term term, Object context);
    protected abstract void _makeIndex(Index index, Object context);
    protected abstract void _makeBold(Bold bold, Object context);
    protected abstract void _makeItalic(Italic italic, Object context);
    protected abstract void _makeDfn(Dfn dfn, Object context);
    protected abstract void _makeTt(Tt em, Object context);
    protected abstract void _makeEm(Em em, Object context);
    protected abstract void _makeStrong(Strong strong, Object context);
    protected abstract void _makeAbbr(Abbr abbr, Object context);
    protected abstract void _makeAcronym(Acronym acronym, Object context);
    protected abstract void _makeCode(Code code, Object context);
    protected abstract void _makeBlockquote(
        Blockquote blockquote,
        Object context
    );
    protected abstract void _makeQuote(Quote quote, Object context);
    protected abstract void _makeCharBlock(CharBlock cblock, Object context);
    protected abstract void _makeAnchor(Anchor anchor, Object context);
    protected abstract void _makePre(Pre pre, Object context);
    protected abstract void _makeProgram(Program program, Object context);
    protected abstract void _makeConsole(Console console, Object context);
    protected abstract void _makeEquation(
        Equation equation,
        Object context
    );
    protected abstract void _makeDiv(Div div, Object context);
    protected abstract void _makeRef(Ref ref, Object context);
    protected abstract void _makeCite(Cite cite, Object context);
    protected abstract void _makeComment(Comment comment, Object context);
    protected abstract void _makeNote(Note note, Object context);
    protected abstract void _makeNative(Native n, Object context);
    protected abstract void _makeTime(TimeCommand time, Object context);
    protected abstract void _makeExternalElement(
        ExternalElement external,       
        Object context
    );
    protected abstract String _escape(String string);

    protected void _makeText(Content content, Object context) {
        if (content instanceof Container) {
            _makeContainer((Container)content, context);
        } else {
            _makeContent(content, context);
        }
    }

    protected void _makeContainer(Container container, Object context) {
        Content[] contents = container.getContents();
        for (int i = 0; i < contents.length; i++) {
            _makeContent(contents[i], context);
        }
    }

    protected void _makeContent(Content content, Object context) {
        if (config_.isDebug()) {
            USmartDoc.traceEnter(this, content);
        }
        try {
            if (content instanceof Sentence) {
                _makeSentence((Sentence)content, context);
            } else if (content instanceof Paragraph) {
                _makeParagraph((Paragraph)content, context);
            } else if (content instanceof Part) {
                _makePart((Part)content, context);
            } else if (content instanceof Chapter) {
                _makeChapter((Chapter)content, context);
            } else if (content instanceof Section) {
                _makeSection((Section)content, context);
            } else if (content instanceof SubSection) {
                _makeSubSection((SubSection)content, context);
            } else if (content instanceof SubSubSection) {
                _makeSubSubSection((SubSubSection)content, context);
            } else if (content instanceof Appendix) {
                _makeAppendix((Appendix)content, context);
            } else if (content instanceof Bibliography) {
                _makeBibliography((Bibliography)content, context);
            } else if (content instanceof Bibliopole) {
                // do nothing
            } else if (content instanceof FYI) {
                _makeFYI((FYI)content, context);
            } else if (content instanceof Ul) {
                _makeUl((Ul)content, context);
            } else if (content instanceof Ol) {
                _makeOl((Ol)content, context);
            } else if (content instanceof Li) {
                _makeLi((Li)content, context);
            } else if (content instanceof Dl) {
                _makeDl((Dl)content, context);
            } else if (content instanceof Dt) {
                _makeDt((Dt)content, context);
            } else if (content instanceof Dd) {
                _makeDd((Dd)content, context);
            } else if (content instanceof Table) {
                _makeTable((Table)content, context);
            } else if (content instanceof THead) {
                _makeTHead((THead)content, context);
            } else if (content instanceof TFoot) {
                _makeTFoot((TFoot)content, context);
            } else if (content instanceof TBody) {
                _makeTBody((TBody)content, context);
            } else if (content instanceof Tr) {
                _makeTr((Tr)content, context);
            } else if (content instanceof Th) {
                _makeTh((Th)content, context);
            } else if (content instanceof Td) {
                _makeTd((Td)content, context);
            } else if (content instanceof Img) {
                _makeImg((Img)content, context);
            } else if (content instanceof ImageFigure) {
                _makeImage((ImageFigure)content, context);
            } else if (content instanceof Span) {
                _makeSpan((Span)content, context);
            } else if (content instanceof Term) {
                _makeTerm((Term)content, context);
            } else if (content instanceof Index) {
                _makeIndex((Index)content, context);
            } else if (content instanceof Bold) {
                _makeBold((Bold)content, context);
            } else if (content instanceof Italic) {
                _makeItalic((Italic)content, context);
            } else if (content instanceof Dfn) {
                _makeDfn((Dfn)content, context);
            } else if (content instanceof Tt) {
                _makeTt((Tt)content, context);
            } else if (content instanceof Em) {
                _makeEm((Em)content, context);
            } else if (content instanceof Strong) {
                _makeStrong((Strong)content, context);
            } else if (content instanceof Abbr) {
                _makeAbbr((Abbr)content, context);
            } else if (content instanceof Acronym) {
                _makeAcronym((Acronym)content, context);
            } else if (content instanceof Cite) {
                _makeCite((Cite)content, context);
            } else if (content instanceof Code) {
                _makeCode((Code)content, context);
            } else if (content instanceof Blockquote) {
                _makeBlockquote((Blockquote)content, context);
            } else if (content instanceof Quote) {
                _makeQuote((Quote)content, context);
            } else if (content instanceof CharBlock) {
                _makeCharBlock((CharBlock)content, context);
            } else if (content instanceof Anchor) {
                _makeAnchor((Anchor)content, context);
            } else if (content instanceof Pre) {
                _makePre((Pre)content, context);
            } else if (content instanceof Program) {
                _makeProgram((Program)content, context);
            } else if (content instanceof Console) {
                _makeConsole((Console)content, context);
            } else if (content instanceof Equation) {
                _makeEquation((Equation)content, context);
            } else if (content instanceof Div) {
                _makeDiv((Div)content, context);
            } else if (content instanceof Ref) {
                _makeRef((Ref)content, context);
            } else if (content instanceof Comment) {
                _makeComment((Comment)content, context);
            } else if (content instanceof Note) {
                _makeNote((Note)content, context);
                //	    } else if (content instanceof Group) {
                //		_makeGroup((Group)content, context);
            } else if (content instanceof Native) {
                _makeNative((Native)content, context);
            } else if (content instanceof TimeCommand) {
                _makeTime((TimeCommand)content, context);
            } else if (content instanceof ExternalElement) {
                _makeExternalElement((ExternalElement)content, context);
            } else {
                throw (new InternalError(content.toString()));
            }
        } catch (SmartDocWarningException e) {
            USmartDoc.warningMessage(e.getMessage()); // XXX
        }
        if (config_.isDebug()) {
            USmartDoc.traceLeave(this, content);
        }
    }
}
