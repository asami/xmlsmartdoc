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

package org.xmlsmartdoc.SmartDoc.pure;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;

import org.xmlsmartdoc.SmartDoc.Abbr;
import org.xmlsmartdoc.SmartDoc.Acronym;
import org.xmlsmartdoc.SmartDoc.Anchor;
import org.xmlsmartdoc.SmartDoc.Appendix;
import org.xmlsmartdoc.SmartDoc.Article;
import org.xmlsmartdoc.SmartDoc.BibMisc;
import org.xmlsmartdoc.SmartDoc.Bibliography;
import org.xmlsmartdoc.SmartDoc.Blockquote;
import org.xmlsmartdoc.SmartDoc.Body;
import org.xmlsmartdoc.SmartDoc.Bold;
import org.xmlsmartdoc.SmartDoc.Book;
import org.xmlsmartdoc.SmartDoc.CSSStyle;
import org.xmlsmartdoc.SmartDoc.Chapter;
import org.xmlsmartdoc.SmartDoc.Cite;
import org.xmlsmartdoc.SmartDoc.Code;
import org.xmlsmartdoc.SmartDoc.Col;
import org.xmlsmartdoc.SmartDoc.Colgroup;
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
import org.xmlsmartdoc.SmartDoc.SmartDocModel;
import org.xmlsmartdoc.SmartDoc.Span;
import org.xmlsmartdoc.SmartDoc.Strong;
import org.xmlsmartdoc.SmartDoc.SubSection;
import org.xmlsmartdoc.SmartDoc.SubSubSection;
import org.xmlsmartdoc.SmartDoc.Summary;
import org.xmlsmartdoc.SmartDoc.TBody;
import org.xmlsmartdoc.SmartDoc.TFoot;
import org.xmlsmartdoc.SmartDoc.THead;
import org.xmlsmartdoc.SmartDoc.Table;
import org.xmlsmartdoc.SmartDoc.Td;
import org.xmlsmartdoc.SmartDoc.Term;
import org.xmlsmartdoc.SmartDoc.Th;
import org.xmlsmartdoc.SmartDoc.Title;
import org.xmlsmartdoc.SmartDoc.Tr;
import org.xmlsmartdoc.SmartDoc.TrContent;
import org.xmlsmartdoc.SmartDoc.Tt;
import org.xmlsmartdoc.SmartDoc.UDoc;
import org.xmlsmartdoc.SmartDoc.Ul;
import org.xmlsmartdoc.SmartDoc.html4.UHTML4;
import org.xmlsmartdoc.SmartDoc.xhtml.AbstractXHTMLGeneratorBase;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;

import com.AsamiOffice.io.UIO;
import com.AsamiOffice.io.UURL;

/**
 * PureGenerator
 *
 * @since   May.  4, 1999
 * @version Oct. 22, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class PureGenerator extends AbstractXHTMLGeneratorBase {
    protected PureConfig pureConfig_;

    public void init(SmartDocConfig config, SmartDocFormatConfig fconfig) {
        super.init(config, fconfig);
        pureConfig_ = (PureConfig)fconfig;
    }

    public GeneratorArtifact generateWhole(
        Doc doc,
        String deploy,
        SmartDocModel model
    ) {
        return (super.generateWhole(doc, deploy, model));
    }

    public GeneratorArtifact generateTitle(
        Doc doc,
        String deploy,
        SmartDocModel model
    ) {
        return (super.generateTitle(doc, deploy, model));
    }

    public GeneratorArtifact generateChapter(
        Doc doc,
        Chapter chapter,
        String deploy,
        SmartDocModel model
    ) {
        return (super.generateChapter(doc, chapter, deploy, model));
    }

    public GeneratorArtifact generateSection(
        Doc doc,
        Section section,
        String deploy,
        SmartDocModel model
    ) {
        return (super.generateSection(doc, section, deploy, model));
    }

    protected void _generateArtifacts(GeneratorResult result) {
        try {
            if (pureConfig_.isCopyDtd()) {
                String dtd = UIO.resource2String(
                    "/org/xmlsmartdoc/SmartDoc/pure/lib/PureSmartDoc.dtd",
                    this
                );
                result.addArtifact("PureSmartDoc.dtd", dtd);
            }
            if (pureConfig_.isCopyCSS()) {
                String css = UIO.resource2String(
                    "/org/xmlsmartdoc/SmartDoc/pure/lib/article.css",
                    this
                );
                result.addArtifact("article.css", css);
            }
        } catch (IOException e) {
            throw (new InternalError(e.getMessage()));
        }
    }

    protected void _makePrologue(Head head, StringBuffer buffer) {
        String encoding = formatConfig_.getEncoding((Doc)head.getParent());
        buffer.append("<?xml version='1.0' encoding=\"");
        buffer.append(encoding);
        buffer.append("\" ?>\n");
        if (pureConfig_.isUseCSS()) {
            String css = pureConfig_.getCssURL();
            buffer.append("<?xml-stylesheet href=\"");
            buffer.append(css);
            buffer.append("\" type=\"text/css\"?>\n");
        }
        if (pureConfig_.isUseDtd()) {
            buffer.append("<!DOCTYPE doc SYSTEM \"PureSmartDoc.dtd\">\n");
        }
        Doc doc = head.getDoc();
        _embedTagPrologue("doc", doc, buffer);
        buffer.append("\n");
    }

    protected void _makeEpilogue(Head head, StringBuffer buffer) {
        buffer.append("</doc>\n");
    }

    protected void _makeHead(Head head, StringBuffer buffer) {
        _embedTagPrologue("head", head, buffer);
        buffer.append("\n");
        Title title = head.getDocTitle();
        if (title != null) {
            buffer.append("<title>");
            _makeString(title, buffer);
            buffer.append("</title>\n");
        }
        Title subtitle = head.getDocSubTitle();
        if (subtitle != null) {
            buffer.append("<subtitle>");
            _makeString(subtitle, buffer);
            buffer.append("</subtitle>\n");
        }
        DocAuthor[] authors = head.getAuthors();
        if (authors != null) {
            for (int i = 0;i < authors.length;i++) {
                _makeDocAuthor(authors[i], buffer);
            }
        }
        DocDate date = head.getDate();
        if (date != null) {
            buffer.append("<date>");
            buffer.append(date.getText());
            buffer.append("</date>\n");
        }
        String email = head.getEMail();
        if (email != null) {
            buffer.append("<email>");
            buffer.append(email);
            buffer.append("</email>\n");
        }
        String hp = head.getHP();
        if (hp != null) {
            buffer.append("<hp>");
            buffer.append(hp);
            buffer.append("</hp>\n");
        }
        Summary summary = head.getSummary();
        if (summary != null) {
            buffer.append("<abstract>");
            _makeText(summary, buffer);
            buffer.append("</abstract>\n");
        }
        Header header = head.getHeader();
        if (header != null) {
            buffer.append("<header>");
            _makeText(header, buffer);
            buffer.append("</header>\n");
        }
        Prologue prologue = head.getPrologue();
        if (prologue != null) {
            buffer.append("<prologue>");
            _makeText(prologue, buffer);
            buffer.append("</prologue>\n");
        }
        Footer footer = head.getFooter();
        if (footer != null) {
            buffer.append("<footer>");
            _makeText(footer, buffer);
            buffer.append("</footer>\n");
        }
        buffer.append("</head>\n");
    }

    private void _makeDocAuthor(DocAuthor author, StringBuffer buffer) {
        String name = UDoc.distillText(author);
        String note = author.getNote();
        String email = author.getEMail();
        String hp = author.getHP();
        buffer.append("<author");
        if (email != null) {
            buffer.append(" email=\"");
            buffer.append(email);
            buffer.append("\"");
        }
        if (hp != null) {
            buffer.append(" hp=\"");
            buffer.append(hp);
            buffer.append("\"");
        }
        if (note != null) {
            buffer.append(" note=\"");
            buffer.append(note);
            buffer.append("\"");
        }
        buffer.append(">");
        buffer.append(name);
        buffer.append("</author>\n");
    }

    protected void _makeBodyPrologue(
        Head head,
        Body body,
        StringBuffer buffer
    ) {
        _embedTagPrologue("body", body, buffer);
        buffer.append("\n");
    }

    protected void _makeBodyEpilogue(
        Head head,
        Body body,
        StringBuffer buffer
    ) {
        buffer.append("</body>\n");
    }

    protected void _makeTitle(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        // do nothing
    }

    protected void _makeTOC(Container container, StringBuffer buffer) {
        // do nothing
    }

    protected void _makeBibliographyPrologue(
        Bibliography bib,
        StringBuffer buffer
    ) {
        _embedTagPrologue("bibliography", bib, buffer);
    }

    protected void _makeBibliographyEpilogue(
        Bibliography bib,
        StringBuffer buffer
    ) {
        buffer.append("</bibliography>\n");
    }

    protected void _makeBook(Book book, StringBuffer buffer) {
        _embedTagPrologue("book", book, buffer);
//        _makeBibData("title", book.getTitle(), buffer);
        _makeBibData("subtitle", book.getSubTitle(), buffer);
        _makeBibData("edition", book.getEdition(), buffer);
        _makeBibAuthors(book.getAuthors(), buffer);
        _makeBibEditors(book.getEditors(), buffer);
        _makeBibData("publisher", book.getPublisher(), buffer);
        _makeBibData("year", book.getYear(), buffer);
        _makeBibData("note", book.getNote(), buffer);
        _makeBibData("uri", book.getUri(), buffer);
        buffer.append("</book>\n");
    }

    protected void _makeArticle(Article article, StringBuffer buffer) {
        _embedTagPrologue("article", article, buffer);
//        _makeBibData("title", article.getTitle(), buffer);
        _makeBibData("subtitle", article.getSubTitle(), buffer);
        _makeBibAuthors(article.getAuthors(), buffer);
        Journal journal = article.getJournal();
        if (journal != null) {
            _makeJournal(journal, buffer);
        }
        _makeBibData("pages", article.getPages(), buffer);
        _makeBibData("note", article.getNote(), buffer);
        _makeBibData("uri", article.getUri(), buffer);
        buffer.append("</article>\n");
    }

    protected void _makeJournal(Journal journal, StringBuffer buffer) {
        _embedTagPrologue("journal", journal, buffer);
//        _makeBibData("title", journal.getTitle(), buffer);
        _makeBibData("year", journal.getYear(), buffer);
        _makeBibData("month", journal.getMonth(), buffer);
        _makeBibData("volume", journal.getVolume(), buffer);
        _makeBibData("number", journal.getNumber(), buffer);
        _makeBibData("publisher", journal.getPublisher(), buffer);
        _makeBibData("note", journal.getNote(), buffer);
        _makeBibData("uri", journal.getUri(), buffer);
        buffer.append("</journal>\n");
    }

    protected void _makeBibMisc(BibMisc misc, StringBuffer buffer) {
        _embedTagPrologue("misc", misc, buffer);
//        _makeBibData("title", misc.getTitle(), buffer);
        _makeBibAuthors(misc.getAuthors(), buffer);
        _makeBibData("howpublished", misc.getHowpublished(), buffer);
        _makeBibData("month", misc.getMonth(), buffer);
        _makeBibData("year", misc.getYear(), buffer);
        _makeBibData("note", misc.getNote(), buffer);
        _makeBibData("uri", misc.getUri(), buffer);
        buffer.append("</misc>\n");
    }

    private void _makeBibData(
        String tagName,
        String data,
        StringBuffer buffer
    ) {
        if (data == null) {
            return;
        }
        buffer.append("<");
        buffer.append(tagName);
        buffer.append(">");
        buffer.append(data);
        buffer.append("</");
        buffer.append(tagName);
        buffer.append(">\n");
    }

    private void _makeBibAuthors(String[] authors, StringBuffer buffer) {
        if (authors == null) {
            return;
        }
        for (int i = 0;i < authors.length;i++) {
            String author = authors[i];
            _makeBibData("author", author, buffer);
        }
    }

    private void _makeBibEditors(String[] editors, StringBuffer buffer) {
        if (editors == null) {
            return;
        }
        for (int i = 0;i < editors.length;i++) {
            String editor = editors[i];
            _makeBibData("editor", editor, buffer);
        }
    }

    protected void _makePageHeader(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        // do nothing
    }

    protected void _makePageFooter(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        // do nothing
    }

    protected void _makeArticlePrologue(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        // do nothing
    }

    protected void _makeIndex(
        Head head,
        Body body,
        Indexdef indexdef,
        StringBuffer buffer
    ) {
        // do nothing
    }

    protected void _makeSentence(
        Sentence sentence,
        StringBuffer buffer
    ) {
        _makeText(sentence, buffer);
    }

    protected void _makeParagraph(Paragraph p, StringBuffer buffer) {
        _embedTagPrologue("p", p, buffer);
        _makeText(p, buffer);
        buffer.append("</p>\n");
    }

    protected void _makePartPrologue(Part part, StringBuffer buffer) {
        _embedHeadingPrologue("part", part, buffer);
    }

    protected void _makePartEpilogue(Part part, StringBuffer buffer) {
        buffer.append("\n</part>\n");
    }

    protected void _makeChapterPrologue(Chapter chapter, StringBuffer buffer) {
        _embedHeadingPrologue("chapter", chapter, buffer);
    }

    protected void _makeChapterEpilogue(Chapter chapter, StringBuffer buffer) {
        buffer.append("</chapter>\n");
    }

    protected void _makeSectionPrologue(Section section, StringBuffer buffer) {
        _embedHeadingPrologue("section", section, buffer);
    }

    protected void _makeSectionEpilogue(Section section, StringBuffer buffer) {
        buffer.append("</section>\n");
    }

    protected void _makeSubSectionPrologue(
        SubSection subsection,
        StringBuffer buffer
    ) {
        _embedHeadingPrologue("subsection", subsection, buffer);
    }

    protected void _makeSubSectionEpilogue(
        SubSection subsection,
        StringBuffer buffer
    ) {
        buffer.append("\n</subsection>\n");
    }

    protected void _makeSubSubSectionPrologue(
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
        _embedHeadingPrologue("subsubsection", subsubsection, buffer);
    }

    protected void _makeSubSubSectionEpilogue(
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
        buffer.append("\n</subsubsection>\n");
    }

    protected void _makeAppendix(
        Appendix appendix,
        StringBuffer buffer
    ) {
        _embedTagPrologue("appendix", appendix, buffer);
        buffer.append("\n");
        _makeText(appendix, buffer);
        buffer.append("\n</appendix>\n");
    }

    protected void _makeFYI(
        FYI fyi,
        StringBuffer buffer
    ) {
        _embedHeadingPrologue("fyi", fyi, buffer);
        _makeText(fyi, buffer);
        buffer.append("\n</fyi>\n");
    }

    protected void _makeUl(Ul ul, StringBuffer buffer) {
        _embedTagPrologue("ul", ul, buffer);
        buffer.append("\n");
        _makeText(ul, buffer);
        buffer.append("</ul>\n");
    }

    protected void _makeOl(Ol ol, StringBuffer buffer) {
        _embedTagPrologue("ol", ol, buffer);
        buffer.append("\n");
        _makeText(ol, buffer);
        buffer.append("</ol>\n");
    }

    protected void _makeLi(Li li, StringBuffer buffer) {
        _embedTagPrologue("li", li, buffer);
        _makeText(li, buffer);
        buffer.append("</li>\n");
    }

    protected void _makeDl(Dl dl, StringBuffer buffer) {
        _embedTagPrologue("dl", dl, buffer);
        _makeText(dl, buffer);
        buffer.append("</dl>\n");
    }

    protected void _makeDt(Dt dt, StringBuffer buffer) {
        _embedTagPrologue("dt", dt, buffer);
        _makeText(dt, buffer);
        buffer.append("</dt>\n");
    }

    protected void _makeDd(Dd dd, StringBuffer buffer) {
        _embedTagPrologue("dd", dd, buffer);
        _makeText(dd, buffer);
        buffer.append("</dd>\n");
    }

    protected void _makeTable(Table table, StringBuffer buffer) {
        _embedHeadingPrologue("table", table, buffer);
        Colgroup[] colgroups = table.getColgroups();
        for (int i = 0;i < colgroups.length;i++) {
            Colgroup colgroup = colgroups[i];
            _embedTagPrologue("colgroup", colgroup, buffer);
            buffer.append("\n");
            Col[] cols = colgroup.getCols();
            for (int j = 0;j < cols.length;j++) {
                Col col = cols[j];
                _embedTagPrologue("col", col, buffer);
                String align = col.getAlign();
                if (align != null) {
                    _embedAttrAppend("align", align, buffer);
                }
                _embedTagEpilogue("col", buffer);
                buffer.append("\n");
            }
            _embedTagEpilogue("colgroup", buffer);
            buffer.append("\n");
        }
        THead thead = table.getTHead();
        TFoot tfoot = table.getTFoot();
        TBody tbody = table.getTBody();
        if (thead != null) {
            _makeTHead(thead, buffer);
        }
        if (tfoot != null) {
            _makeTFoot(tfoot, buffer);
        }
        if (tbody != null) {
            _makeTBody(tbody, buffer);
        }
        _embedTagEpilogue("table", buffer);
        buffer.append("\n");
    }

    protected void _makeTHead(THead thead, StringBuffer buffer) {
            _embedTagPrologue("thead", thead, buffer);
            buffer.append("\n");
            _makeText(thead, buffer);
            _embedTagEpilogue("thead", buffer);
            buffer.append("\n");
    }

    protected void _makeTFoot(TFoot tfoot, StringBuffer buffer) {
            _embedTagPrologue("tfoot", tfoot, buffer);
            buffer.append("\n");
            _makeText(tfoot, buffer);
            _embedTagEpilogue("tfoot", buffer);
            buffer.append("\n");
    }

    protected void _makeTBody(TBody tbody, StringBuffer buffer) {
            _embedTagPrologue("tbody", tbody, buffer);
            buffer.append("\n");
            _makeText(tbody, buffer);
            _embedTagEpilogue("tbody", buffer);
            buffer.append("\n");
    }

    protected void _makeTr(Tr tr, StringBuffer buffer) {
            _embedTagPrologue("tr", tr, buffer);
            buffer.append("\n");
            _makeText(tr, buffer);
            buffer.append("\n");
            _embedTagEpilogue("tr", buffer);
            buffer.append("\n");
    }

    protected void _makeTh(Th th, StringBuffer buffer) {
            _embedTableCellPrologue("th", th, buffer);
            _makeText(th, buffer);
            _embedTagEpilogue("th", buffer);
    }

    protected void _makeTd(Td td, StringBuffer buffer) {
            _embedTableCellPrologue("td", td, buffer);
            _makeText(td, buffer);
            _embedTagEpilogue("td", buffer);
    }

    protected void _makeImg(Img img, StringBuffer buffer) {
        _embedTagPrologue("img", img, buffer);
        _makeString(img, buffer);
        _embedTagEpilogue("img", buffer);
    }

    protected void _makeImage(ImageFigure image, StringBuffer buffer) {
        _embedTagPrologue("figure", image, buffer);
        _makeString(image, buffer);
        _embedTagEpilogue("figure", buffer);
    }

    protected void _embedExternalTimestamp(
        Content content,
        StringBuffer buffer
    ) {
        String src = content.getSrc();
        if (src == null) {
            return;
        }
        try {
            URL url = UURL.getURLFromFileOrURLName(src);
            if ("file".equals(url.getProtocol())) {
                File file = new File(url.getFile());
                long timestamp = file.lastModified();
                _embedAttrAppend(
                    "timestamp",
                    Long.toString(timestamp),
                    buffer
                );
            }
        } catch (IOException e) {
        }
    }

    protected void _makeSpan(Span span, StringBuffer buffer) {
        _makeInlineTag("span", span, buffer);
    }

    protected void _makeTerm(Term term, StringBuffer buffer) {
        _makeString(term, buffer);
    }

    protected void _makeIndex(Index index, StringBuffer buffer) {
        _makeString(index, buffer);
    }

    protected void _makeBold(Bold bold, StringBuffer buffer) {
        _makeInlineTag("b", bold, buffer);
    }

    protected void _makeItalic(Italic italic, StringBuffer buffer) {
        _makeInlineTag("i", italic, buffer);
    }

    protected void _makeDfn(Dfn dfn, StringBuffer buffer) {
        _makeInlineTag("dfn", dfn, buffer);
    }

    protected void _makeTt(Tt tt, StringBuffer buffer) {
        _makeInlineTag("tt", tt, buffer);
    }

    protected void _makeEm(Em em, StringBuffer buffer) {
        _makeInlineTag("em", em, buffer);
    }

    protected void _makeStrong(Strong strong, StringBuffer buffer) {
        _makeInlineTag("strong", strong, buffer);
    }

    // AbstractGeneratorBase
    protected void _makeAbbr(Abbr abbr, StringBuffer buffer) {
        _makeInlineTag("abbr", abbr, buffer);
    }

    // AbstractGeneratorBase
    protected void _makeAcronym(Acronym acronym, StringBuffer buffer) {
        _makeInlineTag("acronym", acronym, buffer);
    }

    protected void _makeCode(Code code, StringBuffer buffer) {
        _makeInlineTag("code", code, buffer);
    }

    protected void _makeBlockquote(
        Blockquote blockquote,
        StringBuffer buffer
    ) {
        _makeBlockTag("blockquote", blockquote, buffer);
    }

    protected void _makeQuote(Quote quote, StringBuffer buffer) {
        _makeInlineTag("quote", quote, buffer);
    }

    protected void _makeAnchor(Anchor anchor, StringBuffer buffer) {
        // pure SmartDoc doesn't use anchor tag
        _makeString(anchor, buffer);
    }

    protected void _makePre(Pre pre, StringBuffer buffer) {
        String source = pre.getText();
        _embedTagPrologue("pre", pre, buffer);
        if (source != null) {
            buffer.append(_escape(source));
        }
        _embedTagEpilogue("pre", buffer);
        buffer.append("\n");
    }

    protected void _makeProgram(Program program, StringBuffer buffer) {
        String source = program.getText();
        _embedHeadingPrologue("program", program, buffer);
        if (source != null) {
            buffer.append(_escape(source));
        }
        _embedTagEpilogue("program", buffer);
        buffer.append("\n");
    }

    protected void _makeConsole(Console console, StringBuffer buffer) {
        String source = console.getText();
        _embedHeadingPrologue("console", console, buffer);
        if (source != null) {
            buffer.append(_escape(source));
        }
        _embedTagEpilogue("console", buffer);
        buffer.append("\n");
    }

    protected void _makeEquation(Equation equation, StringBuffer buffer) {
        String expr = equation.getText();
        _embedHeadingPrologue("equation", equation, buffer);
        if (expr != null) {
            buffer.append(expr);
        }
        _embedTagEpilogue("equation", buffer);
        buffer.append("\n");
    }

    protected void _makeDiv(Div div, StringBuffer buffer) {
        _makeBlockTag("div", div, buffer);
    }

    protected void _makeRef(Ref ref, StringBuffer buffer) {
        String text = _getString(ref);
        String uri = ref.getHref();
        if (ref.getType() == Ref.SELF_LINK) {
            Content link = ref.getLink();
            if (link != null) {
                String srcFile = getLogicalFile(ref); // 1385
                String destFile = getLogicalFile(link);
                if (srcFile.equals(destFile)) {
                    _embedRefTag("#" + _getID(link), ref, buffer);
                } else {
                    _embedRefTag(
                        destFile + "#" + _getID(link),
                        ref,
                        buffer
                    );
                }
                return;
            }
            uri = "#" + uri;
        }
        if (text == null || "".equals(text)) {
            _embedRefTag(uri, uri, buffer);
        } else {
            _embedRefTag(uri, ref, buffer);
        }
    }

    protected void _makeCite(Cite cite, StringBuffer buffer) {
        _makeInlineTag("cite", cite, buffer);
    }

    protected void _makeComment(Comment comment, StringBuffer buffer) {
        _makeInlineTag("comment", comment, buffer);
    }

    protected void _makeNote(Note note, StringBuffer buffer) {
        _makeInlineTag("note", note, buffer);
    }

    // AbstractXMLGeneratorBase
    protected void _embedTagPrologue(
        String tagname,
        Content content,
        StringBuffer buffer
    ) {
        String id = _getID(content);
        String clazz = content.getClazz();
        CSSStyle style = content.getStyle();
        String lang = content.getExplicitLanguage();
        String space = content.getExplicitSpace();
        Locale locale = content.getExplicitLocale();
        Title title = content.getTitleNode();
        String src = content.getSrc();

        buffer.append("<");
        buffer.append(tagname);
//        if (content.hasReferer()) {
//            _embedAttr("id", id, buffer);
//        }
        _embedAttr("id", id, buffer);
        if (clazz != null) {
            _embedAttr("class", clazz, buffer);
        }
        if (style != null) {
            _embedAttr("style", style.getText(), buffer);
        }
        if (lang != null) {
            _embedAttr("xml:lang", UHTML4.getHTML4Lang(lang), buffer); // XXX
        }
        if (space != null) {
            _embedAttr("xml:space", space, buffer);
        }
        if (src != null) {
            _embedAttr("src", src, buffer);
        }
        buffer.append(">");
        _embedExternalTimestamp(content, buffer);
        if (title != null) {
            _makeInlineTag("title", title, buffer);
        }
    }

    protected void _embedTableCellPrologue(
        String tagname,
        TrContent cell,
        StringBuffer buffer
    ) {
        _embedTagPrologue(tagname, cell, buffer);
        int rowspan = cell.getRowSpan();
        int colspan = cell.getColSpan();
        String align = cell.getAlign();
        if (rowspan != 1) {
            _embedAttrAppend("rowspan", Integer.toString(rowspan), buffer);
        }
        if (colspan != 1) {
            _embedAttrAppend("colspan", Integer.toString(colspan), buffer);
        }
        if (align != null) {
            _embedAttrAppend("align", align, buffer);
        }
    }

    // helpers

    protected void _embedHeadingPrologue(
        String tag,
        Container container,
        StringBuffer buffer
    ) {
        _embedTagPrologue(tag, container, buffer);
/*
        buffer.append("\n");
        Title title = container.getTitleNode();
        if (title != null) {
            _embedTagPrologue("title", title, buffer);
            _makeText(title, buffer);
            buffer.append("</title>\n");
        }
*/
    }
}
