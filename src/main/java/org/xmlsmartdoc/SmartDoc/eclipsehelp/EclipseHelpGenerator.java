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
package org.xmlsmartdoc.SmartDoc.eclipsehelp;

import java.util.Locale;

import org.xmlsmartdoc.SmartDoc.AbstractSmartDocGenerator;
import org.xmlsmartdoc.SmartDoc.Anchor;
import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.Doc;
import org.xmlsmartdoc.SmartDoc.GeneratorParameter;
import org.xmlsmartdoc.SmartDoc.Indexdef;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocFormatConfig;
import org.xmlsmartdoc.SmartDoc.TOCNode;
import org.xmlsmartdoc.SmartDoc.Title;
import org.xmlsmartdoc.SmartDoc.TitledBlock;
import org.xmlsmartdoc.SmartDoc.UDoc;
import org.xmlsmartdoc.SmartDoc.USmartDoc;
import org.xmlsmartdoc.SmartDoc.html4.HTML4Generator;

import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.IGeneratorParameter;

/**
 * EclipseHelpGenerator
 *
 * @since   Apr. 26, 2004
 * @version May.  9, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class EclipseHelpGenerator extends AbstractSmartDocGenerator {
    protected SmartDocConfig config_;
    protected EclipseHelpConfig eclipsehelpConfig_;
    protected HTML4Generator html4Generator_;

    public void init(SmartDocConfig config, SmartDocFormatConfig fconfig) {
        super.init(config, fconfig);
        config_ = config;
        eclipsehelpConfig_ = (EclipseHelpConfig)fconfig;
        html4Generator_ = eclipsehelpConfig_.getHTML4Generator();
    }

    // AbstractYaGenerator
    public GeneratorResult generate(IGeneratorParameter iparam) {
        GeneratorParameter param = (GeneratorParameter)iparam;
        GeneratorResult result = html4Generator_.generate(param);
        Doc doc = param.doc;
        String project = param.project;
        String post = UDoc.getFilenamePostString(doc);
        _allocMapID(doc, project, param.deploy, post);
        result.addArtifact(
            project + post + ".xml",
            _generateHelpTOC(doc)
        );
        if (eclipsehelpConfig_.makeContext()) {
            result.addArtifact(
                project + "ContextHelp" + post + ".xml",
                _generateHelpContext(doc)
            );
        }
        return (result);
    }

    protected void _allocMapID(
        Doc doc, 
        String project, 
        String deploy, 
        String post
    ) {
        String alloc = USmartDoc.getAlloc(deploy);
        String fileID = doc.getFileID(alloc);
        String url = project + fileID + ".html";
        doc.setProperty("eclipsehelp.mapid", "main");
        doc.setProperty("eclipsehelp.target", url);
        TOCNode root = doc.getTOC().getTOCRoot();
        Indexdef indexdef = doc.getIndexdef();
        _allocMapID(root, project, deploy, post);
        _allocMapID(indexdef, project, deploy, post);
    }

    protected void _allocMapID(
        TOCNode node,
        String project,
        String alloc,
        String post
    ) {
        int size = node.getChildCount();
        for (int i = 0;i < size;i++) {
            TOCNode child = node.getTOCNode(i);
            TitledBlock heading = child.getHeading();
            String fileID = heading.getFileID(alloc);
            String id = _getID(heading);
            String url = project + fileID + post + ".html#" + id; // TODO post?
            String mapid = project + fileID + "." + id;
            heading.setProperty("eclipsehelp.mapid", mapid);
            heading.setProperty("eclipsehelp.target", url);
            _allocMapID(child, project, alloc, post);
        }
    }

    protected void _allocMapID(
        Indexdef indexdef,
        String project,
        String alloc,
        String post
    ) {
        String[] words = indexdef.getIndexWords();
        for (int i = 0;i < words.length;i++) {
            String word = words[i];
            Anchor def = indexdef.getDefAnchor(word);
            if (def != null) {
                String fileID = def.getFileID(alloc);
                String id = _getID(def);
                String url = project + fileID + post + ".html#" + id;
                String mapid = project + fileID + "." + id;
                def.setProperty("eclipsehelp.mapid", mapid);
                def.setProperty("eclipsehelp.target", url);
            }
        }
    }

    protected String _generateHelpTOC(Doc doc) {
        String titleName = doc.getHead().getDocTitle().getText(); 
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version='1.0' encoding='UTF-8'?>\n");
        buffer.append("<?NLS TYPE=\"org.eclipse.help.toc\"?>\n");
        buffer.append("<toc label=\"");
        buffer.append(titleName);
        buffer.append("\">\n");
        buffer.append("  <topic label=\"");
        buffer.append(titleName);
        buffer.append("\" href=\"");
        buffer.append(getTargetUri_(doc));
        buffer.append("\">\n");
        TOCNode root = doc.getTOC().getTOCRoot();
        _makeTOC(root, buffer);
        buffer.append("  </topic>\n");
        buffer.append("</toc>\n");
        return (new String(buffer));
    }

    protected void _makeTOC(TOCNode node, StringBuffer buffer) {
        int size = node.getChildCount();
        for (int i = 0;i < size;i++) {
            TOCNode child = node.getTOCNode(i);
            TitledBlock heading = child.getHeading();
            buffer.append("  <topic label=\"");
            buffer.append(child.getHeading().getTitle());
            buffer.append("\" href=\"");
            buffer.append(getTargetUri_(heading));
            buffer.append("\">\n");
            _makeTOC(child, buffer);
            buffer.append("  </topic>\n");
        }
    }

    protected String _generateHelpContext(Doc doc) {
        String titleName = doc.getHead().getDocTitle().getText(); 
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version='1.0' encoding='UTF-8'?>\n");
        buffer.append("<contexts>\n");
        TOCNode root = doc.getTOC().getTOCRoot();
        _makeContext(root, buffer);
        buffer.append("</contexts>\n");
        return (new String(buffer));
    }

    protected void _makeContext(TOCNode node, StringBuffer buffer) {
        int size = node.getChildCount();
        for (int i = 0;i < size;i++) {
            TOCNode child = node.getTOCNode(i);
            TitledBlock heading = child.getHeading();
            buffer.append("  <context id=\"");
            buffer.append(getMapId_(heading));
            buffer.append("\">\n");
            buffer.append("    <description>");
            buffer.append(child.getHeading().getTitle());
            buffer.append("</description>\n");
            buffer.append("    <topic label=\"");
            buffer.append(child.getHeading().getTitle());
            buffer.append("\" href=\"");
            buffer.append(getTargetUri_(heading));
            buffer.append("\"/>\n");
            buffer.append("  </context>\n");
            _makeContext(child, buffer);
        }
    }

    private String getMapId_(Content content) {
        return ((String)content.getProperty("eclipsehelp.mapid"));
    }

    private String getTargetUri_(Content content) {
        String uri = (String)content.getProperty("eclipsehelp.target");
        String folder = "html";
        return (folder + "/" + uri);
    }

    protected String _getID(Content content) {
        return (UDoc.getAbsoluteId(content));
    }
}
