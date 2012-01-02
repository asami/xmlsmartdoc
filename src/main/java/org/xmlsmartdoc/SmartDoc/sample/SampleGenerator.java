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
package org.xmlsmartdoc.SmartDoc.sample;

import org.xmlsmartdoc.SmartDoc.Abbr;
import org.xmlsmartdoc.SmartDoc.AbstractStringBufferSmartDocGeneratorBase;
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
import org.xmlsmartdoc.SmartDoc.Chapter;
import org.xmlsmartdoc.SmartDoc.Cite;
import org.xmlsmartdoc.SmartDoc.Code;
import org.xmlsmartdoc.SmartDoc.Comment;
import org.xmlsmartdoc.SmartDoc.Console;
import org.xmlsmartdoc.SmartDoc.Container;
import org.xmlsmartdoc.SmartDoc.Dd;
import org.xmlsmartdoc.SmartDoc.Dfn;
import org.xmlsmartdoc.SmartDoc.Div;
import org.xmlsmartdoc.SmartDoc.Dl;
import org.xmlsmartdoc.SmartDoc.Doc;
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
import org.xmlsmartdoc.SmartDoc.SmartDocModel;
import org.xmlsmartdoc.SmartDoc.Span;
import org.xmlsmartdoc.SmartDoc.Strong;
import org.xmlsmartdoc.SmartDoc.SubSection;
import org.xmlsmartdoc.SmartDoc.SubSubSection;
import org.xmlsmartdoc.SmartDoc.Table;
import org.xmlsmartdoc.SmartDoc.Term;
import org.xmlsmartdoc.SmartDoc.Tt;
import org.xmlsmartdoc.SmartDoc.Ul;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;

/**
 * SampleGenerator
 *
 * @since   Apr. 20, 1999
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SampleGenerator extends AbstractStringBufferSmartDocGeneratorBase {
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

    protected void _makePrologue(Head head, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeEpilogue(Head head, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeHead(Head head, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeBodyPrologue(
        Head head,
        Body body,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeBodyEpilogue(
        Head head,
        Body body,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeTitle(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeTOC(Container container, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeBibliographyPrologue(
        Bibliography bib,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }        

    protected void _makeBibliographyEpilogue(
        Bibliography bib,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeBook(Book book, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeArticle(Article article, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeJournal(Journal journal, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeBibMisc(BibMisc misc, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeIndex(
        Head head,
        Body body,
        Indexdef indexdef,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeSentence(
        Sentence sentence,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeParagraph(Paragraph p, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makePartPrologue(Part part, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makePartEpilogue(Part part, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeChapterPrologue(Chapter chapter, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeChapterEpilogue(Chapter chapter, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeSectionPrologue(Section section, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeSectionEpilogue(Section section, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeSubSectionPrologue(
        SubSection subsection,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeSubSectionEpilogue(
        SubSection subsection,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeSubSubSectionPrologue(
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeSubSubSectionEpilogue(
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeAppendix(
        Appendix appendix,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeFYI(
        FYI fyi,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeUl(Ul ul, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeOl(Ol ol, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeLi(Li li, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeDl(Dl dl, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeDt(Dt dt, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeDd(Dd dd, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeTable(Table table, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeImg(Img img, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeImage(ImageFigure image, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeSpan(Span span, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeTerm(Term term, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeIndex(Index index, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeBold(Bold bold, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeItalic(Italic italic, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeDfn(Dfn dfn, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeTt(Tt tt, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeEm(Em em, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeStrong(Strong strong, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeAbbr(Abbr abbr, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeAcronym(Acronym acronym, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeCode(Code code, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeBlockquote(
        Blockquote blockquote,
        StringBuffer buffer
    ) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeQuote(Quote quote, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeAnchor(Anchor anchor, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makePre(Pre pre, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeProgram(Program program, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeConsole(Console console, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeEquation(Equation equation, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeDiv(Div div, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeRef(Ref ref, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeCite(Cite cite, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeComment(Comment comment, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected void _makeNote(Note note, StringBuffer buffer) {
        throw (new UnsupportedOperationException());
    }

    protected String _escape(String string) {
        throw (new UnsupportedOperationException());
    }
}
