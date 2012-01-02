/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.xhtml;

import java.io.IOException;
import java.net.URL;

import org.xmlsmartdoc.SmartDoc.Anchor;
import org.xmlsmartdoc.SmartDoc.Blockquote;
import org.xmlsmartdoc.SmartDoc.Body;
import org.xmlsmartdoc.SmartDoc.Bold;
import org.xmlsmartdoc.SmartDoc.Chapter;
import org.xmlsmartdoc.SmartDoc.CharBlock;
import org.xmlsmartdoc.SmartDoc.Cite;
import org.xmlsmartdoc.SmartDoc.Code;
import org.xmlsmartdoc.SmartDoc.Col;
import org.xmlsmartdoc.SmartDoc.Colgroup;
import org.xmlsmartdoc.SmartDoc.Container;
import org.xmlsmartdoc.SmartDoc.Dd;
import org.xmlsmartdoc.SmartDoc.Dfn;
import org.xmlsmartdoc.SmartDoc.Div;
import org.xmlsmartdoc.SmartDoc.Dl;
import org.xmlsmartdoc.SmartDoc.Doc;
import org.xmlsmartdoc.SmartDoc.DocContext;
import org.xmlsmartdoc.SmartDoc.Dt;
import org.xmlsmartdoc.SmartDoc.Em;
import org.xmlsmartdoc.SmartDoc.Head;
import org.xmlsmartdoc.SmartDoc.Italic;
import org.xmlsmartdoc.SmartDoc.Li;
import org.xmlsmartdoc.SmartDoc.Ol;
import org.xmlsmartdoc.SmartDoc.Paragraph;
import org.xmlsmartdoc.SmartDoc.Pre;
import org.xmlsmartdoc.SmartDoc.Quote;
import org.xmlsmartdoc.SmartDoc.Section;
import org.xmlsmartdoc.SmartDoc.SmartDocModel;
import org.xmlsmartdoc.SmartDoc.Span;
import org.xmlsmartdoc.SmartDoc.SubSection;
import org.xmlsmartdoc.SmartDoc.SubSubSection;
import org.xmlsmartdoc.SmartDoc.Symbol;
import org.xmlsmartdoc.SmartDoc.TBody;
import org.xmlsmartdoc.SmartDoc.TFoot;
import org.xmlsmartdoc.SmartDoc.THead;
import org.xmlsmartdoc.SmartDoc.Table;
import org.xmlsmartdoc.SmartDoc.Td;
import org.xmlsmartdoc.SmartDoc.Th;
import org.xmlsmartdoc.SmartDoc.Tr;
import org.xmlsmartdoc.SmartDoc.Tt;
import org.xmlsmartdoc.SmartDoc.Ul;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.xml.IProcessor;
import com.AsamiOffice.jaba2.xml.ProcessorFactory;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Entity;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.AsamiOffice.xml.UDOM;

/**
 * XHTMLImporter
 *
 * @since   Dec. 27, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class XHTMLImporter {
    protected SmartDocModel sdocModel_; // XXX
    protected CharacterEntityMap cemap_ = new CharacterEntityMap();

    public XHTMLImporter(SmartDocModel model) {
        sdocModel_ = model;
    }

    public String getID() {
        return ("xhtml");
    }

    public String getName() {
        return ("XHTML Importer");
    }

    public boolean canImport(URL url) {
        String suffix = UString.getSuffix(url.toExternalForm());
        return ("xhtml".equals(suffix));
    }

    public void importSource(
        URL url,
        DocContext context
    ) throws IOException {
        SmartDocModel model = sdocModel_;
        IProcessor processor = ProcessorFactory.getProcessor();        // XXX
        Document xml = processor.parseDocument(url);
        Doc doc = _buildDoc(xml, context);
        model.setDoc(doc);
    }

    protected Doc _buildDoc(Document xml, DocContext context) {
        Element html = xml.getDocumentElement();
        return (_buildHTML(html));
    }

    protected Doc _buildHTML(Element html) {
        Doc doc = new Doc();
        _buildContents(html, doc);
        return (doc);
    }

    protected void _buildHead(Element element, Container target) {
        Head head = new Head();
        target.addContent(head);
        _buildContents(element, head);
    }

    protected void _buildBody(Element element, Container target) {
        Body body = new Body();
        target.addContent(body);
        _buildContents(element, body);
    }

    protected void _buildTitle(Element element, Container target) {
        // XXX
    }

    protected void _buildBase(Element element, Container target) {
        // do nothing
    }

    protected void _buildIsindex(Element element, Container target) {
        // do nothing
    }

    protected void _buildLink(Element element, Container target) {
        // XXX
    }

    protected void _buildMeta(Element element, Container target) {
        // XXX
    }

    protected void _buildStyle(Element element, Container target) {
        // XXX
    }

    protected void _buildAbbr(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildAcronym(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildCode(Element element, Container target) {
        Code code = new Code();
        target.addContent(code);
        _buildContents(element, code);
    }

    protected void _buildCite(Element element, Container target) {
        Cite cite = new Cite();
//        cite.setName(UString.checkNull(element.getAttribute("name")));
        target.addContent(cite);
        _buildContents(element, cite);
    }

    protected void _buildDfn(Element element, Container target) {
        Dfn dfn = new Dfn();
        target.addContent(dfn);
        _buildContents(element, dfn);
    }

    protected void _buildEm(Element element, Container target) {
        Em em = new Em();
        target.addContent(em);
        _buildContents(element, em);
    }

    protected void _buildStrong(Element element, Container target) {
        Em em = new Em();
        target.addContent(em);
        _buildContents(element, em);
    }

    protected void _buildKbd(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildSamp(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildVar(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildSub(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildSup(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildBold(Element element, Container target) {
        Bold bold = new Bold();
        target.addContent(bold);
        _buildContents(element, bold);
    }

    protected void _buildItalic(Element element, Container target) {
        Italic italic = new Italic();
        target.addContent(italic);
        _buildContents(element, italic);
    }

    protected void _buildBig(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildSmall(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildStrike(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildUnderline(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildTt(Element element, Container target) {
        Tt tt = new Tt();
        target.addContent(tt);
        _buildContents(element, tt);
    }

    protected void _buildFont(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildBasefont(Element element, Container target) {
        // XXX
    }

    protected Container _buildH1(Element element, Container target) {
        Chapter chapter = new Chapter();
        chapter.setTitle(UDOM.getDataValue(element));
        return (chapter);
    }

    protected Container _buildH2(Element element, Container target) {
        Section section = new Section();
        section.setTitle(UDOM.getDataValue(element));
        return (section);
    }

    protected Container _buildH3(Element element, Container target) {
        SubSection subsection = new SubSection();
        subsection.setTitle(UDOM.getDataValue(element));
        return (subsection);
    }

    protected Container _buildH4(Element element, Container target) {
        SubSubSection subsubsection = new SubSubSection();
        subsubsection.setTitle(UDOM.getDataValue(element));
        return (subsubsection);
    }

    protected Container _buildH5(Element element, Container target) {
        throw (new UnsupportedOperationException());
    }

    protected Container _buildH6(Element element, Container target) {
        throw (new UnsupportedOperationException());
    }

    protected void _buildAddress(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildDel(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildIns(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildParagraph(Element element, Container target) {
        Paragraph paragraph = new Paragraph();
        target.addContent(paragraph);
        _buildContents(element, paragraph);
    }

    protected void _buildBlockquote(Element element, Container target) {
        Blockquote blockquote = new Blockquote();
        target.addContent(blockquote);
        _buildContents(element, blockquote);
    }

    protected void _buildQuote(Element element, Container target) {
        Quote quote = new Quote();
        target.addContent(quote);
        _buildContents(element, quote);
    }

    protected void _buildBr(Element element, Container target) {
        // XXX
    }

    protected void _buildPre(Element element, Container target) {
        Pre pre = new Pre();
        target.addContent(pre);
        _buildContents(element, pre);
    }

    protected void _buildBdo(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildCenter(Element element, Container target) {
        Div div = new Div();
        div.setStyle("text-align: center;");
        target.addContent(div);
        _buildContents(element, div);
    }

    protected void _buildDiv(Element element, Container target) {
        Div div = new Div();
        target.addContent(div);
        _buildContents(element, div);
    }

    protected void _buildSpan(Element element, Container target) {
        Span span = new Span();
        target.addContent(span);
        _buildContents(element, span);
    }

    protected void _buildAnchor(Element element, Container target) {
        Anchor anchor = new Anchor();
        target.addContent(anchor);
        _buildContents(element, anchor);
    }

    protected void _buildImg(Element element, Container target) {
        // XXX
    }

    protected void _buildMap(Element element, Container target) {
        // do nothing
    }

    protected void _buildArea(Element element, Container target) {
        // do nothing
    }

    protected void _buildHr(Element element, Container target) {
        // XXX
    }

    protected void _buildDir(Element element, Container target) {
        // XXX
    }

    protected void _buildMenu(Element element, Container target) {
        // XXX
    }

    protected void _buildOl(Element element, Container target) {
        Ol ol = new Ol();
        target.addContent(ol);
        _buildContents(element, ol);
    }

    protected void _buildUl(Element element, Container target) {
        Ul ul = new Ul();
        target.addContent(ul);
        _buildContents(element, ul);
    }

    protected void _buildLi(Element element, Container target) {
        Li li = new Li();
        target.addContent(li);
        _buildContents(element, li);
    }

    protected void _buildDl(Element element, Container target) {
        Dl dl = new Dl();
        target.addContent(dl);
        _buildContents(element, dl);
    }

    protected void _buildDt(Element element, Container target) {
        Dt dt = new Dt();
        target.addContent(dt);
        _buildContents(element, dt);
    }

    protected void _buildDd(Element element, Container target) {
        Dd dd = new Dd();
        target.addContent(dd);
        _buildContents(element, dd);
    }

    protected void _buildTable(Element element, Container target) {
        Table table = new Table();
        target.addContent(table);
        _buildContents(element, table);
    }

    protected void _buildTr(Element element, Container target) {
        Tr tr = new Tr();
        target.addContent(tr);
        _buildContents(element, tr);
    }

    protected void _buildTh(Element element, Container target) {
        Th th = new Th();
        target.addContent(th);
        _buildContents(element, th);
    }

    protected void _buildTd(Element element, Container target) {
        Td td = new Td();
        target.addContent(td);
        _buildContents(element, td);
    }

    protected void _buildThead(Element element, Container target) {
        THead thead = new THead();
        target.addContent(thead);
        _buildContents(element, thead);
    }

    protected void _buildTbody(Element element, Container target) {
        TBody tbody = new TBody();
        target.addContent(tbody);
        _buildContents(element, tbody);
    }

    protected void _buildTfoot(Element element, Container target) {
        TFoot tfoot = new TFoot();
        target.addContent(tfoot);
        _buildContents(element, tfoot);
    }

    protected void _buildColgroup(Element element, Container target) {
        Colgroup colgroup = new Colgroup();
        target.addContent(colgroup);
        _buildContents(element, colgroup);
    }

    protected void _buildCol(Element element, Container target) {
        Col col = new Col();
        target.addContent(col);
    }

    protected void _buildCaption(Element element, Container target) {
        // XXX
    }

    protected void _buildFrameset(Element element, Container target) {
        // XXX
    }

    protected void _buildFrame(Element element, Container target) {
        // XXX
    }

    protected void _buildNoframes(Element element, Container target) {
        // XXX
    }

    protected void _buildIframe(Element element, Container target) {
        // XXX
    }

    protected void _buildForm(Element element, Container target) {
        // XXX
    }

    protected void _buildFieldset(Element element, Container target) {
        // XXX
    }

    protected void _buildLegend(Element element, Container target) {
        // XXX
    }

    protected void _buildLabel(Element element, Container target) {
        // XXX
    }

    protected void _buildInput(Element element, Container target) {
        // XXX
    }

    protected void _buildButton(Element element, Container target) {
        // XXX
    }

    protected void _buildTextarea(Element element, Container target) {
        // XXX
    }

    protected void _buildSelect(Element element, Container target) {
        // XXX
    }

    protected void _buildOptgroup(Element element, Container target) {
        // XXX
    }

    protected void _buildOption(Element element, Container target) {
        // XXX
    }

    protected void _buildScript(Element element, Container target) {
        // XXX
    }

    protected void _buildNoscript(Element element, Container target) {
        // XXX
    }

    protected void _buildObject(Element element, Container target) {
        // XXX
    }

    protected void _buildParam(Element element, Container target) {
        // XXX
    }

    protected void _buildApplet(Element element, Container target) {
        // XXX
    }

    protected void _buildSymbol(Element element, Container target) {
        Symbol symbol = new Symbol();
        target.addContent(symbol);
        _buildContents(element, symbol);
    }

    protected void _buildContents(Node parent, Container target) {
        Container[] headerContexts = new Container[6];
        Container newTarget;
        NodeList nodes = parent.getChildNodes();
        int size = nodes.getLength();
        for (int i = 0;i < size;i++) {
            Node node = nodes.item(i);
            switch (node.getNodeType()) {

            case Node.ELEMENT_NODE:
                Element child = (Element)node;
                String tagName = child.getTagName();
                if (_isTag("head", tagName)) {
                    _buildHead(child, target);
                } else if (_isTag("body", tagName)) {
                    _buildBody(child, target);
                } else if (_isTag("title", tagName)) {
                    _buildTitle(child, target);
                } else if (_isTag("base", tagName)) {
                    _buildBase(child, target);
                } else if (_isTag("isindex", tagName)) {
                    _buildIsindex(child, target);
                } else if (_isTag("link", tagName)) {
                    _buildLink(child, target);
                } else if (_isTag("meta", tagName)) {
                    _buildMeta(child, target);
                } else if (_isTag("style", tagName)) {
                    _buildStyle(child, target);
                } else if (_isTag("abbr", tagName)) {
                    _buildAbbr(child, target);
                } else if (_isTag("acronym", tagName)) {
                    _buildAcronym(child, target);
                } else if (_isTag("code", tagName)) {
                    _buildCode(child, target);
                } else if (_isTag("cite", tagName)) {
                    _buildCite(child, target);
                } else if (_isTag("dfn", tagName)) {
                    _buildDfn(child, target);
                } else if (_isTag("em", tagName)) {
                    _buildEm(child, target);
                } else if (_isTag("strong", tagName)) {
                    _buildStrong(child, target);
                } else if (_isTag("kbd", tagName)) {
                    _buildKbd(child, target);
                } else if (_isTag("samp", tagName)) {
                    _buildSamp(child, target);
                } else if (_isTag("var", tagName)) {
                    _buildVar(child, target);
                } else if (_isTag("sub", tagName)) {
                    _buildSub(child, target);
                } else if (_isTag("sup", tagName)) {
                    _buildSup(child, target);
                } else if (_isTag("b", tagName)) {
                    _buildBold(child, target);
                } else if (_isTag("i", tagName)) {
                    _buildItalic(child, target);
                } else if (_isTag("big", tagName)) {
                    _buildBig(child, target);
                } else if (_isTag("small", tagName)) {
                    _buildSmall(child, target);
                } else if (_isTag("s", tagName)) {
                    _buildStrike(child, target);
                } else if (_isTag("strike", tagName)) {
                    _buildStrike(child, target);
                } else if (_isTag("u", tagName)) {
                    _buildUnderline(child, target);
                } else if (_isTag("tt", tagName)) {
                    _buildTt(child, target);
                } else if (_isTag("font", tagName)) {
                    _buildFont(child, target);
                } else if (_isTag("basefont", tagName)) {
                    _buildBasefont(child, target);
                } else if (_isTag("h1", tagName)) {
                    if (headerContexts[0] != null) {
                        target = headerContexts[0];
                    } else {
                        headerContexts[0] = target;
                    }
                    headerContexts[1] = null;
                    headerContexts[2] = null;
                    headerContexts[3] = null;
                    headerContexts[4] = null;
                    headerContexts[5] = null;
                    newTarget = _buildH1(child, target);
                    target.addContent(newTarget);
                    target = newTarget;
                } else if (_isTag("h2", tagName)) {
                    if (headerContexts[1] != null) {
                        target = headerContexts[1];
                    } else {
                        headerContexts[1] = target;
                    }
                    headerContexts[2] = null;
                    headerContexts[3] = null;
                    headerContexts[4] = null;
                    headerContexts[5] = null;
                    newTarget = _buildH2(child, target);
                    target.addContent(newTarget);
                    target = newTarget;
                } else if (_isTag("h3", tagName)) {
                    if (headerContexts[2] != null) {
                        target = headerContexts[1];
                    } else {
                        headerContexts[2] = target;
                    }
                    headerContexts[3] = null;
                    headerContexts[4] = null;
                    headerContexts[5] = null;
                    newTarget = _buildH3(child, target);
                    target.addContent(newTarget);
                    target = newTarget;
                } else if (_isTag("h4", tagName)) {
                    if (headerContexts[3] != null) {
                        target = headerContexts[1];
                    } else {
                        headerContexts[3] = target;
                    }
                    headerContexts[4] = null;
                    headerContexts[5] = null;
                    newTarget = _buildH4(child, target);
                    target.addContent(newTarget);
                    target = newTarget;
                } else if (_isTag("h5", tagName)) {
                    if (headerContexts[4] != null) {
                        target = headerContexts[1];
                    } else {
                        headerContexts[4] = target;
                    }
                    headerContexts[5] = null;
                    newTarget = _buildH5(child, target);
                    target.addContent(newTarget);
                    target = newTarget;
                } else if (_isTag("h6", tagName)) {
                    if (headerContexts[5] != null) {
                        target = headerContexts[1];
                    } else {
                        headerContexts[5] = target;
                    }
                    newTarget = _buildH6(child, target);
                    target.addContent(newTarget);
                    target = newTarget;
                } else if (_isTag("address", tagName)) {
                    _buildAddress(child, target);
                } else if (_isTag("del", tagName)) {
                    _buildDel(child, target);
                } else if (_isTag("ins", tagName)) {
                    _buildIns(child, target);
                } else if (_isTag("p", tagName)) {
                    _buildParagraph(child, target);
                } else if (_isTag("blockquote", tagName)) {
                    _buildBlockquote(child, target);
                } else if (_isTag("q", tagName)) {
                    _buildQuote(child, target);
                } else if (_isTag("br", tagName)) {
                    _buildBr(child, target);
                } else if (_isTag("pre", tagName)) {
                    _buildPre(child, target);
                } else if (_isTag("bdo", tagName)) {
                    _buildBdo(child, target);
                } else if (_isTag("center", tagName)) {
                    _buildCenter(child, target);
                } else if (_isTag("div", tagName)) {
                    _buildDiv(child, target);
                } else if (_isTag("span", tagName)) {
                    _buildSpan(child, target);
                } else if (_isTag("a", tagName)) {
                    _buildAnchor(child, target);
                } else if (_isTag("img", tagName)) {
                    _buildImg(child, target);
                } else if (_isTag("map", tagName)) {
                    _buildMap(child, target);
                } else if (_isTag("area", tagName)) {
                    _buildArea(child, target);
                } else if (_isTag("hr", tagName)) {
                    _buildHr(child, target);
                } else if (_isTag("dir", tagName)) {
                    _buildDir(child, target);
                } else if (_isTag("menu", tagName)) {
                    _buildMenu(child, target);
                } else if (_isTag("ol", tagName)) {
                    _buildOl(child, target);
                } else if (_isTag("ul", tagName)) {
                    _buildUl(child, target);
                } else if (_isTag("li", tagName)) {
                    _buildLi(child, target);
                } else if (_isTag("dl", tagName)) {
                    _buildDl(child, target);
                } else if (_isTag("dt", tagName)) {
                    _buildDt(child, target);
                } else if (_isTag("dd", tagName)) {
                    _buildDd(child, target);
                } else if (_isTag("table", tagName)) {
                    _buildTable(child, target);
                } else if (_isTag("tr", tagName)) {
                    _buildTr(child, target);
                } else if (_isTag("th", tagName)) {
                    _buildTh(child, target);
                } else if (_isTag("td", tagName)) {
                    _buildTd(child, target);
                } else if (_isTag("thead", tagName)) {
                    _buildThead(child, target);
                } else if (_isTag("tbody", tagName)) {
                    _buildTbody(child, target);
                } else if (_isTag("tfoot", tagName)) {
                    _buildTfoot(child, target);
                } else if (_isTag("colgroup", tagName)) {
                    _buildColgroup(child, target);
                } else if (_isTag("col", tagName)) {
                    _buildCol(child, target);
                } else if (_isTag("caption", tagName)) {
                    _buildCaption(child, target);
                } else if (_isTag("framset", tagName)) {
                    _buildFrameset(child, target);
                } else if (_isTag("frame", tagName)) {
                    _buildFrame(child, target);
                } else if (_isTag("noframes", tagName)) {
                    _buildNoframes(child, target);
                } else if (_isTag("iframe", tagName)) {
                    _buildIframe(child, target);
                } else if (_isTag("form", tagName)) {
                    _buildForm(child, target);
                } else if (_isTag("fieldset", tagName)) {
                    _buildFieldset(child, target);
                } else if (_isTag("legend", tagName)) {
                    _buildLegend(child, target);
                } else if (_isTag("label", tagName)) {
                    _buildLabel(child, target);
                } else if (_isTag("input", tagName)) {
                    _buildInput(child, target);
                } else if (_isTag("button", tagName)) {
                    _buildButton(child, target);
                } else if (_isTag("textarea", tagName)) {
                    _buildTextarea(child, target);
                } else if (_isTag("select", tagName)) {
                    _buildSelect(child, target);
                } else if (_isTag("optgroup", tagName)) {
                    _buildOptgroup(child, target);
                } else if (_isTag("option", tagName)) {
                    _buildOption(child, target);
                } else if (_isTag("script", tagName)) {
                    _buildScript(child, target);
                } else if (_isTag("noscript", tagName)) {
                    _buildNoscript(child, target);
                } else if (_isTag("object", tagName)) {
                    _buildObject(child, target);
                } else if (_isTag("param", tagName)) {
                    _buildParam(child, target);
                } else if (_isTag("applet", tagName)) {
                    _buildApplet(child, target);
                } else {
                    _buildSymbol(child, target);
                }
                break;
            case Node.TEXT_NODE:
                String text = ((Text)node).getData();
                target.addContent(new CharBlock(text));
                break;
            case Node.ENTITY_NODE:
                String name = ((Entity)node).getNotationName();
                if (name != null) {
                    char c = cemap_.getCharacter(name);
                    if (c != 0) {
                        target.addContent(new CharBlock(c));
                    } else {
                        throw (new InternalError("bad entity"));
                    }
                }
                break;
            case Node.ENTITY_REFERENCE_NODE:
                // UArray.addAll(list, _buildContents(node));
                // break;
                throw (new UnsupportedOperationException());
            case Node.COMMENT_NODE:
                // do nothing
                break;
            case Node.CDATA_SECTION_NODE:
                String cdata = ((CDATASection)node).getData();
                target.addContent(new CharBlock(cdata));
                break;
            default:
                throw (new InternalError("bad node type = " +
                                         node.getNodeType())); // XXX : debug
            }
        }
    }

    protected final boolean _isTag(String name, String tagName) {
        return (name.equals(tagName.toLowerCase()));
    }
}
