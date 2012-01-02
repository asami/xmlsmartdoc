/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@zeomtech.com)
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
package org.xmlsmartdoc.SmartDoc.cdf;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.xmlsmartdoc.SmartDoc.AbstractSmartDocGeneratorBase;
import org.xmlsmartdoc.SmartDoc.Bibliography;
import org.xmlsmartdoc.SmartDoc.Chapter;
import org.xmlsmartdoc.SmartDoc.Container;
import org.xmlsmartdoc.SmartDoc.Doc;
import org.xmlsmartdoc.SmartDoc.Part;
import org.xmlsmartdoc.SmartDoc.Section;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocFormatConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocModel;
import org.xmlsmartdoc.SmartDoc.SubSection;
import org.xmlsmartdoc.SmartDoc.SubSubSection;
import org.xmlsmartdoc.SmartDoc.UDoc;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;
import com.AsamiOffice.jaba2.j2fw.generator.XMLArtifact;
import com.AsamiOffice.jaba2.xml.IProcessor;
import com.AsamiOffice.jaba2.xml.pdom.PDOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.AsamiOffice.xml.UElement;

/**
 * CDFGenerator
 *
 * @since   Aug. 28, 1999
 * @version Oct. 19, 2003
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class CDFGenerator extends AbstractSmartDocGeneratorBase {
    protected CDFConfig cdfConfig_;
    protected File channelFile_;
    IProcessor processor_;
    protected String baseURL_;

    public void init(SmartDocConfig config, SmartDocFormatConfig fconfig) {
        super.init(config, fconfig);
        cdfConfig_ = (CDFConfig)fconfig;
        channelFile_ = cdfConfig_.getChannelFile();
        processor_ = config_.getXMLProcessor();
        baseURL_ = cdfConfig_.getBaseURL();
    }

    public GeneratorArtifact generateWhole(
        Doc doc,
        String deploy,
        SmartDocModel model
    ) {
        try {
            Document channel;
            String path;
            if (channelFile_ != null) {
                channel = processor_.parseDocument(channelFile_.toURL());
                path = channelFile_.getPath();
            } else {
                channel = new PDOM().createDocument("XML"); // XXX
                path = getPhysicalFile(doc, deploy);
            }
            Element item = _makeCDFItem(channel, doc, deploy);
            return (new XMLArtifact(path, item, cdfConfig_.getEncoding(doc)));
        } catch (IOException e) {
            throw (new InternalError(e.getMessage()));
        }
    }

    public GeneratorArtifact generateTitle(
        Doc doc,
        String deploy,
        SmartDocModel model
    ) {
        try {
            Document channel
                = processor_.parseDocument(channelFile_.toURL());
            Element item = _makeCDFItem(channel, doc, deploy);
            return (new XMLArtifact(channelFile_.getPath(), item));
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    public GeneratorArtifact generatePartTitle(
        Doc doc,
        Part part,
        String deploy,
        SmartDocModel model
    ) {
        try {
            Document channel
                = processor_.parseDocument(channelFile_.toURL());
            Element item = _makeCDFItem(channel, part, deploy);
            return (new XMLArtifact(channelFile_.getPath(), item));
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    public GeneratorArtifact generatePart(
        Doc doc,
        Part part,
        String deploy,
        SmartDocModel model
    ) {
        try {
            Document channel
                = processor_.parseDocument(channelFile_.toURL());
            Element item = _makeCDFItem(channel, part, deploy);
            return (new XMLArtifact(channelFile_.getPath(), item));
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    public GeneratorArtifact generateChapterTitle(
        Doc doc,
        Chapter chapter,
        String deploy,
        SmartDocModel model
    ) {
        try {
            Document channel
                = processor_.parseDocument(channelFile_.toURL());
            Element item = _makeCDFItem(channel, chapter, deploy);
            return (new XMLArtifact(channelFile_.getPath(), item));
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    public GeneratorArtifact generateChapter(
        Doc doc,
        Chapter chapter,
        String deploy,
        SmartDocModel model
    ) {
        try {
            Document channel
                = processor_.parseDocument(channelFile_.toURL());
            Element item = _makeCDFItem(channel, chapter, deploy);
            return (new XMLArtifact(channelFile_.getPath(), item));
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    public GeneratorArtifact generateSectionTitle(
        Doc doc,
        Section section,
        String deploy,
        SmartDocModel model
    ) {
        try {
            Document channel
                = processor_.parseDocument(channelFile_.toURL());
            Element item = _makeCDFItem(channel, section, deploy);
            return (new XMLArtifact(channelFile_.getPath(), item));
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    public GeneratorArtifact generateSection(
        Doc doc,
        Section section,
        String deploy,
        SmartDocModel model
    ) {
        try {
            Document channel
                = processor_.parseDocument(channelFile_.toURL());
            Element item = _makeCDFItem(channel, section, deploy);
            return (new XMLArtifact(channelFile_.getPath(), item));
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    public GeneratorArtifact generateSubSectionTitle(
        Doc doc,
        SubSection subsection,
        String deploy,
        SmartDocModel model
    ) {
        try {
            Document channel
                = processor_.parseDocument(channelFile_.toURL());
            Element item = _makeCDFItem(channel, subsection, deploy);
            return (new XMLArtifact(channelFile_.getPath(), item));
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    public GeneratorArtifact generateSubSection(
        Doc doc,
        SubSection subsection,
        String deploy,
        SmartDocModel model
    ) {
        try {
            Document channel
                = processor_.parseDocument(channelFile_.toURL());
            Element item = _makeCDFItem(channel, subsection, deploy);
            return (new XMLArtifact(channelFile_.getPath(), item));
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    protected Element _makeCDFItem(
        Document channel,
        Container container,
        String deploy
    ) {
        String lastMod = _getTimeAsISO8601();
        String title = container.getTitle();
        if (title == null) {
            title = UDoc.getDocTitle(container);
        }
        String summary = UDoc.getShortSummary(container);
        String file = getLogicalFileBody(container) + ".html";

        Element item = channel.createElement("ITEM");
        String href;
        if (baseURL_ != null) {
            href = baseURL_ + file.toString();
        } else {
            href = file.toString();
        }
        item.setAttribute("HREF", href);
        item.setAttribute("MIMETYPE", "text/html");
        if (lastMod != null) {
            item.setAttribute("LASTMOD", lastMod);
        }
        if (title != null) {
            UElement.appendElement(item, "TITLE", title);
        }
        if (summary != null) {
            UElement.appendElement(item, "ABSTRACT", "VALUE", summary);
        }
        return (item);
    }

    protected String _getTimeAsISO8601() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        int tzoff = cal.get(Calendar.ZONE_OFFSET);
        Format df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        if (tzoff == 0) {
            return (df.format(date));
        } else {
            String prefix;
            if (tzoff > 0) {
                prefix = "+";
            } else {
                prefix = "-";
            }
            tzoff = Math.abs(tzoff);
            tzoff = tzoff / (1000 * 60 * 60);
            String number = Integer.toString(tzoff);
            if (number.length() == 1) {
                number = "0" + number;
            }
            return (df.format(date) + prefix + number + "00");
        }
    }

    // XXX : should divide AbstractSmartDocGeneratorBase 2 classes
    protected void _makeDoc(Doc doc, StringBuffer buffer) {
    }

    protected void _makeTitlePage(
        Doc doc,
        StringBuffer buffer
    ) {
    }

    protected void _makePartTitlePage(
        Doc doc,
        Part part,
        StringBuffer buffer
    ) {
    }

    protected void _makePartPage(
        Doc doc,
        Part part,
        StringBuffer buffer
    ) {
    }

    protected void _makeChapterTitlePage(
        Doc doc,
        Chapter chapter,
        StringBuffer buffer
    ) {
    }

    protected void _makeChapterPage(
        Doc doc,
        Chapter chapter,
        StringBuffer buffer
    ) {
    }

    protected void _makeSectionTitlePage(
        Doc doc,
        Section section,
        StringBuffer buffer
    ) {
    }

    protected void _makeSectionPage(
        Doc doc,
        Section section,
        StringBuffer buffer
    ) {
    }

    protected void _makeSubSectionTitlePage(
        Doc doc,
        SubSection subsection,
        StringBuffer buffer
    ) {
    }

    protected void _makeSubSectionPage(
        Doc doc,
        SubSection subsection,
        StringBuffer buffer
    ) {
    }

    protected void _makeSubSubSectionTitlePage(
        Doc doc,
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
    }

    protected void _makeSubSubSectionPage(
        Doc doc,
        SubSubSection subsubsection,
        StringBuffer buffer
    ) {
    }

    protected void _makeBibliographyPage(
        Doc doc,
        Bibliography bib,
        StringBuffer buffer
    ) {
    }
}
