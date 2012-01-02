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
package org.xmlsmartdoc.SmartDoc.html3;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.xmlsmartdoc.SmartDoc.Abbr;
import org.xmlsmartdoc.SmartDoc.Acronym;
import org.xmlsmartdoc.SmartDoc.Anchor;
import org.xmlsmartdoc.SmartDoc.Appendix;
import org.xmlsmartdoc.SmartDoc.Article;
import org.xmlsmartdoc.SmartDoc.BibMisc;
import org.xmlsmartdoc.SmartDoc.Bibitem;
import org.xmlsmartdoc.SmartDoc.Bibliography;
import org.xmlsmartdoc.SmartDoc.Blockquote;
import org.xmlsmartdoc.SmartDoc.Body;
import org.xmlsmartdoc.SmartDoc.Bold;
import org.xmlsmartdoc.SmartDoc.Book;
import org.xmlsmartdoc.SmartDoc.CSSStyle;
import org.xmlsmartdoc.SmartDoc.Chapter;
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
import org.xmlsmartdoc.SmartDoc.DocContext;
import org.xmlsmartdoc.SmartDoc.DocDate;
import org.xmlsmartdoc.SmartDoc.Dt;
import org.xmlsmartdoc.SmartDoc.Em;
import org.xmlsmartdoc.SmartDoc.Equation;
import org.xmlsmartdoc.SmartDoc.FYI;
import org.xmlsmartdoc.SmartDoc.Head;
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
import org.xmlsmartdoc.SmartDoc.PTable;
import org.xmlsmartdoc.SmartDoc.Paragraph;
import org.xmlsmartdoc.SmartDoc.Part;
import org.xmlsmartdoc.SmartDoc.Pre;
import org.xmlsmartdoc.SmartDoc.Program;
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
import org.xmlsmartdoc.SmartDoc.TOCNode;
import org.xmlsmartdoc.SmartDoc.Table;
import org.xmlsmartdoc.SmartDoc.Td;
import org.xmlsmartdoc.SmartDoc.Term;
import org.xmlsmartdoc.SmartDoc.Th;
import org.xmlsmartdoc.SmartDoc.Title;
import org.xmlsmartdoc.SmartDoc.TitledBlock;
import org.xmlsmartdoc.SmartDoc.Tnote;
import org.xmlsmartdoc.SmartDoc.TrContent;
import org.xmlsmartdoc.SmartDoc.Tt;
import org.xmlsmartdoc.SmartDoc.UDoc;
import org.xmlsmartdoc.SmartDoc.Ul;
import org.xmlsmartdoc.SmartDoc.xhtml.AbstractXHTMLGeneratorBase;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;
import com.AsamiOffice.text.UString;

/**
 * HTML3Generator
 *
 * @since   Apr. 16, 1999
 * @version Jun. 10, 2005
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class HTML3Generator extends AbstractXHTMLGeneratorBase {
    protected HTML3Config html3Config_;
//    protected String indicatorType_ = null; // XXX : deprecated
    protected List notes_ = new ArrayList();

    // AbstractGenerator
    public void init(SmartDocConfig config, SmartDocFormatConfig fconfig) {
        html3Config_ = (HTML3Config)fconfig;
        super.init(config, fconfig);
        _setIndicatorHandler(new HTML3IndicatorHandler());
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
/*        if ("section".equals(deploy)) {
            setIndicatorType("section");
        } else if ("chapter".equals(deploy)) {
            setIndicatorType("chapter");
            }*/
        return (super.generateTitle(doc, deploy, model));
    }

    public GeneratorArtifact generateChapter(
        Doc doc,
        Chapter chapter,
        String deploy,
        SmartDocModel model
    ) {
//        indicatorType_ = "chapter";
        return (super.generateChapter(doc, chapter, deploy, model));
    }

    public GeneratorArtifact generateSection(
        Doc doc,
        Section section,
        String deploy,
        SmartDocModel model
    ) {
//        indicatorType_ = "section";
        return (super.generateSection(doc, section, deploy, model));
    }

/*
    public void setIndicatorType(String type) {
        indicatorType_ = type;
    }
*/

    // AbstractGeneratorBase
    protected void _makePrologue(Head head, StringBuffer buffer) {
        buffer.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">\n");
        buffer.append("<html>\n");
    }

    // AbstractGeneratorBase
    protected void _makeEpilogue(Head head, StringBuffer buffer) {
        buffer.append("</html>\n");
    }

    // AbstractGeneratorBase
    protected void _makeHead(Head head, StringBuffer buffer) {
        DocContext context = head.getDocContext();
        Title title = head.getDocTitle();
        String author = head.getAuthor();
        DocDate date = head.getDate();
        String encoding = formatConfig_.getEncoding((Doc)head.getParent());
        Native nativeValue = head.getNative();

        buffer.append("<head>\n");
        buffer.append("\n");
        buffer.append("<META http-equiv=\"Content-Type\" content=\"text/html;charset=");
        buffer.append(encoding);
        buffer.append("\">\n");
        buffer.append("<META name=\"generator\" content=\"SmartDoc\">\n");
        if (author != null) {
            String lang = head.getLanguage(); // XXX : really author tag
            buffer.append("<META NAME=\"author\" CONTENT=\"");
            buffer.append(author);
            buffer.append("\"");
/*
            if (lang != null) {
                buffer.append(" lang=\"");
                buffer.append(lang);
                buffer.append("\"");
            }
*/
            buffer.append(">\n");
        }
        if (date != null) {
            String lang = head.getLanguage(); // XXX : really date tag
            buffer.append("<META NAME=\"date\" CONTENT=\"");
            buffer.append(date.getText()); // XXX : canonical format
            buffer.append("\"");
/*
            if (lang != null) {
                buffer.append(" lang=\"");
                buffer.append(lang);
                buffer.append("\"");
            }
*/
            buffer.append(">\n");
        }
/*
        buffer.append("<META name=\"description\" content=\"");
        buffer.append("");        // XXX
        buffer.append("\">\n");
        // meta copyright
        buffer.append("<meta name=\"keywords\" content=\"");
        buffer.append("");        // XXX
        buffer.append("\">\n");
*/
        // LINK next prev
        buffer.append("<title>");
        if (title != null) {
            _makeString(title, buffer);
        }
        buffer.append("</title>\n");
        if (nativeValue != null) {
            buffer.append(nativeValue.getText());
            buffer.append("\n");
        }
        buffer.append("</head>\n");        
    }

    // AbstractGeneratorBase
    protected void _makeBodyPrologue(
        Head head,
        Body body,
        StringBuffer buffer
    ) {
        buffer.append("<body>\n");
    }

    // AbstractGeneratorBase
    protected void _makeBodyEpilogue(
        Head head,
        Body body,
        StringBuffer buffer
    ) {
        _makeFootnote(body, buffer);
        buffer.append("</body>\n");
    }

    // AbstractGeneratorBase
    protected void _makeTOC(Container container, StringBuffer buffer) {
        buffer.append("<h2>");
        buffer.append(_makeTitleString(
            model_.getLabel("table of contents", container))
        );
        buffer.append("</h2>\n");
        buffer.append("\n");
        _makeTOCNodes(container, buffer);
        buffer.append("<hr>\n");
    }

    protected void _makeTitleTOC(Container container, StringBuffer buffer) {
        TOCNode node = container.getTOCTree();
        if (node.getChildCount() > 0) {
            _makeTOCNodes(container, buffer);
            buffer.append("<hr>\n");
        }
    }

/*
    protected void _makeTOCNodes(Container container, StringBuffer buffer) {
        TOCNode node = container.getTOCTree();
        TitledBlock heading = node.getHeading();
        if (heading != null) {
            String title = heading.getTitle();
            String id = heading.getID();
            String file = getAllocateFile(heading);
            buffer.append("<ul>\n");
            buffer.append("<li> ");
            String link;
            link = file + "#" + id;
            _embedRefTag(link, title, buffer);
            buffer.append("\n");
            _makeTOCNodes(node, buffer);
            buffer.append("</ul>\n");
        } else {
            _makeTOCNodes(node, buffer);
        }
    }

    protected void _makeTOCNodes(
        TOCNode node,
        StringBuffer buffer
    ) {
        int size = node.getChildCount();
        if (size == 0) {
            return;
        }
        buffer.append("<ul>\n");
        for (int i = 0;i < size;i++) {
            TOCNode child = (TOCNode)node.getChildAt(i);
            TitledBlock heading = child.getHeading();
            String title = heading.getTitle();
            String id = heading.getID();
            String file = getAllocateFile(heading);
            buffer.append("<li> ");
            String link;
            link = file + "#" + id;
            _embedRefTag(link, title, buffer);
            buffer.append("\n");
            _makeTOCNodes(child, buffer);
        }
        buffer.append("</ul>\n");
    }

    protected void _makeTOCNodes(
        Container container,
        Container root,
        StringBuffer buffer
    ) {
        if (container instanceof Part ||
            container instanceof Chapter ||
            container instanceof Section ||
            container instanceof SubSection ||
            container instanceof SubSubSection) {

            String rootFile = getAllocateFile(root);
            TitledBlock block = (TitledBlock)container;
            String file = getAllocateFile(container);
            String title = block.getTitle();
            buffer.append("<li> ");
            String link;
            if (file != null &&
                !file.equals(rootFile)) {

                link = file + "#" + title;
            } else {
                link = "#" + title;
            }
            _embedRefTag(link, title, buffer);
            buffer.append("\n");
            buffer.append("<ul>\n");
            Content[] contents = container.getContents();
            for (int i = 0;i < contents.length;i++) {
                _makeTOCNodes((Container)contents[i], root, buffer);
            }
            buffer.append("</ul>\n");
        } else {
            Content[] contents = container.getContents();
            for (int i = 0;i < contents.length;i++) {
                Content content = contents[i];
                if (content instanceof Container) {
                    _makeTOCNodes((Container)content, root, buffer);
                }
            }
        }
    }
*/

    // AbstractGeneratorBase
    protected void _makeBibliographyPrologue(
        Bibliography bib,
        StringBuffer buffer
    ) {
        String head = _getBiliographyHeadTag(bib);
        buffer.append("\n");
        buffer.append("<a name=\"");
        buffer.append(_getID(bib));
        buffer.append("\">");
        buffer.append("<");
        buffer.append(head);
        buffer.append(">");
        buffer.append("</a>\n");
        Title title = bib.getTitleNode();
        if (title != null) {
            _makeString(title, buffer);
        } else {
            buffer.append(
                _makeTitleString(model_.getLabel("bibliography", bib))
            );
        }
        buffer.append("</");
        buffer.append(head);
        buffer.append(">\n");
        buffer.append("\n");
        buffer.append("<table>\n");
    }

    protected String _getBiliographyHeadTag(Bibliography bib) {
        TitledBlock parent = UDoc.getParentTitledBlock(bib.getParent());
        if (parent == null) {
            return ("h2");
        } else if (parent instanceof Part) {
            return ("h1");
        } else if (parent instanceof Chapter) {
            return ("h2");
        } else if (parent instanceof Section) {
            return ("h3");
        } else if (parent instanceof SubSection) {
            return ("h4");
        } else if (parent instanceof SubSubSection) {
            return ("h5");
        } else {
            return ("h2");
        }
    }

    // AbstractGeneratorBase
    protected void _makeBibliographyEpilogue(
        Bibliography bib,
        StringBuffer buffer
    ) {
        buffer.append("</table>\n");
    }

    // AbstractGeneratorBase
    protected void _makeBook(Book book, StringBuffer buffer) {
        Locale locale = UDoc.getDisplayLocale(book);
        String id = _getID(book);
        String[] authors = book.getAuthors();
        String[] editors = book.getEditors();
        String title = book.getTitle();
        String subtitle = book.getSubTitle();
        String edition = book.getEdition();
        String publisher = book.getPublisher();
        String year = book.getYear();
        String note = book.getNote();
        String uri = book.getUri();
        buffer.append("<tr>");
        buffer.append("<td valign=top>");
        buffer.append("<a name=\"");
        buffer.append(id);
        buffer.append("\">");
        buffer.append("[");
        buffer.append(UDoc.getSequenceNumberBasedSubSubSection(book));
        buffer.append("]");
        buffer.append("</a>");
        buffer.append("</td>");
        buffer.append("<td>");
        if (uri != null) {
            buffer.append("<a href=\"");
            buffer.append(uri);
            buffer.append("\">");
        }
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
            buffer.append("<em>");
            buffer.append(title);
            if (subtitle != null) {
                buffer.append(" : ");
                buffer.append(subtitle);
            }
            buffer.append("</em>. ");
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
        }
        if (uri != null) {
            buffer.append("</a>");
        }
        buffer.append("</td>");
        buffer.append("</tr>\n");
    }

    // AbstractGeneratorBase
    protected void _makeArticle(Article article, StringBuffer buffer) {
        Locale locale = UDoc.getDisplayLocale(article);
        String id = _getID(article);
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
        String uri = journal.getUri();
        buffer.append("<tr>");
        buffer.append("<td valign=top>");
        buffer.append("<a name=\"");
        buffer.append(id);
        buffer.append("\">");
        buffer.append("[");
        buffer.append(UDoc.getSequenceNumberBasedSubSubSection(article));
        buffer.append("]");
        buffer.append("</a>");
        buffer.append("</td>");
        buffer.append("<td>");
        if (uri != null) {
            buffer.append("<a href=\"");
            buffer.append(uri);
            buffer.append("\">");
        }
        if (authors != null && authors.length > 0) {
            _makeAuthors(authors, buffer);
            buffer.append(". ");
        }
        if (title != null) {
            buffer.append("<em>");
            buffer.append(title);
            if (subtitle != null) {
                buffer.append(" : ");
                buffer.append(subtitle);
            }
            buffer.append("</em>. ");
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
            buffer.append(".");
        }
        if (publisher != null) {
            buffer.append(_escape(publisher));
            buffer.append(",");
        }
        if (year != null) {
            buffer.append(" ");
            buffer.append(_escape(year));
            buffer.append(". ");
        }
        if (note != null) {
            buffer.append(note);
        }
        if (uri != null) {
            buffer.append("</a>");
        }
        buffer.append("</td>");
        buffer.append("</tr>\n");
    }

    protected void _makeJournal(Journal journal, StringBuffer buffer) {
        Locale locale = UDoc.getDisplayLocale(journal);
        String id = _getID(journal);
        String title = journal.getTitle();
        String publisher = journal.getPublisher();
        String year = journal.getYear();
        String month = journal.getMonth();
        String volume = journal.getVolume();
        String number = journal.getNumber();
        String note = journal.getNote();
        String uri = journal.getUri();
        buffer.append("<tr>");
        buffer.append("<td valign=top>");
        buffer.append("<a name=\"");
        buffer.append(id);
        buffer.append("\">");
        buffer.append("[");
        buffer.append(UDoc.getSequenceNumberBasedSubSubSection(journal));
        buffer.append("]");
        buffer.append("</a>");
        buffer.append("</td>");
        buffer.append("<td>");
        if (uri != null) {
            buffer.append("<a href=\"");
            buffer.append(uri);
            buffer.append("\">");
        }
        if (title != null) {
            buffer.append("<em>");
            buffer.append(title);
//            if (subtitle != null) {
//                buffer.append(" : ");
//                buffer.append(subtitle);
//            }
            buffer.append("</em>. ");
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
            buffer.append(",");
        }
        if (year != null) {
            buffer.append(" ");
            buffer.append(_escape(year));
            buffer.append(".");
        }
        if (note != null) {
            buffer.append(" ");
            buffer.append(note);
        }
        if (uri != null) {
            buffer.append("</a>");
        }
        buffer.append("</td>");
        buffer.append("</tr>\n");
    }

    protected void _makeBibMisc(BibMisc misc, StringBuffer buffer) {
        Locale locale = UDoc.getDisplayLocale(misc);
        String id = _getID(misc);
        String authors[] = misc.getAuthors();
        String title = misc.getTitle();
        String subtitle = misc.getSubTitle();
        String howpublished = misc.getHowpublished();
        String month = misc.getMonth();
        String year = misc.getYear();
        String note = misc.getNote();
        String uri = misc.getUri();
        buffer.append("<tr>");
        buffer.append("<td valign=\"top\">");
        buffer.append("<a name=\"");
        buffer.append(id);
        buffer.append("\">");
        buffer.append("[");
        buffer.append(UDoc.getSequenceNumberBasedSubSubSection(misc));
        buffer.append("]");
        buffer.append("</a>");
        buffer.append("</td>");
        buffer.append("<td>");
        if (uri != null) {
            buffer.append("<a href=\"");
            buffer.append(uri);
            buffer.append("\">");
        }
        if (authors != null && authors.length > 0) {
            _makeAuthors(authors, buffer);
            buffer.append(". ");
        }
        if (title != null) {
            buffer.append("<em>");
            buffer.append(title);
            if (subtitle != null) {
                buffer.append(" : ");
                buffer.append(subtitle);
            }
            buffer.append("</em>. ");
        }
        if (howpublished != null) {
            buffer.append(_escape(howpublished));
            buffer.append(",");
        }
        if (month != null) {
            buffer.append(" ");
            buffer.append(month);
        }
        if (year != null) {
            buffer.append(" ");
            buffer.append(year);
            buffer.append(".");
        }
        if (note != null) {
            buffer.append(" ");
            buffer.append(note);
        }
        if (uri != null) {
            buffer.append("</a>");
        }
        buffer.append("</td>");
        buffer.append("</tr>\n");
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

    protected void _makeIndex(        // XXX : integrate XHTML : address tbody
        Head head,
        Body body,
        Indexdef indexdef,
        StringBuffer buffer
    ) {
        String[] words = indexdef.getIndexWords();
        if (words == null) {
            return;
        }
        buffer.append("\n");
        buffer.append("<h2>");
        buffer.append(_makeTitleString(model_.getLabel("index", head)));
        buffer.append("</h2>\n");
        buffer.append("\n");
        buffer.append("<table>\n");
        for (int i = 0;i < words.length;i++) {
            String word = words[i];
            Anchor anchor;
            buffer.append("<tr>");
            buffer.append("<td><b>");
            if ((anchor = indexdef.getDefAnchor(word)) != null) {
                _embedRefTagPrologue(
                    getLogicalFile(anchor) + "#" + _getID(anchor),
                    buffer
                );
                buffer.append("<nobr>");
                buffer.append(word);
                buffer.append("</nobr>");
                _embedRefTagEpilogue(buffer);
            } else {
                buffer.append(word);
            }
            buffer.append("</b></td>");
            Anchor[] anchors = indexdef.getRefAnchors(word);
            buffer.append("<td>");
            for (int j = 0;j < anchors.length;j++) {
                anchor = anchors[j];
                buffer.append(" ");
                _embedRefTagPrologue(
                    getLogicalFile(anchor) + "#" + _getID(anchor),
                    buffer
                );
                buffer.append(_getIndexPointer(anchor));
                _embedRefTagEpilogue(buffer);
            }
            buffer.append("</td>");
            buffer.append("</tr>\n");
        }
        buffer.append("</table>\n");
    }

    // same as HTML4
    private String _getIndexPointer(Content content) {
        String pointer = UDoc.getParentTitledBlockNo(content);
        if (pointer != null) {
            return (pointer);
        } else {
            return ("*");
        }
    }

    // AbstractGeneratorBase
    protected void _makeSentence(
        Sentence sentence,
        StringBuffer buffer
    ) {
        _makeText(sentence, buffer);
    }

    // AbstractGeneratorBase
    protected void _makeTitle(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        Title doctitle = head.getDocTitle();
        Title docsubtitle = head.getDocSubTitle();
        String titleText;
        String titleSrc;
        if (doctitle != null) {
            titleText = doctitle.getText();
            titleSrc = doctitle.getSrc();
        } else {
            titleText = null;
            titleSrc = null;
        }
        DocAuthor authors[] = head.getAuthors();
        String org = head.getOrg();
        boolean preOrg = head.getPreOrg();
        String email = head.getEMail();
        String hp = head.getHP();
        DocDate date = head.getDate();
        Summary summary = head.getSummary();

        if (titleSrc != null) {
            buffer.append("\n");
            buffer.append("<div align=\"center\">\n");
            buffer.append("<img src=\"");
            buffer.append(titleSrc);
            buffer.append("\"");
            if (titleText != null) {
                buffer.append(" alt=\"");
                buffer.append(titleText);
                buffer.append("\"");
            }
            buffer.append(">\n");
            buffer.append("</div>\n");
            buffer.append("\n");
        } else if (titleText != null) {
            buffer.append("\n");
            buffer.append("<div align=\"center\">\n");
            buffer.append("<h1>");
            _makeString(doctitle, buffer);
            if (docsubtitle != null) {
                buffer.append("<br>");
                buffer.append("<small>");
                _makeString(docsubtitle, buffer);
                buffer.append("</small>");
            }
            buffer.append("</h1>\n");
            buffer.append("</div>\n");
            buffer.append("\n");
        }
        if (date != null) {
            buffer.append("<div align=\"center\">");
            buffer.append(date.getText());
            buffer.append("</div>\n");
        }
        if (preOrg) {
            if (org != null) {
                buffer.append("<div align=\"center\">");
                buffer.append(org);
                buffer.append("</div>\n");
            }
        }
        if (authors != null) {
            for (int i = 0;i < authors.length;i++) {
                _makeDocAuthor(authors[i], buffer);
            }
        }
        if (!preOrg) {
            if (org != null) {
                buffer.append("<div align=\"center\">");
                buffer.append(org);
                buffer.append("</div>\n");
            }
        }
        if (email != null) {
            buffer.append("<div align=\"center\">");
            _embedRefTag("mailto:" + email, email, buffer);
            buffer.append("</div>\n");
        }
        if (hp != null) {
            buffer.append("<div align=\"center\">");
            _embedRefTag(hp, hp, buffer);
            buffer.append("</div>\n");
        }
        if (summary != null) { // abstract
            buffer.append("<hr>\n");
            _makeText(summary, buffer);
            buffer.append("<hr>\n");
        }
    }

    private void _makeDocAuthor(DocAuthor author, StringBuffer buffer) {
        String note = author.getNote();
        String org = author.getOrg();
        String email = author.getEMail();
        String hp = author.getHP();
        buffer.append("<div align=\"center\">");
        _makeText(author, buffer);
        if (org != null || email != null || hp != null || note != null) {
            buffer.append("(");
        }
        if (org != null) {
            buffer.append(org);
        }
        if (email != null) {
            if (org != null) {
                buffer.append(", ");
            }
            _embedRefTag("mailto:" + email, email, buffer);
        }
        if (hp != null) {
            if (org != null || email != null) {
                buffer.append(", ");
            }
            _embedRefTag(hp, hp, buffer);
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
        buffer.append("</div>\n");
    }

    // AbstractGeneratorBase
    protected void _makeParagraph(Paragraph p, StringBuffer buffer) {
        _makeText(p, buffer);
        buffer.append("<br>\n");
    }

    // AbstractGeneratorBase
    protected void _makePartPrologue(Part part, StringBuffer buffer) {
        String title = part.getTitle();
        buffer.append("\n");
        buffer.append("<h1>");
        buffer.append("<a name=\"");
        buffer.append(_getID(part));
        buffer.append("\">");
        buffer.append(title);
        buffer.append("</a>\n");
        buffer.append("</h1>");
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makePartEpilogue(Part part, StringBuffer buffer) {
        _makeFootnote(part, buffer);
    }

    // AbstractGeneratorBase
    protected void _makeChapterPrologue(
        Chapter chapter,
        StringBuffer buffer
    ) {
        _makeFootnote(chapter, buffer);
        String title = chapter.getTitle();
        buffer.append("\n");
        buffer.append("<h1>");
        buffer.append("<a name=\"");
        buffer.append(_getID(chapter));
        buffer.append("\">");
        buffer.append(title);
        buffer.append("</a>\n");
        buffer.append("</h1>");
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeChapterEpilogue(
        Chapter chapter,
        StringBuffer buffer
    ) {
        _makeFootnote(chapter, buffer);
    }

    // AbstractGeneratorBase
    protected void _makeSectionPrologue(
        Section section,
        StringBuffer buffer
    ) {
        _makeFootnote(section, buffer);
        String title = section.getTitle();
        buffer.append("\n");
        buffer.append("<h2>");
        buffer.append("<a name=\"");
        buffer.append(_getID(section));
        buffer.append("\">");
        buffer.append(title);
        buffer.append("</a>\n");
        buffer.append("</h2>");
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeSectionEpilogue(
        Section section,
        StringBuffer buffer
    ) {
        _makeFootnote(section, buffer);
    }

    // AbstractGeneratorBase
    protected void _makeSubSectionPrologue(
        SubSection subsection,
        StringBuffer buffer
    ) {
        _makeFootnote(subsection, buffer);
        String title = subsection.getTitle();
        buffer.append("\n");
        buffer.append("<h3>");
        buffer.append("<a name=\"");
        buffer.append(_getID(subsection));
        buffer.append("\">");
        buffer.append(title);
        buffer.append("</a>\n");
        buffer.append("</h3>");
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeSubSectionEpilogue(
        SubSection subsection,
        StringBuffer buffer
    ) {
        _makeFootnote(subsection, buffer);
    }

    // AbstractGeneratorBase
    protected void _makeSubSubSectionPrologue(
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
        _makeFootnote(subsubsection, buffer);
        String title = subsubsection.getTitle();
        buffer.append("\n");
        buffer.append("<h4>");
        buffer.append("<a name=\"");
        buffer.append(_getID(subsubsection));
        buffer.append("\">");
        buffer.append(title);
        buffer.append("</a>\n");
        buffer.append("</h4>");
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeSubSubSectionEpilogue(
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
        _makeFootnote(subsubsection, buffer);
    }

    // AbstractGeneratorBase
    protected void _makeAppendix(
        Appendix appendix,
        StringBuffer buffer
    ) {
        buffer.append("<hr>\n");
/*
        String title = appendix.getTitle();
        buffer.append("\n");
        buffer.append("<a name=\"");
        buffer.append(_getID(appendix));
        buffer.append("\">");
        buffer.append("</a>\n");
        buffer.append("<h4>");
        if (title != null) {
            buffer.append("Appendix");
        } else {
            buffer.append(title);
        }
        buffer.append("</h4>");
        buffer.append("\n");
*/
        _makeText(appendix, buffer);
    }

    // AbstractGeneratorBase
    protected void _makeFYI(
        FYI fyi,
        StringBuffer buffer
    ) {
        String title = fyi.getTitle();
        buffer.append("\n");
        buffer.append("<a name=\"");
        buffer.append(_getID(fyi));
        buffer.append("\">");
        buffer.append("</a>\n");
        if (html3Config_.isStrictDTD()) {
            buffer.append("<table border=1>\n");
        } else {
            buffer.append("<table bgcolor=peachpuff>\n");
        }
        if (title != null) {
            buffer.append("<tr>\n");
            buffer.append("<th>");
            buffer.append(title);
            buffer.append("</th>\n");
            buffer.append("</tr>\n");
        }
        buffer.append("<tr>\n");
        buffer.append("<td>");
        _makeText(fyi, buffer);
        buffer.append("</td>\n");
        buffer.append("</tr>\n");
        buffer.append("</table>\n");
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeUl(Ul ul, StringBuffer buffer) {
        buffer.append("\n");
        buffer.append("<ul>\n");
        _makeString(ul, buffer);
        buffer.append("</ul>\n");
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeOl(Ol ol, StringBuffer buffer) {
        buffer.append("\n");
        buffer.append("<ol>\n");
        _makeString(ol, buffer);
        buffer.append("</ol>\n");
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeLi(Li li, StringBuffer buffer) {
        buffer.append("<li> ");
        _makeString(li, buffer);
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeDl(Dl dl, StringBuffer buffer) {
        buffer.append("\n");
        buffer.append("<dl>\n");
        _makeString(dl, buffer);
        buffer.append("</dl>\n");
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeDt(Dt dt, StringBuffer buffer) {
        buffer.append("<dt>\n");
        _makeString(dt, buffer);
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeDd(Dd dd, StringBuffer buffer) {
        buffer.append("<dd>\n");
        _makeString(dd, buffer);
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeTable(Table table, StringBuffer buffer) {
        Title caption = table.getTitleNode();
        String clazz = table.getClazz();
        if (clazz == null) {
            clazz = "data";
        }
        String id = _getID(table);
        buffer.append("<a name=\"");
        buffer.append(id);
        buffer.append("\">");
        buffer.append("</a>\n");
        Tnote tnote = table.getTnote();
        // introductory notes
        if (tnote != null) {
            buffer.append("<table>\n");
            buffer.append("<tr>\n");
            buffer.append("<td>\n");
        }
        // table definition
        buffer.append("<table");
        if (tnote != null) {
            buffer.append(" style=\"margin-bottom:0\"");
        }
        if (!html3Config_.isStrictDTD()) {
            _embedAttr("class", clazz, buffer);
        }
        if (!clazz.equals("menu")) { // XXX : generic
            buffer.append( " border=1");
        }
        buffer.append(">\n");
        // meta info
        if (caption != null) {
            buffer.append("<caption>");
            _makeText(caption, buffer);
            buffer.append("</caption>\n");
        }
        // table contents
        PTable ptable = table.getPTable();
        if (ptable != null) {
            _makePTableContents(ptable, buffer);
        } else {
            _makeLTableContents(table, buffer);
        }
        // table definition
        buffer.append("</table>\n");
        // introductory notes
        if (tnote != null) {
            buffer.append("</td>\n");
            buffer.append("</tr>\n");
            buffer.append("<tr>\n");
            buffer.append("<td align=right>\n");
            _makeTnote(tnote, buffer);
            buffer.append("</td>\n");
            buffer.append("</tr>\n");
            buffer.append("</table>\n");
        }
    }

    protected void _makeLTableContents(Table table, StringBuffer buffer) {
        if (table.getTHead() != null) {
            _makeTHead(table, buffer);
        }
        if (table.getTBody() != null) {
            _makeTBody(table, buffer);
        }
        if (table.getTFoot() != null) {
            _makeTFoot(table, buffer);
        }
    }

    protected void _makePTableContents(PTable table, StringBuffer buffer) {
        if (table.getHeadHeight() > 0) {
            _makeTHead(table, buffer);
        }
        _makeTBody(table, buffer);
        if (table.getFootHeight() > 0) {
            _makeTFoot(table, buffer);
        }
    }

    protected void _makeTHead(Table table, StringBuffer buffer) {
        _embedTableData(table.getHeadData(), table, buffer);
    }

    protected void _makeTHead(PTable table, StringBuffer buffer) {
        int width = table.getHeadWidth();
        int height = table.getHeadHeight();
        for (int y = 0;y < height;y++) {
            buffer.append("<tr>\n");
            for (int x = 0;x < width;x++) {
                PTable.HeadCell cell = table.getHead(x, y);
                if (cell == null) {
                    continue;
                }
                buffer.append("<th");
                Th th = cell.data;
                String clazz = null; // XXX
                CSSStyle style = th.getStyle();
                int rowspan = cell.rowspan;
                int colspan = cell.colspan;
                String align = th.getAlign();
                if (clazz != null) {
                    if (!html3Config_.isStrictDTD()) {
                        buffer.append(" class=\"");
                        buffer.append(clazz);
                        buffer.append("\"");
                    }
                }
                if (style != null) {
                    _embedAttr("style", style.getText(), buffer);
                }
                if (rowspan != 1) {
                    _embedAttr("rowspan", rowspan, buffer);
                }
                if (colspan != 1) {
                    _embedAttr("colspan", colspan, buffer);
                }
                if (align != null) {
                    _embedAttr("align", align, buffer);
                }
                buffer.append(">");
                if (th != null) {
                    _makeString(th, buffer);
                }
                buffer.append("</th>\n");
            }
            buffer.append("</tr>\n");
        }
    }

    protected void _makeTFoot(Table table, StringBuffer buffer) {
        _embedTableData(table.getFootData(), null, buffer);
    }

    protected void _makeTFoot(PTable table, StringBuffer buffer) {
    }

    protected void _makeTBody(Table table, StringBuffer buffer) {
        _embedTableData(table.getBodyData(), null, buffer);
    }

/*
    protected void _makeTBody0(Table table, StringBuffer buffer) {
        int width = table.getWidth();
        int height = table.getHeight();
        for (int y = 0;y < height;y++) {
            buffer.append("<tr>\n");
            for (int x = 0;x < width;x++) {
                Td td = table.getTd(x, y);
                if (td == null) {
                    continue;
                }
                String clazz = table.getClazz(x, y);
                CSSStyle style = td.getStyle();
                int rowspan = td.getRowSpan();
                int colspan = td.getColSpan();
                String align = td.getAlign();
                buffer.append("<td");
                if (clazz != null) {
                    buffer.append(" class=\"");
                    buffer.append(clazz);
                    buffer.append("\"");
                }
                if (style != null) {
                    _embedAttr("style", style.getText(), buffer);
                }
                if (rowspan != 1) {
                    _embedAttr("rowspan", rowspan, buffer);
                }
                if (colspan != 1) {
                    _embedAttr("colspan", colspan, buffer);
                }
                if (align != null) {
                    _embedAttr("align", align, buffer);
                }
                buffer.append(">");
                if (td != null) {
                    _makeString(td, buffer);
                }
                buffer.append("</td>\n");
            }
            buffer.append("</tr>\n");
        }
    }
*/

    protected void _makeTBody(PTable table, StringBuffer buffer) {
        int width = table.getDataWidth();
        int height = table.getDataHeight();
        for (int y = 0;y < height;y++) {
            buffer.append("<tr>\n");
            for (int x = 0;x < width;x++) {
                PTable.DataCell cell = table.getData(x, y);
                if (cell == null) {
                    continue;
                }
                buffer.append("<td");
                Td td = cell.data;
                String clazz = null; // XXX
                CSSStyle style = td.getStyle();
                int rowspan = cell.rowspan;
                int colspan = cell.colspan;
                String align = td.getAlign();
                if (clazz != null) {
                    if (!html3Config_.isStrictDTD()) {
                        buffer.append(" class=\"");
                        buffer.append(clazz);
                        buffer.append("\"");
                    }
                }
                if (style != null) {
                    _embedAttr("style", style.getText(), buffer);
                }
                if (rowspan != 1) {
                    _embedAttr("rowspan", rowspan, buffer);
                }
                if (colspan != 1) {
                    _embedAttr("colspan", colspan, buffer);
                }
                if (align != null) {
                    _embedAttr("align", align, buffer);
                }
                buffer.append(">");
                if (td != null) {
                    _makeString(td, buffer);
                }
                buffer.append("</td>\n");
            }
            buffer.append("</tr>\n");
        }
    }

    protected void _makeTnote(Tnote tnote, StringBuffer buffer) {
        Content[] contents = tnote.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof Dl) {
                _makeTnoteDl((Dl)content, buffer);
            } else if (content instanceof Ul) {
                _makeTnoteUl((Ul)content, buffer);
            }
        }
    }

    protected void _makeTnoteDl(Dl dl, StringBuffer buffer) {
        Content[] contents = dl.getContents();
        buffer.append("<table>\n");
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof Dt) {
                buffer.append("<tr>\n");
                buffer.append("<td style=\"font-size:x-small\">");
                _makeString((Dt)content, buffer);
                buffer.append("</td>\n");
                buffer.append("<td style=\"font-size:x-small\">:</td>\n");
            } else if (content instanceof Dd) {
                buffer.append("<td style=\"font-size:x-small\">\n");
                _makeString((Dd)content, buffer);
                buffer.append("</td>\n");
                buffer.append("</tr>\n");
            }
        }
        buffer.append("</table>\n");
    }

    protected void _makeTnoteUl(Ul ul, StringBuffer buffer) {
        Content[] contents = ul.getContents();
        buffer.append("<table>\n");
        buffer.append("<tr>\n");
        buffer.append("<td align=left>\n");
        ul.setStyle("font-size:x-small;margin-top:0pt;margin-bottom:0pt");
        _makeUl(ul, buffer);
        buffer.append("</td>\n");
        buffer.append("</tr>\n");
        buffer.append("</table>\n");
    }

    // AbstractXHTMLGeneratorBase
    protected String _getCellClass(
        TrContent cell,
        Table table,
        int x,
        int y
    ) {
        return (null);
    }

    // AbstractXHTMLGeneratorBase
    protected CSSStyle _getCellStyle(
        TrContent cell,
        Table table,
        int x,
        int y
    ) {
        return (null);
    }

    // AbstractXHTMLGeneratorBase
    protected String _getCellAlign(
        TrContent cell,
        Table table,
        int x,
        int y
    ) {
        String align = cell.getAlign();
        if (align != null) {
            return (align);
        }
        if (table != null) {
            return (table.getAlign(x, y));
        } else {
            return (null);
        }
    }

    // AbstractGeneratorBase
    protected void _makeImg(Img img, StringBuffer buffer) {
        String url = img.getSrc();
        Title caption = img.getTitleNode();
        if (img.hasReferer()) {
            String id = _getID(img);
            buffer.append("<a name=\"");
            buffer.append(id);
            buffer.append("\">");
        }
        buffer.append("<img");
        buffer.append(" src=\"");
        buffer.append(url);
        buffer.append("\"");
        if (caption != null) {
            buffer.append(" alt=\"");
            _makeText(caption, buffer);
            buffer.append("\"");
        }
        buffer.append(">");
        if (img.hasReferer()) {
            buffer.append("</a>");
        }
    }

    // AbstractGeneratorBase
    protected void _makeImage(ImageFigure image, StringBuffer buffer) {
        String url = image.getSrc();
/*        
        url = image.getGIFURL(); // XXX
        if (url == null) {
            url = image.getJPEGURL();
            if (url == null) {
                url = image.getSrcURL() + ".gif";
            }
        }
*/
        String id = _getID(image);
        Title caption = image.getTitleNode();
        buffer.append("\n");
        buffer.append("<p>\n");
        buffer.append("<a name=\"");
        buffer.append(id);
        buffer.append("\">");
        buffer.append("<img");
        buffer.append(" src=\"");
        buffer.append(url);
        buffer.append("\"");
        if (caption != null) {
            buffer.append(" alt=\"");
            _makeText(caption, buffer);
            buffer.append("\"");
        }
        buffer.append(">");
        buffer.append("</a>\n");
        buffer.append("<p>\n");
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeSpan(Span span, StringBuffer buffer) {
        if (html3Config_.isStrictDTD()) {
            _makeString(span, buffer);
            String ruby = span.getRuby();
            if (ruby != null) {
                buffer.append("<sup>(");
                buffer.append(ruby);
                buffer.append(")</sup>");
            }
        } else {
            _embedTagPrologue("span", span, buffer);
            _makeString(span, buffer);
            String ruby = span.getRuby();
            if (ruby != null) {
                buffer.append("<sup>(");
                buffer.append(ruby);
                buffer.append(")</sup>");
            }
            _embedTagEpilogue("span", buffer);
        }
    }

    // AbstractGeneratorBase
    protected void _makeTerm(Term term, StringBuffer buffer) {
        _makeString(term, buffer);
    }

    // AbstractGeneratorBase
    protected void _makeIndex(Index index, StringBuffer buffer) {
        buffer.append("<a name=\"");
        buffer.append(_getID(index));
        buffer.append("\">");
        _makeString(index, buffer);
        buffer.append("</a>");
    }

    // AbstractGeneratorBase
    protected void _makeBold(Bold bold, StringBuffer buffer) {
        _embedTagPrologue("b", bold, buffer);
        _makeString(bold, buffer);
        _embedTagEpilogue("b", buffer);
    }

    // AbstractGeneratorBase
    protected void _makeItalic(Italic italic, StringBuffer buffer) {
        _embedTagPrologue("i", italic, buffer);
        _makeString(italic, buffer);
        _embedTagEpilogue("i", buffer);
    }

    // AbstractGeneratorBase
    protected void _makeDfn(Dfn dfn, StringBuffer buffer) {
        buffer.append("<a name=\"");
        buffer.append(_getID(dfn));
        buffer.append("\">");
        buffer.append("<dfn>");
        _makeString(dfn, buffer);
        buffer.append("</dfn>");
        buffer.append("</a>");
    }

    // AbstractGeneratorBase
    protected void _makeTt(Tt tt, StringBuffer buffer) {
        _makeInlineTag("tt", tt, buffer); // model logic for non-block container
    }

    // AbstractGeneratorBase
    protected void _makeEm(Em em, StringBuffer buffer) {
        _makeInlineTag("em", em, buffer); // model logic for non-block container
    }

    // AbstractGeneratorBase
    protected void _makeStrong(Strong strong, StringBuffer buffer) {
        _makeInlineTag("strong", strong, buffer); // model logic for non-block container
    }

    // AbstractGeneratorBase
    protected void _makeAbbr(Abbr abbr, StringBuffer buffer) {
        _makeInlineTag("abbr", abbr, buffer); // model logic for non-block container
    }

    // AbstractGeneratorBase
    protected void _makeAcronym(Acronym acronym, StringBuffer buffer) {
        _makeInlineTag("acronym", acronym, buffer); // model logic for non-block container
    }

    // AbstractGeneratorBase
    protected void _makeCode(Code code, StringBuffer buffer) {
        _makeInlineTag("code", code, buffer); // model logic for non-block container
    }

    // AbstractGeneratorBase
    protected void _makeBlockquote(
        Blockquote blockquote,
        StringBuffer buffer
    ) {
        _makeBlockTag("blockquote", blockquote, buffer);
    }

    // AbstractGeneratorBase
    protected void _makeQuote(Quote quote, StringBuffer buffer) {
        _makeInlineTag("q", quote, buffer);
    }

    // AbstractGeneratorBase
    protected void _makeAnchor(Anchor anchor, StringBuffer buffer) {
        buffer.append("<a name=\"");
        buffer.append(_getID(anchor));
        buffer.append("\">");
        buffer.append(anchor.getText());
        buffer.append("</a>");
    }

    // AbstractGeneratorBase
    protected void _makePre(Pre pre, StringBuffer buffer) {
        Title caption = pre.getTitleNode();
        String id = _getID(pre);
        String src = pre.getSrc();
        buffer.append("\n");
        if (pre.hasReferer()) {
            buffer.append("<a name=\"");
            buffer.append(id);
            buffer.append("</a>");
            buffer.append("</a>");
            buffer.append("\n");
        }
        buffer.append("<pre");
        buffer.append(">");
        _makeText(pre, buffer);
        buffer.append("</pre>\n");
    }

    // AbstractGeneratorBase
    protected void _makeProgram(Program program, StringBuffer buffer) {
        Title caption = program.getTitleNode();
        String id = _getID(program);
        String src = program.getSrc();
        buffer.append("\n");
        buffer.append("<p>\n");
        buffer.append("<table border=1>\n");
        if (caption != null) {
            buffer.append("<caption>");
            _makeText(caption, buffer);
            buffer.append("</caption>\n");
        }
        buffer.append("<tr>\n");
        buffer.append("<td>");
        if (html3Config_.isStrictDTD()) {
            buffer.append("<pre>");
        } else {
            buffer.append("<pre class=program>");
        }
        _makeText(program, buffer);
        buffer.append("</pre>");
        buffer.append("</td>\n");
        buffer.append("</tr>\n");
        buffer.append("</table>\n");
        buffer.append("<p>\n");
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeConsole(Console console, StringBuffer buffer) {
        Title caption = console.getTitleNode();
        String id = _getID(console);
        String src = console.getSrc();
        buffer.append("\n");
        buffer.append("<p>\n");
        buffer.append("<a name=\"");
        buffer.append(id);
        buffer.append("\">");
        buffer.append("</a>");
        buffer.append("<table border=1>\n");
        if (caption != null) {
            buffer.append("<caption>");
            _makeText(caption, buffer);
            buffer.append("</caption>\n");
        }
        buffer.append("<tr>\n");
        buffer.append("<td>");
        buffer.append("<pre");
        if (html3Config_.isStrictDTD()) {
            buffer.append(">");
        } else {
            buffer.append(" class=console style=\"margin-top:0\">\n");
        }
        _makeText(console, buffer);
        buffer.append("</pre>");
        buffer.append("</td>\n");
        buffer.append("</tr>\n");
        buffer.append("</table>\n");
        buffer.append("<p>\n");
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeEquation(Equation equation, StringBuffer buffer) {
        String clazz = equation.getClazz();
        buffer.append("\n");
        _embedTagPrologue("div", equation, buffer);
        buffer.append("<table>\n");
        buffer.append("<tr><td>");
        _makeText(equation, buffer);
        buffer.append("</td>\n");
        buffer.append("<td width=\"20\"></td>\n");
        buffer.append("<td>\n");
        buffer.append("(");
        buffer.append(UDoc.getSequenceNumberBasedSubSubSection(equation));
        buffer.append(")");
        buffer.append("</td></tr>\n");
        buffer.append("</table>\n");
        _embedTagEpilogue("div", buffer);
        buffer.append("\n");
    }

    // AbstractGeneratorBase
    protected void _makeDiv(Div div, StringBuffer buffer) {
        String clazz = div.getClazz();
        if (clazz == null) {
            _makeBlockTag("div", div, buffer);
        } else if ("result".equals(clazz)) { // XXX : more generic
            buffer.append("<hr>\n");
            _makeBlockTag("div", div, buffer);
            buffer.append("<hr>\n");
        } else {
            _makeBlockTag("div", div, buffer);
        }
    }

    // AbstractGeneratorBase
    protected void _makeRef(Ref ref, StringBuffer buffer) {
        String href = ref.getHref();
        Content[] contents = ref.getContents();        // XXX
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
                    String srcFile = getLogicalFile(ref);
                    String destFile = getLogicalFile(link);
                    if (srcFile.equals(destFile)) {
                        _embedRefTagPrologue("#" + _getID(link), ref, buffer);
                    } else {
                        _embedRefTagPrologue(
                            destFile + "#" + _getID(link),
                            ref,
                            buffer
                        );
                    }
                    if (contents.length > 0) {
                        _makeString(ref, buffer);
                    } else {
                        buffer.append(label);
                        if (link != null) {
                            String title = link.getTitle();
                            if (title != null) {
                                buffer.append("[");
                                _makeString(link.getTitleNode(), buffer);
                                buffer.append("]");
                            }
                        } else {
                            monitor_.warning("no link : " + href);
//                            label = "*unresolved*";
                        }
                    }
                    _embedRefTagEpilogue(buffer);
                    return;
                } else if (link instanceof ImageFigure) {
                    label = _adjustStringInContext(
                        model_.getLabel("figure", ref),
                        ref
                    );
                } else if (link instanceof Table) {
                    label = _adjustStringInContext(
                        model_.getLabel("table", ref),
                        ref
                    );
                } else if (link instanceof Console) {
                    label = _adjustStringInContext(
                        model_.getLabel("figure", ref),
                        ref
                    );
                } else if (link instanceof Program) {
                    label = _adjustStringInContext(
                        model_.getLabel("list", ref),
                        ref
                    );
                } else if (link instanceof Part) {
                    label = _adjustStringInContext(
                        model_.getLabel("part", ref),
                        ref
                    );
                } else if (link instanceof Chapter) {
                    label = _adjustStringInContext(
                        model_.getLabel("chapter", ref),
                        ref
                    );
                } else if (link instanceof Section) {
                    label = _adjustStringInContext(
                        model_.getLabel("section", ref),
                        ref
                    );
                } else if (link instanceof SubSection) {
                    label = _adjustStringInContext(
                        model_.getLabel("section", ref),
                        ref
                    );
                } else if (link instanceof SubSubSection) {
                    label = _adjustStringInContext(
                        model_.getLabel("section", ref),
                        ref
                    );
                } else if (link instanceof Equation) {
                    String[] parts = model_.getLabelParts("equation", ref);
                    StringBuffer temp = new StringBuffer();
                    if (parts[0] != null) {
                        temp.append(parts[0]);
                    }
                    temp.append(UDoc.getSequenceNumberLabel(link));
                    if (parts[1] != null) {
                        temp.append(parts[1]);
                    }
                    label = new String(temp);
                } else if (link instanceof Bibitem) {
                    // XXX : correct control flow
                    String srcFile = getLogicalFile(ref);
                    String destFile = getLogicalFile(link);
                    if (srcFile.equals(destFile)) {
                        _embedRefTagPrologue("#" + _getID(link), ref, buffer);
                    } else {
                        _embedRefTagPrologue(
                            destFile + "#" + _getID(link),
                            ref,
                            buffer
                        );
                    }
                    if (contents.length > 0) {
                        _makeString(ref, buffer);
                    } else {
                        String title = null;
                        if (link instanceof Book) {
                            title = ((Book)link).getTitle();
                        } else if (link instanceof Article) {
                            title = ((Article)link).getTitle();
                        }
                        String number = UDoc.getSequenceNumberBasedSubSubSection(link);
                        if (number == null) {
                            buffer.append("[");
                            buffer.append(UDoc.adjustStringInContext(
                                model_.getLabel("bibliography", ref),
                                ref
                            ));
                            buffer.append("]");
                        } else {
                            buffer.append("[");
                            buffer.append(number);
                            buffer.append("]");
                        }
                    }
                    _embedRefTagEpilogue(buffer);
                    return;
                } else if (link instanceof Note) {
                    Note note = (Note)link;
                    String srcFile = getLogicalFile(ref);
                    String destFile = getLogicalFile(link);
                    if (srcFile.equals(destFile)) {
                        _embedRefTagPrologue("#" + _getID(link), ref, buffer);
                    } else {
                        _embedRefTagPrologue(
                            destFile + "#" + _getID(link), ref, buffer
                        );
                    }
                    if (contents.length > 0) {
                        _makeString(ref, buffer);
                    } else {
                        int number = note.getNumber();
                        buffer.append("(");
                        buffer.append(number);
                        buffer.append(")");
                    }
                    _embedRefTagEpilogue(buffer);
                    return;
                } else {
                    label = "";
                }
            } else {
                monitor_.warning("no link : " + href);
                label = "*unresolved*";
                _embedRefTagPrologue(href, ref, buffer);
                buffer.append(label);
                _embedRefTagEpilogue(buffer);
                return;
            }
            String srcFile = getLogicalFile(ref);
            String destFile = getLogicalFile(link);
            if (srcFile.equals(destFile)) {
                _embedRefTagPrologue("#" + _getID(link), ref, buffer);
            } else {
                _embedRefTagPrologue(
                    destFile + "#" + _getID(link),
                    ref,
                    buffer
                );
            }
            if (contents.length > 0) {
                _makeString(ref, buffer);
            } else {
                buffer.append(label);
                if (link != null) {
                    String title = link.getTitle();
                    if (title != null) {
                        buffer.append("[");
                        _makeString(link.getTitleNode(), buffer);
                        buffer.append("]");
                    }
                } else {
                    monitor_.warning("no link : " + href);
                    label = "*unresolved*";
                }
            }
            _embedRefTagEpilogue(buffer);
            break;
        case Ref.HYPER_LINK:
            _embedRefTagPrologue(href, ref, buffer);
            if (contents.length > 0) {
                _makeString(ref, buffer);
            } else {
                buffer.append(href);
            }
            _embedRefTagEpilogue(buffer);
            break;
        case Ref.SITE_LINK:
        case Ref.UNKNOWN_LINK:
            buffer.append("[*unresolved*]");
            break;
        default:
            throw (new InternalError());
        }
    }

    // AbstractGeneratorBase
    protected void _makeCite(Cite cite, StringBuffer buffer) {
        Content[] contents = cite.getContents();
        _makeBibLink(cite, buffer);
    }

    // XXX : same as HTML
    private void _makeBibLink(Content ref, StringBuffer buffer) {
        Content link = ref.getLink();
        if (link == null) {
            buffer.append("[unknown]");
            // XXX : warning
            return;
        }
        String srcFile = getLogicalFile(ref);
        String destFile = getLogicalFile(link);
        if (srcFile.equals(destFile)) {
            _embedRefTagPrologue("#" + _getID(link), ref, buffer);
        } else {
            _embedRefTagPrologue(
                destFile + "#" + _getID(link),
                ref,
                buffer
            );
        }
        if (ref instanceof Container &&
            ((Container)ref).getContents().length > 0) {

            _makeString(ref, buffer);
        } else {
            String title = null;
            if (link instanceof Book) {
                title = ((Book)link).getTitle();
            } else if (link instanceof Article) {
                title = ((Article)link).getTitle();
            }
            if (title != null) {
                _embedAttrAppend("title", title, buffer);
            }
        }
        String number = UDoc.getSequenceNumberBasedSubSubSection(link);
        if (number == null) {
            buffer.append("[");
            buffer.append(UDoc.adjustStringInContext(
                model_.getLabel("bibliography", ref),
                ref
            ));
            buffer.append("]");
        } else {
            buffer.append("[");
            buffer.append(number);
            buffer.append("]");
        }
        _embedRefTagEpilogue(buffer);
    }

    // AbstractGeneratorBase
    protected void _makeComment(Comment comment, StringBuffer buffer) {
        if (html3Config_.isStrictDTD()) {
            buffer.append("<table border=1><tr><td>");
        } else {
            buffer.append("<table><tr><td bgcolor=yellow>");
        }
        _makeString(comment, buffer);
        buffer.append("</td></tr></table>");
    }

    // AbstractGeneratorBase
    protected void _makeNote(Note note, StringBuffer buffer) {
        int number = note.getNumber();
        if (!html3Config_.isStrictDTD()) {
            buffer.append("<span class=note>");
        }
//        _embedRefTagPrologue("#note" + number, note, buffer);
        _embedRefTagPrologue("#" + _getID(note), buffer);
        buffer.append("<sup>(");
        buffer.append(number);
        buffer.append(")</sup>");
        _embedRefTagEpilogue(buffer);
        if (!html3Config_.isStrictDTD()) {
            buffer.append("</span>");
        }
        notes_.add(note);
    }

    protected String _decorateProgramText(String text) {
        StringBuffer buffer = new StringBuffer();
        String[] lines = UString.makeStringList(text);
        String em = null;
        int i = 0;
        for (;i < lines.length;i++) {                // truncate preamble null lines
            if (!lines[i].equals("")) {
                break;
            }
        }
        for (;i < lines.length;i++) {
            String line = lines[i];
            if (line.equals("// &lt;em&gt;")) {
                buffer.append("<em>");
            } else if (line.equals("// &lt;/em&gt;")) {
                buffer.append("</em>");
            } else if (line.startsWith("// &lt;em&gt;")) {
                em = line.substring(
                    "// &lt;em&gt;".length(),
                    line.indexOf("&lt;/em&gt;")
                );
            } else {
                if (em != null) {
                    int index = line.indexOf(em);
                    buffer.append(line.substring(0, index));
                    buffer.append("<em>");
                    buffer.append(line.substring(index, index + em.length()));
                    buffer.append("</em>");
                    buffer.append(line.substring(index + em.length()));
                    buffer.append("\n");
                    em = null;
                } else {
                    buffer.append(line);
                    buffer.append("\n");
                }
            }
        }
        return (new String(buffer));
    }

    protected String _decorateConsoleText(String text) {
        String prompt = "&gt;";        // XXX
        StringBuffer buffer = new StringBuffer();
        String[] lines = UString.makeStringList(text);
        String em = null;
        int i = 0;
        for (;i < lines.length;i++) {                // truncate preamble null lines
            if (!lines[i].equals("")) {
                break;
            }
        }
        for (;i < lines.length;i++) {
            String line = lines[i];
            if (i == 0) {
                int index = line.indexOf(prompt);
                if (index != -1) {
                    buffer.append(line.substring(0, index + prompt.length()));
                    buffer.append("<kbd>");
                    buffer.append(line.substring(index + prompt.length()));
                    buffer.append("</kbd>");
                    buffer.append("\n");
                } else {
                    buffer.append(line);
                    buffer.append("\n");
                }
            } else {
                buffer.append(line);
                buffer.append("\n");
            }
        }
        return (new String(buffer));
    }

    // AbstractGeneratorBase
    protected String _escape(String string) {
        if (string == null) {
            return ("");
        }
        return (UHTML3.escape(string));
    }

    protected void _makeFootnote(Container container, StringBuffer buffer) {
        int nNotes = notes_.size();
        if (nNotes == 0) {
            return;
        }
        buffer.append("\n");
        if (html3Config_.isStrictDTD()) {
            buffer.append("<div>\n");
        } else {
            buffer.append("<div class=footnote>\n");
        }
        buffer.append("<ol start=\"");
        buffer.append(((Note)notes_.get(0)).getNumber());
        buffer.append("\">\n");
        for (int i = 0;i < nNotes;i++) {
            Note note = (Note)notes_.get(i);
            int number = note.getNumber();
//            buffer.append("<a name=\"note");
//            buffer.append(number);
            buffer.append("<a name=\"");
            buffer.append(_getID(note));
            buffer.append("\">");
            buffer.append("</a>\n");
            buffer.append("<li>");
            _makeText(note, buffer);
        }
        buffer.append("</ol>\n");
        buffer.append("</div>\n");
        buffer.append("\n");
        notes_.clear();
    }

    protected void _makeFootnote0(Container container, StringBuffer buffer) {
        List list = new ArrayList();
        _collectNote(container, list);
        if (list.size() == 0) {
            return;
        }
        buffer.append("\n");
        if (html3Config_.isStrictDTD()) {
            buffer.append("<div>\n");
        } else {
            buffer.append("<div class=footnote>\n");
        }
        int nNotes = list.size();
        buffer.append("<ol>\n");
        for (int i = 0;i < nNotes;i++) {
            Note note = (Note)list.get(i);
            int number = note.getNumber();
            buffer.append("<a name=\"note");
            buffer.append(number);
            buffer.append("\">");
            buffer.append("</a>\n");
            buffer.append("<li>");
            _makeText(note, buffer);
        }
        buffer.append("</ol>\n");
        buffer.append("</div>\n");
        buffer.append("\n");
    }

    // AbstractXHTMLGenerator
    protected void _makeIndicatorTop(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        Locale[] locales = config_.getLocales();
        Locale locale = head.getLocale();
        if (html3Config_.isLanguageDirectory() &&
            (locales != null && locales.length > 1)) {

            _makeLanguageDirectory(
                head,
                locales,
                locale,
                buffer
            );
        }
        super._makeIndicatorTop(head, container, buffer);
        buffer.append("<hr>\n");
    }

    // AbstractXHTMLGenerator
    protected void _makeIndicatorBottom(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
/*        if (indicatorType_ == null) {
            return;
            }*/
        buffer.append("<hr>\n");
        super._makeIndicatorBottom(head, container, buffer);
    }

    protected void _makeLanguageDirectory(
        Content content,
        Locale[] locales,
        Locale locale,
        StringBuffer buffer
    ) {
        buffer.append("<div align=\"right\">\n");
        buffer.append("<table border=\"1\">\n");
        buffer.append("<tr>\n");
        for (int i = 0;i < locales.length;i++) {
            Locale current = locales[i];
            if (current.equals(locale)) {
                buffer.append("<td>");
                buffer.append(
                    config_.getLabel(
                        current.toString(),
                        Locale.ENGLISH
                    ).toUpperCase()
                );
                buffer.append("</td>");
            } else {
                if (html3Config_.isStrictDTD()) {
                    buffer.append("<td>");
                } else {
                    buffer.append("<td bgcolor=orange>");
                }
                _embedRefTag(
                    getPhysicalFile(content, current),
                    config_.getLabel(
                            current.toString(),
                            Locale.ENGLISH
                    ).toUpperCase(),
                    buffer
                );
                buffer.append("</td>");
            }
        }
        buffer.append("</tr>\n");
        buffer.append("</table>\n");
        buffer.append("</div>\n");
    }

/*
    // AbstractGeneratorBase
    protected void _makeIndicator(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        if (indicatorType_ == null) {
            return;
        }
        if ("section".equals(indicatorType_)) {
            Doc doc = (Doc)UDoc.getRoot(head);
            Section[] sections = UDoc.getSections(doc);
            String title = head.getDocTitle().getText();
            _makeIndicator(title, doc, container, sections, buffer);
        } else {
            throw (new InternalError(indicatorType_));
        }
    }

    protected void _makeIndicator(
        String title,
        Container root,
        Container current,
        Container[] list,
        StringBuffer buffer
    ) {
        String currentFile = getLogicalFile(current);
        String rootFile = getLogicalFile(root);
        String prevFile = null;
        String nextFile = null;
        for (int i = 0;i < list.length;i++) {
            if (list[i] == current) {
                if (i > 0) {
                    prevFile = getLogicalFile(list[i - 1]);
                } else {
                    prevFile = rootFile;
                }
                if (i < list.length - 1) {
                    nextFile = getLogicalFile(list[i + 1]);
                }
                break;
            }
        }
        if (prevFile == null && nextFile == null) {
            nextFile = getLogicalFile(list[0]);
        }
        _makeIndicator(title, rootFile, prevFile, nextFile, buffer);
    }

    protected void _makeIndicator(
        String title,
        String rootFile,
        String prevFile,
        String nextFile,
        StringBuffer buffer
    ) {
        buffer.append("<div align=\"center\">\n");
        if (prevFile != null) {
            _embedRefTag(prevFile, "&lt;&lt;", buffer);
            buffer.append("\n");
        }
        if (rootFile != null) {
            _embedRefTag(rootFile, title, buffer);
            buffer.append("\n");
        }
        if (nextFile != null) {
            _embedRefTag(nextFile, "&gt;&gt;", buffer);
            buffer.append("\n");
        }
        buffer.append("</div>\n");
    }
*/

    // AbstractXMLGeneratorBase
    protected void _embedTagPrologue(
        String tagname,
        Content content,
        StringBuffer buffer
    ) {
        String id = _getID(content);
        String clazz = content.getClazz();
        CSSStyle style = content.getStyle();

        if (content.hasReferer()) {
            buffer.append("<a name=\"");
            buffer.append(id);
            buffer.append("\">");
            buffer.append("</a>");
        }
        buffer.append("<");
        buffer.append(tagname);
        if (clazz != null) {
            if (!html3Config_.isStrictDTD()) {
                _embedAttr("class", clazz, buffer);
            }
        }
        if (style != null) {
            if (!html3Config_.isStrictDTD()) {
                _embedAttr("style", style.getText(), buffer);
            }
        }
        buffer.append(">");
        if (content.hasReferer()) {
        }
    }

    // AbstractXHTMLGeneratorBase
    protected void _embedRefTagPrologueExternalLinkAttributes(
        String href,
        StringBuffer buffer
    ) {
        if (!html3Config_.isStrictDTD()) {
            super._embedRefTagPrologueExternalLinkAttributes(href, buffer);
        }
    }
}
