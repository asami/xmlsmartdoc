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

package org.xmlsmartdoc.SmartDoc.latex2e;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.w3c.dom.Element;
import org.xmlsmartdoc.SmartDoc.Abbr;
import org.xmlsmartdoc.SmartDoc.AbstractStringBufferSmartDocGeneratorBase;
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
import org.xmlsmartdoc.SmartDoc.CSSColor;
import org.xmlsmartdoc.SmartDoc.CSSFont;
import org.xmlsmartdoc.SmartDoc.CSSLength;
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
import org.xmlsmartdoc.SmartDoc.ExternalElement;
import org.xmlsmartdoc.SmartDoc.FYI;
import org.xmlsmartdoc.SmartDoc.FloatingObject;
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
import org.xmlsmartdoc.SmartDoc.Paragraph;
import org.xmlsmartdoc.SmartDoc.Part;
import org.xmlsmartdoc.SmartDoc.Pre;
import org.xmlsmartdoc.SmartDoc.Program;
import org.xmlsmartdoc.SmartDoc.Quote;
import org.xmlsmartdoc.SmartDoc.Ref;
import org.xmlsmartdoc.SmartDoc.Section;
import org.xmlsmartdoc.SmartDoc.Sentence;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocContext;
import org.xmlsmartdoc.SmartDoc.SmartDocErrorException;
import org.xmlsmartdoc.SmartDoc.SmartDocFormatConfig;
import org.xmlsmartdoc.SmartDoc.Span;
import org.xmlsmartdoc.SmartDoc.Strong;
import org.xmlsmartdoc.SmartDoc.SubSection;
import org.xmlsmartdoc.SmartDoc.SubSubSection;
import org.xmlsmartdoc.SmartDoc.Summary;
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
import org.xmlsmartdoc.SmartDoc.mathml.LaTeXMaker;
import org.xmlsmartdoc.SmartDoc.mathml.rParts.MMath;
import org.xmlsmartdoc.SmartDoc.mathml.rParts.URVisitor;

import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.TextArtifact;
import com.AsamiOffice.jaba2.util.LocaleString;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.D2Array;
import com.AsamiOffice.util.ULocale;

/**
 * LaTeX2eGenerator
 *
 * @since   Oct. 18, 1998
 *  version Jun. 10, 2005
 * @version Jan. 19, 2012
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class LaTeX2eGenerator extends AbstractStringBufferSmartDocGeneratorBase {
    protected LaTeX2eConfig latex2eConfig_;
    protected String documentType_;
    protected LocaleString documentClass_;
    protected LocaleString classArticle_;
    protected LocaleString classReport_;
    protected LocaleString classBook_;
    protected String styleUrl_;
    protected String tocStyle_;
    protected LocaleString bibStyle_;
    protected LaTeX2eImageFloatHandler imageFloatHandler_;
    protected LaTeX2eImageHandler imageHandler_;
    protected LaTeX2eBoxHandler boxHandler_;
    protected LaTeX2eTableFloatHandler tableFloatHandler_;
    protected LaTeX2eTableHandler tableHandler_;
    protected LaTeX2eRefHandler refHandler_;
    protected LaTeX2eProgramHandler programHandler_;
    protected LaTeX2eConsoleHandler consoleHandler_;
    protected LaTeX2eRubyHandler rubyHandler_;
    protected int floatTableHeight_ = 26;
    protected transient boolean useColor_ = false;
    protected transient boolean useImage_ = false;
    protected transient boolean useBox_ = true; // XXX
    protected transient boolean useTable_ = false;
    protected transient boolean useLongTable_ = false;
    protected transient boolean useProgram_ = false;
    protected transient boolean useConsole_ = false;
    protected transient boolean usePart_ = false;
    protected transient boolean useChapter_ = false;
    protected transient boolean useRuby_ = false;
    protected transient boolean isTableMode_ = false;

    // AbstractGeneratorBase
    public void init(SmartDocConfig config, SmartDocFormatConfig fconfig) {
        super.init(config, fconfig);
        monitor_ = SmartDocContext.getContext().getMonitor();
        config_ = config;
        latex2eConfig_ = (LaTeX2eConfig)fconfig;
        documentType_ = latex2eConfig_.getDocumentType();
        if (documentType_ != null && documentType_.equals("")) {
            documentType_ = null;
        }
        documentClass_ = latex2eConfig_.getDocumentClass();
        classArticle_ = latex2eConfig_.getClassArticle();
        classReport_ = latex2eConfig_.getClassReport();
        classBook_ = latex2eConfig_.getClassBook();
        styleUrl_ = latex2eConfig_.getStyleUrl();
        tocStyle_ = latex2eConfig_.getTocStyle();
        bibStyle_ = latex2eConfig_.getBibStyle();
        imageFloatHandler_ = latex2eConfig_.getImageFloatHandler();
        imageHandler_ = latex2eConfig_.getImageHandler();
        imageHandler_.setup(latex2eConfig_);
        boxHandler_ = latex2eConfig_.getBoxHandler();
        tableFloatHandler_ = latex2eConfig_.getTableFloatHandler();
        tableHandler_ = latex2eConfig_.getTableHandler();
        refHandler_ = latex2eConfig_.getRefHandler();
        refHandler_.setup(latex2eConfig_);
        programHandler_ = latex2eConfig_.getProgramHandler();
        consoleHandler_ = latex2eConfig_.getConsoleHandler();
        rubyHandler_ = latex2eConfig_.getRubyHandler();
    }

    // SimpleGenerator
    public String getName() {
        return ("LaTeX2e");
    }

    // SimpleGenerator
    public String getSuffix() {
        return ("tex");
    }

    protected void _makePrologue(
        Head head,
        StringBuffer buffer
    ) {
        buffer.append("\\documentclass");
        String[] options = latex2eConfig_.getOptions();
        if (options != null) {
            if (options.length > 0) {
                buffer.append("[");
                buffer.append(options[0]);
                for (int i = 1;i < options.length;i++) {
                    buffer.append(",");
                    buffer.append(options[i]);
                }
                buffer.append("]");
            }
        }
        buffer.append("{");
        Locale locale = head.getLocale();
        if (locale == null) {
            String lang = head.getLanguage();
            if (lang != null) {
                locale = ULocale.makeLocale(lang);
                buffer.append(_getDocumentClass(locale));
            } else {
                buffer.append(_getDocumentClass());
            }
        } else {
            buffer.append(_getDocumentClass(locale));
        }
        buffer.append("}\n");
    }

    protected void _makeEpilogue(
        Head head,
        StringBuffer buffer
    ) {
        buffer.append("\n");
        buffer.append("\\end{document}\n");
    }

    protected void _makeHead(Head head, StringBuffer buffer) {
        Title title = head.getDocTitle();
        Title subTitle = head.getDocSubTitle();
//        String author = head.getAuthor();
        String org = head.getOrg();
        boolean preOrg = head.getPreOrg();
        String email = head.getEMail();
        String hp = head.getHP();
        DocDate date = head.getDate();
        Summary summary = head.getSummary();
        Native nativeValue = head.getNative();

        buffer.append("\n");
        buffer.append("\\usepackage{alltt}\n");        // XXX
        _addPackages(latex2eConfig_.getPackages(), buffer);
        if (config_.makeIndex()) {
            buffer.append("\\usepackage{makeidx}\n");
        }
        if (useColor_) {
            buffer.append("\\usepackage{color}\n");
        }
        if (useImage_) {
            _addPackages(imageFloatHandler_.getPackages(), buffer);
            _addPackages(imageHandler_.getPackages(), buffer);
        }
        if (useBox_) {
            _addPackages(boxHandler_.getPackages(), buffer);
        }
        if (useProgram_) {
            _addPackages(programHandler_.getPackages(), buffer);
        }
        if (useTable_) {
            _addPackages(tableFloatHandler_.getPackages(), buffer);
            _addPackages(tableHandler_.getPackages(), buffer);
            String preamble = tableHandler_.getPreamble();
            if (preamble != null) {
                buffer.append(preamble);
            }
            if ("tabularx".equals(latex2eConfig_.getTabularType())) {
                _addPackage("tabularx", buffer);
            }
        }
        if (useLongTable_) {
            _addPackage("longtable", buffer);
        }
        if (useRuby_) {
            _addPackages(rubyHandler_.getPackages(), buffer);
        }
        _addPackages(refHandler_.getPackages(), buffer);
/*
        buffer.append("\n");
        buffer.append("\\def\\VLINE{\\vrule width 1pt}\n");
        buffer.append("\\def\\HLINE{\\noalign{\\hrule height 1pt}}\n");
*/
        buffer.append("\n");
        buffer.append("\\newcounter{program}\n"); // XXX : waring
        buffer.append("\n");
        _makeMiniPageTableHead(buffer);
        if (title != null) {
            buffer.append("\\title{");
//            buffer.append(_escape(title.getText()));
            _makeString(title, buffer);
            if (subTitle != null) {
                buffer.append("\\\\ ");
                buffer.append(" {\\Large "); // XXX : customizable
                buffer.append(_escape(subTitle.getText()));
                buffer.append("}");
            }
            buffer.append("}\n");
        }
        if (date != null) {
            buffer.append("\\date{");
            buffer.append(_escape(date.getText()));
            buffer.append("}\n");
        } else {
            buffer.append("\\date{}\n");
        }
        _makeAuthors(head.getAuthors(), org, preOrg, email, hp, buffer);
        if (config_.makeIndex()) {
            buffer.append("\\makeindex\n");
        }
        if (nativeValue != null) {
            buffer.append(nativeValue.getText());
            buffer.append("\n");
        }
        if (styleUrl_ != null) {
            buffer.append("\\input{");
            buffer.append(styleUrl_);
            buffer.append("}\n");
        }
    }

    // by Takashi Hattori [sdocusersj 927]
    private void _makeMiniPageTableHead(StringBuffer buffer) {
        buffer.append("\\newlength{\\minipagetbllength}\n");
        buffer.append("\\newcounter{minipagetblcounter}\n");
        buffer.append("\\newcommand{\\minipagetblfootnote}[1]{\n");
        buffer.append("\\footnote{#1}\\addtocounter{minipagetblcounter}{-1}}\n");
        buffer.append("\\newcommand{\\minipagetbl}[1]{\n");
        buffer.append("\\settowidth{\\minipagetbllength}{#1}\n");
        buffer.append("\\setcounter{minipagetblcounter}{0}\n");
        buffer.append("\\begin{center}\\begin{minipage}{\\minipagetbllength}\n");
        buffer.append("\\renewcommand{\\footnoterule}{}\n");
        buffer.append("\\begin{center} #1 \\vspace{-.1in} \\end{center}\n");
        buffer.append("\\end{minipage} \\end{center}\n");
        buffer.append("\\addtocounter{footnote}{\\value{minipagetblcounter}}\n");
        buffer.append("}\n");
    }

    private void _makeAuthors(
        DocAuthor[] authors,
        String org,
        boolean preOrg,
        String email,
        String hp,
        StringBuffer buffer
    ) {
        if (authors == null) {
            return;
        }
        if (authors.length == 0) {
            return;
        }
        buffer.append("\\author{");
        _makeAuthor(authors[0], org, buffer);
        for (int i = 1;i < authors.length;i++) {
            buffer.append(" \\and ");
            _makeAuthor(authors[i], org, buffer);
        }
        if (preOrg) {
            if (org != null) {
                buffer.append("\\\\");
                buffer.append(_escape(org));
            }
        }
        if (email != null) {        // for compatibility
            buffer.append("\\\\");
            buffer.append(_escape(email));
        }
        if (hp != null) {        // for compatibility
            buffer.append("\\\\");
            buffer.append(refHandler_.getHyperLinkTitle(hp));
        }
        if (!preOrg) {
            if (org != null) {
                buffer.append("\\\\");
                buffer.append(_escape(org));
            }
        }
        buffer.append("}\n");
    }

    private void _makeAuthor(
        DocAuthor author,
        String org,
        StringBuffer buffer
    ) {
        String name = UDoc.distillText(author);
        String note = author.getNote();
        String email = author.getEMail();
        String hp = author.getHP();
        String aOrg = author.getOrg();
        if (aOrg != null) {
            org = aOrg;
        }
        buffer.append(_escape(name));
        if (org != null || note != null || email != null || hp != null) {
            buffer.append("\\footnote{");
            if (email != null) {
                buffer.append(_escape(email));
            }
            if (hp != null) {
                if (email != null) {
                    buffer.append(", ");
                }
                buffer.append(_escape(hp));
            }
            if (org != null) {
                if (email != null || hp != null) {
                    buffer.append(", ");
                }
                buffer.append(_escape(org));
            }
            if (note != null) {
                if (org != null || email != null || hp != null) {
                    buffer.append(", ");
                }
                buffer.append(_escape(note));
            }
            buffer.append("}");
        }
    }

    protected void _addPackage(String packageName, StringBuffer buffer) {
        buffer.append("\\usepackage{");
        buffer.append(packageName);
        buffer.append("}\n");
    }

    protected void _addPackages(String[] packages, StringBuffer buffer) {
        if (packages == null) {
            return;
        }
        int nPackages = packages.length;
        for (int i = 0;i < nPackages;i++) {
            _addPackage(packages[i], buffer);
        }
    }

    protected void _addPackages(
        LaTeX2ePackage[] packages,
        StringBuffer buffer
    ) {
        if (packages == null) {
            return;
        }
        int nPackages = packages.length;
        for (int i = 0;i < nPackages;i++) {
            LaTeX2ePackage lp = packages[i];
            buffer.append("\\usepackage");
            if (lp.options != null) {
                String[] options = lp.options;
                buffer.append("[");
                if (options.length > 0) {
                    buffer.append(options[0]);
                    for (int j = 1;j < options.length;j++) {
                        buffer.append(",");
                        buffer.append(options[j]);
                    }
                }
                buffer.append("]");
            }
            buffer.append("{");
            buffer.append(lp.name);
            buffer.append("}\n");
            if (lp.aux != null) {
              buffer.append(lp.aux);
            }
        }
    }

    protected void _makeBodyPrologue(
        Head head,
        Body body,
        StringBuffer buffer
    ) {
        buffer.append("\\begin{document}\n");
        buffer.append("\n");
        if (config_.makeToc() &&
            "long".equals(tocStyle_)) {

            buffer.append("\\pagestyle{empty}\n");
        } else {
            buffer.append("\\pagestyle{");
            buffer.append(latex2eConfig_.getPageStyle());
            buffer.append("}\n");
        }
    }

    protected void _makeTitle(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        Title docTitle = head.getDocTitle();
        if (docTitle == null) {
            return;
        }
        String title = docTitle.getText();
        String author = head.getAuthor();
        String email = head.getEMail();
        String hp = head.getHP();
        DocDate date = head.getDate();
        Summary summary = head.getSummary();
        buffer.append("\\maketitle\n");
        buffer.append("\n");
        if (summary != null) {
            buffer.append("\\begin{abstract}\n");
            _makeText(summary, buffer);
            buffer.append("\\end{abstract}\n");
        }
    }

    protected void _makeBodyEpilogue(
        Head head,
        Body body,
        StringBuffer buffer
    ) {
    }

    protected void _makePageHeader(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
/*
        Header header = head.getHeader();
        if (header != null) {
            buffer.append("{");
            _makeText(header, buffer);
            buffer.append("}\n\n");
        }
}/
    }

    protected void _makePageFooter(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
/*
        Footer footer = head.getFooter();
        if (footer != null) {
            buffer.append("{");
            _makeText(footer, buffer);
            buffer.append("}\n\n");
        }
*/
    }

    protected void _makeArticlePrologue(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
/*
        Prologue prologue = head.getPrologue();
        if (prologue != null) {
            buffer.append("{");
            _makeText(prologue, buffer);
            buffer.append("}\n\n");
        }
*/
    }

    protected void _makeIndex(
        Head head,
        Body body,
        Indexdef indexdef,
        StringBuffer buffer
    ) {
        if (config_.makeIndex()) {
            buffer.append("\n");
            buffer.append("\\printindex\n");
        }
    }

    protected void _makeBibliographyPrologue(
        Bibliography bib,
        StringBuffer buffer
    ) {
        if (bib != null) {
            Locale locale = bib.getLocale();
            if (locale == null) {
                String lang = bib.getLanguage();
                if (lang != null) {
                    locale = ULocale.makeLocale(lang);
                }
            }
            _embedNewline(buffer);
            buffer.append("\\bibliographystyle{");
            if (locale != null) {
                buffer.append(bibStyle_.get(locale));
            } else {
                buffer.append(bibStyle_.getDefault());
            }
            buffer.append("}\n");
            buffer.append("\\bibliography{");
            buffer.append(getLogicalFileBody(bib));
            buffer.append("}\n");
            _makeBibliography(bib);
        }
    }

    protected void _makeBibliographyEpilogue(
        Bibliography bib,
        StringBuffer buffer
    ) {
    }

    protected void _makeBibliography(Bibliography bib) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("@preamble{ \"\\newcommand{\\noopsort}[1]{} \"\n");
        buffer.append("        # \"\\newcommand{\\printfirst}[2]{#1} \"\n");
        buffer.append("        # \"\\newcommand{\\singleletter}[1]{#1} \"\n");
        buffer.append("        # \"\\newcommand{\\switchargs}[2]{#2#1} \" }\n");
        Content[] entries = bib.getContents();
        for (int i = 0;i < entries.length;i++) {
            Content item = entries[i];
            if (item instanceof Book) {
                _makeBookEntry((Book)item, buffer);
            } else if (item instanceof Article) {
                _makeArticleEntry((Article)item, buffer);
            } else if (item instanceof Journal) {
                _makeJournalEntry((Journal)item, buffer);
            } else if (item instanceof BibMisc) {
                _makeBibMiscEntry((BibMisc)item, buffer);
            } else {
                throw (new InternalError("bad item = " + item));
            }
        }
        String deploy = config_.getDeploy(); // XXX : DocContext
        GeneratorArtifact artifact = new TextArtifact(
            config_.getProject() + bib.getFileID(deploy) + ".bib",
            new String(buffer),
            formatConfig_.getEncoding((Doc)UDoc.getRoot(bib))
        );
        _addArtifact(artifact);
    }

    protected void _makeBookEntry(Book book, StringBuffer buffer) {
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
        buffer.append("\n");
        buffer.append("@BOOK{");
        buffer.append(id);
        buffer.append(",\n");
        if (editors != null) {
            buffer.append("  editor = \"");
            _makeEditorEntries(editors, buffer);
            buffer.append("\",\n");
        } else {
            buffer.append("  author = \"");
            _makeAuthorEntries(authors, buffer);
            buffer.append("\",\n");
        }
        buffer.append("  title = \"");
        buffer.append("{");
        buffer.append(_escape(title));
        if (subtitle != null) {
            buffer.append(" : ");
            buffer.append(_escape(subtitle));
        }
        buffer.append("}");
        buffer.append("\",\n");
        if (edition != null) {
            buffer.append("  edition = \"");
//            buffer.append(config_.getEditionLabel(edition, locale));
            buffer.append(edition);
            buffer.append("\",\n");
        }
        if (publisher != null) {
            buffer.append("  publisher = \"");
            buffer.append(_escape(publisher));
            buffer.append("\",\n");
        }
        buffer.append("  year = \"");
        buffer.append(year);
        buffer.append("\",\n");
        if (note == null && uri != null) {
            note = "{" + refHandler_.getHyperLinkTitle(uri) + "}";
//            note = uri;
        }
        if (note != null) {
            buffer.append("  note = \"");
            buffer.append(note);
            buffer.append("\",\n");
        }
        buffer.append("}\n");
    }

    protected void _makeArticleEntry(Article article, StringBuffer buffer) {
        Locale locale = UDoc.getDisplayLocale(article);
        String id = _getID(article);
        String[] authors = article.getAuthors();
        String title = article.getTitle();
        String subtitle = article.getSubTitle();
        String yomi = article.getYomi();
        Journal journal = article.getJournal();
        String pages = article.getPages();
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
        String publisher = null;
        if (journal != null) {
            publisher = journal.getPublisher();
        }
        String note = article.getNote();
        String uri = article.getUri();
        buffer.append("");
        buffer.append("@ARTICLE{");
        buffer.append(id);
        buffer.append(",\n");
        buffer.append("  author = \"");
        _makeAuthorEntries(authors, buffer);
        buffer.append("\",\n");
        if (yomi != null) {
            buffer.append("  yomi = \"");
            buffer.append(yomi);
            buffer.append("\",\n");
        }
        buffer.append("  title = \"");
        buffer.append("{");
        buffer.append(_escape(title));
        if (subtitle != null) {
            buffer.append(" : ");
            buffer.append(subtitle);
        }
        buffer.append("}");
        buffer.append("\",\n");
        if (journal != null) {
            buffer.append("  journal = \"");
            buffer.append(_escape(journal.getTitle()));
            buffer.append("\",\n");
        }
        if (pages != null) {
            buffer.append("  pages = \"");
            buffer.append(_escape(pages));
            buffer.append("\",\n");
        }
        if (publisher != null) {
            buffer.append("  publisher = \"");
            buffer.append(_escape(publisher));
            buffer.append("\",\n");
        }
        if (year != null) {
            buffer.append("  year = \"");
            buffer.append(year);
            buffer.append("\",\n");
        }
        if (month != null) {
            buffer.append("  month = \"");
            buffer.append(month);
//            buffer.append(config_.getMonthLabel(month, locale));
            buffer.append("\",\n");
        }
        if (volume != null) {
            buffer.append("  volume = \"");
            buffer.append(volume);
            buffer.append("\",\n");
        }            
        if (number != null) {
            buffer.append("  number = \"");
            buffer.append(number);
            buffer.append("\",\n");
        }            
        if (note == null && uri != null) {
            note = "{" + refHandler_.getHyperLinkTitle(uri) + "}";
//            note = uri;
        }
        if (note != null) {
            buffer.append("  note = \"");
            buffer.append(note);
            buffer.append("\",\n");
        }
        buffer.append("}\n");
    }

    protected void _makeJournalEntry(Journal journal, StringBuffer buffer) {
        String id = _getID(journal);
        String title = journal.getTitle();
        String yomi = journal.getYomi();
        String year = journal.getYear();
        String month = journal.getMonth();
        String volume = journal.getVolume();
        String number = journal.getNumber();
        String note = journal.getNote();
        String uri = journal.getUri();
        buffer.append("\n");
        buffer.append("@ARTICLE{");
        buffer.append(id);
        buffer.append(",\n");
        if (yomi != null) {
            buffer.append("  yomi = \"");
            buffer.append(yomi);
            buffer.append("\",\n");
        }
        buffer.append("  journal = \"");
        buffer.append(_escape(title));
        buffer.append("\",\n");
        buffer.append("  year = \"");
        buffer.append(year);
        buffer.append("\",\n");
        if (month != null) {
            buffer.append("  month = \"");
            buffer.append(month);
            buffer.append("\",\n");
        }
        if (volume != null) {
            buffer.append("  volume = \"");
            buffer.append(volume);
            buffer.append("\",\n");
        }
        if (number != null) {
            buffer.append("  number = \"");
            buffer.append(number);
            buffer.append("\",\n");
        }
        if (note == null && uri != null) {
            note = "{" + refHandler_.getHyperLinkTitle(uri) + "}";
//            note = uri;
        }
        if (note != null) {
            buffer.append("  note = \"");
            buffer.append(note);
            buffer.append("\",\n");
        }
        buffer.append("}\n");
    }

    protected void _makeBibMiscEntry(BibMisc misc, StringBuffer buffer) {
        String id = _getID(misc);
        String[] authors = misc.getAuthors();
        String title = misc.getTitle();
        String yomi = misc.getYomi();
        String howpublished = misc.getHowpublished();
        String month = misc.getMonth();
        String year = misc.getYear();
        String note = misc.getNote();
        String uri = misc.getUri();
        buffer.append("\n");
        buffer.append("@MISC{");
        buffer.append(id);
        buffer.append(",\n");
        buffer.append("  author = \"");
        _makeAuthorEntries(authors, buffer);
        buffer.append("\",\n");
        if (yomi != null) {
            buffer.append("  yomi = \"");
            buffer.append(yomi);
            buffer.append("\",\n");
        }
        buffer.append("  title = \"");
        buffer.append("{");
        buffer.append(_escape(title));
        buffer.append("}");
        buffer.append("\",\n");
        if (howpublished != null) {
            buffer.append("  howpublished = \"");
            buffer.append(howpublished);
            buffer.append("\",\n");
        }
        if (month != null) {
            buffer.append("  month = \"");
            buffer.append(month);
            buffer.append("\",\n");
        }
        if (year != null) {
            buffer.append("  year = \"");
            buffer.append(year);
            buffer.append("\",\n");
        }
        if (note == null && uri != null) {
            note = "{" + refHandler_.getHyperLinkTitle(uri) + "}";
//            note = uri;
        }
        if (note != null) {
            buffer.append("  note = \"");
            buffer.append(note);
            buffer.append("\",\n");
        }
        buffer.append("}\n");
    }

    protected void _makeEditorEntries(
        String editors[],
        StringBuffer buffer
    ) {
        _makeAuthorEntries(editors, buffer);
    }

    protected void _makeAuthorEntries(
        String authors[],
        StringBuffer buffer
    ) {
        if (authors == null ||
            authors.length == 0) {
//            buffer.append("anonymous");
            return;
        }
        buffer.append("{");
        buffer.append(authors[0]);
        buffer.append("}");
        for (int i = 1;i < authors.length;i++) {
            String author = authors[i];
            if (author == null || author.equals("")) {
                buffer.append(" and others");
            } else {
                buffer.append(" and {");
                buffer.append(_escape(authors[i]));
                buffer.append("}");
            }
        }
    }

/*
    protected void _makeBibliography0(Bibliography bib) {
        PrintWriter out = null;
        try {
            File file;
            File dir = config_.getProjectDirectory();
            if (dir == null) {
                file = new File(config_.getProject() + ".bib");
            } else {
                file = new File(dir, config_.getProject() + ".bib");
            }
            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            out.println("@preamble{ \"\\newcommand{\\noopsort}[1]{} \"");
            out.println("        # \"\\newcommand{\\printfirst}[2]{#1} \"");
            out.println("        # \"\\newcommand{\\singleletter}[1]{#1} \"");
            out.println("        # \"\\newcommand{\\switchargs}[2]{#2#1} \" }");
            Content[] entries = bib.getContents();
            for (int i = 0;i < entries.length;i++) {
                Content item = entries[i];
                if (item instanceof Book) {
                    _makeBook((Book)item, out);
                } else if (item instanceof Article) {
                    _makeArticle((Article)item, out);
                } else if (item instanceof Journal) {
                    _makeJournal((Journal)item, out);
                } else {
                    throw (new InternalError("bad item = " + item));
                }
            }
            out.flush();
        } catch (IOException e) {
            throw (new InternalError(e.toString()));
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    protected void _makeBook(Book book, PrintWriter out) {
        Locale locale = UDoc.getDisplayLocale(book);
        String id = book.getID();
        String[] authors = book.getAuthors();
        String[] editors = book.getEditors();
        String title = book.getTitle();
        String subtitle = book.getSubTitle();
        int edition = book.getEdition();
        String publisher = book.getPublisher();
        int year = book.getYear();
        out.println();
        out.print("@BOOK{");
        out.print(id);
        out.println(",");
        if (editors != null) {
            out.print("  editor = \"");
            _makeEditors(editors, out);
            out.println("\",");
        } else {
            out.print("  author = \"");
            _makeAuthors(authors, out);
            out.println("\",");
        }
        out.print("  title = \"");
        out.print(_escape(title));
        if (subtitle != null) {
            out.print(" : ");
            out.print(_escape(subtitle));
        }
        out.println("\",");
        if (edition > 0) {
            out.print("  edition = \"");
            out.print(config_.getEditionLabel(edition, locale));
            out.println("\",");
        }
        if (publisher != null) {
            out.print("  publisher = \"");
            out.print(_escape(publisher));
            out.println("\",");
        }
        out.print("  year = \"");
        out.print(year);
        out.println("\",");
        out.println("}");
    }

    protected void _makeArticle(Article article, PrintWriter out) {
        Locale locale = UDoc.getDisplayLocale(article);
        String id = article.getID();
        String[] authors = article.getAuthors();
        String title = article.getTitle();
        Journal journal = article.getJournal();
        int year = journal.getYear();
        int month = journal.getMonth();
        int volume = journal.getVolume();
        int number = journal.getNumber();
        String publisher = journal.getPublisher();
        out.println();
        out.print("@ARTICLE{");
        out.print(id);
        out.println(",");
        out.print("  author = \"");
        _makeAuthors(authors, out);
        out.println("\",");
        out.print("  title = \"");
        out.print(_escape(title));
        out.println("\",");
        out.print("  journal = \"");
        out.print(_escape(journal.getTitle()));
        out.println("\",");
        if (publisher != null) {
            out.print("  publisher = \"");
            out.print(_escape(publisher));
            out.println("\",");
        }
        if (year > 0) {
            out.print("  year = \"");
            out.print(year);
            out.println("\",");
        }
        if (month > 0) {
            out.print("  month = \"");
            out.print(config_.getMonthLabel(month, locale));
            out.println("\",");
        }
        if (volume > 0) {
            out.print("  volume = \"");
            out.print(volume);
            out.println("\",");
        }            
        if (number > 0) {
            out.print("  number = \"");
            out.print(number);
            out.println("\",");
        }            
        out.println("}");
    }

    protected void _makeJournal(Journal journal, PrintWriter out) {
        String id = journal.getID();
        String title = journal.getTitle();
        int year = journal.getYear();
        int month = journal.getMonth();
        int volume = journal.getVolume();
        int number = journal.getNumber();
        out.println();
        out.print("@ARTICLE{");
        out.print(id);
        out.println(",");
        out.print("  journal = \"");
        out.print(_escape(title));
        out.println("\",");
        out.print("  year = \"");
        out.print(year);
        out.println("\",");
        if (month > 0) {
            out.print("  month = \"");
            out.print(month);
            out.println("\",");
        }
        if (volume > 0) {
            out.print("  volume = \"");
            out.print(volume);
            out.println("\",");
        }
        if (number > 0) {
            out.print("  number = \"");
            out.print(number);
            out.println("\",");
        }
        out.println("}");
    }

    protected void _makeEditors(String editors[], PrintWriter out) {
        _makeAuthors(editors, out);
    }

    protected void _makeAuthors(String authors[], PrintWriter out) {
        if (authors == null ||
            authors.length == 0) {
            out.print("anonymous");
            return;
        }
        out.print("{");
        out.print(authors[0]);
        out.print("}");
        for (int i = 1;i < authors.length;i++) {
            String author = authors[i];
            if (author == null || author.equals("")) {
                out.print(" et.el"); // XXX
            } else {
                out.print("; ");
                out.print("{");
                out.print(_escape(authors[i]));
                out.print("}");
            }
        }
    }
*/

    protected void _makeBook(Book book, StringBuffer buffer) {
        buffer.append("\\nocite{");
        buffer.append(_getID(book));
        buffer.append("}\n");
    }

    protected void _makeArticle(Article article, StringBuffer buffer) {
        buffer.append("\\nocite{");
        buffer.append(_getID(article));
        buffer.append("}\n");
    }

    protected void _makeJournal(Journal journal, StringBuffer buffer) {
        buffer.append("\\nocite{");
        buffer.append(_getID(journal));
        buffer.append("}\n");
    }

    protected void _makeBibMisc(BibMisc misc, StringBuffer buffer) {
        buffer.append("\\nocite{");
        buffer.append(_getID(misc));
        buffer.append("}\n");
    }

    protected void _makeDiv(Div div, StringBuffer buffer) {
        _embedStyleBegin(div, buffer);
        buffer.append("{\n");
        String clazz = div.getClazz();
        if (clazz == null) {
            _makeText(div, buffer);
        } else if (styleUrl_ != null) {
            buffer.append("\\begin{");
            buffer.append(clazz);
            buffer.append("}\n");
            _makeText(div, buffer);
            buffer.append("\\end{");
            buffer.append(clazz);
            buffer.append("}\n");
        } else if ("result".equals(clazz)) { // XXX : more generic
            buffer.append("\\makeatletter\n"); // XXX : more generic
            buffer.append("\\@@line{\\dotfill}\n");
            buffer.append("\\makeatother\n");
            _makeText(div, buffer);
            buffer.append("\\makeatletter\n"); // XXX : more generic
            buffer.append("\\@@line{\\dotfill}\n");
            buffer.append("\\makeatother\n");
        } else {
            _makeText(div, buffer);
        }
        buffer.append("}\n");
        buffer.append("\n");
        _embedStyleEnd(div, buffer);
    }

    protected void _makeParagraph(Paragraph p, StringBuffer buffer) {
        _makeText(p, buffer);
        if (isTableMode_) {
            buffer.append("\\newline\n");
        } else {
            buffer.append("\n\n");
        }
    }

    protected void _makeSentence(Sentence sen, StringBuffer buffer) {
        _makeText(sen, buffer);
//        buffer.append("\n\n");
    }

/*
    protected String _getSentenceDelimiter() {
        return ("\n\n");
    }
*/

    protected void _makeTOC(Container container, StringBuffer buffer) {
        buffer.append("\n");
        if (config_.makeToc()) {
            if ("article".equals(documentType_)) {
                if ("long".equals(tocStyle_)) {
                    buffer.append("\\pagestyle{empty}\n");
                    buffer.append("\n");
                }
            } else if ("report".equals(documentType_) ||
                       "book".equals(documentType_)) {

                buffer.append("\\pagenumbering{roman}\n");
                buffer.append("\\pagestyle{");
                buffer.append(latex2eConfig_.getPageStyle()); // XXX
                buffer.append("}\n");
            }
            buffer.append("\n");
            buffer.append("\\tableofcontents\n");
            buffer.append("\n");
            if ("long".equals(tocStyle_)) {
                buffer.append("\\clearpage\n");
                buffer.append("\n");
                buffer.append("\\pagenumbering{arabic}\n");
                buffer.append("\\pagestyle{");
                buffer.append(latex2eConfig_.getPageStyle());
                buffer.append("}\n");
                buffer.append("\n");
            }
        }
    }

    protected void _makePartPrologue(Part part, StringBuffer buffer) {
//        String title = part.getTitle();
        Title title = part.getTitleNode();
        buffer.append("\n");
        buffer.append("\\part");
        if (!part.isSequencable()) {
            buffer.append("*");
        }
        buffer.append("{");
//        buffer.append(_escape(title));
        if (title != null) {
            _makeString(title, buffer);
        }
        buffer.append("}\n");
        if (part.hasReferer()) {
            _embedLabel(part, buffer);
        }
        buffer.append("\n");
    }

    protected void _makePartEpilogue(Part part, StringBuffer buffer) {
    }

    protected void _makeChapterPrologue(
        Chapter chapter,
        StringBuffer buffer
    ) {
//        String title = chapter.getTitle();
        Title title = chapter.getTitleNode();
        buffer.append("\n");
        buffer.append("\\chapter");
        if (!chapter.isSequencable()) {
            buffer.append("*");
        }
        buffer.append("{");
//        buffer.append(_escape(title));
        if (title != null) {
            _makeString(title, buffer);
        }
        buffer.append("}\n");
        if (chapter.hasReferer()) {
            _embedLabel(chapter, buffer);
        }
        buffer.append("\n");
    }

    protected void _makeChapterEpilogue(
        Chapter chapter,
        StringBuffer buffer
    ) {
    }

    protected void _makeSectionPrologue(
        Section section,
        StringBuffer buffer
    ) {
//        String title = section.getTitle();
        Title title = section.getTitleNode();
        buffer.append("\n");
        buffer.append("\\section");
        if (!section.isSequencable()) {
            buffer.append("*");
        }
        buffer.append("{");
//        buffer.append(_escape(title));
        if (title != null) {
            _makeString(title, buffer);
        }
        buffer.append("}\n");
        if (section.hasReferer()) {
            _embedLabel(section, buffer);
        }
        if (true) {                // XXX
            buffer.append("\\suppressfloats[t]\n");
        }
        buffer.append("\n");
    }

    protected void _makeSectionEpilogue(
        Section section,
        StringBuffer buffer
    ) {
    }

    protected void _makeSubSectionPrologue(
        SubSection subsection,
        StringBuffer buffer
    ) {
//        String title = subsection.getTitle();
        Title title = subsection.getTitleNode();
        buffer.append("\n");
        buffer.append("\\subsection");
        if (!subsection.isSequencable()) {
            buffer.append("*");
        }
        buffer.append("{");
//        buffer.append(_escape(title));
        if (title != null) {
            _makeString(title, buffer);
        }
        buffer.append("}\n");
        if (subsection.hasReferer()) {
            _embedLabel(subsection, buffer);
        }
        buffer.append("\n");
    }

    protected void _makeSubSectionEpilogue(
        SubSection subsection,
        StringBuffer buffer
    ) {
    }

    protected void _makeSubSubSectionPrologue(
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
//        String title = subsubsection.getTitle();
        Title title = subsubsection.getTitleNode();
        buffer.append("\n");
        buffer.append("\\subsubsection");
        if (!subsubsection.isSequencable()) {
            buffer.append("*");
        }
        buffer.append("{");
//        buffer.append(_escape(title));
        if (title != null) {
            _makeString(title, buffer);
        }
        buffer.append("}\n");
        if (subsubsection.hasReferer()) {
            _embedLabel(subsubsection, buffer);
        }
        buffer.append("\n");
    }

    protected void _makeSubSubSectionEpilogue(
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
    }

    protected void _makeAppendix(
        Appendix appendix,
        StringBuffer buffer
    ) {
//        String title = appendix.getTitle();
        Title title = appendix.getTitleNode();
        buffer.append("\n");
        buffer.append("\\appendix\n");
        buffer.append("\n");
        if (title != null) {
            buffer.append("\\vspace{1cm}\n");
            buffer.append("\\noindent{\\bfseries \\large ");
//            buffer.append(title);
            if (title != null) {
                _makeString(title, buffer);
            }
            buffer.append("}\n");
            buffer.append("\n");
        }
        _makeText(appendix, buffer);
    }

    protected void _makeFYI(
        FYI fyi,
        StringBuffer buffer
    ) {
        String title = fyi.getTitle();
        buffer.append("\n");
        buffer.append("\\begin{figure*}[");
        buffer.append(latex2eConfig_.getFYILoc());
        buffer.append("]\n");
        String boxBegin = boxHandler_.makeFYIBegin(_escape(title)); // XXX
        if (boxBegin != null) {
            buffer.append(boxBegin);
        }
        _makeText(fyi, buffer);
        String boxEnd = boxHandler_.makeFYIEnd();
        if (boxEnd != null) {
            buffer.append(boxEnd);
        }
        buffer.append("\\end{figure*}\n");
        buffer.append("\n");
    }

    protected void _makeUl(Ul ul, StringBuffer buffer) {
        buffer.append("\n");
        buffer.append("\\begin{itemize}\n");
        _makeText(ul, buffer);
        buffer.append("\\end{itemize}\n");
        buffer.append("\n");
    }

    protected void _makeOl(Ol ol, StringBuffer buffer) {
        buffer.append("\n");
        buffer.append("\\begin{enumerate}\n");
        _makeText(ol, buffer);
        buffer.append("\\end{enumerate}\n");
        buffer.append("\n");
    }

    protected void _makeLi(Li li, StringBuffer buffer) {
        buffer.append("\\item ");
        if (li.hasReferer()) {
//            _embedLabel(li, buffer);
            buffer.append("\\label{");
            buffer.append(_getID(li));
            buffer.append("}");
        }
        _makeString(li, buffer);
        buffer.append("\n");
    }

    protected void _makeDl(Dl dl, StringBuffer buffer) {
        buffer.append("\n");
        buffer.append("\\begin{description}\n");
        _makeText(dl, buffer);
        buffer.append("\\end{description}\n");
        buffer.append("\n");
    }

    protected void _makeDt(Dt dt, StringBuffer buffer) {
        buffer.append("\\item [");
        _makeString(dt, buffer);
        buffer.append("] ");
    }

    protected void _makeDd(Dd dd, StringBuffer buffer) {
        _makeString(dd, buffer);
        buffer.append("\n");
    }

    protected void _makeTable(Table table, StringBuffer buffer) {
        if (_isLongTable(table)) {
            _makeLongTable(table, buffer);
        } else {
            _makeFloatTable(table, buffer);
        }
    }

    private boolean _isLongTable(Table table) {
        String value = table.getAttribute("latex2e.longtable");
        if ("true".equals(value)) {
            return (true);
        }
        if ("false".equals(value)) {
            return (false);
        }
        return (table.getHeight() > floatTableHeight_);
    }

    private void _makeFloatTable(Table table, StringBuffer buffer) {
        CSSStyle style = table.getStyle();
        Tnote tnote = table.getTnote();
        _embedNewline(buffer);
        if (!UDoc.isAncestor(table, FYI.class)) {
            buffer.append(
                tableFloatHandler_.getBegin(
                    table,
                    latex2eConfig_.getTableLoc()
                )
            );
            _embedCaption(table, buffer);
        } else {
            // XXX : caption
            buffer.append("\\begin{center}\n");
        }
/* [1267]
        if (style != null) {
            buffer.append(imageHandler_.makeStyleBegin(style));
        }
        _embedStyleBegin(table, buffer);
*/
        if (true) {
            isTableMode_ = true;
            buffer.append("\\minipagetbl{\n");
        }
        if (style != null) {
            buffer.append(imageHandler_.makeStyleBegin(style));
        }
        _embedStyleBegin(table, buffer);
        if ("tabularx".equals(latex2eConfig_.getTabularType())) {
            buffer.append("\\begin{tabularx}{\\linewidth}");
        } else {
            buffer.append("\\begin{tabular}");
        }
        // meta info
        buffer.append("{");
        buffer.append(tableHandler_.getLeftBorderLine());
        Colgroup[] colgroups = table.getColgroups();
        if (colgroups.length > 0) {
            for (int i = 0;i < colgroups.length - 1;i++) {
                _makeColgroup(colgroups[i], buffer);
                buffer.append(tableHandler_.getThickVLine());
            }
            _makeColgroup(colgroups[colgroups.length - 1], buffer);
            buffer.append(tableHandler_.getRightBorderLine());
        }
        buffer.append("}");
        buffer.append(tableHandler_.getTopBorderLine());
        buffer.append("\n");
        // header
        if (table.getTHead() != null) {
            _makeTHead(table, buffer);
        }
        // body
        _makeTBody(table, buffer);
        // footer
        if (table.getTFoot() != null) {
            _makeTFoot(table, buffer);
        }
        if (tnote != null) {
            buffer.append("\\multicolumn{");
            buffer.append(table.getWidth());
            buffer.append("}{r}{");
            _makeTnote(tnote, buffer);
            buffer.append("} \\\\\n");
        }
        if ("tabularx".equals(latex2eConfig_.getTabularType())) {
            buffer.append("\\end{tabularx}");
        } else {
            buffer.append("\\end{tabular}");
        }
        if (true) {
            buffer.append("}\n");
            isTableMode_ = false;
        }
        if (style != null) {
            buffer.append(imageHandler_.makeStyleEnd(style));
        }
        _embedStyleEnd(table, buffer);
        if (UDoc.isAncestor(table, FYI.class)) {
            buffer.append("\\end{center}\n");
        } else {
            buffer.append(tableFloatHandler_.getEnd(table));
        }
        _embedNewline(buffer);
    }

    private void _makeLongTable(Table table, StringBuffer buffer) {
        CSSStyle style = table.getStyle();
        Tnote tnote = table.getTnote();
        _embedNewline(buffer);
        buffer.append("\\setlongtables\n");
        if (true) {
//            isTableMode_ = true;
//            buffer.append("\\minipagetbl{\n");
        }
        buffer.append("\\begin{longtable}");
        // meta info
        buffer.append("{");
        if (true) {                // XXX
            buffer.append("|");
        } else {
            buffer.append(tableHandler_.getLeftBorderLine());
        }
        Colgroup[] colgroups = table.getColgroups();
        if (colgroups.length > 0) {
            for (int i = 0;i < colgroups.length - 1;i++) {
                _makeColgroup(colgroups[i], buffer);
                if (true) {        // XXX
                    buffer.append("|");
                } else {
                    buffer.append(tableHandler_.getThickVLine());
                }
            }
            _makeColgroup(colgroups[colgroups.length - 1], buffer);
            if (true) {                // XXX
                buffer.append("|");
            } else {
                buffer.append(tableHandler_.getRightBorderLine());
            }
        }
        buffer.append("}");
        buffer.append("\n");
        // caption
//        String caption = table.getTitle();
//        if (caption != null) {
//            _embedCommand("caption", _escape(caption), buffer);
//            _embedNewline(buffer);
//            _embedLabel(table, buffer);
//        }
        if (table.getTitleNode() != null) {
            _embedCaption(table, buffer);
            buffer.append(" \\\\ ");
        }
        if (true) {                // XXX
            buffer.append("\\hline");
        } else {
            buffer.append(tableHandler_.getTopBorderLine());
        }
        _embedNewline(buffer);
        // firsthead
        if (table.getTHead() != null) {
            _makeTHeadLong(table, buffer);
        }
        buffer.append("\\endfirsthead\n");
        // head
        buffer.append("\\multicolumn{");
        buffer.append(table.getWidth());
        buffer.append("}{l}{\\small\\slshape continued from previous page} \\\\ ");
        if (true) {                // XXX
            buffer.append("\\hline");
        } else {
            buffer.append(tableHandler_.getTopBorderLine());
        }
        _embedNewline(buffer);
        if (table.getTHead() != null) {
            _makeTHeadLong(table, buffer);
        }
        buffer.append("\\endhead\n");
        // foot
        if (table.getTFoot() != null) {
            _makeTFootLong(table, buffer);
        }
        buffer.append("\\multicolumn{");
        buffer.append(table.getWidth());
        buffer.append("}{r}{\\small\\slshape continued on next page} \\\\\n");
        buffer.append("\\endfoot\n");
        // lastfoot
        if (table.getTFoot() != null) {
            _makeTFootLong(table, buffer);
        }
        if (tnote != null) {
            buffer.append("\\multicolumn{");
            buffer.append(table.getWidth());
            buffer.append("}{r}{");
            _makeTnote(tnote, buffer);
            buffer.append("} \\\\\n");
        }
        buffer.append("\\endlastfoot\n");
        // body
        _makeTBodyLong(table, buffer);
        //
        buffer.append("\\end{longtable}\n");
        if (true) {
//            buffer.append("}\n");
//            isTableMode_ = false;
        }
    }

    protected void _makeTBody(Table table, StringBuffer buffer) {
        int width = table.getWidth();
        int height = table.getHeight();
        if (height > 0) {
            int loop = height - 1;
            for (int y = 0;y < loop;y++) {
                _makeTr(table, y, buffer);
                int yy = y + 1;
                List list = new ArrayList();
                int last = 0;
                for (int x = 0;x < width;x++) {
                    if (x < last) {
                        list.add(new Integer(x + 1));
                    } else {
                        TrContent cell = table.getCell(x, yy);
                        if (cell != null) {
                            last = x + cell.getColSpan();
                            list.add(new Integer(x + 1));
                        }
                    }
                }
                int nCols = list.size();
                if (nCols == 0) {
                    buffer.append(" \\\\\n");
                } else if (nCols == width) {
                    buffer.append(" \\\\ ");
                    buffer.append(tableHandler_.getThinHLine());
                    buffer.append("\n");
                } else {
                    buffer.append(" \\\\ ");
                    int size = list.size();
                    int start = ((Integer)list.get(0)).intValue();
                    int end = start;
                    for (int i = 1;i < size;i++) {
                        int current = ((Integer)list.get(i)).intValue();
                        if (current - 1 == end) {
                            end = current;
                        } else {
                            buffer.append("\\cline{");
                            buffer.append(start);
                            buffer.append("-");
                            buffer.append(end);
                            buffer.append("} ");
                            start = end = current;
                        }
                    }
                    buffer.append("\\cline{");
                    buffer.append(start);
                    buffer.append("-");
                    buffer.append(end);
                    buffer.append("}\n");
                }
            }
            _makeTr(table, loop, buffer);
            buffer.append(" \\\\ ");
            buffer.append(tableHandler_.getBottomBorderLine());
            buffer.append("\n");
        }
    }

    protected void _makeTHead(Table table, StringBuffer buffer) {
        D2Array data = table.getHeadData();
        if (data != null) {
            _makeTData(data, table, buffer);
        }
    }

    protected void _makeTFoot(Table table, StringBuffer buffer) {
        D2Array data = table.getFootData();
        if (data != null) {
            _makeTData(data, table, buffer);
        }
    }

    protected void _makeTData(
        D2Array data,
        Table table,
        StringBuffer buffer
    ) {
        int width = data.getWidth();
        int height = data.getHeight();
        if (height > 0) {
            int loop = height - 1;
            for (int y = 0;y < loop;y++) {
                _makeTr(data, y, table, buffer);
                int yy = y + 1;
                List list = new ArrayList();
                int last = 0;
                for (int x = 0;x < width;x++) {
                    if (x < last) {
                        list.add(new Integer(x + 1));
                    } else {
                        TrContent cell = (TrContent)data.get(x, yy);
                        if (cell != null) {
                            last = x + cell.getColSpan();
                            list.add(new Integer(x + 1));
                        }
                    }
                }
                int nCols = list.size();
                if (nCols == 0) {
                    buffer.append(" \\\\\n");
                } else if (nCols == width) {
                    buffer.append(" \\\\ ");
                    buffer.append(tableHandler_.getThinHLine());
                    buffer.append("\n");
                } else {
                    buffer.append(" \\\\ ");
                    int size = list.size();
                    int start = ((Integer)list.get(0)).intValue();
                    int end = start;
                    for (int i = 1;i < size;i++) {
                        int current = ((Integer)list.get(i)).intValue();
                        if (current - 1 == end) {
                            end = current;
                        } else {
                            buffer.append("\\cline{");
                            buffer.append(start);
                            buffer.append("-");
                            buffer.append(end);
                            buffer.append("} ");
                            start = end = current;
                        }
                    }
                    buffer.append("\\cline{");
                    buffer.append(start);
                    buffer.append("-");
                    buffer.append(end);
                    buffer.append("}\n");
                }
            }
            _makeTr(data, loop, table, buffer);
            buffer.append(" \\\\ ");
            buffer.append(tableHandler_.getBottomBorderLine());
            buffer.append("\n");
        }
    }

    // XXX : unify _makeTHead
    protected void _makeTBodyLong(Table table, StringBuffer buffer) {
        int width = table.getWidth();
        int height = table.getHeight();
        if (height > 0) {
            int loop = height - 1;
            for (int y = 0;y < loop;y++) {
                _makeTr(table, y, buffer);
                int yy = y + 1;
                List list = new ArrayList();
                int last = 0;
                for (int x = 0;x < width;x++) {
                    if (x < last) {
                        list.add(new Integer(x + 1));
                    } else {
                        TrContent cell = table.getCell(x, yy);
                        if (cell != null) {
                            last = x + cell.getColSpan();
                            list.add(new Integer(x + 1));
                        }
                    }
                }
                int nCols = list.size();
                if (nCols == 0) {
                    buffer.append(" \\\\\n");
                } else if (nCols == width) {
                    buffer.append(" \\\\ ");
                    if (true) {
                        buffer.append("\\hline");
                    } else {
                        buffer.append(tableHandler_.getThinHLine());
                    }
                    buffer.append("\n");
                } else {
                    buffer.append(" \\\\ ");
                    int size = list.size();
                    int start = ((Integer)list.get(0)).intValue();
                    int end = start;
                    for (int i = 1;i < size;i++) {
                        int current = ((Integer)list.get(i)).intValue();
                        if (current - 1 == end) {
                            end = current;
                        } else {
                            buffer.append("\\cline{");
                            buffer.append(start);
                            buffer.append("-");
                            buffer.append(end);
                            buffer.append("} ");
                            start = end = current;
                        }
                    }
                    buffer.append("\\cline{");
                    buffer.append(start);
                    buffer.append("-");
                    buffer.append(end);
                    buffer.append("}\n");
                }
            }
            _makeTr(table, loop, buffer);
            buffer.append(" \\\\ ");
            if (true) {
                buffer.append("\\hline");
            } else {
                buffer.append(tableHandler_.getBottomBorderLine());
            }
            buffer.append("\n");
        }
    }

    // XXX : unify _makeTHead
    protected void _makeTHeadLong(Table table, StringBuffer buffer) {
        D2Array data = table.getHeadData();
        if (data != null) {
            _makeTDataLong(data, table, buffer);
        }
    }

    // XXX : unify _makeTFoot
    protected void _makeTFootLong(Table table, StringBuffer buffer) {
        D2Array data = table.getFootData();
        if (data != null) {
            _makeTDataLong(data, table, buffer);
        }
    }

    // XXX : unify _makeTData
    protected void _makeTDataLong(
        D2Array data,
        Table table,
        StringBuffer buffer
    ) {
        int width = data.getWidth();
        int height = data.getHeight();
        if (height > 0) {
            int loop = height - 1;
            for (int y = 0;y < loop;y++) {
                _makeTr(data, y, table, buffer);
                int yy = y + 1;
                List list = new ArrayList();
                int last = 0;
                for (int x = 0;x < width;x++) {
                    if (x < last) {
                        list.add(new Integer(x + 1));
                    } else {
                        TrContent cell = (TrContent)data.get(x, yy);
                        if (cell != null) {
                            last = x + cell.getColSpan();
                            list.add(new Integer(x + 1));
                        }
                    }
                }
                int nCols = list.size();
                if (nCols == 0) {
                    buffer.append(" \\\\\n");
                } else if (nCols == width) {
                    buffer.append(" \\\\ ");
                    if (true) {        // XXX : just one line modification
                        buffer.append("\\hline");
                    } else {
                        buffer.append(tableHandler_.getThinHLine());
                    }
                    buffer.append("\n");
                } else {
                    buffer.append(" \\\\ ");
                    int size = list.size();
                    int start = ((Integer)list.get(0)).intValue();
                    int end = start;
                    for (int i = 1;i < size;i++) {
                        int current = ((Integer)list.get(i)).intValue();
                        if (current - 1 == end) {
                            end = current;
                        } else {
                            buffer.append("\\cline{");
                            buffer.append(start);
                            buffer.append("-");
                            buffer.append(end);
                            buffer.append("} ");
                            start = end = current;
                        }
                    }
                    buffer.append("\\cline{");
                    buffer.append(start);
                    buffer.append("-");
                    buffer.append(end);
                    buffer.append("}\n");
                }
            }
            _makeTr(data, loop, table, buffer);
            buffer.append(" \\\\ ");
            if (true) {
                buffer.append("\\hline");
            } else {
                buffer.append(tableHandler_.getBottomBorderLine());
            }
            buffer.append("\n");
        }
    }

    protected void _makeTr(
        D2Array data,
        int y,
        Table table,
        StringBuffer buffer
    ) {
        int width = data.getWidth();
        int span = 0;                // 0 means rowspan area
        if (width > 0) {
            TrContent cell;
            cell = (TrContent)data.get(0, y);
            if (cell != null) {
                _makeTCell(cell, buffer);
                span = cell.getColSpan();
            } else {
                span = _makeRowSpanAreaStub(data, width, 0, y, table, buffer);
            }
            for (int x = 1;x < width;x++) {
                if (--span == 0) {
                    cell = (TrContent)data.get(x, y);
                    if (cell != null) {
                        buffer.append(" & ");
                        _makeTCell(cell, buffer);
                        span = cell.getColSpan();
                    } else {
                        buffer.append(" & ");
                        span = _makeRowSpanAreaStub(
                            data, width, x, y, table, buffer);
                    }
                }
            }
        }
    }

    protected int _makeRowSpanAreaStub(
        D2Array data,
        int width,
        int x,
        int y,
        Table table,
        StringBuffer buffer
    ) {
        int areaWidth = 0;
        int span;
        span = _makeRowSpanAreaStubPerRow(data, x, y, table, buffer);
        areaWidth += span;
        for (x += span;x < width;x += span) {
            if (data.get(x, y) != null) {
                break;
            }
            buffer.append(" & ");
            span = _makeRowSpanAreaStubPerRow(data, x, y, table, buffer);
            areaWidth += span;
        }
        return (areaWidth);
    }

    protected int _makeRowSpanAreaStubPerRow(
        D2Array data,
        int x,
        int y,
        Table table,
        StringBuffer buffer
    ) {
        while (--y >= 0) {
            TrContent cell = (TrContent)data.get(x, y);
            if (cell != null) {
                int span = cell.getColSpan();
                if (span > 1) {
                    Td multi = new Td(); // XXX
                    multi.setColSpan(span);
                    multi.setCol(table.getCols()[x]);
                    _makeTd(multi, buffer);
                }
                return (span);
            }
        }
        return (1);
//        throw (new InternalError());
    }

    protected void _makeTCell(TrContent cell, StringBuffer buffer) {
        if (cell instanceof Th) {
            _makeTh((Th)cell, buffer);
        } else if (cell instanceof Td) {
            _makeTd((Td)cell, buffer);
        } else {
            throw (new InternalError());
        }
    }

    protected void _makeTnote(Tnote tnote, StringBuffer buffer) {
        buffer.append("\\footnotesize\n");
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
        buffer.append("\\begin{tabular}{lcl}\n");
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof Dt) {
                _makeString((Dt)content, buffer);
                buffer.append(" & : & ");
            } else if (content instanceof Dd) {
                _makeString((Dd)content, buffer);
                buffer.append(" \\\\\n");
            }
        }
        buffer.append("\\end{tabular}\n");
    }

    protected void _makeTnoteUl(Ul ul, StringBuffer buffer) {
        Content[] contents = ul.getContents();
        buffer.append("\\begin{tabular}{ll}\n");
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof Li) {
                buffer.append("\\labelitemi & ");
                _makeString((Li)content, buffer);
                buffer.append(" \\\\\n");
            }
        }
        buffer.append("\\end{tabular}\n");
    }

    protected void _makeColgroup(Colgroup colgroup, StringBuffer buffer) {
        Col[] cols = colgroup.getCols();
        if (cols.length > 0) {
            _makeCol(cols[0], buffer);
            for (int j = 1;j < cols.length;j++) {
                buffer.append("|");
                _makeCol(cols[j], buffer);
            }
        }
    }

    protected void _makeCol(Col col, StringBuffer buffer) {
        CSSLength width = col.getWidthFinal();
        String calign = col.getAlignFinal();
        if (width != null) {
            buffer.append("p{");
            buffer.append(ULaTeX2e.getLengthString(width));
            buffer.append("}");
        } else if (calign != null) {
            if ("left".equals(calign)) {
                buffer.append("l");
            } else if ("center".equals(calign)) {
                buffer.append("c");
            } else if ("right".equals(calign)) {
                buffer.append("r");
            } else {
                throw (new IllegalArgumentException());
            }
        } else {
            if (!isTableMode_) {  // long table
                buffer.append("l");
            } else if ("tabularx".equals(latex2eConfig_.getTabularType())) {
                buffer.append("X");
            } else {
                buffer.append("l");
            }
        }
    }

/*
    protected void _makeHeadTr(Table table, int y, StringBuffer buffer) {
        int width = table.getWidth();
        int span = 0;                // 0 means rowspan area
        if (width > 0) {
            Th th;
            th = table.getTh(0, y);
            if (th != null) {
                _makeTh(th, buffer);
                span = th.getColSpan();
            } else {
                span = _makeHeadRowSpanAreaStub(table, width, 0, y, buffer);
            }
            for (int x = 1;x < width;x++) {
                if (--span == 0) {
                    th = table.getTh(x, y);
                    if (th != null) {
                        buffer.append(" & ");
                        _makeTh(th, buffer);
                        span = th.getColSpan();
                    } else {
                        span = _makeHeadRowSpanAreaStub(
                            table, width, x, y, buffer);
                    }
                }
            }
        }
    }

    protected int _makeHeadRowSpanAreaStub(
        Table table,
        int width,
        int x,
        int y,
        StringBuffer buffer
    ) {
        int areaWidth = 0;
        int span;
        span = _makeHeadRowSpanAreaStubPerRow(table, x, y, buffer);
        areaWidth += span;
        for (x += span;x < width;x += span) {
            if (table.getTh(x, y) != null) {
                break;
            }
            buffer.append(" & ");
            span = _makeHeadRowSpanAreaStubPerRow(table, x, y, buffer);
            areaWidth += span;
        }
        return (areaWidth);
    }

    protected int _makeHeadRowSpanAreaStubPerRow(
        Table table,
        int x,
        int y,
        StringBuffer buffer
    ) {
        while (--y >= 0) {
            Th th = table.getTh(x, y);
            if (th != null) {
                int span = th.getColSpan();
                if (span > 1) {
                    Th multi = new Th();
                    multi.setColSpan(span);
                    multi.setCol(table.getCols()[x]);
                    _makeTh(multi, buffer);
                }
                return (span);
            }
        }
        return (1);
//        throw (new InternalError()); XXX
    }
*/

    protected void _makeTr(Table table, int y, StringBuffer buffer) {
        int width = table.getWidth();
        int span = 0;                // 0 means rowspan area
        if (width > 0) {
            TrContent cell;
            cell = table.getCell(0, y);
            if (cell != null) {
                _makeTCell(cell, buffer);
                span = cell.getColSpan();
            } else {
                span = _makeRowSpanAreaStub(table, width, 0, y, buffer);
            }
            for (int x = 1;x < width;x++) {
                if (--span == 0) {
                    cell = table.getCell(x, y);
                    if (cell != null) {
                        buffer.append(" & ");
                        _makeTCell(cell, buffer);
                        span = cell.getColSpan();
                    } else {
                        buffer.append(" & ");
                        span = _makeRowSpanAreaStub(
                            table, width, x, y, buffer);
                    }
                }
            }
        }
    }

    protected int _makeRowSpanAreaStub(
        Table table,
        int width,
        int x,
        int y,
        StringBuffer buffer
    ) {
        int areaWidth = 0;
        int span;
        span = _makeRowSpanAreaStubPerRow(table, x, y, buffer);
        areaWidth += span;
        for (x += span;x < width;x += span) {
            if (table.getCell(x, y) != null) {
                break;
            }
            buffer.append(" & ");
            span = _makeRowSpanAreaStubPerRow(table, x, y, buffer);
            areaWidth += span;
        }
        return (areaWidth);
    }

    protected int _makeRowSpanAreaStubPerRow(
        Table table,
        int x,
        int y,
        StringBuffer buffer
    ) {
        while (--y >= 0) {
            TrContent cell = table.getCell(x, y);
            if (cell != null) {
                int span = cell.getColSpan();
                if (span > 1) {
                    Td multi = new Td();
                    multi.setColSpan(span);
                    multi.setCol(table.getCols()[x]);
                    _makeTd(multi, buffer);
                }
                return (span);
            }
        }
        return (1);
//        throw (new InternalError());
    }

    protected void _makeTh(Th th, StringBuffer buffer) {
        _makeTCell(th, true, buffer);
    }

    protected void _makeTd(Td td, StringBuffer buffer) {
        _makeTCell(td, false, buffer);
    }

    protected void _makeTCell(
        TrContent cell,
        boolean bold,
        StringBuffer buffer
    ) {
        StringBuffer tmp = new StringBuffer();
        _makeString(cell, tmp);
        String content = new String(tmp);
        if (true) {                // XXX
            content = content.trim();
        } else {
//            content = content;
        }
        String clazz = cell.getClazz();
        String align = cell.getAlign();
        if (align == null) {
            Col col = cell.getCol();
            if (col.getWidthFinal() != null) { // p{}
                align = col.getAlignFinal();
            }
        }
        int rowSpan = cell.getRowSpan();
        int colSpan = cell.getColSpan();
        if (bold) {
            content = "\\bfseries{" + content + "}";
        }
        if (colSpan == 1) {
            if (align == null) {
                buffer.append(content);
            } else if ("left".equals(align)) {
                buffer.append(content);
                buffer.append(" \\hfill\\null");
            } else if ("center".equals(align)) {
                buffer.append("\\hfill ");
                buffer.append(content);
                buffer.append(" \\hfill\\null");
            } else if ("right".equals(align)) {
                buffer.append("\\hfill ");
                buffer.append(content);
            }
        } else {
            Col leftCol = cell.getCol();
            Colgroup colgroup = leftCol.getColgroup();
            Table table = colgroup.getTable();
            Col[] colsOfColgroup = colgroup.getCols();
            Col[] colsOfTable = table.getCols();
            int span = cell.getColSpan();
            int i = 0;
            for (;i < colsOfTable.length;i++) {
                if (colsOfTable[i] == leftCol) {
                    break;
                }
            }
            if (i == colsOfTable.length) {
                throw (new InternalError());
            }
            Col rightCol = colsOfTable[i + span - 1];
            buffer.append("\\multicolumn{");
            buffer.append(colSpan);
            buffer.append("}{");
            if (colsOfTable[0] == leftCol) {
                buffer.append(tableHandler_.getLeftBorderLine());
            } else if (colsOfColgroup[0] == leftCol) {
                // do nothing
            } else {
//                buffer.append(tableHandler_.getThinHLine());
                // do nothing                
            }
            if (align == null) {
                align = leftCol.getAlign();
            }
            if ("left".equals(align)) {
                buffer.append("l");
            } else if ("center".equals(align)) {
                buffer.append("c");
            } else if ("right".equals(align)) {
                buffer.append("r");
            } else {
                buffer.append("l");
            }
            if (colsOfTable[colsOfTable.length - 1] == rightCol) {
                buffer.append(tableHandler_.getRightBorderLine());
            } else if (colsOfColgroup[colsOfColgroup.length - 1] == rightCol) {
                // do nothing
            } else {
                buffer.append(tableHandler_.getThinVLine());
            }
            buffer.append("}{");
            buffer.append(content);
            buffer.append("}");
        }
    }

    protected void _makeImg(Img img, StringBuffer buffer) {
        buffer.append(imageHandler_.makeImageTag(img));
    }

    protected void _makeImage(ImageFigure image, StringBuffer buffer) {
        buffer.append("\n");
        if (UDoc.isAncestor(image, FYI.class)) {
            buffer.append("\\begin{center}\n");
            buffer.append(imageHandler_.makeImageTag(image));
            buffer.append("\n");
// XXX :    _embedCaption(image, buffer);
            buffer.append("\\end{center}\n");
        } else {
            buffer.append(
                imageFloatHandler_.getBegin(
                    image,
                    latex2eConfig_.getImageLoc()
                )
            );
            buffer.append(imageHandler_.makeImageTag(image));
            buffer.append("\n");
            _embedCaption(image, buffer);
            buffer.append(imageFloatHandler_.getEnd(image));
        }
        buffer.append("\n");
    }

    protected void _makeSpan(Span span, StringBuffer buffer) {
        String clazz = span.getClazz();
        if (clazz != null && styleUrl_ != null) {
            buffer.append("\\");
            buffer.append(clazz);
            buffer.append("{");
        }
        _embedStyleBegin(span, buffer);
        String ruby = span.getRuby();
        if (ruby != null) {
            buffer.append(rubyHandler_.makeRubyBegin(ruby));
            _makeString(span, buffer);
            buffer.append(rubyHandler_.makeRubyEnd(ruby));
        } else {
            _makeString(span, buffer);
        }
        _embedStyleEnd(span, buffer);
        if (clazz != null && styleUrl_ != null) {
            buffer.append("}");
        }
    }

    protected void _makeTerm(Term term, StringBuffer buffer) {
        _makeString(term, buffer);
    }

    protected void _makeIndex(Index index, StringBuffer buffer) {
        _makeString(index, buffer);
        String term = UDoc.distillText(index);
        String phonetic = index.getPhonetic();
        if (phonetic != null) {
            // XXX : I18N
            term = phonetic + "@" + term;
        }
        _embedCommand("index", term, buffer);
    }

    protected void _makeBold(Bold bold, StringBuffer buffer) {
        _embedCommand("textbf", bold, buffer);
    }

    protected void _makeItalic(Italic italic, StringBuffer buffer) {
        _embedCommand("textit", italic, buffer);
    }

    protected void _makeDfn(Dfn dfn, StringBuffer buffer) {
        _embedCommand("textbf", dfn, buffer);
    }

    protected void _makeTt(Tt tt, StringBuffer buffer) {
        _embedCommand("texttt", tt, buffer);
    }

    protected void _makeEm(Em em, StringBuffer buffer) {
        _embedCommand("textbf", em, buffer); // XXX
    }

    protected void _makeStrong(Strong strong, StringBuffer buffer) {
        _embedCommand("textbf", strong, buffer); // XXX
    }

    // AbstractGeneratorBase
    protected void _makeAbbr(Abbr abbr, StringBuffer buffer) {
        _embedCommand("textbf", abbr, buffer);
    }

    // AbstractGeneratorBase
    protected void _makeAcronym(Acronym acronym, StringBuffer buffer) {
        _embedCommand("textbf", acronym, buffer);
    }

    protected void _makeCode(Code code, StringBuffer buffer) {
        _embedCommand("texttt", code, buffer);
    }

    protected void _makeBlockquote(
        Blockquote blockquote,
        StringBuffer buffer
    ) {
        _embedEnvironment("quotation", blockquote, buffer);
    }

    protected void _makeQuote(Quote quote, StringBuffer buffer) {
        buffer.append(latex2eConfig_.getQuotePrologue());
        _makeText(quote, buffer);
        buffer.append(latex2eConfig_.getQuoteEpilogue());
    }

    protected void _makeAnchor(Anchor anchor, StringBuffer buffer) {
        String text = _escape(anchor.getText());
        buffer.append("\\index{");
        buffer.append(text);
        buffer.append("}");
        buffer.append(text);
    }

    protected void _makePre(Pre pre, StringBuffer buffer) {
        _embedNewline(buffer);
        _embedStyleBegin(pre, buffer);
        buffer.append("\\begin{verbatim}");
        buffer.append(UDoc.distillText(pre));
        buffer.append("\\end{verbatim}\n");
        _embedStyleEnd(pre, buffer);
        _embedNewline(buffer);
    }

    protected void _makeProgram(Program program, StringBuffer buffer) {
        Title title = program.getTitleNode();
        String src = program.getSrc();
        src = null;                // XXX : change LaTeX2eProgramHandler
        _embedNewline(buffer);
        buffer.append("\\bigskip\n");
        _embedNewline(buffer);
        if (title != null) {
            buffer.append(_escape(model_.getLabel("list", program)));
            buffer.append("\\refstepcounter{program}\n");
            buffer.append("\\theprogram : ");
            _makeString(title, buffer);
            buffer.append("\n");
            _embedLabel(program, buffer);
            buffer.append("\\smallskip\n");
        }
        CSSStyle defaultStyle = new CSSStyle("font-size:small");
        _embedStyleBegin(program, defaultStyle, buffer);
        buffer.append(
            programHandler_.format(
                src,
                program.getText(),
                program.getDoc().getDocContext()
            )
        );
        _embedStyleEnd(program, defaultStyle, buffer);
        _embedNewline(buffer);
        buffer.append("\\bigskip\n");
        _embedNewline(buffer);
    }

    protected void _makeConsole(Console console, StringBuffer buffer) {
        Title title = console.getTitleNode();
        String src = console.getSrc();
        src = null;                // XXX
        String display = console.getText();
        buffer.append("\n");
        buffer.append("\\bigskip\n");
        if (title != null) {
            buffer.append("\\begin{figure}[");
            buffer.append(latex2eConfig_.getConsoleLoc());
            buffer.append("]\n");
        }
        String boxBegin = boxHandler_.makeConsoleBegin();
        if (boxBegin != null) {
            buffer.append(boxBegin);
        }
        _embedStyleBegin(console, buffer);
        buffer.append(
            consoleHandler_.format(
                src,
                display,
                console.getDoc().getDocContext()
            )
        );
        _embedStyleEnd(console, buffer);
        String boxEnd = boxHandler_.makeConsoleEnd();
        if (boxEnd != null) {
            buffer.append(boxEnd);
        }
        if (title != null) {
            _embedCaption(console, buffer);
            buffer.append("\\end{figure}\n");
        }
        buffer.append("\\bigskip\n");
        buffer.append("\n");
    }

    protected void _makeEquation(Equation equation, StringBuffer buffer) {
        _embedEnvironmentWithLabel("equation", equation, buffer);
    }

    protected void _makeRef(Ref ref, StringBuffer buffer) {
        String href = ref.getHref();
        if (href == null) {
            href = "*unresolved reference*";
        }
        Content[] contents = ref.getContents();        // XXX
        String label;
        if (contents.length > 0) {
            label = _getString(ref);
            if ("".equals(label)) {
                label = null;
            }
        } else {
            label = null;
        }
        switch (ref.getType()) {

        case Ref.SELF_LINK:
            Content link = ref.getLink();
            String labelPrefix = _getLabelPrefix(ref);
            String labelSuffix = _getLabelSuffix(ref);
            if (labelPrefix != null || labelSuffix != null) {
                String id = _getID(link);
                if (id != null) {
                    href = id;
                }
                String[] parts = new String[2];
                parts[0] = labelPrefix;
                parts[1] = labelSuffix;
                _makeRefFloat(href, parts, label, buffer);
            } else if (link != null) {
                String id = _getID(link);
                if (link instanceof ImageFigure) {
                    String prefix = model_.getLabel("figure", ref);
                    _makeRefFloat(id, prefix, label, buffer);
                } else if (link instanceof Table) {
                    String prefix = model_.getLabel("table", ref);
                    _makeRefFloat(id, prefix, label, buffer);
                } else if (link instanceof Console) {
                    String prefix = model_.getLabel("figure", ref);
                    _makeRefFloat(id, prefix, label, buffer);
                } else if (link instanceof Program) {
                    String prefix = model_.getLabel("list", ref);
                    _makeRefFloat(id, prefix, label, buffer);
                } else if (link instanceof Part) {
                    String[] parts = model_.getLabelParts("part", ref);
                    _makeRefFloat(id, parts, label, buffer);
                } else if (link instanceof Chapter) {
                    String[] parts = model_.getLabelParts("chapter", ref);
                    _makeRefFloat(id, parts, label, buffer);
                } else if (link instanceof Section) {
                    String[] parts = model_.getLabelParts("section", ref);
                    _makeRefFloat(id, parts, label, buffer);
                } else if (link instanceof SubSection) {
                    String[] parts = model_.getLabelParts("section", ref);
                    _makeRefFloat(id, parts, label, buffer);
                } else if (link instanceof SubSubSection) {
                    String[] parts = model_.getLabelParts("section", ref);
                    _makeRefFloat(id, parts, label, buffer);
                } else if (link instanceof Equation) {
                    String[] parts = model_.getLabelParts("equation", ref);
                    _makeRefFloat(id, parts, label, buffer);
                } else if (link instanceof Bibitem) {
                    if (label != null) {
                        buffer.append(
                            refHandler_.getSelfLinkCite(id, label)
                        );
                    } else {
                        buffer.append(
                            refHandler_.getSelfLinkCite(id)
                        );
                    }
                } else if (link instanceof TitledBlock) {
                    if (label != null) {
                        buffer.append(
                            refHandler_.getSelfLinkTitle(label)
                        );
                    } else {
                        buffer.append(
                            refHandler_.getSelfLinkTitle(id)
                        );
                    }
                } else if (link instanceof Note) {
                    String[] parts = model_.getLabelParts("note", ref);
                    _makeRefFloat(id, parts, label, buffer);
                } else {
                    _makeRefFloat(id, "*unknown element*", null, buffer);
                }
            } else {
                _makeRefFloat(href, "*unresolved reference*", null, buffer);
            }
            break;
        case Ref.HYPER_LINK:
            if (UDoc.isAncestor(ref, Note.class)) {
                if (contents.length > 0) {
                    buffer.append(
                        refHandler_.getHyperLinkTitle(href, _getString(ref))
                    );
                } else {
                    buffer.append(
                        refHandler_.getHyperLinkTitle(href)
                    );
                }
            } else {
                if (contents.length > 0) {
                    buffer.append(
                        refHandler_.getHyperLink(href, _getString(ref))
                    );
                } else {
                    buffer.append(
                        refHandler_.getHyperLink(href)
                    );
                }
            }
            break;
        case Ref.SITE_LINK:
        case Ref.UNKNOWN_LINK:    
            _makeRefFloat(href, "*unresolved reference*", null, buffer);
        default:
            throw new SmartDocErrorException();
        }
    }

    protected void _makeRefFloat(
        String href,
        String prefix,
        String label,
        StringBuffer buffer
    ) {
        if (label != null) {
            buffer.append(refHandler_.getSelfLinkFloat(href, prefix, label));
        } else {
            buffer.append(refHandler_.getSelfLinkFloat(href, prefix));
        }
    }

    protected void _makeRefFloat(
        String href,
        String[] parts,
        String label,
        StringBuffer buffer
    ) {
        if (label != null) {
            buffer.append(
                refHandler_.getSelfLinkFloat(href, parts, label)
            );
        } else {
            buffer.append(refHandler_.getSelfLinkFloat(href, parts));
        }
    }

    protected void _makeCite(Cite cite, StringBuffer buffer) {
        Content[] contents = cite.getContents();
        Content target = cite.getLink();
//        String id = _getIdref(cite);
        String id;
        if (target == null) {
            id = "*unresolved*";
        } else {
            id = _getID(target);
        }
        buffer.append("\\cite");
        if (contents.length > 0) {
            buffer.append("[");
            _makeString(cite, buffer);
            buffer.append("]");
        }
        buffer.append("{");
        buffer.append(id);
        buffer.append("}");
    }

    protected void _makeComment(Comment comment, StringBuffer buffer) {
        if (true) {
            buffer.append("\\marginpar{\\footnotesize ");
            _makeString(comment, buffer);
            buffer.append("}");
        } else {
            buffer.append("\n");
            String boxBegin = boxHandler_.makeCommentBegin();
            if (boxBegin != null) {
                buffer.append(boxBegin);
            }
            _makeString(comment, buffer);
            String boxEnd = boxHandler_.makeCommentEnd();
            if (boxEnd != null) {
                buffer.append(boxEnd);
            }
            buffer.append("\n");
        }
    }

    protected void _makeNote(Note note, StringBuffer buffer) {
        if (isTableMode_) {
            buffer.append("\\minipagetblfootnote{");
            _makeString(note, buffer);
            buffer.append("}");
        } else {
            String id = note.getExplicitID();
            buffer.append("\\footnote{");
            if (id != null) {
                id = _getID(note);
                buffer.append("\\label{");
                buffer.append(id);
                buffer.append("}");
            }
            _makeString(note, buffer);
            buffer.append("}");
        }
    }

    protected void _makeNative(Native n, StringBuffer buffer) {
        _embedStyleBegin(n, buffer);
        super._makeNative(n, buffer);
        _embedStyleEnd(n, buffer);
    }

    protected void _makeExternalElement(
        ExternalElement external,
        StringBuffer buffer
    ) {
        Element element = external.getElement();
        String namespaceURI = element.getNamespaceURI();
        if (namespaceURI == null) {
            super._makeExternalElement(external, buffer);
        } else {
            if ("http://www.w3.org/1998/Math/MathML".equals(namespaceURI)) {
                if (UDoc.isAncestor(external, Equation.class)) {
                    _makeMathML(element, buffer);
                } else {
                    buffer.append("$");
                    _makeMathML(element, buffer);
                    buffer.append("$");
                }
            } else {
                super._makeExternalElement(external, buffer);
            }
        }
    }

    protected void _makeMathML(Element element, StringBuffer buffer) {
        MMath math = new MMath(element);
        LaTeXMaker maker = new LaTeXMaker();
        URVisitor.traverse(math, maker);
        buffer.append(maker.getText());
    }

    protected void _generateImageArtifacts(
        ImageFigure image,
        GeneratorResult result
    ) {
        super._generateImageArtifacts(image, result);
        result.addArtifacts(imageHandler_.generateArtifacts(image));
    }

    protected void _generateImageArtifacts(
        Img image,
        GeneratorResult result
    ) {
        super._generateImageArtifacts(image, result);
        result.addArtifacts(imageHandler_.generateArtifacts(image));
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
            if (line.equals("// <em>")) {
                buffer.append("\\underline{");
            } else if (line.equals("// </em>")) {
                buffer.append("}");
            } else if (line.startsWith("// <em>")) {
                em = line.substring("// <em>".length(), line.indexOf("</em>"));
            } else {
                if (em != null) {
                    int index = line.indexOf(em);
                    buffer.append(line.substring(0, index));
                    buffer.append("\\underline{");
                    buffer.append(line.substring(index, index + em.length()));
                    buffer.append("}");
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
        String prompt = ">";        // XXX
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
                    buffer.append("\\underline{");
                    buffer.append(line.substring(index + prompt.length()));
                    buffer.append("}");
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
        return (ULaTeX2e.escape(string));
    }

    protected String _escape0(String string) {
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            switch (c) {

            case '\\':
                buffer.append("\\(\\backslash\\)");
                break;
            case '{':
                buffer.append("{\\{}");
                break;
            case '}':
                buffer.append("{\\}}");
                break;
            case '$':
                buffer.append("{\\$}");
                break;
            case '&':
                buffer.append("{\\&}");
                break;
            case '#':
                buffer.append("{\\#}");
                break;
            case '_':
                buffer.append("{\\_}");
                break;
            case '^':
//                buffer.append("{\\textasciicircum}");
                buffer.append("{\\^{}}");
                break;
            case '%':
                buffer.append("{\\%}");
                break;
            case '~':
//                buffer.append("{\\textasciitilde}");
                buffer.append("{\\~{}}");
                break;
            case '<':
//                buffer.append("{\\textless}");
                buffer.append("\\(<\\)");
                break;
            case '>':
//                buffer.append("{\\textgreater}");
                buffer.append("\\(>\\)");
                break;
            case '|':
//                buffer.append("{\\textbar}");
                buffer.append("\\(|\\)");
                break;
            default:
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    /**
     * @deprecated
     */
    protected String _escapeAlltt(String string) {
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            switch (c) {

            case '\\':
                buffer.append("\\(\\backslash\\)");
                break;
            case '{':
                buffer.append("{\\{}");
                break;
            case '}':
                buffer.append("{\\}}");
                break;
            default:
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    protected String _escapeHref(String string) {
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            switch (c) {

            case '\\':
                buffer.append("\\(\\backslash\\)");
                break;
            case '{':
                buffer.append("{\\{}");
                break;
            case '}':
                buffer.append("{\\}}");
                break;
            case '$':
                buffer.append("{\\$}");
                break;
            case '&':
                buffer.append("{\\&}");
                break;
            case '#':
                buffer.append("{\\#}");
                break;
            case '_':
                buffer.append("\\_");
                break;
            case '^':
//                buffer.append("{\\textasciicircum}");
                buffer.append("{\\^{}}");
                break;
            case '%':
                buffer.append("{\\%}");
                break;
            case '~':
//                buffer.append("{\\textasciitilde}");
                buffer.append("{\\~{}}");
                break;
            case '<':
//                buffer.append("{\\textless}");
                buffer.append("\\(<\\)");
                break;
            case '>':
//                buffer.append("{\\textgreater}");
                buffer.append("\\(>\\)");
                break;
            case '|':
//                buffer.append("{\\textbar}");
                buffer.append("\\(|\\)");
                break;
            default:
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    /**
     * This method should be called after _checkDoc.
     */
    protected String _getDocumentClass() {
        if (documentClass_ != null) {
            return (documentClass_.getDefault());
        }
        if (documentType_ == null) {
            documentType_ = _guessDocumentType();
        }
        if ("article".equals(documentType_)) {
            return (classArticle_.getDefault());
        } else if ("report".equals(documentType_)) {
            return (classReport_.getDefault());
        } else if ("book".equals(documentType_)) {
            return (classBook_.getDefault());
        } else {
            throw (new InternalError()); // error
        }
    }

    /**
     * This method should be called after _checkDoc.
     */
    protected String _getDocumentClass(Locale locale) {
        if (documentClass_ != null) {
            return (documentClass_.get(locale));
        }
        if (documentType_ == null) {
            documentType_ = _guessDocumentType();
        }
        if ("article".equals(documentType_)) {
            return (classArticle_.get(locale));
        } else if ("report".equals(documentType_)) {
            return (classReport_.get(locale));
        } else if ("book".equals(documentType_)) {
            return (classBook_.get(locale));
        } else {
            throw (new InternalError()); // error
        }
    }

    protected String _guessDocumentType() {
        if (usePart_ || useChapter_) {
            return ("report");
        } else {
            return ("article");
        }
    }

    protected void _embedCaption(Content content, StringBuffer buffer) {
        Title title = content.getTitleNode();
        if (title != null) {
            buffer.append("\\caption{");
            _makeString(title, buffer);
            buffer.append("}");
            _embedNewline(buffer);
            _embedLabel(content, buffer);
            _embedNewline(buffer);
        }
    }
/*
    protected void _embedCaption(Content content, StringBuffer buffer) {
        if (!(content instanceof FloatingObject)) {
            return;
        }
        FloatingObject fo = (FloatingObject)content;
        String caption = fo.getTitle();
        if (caption != null) {
            _embedCommand("caption", _escape(caption), buffer);
            _embedNewline(buffer);
            _embedLabel(content, buffer);
            _embedNewline(buffer);
        }
    }
*/

    protected void _embedLabel(Content content, StringBuffer buffer) {
        String id = _getID(content);
        String caption = null;
        if (content instanceof FloatingObject) {
            caption = content.getTitle();
        }
        String label;
        if (id != null) {
            label = id;
        } else {
            label = caption;
        }
        buffer.append(refHandler_.getLinkTarget(label, ""));
        _embedCommand("label", label, buffer);
        _embedNewline(buffer);
    }

    protected void _embedCommand(String command, StringBuffer buffer) {
        buffer.append("\\");
        buffer.append(command);
        buffer.append(" ");
    }

    protected void _embedCommand(
        String command,
        String arg,
        StringBuffer buffer
    ) {
        buffer.append("\\");
        buffer.append(command);
        buffer.append("{");
        buffer.append(arg);
        buffer.append("}");
    }

    protected void _embedCommand(
        String command,
        Container container,
        StringBuffer buffer
    ) {
        _embedStyleBegin(container, buffer);
        buffer.append("\\");
        buffer.append(command);
        buffer.append("{");
        _makeString(container, buffer);
        buffer.append("}");
        _embedStyleEnd(container, buffer);
    }

    protected void _embedEnvironment(String environment, StringBuffer buffer) {
        buffer.append("\\begin{");
        buffer.append(environment);
        buffer.append("}\n");
        buffer.append("\\end{");
        buffer.append(environment);
        buffer.append("}\n");
    }

    protected void _embedEnvironment(
        String environment,
        String content,
        StringBuffer buffer
    ) {
        buffer.append("\\begin{");
        buffer.append(environment);
        buffer.append("}\n");
        buffer.append(content);
        buffer.append("\\end{");
        buffer.append(environment);
        buffer.append("}\n");
    }

    protected void _embedEnvironment(
        String environment,
        Container container,
        StringBuffer buffer
    ) {
        buffer.append("\\begin{");
        buffer.append(environment);
        buffer.append("}\n");
        _embedStyleBegin(container, buffer);
        _makeString(container, buffer);        // trim
        buffer.append("\n");
        _embedStyleEnd(container, buffer);
        buffer.append("\\end{");
        buffer.append(environment);
        buffer.append("}\n");
    }

    protected void _embedEnvironmentWithLabel(
        String environment,
        Container container,
        StringBuffer buffer
    ) {
        buffer.append("\\begin{");
        buffer.append(environment);
        buffer.append("}\n");
        if (container.hasReferer()) {
            _embedLabel(container, buffer);
        }
        _embedStyleBegin(container, buffer);
        _makeString(container, buffer);        // trim
        buffer.append("\n");
        _embedStyleEnd(container, buffer);
        buffer.append("\\end{");
        buffer.append(environment);
        buffer.append("}\n");
    }

    protected void _embedStyleBegin(Content content, StringBuffer buffer) {
        _embedStyleBegin(content, null, buffer);
    }

    protected void _embedStyleBegin(
        Content content,
        CSSStyle defaultStyle,
        StringBuffer buffer
    ) {
        CSSStyle style = content.getStyle();
        String textAlign = null;
        CSSFont font = null;
        CSSColor color = null;
        CSSColor background = null;
        if (style != null) {
            textAlign = style.getTextAlign();
            font = style.getFont();
            color = style.getColor();
            background = style.getBackgroundColor();
        }
        if (defaultStyle != null) {
            if (textAlign == null) {
                textAlign = defaultStyle.getTextAlign();
            }
            if (font == null) {
                font = defaultStyle.getFont();
            }
            if (color == null) {
                color = defaultStyle.getColor();
            }
            if (background == null) {
                background = defaultStyle.getBackgroundColor();
            }
        }
        if (textAlign == null &&
            font == null &&
            color == null &&
            background == null) {

            return;
        }
        buffer.append(imageHandler_.makeStyleBegin(style));
        if (background != null) {
            buffer.append("\\colorbox[rgb]{");
            buffer.append((float)background.getRed() / 255.0f);
            buffer.append(",");
            buffer.append((float)background.getGreen() / 255.0f);
            buffer.append(",");
            buffer.append((float)background.getBlue() / 255.0f);
            buffer.append("}{");
        }
        if (color != null) {
            buffer.append("\\textcolor[rgb]{");
            buffer.append((float)color.getRed() / 255.0f);
            buffer.append(",");
            buffer.append((float)color.getGreen() / 255.0f);
            buffer.append(",");
            buffer.append((float)color.getBlue() / 255.0f);
            buffer.append("}{");
        }
        if (font != null) {
            buffer.append("{");
            String logicalFontSize = font.getLogicalFontSize();
            if ("xx-small".equals(logicalFontSize)) {
                buffer.append("\\scriptsize ");
            } else if ("x-small".equals(logicalFontSize)) {
                buffer.append("\\footnotesize ");
            } else if ("small".equals(logicalFontSize)) {
                buffer.append("\\small ");
            } else if ("normal".equals(logicalFontSize)) {
                buffer.append("\\normalsize ");
            } else if ("large".equals(logicalFontSize)) {
                buffer.append("\\large ");
            } else if ("x-large".equals(logicalFontSize)) {
                buffer.append("\\Large ");
            } else if ("xx-large".equals(logicalFontSize)) {
                buffer.append("\\LARGE ");
            } else {
                throw (new InternalError()); // XXX
            }
        }
        if (textAlign != null) {
            if ("left".equals(textAlign)) {
                buffer.append("\\begin{flushleft}\n");
            } else if ("right".equals(textAlign)) {
                buffer.append("\\begin{flushright}\n");
            } else if ("center".equals(textAlign)) {
                buffer.append("\\begin{center}\n");
            }
        }
    }

    protected void _embedStyleEnd(Content content, StringBuffer buffer) {
        _embedStyleEnd(content, null, buffer);
    }

    protected void _embedStyleEnd(
        Content content,
        CSSStyle defaultStyle,
        StringBuffer buffer
    ) {
        CSSStyle style = content.getStyle();
        String textAlign = null;
        CSSFont font = null;
        CSSColor color = null;
        CSSColor background = null;
        if (style != null) {
            textAlign = style.getTextAlign();
            font = style.getFont();
            color = style.getColor();
            background = style.getBackgroundColor();
        }
        if (defaultStyle != null) {
            if (textAlign == null) {
                textAlign = defaultStyle.getTextAlign();
            }
            if (font == null) {
                font = defaultStyle.getFont();
            }
            if (color == null) {
                color = defaultStyle.getColor();
            }
            if (background == null) {
                background = defaultStyle.getBackgroundColor();
            }
        }
        if (textAlign == null &&
            font == null &&
            color == null &&
            background == null) {

            return;
        }
        if (textAlign != null) {
            if ("left".equals(textAlign)) {
                buffer.append("\\end{flushleft}\n");
            } else if ("right".equals(textAlign)) {
                buffer.append("\\end{flushright}\n");
            } else if ("center".equals(textAlign)) {
                buffer.append("\\end{center}\n");
            }
        }
        if (font != null) {
            buffer.append("}");
        }
        if (color != null) {
            buffer.append("}");
        }
        if (background != null) {
            buffer.append("}");
        }
        buffer.append(imageHandler_.makeStyleEnd(style));
    }

    protected void _embedNewline(StringBuffer buffer) {
        buffer.append("\n");        // XXX
    }

    // AbstractYaGenerator
    protected void _prepareDoc(Doc doc) {
        _checkContainer(doc.getBody());
    }

    protected void _checkContainer(Container container) {
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            CSSStyle style = content.getStyle();
            if (style != null) {
                if (style.getColor() != null ||
                    style.getBackgroundColor() != null) {

                    useColor_ = true;
                }
                if (style.getWidth() != null ||
                    style.getHeight() != null) {

                    useImage_ = true;
                }
            }
            if (content instanceof ImageFigure) {
                useImage_ = true;
            } else if (content instanceof Img) {
                useImage_ = true;
            } else if (content instanceof Table) {
                useTable_ = true;
                if (_isLongTable((Table)content)) {
                    useLongTable_ = true;
                }
            } else if (content instanceof Program) {
                useProgram_ = true;
            } else if (content instanceof Console) {
                useConsole_ = true;
            } else if (content instanceof Part) {
                usePart_ = true;
            } else if (content instanceof Chapter) {
                useChapter_ = true;
            } else if (content instanceof Span) {
                if (((Span)content).getRuby() != null) {
                    useRuby_ = true;
                }
            }
            if (content instanceof Container) {
                _checkContainer((Container)content);
            }
        }
    }

    private String _getID(Content content) {
        if (config_.isIdGlobal()) {
            String id = content.getExplicitID();
            if (id != null) {
                return (id);
            }            
        }
        return (UDoc.getAbsoluteId(content));
    }

    private String _getIdref(Content content) {
        if (config_.isIdGlobal()) {
            return (content.getIdref());
        }
        return (UDoc.getAbsoluteIdref(content));
    }

/*
    private String _getID(Content content) {
        DocContext context = content.getDocContext();
        return (context.getID() + ":" + content.getID());
    }

    private String _getIdref(Content content) {
        DocContext context = content.getDocContext();
        return (context.getID() + ":" + content.getIdref());
    }
*/
}
