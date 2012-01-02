/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2006  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.forrest;

import javax.xml.parsers.ParserConfigurationException;

import org.relaxer.vocabulary.forrest_0_5.document_v12.FdAuthors;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdBody;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdCaption;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdCode;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdDd;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdDl;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdDlSequence;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdDocument;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdDt;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdEm;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdFigure;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdFork;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdHeader;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdJump;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdLi;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdLink;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdOl;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdP;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdPerson;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdSection;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdSource;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdStrong;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdTable;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdTd;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdTh;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdTitle;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdTr;
import org.relaxer.vocabulary.forrest_0_5.document_v12.FdUl;
import org.relaxer.vocabulary.forrest_0_5.document_v12.IFdBodyChoice;
import org.relaxer.vocabulary.forrest_0_5.document_v12.IFdContentMixMixed;
import org.relaxer.vocabulary.forrest_0_5.document_v12.IFdFlowMixed;
import org.relaxer.vocabulary.forrest_0_5.document_v12.IFdLinkContentMixMixed;
import org.relaxer.vocabulary.forrest_0_5.document_v12.IFdOlChoice;
import org.relaxer.vocabulary.forrest_0_5.document_v12.IFdSectionChoice;
import org.relaxer.vocabulary.forrest_0_5.document_v12.IFdTitleMixed;
import org.relaxer.vocabulary.forrest_0_5.document_v12.IFdUlChoice;
import org.w3c.dom.Element;
import org.xmlsmartdoc.SmartDoc.Abbr;
import org.xmlsmartdoc.SmartDoc.AbstractContextSmartDocGeneratorBase;
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
import org.xmlsmartdoc.SmartDoc.Dt;
import org.xmlsmartdoc.SmartDoc.Em;
import org.xmlsmartdoc.SmartDoc.Equation;
import org.xmlsmartdoc.SmartDoc.ExternalElement;
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
import org.xmlsmartdoc.SmartDoc.Paragraph;
import org.xmlsmartdoc.SmartDoc.Part;
import org.xmlsmartdoc.SmartDoc.Pre;
import org.xmlsmartdoc.SmartDoc.Program;
import org.xmlsmartdoc.SmartDoc.Quote;
import org.xmlsmartdoc.SmartDoc.Ref;
import org.xmlsmartdoc.SmartDoc.Section;
import org.xmlsmartdoc.SmartDoc.Sentence;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocErrorException;
import org.xmlsmartdoc.SmartDoc.SmartDocFormatConfig;
import org.xmlsmartdoc.SmartDoc.Span;
import org.xmlsmartdoc.SmartDoc.Strong;
import org.xmlsmartdoc.SmartDoc.SubSection;
import org.xmlsmartdoc.SmartDoc.SubSubSection;
import org.xmlsmartdoc.SmartDoc.Table;
import org.xmlsmartdoc.SmartDoc.Td;
import org.xmlsmartdoc.SmartDoc.Term;
import org.xmlsmartdoc.SmartDoc.Th;
import org.xmlsmartdoc.SmartDoc.TimeCommand;
import org.xmlsmartdoc.SmartDoc.Title;
import org.xmlsmartdoc.SmartDoc.TitledBlock;
import org.xmlsmartdoc.SmartDoc.Tt;
import org.xmlsmartdoc.SmartDoc.UDoc;
import org.xmlsmartdoc.SmartDoc.USmartDoc;
import org.xmlsmartdoc.SmartDoc.Ul;

import com.AsamiOffice.util.D2Array;
import com.AsamiOffice.xml.XMLMaker;
import com.AsamiOffice.xml.visitor.DOMVisitorException;
import com.AsamiOffice.xml.visitor.UDOMVisitor;

/**
 * DocumentV12Generator
 *
 * @since   May.  3, 2004
 * @version Feb.  8, 2006
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class DocumentV12Generator extends AbstractContextSmartDocGeneratorBase {
    protected DocumentV12Config doc12Config_;
    protected FdHeader fdHeader_;

    public void init(SmartDocConfig config, SmartDocFormatConfig fconfig) {
        super.init(config, fconfig);
        doc12Config_ = (DocumentV12Config)fconfig;
    }

    protected Object _getRootContext(Doc doc) {
        FdDocument fdDocument = new FdDocument();
        fdDocument.setXmlLang(doc.getLanguage());
        return (fdDocument);
    }

    protected void _makeBuffer(
        Object context, 
        Doc doc,
        StringBuffer buffer
    ) {
        XMLMaker maker = new XMLMaker();
        maker.setVisual(true);
        maker.setPublicId("-//APACHE//DTD Documentation V1.2//EN");
        maker.setSystemId("http://apache.org/forrest/dtd/document-v12.dtd");
        String encoding = formatConfig_.getEncoding(doc);
        if (encoding != null) {
            maker.setEncoding(encoding);
        }
        maker.addMixedElement("p");
        try {
            UDOMVisitor.traverse(((FdDocument)context).makeDocument(), maker);
        } catch (DOMVisitorException e) {
            throw (new SmartDocErrorException(e));
        } catch (ParserConfigurationException e) {
            throw (new SmartDocErrorException(e));
        }
        buffer.append(maker.getText());
    }

    protected void _makeHead(Head head, Object context) {
        FdDocument fdDoc = (FdDocument)context;
        fdHeader_ = new FdHeader();
        fdDoc.setHeader(fdHeader_);
        FdTitle fdTitle = new FdTitle();
        fdHeader_.setTitle(fdTitle);
        DocAuthor[] authors = head.getAuthors();
        if (authors != null && authors.length > 0) {
            FdAuthors fdAuthors = new FdAuthors();
            for (int i = 0;i < authors.length;i++) {
                FdPerson fdPerson = new FdPerson();
                fdPerson.setName(authors[i].getText()); // TODO
                fdPerson.setEmail(authors[i].getEMail());
            }
        }
        _makeContainer(head.getDocTitle(), fdTitle);
        // FdSubtitle fdSubtitle = ;
        // FdAbstract fdAbstract = ;
    }

    protected void _makeArticleBody(Body body, Object context) {
        FdDocument fdDocument = (FdDocument)context;
        FdBody fdBody = new FdBody();
        fdDocument.setBody(fdBody);
        _makeContainer(body, fdBody);
        IFdBodyChoice[] contents = fdBody.getContent();
        if (contents.length == 0) {
            fdBody.addContent(new FdP());
        }
    }

    protected void _makeTitle(Head head, Container container, Object context) {
    }

    protected void _makeTOC(Container container, Object context) {
    }

    protected void _makeBibliographyPrologue(Bibliography bib, Object context) {
    	String msg = "bib.getText()=\"" + bib.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeBibliographyEpilogue(Bibliography bib, Object context) {
    	String msg = "bib.getText()=\"" + bib.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeBook(Book book, Object context) {
    	String msg = "book.getText()=\"" + book.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeArticle(Article article, Object context) {
    	String msg = "article.getText()=\"" + article.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeJournal(Journal journal, Object context) {
    	String msg = "journal.getText()=\"" + journal.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeBibMisc(BibMisc bibMisc, Object context) {
    	String msg = "bibMisc.getText()=\"" + bibMisc.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeIndex(Head head, Body body, Indexdef indexdef, Object context) {
    }

    protected void _makeSentence(Sentence sentence, Object context) {
        _makeContainer(sentence, context);
    }

    protected void _makeParagraph(Paragraph p, Object context) {
        FdP fdP = new FdP();
        addContent_(fdP, context);
        _makeContainer(p, fdP);
    }

    protected void _makePartBody(Part part, Object context) {
        makeFdSection_(part, context);
    }

    protected void _makeChapterBody(Chapter chapter, Object context) {
        makeFdSection_(chapter, context);
    }

    protected void _makeSectionBody(Section section, Object context) {
        makeFdSection_(section, context);
    }

    protected void _makeSubSectionBody(SubSection subsection, Object context) {
        makeFdSection_(subsection, context);
    }

    protected void _makeSubSubSectionBody(SubSubSection subsubsection, Object context) {
        makeFdSection_(subsubsection, context);
    }

    protected void _makeAppendix(Appendix appendix, Object context) {
        makeFdSection_(appendix, context);
    }

    protected void _makeFYI(FYI fyi, Object context) {
    	String msg = "fyi.getText()=\"" + fyi.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeUl(Ul ul, Object context) {
        FdUl fdUl = new FdUl();
        addContent_(fdUl, context);
        _makeContainer(ul, fdUl);
    }

    protected void _makeOl(Ol ol, Object context) {
        FdOl fdOl = new FdOl();
        addContent_(fdOl, context);
        _makeContainer(ol, fdOl);
    }

    protected void _makeLi(Li li, Object context) {
        FdLi fdLi = new FdLi();
        addContent_(fdLi, context);
        _makeContainer(li, fdLi);
    }

    protected void _makeDl(Dl dl, Object context) {
        FdDl fdDl = new FdDl();
        addContent_(fdDl, context);
        Content[] contents = dl.getContents();
        FdDt fdDt = null;
        for (int i = 0; i < contents.length; i++) {
            Content content = contents[i];
            if (content instanceof Dt) {
                fdDt = new FdDt();
                _makeContainer((Dt)content, fdDt);
            } else if (content instanceof Dd) {
                FdDlSequence pair = new FdDlSequence();
                fdDl.addDlSequence(pair);
                pair.setDt(fdDt);
                FdDd fdDd = new FdDd();
                pair.setDd(fdDd);
                _makeContainer((Dd)content, fdDd); 
            } else {
                // TODO
            }
//            _makeContent(contents[i], context);
        }
    }

    protected void _makeDt(Dt dt, Object context) {
        FdDt fdDt = new FdDt();
        addContent_(fdDt, context);
        _makeContainer(dt, fdDt);
    }

    protected void _makeDd(Dd dd, Object context) {
        FdDd fdDd = new FdDd();
        addContent_(fdDd, context);
        _makeContainer(dd, fdDd);
    }

    protected void _makeTable(Table table, Object context) {
        FdTable fdTable = new FdTable();
        addContent_(fdTable, context);
        fdTable.setId(table.getID());
        Title title = table.getTitleNode();
        if (title != null) {
            FdCaption fdCaption = new FdCaption();
            fdTable.setCaption(fdCaption);
            _makeContainer(title, fdCaption);
        }
        makeTableRecords_(fdTable, table.getHeadData()); 
        makeTableRecords_(fdTable, table.getBodyData()); 
        makeTableRecords_(fdTable, table.getFootData()); 
    }

    private void makeTableRecords_(FdTable fdTable, D2Array array) {
        if (array == null) {
            return;
        }
        int width = array.getWidth();
        int height = array.getHeight();
        for (int y = 0;y < height;y++) {
            FdTr fdTr = new FdTr();
            fdTable.addTr(fdTr);
            for (int x = 0;x < width;x++) {
                Content content = (Content)array.get(x, y);
                if (content == null) {
                    // do nothing
                } else if (content instanceof Th) {
                    Th th = (Th)content;
                    FdTh fdTh = new FdTh();
                    fdTh.setColspan(Integer.toString(th.getColSpan()));
                    fdTh.setRowspan(Integer.toString(th.getRowSpan()));
                    fdTr.addContent(fdTh);
                    _makeContainer((Th)content, fdTh);
                } else if (content instanceof Td){
                    Td td = (Td)content;
                    FdTd fdTd = new FdTd();
                    fdTd.setColspan(Integer.toString(td.getColSpan()));
                    fdTd.setRowspan(Integer.toString(td.getRowSpan()));
                    fdTr.addContent(fdTd);
                    _makeContainer((Td)content, fdTd);
                } else {
                    throw (new SmartDocErrorException());
                }
            }
        }
    }

    protected void _makeImg(Img image, Object context) {
    	String msg = "image.getText()=\"" + image.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeImage(ImageFigure image, Object context) {
        FdFigure fdFigure = new FdFigure();
        addContent_(fdFigure, context);
        fdFigure.setId(image.getID());
        fdFigure.setSrc(image.getSrc());
        String alt = image.getTitle();
        if (alt == null) {
            alt = "";
        }
        fdFigure.setAlt(alt);
    }

    protected void _makeSpan(Span span, Object context) {
        _makeContainer(span, context);
    }

    protected void _makeTerm(Term term, Object context) {
        FdStrong fdStrong = new FdStrong();
        addContent_(fdStrong, context);
        _makeContainer(term, fdStrong);
    }

    protected void _makeIndex(Index index, Object context) {
        FdStrong fdStrong = new FdStrong();
        addContent_(fdStrong, context);
        _makeContainer(index, fdStrong);
    }

    protected void _makeBold(Bold bold, Object context) {
        FdStrong fdStrong = new FdStrong();
        addContent_(fdStrong, context);
        _makeContainer(bold, fdStrong);
    }

    protected void _makeItalic(Italic italic, Object context) {
        FdEm fdEm = new FdEm();
        addContent_(fdEm, context);
        _makeContainer(italic, fdEm);
    }

    protected void _makeDfn(Dfn dfn, Object context) {
        FdStrong fdStrong = new FdStrong();
        addContent_(fdStrong, context);
        _makeContainer(dfn, fdStrong);
    }

    protected void _makeTt(Tt tt, Object context) {
        FdCode fdCode = new FdCode();
        addContent_(fdCode, context);
        _makeContainer(tt, fdCode);
   }

    protected void _makeEm(Em em, Object context) {
        FdEm fdEm = new FdEm();
        addContent_(fdEm, context);
        _makeContainer(em, fdEm);
    }

    protected void _makeStrong(Strong strong, Object context) {
        FdStrong fdStrong = new FdStrong();
        addContent_(fdStrong, context);
        _makeContainer(strong, fdStrong);
    }

    protected void _makeAbbr(Abbr abbr, Object context) {
        FdEm fdEm = new FdEm();
        addContent_(fdEm, context);
        _makeContainer(abbr, fdEm);
    }

    protected void _makeAcronym(Acronym acronym, Object context) {
        FdEm fdEm = new FdEm();
        addContent_(fdEm, context);
        _makeContainer(acronym, fdEm);
    }

    protected void _makeCode(Code code, Object context) {
        FdCode fdCode = new FdCode();
        addContent_(fdCode, context);
        _makeContainer(code, fdCode);
    }

    protected void _makeBlockquote(Blockquote blockquote, Object context) {
        FdUl fdUl = new FdUl();
        addContent_(fdUl, context);
        FdLi fdLi = new FdLi();
        addContent_(fdLi, fdUl);
        _makeContainer(blockquote, fdLi);
    }

    protected void _makeQuote(Quote quote, Object context) {
        FdEm fdEm = new FdEm();
        addContent_(fdEm, context);
        _makeContainer(quote, fdEm);
    }

    protected void _makeCharBlock(CharBlock cblock, Object context) {
        addContent_(cblock.getText(), context);
    }

    protected void _makeAnchor(Anchor anchor, Object context) {
    	String msg = "anchor.getText()=\"" + anchor.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makePre(Pre pre, Object context) {
        FdSource source = new FdSource();
        addContent_(source, context);
        _makeContainer(pre, source);
    }

    protected void _makeProgram(Program program, Object context) {
        Title title = program.getTitleNode();
        if (title != null) {
            FdP p = new FdP();
            addContent_(p, context);
            FdStrong strong = new FdStrong();
            addContent_(strong, p);
            _makeContainer(title, strong);
        }
        FdSource source = new FdSource();
        addContent_(source, context);
        _makeContainer(program, source);
    }

    protected void _makeConsole(Console console, Object context) {
        FdSource source = new FdSource();
        addContent_(source, context);
        _makeContainer(console, source);
    }

    protected void _makeEquation(Equation equation, Object context) {
    	String msg = "equation.getText()=\"" + equation.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeDiv(Div div, Object context) {
        _makeContainer(div, context);
    }

    protected void _makeRef(Ref ref, Object context) {
        String siteLink = ref.getDocumentV12Href();
        if (siteLink != null) {
            FdJump fdJump = new FdJump();
            addContent_(fdJump, context);
            fdJump.setHref(siteLink);
            makeRefContentsSite_(ref, fdJump);
            return;
        }
        switch (ref.getType()) {
        case Ref.SELF_LINK:
            FdLink fdLink = new FdLink();
            addContent_(fdLink, context);
            fdLink.setHref("#" + ref.getHref());
            makeRefContentsSelf_(ref, fdLink);
            break;
        case Ref.HYPER_LINK: {
            FdJump fdJump = new FdJump();
            addContent_(fdJump, context);
            fdJump.setHref(ref.getHref());
            makeRefContentsHyper_(ref, fdJump);
            break;
        }
        case Ref.SITE_LINK: {
            FdJump fdJump = new FdJump();
            addContent_(fdJump, context);
            fdJump.setHref("site:" + ref.getHref());
            makeRefContentsSite_(ref, fdJump);
            break;
        }
        case Ref.UNKNOWN_LINK:
            FdFork fdFork = new FdFork();
            addContent_(fdFork, context);
            fdFork.setHref(ref.getHref());
            _makeContainer(ref, fdFork);
            break;
        default:
            throw (new SmartDocErrorException());
        }
    }

    private void makeRefContentsSelf_(Ref ref, FdLink fdLink) {
        boolean isComplete = false;
        if (ref.getContents().length > 0) {
            _makeContainer(ref, fdLink);
        } else {
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
                    isComplete = true;
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
                    String title = null;
                    if (link instanceof Book) {
                        title = ((Book)link).getTitle();
                    } else if (link instanceof Article) {
                        title = ((Article)link).getTitle();
                    }
                    fdLink.setTitle(title);
                    String number = UDoc.getSequenceNumberBasedSubSubSection(link);
                    StringBuffer buffer = new StringBuffer();
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
                    label = new String(buffer);
                    isComplete = true;
              } else if (link instanceof Note) {
                    Note note = (Note)link;
                    int number = note.getNumber();
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("(");
                    buffer.append(number);
                    buffer.append(")");
                    label = new String(buffer);
                } else {
                    label = "";
                }
                isComplete = true;
            } else {
                monitor_.warning("no link : " + ref.getHref());
                label = "*unresolved*";
                isComplete = true;
            }
            String srcFile = getLogicalFile(ref);
            String destFile = getLogicalFile(link);
            if (srcFile.equals(destFile)) {
                fdLink.setHref("#" + UDoc.getAbsoluteId(link));
            } else {
                fdLink.setHref(
                    destFile + "#" + UDoc.getAbsoluteId(link)
                );
            }
            StringBuffer buffer = new StringBuffer();
            buffer.append(label);
            if (link != null) {
//                   String number = UDoc.getSequenceNumber(link);
                if (!isComplete) {
                    String number = UDoc.getSequenceNumberLabel(link);
                    if (number != null) {
                        if (USmartDoc.isWordSeparate(label, number)) {
                            buffer.append(" ");
                        }
                        buffer.append(number);
                    }
                }
                String title = link.getTitle();
                if (title != null) {
                    if (USmartDoc.isWordSeparate(label, title)) {
                        buffer.append(" ");
                    }
                    buffer.append(title);
                }
            } else {
                monitor_.warning("no link : " + ref.getHref());
//                    label = "*unresolved*";
            }
            fdLink.addContent(new String(buffer));
        }
    }

    private void makeRefContentsHyper_(Ref ref, FdJump fdJump) {
        if (ref.getContents().length > 0) {
            _makeContainer(ref, fdJump);
        } else {
            fdJump.addContent(ref.getHref());
        }
    }

    private void makeRefContentsSite_(Ref ref, FdJump fdJump) {
        if (ref.getContents().length > 0) {
            _makeContainer(ref, fdJump);
        } else {
            fdJump.addContent("site:" + ref.getHref());
        }
    }

    protected void _makeCite(Cite cite, Object context) {
    	String msg = "cite.getText()=\"" + cite.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeComment(Comment comment, Object context) {
    	String msg = "comment.getText()=\"" + comment.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeNote(Note note, Object context) {
    	String msg = "note.getText()=\"" + note.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeNative(Native n, Object context) {
    	String msg = "n.getText()=\"" + n.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeTime(TimeCommand time, Object context) {
    	String msg = "time.getText()=\"" + time.getText() + "\"";
        throw (new UnsupportedOperationException(msg));
    }

    protected void _makeExternalElement(ExternalElement external, Object context) {
        Element element = external.getElement();
        String namespaceURI = element.getNamespaceURI();
        if (namespaceURI != null) {
            if ("http://www.xmlsmartdoc.org/xmlns/goldenport".equals(namespaceURI) ||
                "http://www.relaxer.org/xmlns/goldenport".equals(namespaceURI)) {
                return;
            } else if ("http://www.w3.org/1998/Math/MathML".equals(namespaceURI)) {
//                _makeMathMLElement(external, buffer);
            } else if ("http://www.w3.org/1999/xhtml".equals(namespaceURI)) {
//                buffer.append(UXMLMaker.getXMLText(element));
            }
        }
    }

    protected String _escape(String string) {
        if (string == null) {
            return ("");
        } else {
            return (string);
        }
/*
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
                buffer.append(c);
            }
        }
        return (new String(buffer));
*/
    }

    //
    private void addContent_(Object target, Object context) {
        if (context instanceof FdBody) {
            if (target instanceof IFdBodyChoice) {
                ((FdBody)context).addContent((IFdBodyChoice)target);
            } else {
                String message = target + " is illegal in <body>";
                monitor_.warning(message);
                FdP p = new FdP();
                p.addContent("[" + message + "]");
                ((FdBody)context).addContent(p);
            }
        } else if (context instanceof FdSection) {
            if (target instanceof IFdSectionChoice) {
                ((FdSection)context).addContent((IFdSectionChoice)target);
            } else {
                String message = target + " is illegal in <section>";
                monitor_.warning(message);
                FdP p = new FdP();
                p.addContent(message);
                ((FdSection)context).addContent(p);
            }
        } else if (context instanceof FdP) {
            if (target instanceof String) {
                ((FdP)context).addContent(_escape((String)target));                
            } else if (target instanceof IFdContentMixMixed) {
                ((FdP)context).addContent((IFdContentMixMixed)target);                
            } else {
                String message = target + " is illegal in <p>";
                monitor_.warning(message);
                ((FdP)context).addContent("[" + message + "]");
            }
        } else if (context instanceof FdTitle) {
            if (target instanceof String) {
                ((FdTitle)context).addContent(_escape((String)target));
            } else if (target instanceof IFdTitleMixed) {
                ((FdTitle)context).addContent((IFdTitleMixed)target);
            } else {
                String message = target + " is illegal in <title>";
                monitor_.warning(message);
                ((FdTitle)context).addContent("[" + message + "]");
            }
        } else if (context instanceof FdUl) {
            if (target instanceof IFdUlChoice) {
                ((FdUl)context).addContent((IFdUlChoice)target);
            } else {
                String message = target + " is illegal in <ul>";
                monitor_.warning(message);
                FdLi li = new FdLi();
                li.addContent("[" + message + "]");
                ((FdUl)context).addContent(li);
            }
        } else if (context instanceof FdOl) {
            if (target instanceof IFdOlChoice) {
                ((FdOl)context).addContent((IFdOlChoice)target);
            } else {
                String message = target + " is illegal in <ol>";
                monitor_.warning(message);
                FdLi li = new FdLi();
                li.addContent("[" + message + "]");
                ((FdOl)context).addContent(li);
            }
        } else if (context instanceof FdLi) {
            if (target instanceof String) {
                ((FdLi)context).addContent(_escape((String)target));
            } else if (target instanceof IFdFlowMixed) {
                ((FdLi)context).addContent((IFdFlowMixed)target);
            } else {
                String message = target + " is illegal in <li>";
                monitor_.warning(message);
                ((FdLi)context).addContent("[" + message + "]");
            }
        } else if (context instanceof FdDt) {
            if (target instanceof String) {
                ((FdDt)context).addContent(_escape((String)target));
            } else if (target instanceof IFdContentMixMixed) {
                ((FdDt)context).addContent((IFdContentMixMixed)target);
            } else {
                String message = target + " is illegal in <dt>";
                monitor_.warning(message);
                ((FdDt)context).addContent("[" + message + "]");
            }
        } else if (context instanceof FdDd) {
            if (target instanceof String) {
                ((FdDd)context).addContent(_escape((String)target));
            } else if (target instanceof IFdFlowMixed) {
                ((FdDd)context).addContent((IFdFlowMixed)target);
            } else {
                String message = target + " is illegal in <dd>";
                monitor_.warning(message);
                ((FdDd)context).addContent("[" + message + "]");
            }
        } else if (context instanceof FdTd) {
            if (target instanceof String) {
                ((FdTd)context).addContent(_escape((String)target));
            } else if (target instanceof IFdFlowMixed) {
                ((FdTd)context).addContent((IFdFlowMixed)target);
            } else {
                String message = target + " is illegal in <td>";
                monitor_.warning(message);
                ((FdTd)context).addContent("[" + message + "]");
            }
        } else if (context instanceof FdTh) {
            if (target instanceof String) {
                ((FdTh)context).addContent(_escape((String)target));
            } else if (target instanceof IFdFlowMixed) {
                ((FdTh)context).addContent((IFdFlowMixed)target);
            } else {
                String message = target + " is illegal in <th>";
                monitor_.warning(message);
                ((FdTh)context).addContent("[" + message + "]");
            }
        } else if (context instanceof FdCaption) {
            if (target instanceof String) {
                ((FdCaption)context).addContent(_escape((String)target));
            } else if (target instanceof IFdContentMixMixed) {
                ((FdCaption)context).addContent((IFdContentMixMixed)target);
            } else {
                String message = target + " is illegal in <caption>";
                monitor_.warning(message);
                ((FdCaption)context).addContent("[" + message + "]");
            }
        } else if (context instanceof FdLink) {
            if (target instanceof String) {
                ((FdLink)context).addContent(_escape((String)target));
            } else if (target instanceof IFdContentMixMixed) {
                ((FdLink)context).addContent((IFdLinkContentMixMixed)target);
            } else {
                String message = target + " is illegal in <link>";
                monitor_.warning(message);
                ((FdLink)context).addContent("[" + message + "]");
            }
        } else if (context instanceof FdJump) {
            if (target instanceof String) {
                ((FdJump)context).addContent(_escape((String)target));
            } else if (target instanceof IFdContentMixMixed) {
                ((FdJump)context).addContent((IFdLinkContentMixMixed)target);
            } else {
                String message = target + " is illegal in <jump>";
                monitor_.warning(message);
                ((FdJump)context).addContent("[" + message + "]");
            }
        } else if (context instanceof FdSource) {
            if (target instanceof String) {
                ((FdSource)context).addContent(_escape((String)target));
            } else if (target instanceof IFdContentMixMixed) {
                ((FdSource)context).addContent((IFdContentMixMixed)target);
            } else {
                String message = target + " is illegal in <source>";
                monitor_.warning(message);
                ((FdSource)context).addContent("[" + message + "]");
            }
        } else if (context instanceof FdCode) {
            if (target instanceof String) {
                ((FdCode)context).setContent(_escape((String)target));
            } else if (target instanceof IFdContentMixMixed) {
                String message = target + " is illegal in <code>";
                monitor_.warning(message);
                ((FdSource)context).addContent("[" + message + "]");
            } else {
                String message = target + " is illegal in <code>";
                monitor_.warning(message);
                ((FdSource)context).addContent("[" + message + "]");
            }
        } else if (context instanceof FdStrong) {
            if (target instanceof String) {
                ((FdStrong)context).addContent(_escape((String)target));
            } else if (target instanceof IFdContentMixMixed) {
                ((FdStrong)context).addContent((IFdContentMixMixed)target);
            } else {
                String message = target + " is illegal in <strong>";
                monitor_.warning(message);
                ((FdStrong)context).addContent("[" + message + "]");
            }
        } else if (context instanceof FdEm) {
            if (target instanceof String) {
                ((FdEm)context).addContent(_escape((String)target));
            } else if (target instanceof IFdContentMixMixed) {
                ((FdEm)context).addContent((IFdContentMixMixed)target);
            } else {
                String message = target + " is illegal in <em>";
                monitor_.warning(message);
                ((FdStrong)context).addContent("[" + message + "]");
            }
        } else {
            throw (new UnsupportedOperationException(context.toString()));
        }
    }

    private void makeFdSection_(
        TitledBlock block,
        Object context
    ) {
        FdSection fdSection = new FdSection();
        addContent_(fdSection, context);
        fdSection.setId(block.getID());
        fdSection.setXmlLang(block.getExplicitLanguage());
        FdTitle fdTitle = new FdTitle();
        fdSection.setTitle(fdTitle);
        Title title = block.getTitleNode();
        if (title != null) {
            _makeContainer(title, fdTitle);
        }
        _makeContainer(block, fdSection);
    }
}
