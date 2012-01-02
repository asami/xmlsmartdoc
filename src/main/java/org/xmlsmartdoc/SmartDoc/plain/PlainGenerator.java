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
package org.xmlsmartdoc.SmartDoc.plain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.xmlsmartdoc.SmartDoc.Abbr;
import org.xmlsmartdoc.SmartDoc.AbstractSmartDocGeneratorBase;
import org.xmlsmartdoc.SmartDoc.Acronym;
import org.xmlsmartdoc.SmartDoc.Anchor;
import org.xmlsmartdoc.SmartDoc.Appendix;
import org.xmlsmartdoc.SmartDoc.Article;
import org.xmlsmartdoc.SmartDoc.BibMisc;
import org.xmlsmartdoc.SmartDoc.Bibitem;
import org.xmlsmartdoc.SmartDoc.Bibliography;
import org.xmlsmartdoc.SmartDoc.Bibliopole;
import org.xmlsmartdoc.SmartDoc.Blockquote;
import org.xmlsmartdoc.SmartDoc.Body;
import org.xmlsmartdoc.SmartDoc.Bold;
import org.xmlsmartdoc.SmartDoc.Book;
import org.xmlsmartdoc.SmartDoc.CSSStyle;
import org.xmlsmartdoc.SmartDoc.Chapter;
import org.xmlsmartdoc.SmartDoc.CharBlock;
import org.xmlsmartdoc.SmartDoc.Cite;
import org.xmlsmartdoc.SmartDoc.Code;
import org.xmlsmartdoc.SmartDoc.Comment;
import org.xmlsmartdoc.SmartDoc.Console;
import org.xmlsmartdoc.SmartDoc.Container;
import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.Dd;
import org.xmlsmartdoc.SmartDoc.Dfn;
import org.xmlsmartdoc.SmartDoc.Div;
import org.xmlsmartdoc.SmartDoc.Dl;
import org.xmlsmartdoc.SmartDoc.Doc;
import org.xmlsmartdoc.SmartDoc.DocAuthor;
import org.xmlsmartdoc.SmartDoc.DocDate;
import org.xmlsmartdoc.SmartDoc.Dt;
import org.xmlsmartdoc.SmartDoc.Em;
import org.xmlsmartdoc.SmartDoc.Equation;
import org.xmlsmartdoc.SmartDoc.ExternalElement;
import org.xmlsmartdoc.SmartDoc.FYI;
import org.xmlsmartdoc.SmartDoc.Footer;
import org.xmlsmartdoc.SmartDoc.Head;
import org.xmlsmartdoc.SmartDoc.Header;
import org.xmlsmartdoc.SmartDoc.ImageFigure;
import org.xmlsmartdoc.SmartDoc.Img;
import org.xmlsmartdoc.SmartDoc.Index;
import org.xmlsmartdoc.SmartDoc.Indexdef;
import org.xmlsmartdoc.SmartDoc.Italic;
import org.xmlsmartdoc.SmartDoc.Journal;
import org.xmlsmartdoc.SmartDoc.Li;
import org.xmlsmartdoc.SmartDoc.Native;
import org.xmlsmartdoc.SmartDoc.Note;
import org.xmlsmartdoc.SmartDoc.Ol;
import org.xmlsmartdoc.SmartDoc.Paragraph;
import org.xmlsmartdoc.SmartDoc.Part;
import org.xmlsmartdoc.SmartDoc.Pre;
import org.xmlsmartdoc.SmartDoc.Program;
import org.xmlsmartdoc.SmartDoc.Prologue;
import org.xmlsmartdoc.SmartDoc.Quote;
import org.xmlsmartdoc.SmartDoc.Ref;
import org.xmlsmartdoc.SmartDoc.Section;
import org.xmlsmartdoc.SmartDoc.Sentence;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocFormatConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocWarningException;
import org.xmlsmartdoc.SmartDoc.Span;
import org.xmlsmartdoc.SmartDoc.Strong;
import org.xmlsmartdoc.SmartDoc.SubSection;
import org.xmlsmartdoc.SmartDoc.SubSubSection;
import org.xmlsmartdoc.SmartDoc.Summary;
import org.xmlsmartdoc.SmartDoc.TBody;
import org.xmlsmartdoc.SmartDoc.TFoot;
import org.xmlsmartdoc.SmartDoc.THead;
import org.xmlsmartdoc.SmartDoc.TOCNode;
import org.xmlsmartdoc.SmartDoc.Table;
import org.xmlsmartdoc.SmartDoc.Td;
import org.xmlsmartdoc.SmartDoc.Term;
import org.xmlsmartdoc.SmartDoc.Th;
import org.xmlsmartdoc.SmartDoc.TimeCommand;
import org.xmlsmartdoc.SmartDoc.Title;
import org.xmlsmartdoc.SmartDoc.TitledBlock;
import org.xmlsmartdoc.SmartDoc.Tr;
import org.xmlsmartdoc.SmartDoc.Tt;
import org.xmlsmartdoc.SmartDoc.UDoc;
import org.xmlsmartdoc.SmartDoc.Ul;
import com.AsamiOffice.jaba2.text.cui.CBoardBase;
import com.AsamiOffice.jaba2.text.cui.CPanel;
import org.xmlsmartdoc.SmartDoc.mathml.rParts.MMath;
import org.xmlsmartdoc.SmartDoc.mathml.rParts.URVisitor;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlsmartdoc.SmartDoc.mathml.LaTeXMaker;

import com.AsamiOffice.xml.UXMLMaker;

/**
 * PlainGenerator
 *
 * @since   Jun. 21, 1999
 * @version Nov. 25, 2006
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class PlainGenerator extends AbstractSmartDocGeneratorBase {
    private PlainConfig plainConfig_;
    private List notes_ = new ArrayList();

    // AbstractGenerator
    public void init(SmartDocConfig config, SmartDocFormatConfig fconfig) {
        super.init(config, fconfig);
        plainConfig_ = (PlainConfig)fconfig;
    }

    protected void _makeDoc(Doc doc, StringBuffer buffer) {
        TNode node = new TContainer();
        Head head = doc.getHead();
        Body body = doc.getBody();
        Indexdef indexdef = doc.getIndexdef();
        Bibliography bib = doc.getBibliography();
        _makePrologue(head, node);
        _makeHead(head, node);
        _makeBody(head, body, bib, indexdef, node);
        _makeEpilogue(head, node);
//        UPlain.printTNode(node, buffer);
//                                // temporary
        _makeScreen(node, buffer);
    }

    protected void _makeTitlePage(
        Doc doc,
        StringBuffer buffer
    ) {
        TNode node = new TContainer();
        Head head = doc.getHead();
        Body body = doc.getBody();
        Indexdef indexdef = doc.getIndexdef(); // XXX : move another page
        Bibliography bib = doc.getBibliography(); // XXX : move another page
        _makePrologue(head, node);
        _makeHead(head, node);
        _makeBodyPrologue(head, body, node);
        _makePageHeader(head, body, node);
        _makePower(node);
        _makeLanguageIndicator(head, body, node);
        _makeIndicatorTop(head, body, node);
        _makeTitle(head, body, node);
        _makeArticlePrologue(head, body, node);
        if (makeTOC_) {
            _makeTOC(body, node);
        }
        _makeContent(body, node);
        if (bib != null) {
            _makeBibliography(bib, node);
        }
        if (config_.makeIndex()) {
            if (indexdef != null) {
                _makeIndex(head, body, indexdef, node);
            }
        }
        _makeArticleEpilogue(head, body, node);
        _makeIndicatorBottom(head, body, node);
        _makePageFooter(head, body, node);
        _makeBodyEpilogue(head, body, node);
        _makeEpilogue(head, node);
        _makeScreen(node, buffer);
    }

    protected void _makeScreen(TNode node, StringBuffer buffer) {
        CPanel root = new CPanel();
        node.format(root);
        CBoardBase screen = new CBoardBase();
        screen.setNewline(plainConfig_.getNewline());
        root.layout(plainConfig_.getLayoutWidth());
        root.draw(screen);
        screen.makeScreen(buffer);
    }

    protected void _makePartTitlePage(
        Doc doc,
        Part part,
        StringBuffer buffer
    ) {
        _makePartPage(doc, part, buffer);
    }

    protected void _makePartPage(
        Doc doc,
        Part part,
        StringBuffer buffer
    ) {
        TNode node = new TContainer();
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, node);
        _makeHead(head, node);
        _makeBodyPrologue(head, body, node);
        _makePageHeader(head, part, node);
        _makePower(node);
        _makeLanguageIndicator(head, body, node);
        _makeIndicatorTop(head, part, node);
        _makeArticlePrologue(head, part, node);
        _makePartPrologue(part, node);
        if (makeTOC_) {
            _makeTitleTOC(part, node);
        }
        _makeContent(part, node);
        _makePartEpilogue(part, node);
        _makeArticleEpilogue(head, part, node);
        _makeIndicatorBottom(head, part, node);
        _makePageFooter(head, part, node);
        _makeBodyEpilogue(head, body, node);
        _makeEpilogue(head, node);
        UPlain.printTNode(node, buffer);
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
        TNode node = new TContainer();
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, node);
        _makeHead(head, node);
        _makeBodyPrologue(head, body, node);
        _makePageHeader(head, chapter, node);
        _makePower(node);
        _makeLanguageIndicator(head, body, node);
        _makeIndicatorTop(head, chapter, node);
        _makeArticlePrologue(head, chapter, node);
        _makeChapterPrologue(chapter, node);
        if (makeTOC_) {
            _makeTitleTOC(chapter, node);
        }
        _makeContent(chapter, node);
        _makeChapterEpilogue(chapter, node);
        _makeArticleEpilogue(head, chapter, node);
        _makeIndicatorBottom(head, chapter, node);
        _makePageFooter(head, chapter, node);
        _makeBodyEpilogue(head, body, node);
        _makeEpilogue(head, node);
        UPlain.printTNode(node, buffer);
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
        TNode node = new TContainer();
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, node);
        _makeHead(head, node);
        _makeBodyPrologue(head, body, node);
        _makePageHeader(head, section, node);
        _makePower(node);
        _makeLanguageIndicator(head, body, node);
        _makeIndicatorTop(head, section, node);
        _makeArticlePrologue(head, section, node);
        _makeSectionPrologue(section, node);
        if (makeTOC_) {
            _makeTitleTOC(section, node);
        }
        _makeContent(section, node);
        _makeSectionEpilogue(section, node);
        _makeArticleEpilogue(head, section, node);
        _makeIndicatorBottom(head, section, node);
        _makePageFooter(head, section, node);
        _makeBodyEpilogue(head, body, node);
        _makeEpilogue(head, node);
        UPlain.printTNode(node, buffer);
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
        TNode node = new TContainer();
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, node);
        _makeHead(head, node);
        _makeBodyPrologue(head, body, node);
        _makePageHeader(head, subsection, node);
        _makePower(node);
        _makeLanguageIndicator(head, body, node);
        _makeIndicatorTop(head, subsection, node);
        _makeArticlePrologue(head, subsection, node);
        _makeSubSectionPrologue(subsection, node);
        if (makeTOC_) {
            _makeTitleTOC(subsection, node);
        }
        _makeContent(subsection, node);
        _makeSubSectionEpilogue(subsection, node);
        _makeArticleEpilogue(head, subsection, node);
        _makeIndicatorBottom(head, subsection, node);
        _makePageFooter(head, subsection, node);
        _makeBodyEpilogue(head, body, node);
        _makeEpilogue(head, node);
        UPlain.printTNode(node, buffer);
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
        TNode node = new TContainer();
        Head head = doc.getHead();
        Body body = doc.getBody();
        _makePrologue(head, node);
        _makeHead(head, node);
        _makeBodyPrologue(head, body, node);
        _makePageHeader(head, subsubsection, node);
        _makePower(node);
        _makeLanguageIndicator(head, body, node);
        _makeIndicatorTop(head, subsubsection, node);
        _makeArticlePrologue(head, subsubsection, node);
        _makeSubSubSectionPrologue(subsubsection, node);
        if (makeTOC_) {
            _makeTitleTOC(subsubsection, node);
        }
        _makeContent(subsubsection, node);
        _makeSubSubSectionEpilogue(subsubsection, node);
        _makeArticleEpilogue(head, subsubsection, node);
        _makeIndicatorBottom(head, subsubsection, node);
        _makePageFooter(head, subsubsection, node);
        _makeBodyEpilogue(head, body, node);
        _makeEpilogue(head, node);
        UPlain.printTNode(node, buffer);
    }

    protected void _makeBibliographyPage(
        Doc doc,
        Bibliography bib,
        StringBuffer buffer
    ) {
    }

    // implementation
    // dvide to AbstractNodeGeneratorBase

    protected void _makePrologue(Head head, Node node) {
        // do nothing
    }

    protected void _makeEpilogue(Head head, Node node) {
        // do nothing
    }

    protected void _makeHead(Head head, Node node) {
        // do nothing
    }

    protected void _makeBody(        // _makeWholePage
        Head head,
        Body body,
        Bibliography bib,
        Indexdef indexdef,
        Node node
    ) {
        _makeBodyPrologue(head, body, node);
        _makePageHeader(head, body, node);
        _makePower(node);
        _makeLanguageIndicator(head, body, node);
//        _makeIndicatorTop(head, body, node);
        _makeTitle(head, body, node);
        _makeArticlePrologue(head, body, node);
        if (makeTOC_) {
            _makeTOC(body, node);
        }
        _makeContent(body, node);
        if (bib != null) {
            _makeBibliography(bib, node);
        }
        if (config_.makeIndex()) {
            if (indexdef != null) {
                _makeIndex(head, body, indexdef, node);
            }
        }
        _makeArticleEpilogue(head, body, node);
//        _makeIndicatorBottom(head, body, node);
        _makePageFooter(head, body, node);
        _makeBodyEpilogue(head, body, node);
    }

    protected void _makeBodyPrologue(
        Head head,
        Body body,
        Node node
    ) {
        // do nothing
    }

    protected void _makeBodyEpilogue(
        Head head,
        Body body,
        Node node
    ) {
        _buildNoteBody(body, node);
    }

    protected void _makePageHeader(
        Head head,
        Container container,
        Node node
    ) {
        Header header = head.getHeader();
        if (header != null) {
            _makeContent(header, node);
        }
    }

    protected void _makePageFooter(
        Head head,
        Container container,
        Node node
    ) {
        Footer footer = head.getFooter();
        if (footer != null) {
            _makeContent(footer, node);
        }
    }

    protected void _makeArticlePrologue(
        Head head,
        Container container,
        Node node
    ) {
        Prologue prologue = head.getPrologue();
        if (prologue != null) {
            _makeContent(prologue, node);
        }
    }

    protected void _makeArticleEpilogue(
        Head head,
        Container container,
        Node node
    ) {
        // do nothing
    }

    protected void _makeIndicatorTop(
        Head head,
        Container container,
        Node node
    ) {
        _makeIndicator(head, container, node);
    }

    protected void _makeIndicatorBottom(
        Head head,
        Container container,
        Node node
    ) {
        _makeIndicator(head, container, node);
    }

    protected void _makeIndicator(
        Head head,
        Container container,
        Node node
    ) {
        // do nothing
    }

    protected void _makePower(Node node) {
        // do nothing
    }

    protected void _makeLanguageIndicator(
        Head head,
        Container container,
        Node node
    ) {
        // do nothing
    }

    protected void _makeTitle(
        Head head,
        Container container,
        Node node
    ) {
        Title title = head.getDocTitle();
        String org = head.getOrg();
        boolean preOrg = head.getPreOrg();
        DocAuthor[] authors = head.getAuthors();
        String email = head.getEMail();
        String hp = head.getHP();
        DocDate date = head.getDate();
        Summary summary = head.getSummary();
        if (title != null) {
            THeading theading = new THeading(title.getText());
            theading.setEpilogueSpan(1);
//            theading.setUnderline("=");
            theading.setUnderline(plainConfig_.getThickUnderline());
            theading.setAlign("center");
            node.appendChild(theading);
        }
        if (date != null) {
            node.appendChild(UTTree.makeSimpleCenterHeading(date.getText()));
        }
        if (preOrg) {
            if (org != null) {
                node.appendChild(UTTree.makeSimpleCenterHeading(org));
            }
        }
        if (authors != null) {
            for (int i = 0;i < authors.length;i++) {
                _makeDocAuthor(authors[i], node);
            }
        }
        if (!preOrg) {
            if (org != null) {
                node.appendChild(UTTree.makeSimpleCenterHeading(org));
            }
        }
        if (email != null) {
            node.appendChild(UTTree.makeSimpleCenterHeading(email));
        }
        if (hp != null) {
            node.appendChild(UTTree.makeSimpleCenterHeading(hp));
        }
        if (summary != null) {
            TFrameDiv frame = new TFrameDiv(plainConfig_.getKeisenStyle());
            frame.setTopGap(1);
            frame.setBottomGap(1);
            _makeContent(summary, frame);
            node.appendChild(frame);
        }
    }

    private void _makeDocAuthor(DocAuthor author, Node node) {
        String name = UDoc.distillText(author);
        String note = author.getNote();
        String email = author.getEMail();
        String hp = author.getHP();
        String org = author.getOrg();
        StringBuffer buffer = new StringBuffer();
        buffer.append(name);
        if (org != null || email != null || hp != null || note != null) {
            buffer.append("(");
        }
        if (email != null) {
            buffer.append(email);
        }
        if (hp != null) {
            if (email != null) {
                buffer.append(", ");
            }
            buffer.append(hp);
        }
        if (org != null) {
            if (email != null || hp != null) {
                buffer.append(", ");
            }
            buffer.append(org);
            }
        if (note != null) {
            if (org != null || email != null || hp != null) {
                buffer.append(", ");
            }
            buffer.append(note);
        }
        if (org != null || email != null || hp != null || note != null) {
            buffer.append(")");
        }
        node.appendChild(UTTree.makeSimpleCenterHeading(new String(buffer)));
    }

    protected void _makeTOC(Container container, Node node) {
        THeading theading = new THeading(
            model_.getLabel("table of contents", container)
        );
        theading.setUnderline(plainConfig_.getThinUnderline());
        node.appendChild(theading);
        _makeTOCNodes(container, true, node);
    }

    protected void _makeTitleTOC(
        Container container,
        Node node
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeTOCNodes(
        Container container,
        boolean isNumber,
        Node node
    ) {
        TOCNode toc = container.getTOCTree();
        _makeTOCNodes(toc, isNumber, node);
    }

    protected void _makeTOCNodes(
        TOCNode toc,
        boolean isNumber,
        Node node
    ) {
        int size = toc.getChildCount();
        if (size == 0) {
            return;
        }
        TPlainList list = new TPlainList();
        list.setIndent(2);
        for (int i = 0;i < size;i++) {
            TOCNode child = toc.getTOCNode(i);
            TitledBlock heading = child.getHeading();
            Title title = heading.getTitleNode();
            String number;
            if (isNumber) {
                number = UDoc.getTitleNo(heading, ".");
                if (number != null) {
                    number = number + "  ";
                } else {
                    number = "";
                }
            } else {
                number = "";
            }
            TItem item = new TItem();
            if (title != null) {
                item.appendChild(new TText(number + title.getText()));
            } else {
                item.appendChild(new TText(number + ""));
            }
            list.appendChild(item);
            _makeTOCNodes(child, isNumber, list);
        }
        node.appendChild(list);
    }

    protected void _makeBibliographyPrologue(
        Bibliography bib,
        Node node
    ) {
        THeading theading = new THeading(
            model_.getLabel("bibliography", bib)
        );
        theading.setUnderline(plainConfig_.getThinUnderline());
        node.appendChild(theading);
    }

    protected void _makeBibliographyEpilogue(
        Bibliography bib,
        Node node
    ) {
        // do nothing
    }

    protected void _makeBook(Book book, TDList list) {
        Locale locale = UDoc.getDisplayLocale(book);
        String[] authors = book.getAuthors();
        String[] editors = book.getEditors();
        String title = book.getTitle();
        String subtitle = book.getSubTitle();
        String edition = book.getEdition();
        String publisher = book.getPublisher();
        String year = book.getYear();
        String note = book.getNote();
        String uri = book.getUri();
        String term = "[" + UDoc.getSequenceNumberBasedSubSubSection(book) + "]";
        StringBuffer buffer = new StringBuffer();
        if (editors != null) {
            _makeEditors(editors, buffer, locale);
            buffer.append(". ");
        } else {
            if (authors != null && authors.length > 0) {
                _makeAuthors(authors, buffer);
                buffer.append(". ");
            }
        }
        if (title != null) {
            buffer.append(title);
            if (subtitle != null) {
                buffer.append(" : ");
                buffer.append(subtitle);
            }
            buffer.append(". ");
        }
        if (edition != null) {
//            buffer.append(config_.getEditionLabel(edition, locale));
            buffer.append(edition);
            buffer.append(", ");
        }
        if (publisher != null) {
            buffer.append(_escape(publisher));
            buffer.append(", ");
        }
        if (year != null) {
            buffer.append(year);
            buffer.append(". ");
        }
        if (note != null) {
            buffer.append(note);
        } else if (uri != null) {
            buffer.append(uri);
        }
        buffer.append("\n");
        _makeBibEntry(term, new String(buffer), list);
    }

    protected void _makeArticle(Article article, TDList list) {
        Locale locale = UDoc.getDisplayLocale(article);
        String authors[] = article.getAuthors();
        String title = article.getTitle();
        String subtitle = article.getSubTitle();
        String pages = article.getPages();
        Journal journal = article.getJournal();
        String publisher = null;
        if (journal != null) {
            publisher = journal.getPublisher();
        }
        String year = null;
        if (journal != null) {
            year = journal.getYear();
        }
        String month = null;
        if (journal != null) {
            month = journal.getMonth();
        }
        String volume = null;
        if (journal != null) {
            volume = journal.getVolume();
        }
        String number = null;
        if (journal != null) {
            number = journal.getNumber();
        }
        String note = article.getNote();
        String uri = article.getUri();
        String term = "[" + UDoc.getSequenceNumberBasedSubSubSection(article) + "]";
        StringBuffer buffer = new StringBuffer();
        if (authors != null && authors.length > 0) {
            _makeAuthors(authors, buffer);
            buffer.append(". ");
        }
        if (title != null) {
            buffer.append(title);
            if (subtitle != null) {
                buffer.append(" : ");
                buffer.append(subtitle);
            }
            buffer.append(". ");
        }
        if (journal != null) {
            buffer.append(_escape(journal.getTitle()));
        }
        if (pages != null) {
            buffer.append(" ");
            buffer.append(_escape(pages));
        }
        if (volume != null) {
//            buffer.append(" Vol. ");
            buffer.append(" ");
            buffer.append(_escape(volume));
        }
        if (number != null) {
//            buffer.append(" No. ");
            buffer.append(" ");
            buffer.append(_escape(number));
        }
/*
        if (year > 0) {
            buffer.append(" ");
            buffer.append(config_.getYearLabel(year, locale));
        }
*/
        if (month != null) {
            buffer.append(" ");
            buffer.append(_escape(month));
//            buffer.append(config_.getMonthLabel(month, locale));
        }
        if (publisher != null) {
            buffer.append(".");
            buffer.append(_escape(publisher));
        }
        if (year != null) {
            buffer.append(", ");
            buffer.append(_escape(year));
            buffer.append(". ");
        }
        if (note != null) {
            buffer.append(note);
        } else if (uri != null) {
            buffer.append(uri);
        }
        buffer.append("\n");
        _makeBibEntry(term, new String(buffer), list);
    }

    protected void _makeJournal(Journal journal, TDList list) {
        Locale locale = UDoc.getDisplayLocale(journal);
        String title = journal.getTitle();
        String publisher = journal.getPublisher();
        String year = journal.getYear();
        String month = journal.getMonth();
        String volume = journal.getVolume();
        String number = journal.getNumber();
        String note = journal.getNote();
        String uri = journal.getUri();
        String term = "[" + UDoc.getSequenceNumberBasedSubSubSection(journal) + "]";
        StringBuffer buffer = new StringBuffer();
        if (title != null) {
            buffer.append(title);
//            if (subtitle != null) {
//                buffer.append(" : ");
//                buffer.append(subtitle);
//            }
            buffer.append(". ");
        }
        if (volume != null) {
            buffer.append(" ");
            buffer.append(_escape(volume));
        }
        if (number != null) {
            buffer.append(" ");
            buffer.append(_escape(number));
        }
        if (month != null) {
            buffer.append(" ");
            buffer.append(_escape(month));
        }
        if (publisher != null) {
            buffer.append(".");
            buffer.append(_escape(publisher));
        }
        if (year != null) {
            buffer.append(", ");
            buffer.append(_escape(year));
            buffer.append(". ");
        }
        if (note != null) {
            buffer.append(note);
        } else if (uri != null) {
            buffer.append(uri);
        }
        buffer.append("\n");
        _makeBibEntry(term, new String(buffer), list);
    }

    protected void _makeBibMisc(BibMisc misc, TDList list) {
        Locale locale = UDoc.getDisplayLocale(misc);
        String authors[] = misc.getAuthors();
        String title = misc.getTitle();
        String howpublished = misc.getHowpublished();
        String month = misc.getMonth();
        String year = misc.getYear();
        String note = misc.getNote();
        String uri = misc.getUri();
        String term = "[" + UDoc.getSequenceNumberBasedSubSubSection(misc) + "]";
        StringBuffer buffer = new StringBuffer();
        if (authors != null && authors.length > 0) {
            _makeAuthors(authors, buffer);
            buffer.append(". ");
        }
        if (title != null) {
            buffer.append(title);
//            if (subtitle != null) {
//                buffer.append(" : ");
//                buffer.append(subtitle);
//            }
            buffer.append(". ");
        }
        if (howpublished != null) {
            buffer.append(_escape(howpublished));
            buffer.append(". ");
        }
        if (month != null) {
            buffer.append(_escape(month));
            buffer.append(" ");
        }
        if (year != null) {
            buffer.append(_escape(year));
            buffer.append(". ");
        }
        if (note != null) {
            buffer.append(note);
        } else if (uri != null) {
            buffer.append(uri);
        }
        buffer.append("\n");
        _makeBibEntry(term, new String(buffer), list);
    }

    private void _makeBibEntry(String term, String desc, TDList list) {
        TDTerm termNode = new TDTerm();
        termNode.appendChild(new TText(term));
        list.appendChild(termNode);
        TDDesc descNode = new TDDesc();
        descNode.appendChild(new TText(desc));
        list.appendChild(descNode);
    }

    protected void _makeEditors(
        String editors[],
        StringBuffer buffer,
        Locale locale
    ) {
        _makeAuthors(editors, buffer);
        if (editors.length > 1) {
            buffer.append(config_.getEditorsLabel(locale));
        } else {
            buffer.append(config_.getEditorLabel(locale));
        }
    }

    protected void _makeAuthors(String authors[], StringBuffer buffer) {
        if (authors == null ||
            authors.length == 0) {
            buffer.append("anonymous");
            return;
        }
        buffer.append(authors[0]);
        for (int i = 1;i < authors.length;i++) {
            String author = authors[i];
            if (author == null || author.equals("")) {
                buffer.append(" et al.");
            } else {
                buffer.append("; ");
                buffer.append(authors[i]);
            }
        }
    }

    protected void _makeBibliography(
        Bibliography bib,
        Node node
    ) {
        _makeBibliographyPrologue(bib, node);
        TDList list = new TDList();
        list.setIndent(0);
        list.setDelimiter(" ");
        Content[] entries = bib.getContents();
        for (int i = 0;i < entries.length;i++) {
            Content item = entries[i];
            if (item instanceof Book) {
                _makeBook((Book)item, list);
            } else if (item instanceof Article) {
                _makeArticle((Article)item, list);
            } else if (item instanceof Journal) {
                _makeJournal((Journal)item, list);
            } else if (item instanceof BibMisc) {
                _makeBibMisc((BibMisc)item, list);
            } else {
                throw (new InternalError("bad item = " + item));
            }
        }
        node.appendChild(list);
        _makeBibliographyEpilogue(bib, node);
    }

    protected void _makeIndex(
        Head head,
        Body body,
        Indexdef indexdef,
        Node node
    ) {
        // XXX
    }

    protected void _makeSentence(
        Sentence sentence,
        Node node
    ) {
        _makeContent(sentence, node);
    }

    protected void _makeParagraph(Paragraph p, Node node) {
        TParagraph tp = new TParagraph();
        tp.setNatural(plainConfig_.isNatural());
        if (UDoc.isFirstParagraph(p)) {
            if (UDoc.isJaStyleFirstParagraph(p)) {
                tp.setIndent("  ");
            } else {
                tp.setIndent("");
            }
        } else {
            tp.setIndent("  ");
        }
        node.appendChild(tp);
        _makeContent(p, tp);
    }

    protected void _makePartPrologue(Part part, Node node) {
        _buildNoteBody(part, node);
        THeading theading = new THeading(_getTitle(part));
        theading.setUnderline(plainConfig_.getThinUnderline());
        node.appendChild(theading);
    }

    protected void _makePartEpilogue(Part part, Node node) {
        _buildNoteBody(part, node);
    }

    protected void _makeChapterPrologue(Chapter chapter, Node node) {
        _buildNoteBody(chapter, node);
        THeading theading = new THeading(_getTitle(chapter));
        theading.setUnderline(plainConfig_.getThinUnderline());
        node.appendChild(theading);
    }

    protected void _makeChapterEpilogue(Chapter chapter, Node node) {
        _buildNoteBody(chapter, node);
    }

    protected void _makeSectionPrologue(
        Section section,
        Node node
    ) {
        _buildNoteBody(section, node);
        THeading theading = new THeading(_getTitle(section));
        theading.setUnderline(plainConfig_.getThinUnderline());
        node.appendChild(theading);
    }

    protected void _makeSectionEpilogue(
        Section section,
        Node node
    ) {
        _buildNoteBody(section, node);
    }

    protected void _makeSubSectionPrologue(
        SubSection subsection,
        Node node
    ) {
        _buildNoteBody(subsection, node);
        THeading theading = new THeading(_getTitle(subsection));
        theading.setUnderline(plainConfig_.getThinUnderline());
        node.appendChild(theading);
    }

    protected void _makeSubSectionEpilogue(
        SubSection subsection,
        Node node
    ) {
        _buildNoteBody(subsection, node);
    }

    protected void _makeSubSubSectionPrologue(
        SubSubSection subsubsection,
        Node node
    ) {
        _buildNoteBody(subsubsection, node);
        THeading theading = new THeading(_getTitle(subsubsection));
        theading.setUnderline(plainConfig_.getThinUnderline());
        node.appendChild(theading);
    }

    protected void _makeSubSubSectionEpilogue(
        SubSubSection subsubsection,
        Node node
    ) {
        _buildNoteBody(subsubsection, node);
    }

    protected void _makeAppendix(
        Appendix appendix,
        Node node
    ) {
        _buildNoteBody(appendix, node);
        THeading theading = new THeading(_getAppendixTitle(appendix));
        theading.setUnderline(plainConfig_.getThinUnderline());
        node.appendChild(theading);
        _makeContent(appendix, node);
        _buildNoteBody(appendix, node);
    }

    protected void _makeFYI(
        FYI fyi,
        Node node
    ) {
        TFrameDiv frame = new TFrameDiv(plainConfig_.getKeisenStyle());
        frame.setTopGap(1);
        frame.setBottomGap(1);
        String title = _getTitle(fyi);
        if (title != null) {
            frame.setTitle(title);
        }
        _makeContent(fyi, frame);
        node.appendChild(frame);
    }

    protected void _makeUl(Ul ul, Node node) {
        TList tl = new TUList();
        node.appendChild(tl);
        _makeContent(ul, tl);
    }

    protected void _makeOl(Ol ol, Node node) {
        TList tl = new TOList();
        node.appendChild(tl);
        makeOlContent_(ol, tl);
    }

    private void makeOlContent_(Container container, Node node) {
        TItem li = null;
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if ((content instanceof Ul || content instanceof Ol) &&
                    li != null) {
                _makeContent(content, li);
//                TList list = (TList)li.getChildren()[1];
//                list.setIndent(3);
                li = null;
            } else {
                if (content instanceof Li) {
                    li = _makeLi((Li)content, node);
                } else {
                    li = null;
                    _makeContent(content, node);
                }
            }
        }
    }

    protected TItem _makeLi(Li li, Node node) {
        TItem ti = new TItem();
        CSSStyle style = li.getStyle();
        if (style != null && "none".equals(style.getListStyleType())) {
            ti.setMark("");
        } else {
            ti.setMark("- ");
        }
        node.appendChild(ti);
        _makeContent(li, ti);
        return ti;
    }

    protected void _makeDl(Dl dl, Node node) {
        TDList tl = new TDList();
        node.appendChild(tl);
        _makeContent(dl, tl);
    }

    protected void _makeDt(Dt dt, Node node) {
        TDTerm tt = new TDTerm();
        node.appendChild(tt);
        _makeContent(dt, tt);
    }

    protected void _makeDd(Dd dd, Node node) {
        TDDesc td = new TDDesc();
        node.appendChild(td);
        _makeContent(dd, td);
    }

    protected void _makeTable(Table table, Node node) {
        TDiv frame = new TDiv();
        frame.setTopGap(1);
        frame.setBottomGap(1);
        String title = _getNumberedTitle(table, "table");
        if (title != null) {
//            frame.appendChild(UTTree.makeSimpleCenterHeading(title));
            TText head = new TText("    " + title);
            frame.appendChild(head);
        }
        TTable tt = new TTable(table);
        tt.setKeisenStyle(plainConfig_.getKeisenStyle());
        frame.appendChild(tt);
        node.appendChild(frame);
    }

    protected void _makeImg(Img img, Node node) {
        TText text = new TText("<" + img.getSrc() + ">");
        node.appendChild(text);
    }

    protected void _makeImage(ImageFigure image, Node node) {
        TDiv frame = new TDiv();
        frame.setTopGap(1);
        frame.setBottomGap(1);
        String title = _getNumberedTitle(image, "figure");
        if (title != null) {
            TText head = new TText("    " + title);
            frame.appendChild(head);
        }
        TFrameDiv view = new TFrameDiv(plainConfig_.getKeisenStyle());
        TText text = new TText("<" + image.getSrc() + ">");
        view.appendChild(text);
        frame.appendChild(view);
        node.appendChild(frame);
    }

    protected void _makeSpan(Span span, Node node) {
        _makeContent(span, node);
    }

    protected void _makeTerm(Term term, Node node) { // XXX
        _makeContent(term, node);
    }

    protected void _makeIndex(Index index, Node node) {        // XXX
        _makeContent(index, node);
    }

    protected void _makeBold(Bold bold, Node node) {
        _makeContent(bold, node);
    }

    protected void _makeItalic(Italic italic, Node node) {
        _makeContent(italic, node);
    }

    protected void _makeDfn(Dfn dfn, Node node) {
        _makeContent(dfn, node);
    }

    protected void _makeTt(Tt tt, Node node) {
        _makeContent(tt, node);
    }

    protected void _makeEm(Em em, Node node) {
        _makeContent(em, node);
    }

    protected void _makeStrong(Strong strong, Node node) {
        _makeContent(strong, node);
    }

    protected void _makeAbbr(Abbr abbr, Node node) {
        _makeContent(abbr, node);
    }

    protected void _makeAcronym(Acronym acronym, Node node) {
        _makeContent(acronym, node);
    }

    protected void _makeCode(Code code, Node node) {
        _makeContent(code, node);
    }

    protected void _makeBlockquote(
        Blockquote blockquote,
        Node node
    ) {
        TDiv tdiv = new TDiv();
        node.appendChild(tdiv);
        _makeContent(blockquote, node);
    }

    protected void _makeQuote(Quote quote, Node node) {
        node.appendChild(new TText(plainConfig_.getQuotePrologue()));
        _makeContent(quote, node);
        node.appendChild(new TText(plainConfig_.getQuoteEpilogue()));
    }

    protected void _makeAnchor(Anchor anchor, Node node) {
        _makeContent(anchor, node);
    }

    protected void _makePre(Pre pre, Node node) {
        TPre tpre = new TPre();
        _makeContent(pre, tpre);
        node.appendChild(tpre);
    }

    protected void _makeProgram(Program program, Node node) {
        TDiv frame = new TDiv();
        frame.setTopGap(1);
        frame.setBottomGap(1);
        String title = _getNumberedTitle(program, "list");
        if (title != null) {
            TText head = new TText("    " + title);
            frame.appendChild(head);
        }
        frame.appendChild(new THr(plainConfig_.getKeisenStyle()));
        TPre tpre = new TPre();
        _makeContent(program, tpre);
        frame.appendChild(tpre);
        frame.appendChild(new THr(plainConfig_.getKeisenStyle()));
        node.appendChild(frame);
    }

    protected void _makeConsole(Console console, Node node) {
        TFrameDiv frame = new TFrameDiv(plainConfig_.getKeisenStyle());
        frame.setTopGap(1);
        frame.setBottomGap(1);
        _makeContent(console, frame);
        node.appendChild(frame);
    }

    protected void _makeEquation(Equation equation, Node node) {
        TFrameDiv frame = new TFrameDiv(plainConfig_.getKeisenStyle());
        frame.setTopGap(1);
        frame.setBottomGap(1);
        frame.appendChild(new TText("    "));
        _makeContent(equation, frame);
        String tail = "    --- (" + UDoc.getSequenceNumberBasedSubSubSection(equation) + ")";
        frame.appendChild(new TText(tail));
        node.appendChild(frame);
    }

    protected void _makeDiv(Div div, Node node) {
        TDiv tdiv = new TDiv();
        _makeContent(div, tdiv);
        node.appendChild(tdiv);
    }

    protected void _makeRef(Ref ref, Node node) {
        String text = _makeString(ref);
        String href = ref.getHref();
        switch (ref.getType()) {

        case Ref.SELF_LINK:
            String label;
            Content link = ref.getLink();
            if (link != null) {
                String labelPrefix = _getLabelPrefix(ref);
                String labelSuffix = _getLabelSuffix(ref);
                if (labelPrefix != null || labelSuffix != null) {
                    String[] parts = new String[2];
                    parts[0] = labelPrefix;
                    parts[1] = labelSuffix;
                    label = UDoc.makePrefixSuffixLabel(link, parts);
                    label = UDoc.adjustStringInContext(label, ref);
                    node.appendChild(new TText(label));
                } else if (link instanceof ImageFigure) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("figure", ref),
                        ref
                    );
                    String number = UDoc.getSequenceNumberLabel(link);
                    node.appendChild(new TText(label + number));
                } else if (link instanceof Table) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("table", ref),
                        ref
                    );
                    String number = UDoc.getSequenceNumberLabel(link);
                    node.appendChild(new TText(label + number));

                } else if (link instanceof Console) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("figure", ref),
                        ref
                    );
                    String number = UDoc.getSequenceNumberLabel(link);
                    node.appendChild(new TText(label + number));
                } else if (link instanceof Program) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("list", ref),
                        ref
                    );
                    String number = UDoc.getSequenceNumberLabel(link);
                    node.appendChild(new TText(label + number));
                } else if (link instanceof Part) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("part", ref),
                        ref
                    );
                    String number = UDoc.getTitleNo(link, ".");
                    node.appendChild(new TText(label + number));
                } else if (link instanceof Chapter) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("chapter", ref),
                        ref
                    );
                    String number = UDoc.getTitleNo(link, ".");
                    node.appendChild(new TText(label + number));
                } else if (link instanceof Section) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("section", ref),
                        ref
                    );
                    String number = UDoc.getTitleNo(link, ".");
                    node.appendChild(new TText(label + number));
                } else if (link instanceof SubSection) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("section", ref),
                        ref
                    );
                    String number = UDoc.getTitleNo(link, ".");
                    node.appendChild(new TText(label + number));
                } else if (link instanceof SubSubSection) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("section", ref),
                        ref
                    );
                    String number = UDoc.getTitleNo(link, ".");
                    node.appendChild(new TText(label + number));
                } else if (link instanceof Equation) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("equation", ref),
                        ref
                    );
                    String number = UDoc.getSequenceNumberLabel(link);
                    node.appendChild(new TText(label + number));
                } else if (link instanceof Bibitem) {
                    String number = UDoc.getSequenceNumberBasedSubSubSection(link);
                    if (number == null) { // XXX
                        label =
                            "[" + 
                            UDoc.adjustStringInContext(
                                model_.getLabel("bibliography", ref),
                                ref
                            ) +
                            "]";
                    } else {
                        label = "[" + number + "]";
                    }
                    node.appendChild(new TText(label));
                } else if (link instanceof Note) {
                    Note note = (Note)link;
                    int number = note.getNumber();
                    label = _makeString(ref);
                    if (label != null) {
                        label = label + "(*" + number + ")";
                    } else {
                        label = "*" + number;
                    }
                    node.appendChild(new TText(label));
                } else {
                    label = "";
                    node.appendChild(new TText(label));
                }
            } else {
                monitor_.warning("no link : " + ref.getHref());
                label = "*unresolved*";
                node.appendChild(new TText(label));
            }
            break;
        case Ref.HYPER_LINK:
            if (text != null && !"".equals(text)) {
                node.appendChild(new TText(text + "<" + href + ">"));
            } else {
                node.appendChild(new TText(href));
            }
            break;
        case Ref.SITE_LINK:
        case Ref.UNKNOWN_LINK:
            node.appendChild(new TText("*Unknown*"));
            break;
        default:
            throw (new InternalError());
        }
    }

    protected void _makeCite(Cite cite, Node node) {
        _makeContent(cite, node);
        Content link = cite.getLink();
        if (link != null) {
            if (link instanceof Bibitem) {
                String number = UDoc.getSequenceNumberBasedSubSubSection(link);
                node.appendChild(new TText("[" + number + "]"));
                return;
            }
        }
        node.appendChild(new TText("[unknown]"));
    }

    protected void _makeComment(Comment comment, Node node) {
        TText text = new TText("<<" + comment.getSrc() + ">>");
        node.appendChild(text);
    }

    protected void _makeNote(Note note, Node node) {
        TText text = new TText("(*" + note.getNumber() + ")");
        node.appendChild(text);
        notes_.add(note);
    }

    protected void _makeNative(Native n, Node node) {
        TDiv tdiv = new TDiv();
        _makeContent(n, tdiv);
        node.appendChild(tdiv);
    }

    protected void _makeTime(TimeCommand time, Node node) {
        TText text = new TText(new Date().toString()); // XXX
        node.appendChild(text);
    }

    protected void _makeExternalElement(
        ExternalElement external,
        Node node
    ) {
        Element element = external.getElement();
        String namespaceURI = element.getNamespaceURI();
        if (namespaceURI == null) {
            _makeExternalElementAsIs(element, node);
        } else {
            if ("http://www.w3.org/1998/Math/MathML".equals(namespaceURI)) {
                _makeMathML(element, node);
            } else {
                _makeExternalElementAsIs(element, node);
            }
        }
    }

    protected void _makeMathML(Element element, Node node) {
        MMath math = new MMath(element);
        LaTeXMaker maker = new LaTeXMaker();
        URVisitor.traverse(math, maker);
        TText text = new TText(maker.getText());
        node.appendChild(text);
    }

    protected void _makeExternalElementAsIs(Element element, Node node) {
        TText text = new TText(UXMLMaker.getXMLText(element));
        node.appendChild(text);
        _info("external element : " + UXMLMaker.getXMLText(element));
    }

    protected String _escape(String string) {
        if (string == null) {
            return ("");
        }
        return (string);
    }

    protected void _makeContent(Container container, Node node) {
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            _makeContent(contents[i], node);
        }
    }

    protected void _makeContent(Content content, Node node) {
        try {
            Node snapshot = new TContainer();
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
            } else if (content instanceof Strong) {
                _makeStrong((Strong)content, snapshot);
            } else if (content instanceof Abbr) {
                _makeAbbr((Abbr)content, snapshot);
            } else if (content instanceof Acronym) {
                _makeAcronym((Acronym)content, snapshot);
            } else if (content instanceof Cite) {
                _makeCite((Cite)content, snapshot);
            } else if (content instanceof Tt) {
                _makeTt((Tt)content, snapshot);
            } else if (content instanceof Em) {
                _makeEm((Em)content, snapshot);
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
//            } else if (content instanceof Group) {
//                _makeGroup((Group)content, snapshot);
            } else if (content instanceof Native) {
                _makeNative((Native)content, snapshot);
            } else if (content instanceof TimeCommand) {
                _makeTime((TimeCommand)content, snapshot);
            } else if (content instanceof ExternalElement) {
                _makeExternalElement((ExternalElement)content, snapshot);
            } else {
                throw (new InternalError(content.toString()));
            }
            NodeList nodes = snapshot.getChildNodes();
            int size = nodes.getLength();
            for (int i = 0;i < size;i++) {
                node.appendChild(nodes.item(i));
            }
        } catch (SmartDocWarningException e) {
            // continue
        }
    }

    protected void _makePart(Part part, Node node) {
        _makePartPrologue(part, node);
        _makeContent(part, node);
        _makePartEpilogue(part, node);
    }

    protected void _makeChapter(Chapter chapter, Node node) {
        _makeChapterPrologue(chapter, node);
        _makeContent(chapter, node);
        _makeChapterEpilogue(chapter, node);
    }

    protected void _makeSection(Section section, Node node) {
        _makeSectionPrologue(section, node);
        _makeContent(section, node);
        _makeSectionEpilogue(section, node);
    }

    protected void _makeSubSection(
        SubSection subsection,
        Node node
    ) {
        _makeSubSectionPrologue(subsection, node);
        _makeContent(subsection, node);
        _makeSubSectionEpilogue(subsection, node);
    }

    protected void _makeSubSubSection(
        SubSubSection subsubsection,
        Node node
    ) {
        _buildNoteBody(subsubsection, node);
        THeading theading = new THeading(_getTitle(subsubsection));
        theading.setUnderline(plainConfig_.getThinUnderline());
        node.appendChild(theading);
        _makeContent(subsubsection, node);
        _buildNoteBody(subsubsection, node);
    }

    protected void _makeTHead(THead thead, Node node) {
        // do nothing
    }

    protected void _makeTFoot(TFoot tfoot, Node node) {
        // do nothing
    }

    protected void _makeTBody(TBody tbody, Node node) {
        // do nothing
    }

    protected void _makeTr(Tr tr, Node node) {
        // do nothing
    }

    protected void _makeTh(Th th, Node node) {
        // do nothing
    }

    protected void _makeTd(Td td, Node node) {
        // do nothing
    }

    protected void _makeCharBlock(CharBlock cb, Node node) {
        node.appendChild(new TText(cb.getText()));
    }

    protected String _makeString(Content content) {
        if (content instanceof Container) {
            return (UDoc.distillText((Container)content));
        } else {
            return ("");
        }
    }

    protected String _getAppendixTitle(Appendix appendix) {
        return (model_.getLabel("appendix", appendix));
    }

    protected String _getTitle(TitledBlock heading) {
        StringBuffer buffer = new StringBuffer();
        if (_isNumberedTitle(heading)) {
            buffer.append(UDoc.getTitleNo(heading, "."));
            buffer.append("  ");
        }
        String title = heading.getTitle();
        if (title != null) {
            buffer.append(title);
        }
        return (new String(buffer));
    }

    private boolean _isNumberedTitle(TitledBlock heading) {
        if (heading instanceof FYI) {
            return (false);
        }
        return (true);
    }

    protected String _getNumberedTitle(Content content, String label) {
        String labelString = model_.getLabel(label, content);
        String title = content.getTitle();
        if (title == null) {
            return (null);
        }
        if (true) {                // XXX
            String number = UDoc.getSequenceNumberLabel(content);
            if (number == null) {
                return (labelString + title);
            } else {
                return (labelString + number + " " + title);
            }
        } else {
            return (labelString + title);
        }
    }

    private void _buildNoteBody(Container container, Node node) {
        int size = notes_.size();
        if (size > 0) {
            THeading sep = new THeading(_getNoteSeparator());
            sep.setPrologueSpan(1);
            sep.setEpilogueSpan(0);
            sep.setUnderline(null);
            node.appendChild(sep);
            TNoteList nl = new TNoteList();
            for (int i = 0;i < size;i++) {
                Note note = (Note)notes_.get(i);
                TItem item = new TItem();
                item.setMark("*" + note.getNumber() + " ");
                _makeContent(note, item);
                nl.appendChild(item);
            }
            notes_.clear();
            node.appendChild(nl);
        }
    }

    private String _getNoteSeparator() {
        if ("jis".equals(plainConfig_.getKeisenStyle())) {
            return ("*\u2500\u2500");
        } else {
            return ("*----");
        }
    }
}
