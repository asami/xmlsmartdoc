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

package org.xmlsmartdoc.SmartDoc.html4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import org.xmlsmartdoc.SmartDoc.CSSLength;
import org.xmlsmartdoc.SmartDoc.CSSStyle;
import org.xmlsmartdoc.SmartDoc.Chapter;
import org.xmlsmartdoc.SmartDoc.CharBlock;
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
import org.xmlsmartdoc.SmartDoc.DocContext;
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
import org.xmlsmartdoc.SmartDoc.PTable;
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
import org.xmlsmartdoc.SmartDoc.TimeCommand;
import org.xmlsmartdoc.SmartDoc.Title;
import org.xmlsmartdoc.SmartDoc.TitledBlock;
import org.xmlsmartdoc.SmartDoc.Tnote;
import org.xmlsmartdoc.SmartDoc.Tt;
import org.xmlsmartdoc.SmartDoc.UDoc;
import org.xmlsmartdoc.SmartDoc.USmartDoc;
import org.xmlsmartdoc.SmartDoc.Ul;
import org.xmlsmartdoc.SmartDoc.xhtml.AbstractXHTMLGeneratorBase;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.text.UString;

import org.w3c.dom.Element;

import com.AsamiOffice.io.UIO;
import com.AsamiOffice.io.UURL;
import com.AsamiOffice.util.D2Array;
import com.AsamiOffice.xml.UXML;
import com.AsamiOffice.xml.UXMLMaker;

/**
 * AbstractHTML4Generator
 *
 * @since   Nov. 10, 1998
 * @version May. 29, 2007
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class AbstractHTML4Generator
    extends AbstractXHTMLGeneratorBase {

    protected HTML4Config html4Config_;
    protected String dtdtype_;
    protected Symbols symbols_ = new Symbols();
    protected List notes_ = new ArrayList();

    // AbstractGenerator
    public void init(SmartDocConfig config, SmartDocFormatConfig fconfig) {
        super.init(config, fconfig);
        html4Config_ = (HTML4Config)fconfig;
        _setDynamicHandler(html4Config_.getDynamicHandler());
        _useNegotiator(html4Config_.isNegotiation());
    }

    // YaGenerator
    public String getName() {        // XXX
        return ("html4");
    }

    protected void _generateArtifacts(GeneratorResult result) {
        try {
            if (html4Config_.isCopyCSS() ||
                ("link".equals(html4Config_.getCSSInclude()) &&
                 html4Config_.getCSSURL() == null)) {

                String css = UIO.resource2String(
                    "/org/xmlsmartdoc/SmartDoc/html4/lib/article.css",
                    this
                );
                result.addArtifact("article.css", css);
            }
        } catch (IOException e) {
            throw (new InternalError(e.getMessage()));
        }
    }

    protected void _makePrologue(Head head, StringBuffer buffer) {
        Doc doc = head.getDoc();
        String lang = doc.getLanguage();
        String encoding = formatConfig_.getEncoding((Doc)head.getParent());
        if (lang == null) {
            Locale locale = doc.getLocale();
            if (locale != null) {
                lang = locale.toString();
            } else {
                locale = doc.getDocContext().getLocale();
                if (locale != null) {
                    lang = locale.toString();
                }
            }
        }
        if (html4Config_.isXhtml()) {
            buffer.append("<?xml version=\"1.0\" encoding=\"");
            buffer.append(encoding);
            buffer.append("\"?>\n");
        } else if (html4Config_.isStrictDTD()) {
            buffer.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\"\n");
            buffer.append("\t\"http://www.w3.org/TR/REC-html401/strict.dtd\">\n");
        } else {
            buffer.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
            buffer.append("\t\"http://www.w3.org/TR/REC-html401/loose.dtd\">\n");
        }
        buffer.append("<html");
        if (html4Config_.isXhtml()) {
            buffer.append(" xmlns=\"http://www.w3.org/1999/xhtml\"");
        }
        if (lang != null) {
            buffer.append(" lang=\"");
            buffer.append(UHTML4.getHTML4Lang(lang));
            buffer.append("\"");
            if (html4Config_.isXhtml()) {
                buffer.append(" xml:lang=\"");
                buffer.append(UHTML4.getHTML4Lang(lang));
                buffer.append("\"");
            }
        }
        buffer.append(">\n");
    }

    protected void _makeEpilogue(Head head, StringBuffer buffer) {
        buffer.append("</html>\n");
    }

    protected void _makeHead(Head head, StringBuffer buffer) {
        String cssURL = html4Config_.getCSSURL();
        String cssInclude = html4Config_.getCSSInclude();
        Title title = head.getDocTitle();
        String author = head.getAuthor();
        String org = head.getOrg();
        DocDate date = head.getDate();
        String encoding = formatConfig_.getEncoding((Doc)head.getParent());
        Native nativeValue = head.getNative();
        DocContext context = head.getDoc().getDocContext();

        _embedTagPrologue("head", head, buffer);
        buffer.append("\n");
        buffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=");
        buffer.append(encoding);
        buffer.append("\"");
        _embedEmptyTagCloseNL(buffer);
        buffer.append("<meta http-equiv=\"Content-Style-Type\" content=\"text/css\"");
        _embedEmptyTagCloseNL(buffer);
        buffer.append("<meta http-equiv=\"Content-Script-Type\" content=\"text/javascript\"");
        _embedEmptyTagCloseNL(buffer);
        buffer.append("<meta name=\"generator\" content=\"SmartDoc ");
        buffer.append(config_.getVersion());
        buffer.append("\"");
        _embedEmptyTagCloseNL(buffer);
        if (author != null) {
            String lang = head.getLanguage(); // XXX : really author tag
            buffer.append("<meta name=\"author\" content=\"");
            buffer.append(author);
            buffer.append("\"");
            if (lang != null) {
                buffer.append(" lang=\"");
                buffer.append(lang);
                buffer.append("\"");
            }
            _embedEmptyTagCloseNL(buffer);
        }
        if (date != null) {
            String lang = head.getLanguage(); // XXX : really date tag
            buffer.append("<meta name=\"date\" content=\"");
            buffer.append(date.getText()); // XXX : canonical format
            buffer.append("\"");
            if (lang != null) {
                buffer.append(" lang=\"");
                buffer.append(lang);
                buffer.append("\"");
            }
            _embedEmptyTagCloseNL(buffer);
        }
        // meta copyright
        // meta keywords
        buffer.append("<title>");
        if (title != null) {
            _makeString(title, buffer);
        }
        buffer.append("</title>\n");
        if ("link".equals(cssInclude)) {
            buffer.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
            if (cssURL == null) {
                cssURL = "article.css";
            }
            buffer.append(cssURL);
            buffer.append("\"");
            _embedEmptyTagCloseNL(buffer);
        } else if ("embed".equals(cssInclude)) {
            buffer.append("<style type=\"text/css\">\n");
            if (true) {                // XXX
                buffer.append("<!--\n");
            }
            if (cssURL == null) {
                cssURL = UURL.getURLFromResourceName(
                    "/org/xmlsmartdoc/SmartDoc/html4/lib/article.css",
                    this
                ).toExternalForm();
            }
//            buffer.append(USmartDoc.importText(cssURL, context));
            buffer.append(USmartDoc.importText(cssURL));
            if (true) {
                buffer.append("-->\n");
            }
            buffer.append("</style>\n");
        } else {
            monitor_.warning("Bad html4.css.include = " + cssInclude);
        }
        if (true) {                // XXX
            String script = dynamic_.getScript();
            if (script != null) {
                buffer.append("<script>");
//                _embedAttrAppend("language", "JavaScript", buffer);
                _embedAttrAppend("type", "text/javascript", buffer);
                buffer.append("\n");
                buffer.append("<!--\n");
                buffer.append(script);
                buffer.append("// -->\n");
                buffer.append("</script>");
                buffer.append("\n");
            }
        }
        if (nativeValue != null) {
            buffer.append(nativeValue.getText());
            buffer.append("\n");
        }
        buffer.append("</head>\n");
    }

    protected void _makeBodyPrologue(
        Head head,
        Body body,
        StringBuffer buffer
    ) {
        _embedTagPrologue("body", body, buffer);
        if (html4Config_.isOHP()) {
            _embedAttrAppend("onLoad", "setOHPHandler()", buffer);
        }
        buffer.append("\n");
    }

    protected void _makePower(StringBuffer buffer) {
        if (html4Config_.isPoweredLogo()) {
            buffer.append("<div style=\"text-align:right\"><a href=\"http://www.XMLSmartDoc.org\" target=\"_top\"><span style=\"color:#4F5952;background:#EE8362;font-family:sans-serif;font-size:xx-small;text-decoration:none\">Powered by </span><span style=\"color:#058258;background:#EE8362;font-family:fantasy, sans-serif;font-size:x-small;text-decoration:none\">SmartDoc</span></a></div>\n");
        }
    }

    protected void _makeLanguageIndicator(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        Locale[] locales = config_.getLocales();
        Locale locale = head.getLocale();
        if (html4Config_.isLanguageDirectory() &&
            (locales != null && locales.length > 1)) {

            _makeLanguageDirectory(
                head,
                locales,
                locale,
                buffer
            );
        }
    }

    protected void _makeLanguageDirectory(
        Content content,
        Locale[] locales,
        Locale locale,
        StringBuffer buffer
    ) {
        buffer.append("<div class=\"languages\">\n");
        buffer.append("<table class=\"languages\">\n");
        buffer.append("<tr>\n");
        for (int i = 0;i < locales.length;i++) {
            Locale current = locales[i];
            if (current.equals(locale)) {
                buffer.append("<td class=\"current\">");
                String name = config_.getLabel(
                        current.toString(),
                        Locale.ENGLISH
                );
                if (name != null) {
                    name = name.toUpperCase();
                } else {
                    name = current.toString();
                }
                buffer.append(name);
                buffer.append("</td>");
            } else {
                buffer.append("<td class=\"other\">");
                String name = config_.getLabel(
                    current.toString(),
                    Locale.ENGLISH
                );
                if (name != null) {
                    name = name.toUpperCase();
                } else {
                    name = current.toString();
                }
                _embedRefTag(
                    getPhysicalFile(content, current),
                    name,
                    buffer
                );
                buffer.append("</td>");
            }
        }
        buffer.append("</tr>\n");
        buffer.append("</table>\n");
        buffer.append("</div>\n");
    }

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
        DocAuthor[] authors = head.getAuthors();
        String org = head.getOrg();
        boolean preOrg = head.getPreOrg();
        String email = head.getEMail();
        String hp = head.getHP();
        DocDate date = head.getDate();
        Summary summary = head.getSummary();

        if (titleSrc != null) {
            buffer.append("\n");
            buffer.append("<div class=\"title\">\n");
            buffer.append("<img src=\"");
            buffer.append(titleSrc);
            buffer.append("\"");
            if (titleText != null) {
                buffer.append(" alt=\"");
                buffer.append(titleText);
                buffer.append("\"");
            }
            if (html4Config_.isXhtml()) {
                buffer.append(" /");
            }
            buffer.append(">\n");
            buffer.append("</div>\n");
            buffer.append("\n");
        } else if (titleText != null) {
            buffer.append("\n");
            buffer.append("<h1 class=\"title\">");
            _makeString(doctitle, buffer);
            if (docsubtitle != null) {
                buffer.append("<br");
                if (html4Config_.isXhtml()) {
                    buffer.append(" />");
                } else {
                    buffer.append(">");
                }
                buffer.append("<span class=\"subtitle\">");
                _makeString(docsubtitle, buffer);
                buffer.append("</span>");
            }
            buffer.append("</h1>\n");
            buffer.append("\n");
        }
        if (date != null) {
            buffer.append("<div class=\"date\">");
            buffer.append(date.getText());
            buffer.append("</div>\n");
        }
        if (preOrg) {
            if (org != null) {
                buffer.append("<div class=\"org\">");
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
                buffer.append("<div class=\"org\">");
                buffer.append(org);
                buffer.append("</div>\n");
            }
        }
        if (email != null) {
            buffer.append("<div class=\"email\">");
            _embedRefTag("mailto:" + email, email, buffer);
            buffer.append("</div>\n");
        }
        if (hp != null) {
            buffer.append("<div class=\"hp\">");
            _embedRefTag(hp, hp, buffer);
            buffer.append("</div>\n");
        }
        if (summary != null) {
            buffer.append("<div class=\"summary\">\n"); // abstract
            _makeText(summary, buffer);
            buffer.append("</div>\n");
        }
    }

    private void _makeDocAuthor(DocAuthor author, StringBuffer buffer) {
        String note = author.getNote();
        String org = author.getOrg();
        String email = author.getEMail();
        String hp = author.getHP();
        buffer.append("<div class=\"author\">");
        _makeText(author, buffer);
        if (org != null || email != null || hp != null || note != null) {
            buffer.append("(");
        }
        if (org != null) {
            buffer.append("<span class=\"org\">");
            buffer.append(org);
            buffer.append("</span>");
        }
        if (email != null) {
            if (org != null) {
                buffer.append(", ");
            }
            buffer.append("<span class=\"mail\">");
            _embedRefTag("mailto:" + email, email, buffer);
            buffer.append("</span>");
        }
        if (hp != null) {
            if (org != null || email != null) {
                buffer.append(", ");
            }
            buffer.append("<span class=\"hp\">");
            _embedRefTag(hp, hp, buffer);
            buffer.append("</span>");
        }
        if (note != null) {
            if (org != null || email != null || hp != null) {
                buffer.append(", ");
            }
            buffer.append("<span class=\"note\">");
            buffer.append(note);
            buffer.append("</span>");
        }
        if (org != null || email != null || hp != null || note != null) {
            buffer.append(")");
        }
        buffer.append("</div>\n");
    }

    protected void _makeBodyEpilogue(
        Head head,
        Body body,
        StringBuffer buffer
    ) {
        _makeFootnote(body, buffer);
        Footer footer = head.getFooter();
        if (footer != null) {
            buffer.append("<div class=\"footer\">");
            _makeText(footer, buffer);
            buffer.append("</div>\n");
        }
        buffer.append("</body>\n");
    }

    protected void _makePageHeader(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        Header header = head.getHeader();
        if (header != null) {
            buffer.append("<div class=\"header\">");
            _makeText(header, buffer);
            buffer.append("</div>\n");
        }
    }

    protected void _makePageFooter(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        // do nothing. see _makeBodyEpilogue
    }

    protected void _makeArticlePrologue(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        Prologue prologue = head.getPrologue();
        if (prologue != null) {
            buffer.append("<div class=\"prologue\">");
            _makeText(prologue, buffer);
            buffer.append("</div>\n");
        }
    }

    protected void _makeTOC(Container container, StringBuffer buffer) {
        buffer.append("<h2>");
        buffer.append(_makeTitleString(
            model_.getLabel("table of contents", container)));
        buffer.append("</h2>\n");
        buffer.append("\n");
            buffer.append("<div class=\"toc\">\n");
        _makeTOCNodes(
            container,
            html4Config_.isNumberedTitle(),
            html4Config_.isXhtml(),
            buffer
        );
        buffer.append("</div>\n");
    }

    protected void _makeTitleTOC(Container container, StringBuffer buffer) {
        TOCNode node = container.getTOCTree();
        if (node.getChildCount() > 0) {
            buffer.append("<div class=\"titletoc\">\n");
            _makeTOCNodes(
                container,
                html4Config_.isNumberedTitle(),
                html4Config_.isXhtml(),
                buffer
            );
            buffer.append("</div>\n");
        }
    }

    protected void _makeBibliographyPrologue(
        Bibliography bib,
        StringBuffer buffer
    ) {
        String head = _getBiliographyHeadTag(bib);
        buffer.append("\n");
        buffer.append("<");
        buffer.append(head);
        buffer.append(" id=\"");
        buffer.append(_getID(bib));
        buffer.append("\" class=\"bibliography\">");
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

    protected void _makeBibliographyEpilogue(
        Bibliography bib,
        StringBuffer buffer
    ) {
        buffer.append("</table>\n");
    }

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
        if (html4Config_.isNNLink()) {
            buffer.append("<td valign=\"top\">");
            buffer.append("<a name=\"");
            buffer.append(id);
            buffer.append("\">");
        } else {
            buffer.append("<td id=\"");
            buffer.append(id);
            buffer.append("\" valign=\"top\">");
        }
        buffer.append("[");
        buffer.append(UDoc.getSequenceNumberBasedSubSubSection(book));
        buffer.append("]");
        if (html4Config_.isNNLink()) {
            buffer.append("</a>");
        }
        buffer.append("</td>");
        buffer.append("<td");
        if(locale != null) {
            buffer.append(" lang=\"");
            buffer.append(locale.toString());
            buffer.append("\"");
        }
        buffer.append(">");
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
        String uri = article.getUri();
        buffer.append("<tr>");
        if (html4Config_.isNNLink()) {
            buffer.append("<td valign=\"top\">");
            buffer.append("<a name=\"");
            buffer.append(id);
            buffer.append("\">");
        } else {
            buffer.append("<td id=\"");
            buffer.append(id);
            buffer.append("\" valign=\"top\">");
        }
        buffer.append("[");
        buffer.append(UDoc.getSequenceNumberBasedSubSubSection(article));
        buffer.append("]");
        if (html4Config_.isNNLink()) {
            buffer.append("</a>");
        }
        buffer.append("</td>");
        buffer.append("<td");
        if(locale != null) {
            buffer.append(" lang=\"");
            buffer.append(locale.toString());
            buffer.append("\"");
        }
        buffer.append(">");
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
            buffer.append(". ");
        }
        if (publisher != null) {
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
        if (html4Config_.isNNLink()) {
            buffer.append("<td valign=\"top\">");
            buffer.append("<a name=\"");
            buffer.append(id);
            buffer.append("\">");
        } else {
            buffer.append("<td id=\"");
            buffer.append(id);
            buffer.append("\" valign=\"top\">");
        }
        buffer.append("[");
        buffer.append(UDoc.getSequenceNumberBasedSubSubSection(journal));
        buffer.append("]");
        if (html4Config_.isNNLink()) {
            buffer.append("</a>");
        }
        buffer.append("</td>");
        buffer.append("<td");
        if(locale != null) {
            buffer.append(" lang=\"");
            buffer.append(locale.toString());
            buffer.append("\"");
        }
        buffer.append(">");
        if (uri != null) {
            buffer.append("<a href=\"");
            buffer.append(uri);
            buffer.append("\">");
        }
        if (title != null) {
            buffer.append("<em>");
            buffer.append(_escape(title));
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
        if (html4Config_.isNNLink()) {
            buffer.append("<td valign=\"top\">");
            buffer.append("<a name=\"");
            buffer.append(id);
            buffer.append("\">");
        } else {
            buffer.append("<td id=\"");
            buffer.append(id);
            buffer.append("\" valign=\"top\">");
        }
        buffer.append("[");
        buffer.append(UDoc.getSequenceNumberBasedSubSubSection(misc));
        buffer.append("]");
        if (html4Config_.isNNLink()) {
            buffer.append("</a>");
        }
        buffer.append("</td>");
        buffer.append("<td");
        if(locale != null) {
            buffer.append(" lang=\"");
            buffer.append(locale.toString());
            buffer.append("\"");
        }
        buffer.append(">");
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
            buffer.append(_escape(title));
            if (subtitle != null) {
                buffer.append(" : ");
                buffer.append(_escape(subtitle));
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
            buffer.append(" ");
        }
        if (year != null) {
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

    protected void _makeIndex(
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
        buffer.append("<tbody>\n");
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
        buffer.append("</tbody>\n");
        buffer.append("</table>\n");
    }

    private String _getIndexPointer(Content content) {
        String pointer = UDoc.getParentTitledBlockNo(content);
        if (pointer != null) {
            return (pointer);
        } else {
            return ("*");
        }
    }

    protected void _makeIndex0(        // XXX : extension point
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
        buffer.append("<tbody>\n");
        for (int i = 0;i < words.length;i++) {
            String word = words[i];
            Anchor anchor;
            buffer.append("<tr>");
            buffer.append("<td><b>");
            buffer.append(word);
            buffer.append("</b></td>");
            buffer.append("<td>");
            if ((anchor = indexdef.getDefAnchor(word)) != null) {
                _embedRefTagPrologue(
                    getLogicalFile(anchor) + "#" + _getID(anchor),
                    buffer
                );
                buffer.append("<nobr><b>");
                buffer.append(model_.getLabel("def", head));
                buffer.append("</b></nobr>");
                _embedRefTagEpilogue(buffer);
            }
            buffer.append("</td>");
            Anchor[] anchors = indexdef.getRefAnchors(word);
            buffer.append("<td>");
            for (int j = 0;j < anchors.length;j++) {
                buffer.append(" ");
                _embedRefTagPrologue("#" + _getID(anchors[j]), buffer);
                buffer.append(model_.getLabel("ref", head));
                _embedRefTagEpilogue(buffer);
            }
            buffer.append("</td>");
            buffer.append("</tr>\n");
        }
        buffer.append("</tbody>\n");
        buffer.append("</table>\n");
    }

    // XXX : use div to specify part area?
    protected void _makePartPrologue(Part part, StringBuffer buffer) {
        _makeFootnote(part, buffer);
        buffer.append("\n");
        if (html4Config_.isNNLink()) {
            buffer.append("<h1 class=\"part\">");
            buffer.append("<a name=\"");
            buffer.append(_getID(part));
            buffer.append("\">");
        } else {
            buffer.append("<h1 class=\"part\" id=\"");
            buffer.append(_getID(part));
            buffer.append("\">");
        }
        if (html4Config_.isNumberedTitle()) {
            String number = UDoc.getTitleNo(part, ".");
            if (number != null) {
                buffer.append(number);
                buffer.append("  ");
            }
        }
        Title title = part.getTitleNode();
        if (title != null) {
            _makeString(title, buffer);
        }
        if (html4Config_.isNNLink()) {
            buffer.append("</a>");
        }
        buffer.append("</h1>\n");
        buffer.append("\n");
    }

    protected void _makePartEpilogue(
        Part part,
        StringBuffer buffer
    ) {
        _makeFootnote(part, buffer);
    }

    protected void _makeChapterPrologue(
        Chapter chapter,
        StringBuffer buffer
    ) {
        _makeFootnote(chapter, buffer);
        buffer.append("\n");
        if (html4Config_.isNNLink()) {
            buffer.append("<h1 class=\"chapter\">");
            buffer.append("<a name=\"");
            buffer.append(_getID(chapter));
            buffer.append("\">");
        } else {
            buffer.append("<h1 class=\"chapter\" id=\"");
            buffer.append(_getID(chapter));
            buffer.append("\">");
        }
        if (html4Config_.isNumberedTitle()) {
            buffer.append(UDoc.getTitleNo(chapter, "."));
            buffer.append("  ");
        }
        Title title = chapter.getTitleNode();
        if (title != null) {
            _makeString(title, buffer);
        }
        if (html4Config_.isNNLink()) {
            buffer.append("</a>");
        }
        buffer.append("</h1>\n");
        buffer.append("\n");
    }

    protected void _makeChapterEpilogue(
        Chapter chapter,
        StringBuffer buffer
    ) {
        _makeFootnote(chapter, buffer);
    }

    protected void _makeSectionPrologue(
        Section section,
        StringBuffer buffer
    ) {
        _makeFootnote(section, buffer);
        buffer.append("\n");
        if (html4Config_.isNNLink()) {
            buffer.append("<h2>");
            buffer.append("<a name=\"");
            buffer.append(_getID(section));
            buffer.append("\">");
        } else {
            buffer.append("<h2 id=\"");
            buffer.append(_getID(section));
            buffer.append("\">");
        }
        if (html4Config_.isNumberedTitle()) {
            buffer.append(UDoc.getTitleNo(section, "."));
            buffer.append("  ");
        }
        Title title = section.getTitleNode();
        if (title != null) {
            _makeString(section.getTitleNode(), buffer);
        }
        if (html4Config_.isNNLink()) {
            buffer.append("</a>");
        }
        buffer.append("</h2>\n");
        buffer.append("\n");
    }

    protected void _makeSectionEpilogue(
        Section section,
        StringBuffer buffer
    ) {
        _makeFootnote(section, buffer);
    }
    
    protected void _makeSubSectionPrologue(
        SubSection subsection,
        StringBuffer buffer
    ) {
        _makeFootnote(subsection, buffer);
        buffer.append("\n");
        if (html4Config_.isNNLink()) {
            buffer.append("<h3>");
            buffer.append("<a name=\"");
            buffer.append(_getID(subsection));
            buffer.append("\">");
        } else {
            buffer.append("<h3 id=\"");
            buffer.append(_getID(subsection));
            buffer.append("\">");
        }
        if (html4Config_.isNumberedTitle()) {
            buffer.append(UDoc.getTitleNo(subsection, "."));
            buffer.append("  ");
        }
        Title title = subsection.getTitleNode();
        if (title != null) {
            _makeString(title, buffer);
        }
        if (html4Config_.isNNLink()) {
            buffer.append("</a>");
        }
        buffer.append("</h3>\n");
        buffer.append("\n");
    }

    protected void _makeSubSectionEpilogue(
        SubSection subsection,
        StringBuffer buffer
    ) {
        _makeFootnote(subsection, buffer);
    }

    protected void _makeSubSubSectionPrologue(
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
        _makeFootnote(subsubsection, buffer);
        buffer.append("\n");
        if (html4Config_.isNNLink()) {
            buffer.append("<h4>");
            buffer.append("<a name=\"");
            buffer.append(_getID(subsubsection));
            buffer.append("\">");
        } else {
            buffer.append("<h4 id=\"");
            buffer.append(_getID(subsubsection));
            buffer.append("\">");
        }
        if (html4Config_.isNumberedTitle()) {
            buffer.append(UDoc.getTitleNo(subsubsection, "."));
            buffer.append("  ");
        }
        Title title = subsubsection.getTitleNode();
        if (title != null) {
            _makeString(title, buffer);
        }
        if (html4Config_.isNNLink()) {
            buffer.append("</a>");
        }
        buffer.append("</h4>\n");
        buffer.append("\n");
    }

    protected void _makeSubSubSectionEpilogue(
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
        _makeFootnote(subsubsection, buffer);
    }

    protected void _makeAppendix(
        Appendix appendix,
        StringBuffer buffer
    ) {
        buffer.append("<hr");
        if (html4Config_.isXhtml()) {
            buffer.append(" />");
        } else {
            buffer.append(">");
        }
        buffer.append("\n");
/*
        Title title = appendix.getTitleNode();
        buffer.append("\n");
        buffer.append("<h4 id=\"");
        buffer.append(_getID(appendix));
        buffer.append("\">");
        if (title != null) {
            _makeString(title, buffer);
        } else {
            buffer.append("Appendix");
        }
        buffer.append("</h4>\n");
        buffer.append("\n");
*/
        _makeText(appendix, buffer);
    }

    protected void _makeFYI(
        FYI fyi,
        StringBuffer buffer
    ) {
        String clazz = fyi.getClazz();
        Title title = fyi.getTitleNode();
        if (clazz == null) {
            fyi.setClazz("fyi");        // XXX
        }
        _embedTagPrologue("div", fyi, buffer);
        buffer.append("\n");
        buffer.append("<div class=\"title\">");
        if (title != null) {
            _makeString(title, buffer);
        }
        buffer.append("</div>\n");
        buffer.append("\n");
        _makeText(fyi, buffer);
        buffer.append("</div>\n");
        buffer.append("\n");
        fyi.setClazz(clazz);
    }

    protected void _makeUl(Ul ul, StringBuffer buffer) {
        buffer.append("\n");
        _embedTagPrologue("ul", ul, buffer);
        buffer.append("\n");
        _makeString(ul, buffer);
        buffer.append("</ul>\n");
        buffer.append("\n");
    }

    protected void _makeOl(Ol ol, StringBuffer buffer) {
        buffer.append("\n");
        _embedTagPrologue("ol", ol, buffer);
        buffer.append("\n");
        _makeString(ol, buffer);
        buffer.append("</ol>\n");
        buffer.append("\n");
    }

    protected void _makeLi(Li li, StringBuffer buffer) {
        _embedTagPrologue("li", li, buffer);
        buffer.append(" ");
        _makeString(li, buffer);
        if (html4Config_.isXhtml()) {
            buffer.append("</li>");
        }
        buffer.append("\n");
    }

    protected void _makeDl(Dl dl, StringBuffer buffer) {
        buffer.append("\n");
        _embedTagPrologue("dl", dl, buffer);
        buffer.append("\n");
        _makeString(dl, buffer);
        buffer.append("</dl>\n");
        buffer.append("\n");
    }

    protected void _makeDt(Dt dt, StringBuffer buffer) {
        _embedTagPrologue("dt", dt, buffer);
        _makeString(dt, buffer);
        if (html4Config_.isXhtml()) {
            buffer.append("</dt>");
        }
        buffer.append("\n");
    }

    protected void _makeDd(Dd dd, StringBuffer buffer) {
        _embedTagPrologue("dd", dd, buffer);
        _makeString(dd, buffer);
        if (html4Config_.isXhtml()) {
            buffer.append("</dd>");
        }
        buffer.append("\n");
    }

    protected void _makeTable(Table table, StringBuffer buffer) {
        Title caption = _getNumberedTitle(table);
        String clazz = table.getClazz();
        if (clazz == null) {
            clazz = "data";
        }
        CSSStyle style = table.getStyle();
        String styleText;
        if (style != null) {
            styleText = style.getText();
        } else {
            styleText = null;
        }
        String id = _getID(table);
        String lang = table.getExplicitLanguage();
        Locale locale = table.getExplicitLocale();

        Tnote tnote = table.getTnote();
        buffer.append("\n");
        buffer.append("<div>");
//        _embedTagPrologue("div", table, buffer);
        _embedAttrAppend("class", "table", buffer); // XXX
        buffer.append("\n");
        // introductory notes
        if (tnote != null) {
            buffer.append("<table>\n");
            buffer.append("<tr>\n");
            buffer.append("<td>\n");
        }
        // table definition
        if (tnote != null) {
            if (styleText != null) {
                styleText = "margin-bottom:0";
            } else {
                styleText = styleText + ";margin-bottom:0";
            }
        }
        if (html4Config_.isNNLink()) {
            buffer.append("<a name=\"");
            buffer.append(id);
            buffer.append("\">");
            buffer.append("</a>");
        }
        buffer.append("<table");
        if (!html4Config_.isNNLink()) {
            _embedAttr("id", id, buffer);
        }
        _embedAttr("class", clazz, buffer);
        if (styleText != null) {
            _embedAttr("style", styleText, buffer);
        }
        if (lang != null) {
            _embedAttr("lang", UHTML4.getHTML4Lang(lang), buffer); // XXX
        } else {
            if (locale != null) {
                _embedAttr(
                    "lang",
                    UHTML4.getHTML4Lang(locale.toString()), // XXX
                    buffer
                );
            }
        }
        if (!clazz.equals("menu")) { // XXX : generic
            String tableAttrs = html4Config_.getTableAttrs();
            if (tableAttrs != null) {
                buffer.append(" ");
                buffer.append(tableAttrs);
            }
//            _embedAttr("rules", "groups", buffer);
        }
        buffer.append(">\n");
        // meta info
        if (caption != null) {
            buffer.append("<caption>");
            _makeString(caption, buffer);
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
        _embedTagEpilogue("div", buffer);
        buffer.append("\n");
        buffer.append("\n");
    }

    protected void _makeLTableContents(Table table, StringBuffer buffer) {
        Colgroup[] colgroups = table.getColgroups();
        for (int i = 0;i < colgroups.length;i++) {
            Colgroup colgroup = colgroups[i];
            Col[] cols = colgroup.getCols();
            String align = colgroup.getAlign();
            CSSLength width = colgroup.getWidth();
            buffer.append("<colgroup span=\"");
            buffer.append(cols.length);
            buffer.append("\"");
            if (align != null) {
                buffer.append(" align=\"");
                buffer.append(align);
                buffer.append("\"");
            }
            if (width != null) {
                buffer.append(" width=\"");
                buffer.append(width.getValueAsPixel());
                buffer.append("\"");
            }
            buffer.append(">\n");
            for (int j = 0;j < cols.length;j++) {
                buffer.append("<col");
                Col col = cols[j];
                String calign = col.getAlign();
                CSSLength cwidth = col.getWidth();
                if (calign != null) {
                    buffer.append(" align=\"");
                    buffer.append(calign);
                    buffer.append("\"");
                }
                if (cwidth != null) {
                    buffer.append(" width=\"");
//                    buffer.append(cwidth.getValueAsPixel());
                    buffer.append(cwidth.getString());
                    buffer.append("\"");
                }
                if (html4Config_.isXhtml()) {
                    buffer.append(" />\n");
                } else {
                    buffer.append(">\n");
                }
            }
            buffer.append("</colgroup>\n");
        }
        //
        if (table.getTHead() != null) {
            _makeTHead(table, buffer);
        }
        if (table.getTFoot() != null) {
            _makeTFoot(table, buffer);
        }
        if (table.getTBody() != null) {
            _makeTBody(table, buffer);
        }
    }

    protected void _makePTableContents(PTable table, StringBuffer buffer) {
        if (table.getHeadHeight() > 0) {
            _makeTHead(table, buffer);
        }
        if (table.getFootHeight() > 0) {
            _makeTHead(table, buffer);
        }
        _makeTBody(table, buffer);
    }

    protected void _makeTHead(Table table, StringBuffer buffer) {
        D2Array data = table.getHeadData();
        buffer.append("<thead>\n");
        if (data != null) {
            _embedTableData(data, null, buffer);
        }
        buffer.append("</thead>\n");
    }

    protected void _makeTHead(PTable table, StringBuffer buffer) {
        buffer.append("<thead>\n");
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
                if (th != null) {
                    _makeString(th, buffer);
                }
                buffer.append("</th>\n");
            }
            buffer.append("</tr>\n");
        }
        buffer.append("</thead>\n");
    }

    protected void _makeTFoot(Table table, StringBuffer buffer) {
        D2Array data = table.getFootData();
        buffer.append("<tfoot>\n");
        if (data != null) {
            _embedTableData(data, null, buffer);
        }
        buffer.append("</tfoot>\n");
    }

    protected void _makeTFoot(PTable table, StringBuffer buffer) {
    }

    protected void _makeTBody(Table table, StringBuffer buffer) {
        D2Array data = table.getBodyData();
        buffer.append("<tbody>\n");
        if (data != null) {
            _embedTableData(data, table, buffer);
        }
        buffer.append("</tbody>\n");
    }

    protected void _makeTBody(PTable table, StringBuffer buffer) {
        buffer.append("<tbody>\n");
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
        buffer.append("</tbody>\n");
    }

    protected void _makeTr() {        // XXX : make for common function
        throw (new UnsupportedOperationException());
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

    protected void _makeImg(Img img, StringBuffer buffer) {
        String url = img.getSrc();
        String caption = img.getTitle();
        _embedAnchorPrologue(img, buffer);
        _embedTagPrologue("img", img, buffer);
        _embedAttrAppend("src", url, buffer);
        if (caption != null) {
            _embedAttrAppend("alt", caption, buffer);
        }
        if (html4Config_.isXhtml()) {
            _embedXhtmlTagCloseAppend(buffer);
        }
        _embedAnchorEpilogue(img, buffer);
    }

    protected void _makeImage(ImageFigure image, StringBuffer buffer) {
        String clazz = image.getClazz();
        if (clazz == null) {
            image.setClazz("figure");        // XXX
        }
        String url = image.getSrc();
        Title caption = _getNumberedTitle(image);
        CSSStyle style = image.getStyle();
        buffer.append("\n");
        buffer.append("<div");
        buffer.append(" class=\"");
        buffer.append(image.getClazz());
        buffer.append("\"");
        buffer.append(">");
        buffer.append("\n");
        _embedAnchorPrologue(image, buffer);
        if ("top".equals(html4Config_.getFigureTitle())) {
            if (caption != null) {
                buffer.append("<div class=\"caption\">");
                _makeString(caption, buffer);
                buffer.append("</div>\n");
            }
        }
        _embedTagPrologue("img", image, buffer);
        _embedAttrAppend("src", url, buffer);
        if (caption != null) {
            _embedAttrAppend("alt", caption.getText(), buffer);
        }
        if (style != null) {
            CSSLength width = style.getWidth();
            if (width != null) {
                _embedAttrAppend("width", width.getString(), buffer);
            }
            CSSLength height = style.getHeight();
            if (height != null) {
                _embedAttrAppend("height", height.getString(), buffer);
            }
        }
        if (html4Config_.isXhtml()) {
            _embedXhtmlTagCloseAppend(buffer);
        }
        if ("bottom".equals(html4Config_.getFigureTitle())) {
            if (caption != null) {
                buffer.append("<div class=\"caption\">");
                _makeString(caption, buffer);
                buffer.append("</div>\n");
            }
        }
        _embedAnchorEpilogue(image, buffer);
        buffer.append("\n");
        _embedTagEpilogue("div", buffer);
        buffer.append("\n");
        buffer.append("\n");
        image.setClazz(clazz);
    }

    protected void _makeSpan(Span span, StringBuffer buffer) {
        String clazz = span.getClazz();
        if (clazz != null && clazz.equals("kbd")) { // XXX : should provide kbd
            _embedTagPrologue("kbd", span, buffer);
            _makeString(span, buffer);
            _embedTagEpilogue("kbd", buffer);
            return;
        }
        _embedAnchorPrologue(span, buffer);
        _embedTagPrologue("span", span, buffer);
        _makeString(span, buffer);
        String ruby = span.getRuby();
        if (ruby != null) {
            buffer.append("<sup>(");
            buffer.append(ruby);
            buffer.append(")</sup>");
        }
        _embedTagEpilogue("span", buffer);
        _embedAnchorEpilogue(span, buffer);
    }

    protected void _makeTerm(Term term, StringBuffer buffer) {
        _makeString(term, buffer); // XXX
    }

    protected void _makeIndex(Index index, StringBuffer buffer) {
        buffer.append("<a name=\"");
        buffer.append(_getID(index));
        buffer.append("\">");
        _makeString(index, buffer);
        buffer.append("</a>");
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
        _makeInlineTag("tt", tt, buffer); // model logic for non-block container
    }

    protected void _makeEm(Em em, StringBuffer buffer) {
        _makeInlineTag("em", em, buffer); // model logic for non-block container
    }

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

    protected void _makeCode(Code code, StringBuffer buffer) {
        _makeInlineTag("code", code, buffer); // model logic for non-block container
    }

    protected void _makeBlockquote(
        Blockquote blockquote,
        StringBuffer buffer
    ) {
        _makeBlockTag("blockquote", blockquote, buffer);
    }

    protected void _makeQuote(Quote quote, StringBuffer buffer) {
        _makeInlineTag("q", quote, buffer);
    }

    protected void _makeAnchor(Anchor anchor, StringBuffer buffer) {
        buffer.append("<a name=\"");
        buffer.append(_getID(anchor));
        buffer.append("\">");
        buffer.append(anchor.getText());
        buffer.append("</a>");
    }

    protected void _makePre(Pre pre, StringBuffer buffer) {
        String caption = pre.getTitle();
        String id = _getID(pre);
        String src = pre.getSrc();
        buffer.append("\n");
        _embedTagPrologue("pre", pre, buffer);
        if (src != null) {
            _embedAttrAppend("src", src, buffer); // XXX
        }
        _makeText(pre, buffer);
        buffer.append("</pre>\n");
        buffer.append("\n");
    }

    protected void _makeProgram(Program program, StringBuffer buffer) {
        Title caption = _getNumberedTitle(program);
        String id = _getID(program);
        String clazz = program.getClazz();
        if (clazz == null) {
            clazz = "program";
        }
        CSSStyle style = program.getStyle();
        buffer.append("\n");
        if (html4Config_.isNNLink()) {
            buffer.append("<a name=\"");
            buffer.append(id);
            buffer.append("\">");
            buffer.append("</a>\n");
        }
        if (caption != null) {
            String styleText;
            if (style != null) {
                styleText = style.getText();
            } else {
                styleText = "margin-top:0";
            }
            buffer.append("<div");
            if (!html4Config_.isNNLink()) {
                buffer.append(" id=\"");
                buffer.append(id);
                buffer.append("\"");
            }
            buffer.append(" class=\"caption\">");
            _makeString(caption, buffer);
            buffer.append("</div>\n");
            buffer.append("<pre");
            _embedAttr("class", clazz, buffer);
            _embedAttr("style", styleText, buffer);
            buffer.append(">\n");
            _makeText(program, buffer);
            buffer.append("</pre>\n");
        } else {
            buffer.append("<pre");
            if (!html4Config_.isNNLink()) {
                buffer.append(" id=\"");
                buffer.append(id);
                buffer.append("\"");
            }
            _embedAttr("class", clazz, buffer);
            if (style != null) {
                _embedAttr("style", style.getText(), buffer);
            }
            buffer.append(">\n");
            _makeText(program, buffer);
            buffer.append("</pre>\n");
        }
        buffer.append("\n");
    }

    protected void _makeConsole(Console console, StringBuffer buffer) {
        Title caption = _getNumberedTitle(console);
        String id = _getID(console);
        String clazz = console.getClazz();
        if (clazz == null) {
            clazz = "console";
        }
        CSSStyle style = console.getStyle();
        if (html4Config_.isNNLink()) {
            buffer.append("<a name=\"");
            buffer.append(id);
            buffer.append("\">");
            buffer.append("</a>\n");
        }
        buffer.append("\n");
        if (caption != null) {
            String styleText;
            if (style != null) {
                styleText = style.getText();
            } else {
                styleText = "margin-top:0";
            }
            buffer.append("<div");
            if (!html4Config_.isNNLink()) {
                buffer.append(" id=\"");
                buffer.append(id);
                buffer.append("\"");
            }
            buffer.append(" class=\"caption\">");
            _makeString(caption, buffer);
            buffer.append("</div>\n");
            buffer.append("<pre");
            _embedAttr("class", clazz, buffer);
            _embedAttr("style", styleText, buffer);
            buffer.append(">\n");
            _makeText(console, buffer);
            buffer.append("</pre>\n");
        } else {
            buffer.append("<pre");
            if (!html4Config_.isNNLink()) {
                buffer.append(" id=\"");
                buffer.append(id);
                buffer.append("\"");
            }
            _embedAttr("class", clazz, buffer);
            if (style != null) {
                _embedAttr("style", style.getText(), buffer);
            }
            buffer.append(">\n");
            _makeText(console, buffer);
            buffer.append("</pre>\n");
        }
        buffer.append("\n");
    }

    protected void _makeEquation(Equation equation, StringBuffer buffer) {
        String clazz = equation.getClazz();
        if (clazz == null) {
            equation.setClazz("equation");
        }
        buffer.append("\n");
        _embedTagPrologue("div", equation, buffer);
        buffer.append("<table>\n");
        buffer.append("<tr><td>");
        _makeText(equation, buffer);
        buffer.append("</td>\n");
        buffer.append("<td class=\"padding\"></td>\n");
        buffer.append("<td class=\"equationNumber\">\n");
        buffer.append("(");
        buffer.append(UDoc.getSequenceNumberLabel(equation));
        buffer.append(")");
        buffer.append("</td></tr>\n");
        buffer.append("</table>\n");
        _embedTagEpilogue("div", buffer);
        buffer.append("\n");
    }

    protected void _makeDiv(Div div, StringBuffer buffer) {
        Title caption = _getNumberedTitle(div);
        String id = _getID(div);
        String clazz = div.getClazz();
        CSSStyle style = div.getStyle();
        buffer.append("\n");
        if (caption != null) {
            String styleText;
            if (style != null) {
                styleText = style.getText();
            } else {
                styleText = "margin-top:0";
            }
            buffer.append("<div");
            buffer.append(" id=\"");
            buffer.append(id);
            buffer.append("\" class=\"caption\">");
            _makeString(caption, buffer);
            buffer.append("</div>\n");
        }
        _embedTagPrologue("div", div, buffer);
        _makeText(div, buffer);
        _embedTagEpilogue("div", buffer);
        buffer.append("\n");
    }

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
                    String srcFile = getLogicalFile(ref); // 1385
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
                            if (html4Config_.isRefTitle()) {
                                String title = link.getTitle();
                                if (title != null) {
                                    buffer.append("[");
                                    _makeString(link.getTitleNode(), buffer);
                                    buffer.append("]");
                                }
                            }
                        } else {
                            monitor_.warning("no link : " + href);
//                    label = "*unresolved*";
                        }
                    }
                    _embedRefTagEpilogue(buffer);
                    return;
                } else if (link instanceof ImageFigure) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("figure", ref),
                        ref
                    );
                } else if (link instanceof Table) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("table", ref),
                        ref
                    );
                } else if (link instanceof Console) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("figure", ref),
                        ref
                    );
                } else if (link instanceof Program) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("list", ref),
                        ref
                    );
                } else if (link instanceof Part) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("part", ref),
                        ref
                    );
                } else if (link instanceof Chapter) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("chapter", ref),
                        ref
                    );
                } else if (link instanceof Section) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("section", ref),
                        ref
                    );
                } else if (link instanceof SubSection) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("section", ref),
                        ref
                    );
                } else if (link instanceof SubSubSection) {
                    label = UDoc.adjustStringInContext(
                        model_.getLabel("section", ref),
                        ref
                    );
                } else if (link instanceof Equation) {
                    String[] parts = model_.getLabelParts("equation", ref);
                    label = UDoc.makePrefixSuffixLabel(link, parts);
                } else if (link instanceof Bibitem) {
                    // XXX : correct control flow
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
                        String title = null;
                        if (link instanceof Book) {
                            title = ((Book)link).getTitle();
                        } else if (link instanceof Article) {
                            title = ((Article)link).getTitle();
                        }
                        if (title != null) {
                            _embedAttrAppend("title", title, buffer);
                        }
                        String number = UDoc.getSequenceNumberLabel(link);
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
//                    String number = UDoc.getSequenceNumber(link);
                    String number = UDoc.getSequenceNumberLabel(link);
                    if (number != null) {
                        if (USmartDoc.isWordSeparate(label, number)) {
                            buffer.append(" ");
                        }
                        buffer.append(number);
                    }
                    if (html4Config_.isRefTitle()) {
                        String title = link.getTitle();
                        if (title != null) {
                            buffer.append("[");
                            _makeString(link.getTitleNode(), buffer);
                            buffer.append("]");
                        }
                    }
                } else {
                    monitor_.warning("no link : " + href);
//                    label = "*unresolved*";
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

    protected void _makeCite(Cite cite, StringBuffer buffer) {
        Content[] contents = cite.getContents();
        _makeBibLink(cite, buffer);
    }

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

    protected void _makeComment(Comment comment, StringBuffer buffer) {
        buffer.append("<span class=\"comment\">");
        _makeString(comment, buffer);
        buffer.append("</span>");
    }

    protected void _makeNote(Note note, StringBuffer buffer) {
        int number = note.getNumber();
        buffer.append("<span class=\"note\">");
//        _embedRefTagPrologue("#note" + number, note, buffer);
        _embedRefTagPrologue("#" + _getID(note), buffer);
        _embedAttrAppend("title", note.getText(), buffer);
        buffer.append("<sup>(");
        buffer.append(number);
        buffer.append(")</sup>");
        _embedRefTagEpilogue(buffer);
        buffer.append("</span>");
        notes_.add(note);
    }

    protected void _makeFootnote(Container container, StringBuffer buffer) {
        int nNotes = notes_.size();
        if (nNotes == 0) {
            return;
        }
        buffer.append("\n");
        buffer.append("<div class=\"footnote\">\n");
        buffer.append("<ol>\n");
        for (int i = 0;i < nNotes;i++) {
            Note note = (Note)notes_.get(i);
            int number = note.getNumber();
//            buffer.append("<li id=\"note"); // XXX
//            buffer.append(number);
            buffer.append("<li id=\"");
            buffer.append(_getID(note));
            buffer.append("\" value=\"");
            buffer.append(number);
            buffer.append("\"> ");
            _makeText(note, buffer);
            if (html4Config_.isXhtml()) {
                buffer.append("</li>");
            }
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
        buffer.append("<div class=\"footnote\">\n");
        int nNotes = list.size();
        buffer.append("<ol>\n");
        for (int i = 0;i < nNotes;i++) {
            Note note = (Note)list.get(i);
            int number = note.getNumber();
            buffer.append("<li id=\"note"); // XXX
            buffer.append(number);
            buffer.append("\" value=\"");
            buffer.append(number);
            buffer.append("\"> ");
            _makeText(note, buffer);
        }
        buffer.append("</ol>\n");
        buffer.append("</div>\n");
        buffer.append("\n");
    }

    protected void _makeTime(TimeCommand time, StringBuffer buffer) {
        buffer.append(new Date().toString()); // XXX
    }

    protected void _makeExternalElement(
        ExternalElement external,
        StringBuffer buffer
    ) {
        Element element = external.getElement();
        String namespaceURI = element.getNamespaceURI();
        if (namespaceURI != null) {
            if ("http://www.w3.org/1998/Math/MathML".equals(namespaceURI)) {
                _makeMathMLElement(external, buffer);
            } else if ("http://www.w3.org/1999/xhtml".equals(namespaceURI)) {
                buffer.append(UXMLMaker.getXMLText(element));
            } else {
                super._makeExternalElement(external, buffer);
            }
        } else {
            super._makeExternalElement(external, buffer);
        }
    }

    private void _makeMathMLElement(
        ExternalElement external,
        StringBuffer buffer
    ) {
        Element element = external.getElement();
        if ("math".equals(element.getLocalName())) {
            buffer.append("<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n");
            _makeMathMLElementBody(element, buffer);
            buffer.append("</math>\n");
        } else {
            _makeMathMLElementBody(element, buffer);
        }
    }

    private void _makeMathMLElementBody(
        Element element,
        StringBuffer buffer
    ) {
        org.w3c.dom.NodeList children = element.getChildNodes();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            buffer.append(
                UXML.escapeAscii(
                    UXMLMaker.getXMLText(children.item(i))
                )
            );
        }
    }        

    protected void _makeSentence(Sentence sentence, StringBuffer buffer) {
        _makeText(sentence, buffer);
//        buffer.append("<br>\n"); // XXX : virtualy paragraph now
    }

    protected void _makeParagraph(Paragraph p, StringBuffer buffer) {
        if (UDoc.isFirstParagraph(p)) {
            String clazz = p.getClazz();
            if (clazz == null) {
                if (UDoc.isJaStyleFirstParagraph(p)) {
                    p.setClazz("first_ja");
                } else {
                    p.setClazz("first");
                }
            }
        } else {
            String clazz = p.getClazz();
            if (clazz == null) {
            }
        }
        _makeInlineBlockTag("p", p, buffer);
    }

    // AbstractXMLGeneratorBase
    protected String _escape(String string) {
        if (string == null) {
            return ("");
        }
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            switch (c) {

            case '<':
                buffer.append("&lt;");
                break;
            case '>':
                buffer.append("&gt;");
                break;
            case '&':
                buffer.append("&amp;");
                break;
            case '"':
                buffer.append("&quot;");
                break;
            default:
                String symbol = symbols_.getSymbol(c);
                if (symbol != null) {
                    buffer.append(symbol);
                } else {
                    buffer.append(c);
                }
            }
        }
        return (new String(buffer));
    }

    protected Title _getNumberedTitle(Content content) {
        Title title = content.getTitleNode();
        if (title == null) {
            return (null);
        }
        if (html4Config_.isNumberedTitle()) {
//            String number = UDoc.getSequenceNumber(content); TODO _makeRef
            String number = UDoc.getSequenceNumberLabel(content);
            if (number == null) {
                return (title);
            } else {
                Title numberedTitle = new Title();
                String label = null;
                if (content instanceof ImageFigure) {
                    label = UDoc.makeTitleString(
                        model_.getLabel("figure", content)
                    );
                } else if (content instanceof Table) {
                    label = UDoc.makeTitleString(
                        model_.getLabel("table", content)
                    );
                } else if (content instanceof Console) {
                    label = UDoc.makeTitleString(
                        model_.getLabel("figure", content)
                    );
                } else if (content instanceof Program) {
                    label = UDoc.makeTitleString(
                        model_.getLabel("list", content)
                    );
                }
                if (label != null) {
                    numberedTitle.addContent(new CharBlock(label + " "));
                }
                numberedTitle.addContent(new CharBlock(number + " "));
                numberedTitle.addContents(title.getContents());
                return (numberedTitle);
            }
        } else {
            return (title);
        }
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

    // Unused?
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
        boolean isKbd = false;
        for (;i < lines.length;i++) {
            String line = lines[i];
            if (i == 0) {
                int index = line.indexOf(prompt);
                if (index != -1) {
                    buffer.append(line.substring(0, index + prompt.length()));
                    buffer.append("<kbd>");
                    String command = line.substring(index + prompt.length());
                    buffer.append(command);
                    //buffer.append("</kbd>");
                    isKbd = isContinueLine_(command);
                    buffer.append("\n");
                } else {
                    buffer.append(line);
                    buffer.append("\n");
                }
            } else {
                if (isKbd) {
                    buffer.append("<kbd>");                    
                }
                buffer.append(line);
                if (isKbd) {
                    buffer.append("</kbd>");                    
                    isKbd = isContinueLine_(line); 
                }
                buffer.append("\n");
            }
        }
        return (new String(buffer));
    }

    private boolean isContinueLine_(String line) {
        return line.charAt(line.length() - 1) == '\\';
    }

    // AbstractXMLGeneratorBase
    protected void _makeInlineTag(
        String tagname,
        Content content,
        StringBuffer buffer
    ) {
        if (isNNLink(content)) {
            buffer.append("<a name=\"");
            buffer.append(_getID(content));
            buffer.append("\">");
            buffer.append("</a>\n");
        }
        _embedTagPrologue(tagname, content, buffer);
        _makeString(content, buffer);
        _embedTagEpilogue(tagname, buffer);
        if (isNNLink(content)) {
            buffer.append("</a>");
        }
    }

    protected void _makeInlineBlockTag(
        String tagname,
        Content content,
        StringBuffer buffer
    ) {
        _embedAnchorPrologue(content, buffer);
        _embedTagPrologue(tagname, content, buffer);
        _makeString(content, buffer);
        _embedTagEpilogue(tagname, buffer);
        _embedAnchorEpilogue(content, buffer);
        buffer.append("\n");
    }

    protected void _makeBlockTag(
        String tagname,
        Content content,
        StringBuffer buffer
    ) {
        _embedEmptyAnchor(content, buffer);
        _embedTagPrologue(tagname, content, buffer);
        buffer.append("\n");
        _makeText(content, buffer);
        _embedTagEpilogue(tagname, buffer);
        buffer.append("\n");
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

        buffer.append("<");
        buffer.append(tagname);
        if (!html4Config_.isNNLink()) {
            if (content.hasReferer()) {
                _embedAttr("id", id, buffer);
            }
        }
        if (clazz != null) {
            _embedAttr("class", clazz, buffer);
        }
        if (style != null) {
            _embedAttr("style", style.getText(), buffer);
        }
        if (lang != null) {
            _embedAttr("lang", UHTML4.getHTML4Lang(lang), buffer);
        }
        buffer.append(">");
    }

    // AbstractXHTMLGeneratorBase
    protected void _embedRefTagPrologueExternalLinkAttributes(
        String href,
        StringBuffer buffer
    ) {
        if (!html4Config_.isStrictDTD()) {
            super._embedRefTagPrologueExternalLinkAttributes(href, buffer);
        }
    }

    private void _embedEmptyAnchor(Content content, StringBuffer buffer) {
        if (isNNLink(content)) {
            buffer.append("<a name=\"");
            buffer.append(_getID(content));
            buffer.append("\">");
            buffer.append("</a>\n");
        }
    }

    private void _embedAnchorPrologue(Content content, StringBuffer buffer) {
        if (isNNLink(content)) {
            buffer.append("<a name=\"");
            buffer.append(_getID(content));
            buffer.append("\">");
            buffer.append("</a>\n");
        }
    }

    private void _embedAnchorEpilogue(Content content, StringBuffer buffer) {
        if (isNNLink(content)) {
            buffer.append("</a>");
        }
    }

    private void _embedEmptyTagClose(StringBuffer buffer) {
        if (html4Config_.isXhtml()) {
            buffer.append(" />");
        } else {
            buffer.append(">");
        }
    }

    private void _embedEmptyTagCloseNL(StringBuffer buffer) {
        _embedEmptyTagClose(buffer);
        buffer.append("\n");
    }

    private boolean isNNLink(Content content) {
        return (html4Config_.isNNLink() && content.hasReferer());
    }
}
