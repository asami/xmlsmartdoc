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

package org.xmlsmartdoc.SmartDoc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.IGeneratorParameter;
import com.AsamiOffice.jaba2.j2fw.generator.LinkArtifact;
import com.AsamiOffice.jaba2.j2fw.generator.TextArtifact;

import com.AsamiOffice.io.UURL;

/**
 * AbstractSmartDocGeneratorBase
 *
 * @since   Aug. 10, 1999
 * @version Mar. 17, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class AbstractSmartDocGeneratorBase
    extends AbstractSmartDocGenerator {

    private String localeDelimiter_ = "_";
    private boolean makeNegotiator_ = false;
    transient protected boolean makeTOC_ = false;        // XXX : make TOC in _makeBodyPrologueContent
    transient protected boolean makePart_ = true;
    transient protected boolean makeChapter_ = true;
    transient protected boolean makeSection_ = true;
    transient protected boolean makeSubSection_ = true;
    transient protected boolean makeSubSubSection_ = true;
    transient protected boolean makeBibliography_ = true;
    // List<GeneratorArtifact>
    transient protected List artifacts_ = new ArrayList();

    // SmartDocGenerator
    public void init(SmartDocConfig config, SmartDocFormatConfig fconfig) {
        super.init(config, fconfig);
    }

    protected void _setLocaleDelimiter(String delimiter) {
        localeDelimiter_ = delimiter;
    }

    protected void _useNegotiator(boolean use) {
        makeNegotiator_ = use;
    }

    // IGenerator
    public GeneratorResult generate(IGeneratorParameter iparam) {
        GeneratorParameter param = (GeneratorParameter)iparam;
        model_ = param.model;        // XXX
        _prepareDoc(param.doc);
        String deploy;
        if (formatConfig_.isDeploy()) {
            deploy = param.deploy;
        } else {
            deploy = "whole";
        }
        _setLocaleDelimiter(config_.getLocaleDelimiter());
        GeneratorResult result = new GeneratorResult();
        _generateDocuments(
            param.doc,
            param.doc,
            deploy,
            param.project,
            result
        );
        _generateArtifacts(result);
        _generateArtifacts(
            param.doc,
            result
        );
        int nArtifacts = artifacts_.size();
        for (int i = 0;i < nArtifacts;i++) {
            result.addArtifact((GeneratorArtifact)artifacts_.get(i));
        }
        return (result);
    }

    protected void _generateDocuments(
        Doc doc,
        Container container,
        String deploy,
        String project,
        GeneratorResult result
    ) {
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof Body) {
                Body body = (Body)content;
                if ("part".equals(deploy) ||
                    "chapter".equals(deploy) ||
                    "section".equals(deploy) ||
                    "subsection".equals(deploy) ||
                    "subsubsection".equals(deploy)) {

                    GeneratorArtifact artifact
                        = generateTitle(doc, deploy, model_);
                    if (artifact != null) {
                        result.addArtifact(artifact);
                    }
                    _generateDocuments(doc, body, deploy, project, result);
                    artifact = generateBibliography(doc, deploy, model_);
                    if (artifact != null) {
                        result.addArtifact(artifact);
                    }
                } else {
                    GeneratorArtifact artifact
                        = generateWhole(doc, deploy, model_);
                    if (artifact != null) {
                        result.addArtifact(artifact);
                    }
                }
            } else if (content instanceof Part) {
                Part part = (Part)content;
                if ("part".equals(deploy)) {
                    GeneratorArtifact artifact
                        = generatePart(doc, part, deploy, model_);
                    if (artifact != null) {
                        result.addArtifact(artifact);
                    }
                } else if ("chapter".equals(deploy) ||
                           "section".equals(deploy) ||
                           "subsection".equals(deploy) ||
                           "subsubsection".equals(deploy)) {

                    GeneratorArtifact artifact
                        = generatePartTitle(doc, part, deploy, model_);
                    if (artifact != null) {
                        result.addArtifact(artifact);
                    }
                    _generateDocuments(
                        doc,
                        part,
                        deploy,
                        project,
                        result
                    );
                }
            } else if (content instanceof Chapter) {
                Chapter chapter = (Chapter)content;
                if ("chapter".equals(deploy)) {
                    GeneratorArtifact artifact
                        = generateChapter(doc, chapter, deploy, model_);
                    if (artifact != null) {
                        result.addArtifact(artifact);
                    }                            
                } else if ("section".equals(deploy) ||
                           "subsection".equals(deploy) ||
                           "subsubsection".equals(deploy)) {

                    GeneratorArtifact artifact
                        = generateChapterTitle(doc, chapter, deploy, model_);
                    if (artifact != null) {
                        result.addArtifact(artifact);
                    }
                    _generateDocuments(
                        doc,
                        chapter,
                        deploy,
                        project,
                        result
                    );
                }
            } else if (content instanceof Section) {
                Section section = (Section)content;
                if ("section".equals(deploy)) {
                    GeneratorArtifact artifact =
                        generateSection(doc, section, deploy, model_);
                    if (artifact != null) {
                        result.addArtifact(artifact);
                    }
                } else if ("subsection".equals(deploy) ||
                           "subsubsection".equals(deploy)) {

                    GeneratorArtifact artifact =
                        generateSectionTitle(doc, section, deploy, model_);
                    if (artifact != null) {
                        result.addArtifact(artifact);
                    }
                    _generateDocuments(
                        doc,
                        section,
                        deploy,
                        project,
                        result
                    );
                }
            } else if (content instanceof SubSection) {
                SubSection subsection = (SubSection)content;
                if ("subsection".equals(deploy)) {
                    GeneratorArtifact artifact
                        = generateSubSection(doc, subsection, deploy, model_);
                    if (artifact != null) {
                        result.addArtifact(artifact);
                    }
                } else if ("subsubsection".equals(deploy)) {
                    GeneratorArtifact artifact
                        = generateSubSectionTitle(
                            doc,
                            subsection,
                            deploy,
                            model_
                        );
                    if (artifact != null) {
                        result.addArtifact(artifact);
                    }                        
                    _generateDocuments(
                        doc,
                        subsection,
                        deploy,
                        project,
                        result
                    );
                }
            } else if (content instanceof SubSubSection) {
                SubSubSection subsubsection = (SubSubSection)content;
                if ("subsubsection".equals(deploy)) {
                    GeneratorArtifact artifact
                        = generateSubSubSection(
                            doc,
                            subsubsection,
                            deploy,
                            model_
                        );
                    if (artifact != null) {
                        result.addArtifact(artifact);
                    }
                } else {
                    throw (new InternalError());
                }
            } else if (content instanceof Bibliography) {
                if (true) {
                    Bibliography bib = (Bibliography)content;
                    GeneratorArtifact artifact
                        = generateBibliography(
                            doc,
                            bib,
                            deploy,
                            model_
                        );
                    if (artifact != null) {
                        result.addArtifact(artifact);
                    }
                } else {
                    throw (new InternalError());
                }
            } else if (content instanceof Container) {
                _generateDocuments(
                    doc,
                    (Container)content,
                    deploy,
                    project,
                    result
                );
            }
        }
    }

    // if needed virtually 1st pass
    protected void _prepareDoc(Doc doc) {
    }

    public GeneratorArtifact generateWhole(
        Doc doc,
        String deploy,
        SmartDocModel model
    ) {
        DocContext context = doc.getDocContext();
        return (new TextArtifact(
            getPhysicalFile(doc, deploy),
            _generateWhole(doc, deploy, model),
            formatConfig_.getEncoding(doc)
        ));
    }

    public GeneratorArtifact generateTitle(
        Doc doc,
        String deploy,
        SmartDocModel model
    ) {
        DocContext context = doc.getDocContext();
        return (new TextArtifact(
            getPhysicalFile(doc, deploy),
            _generateTitle(doc, deploy, model),
            formatConfig_.getEncoding(doc)
        ));
    }

    public GeneratorArtifact generatePartTitle(
        Doc doc,
        Part part,
        String deploy,
        SmartDocModel model
    ) {
        DocContext context = doc.getDocContext();
        return (new TextArtifact(
            getPhysicalFile(part, deploy),
            _generatePartTitle(doc, part, deploy, model),
            formatConfig_.getEncoding(doc)
        ));
    }

    public GeneratorArtifact generatePart(
        Doc doc,
        Part part,
        String deploy,
        SmartDocModel model
    ) {
        DocContext context = doc.getDocContext();
        return (new TextArtifact(
            getPhysicalFile(part, deploy),
            _generatePart(doc, part, deploy, model),
            formatConfig_.getEncoding(doc)
        ));
    }

    public GeneratorArtifact generateChapterTitle(
        Doc doc,
        Chapter chapter,
        String deploy,
        SmartDocModel model
    ) {
        DocContext context = doc.getDocContext();
        return (new TextArtifact(
            getPhysicalFile(chapter, deploy),
            _generateChapterTitle(doc, chapter, deploy, model),
            formatConfig_.getEncoding(doc)
        ));
    }

    public GeneratorArtifact generateChapter(
        Doc doc,
        Chapter chapter,
        String deploy,
        SmartDocModel model
    ) {
        DocContext context = doc.getDocContext();
        return (new TextArtifact(
            getPhysicalFile(chapter, deploy),
            _generateChapter(doc, chapter, deploy, model),
            formatConfig_.getEncoding(doc)
        ));
    }

    public GeneratorArtifact generateSectionTitle(
        Doc doc,
        Section section,
        String deploy,
        SmartDocModel model
    ) {
        DocContext context = doc.getDocContext();
        return (new TextArtifact(
            getPhysicalFile(section, deploy),
            _generateSectionTitle(doc, section, deploy, model),
            formatConfig_.getEncoding(doc)
        ));
    }

    public GeneratorArtifact generateSection(
        Doc doc,
        Section section,
        String deploy,
        SmartDocModel model
    ) {
        DocContext context = doc.getDocContext();
        return (new TextArtifact(
            getPhysicalFile(section, deploy),
            _generateSection(doc, section, deploy, model),
            formatConfig_.getEncoding(doc)
        ));
    }

    public GeneratorArtifact generateSubSectionTitle(
        Doc doc,
        SubSection subsection,
        String deploy,
        SmartDocModel model
    ) {
        DocContext context = doc.getDocContext();
        return (new TextArtifact(
            getPhysicalFile(subsection, deploy),
            _generateSubSectionTitle(doc, subsection, deploy, model),
            formatConfig_.getEncoding(doc)
        ));
    }

    public GeneratorArtifact generateSubSection(
        Doc doc,
        SubSection subsection,
        String deploy,
        SmartDocModel model
    ) {
        DocContext context = doc.getDocContext();
        return (new TextArtifact(
            getPhysicalFile(subsection, deploy),
            _generateSubSection(doc, subsection, deploy, model),
            formatConfig_.getEncoding(doc)
        ));
    }

    public GeneratorArtifact generateSubSubSectionTitle(
        Doc doc,
        SubSubSection subsubsection,
        String deploy,
        SmartDocModel model
    ) {
        DocContext context = doc.getDocContext();
        return (new TextArtifact(
            getPhysicalFile(subsubsection, deploy),
            _generateSubSubSectionTitle(doc, subsubsection, deploy, model),
            formatConfig_.getEncoding(doc)
        ));
    }

    public GeneratorArtifact generateSubSubSection(
        Doc doc,
        SubSubSection subsubsection,
        String deploy,
        SmartDocModel model
    ) {
        DocContext context = doc.getDocContext();
        return (new TextArtifact(
            getPhysicalFile(subsubsection, deploy),
            _generateSubSubSection(doc, subsubsection, deploy, model),
            formatConfig_.getEncoding(doc)
        ));
    }

    public GeneratorArtifact generateBibliography(
        Doc doc,
        Bibliography bib,
        String deploy,
        SmartDocModel model
    ) {
        return (new TextArtifact(
            getPhysicalFile(bib, deploy),
            _generateBibliography(doc, bib, deploy, model),
            formatConfig_.getEncoding(doc)
        ));
    }

    public GeneratorArtifact generateBibliography(
        Doc doc,
        String deploy,
        SmartDocModel model
    ) {
        Bibliography bib = doc.getBibliography();
        if (bib == null) {
            return (null);
        }
        return (generateBibliography(doc, bib, deploy, model));
    }

    public String getLogicalFileBody(Content content) {
        DocContext context = content.getDocContext();
        String project = context.getProject();
        String deploy = context.getDeploy();
        Locale locale = context.getLocale();
        String deployContext = content.getDeployContext(deploy);
        String filename;
        if (deployContext != null) {
            filename = project + deployContext;
        } else {
            filename = project;
        }
        if (locale == null) {
            return (filename);
        } else if (locale.equals(config_.getMasterLocale())) {
            return (filename);
        } else {
            return (filename + localeDelimiter_ + locale);
        }
    }

    public String getLogicalFile(Content content) {
        String suffix = formatConfig_.getSuffix();
        return (getLogicalFileBody(content) + "." + suffix);
    }

    public String getPhysicalFile(Content content, Locale locale) {
        return (getPhysicalFile(content, config_.getDeploy(), locale));
    }

/*
    public String getPhysicalFile0(Content content, Locale locale) {
        String project = config_.getProject();
        String deploy = config_.getDeploy();
        String suffix = formatConfig_.getSuffix();
        String deployContext = content.getDeployContext(deploy);
        String filename;
        if (deployContext != null) {
            filename = project + deployContext;
        } else {
            filename = project;
        }
        if (locale.equals(config_.getMasterLocale())) {
            return (filename + "." + suffix);
        } else {
            return (filename + "_" + locale + "." + suffix);
        }
    }
*/

    public String getPhysicalFile(Content content, String deploy) {
        return (getPhysicalFile(content, deploy, content.getDocContext().getLocale()));
    }

    public String getPhysicalFile(Content content, String deploy, Locale locale) {
        deploy = USmartDoc.getAlloc(deploy);
        String project = config_.getProject();
        String suffix = formatConfig_.getSuffix();
        String deployContext = content.getDeployContext(deploy);
        if (deployContext == null) {
            deployContext = "";
        }
        if (makeNegotiator_) {
            if (locale == null) {
                return (project + deployContext + "." + suffix);
            } else {
                return (project + deployContext + "." + suffix + "." + locale);
            }
        } else {
            if (locale != null) {
                if (!locale.equals(config_.getMasterLocale())) {
                    deployContext = deployContext + localeDelimiter_ + locale;
                }
            }
            return (project + deployContext + "." + suffix);
        }
    }

    protected void _addArtifact(GeneratorArtifact artifact) {
        artifacts_.add(artifact);
    }

    protected String _generateWhole(
        Doc doc,
        String deploy,
        SmartDocModel model
    ) {
        model_ = model;
        makeTOC_ = config_.makeToc();
        makeChapter_ = true;
        makeSection_ = true;
        StringBuffer buffer = new StringBuffer();
        _makeDoc(doc, buffer);
        return (new String(buffer));
    }

    protected String _generateTitle(
        Doc doc,
        String deploy,
        SmartDocModel model
    ) {
        model_ = model;
        makeTOC_ = true;
        makePart_ = false;
        makeChapter_ = false;
        makeSection_ = false;
        makeBibliography_ = false;
        StringBuffer buffer = new StringBuffer();
        _makeTitlePage(doc, buffer);
        return (new String(buffer));
    }

    protected String _generatePartTitle(
        Doc doc,
        Part part,
        String deploy,
        SmartDocModel model
    ) {
        model_ = model;
        makeTOC_ = true;
        makeChapter_ = false;
        makeSection_ = false;
        makeBibliography_ = false;
        StringBuffer buffer = new StringBuffer();
        _makePartTitlePage(doc, part, buffer);
        return (new String(buffer));
    }

    protected String _generatePart(
        Doc doc,
        Part part,
        String deploy,
        SmartDocModel model
    ) {
        model_ = model;
        makeTOC_ = true;
        makeChapter_ = true;
        makeSection_ = true;
        makeBibliography_ = true; // XXX
        StringBuffer buffer = new StringBuffer();
        _makePartPage(doc, part, buffer);
        return (new String(buffer));
    }

    protected String _generateChapterTitle(
        Doc doc,
        Chapter chapter,
        String deploy,
        SmartDocModel model
    ) {
        model_ = model;
        makeTOC_ = true;
        makeChapter_ = true;
        makeSection_ = false;
        makeBibliography_ = false;
        StringBuffer buffer = new StringBuffer();
        _makeChapterTitlePage(doc, chapter, buffer);
        return (new String(buffer));
    }

    protected String _generateChapter(
        Doc doc,
        Chapter chapter,
        String deploy,
        SmartDocModel model
    ) {
        model_ = model;
        makeTOC_ = true;
        makeChapter_ = true;
        makeSection_ = true;
        makeBibliography_ = true;
        StringBuffer buffer = new StringBuffer();
        _makeChapterPage(doc, chapter, buffer);
        return (new String(buffer));
    }

    protected String _generateSectionTitle(
        Doc doc,
        Section section,
        String deploy,
        SmartDocModel model
    ) {
        model_ = model;
        makeTOC_ = true;
        makeChapter_ = true;
        makeSection_ = true;
        makeSubSection_ = false;
        makeSubSubSection_ = false;
        makeBibliography_ = false;
        StringBuffer buffer = new StringBuffer();
        _makeSectionTitlePage(doc, section, buffer);
        return (new String(buffer));
    }

    protected String _generateSection(
        Doc doc,
        Section section,
        String deploy,
        SmartDocModel model
    ) {
        model_ = model;
        makeTOC_ = true;
        makeChapter_ = true;
        makeSection_ = true;
        makeBibliography_ = true;
        StringBuffer buffer = new StringBuffer();
        _makeSectionPage(doc, section, buffer);
        return (new String(buffer));
    }

    protected String _generateSubSectionTitle(
        Doc doc,
        SubSection subsection,
        String deploy,
        SmartDocModel model
    ) {
        model_ = model;
        makeTOC_ = true;
        makeChapter_ = true;
        makeSection_ = true;
        makeSubSection_ = true;
        makeSubSubSection_ = false;
        makeBibliography_ = false;
        StringBuffer buffer = new StringBuffer();
        _makeSubSectionTitlePage(doc, subsection, buffer);
        return (new String(buffer));
    }

    protected String _generateSubSection(
        Doc doc,
        SubSection subsection,
        String deploy,
        SmartDocModel model
    ) {
        model_ = model;
        makeTOC_ = true;
        makeChapter_ = true;
        makeSection_ = true;
        makeSubSection_ = true;
        if ("subsection".equals(deploy)) {
            makeSubSubSection_ = true;
        } else {
            makeSubSubSection_ = false;
        }
        makeBibliography_ = true;
        StringBuffer buffer = new StringBuffer();
        _makeSubSectionPage(doc, subsection, buffer);
        return (new String(buffer));
    }

    protected String _generateSubSubSectionTitle(
        Doc doc,
        SubSubSection subsubsection,
        String deploy,
        SmartDocModel model
    ) {
        model_ = model;
        makeTOC_ = true;
        makeChapter_ = true;
        makeSection_ = true;
        makeSubSection_ = true;
        makeSubSubSection_ = false;
        makeBibliography_ = false;
        StringBuffer buffer = new StringBuffer();
        _makeSubSubSectionTitlePage(doc, subsubsection, buffer);
        return (new String(buffer));
    }

    protected String _generateSubSubSection(
        Doc doc,
        SubSubSection subsubsection,
        String deploy,
        SmartDocModel model
    ) {
        model_ = model;
        makeTOC_ = true;
        makeChapter_ = true;
        makeSection_ = true;
        makeSubSection_ = true;
        makeSubSubSection_ = true;
        makeBibliography_ = true;
        StringBuffer buffer = new StringBuffer();
        _makeSubSubSectionPage(doc, subsubsection, buffer);
        return (new String(buffer));
    }

    protected String _generateBibliography(
        Doc doc,
        Bibliography bib,
        String deploy,
        SmartDocModel model
    ) {
        model_ = model;
        makeBibliography_ = true;
        StringBuffer buffer = new StringBuffer();
        _makeBibliographyPage(doc, bib, buffer);
        return (new String(buffer));
    }

    protected void _generateArtifacts(GeneratorResult result) {
    }

    protected void _generateArtifacts(
        Content content,
        GeneratorResult result
    ) {
        if (content instanceof ImageFigure) {
            _generateImageArtifacts((ImageFigure)content, result);
        } else if (content instanceof Img) {
            _generateImageArtifacts((Img)content, result);
        }
        if (content instanceof Container) {
            Container container = (Container)content;
            Content[] contents = container.getContents();
            for (int i = 0;i < contents.length;i++) {
                _generateArtifacts(contents[i], result);
            }
        }
    }

    protected void _generateImageArtifacts(
        ImageFigure image,
        GeneratorResult result
    ) {
        _generateImageLinkArtifacts(image, result);
    }

    protected void _generateImageArtifacts(
        Img image,
        GeneratorResult result
    ) {
        _generateImageLinkArtifacts(image, result);
    }

    protected void _generateImageLinkArtifacts(
        Content image,
        GeneratorResult result
    ) {
        String src = image.getSrc();
        if (src == null) {
            return;
        }
        if (UURL.isURL(src)) {
            // no artifact if src is url link
            return;
        }
        File file = new File(src);
        if (file.isAbsolute()) {
            // no artifact if src is absolute path
            return;
        }
        String srcFileName = USmartDoc.getImageFilename(
            src, 
            image.getDocContext()
        ); 
        LinkArtifact artifact = new LinkArtifact(src, srcFileName);
        File imageDir = config_.getTargetImageDirectory();
        if (imageDir != null) {
            artifact.setDestDir(imageDir); 
        }
        result.addArtifact(artifact);
    }

    // XXX : String _makeDoc(Doc);
    protected abstract void _makeDoc(Doc doc, StringBuffer buffer);
    protected abstract void _makeTitlePage(
        Doc doc,
        StringBuffer buffer
    );
    protected abstract void _makePartTitlePage(
        Doc doc,
        Part part,
        StringBuffer buffer
    );
    protected abstract void _makePartPage(
        Doc doc,
        Part part,
        StringBuffer buffer
    );
    protected abstract void _makeChapterTitlePage(
        Doc doc,
        Chapter chapter,
        StringBuffer buffer
    );
    protected abstract void _makeChapterPage(
        Doc doc,
        Chapter chapter,
        StringBuffer buffer
    );
    protected abstract void _makeSectionTitlePage(
        Doc doc,
        Section section,
        StringBuffer buffer
    );
    protected abstract void _makeSectionPage(
        Doc doc,
        Section section,
        StringBuffer buffer
    );
    protected abstract void _makeSubSectionTitlePage(
        Doc doc,
        SubSection subsection,
        StringBuffer buffer
    );
    protected abstract void _makeSubSectionPage(
        Doc doc,
        SubSection subsection,
        StringBuffer buffer
    );
    protected abstract void _makeSubSubSectionTitlePage(
        Doc doc,
        SubSubSection subsubsection,
        StringBuffer buffer
    );
    protected abstract void _makeSubSubSectionPage(
        Doc doc,
        SubSubSection subsubsection,
        StringBuffer buffer
    );
    protected abstract void _makeBibliographyPage(
        Doc doc,
        Bibliography bib,
        StringBuffer buffer
    );

    protected final String _getLabelPrefix(Ref ref) {
        String prefix = ref.getLabelPrefix();
        if (prefix != null) {
            return (prefix);
        }
        Content link = ref.getLink();
        if (link instanceof ImageFigure) {
            prefix = config_.getLabelPrefixFigure(ref.getLocale());
        } else if (link instanceof Table) {
            prefix = config_.getLabelPrefixTable(ref.getLocale());
        } else if (link instanceof Console) {
            prefix = config_.getLabelPrefixConsole(ref.getLocale());
        } else if (link instanceof Program) {
            prefix = config_.getLabelPrefixProgram(ref.getLocale());
        } else if (link instanceof Part) {
            prefix = config_.getLabelPrefixPart(ref.getLocale());
        } else if (link instanceof Chapter) {
            prefix = config_.getLabelPrefixChapter(ref.getLocale());
        } else if (link instanceof Section) {
            prefix = config_.getLabelPrefixSection(ref.getLocale());
        } else if (link instanceof SubSection) {
            prefix = config_.getLabelPrefixSubsection(ref.getLocale());
        } else if (link instanceof SubSubSection) {
            prefix = config_.getLabelPrefixSubsubsection(ref.getLocale());
        } else if (link instanceof Equation) {
            prefix = config_.getLabelPrefixEquation(ref.getLocale());
        }
        return (prefix);
    }

    protected final String _getLabelSuffix(Ref ref) {
        String suffix = ref.getLabelSuffix();
        if (suffix != null) {
            return (suffix);
        }
        Content link = ref.getLink();
        if (link instanceof ImageFigure) {
            suffix = config_.getLabelSuffixFigure(ref.getLocale());
        } else if (link instanceof Table) {
            suffix = config_.getLabelSuffixTable(ref.getLocale());
        } else if (link instanceof Console) {
            suffix = config_.getLabelSuffixConsole(ref.getLocale());
        } else if (link instanceof Program) {
            suffix = config_.getLabelSuffixProgram(ref.getLocale());
        } else if (link instanceof Part) {
            suffix = config_.getLabelSuffixPart(ref.getLocale());
        } else if (link instanceof Chapter) {
            suffix = config_.getLabelSuffixChapter(ref.getLocale());
        } else if (link instanceof Section) {
            suffix = config_.getLabelSuffixSection(ref.getLocale());
        } else if (link instanceof SubSection) {
            suffix = config_.getLabelSuffixSubsection(ref.getLocale());
        } else if (link instanceof SubSubSection) {
            suffix = config_.getLabelSuffixSubsubsection(ref.getLocale());
        } else if (link instanceof Equation) {
            suffix = config_.getLabelSuffixEquation(ref.getLocale());
        }
        return (suffix);
    }
}
