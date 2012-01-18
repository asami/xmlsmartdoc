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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Entity;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xmlsmartdoc.SmartDoc.control.And;
import org.xmlsmartdoc.SmartDoc.control.Define;
import org.xmlsmartdoc.SmartDoc.control.Lambda;
import org.xmlsmartdoc.SmartDoc.control.Or;
import org.xmlsmartdoc.SmartDoc.control.Refer;
import org.xmlsmartdoc.SmartDoc.xhtml.CharacterEntityMap;
import org.xmlsmartdoc.SmartDoc.xhtml.XHTMLImporter;
import org.xmlsmartdoc.goldenport.Goldenport;
import org.xmlsmartdoc.goldenport.adapters.SmartDocAdapter;
import org.xmlsmartdoc.goldenport.config.GcAdapter;
import org.xmlsmartdoc.goldenport.config.GcGoldenportConfig;
import org.xmlsmartdoc.goldenport.config.GcProperty;

import com.AsamiOffice.io.UURL;
import com.AsamiOffice.jaba2.j2fw.J2Monitor;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorModel;
import com.AsamiOffice.jaba2.xml.IProcessor;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.UArray;
import com.AsamiOffice.util.ULocale;

/**
 * SmartDocModel
 *
 * @since   Oct. 19, 1998
 *  version Jun. 10, 2005
 * @version Jan. 18, 2012
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SmartDocModel extends GeneratorModel {
    protected J2Monitor monitor_;
    protected SmartDocConfig config_;
    protected DocContext[] docContexts_;
    protected URL source_;
    protected Document xml_;
    protected Doc doc_;
    protected Map docs_ = new HashMap(); // Map<DocContext, Doc>
    protected BibliographyDatabase bibDB_;
    protected Locale[] locales_;
    protected String[] formats_;
    protected String key_;
    protected CharacterEntityMap cemap_ = new CharacterEntityMap();
    protected Map includes_ = new HashMap(); // [640]

    public SmartDocModel(SmartDocConfig config) throws IOException {
        super(config);
        config_ = config;
    }

    public void setup() throws IOException {
        setup(null);
    }

    public void setup(Document doc) throws IOException {
        monitor_ = SmartDocContext.getContext().getMonitor();
        source_ = config_.getSource();
        // XXX
        if (source_ != null) {
            XHTMLImporter xhtmlImporter = new XHTMLImporter(this);// XXX
            if (xhtmlImporter.canImport(source_)) {
                xhtmlImporter.importSource(source_, null); // XXX
                return;
            }
        }
        bibDB_ = config_.getBibliographyDatabase();
        locales_ = config_.getLocales();
        formats_ = config_.getFormats();
        key_ = config_.getKey();
        if (doc == null) {
            IProcessor processor = config_.getXMLProcessor();
            xml_ = processor.parseDocument(source_);
        } else {
            xml_ = doc;
        }
        if (xml_ == null || xml_.getDocumentElement() == null) {
            _error("XML syntax error");
        }
        DocContext[] contexts;
        if (locales_ == null) {
            if (formats_ == null) {
                contexts = null;
            } else {
                contexts = new DocContext[formats_.length];
                for (int i = 0;i < formats_.length;i++) {
                    DocContext context = new DocContext(config_);
                    context.setProject(config_.getProject());
                    context.setFormat(formats_[i]);
                    context.setKey(key_);
                    context.setBibliographyDatabase(bibDB_);
                    _setupBaseDirectory(context, source_);
                    contexts[i] = context;
                }
            }
        } else {
            if (formats_ == null) {
                contexts = new DocContext[locales_.length];
                for (int i = 0;i < locales_.length;i++) {
                    DocContext context = new DocContext(config_);
                    context.setProject(config_.getProject());
                    context.setLocale(locales_[i]);
                    context.setBibliographyDatabase(bibDB_);
                    _setupBaseDirectory(context, source_);
                    contexts[i] = context;
                }
            } else {
                contexts = new DocContext[locales_.length * formats_.length];
                int index = 0;
                for (int i = 0;i < locales_.length;i++) {
                    for (int j = 0;j < formats_.length;j++) {
                        DocContext context = new DocContext(config_);
                        context.setProject(config_.getProject());
                        context.setLocale(locales_[i]);
                        context.setFormat(formats_[j]);
                        context.setKey(key_);
                        context.setBibliographyDatabase(bibDB_);
                        _setupBaseDirectory(context, source_);
                        contexts[index++] = context;
                    }
                }
            }
        }
        if (contexts == null) {        // XXX : obsolate?
            docContexts_ = null;
            DocContext context = new DocContext(config_);
            context.setProject(config_.getProject());
            context.setBibliographyDatabase(bibDB_);
            _setupBaseDirectory(context, source_);
            monitor_.verbose("\tMaster document...");
            doc_ = _buildDoc(xml_, context);
        } else {
            docContexts_ = contexts;
            for (int i = 0;i < contexts.length;i++) {
                DocContext context = contexts[i];
                String format = context.getFormat();
                Locale locale = context.getLocale();
                StringBuffer buffer = new StringBuffer();
                buffer.append("\t");
                if (format != null) {
                    buffer.append("format=");
                    buffer.append(format);
                }
                if (locale != null) {
                    if (format != null) {
                        buffer.append(",");
                    }
                    buffer.append("locale=");
                    buffer.append(locale.toString());
                }
                monitor_.verbose(new String(buffer));
                docs_.put(context, _buildDoc(xml_, context));
            }
        }
    }

    private void _setupBaseDirectory(DocContext context, URL source) {
      File dir = config_.getProjectDirectory();
      if (dir != null) {
          context.setBaseDirctory(dir.toString());
      } else if (source == null) {
          return;
      } else {
          String parent = UString.getContainerPathname(source.toString());
//        System.out.println("parent = " + parent);
          if (parent != null && !"".equals(parent)) {
              context.setBaseDirctory(parent);
          }
      }
    }

    public boolean isSdocReport() {
        return (config_.isSdocReport());
    }

    public URL getSource() {
        return (source_);
    }

    public Document getDocument() {
        return (xml_);
    }

    // XXX : obsolate?
    public Doc getDoc() {
        return (doc_);
    }

    // XXX : called by XHTMLImporter
    public void setDoc(Doc doc) {
    }

    public DocContext[] getDocContexts() {
        return (docContexts_);
    }

    public Doc getDoc(DocContext context) {
        return ((Doc)docs_.get(context));
    }

    /**
     * @deprecated
     */
    public Doc getDoc(Locale locale) { // XXX
        return ((Doc)docs_.get(locale));
    }

    public File getTargetDirectory() {
        File dir = config_.getTargetDirectory();
        if (dir != null) {
            return (dir);
        } else {
            return (new File("."));
        }
    }

    public Locale[] getLocales() {
        return (locales_);
    }

    public Locale getDefaultLocale() {
        return (Locale.ENGLISH);
//        return (Locale.getDefault());
    }

    public String getLabel(String key, Content content) {
        Locale locale = _getLocale(content);
        return (config_.getLabel(key, locale));
    }

    public String getCapitalLabel(String key, Content content) {
        Locale locale = _getLocale(content);
        return (ULocale.makeLabel(config_.getLabel(key, locale), locale));
    }

    public String[] getLabelParts(String key, Content content) {
        Locale locale = _getLocale(content);
        return (config_.getLabelParts(key, locale));
    }

    public String[] getCapitalLabelParts(String key, Content content) {
        Locale locale = _getLocale(content);
        String[] parts = config_.getLabelParts(key, locale);
        if (parts[0] != null) {
            parts[0] =
                ULocale.makeLabel(config_.getLabel(key, locale), locale);
        }
        return (parts);
    }

    public String getPartLabel(int number, Content content) {
        Locale locale = _getLocale(content);
        return (config_.getChapterLabel(number, locale));
    }

    public String getChapterLabel(int number, Content content) {
        Locale locale = _getLocale(content);
        return (config_.getChapterLabel(number, locale));
    }

    public String getSectionLabel(int number, Content content) {
        Locale locale = _getLocale(content);
        return (config_.getSectionLabel(number, locale));
    }

    public String getSubSectionLabel(
        int section,
        int subSection,
        Content content
    ) {
        Locale locale = _getLocale(content);
        return (config_.getSubSectionLabel(section, subSection, locale));
    }

    public String getSubSubSectionLabel(
        int section,
        int subSection,
        int subSubSection,
        Content content
    ) {
        Locale locale = _getLocale(content);
        return (
            config_.getSubSubSectionLabel(
                section,
                subSection,
                subSubSection,
                locale
            )
        );
    }

    private Locale _getLocale(Content content) {
        return (content.getProcessLocale());
/*
        Locale locale = content.getLanguageLocale();
        if (locale != null) {
            return (locale);
        }
        locale = content.getLocale();
        if (locale != null) {
            return (locale);
        }
        return (getDefaultLocale());
*/
    }

    /**
     * @deprecated
     */
    public Doc _getDoc(Content content) {
        Container container = content.getParent();
        while (!(container instanceof Doc)) {
            container = container.getParent();
        }
        return ((Doc)container);
    }

    // invoked by adapter
    public Doc build(Document xml, DocContext context) throws RemoteException {
        xml = _goldenport(xml, context);
        Doc doc = _build(xml, context);
        doc = _metaEval(doc, context);
        doc = _macroExpand(doc, context);
        return (doc);
    }

    // invoked by adapter
    public Doc expand(Doc doc, DocContext context) {
        return (_expand(doc, context));
    }

    public Content[] buildSubDoc(URL url, DocContext context)
        throws IOException {

        IProcessor processor = config_.getXMLProcessor();
        Document xml = processor.parseDocument(url);
        return (buildSubDoc(xml, context));
    }

    public Content[] buildSubDoc(Document xml, DocContext context) {
        Element root = xml.getDocumentElement();
        Element newroot = xml.createElement("doc");
        newroot.appendChild(root);
        return (_buildContents(newroot));
    }

    public Content[] buildContents(Node node) {
        return (_buildContents(node));
    }

    protected Doc _buildDoc(Document xml, DocContext context) 
      throws RemoteException {
        xml = _goldenport(xml, context);
        Doc doc = _build(xml, context);
        doc = _expand(doc, context);
        doc = _metaEval(doc, context);
        doc = _macroExpand(doc, context);
        doc = _normalize(doc, context);
        doc = _eval(doc, context);
        doc = _format(doc, context);
        return (doc);
    }

    protected Doc _build(Document xml, DocContext context) {
        Element root = xml.getDocumentElement();
        String lang = UString.checkNull(root.getAttribute("xml:lang"));
        NodeList nodes = root.getChildNodes();
        int size = nodes.getLength();
        Macro macro = null;
        Head head = null;
        Body body = null;
        Glossary glossary = null;
        Bibliography bib = null;
        for (int i = 0;i < size;i++) {
            try {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element)node;
                    String tagName = element.getTagName();
                    if ("macro".equals(tagName)) {
                        macro = _buildMacro(element, context);
                    } else if ("head".equals(tagName)) {
                        head = _buildHead(element, context);
                    } else if ("body".equals(tagName)) {
                        body = _buildBody(element);
                    // XXX : in body
                    } else if ("glossary".equals(tagName)) {
                        glossary = _buildGlossary(element);
                    // XXX : in body
                    } else if ("bibliography".equals(tagName)) {
                        bib = _buildBibliography(
                            element,
                            context.getBibliographyDatabase()
                        );
                    } else {
                        _warning("bad tag in <doc> : " + tagName);
                    }
                }
            } catch (SmartDocWarningException e) {
                // continute
            }
        }
        if (head == null) {
            head = new Head();
        }
        if (body == null) {
            body = new Body();
        }
        Doc doc = new Doc();
        doc.setDocContext(context);
        doc.setLanguage(lang);
        doc.setLocale(context.getLocale());
        if (macro != null) {
            doc.setMacro(macro);
        }
        doc.setHead(head);
        doc.setBody(body);
//        doc.setGlossary(glossary);
//        doc.setBibliography(bib);
//        doc.setTOC(_buildTOC(body)); XXX move to format
//        doc.setIndex(_buildIndex(head, body));

        return (doc);
    }

    protected Doc _expand(Doc doc, DocContext context) {
        return ((Doc)doc.expand(context)[0]);
    }

    protected Doc _metaEval(Doc doc, DocContext context) {
        return ((Doc)doc.metaEval(context)[0]);
    }

    protected Doc _macroExpand(Doc doc, DocContext context) {
        return ((Doc)doc.macroExpand(context)[0]);
    }

    protected Doc _normalize(Doc doc, DocContext context) {
        return ((Doc)doc.normalize(context)[0]);
    }

    protected Doc _eval(Doc doc, DocContext context) {
        return ((Doc)doc.eval(context)[0]);
    }

    protected Doc _format(Doc doc, DocContext context) { // really format
        _formatDoc(doc);
        _makeTOC(doc);
        _makeIndex(doc);
        _makeSequenceNumber(doc);
        _resolveLinks(doc);
//        _adjustXMLLang(doc, context);
        _allocateFiles(doc, context);
        return (doc);
    }

    protected Content[] _buildContents(Node parent) {
        // XXX : handle import
        List list = new ArrayList();
        NodeList nodes = parent.getChildNodes();
        int size = nodes.getLength();
        for (int i = 0;i < size;i++) {
            Node node = nodes.item(i);
            switch (node.getNodeType()) {

            case Node.ELEMENT_NODE:
                Element child = (Element)node;
                String tagName = child.getTagName();
                if ("sen".equals(tagName)) {
                    list.add(_buildSentence(child));
                } else if ("p".equals(tagName)) {
                    list.add(_buildParagraph(child));
                } else if ("part".equals(tagName)) {
                    list.add(_buildPart(child));
                } else if ("chapter".equals(tagName)) {
                    list.add(_buildChapter(child));
                } else if ("section".equals(tagName)) {
                    list.add(_buildSection(child));
                } else if ("subsection".equals(tagName)) {
                    list.add(_buildSubSection(child));
                } else if ("subsubsection".equals(tagName)) {
                    list.add(_buildSubSubSection(child));
                } else if ("appendix".equals(tagName)) {
                    list.add(_buildAppendix(child));
                } else if ("bibliography".equals(tagName)) {
                    list.add(_buildBibliography(child));
                } else if ("bibliopole".equals(tagName)) {
                    list.add(_buildBibliopole(child));
                } else if ("fyi".equals(tagName)) {
                    list.add(_buildFYI(child));
                } else if ("img".equals(tagName)) {
                    list.add(_buildImg(child));
                } else if ("figure".equals(tagName)) {
                    list.add(_buildImageFigure(child));
                } else if ("ul".equals(tagName)) {
                    list.add(_buildUl(child));
                } else if ("ol".equals(tagName)) {
                    list.add(_buildOl(child));
                } else if ("li".equals(tagName)) {
                    list.add(_buildLi(child));
                } else if ("dl".equals(tagName)) {
                    list.add(_buildDl(child));
                } else if ("dt".equals(tagName)) {
                    list.add(_buildDt(child));
                } else if ("dd".equals(tagName)) {
                    list.add(_buildDd(child));
                } else if ("table".equals(tagName)) {
                    list.add(_buildTable(child));
                } else if ("rowgroup".equals(tagName)) {
                    list.add(_buildRowgroup(child));
                } else if ("colgroup".equals(tagName)) {
                    list.add(_buildColgroup(child));
                } else if ("thead".equals(tagName)) {
                    list.add(_buildTHead(child));
                } else if ("tfoot".equals(tagName)) {
                    list.add(_buildTFoot(child));
                } else if ("tbody".equals(tagName)) {
                    list.add(_buildTBody(child));
                } else if ("tr".equals(tagName)) {
                    list.add(_buildTr(child));
                } else if ("th".equals(tagName)) {
                    list.add(_buildTh(child));
                } else if ("td".equals(tagName)) {
                    list.add(_buildTd(child));
                } else if ("tnote".equals(tagName)) {
                    list.add(_buildTnote(child));
                } else if ("pre".equals(tagName)) {
                    list.add(_buildPre(child));
                } else if ("program".equals(tagName)) {
                    list.add(_buildProgram(child));
                } else if ("console".equals(tagName)) {
                    list.add(_buildConsole(child));
                } else if ("equation".equals(tagName)) {
                    list.add(_buildEquation(child));
                } else if ("div".equals(tagName)) {
                    list.add(_buildDiv(child));
                } else if ("a".equals(tagName)) {
                    list.add(_buildRef(child));
                } else if ("cite".equals(tagName)) {
                    list.add(_buildCite(child));
                } else if ("comment".equals(tagName)) {
                    list.add(_buildComment(child));
                } else if ("note".equals(tagName)) {
                    list.add(_buildNote(child));
                } else if ("span".equals(tagName)) {
                    list.add(_buildSpan(child));
                } else if ("term".equals(tagName)) {
                    list.add(_buildTerm(child));
                } else if ("index".equals(tagName)) {
                    list.add(_buildIndex(child));
                } else if ("b".equals(tagName)) {
                    list.add(_buildBold(child));
                } else if ("i".equals(tagName)) {
                    list.add(_buildItalic(child));
                } else if ("dfn".equals(tagName)) {
                    list.add(_buildDfn(child));
                } else if ("tt".equals(tagName)) {
                    list.add(_buildTt(child));
                } else if ("em".equals(tagName)) {
                    list.add(_buildEm(child));
                } else if ("strong".equals(tagName)) {
                    list.add(_buildStrong(child));
                } else if ("abbr".equals(tagName)) {
                    list.add(_buildAbbr(child));
                } else if ("acronym".equals(tagName)) {
                    list.add(_buildAcronym(child));
                } else if ("code".equals(tagName)) {
                    list.add(_buildCode(child));
                } else if ("blockquote".equals(tagName)) {
                    list.add(_buildBlockquote(child));
                } else if ("q".equals(tagName)) {
                    list.add(_buildQuote(child));
                } else if ("time".equals(tagName)) {
                    list.add(_buildTime(child));
                } else if ("native".equals(tagName)) {
                    list.add(_buildNative(child));
                } else if ("lambda".equals(tagName)) {
                    list.add(_buildLambda(child));
                } else if ("refer".equals(tagName)) {
                    list.add(_buildRefer(child));
                } else if ("and".equals(tagName)) {
                    list.add(_buildAnd(child));
                } else if ("or".equals(tagName)) {
                    list.add(_buildOr(child));
                } else if ("attribute".equals(tagName)) {
                    list.add(_buildMacroAttribute(child)); // XXX : Macro?
                } else if ("title".equals(tagName)) {
                    list.add(_buildMacroTitle(child));
                } else if ("content".equals(tagName)) {        // XXX
                    list.add(_buildMacroContent(child));
                } else {
                    list.add(_buildSymbol(child));
/*
                    _warning (
                        "bad tag in <" +
                        ((Element)parent).getTagName()
                        + "> : " +
                        tagName
                    );
*/
                }
                break;
            case Node.TEXT_NODE:
                String text = ((Text)node).getData();
                list.add(new CharBlock(text));
                break;
            case Node.ENTITY_NODE:
                String name = ((Entity)node).getNotationName();
/*
System.out.println("entity");
System.out.println(name);
System.out.println(((Entity)node).getSystemId());
System.out.println(((Entity)node).getPublicId());
*/
                if (name != null) {
                    char c = cemap_.getCharacter(name);
                    if (c != 0) {
                        list.add(new CharBlock(c));
                    } else {
                        throw (new InternalError("bad entity"));
                    }
                }
                break;
            case Node.ENTITY_REFERENCE_NODE:
                UArray.addAll(list, _buildContents(node));
                break;
            case Node.COMMENT_NODE:
                // do nothing
                break;
            case Node.CDATA_SECTION_NODE:
                String cdata = _getString((CDATASection)node);
                list.add(new CharBlock(cdata));
                break;
            default:
                throw (new InternalError("bad node type = " +
                                         node.getNodeType())); // XXX : debug
            }
        }
        Content[] contents = new Content[list.size()];
        return ((Content[])list.toArray(contents));
    }

    protected Content[] _buildHeadContents(Node parent) {
        List list = new ArrayList();
        NodeList nodes = parent.getChildNodes();
        int size = nodes.getLength();
        for (int i = 0;i < size;i++) {
            Node node = nodes.item(i);
            switch (node.getNodeType()) {

            case Node.ELEMENT_NODE:
                Element child = (Element)node;
                String tagName = child.getTagName();
                if ("title".equals(tagName)) {
                    list.add(_buildDocTitle(child));
                } else if ("subtitle".equals(tagName)) {
                    list.add(_buildGeneric("subtitle", child));
                } else if ("org".equals(tagName)) {
                    list.add(_buildGeneric("org", child));
                } else if ("author".equals(tagName)) {
                    list.add(_buildDocAuthor(child));
                } else if ("date".equals(tagName)) {
                    list.add(_buildDocDate(child));
                } else if ("hp".equals(tagName)) {
                    list.add(_buildGeneric("hp", child));
                } else if ("email".equals(tagName)) {
                    list.add(_buildGeneric("email", child));
                } else if ("abstract".equals(tagName)) {
                    list.add(_buildSummary(child));
                } else if ("header".equals(tagName)) {
                    list.add(_buildHeader(child));
                } else if ("footer".equals(tagName)) {
                    list.add(_buildFooter(child));
                } else if ("prologue".equals(tagName)) {
                    list.add(_buildPrologue(child));
                } else if ("indexdef".equals(tagName)) {
                    list.add(_buildIndexdef(child));
// move Head format  list.add(_buildIndexWords(child));
                } else if ("bibliopole".equals(tagName)) {
                    Bibliopole bib = _buildBibliopole(child);
                    bibDB_.addBibliopole(bib);
                } else if ("define".equals(tagName)) {// XXX
                    list.add(_buildDefine(child));
                } else if ("native".equals(tagName)) {
                    list.add(_buildNative(child));
                } else if ("include".equals(tagName)) {        // XXX
                    _buildInclude(child, list);
                } else {
                    _warning (
                        "bad tag in <" +
                        ((Element)parent).getTagName()
                        + "> : " +
                        tagName
                    );
                }
                break;
            case Node.TEXT_NODE:
                String text = ((Text)node).getData();
                list.add(new CharBlock(text));
                break;
            case Node.ENTITY_NODE:
                String name = ((Entity)node).getNotationName();
                if (name != null) {
                    char c = cemap_.getCharacter(name);
                    if (c != 0) {
                        list.add(new CharBlock(c));
                    } else {
                        throw (new InternalError("bad entity"));
                    }
                }
                break;
            case Node.ENTITY_REFERENCE_NODE:
                UArray.addAll(list, _buildContents(node));
                break;
            case Node.COMMENT_NODE:
                // do nothing
                break;
            case Node.CDATA_SECTION_NODE:
                String cdata = _getString((CDATASection)node);
                list.add(new CharBlock(cdata));
                break;
            default:
                throw (new InternalError("bad node type = " +
                                         node.getNodeType())); // XXX : debug
            }
        }
        Content[] contents = new Content[list.size()];
        return ((Content[])list.toArray(contents));
    }


    public Content[] buildMacroContents(Node parent) {
        List list = new ArrayList();
        NodeList nodes = parent.getChildNodes();
        int size = nodes.getLength();
        for (int i = 0;i < size;i++) {
            Node node = nodes.item(i);
            switch (node.getNodeType()) {

            case Node.ELEMENT_NODE:
                Element child = (Element)node;
                String tagName = child.getTagName();
                if ("define".equals(tagName)) {
                    list.add(_buildDefine(child));
                } else {
                    _warning (
                        "bad tag in <" +
                        ((Element)parent).getTagName()
                        + "> : " +
                        tagName
                    );
                }
                break;
            case Node.TEXT_NODE:
                // do nothing
                break;
            case Node.ENTITY_NODE:
                // do nothing
                break;
            case Node.ENTITY_REFERENCE_NODE:
                UArray.addAll(list, buildMacroContents(node));
                break;
            case Node.COMMENT_NODE:
                // do nothing
                break;
            case Node.CDATA_SECTION_NODE:
                // do nothing
                break;
            default:
                throw (new InternalError("bad node type = " +
                                         node.getNodeType())); // XXX : debug
            }
        }
        Content[] contents = new Content[list.size()];
        return ((Content[])list.toArray(contents));
    }

    protected Macro _buildMacro(Element element, DocContext context) {
        Macro macro = new Macro(element);
        Content[] contents = buildMacroContents(element);
        macro.addContents(contents);
        return (macro);
    }

    protected Head _buildHead(Element element, DocContext context) {
        Head head = new Head(element);
        try {
            URL headerURL = config_.getHeader();
            if (headerURL != null) {
                Header header = new Header();
                header.addContents(buildSubDoc(headerURL, context));
                head.addContent(header);
            }
            URL footerURL = config_.getFooter();
            if (footerURL != null) {
                Footer footer = new Footer();
                footer.addContents(buildSubDoc(footerURL, context));
                head.addContent(footer);
            }
        } catch (IOException e) {
            throw (new InternalError()); // XXX
        }
        Content[] contents = _buildHeadContents(element);
        head.addContents(contents);
        bibDB_.setup();
        return (head);
    }

    protected Generic _buildGeneric(String name, Element element) {
        Generic generic = new Generic(element);
        generic.setName(name);
        Content[] contents = _buildContents(element);
        generic.addContents(contents);
        return (generic);
    }

    protected Title _buildDocTitle(Element element) {
        Title title = new Title(element);
        Content[] contents = _buildContents(element);
        title.addContents(contents);
        return (title);
    }

    protected DocDate _buildDocDate(Element element) {
        DocDate date = new DocDate(element);
        String text = _getString(element);
        if (text != null && !text.equals("")) {
            date.setText(text);
        }
        return (date);
    }

    protected DocAuthor _buildDocAuthor(Element element) {
        DocAuthor author = new DocAuthor(element);
        String text = _getString(element);
        Content[] contents = _buildContents(element);
        author.addContents(contents);
        return (author);
    }

    protected Summary _buildSummary(Element element) {
        Summary summary = new Summary(element);
        Content[] contents = _buildContents(element);
        summary.addContents(contents);
        return (summary);
    }

    protected Header _buildHeader(Element element) {
        Header header = new Header(element);
        Content[] contents = _buildContents(element);
        header.addContents(contents);
        return (header);
    }

    protected Footer _buildFooter(Element element) {
        Footer footer = new Footer(element);
        Content[] contents = _buildContents(element);
        footer.addContents(contents);
        return (footer);
    }

    protected Prologue _buildPrologue(Element element) {
        Prologue prologue = new Prologue(element);
        Content[] contents = _buildContents(element);
        prologue.addContents(contents);
        return (prologue);
    }

    protected Indexdef _buildIndexdef(Element element) {
        Indexdef indexdef = new Indexdef(element);
        List list = new ArrayList();
        NodeList nodes = element.getChildNodes();
        int size = nodes.getLength();
        for (int i = 0;i < size;i++) {
            Node node = nodes.item(i);
            switch (node.getNodeType()) {

            case Node.ELEMENT_NODE:
                Element child = (Element)node;
                String tagName = child.getTagName();
                if ("indexitem".equals(tagName)) {
                    list.add(_buildIndexItem(child));
                } else {
                    _warning (
                        "bad tag in <" +
                        ((Element)element).getTagName()
                        + "> : " +
                        tagName
                    );
                }
                break;
            case Node.TEXT_NODE:
                String text = ((Text)node).getData();
                list.add(new CharBlock(text));
                break;
            case Node.ENTITY_NODE:
                String name = ((Entity)node).getNotationName();
                if (name != null) {
                    char c = cemap_.getCharacter(name);
                    if (c != 0) {
                        list.add(new CharBlock(c));
                    } else {
                        throw (new InternalError("bad entity"));
                    }
                }
                break;
            case Node.ENTITY_REFERENCE_NODE:
                UArray.addAll(list, _buildContents(node)); // XXX
                break;
            case Node.COMMENT_NODE:
                // do nothing
                break;
            case Node.CDATA_SECTION_NODE:
                String cdata = _getString((CDATASection)node);
                list.add(new CharBlock(cdata));
                break;
            default:
                throw (new InternalError("bad node type = " +
                                         node.getNodeType())); // XXX : debug
            }
        }
        size = list.size();
        for (int i = 0;i < size;i++) {
            indexdef.addContent((Content)list.get(i));
        }
        return (indexdef);
    }

    protected IndexItem _buildIndexItem(Element element) {
        IndexItem item = new IndexItem(element);
        item.setWord(_getString(element));
        return (item);
    }

    protected Body _buildBody(Element element) {
        Body body = new Body(element);
        Content[] contents = _buildContents(element);
        body.addContents(contents);
        return (body);
    }

    // Structure stuff

    protected Sentence _buildSentence(Element element) {
        Sentence sen = new Sentence(element);
        Content[] contents = _buildContents(element);
        sen.addContents(contents);
        sen.setDone();
        return (sen);
    }

    protected Paragraph _buildParagraph(Element element) {
        Paragraph p = new Paragraph(element);
        Content[] contents = _buildContents(element);
        p.addContents(contents);
        return (p);
    }

    protected Part _buildPart(Element element) {
        Part part = new Part(element);
        Content[] contents = _buildContents(element);
        part.addContents(contents);
        _setupTitle(part, element);
        return (part);
    }

    protected Chapter _buildChapter(Element element) {
        Chapter chapter = new Chapter(element);
        Content[] contents = _buildContents(element);
        chapter.addContents(contents);
        _setupTitle(chapter, element);
        return (chapter);
    }

    protected Section _buildSection(Element element) {
        Section section = new Section(element);
        Content[] contents = _buildContents(element);
        section.addContents(contents);
        _setupTitle(section, element);
        return (section);
    }

    protected SubSection _buildSubSection(Element element) {
        SubSection subsection = new SubSection(element);
        Content[] contents = _buildContents(element);
        subsection.addContents(contents);
        _setupTitle(subsection, element);
        return (subsection);
    }

    protected SubSubSection _buildSubSubSection(Element element) {
        SubSubSection subsubsection = new SubSubSection(element);
        Content[] contents = _buildContents(element);
        subsubsection.addContents(contents);
        _setupTitle(subsubsection, element);
        return (subsubsection);
    }

    protected Appendix _buildAppendix(Element element) {
        Appendix appendix = new Appendix(element);
        Content[] contents = _buildContents(element);
        appendix.addContents(contents);
        _setupTitle(appendix, element);
        return (appendix);
    }

    protected FYI _buildFYI(Element element) {
        FYI fyi = new FYI(element);
        Content[] contents = _buildContents(element);
        fyi.addContents(contents);
        _setupTitle(fyi, element);
        return (fyi);
    }

    protected void _setupTitle(
        Content content,
        Element element
    ) {
        // XXX : obsolete
    }

/*
    protected void _setupTitle(
        Content content,
        Element element
    ) {
        NodeList nodes = element.getChildNodes();
        int size = nodes.getLength();
        for (int i = 0;i < size;i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element)node;
                if (child.getTagName().equals("title")) {
                    Title title = _buildDocTitle(child);
                    String localeName = UString.checkNull(
                        child.getAttribute("locale")
                    );
                    if (localeName == null) {
                        content.setTitle(title);
                    } else {
                        content.setTitle(
                            title,
                            ULocale.makeLocale(localeName)
                        );
                    }
                }
            }
        }
    }
*/

    protected Img _buildImg(Element element) {
        Img image = new Img(element);
        Content[] contents = _buildContents(element);
        image.addContents(contents);
        return (image);
    }

    protected ImageFigure _buildImageFigure(Element element) {
        ImageFigure image = new ImageFigure(element);
        Content[] contents = _buildContents(element);
        image.addContents(contents);
        _setupTitle(image, element);
        return (image);
    }

    // List stuff

    protected Ul _buildUl(Element element) {
        Ul ul = new Ul(element);
        Content[] contents = _buildContents(element);
        ul.addContents(contents);
        return (ul);
    }

    protected Ol _buildOl(Element element) {
        Ol ol = new Ol(element);
        Content[] contents = _buildContents(element);
        ol.addContents(contents);
        return (ol);
    }

    protected Li _buildLi(Element element) {
        Li li = new Li(element);
        Content[] contents = _buildContents(element);
        li.addContents(contents);
        return (li);
    }

    protected Dl _buildDl(Element element) {
        Dl dl = new Dl(element);
        Content[] contents = _buildContents(element);
        dl.addContents(contents);
        return (dl);
    }

    protected Dt _buildDt(Element element) {
        Dt dt = new Dt(element);
        Content[] contents = _buildContents(element);
        dt.addContents(contents);
        return (dt);
    }

    protected Dd _buildDd(Element element) {
        Dd dd = new Dd(element);
        Content[] contents = _buildContents(element);
        dd.addContents(contents);
        return (dd);
    }

    protected Table _buildTable(Element element) {
        Table table = new Table(element);
        Content[] contents = _buildContents(element);
        table.addContents(contents);
        _setupTitle(table, element);
        return (table);
    }

    protected Rowgroup _buildRowgroup(Element element) {
        Rowgroup rowgroup = new Rowgroup(element);
        NodeList nodes = element.getChildNodes();
        int size = nodes.getLength();
        for (int i = 0;i < size;i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element)node;
                if (!child.getTagName().equals("colgroup")) {
                    _warning("not colgroup in rowgroup");
                }
            }
        }
        return (rowgroup);
    }

    protected Colgroup _buildColgroup(Element element) {
        Colgroup colgroup = new Colgroup(element);
        String align = colgroup.getAlign();
        String type = colgroup.getClazz();
        int span = colgroup.getSpan();
        NodeList nodes = element.getChildNodes();
        int size = nodes.getLength();
        int nCols = 0;
        for (int i = 0;i < size;i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element)node;
                if (!child.getTagName().equals("col")) {
                    _warning("not col in colgroup");
                }
                String spanString
                    = UString.checkNull(child.getAttribute("span"));
                int spanValue;
                if (spanString != null) {
                    try {
                        spanValue = Integer.parseInt(spanString);
                    } catch (NumberFormatException e) {
                        spanValue = 1;
                    }
                } else {
                    spanValue = 1;
                }
                for (int j = 0;j < spanValue;j++) {
                    Col col = new Col(child, colgroup);
                    colgroup.addCol(col);
                }
                nCols += spanValue;
            }
        }
        if (span == 0) {
            if (nCols == 0) {
                Col col = new Col(colgroup);
                colgroup.addCol(col);
            }
        } else {
            for (int i = nCols;i < span;i++) {
                Col col = new Col(colgroup);
                colgroup.addCol(col);
            }
        }
/*
                String calign = UString.checkNull(child.getAttribute("align"));
                if (calign == null) {
                    calign = align;
                }
                String ctype = UString.checkNull(child.getAttribute("class"));
                if (ctype == null) {
                    ctype = type;
                }
                String cspanArg = UString.checkNull(
                    child.getAttribute("span")
                );
                int cspan;
                if (cspanArg == null) {
                    cspan = 1;
                } else {
                    cspan = Integer.parseInt(cspanArg);
                }
                if (cspan < 0) {
                    _warning("bad span number");
                }
                nCols += cspan;
                while (cspan-- > 0) {
                    Col col = new Col();
                    col.setAlign(calign);
                    col.setWidth(width);
                    col.setClazz(ctype);
                    colgroup.addCol(col);
                }
            }
        }
        if (span == 0) {
            if (nCols == 0) {
                Col col = new Col();
                col.setAlign(align);
                col.setClazz(type);
                colgroup.addCol(col);
            }
        } else {
            for (int i = nCols;i < span;i++) {
                Col col = new Col();
                col.setAlign(align);
                col.setClazz(type);
                colgroup.addCol(col);
            }
        }
*/
        return (colgroup);
    }

    protected THead _buildTHead(Element element) {
        THead thead = new THead(element);
        Content[] contents = _buildContents(element);
        thead.addContents(contents);
        return (thead);
    }

    protected TFoot _buildTFoot(Element element) {
        TFoot tfoot = new TFoot(element);
        Content[] contents = _buildContents(element);
        tfoot.addContents(contents);
        return (tfoot);
    }

    protected TBody _buildTBody(Element element) {
        TBody tbody = new TBody(element);
        Content[] contents = _buildContents(element);
        tbody.addContents(contents);
        return (tbody);
    }

    protected Tr _buildTr(Element element) {
        Tr tr = new Tr(element);
        Content[] contents = _buildContents(element);
        tr.addContents(contents);
        return (tr);
    }

    protected Th _buildTh(Element element) {
        Th th = new Th(element);
        Content[] contents = _buildContents(element);
        th.addContents(contents);
        return (th);
    }

    protected Td _buildTd(Element element) {
        Td td = new Td(element);
        Content[] contents = _buildContents(element);
        td.addContents(contents);
        return (td);
    }

    protected Tnote _buildTnote(Element element) {
        Tnote tnote = new Tnote(element);
        Content[] contents = _buildContents(element);
        tnote.addContents(contents);
        return (tnote);
    }

    protected Pre _buildPre(Element element) {
        Pre pre = new Pre(element);
//        pre.setSource(_getBlockString(element));
//        pre.setText(_getBlockString(element));
        Content[] contents = _buildContents(element);
        pre.addContents(contents);
        return (pre);
    }

    protected Program _buildProgram(Element element) {
        Program program = new Program(element);
//        program.setSource(_getBlockString(element));
//        program.setText(_getBlockString(element));
        Content[] contents = _buildContents(element);
        program.addContents(contents);
        _setupTitle(program, element);
        return (program);
    }

    protected Console _buildConsole(Element element) {
        Console console = new Console(element);
//        console.setDisplay(_getBlockString(element));
//        console.setText(_getBlockString(element));
        Content[] contents = _buildContents(element);
        console.addContents(contents);
        _setupTitle(console, element);
        return (console);
    }

    protected Equation _buildEquation(Element element) {
        Equation equation = new Equation(element);
        Content[] contents = _buildContents(element);
        equation.addContents(contents);
        _setupTitle(equation, element);
        return (equation);
    }

    protected Div _buildDiv(Element element) {
        Div div = new Div(element);
        div.addContents(_buildContents(element));
        return (div);
    }

    protected Ref _buildRef(Element element) {
        Ref ref = new Ref(element);
        ref.addContents(_buildContents(element));
        return (ref);
    }

    protected Cite _buildCite(Element element) {
        Cite cite = new Cite(element);
        cite.addContents(_buildContents(element));
        return (cite);
    }

    protected Comment _buildComment(Element element) {
        Comment comment = new Comment(element);
        Content[] contents = _buildContents(element);
        comment.addContents(contents);
        return (comment);
    }

    protected Note _buildNote(Element element) {
        Note note = new Note(element);
        Content[] contents = _buildContents(element);
        note.addContents(contents);
        return (note);
    }

    protected Span _buildSpan(Element element) {
        Span span = new Span(element);
        Content[] contents = _buildContents(element);
        span.addContents(contents);
        return (span);
    }

    protected Term _buildTerm(Element element) {
        Term term = new Term(element);
        Content[] contents = _buildContents(element);
        term.addContents(contents);
        return (term);
    }

    protected Index _buildIndex(Element element) {
        Index index = new Index(element);
        Content[] contents = _buildContents(element);
        index.addContents(contents);
        return (index);
    }

    protected Bold _buildBold(Element element) {
        Bold bold = new Bold(element);
        Content[] contents = _buildContents(element);
        bold.addContents(contents);
        return (bold);
    }

    protected Italic _buildItalic(Element element) {
        Italic italic = new Italic(element);
        Content[] contents = _buildContents(element);
        italic.addContents(contents);
        return (italic);
    }

    protected Dfn _buildDfn(Element element) {
        Dfn dfn = new Dfn(element);
        dfn.addContents(_buildContents(element));
        return (dfn);
    }

    protected Tt _buildTt(Element element) {
        Tt tt = new Tt(element);
        tt.addContents(_buildContents(element));
        return (tt);
    }

    protected Em _buildEm(Element element) {
        Em em = new Em(element);
        em.addContents(_buildContents(element));
        return (em);
    }

    protected Strong _buildStrong(Element element) {
        Strong strong = new Strong(element);
        strong.addContents(_buildContents(element));
        return (strong);
    }

    protected Abbr _buildAbbr(Element element) {
        Abbr abbr = new Abbr(element);
        abbr.addContents(_buildContents(element));
        return (abbr);
    }

    protected Acronym _buildAcronym(Element element) {
        Acronym acronym = new Acronym(element);
        acronym.addContents(_buildContents(element));
        return (acronym);
    }

    protected Code _buildCode(Element element) {
        Code code = new Code(element);
        code.addContents(_buildContents(element));
        return (code);
    }

    protected Blockquote _buildBlockquote(Element element) {
        Blockquote blockquote = new Blockquote(element);
        blockquote.addContents(_buildContents(element));
        return (blockquote);
    }

    protected Quote _buildQuote(Element element) {
        Quote quote = new Quote(element);
        quote.addContents(_buildContents(element));
        return (quote);
    }

    protected TimeCommand _buildTime(Element element) {
        return (new TimeCommand(element));
    }

    protected Native _buildNative(Element element) {
        Native n = new Native(element);
        Content[] contents = _buildContents(element);
        n.addContents(contents);
//        n.setText(UDoc.distillText(n));        // XXX : remains for trim
        return (n);
    }

    protected void _buildInclude(Element element, List list) {
        String src = element.getAttribute("src");
        if ("".equals(src)) {
            return;
        }
        List included = (List)includes_.get(src);
        if (includes_.containsKey(src)) {
            if (included != null) {
                list.addAll(included);
            }
              return;
          }
        included = new ArrayList();
        try {
            IProcessor processor = config_.getXMLProcessor();
            URL url = UURL.getURLFromFileOrURLName(src);
            Document xml = processor.parseDocument(url);
            Content[] contents = _buildHeadContents(xml.getDocumentElement());
            for (int i = 0;i < contents.length;i++) {
                included.add(contents[i]);
            }
        } catch (IOException e) {
            // XXX
        }
        includes_.put(src, included);
        list.addAll(included);
    }

    protected TOC _buildTOC(Doc doc) {
        TOC toc = new TOC(doc);
        toc.calcSeqNumber(doc);
        return (toc);
    }

    protected Bibliography _buildBibliography(
        Element element,
        BibliographyDatabase bibDB
    ) {
        Bibliography bib = new Bibliography(element, bibDB);
        return (bib);
    }

    protected Bibliography _buildBibliography(
        Element element
    ) {
        Bibliography bib = new Bibliography(element, bibDB_);
        return (bib);
    }

    protected Bibliopole _buildBibliopole(
        Element element
    ) {
        Bibliopole pole = new Bibliopole(element);
        return (pole);
    }

    protected Glossary _buildGlossary(Element element) {
        return (null);                // XXX
    }

    // control objects

    protected Define _buildDefine(Element element) {
        Define define = new Define(element);
        Content[] contents = _buildContents(element);
        define.addContents(contents);
        return (define);
    }

    protected Refer _buildRefer(Element element) {
        Refer refer = new Refer(element);
        Content[] contents = _buildContents(element);
        refer.addContents(contents);
        return (refer);
    }

    protected Lambda _buildLambda(Element element) {
        Lambda lambda = new Lambda(element);
        Content[] contents = _buildContents(element);
        lambda.addContents(contents);
        return (lambda);
    }

    protected And _buildAnd(Element element) {
        And and = new And(element);
        Content[] contents = _buildContents(element);
        and.addContents(contents);
        return (and);
    }

    protected Or _buildOr(Element element) {
        Or or = new Or(element);
        Content[] contents = _buildContents(element);
        or.addContents(contents);
        return (or);
    }

    protected MacroContent _buildMacroContent(Element element) {
        MacroContent macroContent = new MacroContent(element);
        Content[] contents = _buildContents(element);
        macroContent.addContents(contents);
        return (macroContent);
    }

    protected MacroAttribute _buildMacroAttribute(Element element) {
        MacroAttribute macroAttribute = new MacroAttribute(element);
        Content[] contents = _buildContents(element);
        macroAttribute.addContents(contents);
        return (macroAttribute);
    }

    protected MacroTitle _buildMacroTitle(Element element) {
        MacroTitle macroTitle = new MacroTitle(element);
        Content[] contents = _buildContents(element);
        macroTitle.addContents(contents);
        return (macroTitle);
    }

    protected Symbol _buildSymbol(Element element) {
        Symbol symbol = new Symbol(element);
        Content[] contents = _buildContents(element);
        symbol.addContents(contents);
        return (symbol);
    }

    //

    protected void _collectDfn(
        Container container,
        Indexdef indexdef
    ) {
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof Dfn) {
                Dfn dfn = (Dfn)content;
                indexdef.addDfn(dfn);
            } else if (content instanceof Container) {
                _collectDfn((Container)content, indexdef);
            }
        }
    }

    protected void _collectIndex(
        Container container,
        Indexdef indexdef
    ) {
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof Index) {
                Index index = (Index)content;
                indexdef.addIndex(index);
            } else if (content instanceof Container) {
                _collectIndex((Container)content, indexdef);
            }
        }
    }

/*
    protected void _embedIndexAnchor(
        Container container,
        String[] words,
        Indexdef indexdef
    ) {
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof Sentence) {
                Sentence sentece = (Sentence)content;
                ((Sentence)content).embedAnchor(words, indexdef);
            } else if (content instanceof Container) {
                _embedIndexAnchor((Container)content, words, indexdef);
            }
        }
    }
*/

    protected void _checkDfn(        // XXX
        Container container
    ) {
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof Dfn) {
                System.out.println("OK");
            } else if (content instanceof Container) {
                _checkDfn((Container)content);
            }
        }
    }

    protected void _formatDoc(Doc doc) {
        doc.format();
    }

    protected void _makeTOC(Doc doc) {
        doc.setTOC(_buildTOC(doc));
    }

    protected void _makeIndex(Doc doc) {
        Head head = doc.getHead();
        Body body = doc.getBody();
        Indexdef indexdef = doc.getHead().getIndexdef();
        if (indexdef == null) {
            indexdef = new Indexdef();
        }
        _collectDfn(body, indexdef);
        _collectIndex(body, indexdef);
        String[] words = indexdef.getIndexWords();
        // to avoid partial matching.
        // sort descendent order as string length.
        Arrays.sort(words, new Comparator() {
            public int compare(Object lhs, Object rhs) {
                return (rhs.toString().length() - lhs.toString().length());
            }
        });
/*
        if (false) {
            _embedIndexAnchor(body, words, indexdef);
        }
//        _checkDfn(body);        // XXX
*/
        doc.setIndexdef(indexdef);
    }

    protected void _makeSequenceNumber(Doc doc) {
        UDoc.traverse(doc, new SequenceCounter());
    }

    protected void _resolveLinks(Doc doc) {
        List list = new ArrayList();
        _collectRefs(doc, list);
        Bibliography bib = doc.getBibliography();
        if (bib != null) {
            _collectRefs(bib, list);
        }
        int size = list.size();
        for (int i = 0;i < size;i++) {
            _resolveLink(doc, (Content)list.get(i));
        }
    }

    protected void _collectRefs(Container container, List list) {
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            Title[] titles = content.getAllTitleNodes();
            for (int j = 0;j < titles.length;j++) {
                _collectRefs(titles[j], list);
            }
            if (content instanceof Ref) {
                list.add(content);
            } else if (content.getIdref() != null) {
                list.add(content);
            } else if (content.getLink() != null) { // XXX : needs?
                list.add(content);
            } else if (content instanceof Container) {
                _collectRefs((Container)content, list);
            }
        }
    }

    protected void _resolveLink(Doc doc, Content content) {
        if (content instanceof Ref) {
            _resolveLink(doc, (Ref)content);
        } else {
            _resolveLinkIdref(doc, content);
        }
    }

    protected void _resolveLink(Doc doc, Ref ref) {
        switch (ref.getType()) {

        case Ref.HYPER_LINK:
            // do nothing
            break;
        case Ref.SELF_LINK:
            if (ref.getHref() == null) {
                throw (new InternalError());
            }
            _resolveLink(doc.getBody(), ref);
            if (ref.getLink() == null) {
                Bibliography bib = doc.getBibliography();
                if (bib != null) {
                    _resolveLink(bib, ref);
                }
            }
            if (ref.getLink() == null) {
                _warning("Unresolved link = " + ref.getHref());
            }
            break;
        case Ref.SITE_LINK:
            // do nothing
            break;
        case Ref.UNKNOWN_LINK:
            _resolveDynamicLink(doc.getBody(), ref);
            if (ref.getLink() == null) {
                Bibliography bib = doc.getBibliography();
                if (bib != null) {
                    _resolveDynamicLink(bib, ref);
                }
            }
            break;
        default:
            throw (new InternalError());
        }
    }

    protected void _resolveLink(Container container, Ref ref) {
        _resolveLinkID(container, ref, false);
        if (ref.getLink() != null) {
            return;
        }
        _resolveLinkIDExternalContext(container, ref, false);
        if (ref.getLink() != null) {
            return;
        }
        _resolveLinkTitle(container, ref, false);
    }

    protected boolean _resolveLinkID(
        Container container,
        Ref ref,
        boolean isResolved
    ) {
        String href = ref.getHref();
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            String id = content.getID();
            // XXX : handle external link
            if (content.getDocContext() == ref.getDocContext()) {
                if (href.equals(id)) {
                    if (isResolved) {
                        _warning("Duplicate link id = " + href);
                    } else {
                        ref.setLink(content);
                        content.addReferer(ref);
                        isResolved = true;
                    }
                }
            }
            if (content instanceof Container) {
                isResolved
                    = _resolveLinkID((Container)content, ref, isResolved);
            }
        }
        return (isResolved);
    }

    protected boolean _resolveLinkIDExternalContext(
        Container container,
        Ref ref,
        boolean isResolved
    ) {
        String href = ref.getHref();
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            String id = content.getID();
            // XXX : handle external link
            if (href.equals(id)) {
                if (isResolved) {
                    _warning("Duplicate link id = " + href);
                } else {
                    ref.setLink(content);
                    content.addReferer(ref);
                    isResolved = true;
                }
            }
            if (content instanceof Container) {
                isResolved = _resolveLinkIDExternalContext(
                    (Container)content,
                    ref,
                    isResolved
                );
            }
        }
        return (isResolved);
    }

    protected boolean _resolveLinkTitle(
        Container container,
        Ref ref,
        boolean isResolved
    ) {
        String href = ref.getHref();
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            String title = content.getTitle();
            if (href.equals(title)) {
                if (isResolved) {
                    _warning("Ambiguous link title = " + href);
                } else {
                    ref.setLink(content);
                    content.addReferer(ref);
                    isResolved = true;
                }
            }
            if (content instanceof Container) {
                isResolved
                    = _resolveLinkTitle((Container)content, ref, isResolved);
            }
        }
        return (isResolved);
    }

    protected void _resolveDynamicLink(Container container, Ref ref) {
        _resolveDynamicLink(container, ref, false);
    }

    /**
     * @return 0 terminate
     *         1 ref search
     *         2 do resolve
     */
    protected int _resolveDynamicLink(
        Container container,
        Ref ref,
        boolean doResolve
    ) {
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content == ref) {
                doResolve = true;
            }
            if (doResolve) {
                String id = content.getExplicitID();
                if (id != null) {
                    ref.setHref("#" + id);
                    ref.setLink(content);
                    content.addReferer(ref);
                    return (0);
                }
                if (content instanceof FloatingObject) {
                    id = content.getID();
                    ref.setHref("#" + id);
                    ref.setLink(content);
                    content.addReferer(ref);
                    return (0);
                }
            }
            if (content instanceof Container) {
                int status = _resolveDynamicLink(
                    (Container)content,
                    ref,
                    doResolve
                );
                switch (status) {

                case 0:
                    return (0);
                case 1:
                    doResolve = false;
                    break;
                case 2:
                    doResolve = true;
                    break;
                default:
                    throw (new InternalError("status = " + status));
                }
            }
        }
        if (doResolve) {
            return (2);
        } else {
            return (1);
        }
    }

    protected void _resolveLinkIdref(Doc doc, Content ref) {
        if (ref.getIdref() == null) {
            throw (new InternalError());
        }
        _resolveLinkIdref(doc.getBody(), ref);
        if (ref.getLink() == null) {
/*
            Bibliography bib = doc.getBibliography();
            if (bib != null) {
                _resolveLinkIdref(bib, ref);
            }
*/
            Bibitem item = bibDB_.get(ref.getIdref());
            if (item != null) {
                ref.setLink(item);
            }
        }
        if (ref.getLink() == null) {
            _warning("Unresolved link = " + ref.getIdref());
        }
    }

    protected void _resolveLinkIdref(Container container, Content ref) {
        _resolveLinkIDIdref(container, ref, false);
        if (ref.getLink() != null) {
            return;
        }
        _resolveLinkIDIdrefExternalContext(container, ref, false);
        if (ref.getLink() != null) {
            return;
        }
        _resolveLinkTitleIdref(container, ref, false);
    }

    protected boolean _resolveLinkIDIdref(
        Container container,
        Content ref,
        boolean isResolved
    ) {
        String href = ref.getIdref();
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            String id = content.getID();
            if (content.getDocContext() == ref.getDocContext()) {
                if (href.equals(id)) {
                    if (isResolved) {
                        _warning("Duplicate link id = " + href);
                    } else {
                        ref.setLink(content);
                        content.addReferer(ref);
                        isResolved = true;
                    }
                }
            }
            if (content instanceof Container) {
                isResolved = _resolveLinkIDIdref(
                    (Container)content,
                    ref,
                    isResolved
                );
            }
        }
        return (isResolved);
    }

    protected boolean _resolveLinkIDIdrefExternalContext(
        Container container,
        Content ref,
        boolean isResolved
    ) {
        String href = ref.getIdref();
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            String id = content.getID();
            if (href.equals(id)) {
                if (isResolved) {
                    _warning("Duplicate link id = " + href);
                } else {
                    ref.setLink(content);
                    content.addReferer(ref);
                    isResolved = true;
                }
            }
            if (content instanceof Container) {
                isResolved = _resolveLinkIDIdrefExternalContext(
                    (Container)content,
                    ref,
                    isResolved
                );
            }
        }
        return (isResolved);
    }

    protected boolean _resolveLinkTitleIdref(
        Container container,
        Content ref,
        boolean isResolved
    ) {
        String href = ref.getIdref();
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            String title = content.getTitle();
            if (href.equals(title)) {
                if (isResolved) {
                    _warning("Ambiguous link title = " + href);
                } else {
                    ref.setLink(content);
                    content.addReferer(ref);
                    isResolved = true;
                }
            }
            if (content instanceof Container) {
                isResolved = _resolveLinkTitleIdref(
                    (Container)content,
                    ref,
                    isResolved
                );
            }
        }
        return (isResolved);
    }

/*
    protected void _adjustXMLLang(Doc doc, DocContext context) {
        if (doc.getExplicitLanguage() != null) {
            return;
        }
        Locale locale = context.getLocale();
        if (locale == null) {
            return;
        }
        doc.setLanguage(locale.toString());
    }
*/

    protected void _allocateFiles(Doc doc, DocContext context) {
        _allocateFilesWhole(doc, "", context.getLocale());
        _allocateFilesPart(doc, "", context.getLocale());
        _allocateFilesChapter(doc, "", context.getLocale());
        _allocateFilesSection(doc, "", context.getLocale());
        _allocateFilesSubSection(doc, "", context.getLocale());
        _allocateFilesSubSubSection(doc, "", context.getLocale());
    }

    protected void _allocateFilesWhole(
        Content content,
        String context,
        Locale locale
    ) {
        String currentContext = context;
        _setAllocateFile(content, "whole", currentContext, locale);
        if (content instanceof Container) {
            Content[] contents = ((Container)content).getContents();
            for (int i = 0;i < contents.length;i++) {
                _allocateFilesWhole(
                    contents[i],
                    currentContext,
                    locale
                );
            }
        }
    }

    protected void _allocateFilesPart(
        Content content,
        String context,
        Locale locale
    ) {
        String currentContext = context;
        if (content instanceof Part) {
            Part part = (Part)content;
            currentContext = context + "_p" + _getSeqNumber(part);
        } else if (content instanceof Appendix) {
            currentContext = context + "_a";
        } else if (content instanceof Bibliography) {
            currentContext = context + "_bib";
        }
        _setAllocateFile(content, "part", currentContext, locale);
        if (content instanceof Container) {
            Content[] contents = ((Container)content).getContents();
            for (int i = 0;i < contents.length;i++) {
                _allocateFilesPart(
                    contents[i],
                    currentContext,
                    locale
                );
            }
        }
    }

    protected void _allocateFilesChapter(
        Content content,
        String context,
        Locale locale
    ) {
        String currentContext = context;
        if (content instanceof Part) {
            Part part = (Part)content;
            currentContext = context + "_p" + _getSeqNumber(part);
        } else if (content instanceof Chapter) {
            Chapter chapter = (Chapter)content;
            currentContext = context + "_c" + _getSeqNumber(chapter);
        } else if (content instanceof Appendix) {
            currentContext = context + "_a";
        } else if (content instanceof Bibliography) {
            TitledBlock parent
                = UDoc.getParentTitledBlock(content.getParent());
            if (parent == null ||
                parent instanceof Part) {

                currentContext = context + "_bib";
            }
        }
        _setAllocateFile(content, "chapter", currentContext, locale);
        if (content instanceof Container) {
            Content[] contents = ((Container)content).getContents();
            for (int i = 0;i < contents.length;i++) {
                _allocateFilesChapter(
                    contents[i],
                    currentContext,
                    locale
                );
            }
        }
    }

    protected void _allocateFilesSection(
        Content content,
        String context,
        Locale locale
    ) {
        String currentContext = context;
        if (content instanceof Part) {
            Part part = (Part)content;
            currentContext = context + "_p" + _getSeqNumber(part);
        } else if (content instanceof Chapter) {
            Chapter chapter = (Chapter)content;
            currentContext = context + "_c" + _getSeqNumber(chapter);
        } else if (content instanceof Section) {
            Section section = (Section)content;
            currentContext = context + "_s" + _getSeqNumber(section);
        } else if (content instanceof Appendix) {
            currentContext = context + "_a";
        } else if (content instanceof Bibliography) {
            TitledBlock parent
                = UDoc.getParentTitledBlock(content.getParent());
            if (parent == null ||
                parent instanceof Part ||
                parent instanceof Chapter) {
                currentContext = context + "_bib";
            }
        }
        _setAllocateFile(content, "section", currentContext, locale);
        if (content instanceof Container) {
            Content[] contents = ((Container)content).getContents();
            for (int i = 0;i < contents.length;i++) {
                _allocateFilesSection(
                    contents[i],
                    currentContext,
                    locale
                );
            }
        }
    }

    protected void _allocateFilesSubSection(
        Content content,
        String context,
        Locale locale
    ) {
        String currentContext = context;
        if (content instanceof Part) {
            Part part = (Part)content;
            currentContext = context + "_p" + _getSeqNumber(part);
        } else if (content instanceof Chapter) {
            Chapter chapter = (Chapter)content;
            currentContext = context + "_c" + _getSeqNumber(chapter);
        } else if (content instanceof Section) {
            Section section = (Section)content;
            currentContext = context + "_s" + _getSeqNumber(section);
        } else if (content instanceof SubSection) {
            SubSection subsection = (SubSection)content;
            currentContext = context + "_ss" + _getSeqNumber(subsection);
        } else if (content instanceof Appendix) {
            currentContext = context + "_a";
        } else if (content instanceof Bibliography) {
            TitledBlock parent
                = UDoc.getParentTitledBlock(content.getParent());
            if (parent == null ||
                parent instanceof Part ||
                parent instanceof Chapter ||
                parent instanceof Section) {

                currentContext = context + "_bib";
            }
        }
        _setAllocateFile(content, "subsection", currentContext, locale);
        if (content instanceof Container) {
            Content[] contents = ((Container)content).getContents();
            for (int i = 0;i < contents.length;i++) {
                _allocateFilesSubSection(
                    contents[i],
                    currentContext,
                    locale
                );
            }
        }
    }

    protected void _allocateFilesSubSubSection(
        Content content,
        String context,
        Locale locale
    ) {
        String currentContext = context;
        if (content instanceof Part) {
            Part part = (Part)content;
            currentContext = context + "_p" + _getSeqNumber(part);
        } else if (content instanceof Chapter) {
            Chapter chapter = (Chapter)content;
            currentContext = context + "_c" + _getSeqNumber(chapter);
        } else if (content instanceof Section) {
            Section section = (Section)content;
            currentContext = context + "_s" + _getSeqNumber(section);
        } else if (content instanceof SubSection) {
            SubSection subsection = (SubSection)content;
            currentContext = context + "_ss" + _getSeqNumber(subsection);
        } else if (content instanceof SubSubSection) {
            SubSubSection subsubsection = (SubSubSection)content;
            currentContext = context + "_sss" + _getSeqNumber(subsubsection);
        } else if (content instanceof Appendix) {
            currentContext = context + "_a";
        } else if (content instanceof Bibliography) {
            TitledBlock parent
                = UDoc.getParentTitledBlock(content.getParent());
            if (parent == null ||
                parent instanceof Part ||
                parent instanceof Chapter ||
                parent instanceof Section ||
                parent instanceof SubSection) {

                currentContext = context + "_bib";
            }
        }
        _setAllocateFile(content, "subsubsection", currentContext, locale);
        if (content instanceof Container) {
            Content[] contents = ((Container)content).getContents();
            for (int i = 0;i < contents.length;i++) {
                _allocateFilesSubSubSection(
                    contents[i],
                    currentContext,
                    locale
                );
            }
        }
    }

    private String _getSeqNumber(TitledBlock block) {
        int number = block.getSeqNumber();
        if (number != 0) {
            return (Integer.toString(number));
        } else {
            return ("id" + block.getID());
        }
    }

    private void _setAllocateFile(
        Content content,
        String contextCategory,
        String currentContext,
        Locale locale
    ) {
        // XXX : deprecated
        if (locale != null && !locale.equals(config_.getMasterLocale())) {
            content.setFileID(contextCategory, currentContext + "_" + locale);
        } else {
            content.setFileID(contextCategory, currentContext);
        }
        // XXX : deprecated
        content.setDeployContext(contextCategory, currentContext);
    }

/*
    protected void _allocateFilesSection(
        Content content,
        String context,
        Locale locale
    ) {
        String currentContext = context;
        if (content instanceof Section) {
            Section section = (Section)content;
            currentContext = context + "_s" + section.getSeqNumber();
        }
        if (locale != null && !locale.equals(config_.getMasterLocale())) {
            content.setFileID("section", currentContext + "_" + locale);
        } else {
            content.setFileID("section", currentContext);
        }
        content.setDeployContext("section", currentContext);
        if (content instanceof Container) {
            Content[] contents = ((Container)content).getContents();
            for (int i = 0;i < contents.length;i++) {
                _allocateFilesSection(
                    contents[i],
                    currentContext,
                    locale
                );
            }
        }
    }
*/

    protected String _getString(Element element) {
        // XXX : linebreak normalization
        return (_getRawString(element).trim());
    }

    protected String _getBlockString(Element element) {
        // XXX : linebreak normalization -> normalizer
        // XXX : null line normalization -> normalizer
        return (
            UString.trimEmptyLines(
                UString.makeCanonicalString(
                    _getRawString(element)
                )
            )
        );
/*
        String string = _getRawString(element);
        if (string.length() > 0) {
            if (string.charAt(0) == '\n') {
                return (string.substring(1));
            } else if (string.charAt(0) == '\r') {
                if (string.length() > 1 &&
                    string.charAt(1) == '\n') {

                    return (string.substring(2));
                } else {
                    return (string.substring(1));
                }
            }
        }
        return (string);
*/
    }


    // XXX : trim?
    protected void _getString(Element element, StringBuffer buffer) {
        NodeList list = element.getChildNodes();
        int size = list.getLength();
        for (int i = 0;i < size;i++) {
            Node node = list.item(i);
            switch (node.getNodeType()) {

            case Node.ELEMENT_NODE:
                _getString(element, buffer);
                break;
            case Node.TEXT_NODE:
                buffer.append(((Text)node).getData());
                break;
            }
        }
    }

    protected String _getString(EntityReference eref) {
        StringBuffer buffer = new StringBuffer();
        _getString(eref, buffer);
        return (new String(buffer));
    }

    protected void _getString(EntityReference eref, StringBuffer buffer) {
        NodeList list = eref.getChildNodes();
        int size = list.getLength();
        for (int i = 0;i < size;i++) {
            Node node = list.item(i);
            switch (node.getNodeType()) {

            case Node.TEXT_NODE:
                buffer.append(((Text)node).getData());
                break;
            case Node.ELEMENT_NODE:
                _getString((Element)node, buffer);
                break;
            default:
                throw (new InternalError("bad node = " + node.getNodeType()));
            }
        }
    }

    // XXX
    protected void _getString(Entity entity, StringBuffer buffer) {
        System.out.println(entity.getPublicId());
        System.out.println(entity.getSystemId());
        System.out.println(entity.getNotationName());
    }

    protected String _getString(CDATASection cdata) {
        return (cdata.getData());
    }

    protected String _getRawString(Element element) {
        StringBuffer buffer = new StringBuffer();
        NodeList list = element.getChildNodes();
        int size = list.getLength();
        for (int i = 0;i < size;i++) {
            Node node = list.item(i);
            switch (node.getNodeType()) {

            case Node.ELEMENT_NODE:
                _getString((Element)node, buffer);
                break;
            case Node.TEXT_NODE:
                buffer.append(((Text)node).getData());
                break;
            case Node.CDATA_SECTION_NODE:
                buffer.append(_getString((CDATASection)node));
                break;
            case Node.ENTITY_NODE:
                String name = ((Entity)node).getNotationName();
                if (name != null) {
                    char c = cemap_.getCharacter(name);
                    if (c != 0) {
                        buffer.append(c);
                    } else {
                        throw (new InternalError("bad entity"));
                    }
                }
                break;
            case Node.ENTITY_REFERENCE_NODE:
                _getString((EntityReference)node, buffer);
                break;
            }
        }
        return (new String(buffer));
    }

    protected void _warning(String message) throws SmartDocWarningException {
        monitor_.warning(message);
//        throw (new SmartDocWarningException(message));
    }

    protected void _error(String message) throws SmartDocErrorException {
        monitor_.error(message);
        throw (new SmartDocErrorException(message));
    }

    //
    private Document _goldenport(Document doc, DocContext docContext) 
      throws RemoteException {
        if (!config_.isGoldenport()) {
            return (doc);
        }
        Goldenport goldenport = new Goldenport();
        goldenport.setXmlBase(docContext.getBaseDirectory());
        GcGoldenportConfig config = new GcGoldenportConfig();
        GcAdapter adapter = new GcAdapter();
        adapter.setJavaClass("org.xmlsmartdoc.goldenport.adapters.WhatsNewAdapter");
        GcProperty property = new GcProperty();
        property.setName("suffix");
        property.setValue("html");
        adapter.addProperty(property);
        config.addAdapter(adapter);
        adapter = new GcAdapter();
        adapter.setJavaClass("org.xmlsmartdoc.goldenport.adapters.SmartDocAdapter");
        if (config_.isIdGlobal()) {
            property = new GcProperty();
            property.setName(SmartDocAdapter.PROPERTY_ADJUST_IDS);
            property.setValue("false");
            adapter.addProperty(property);
        }
        config.addAdapter(adapter);
        goldenport.setSystemConfig(config);
        return (goldenport.evalDocument(doc));
    }
}
