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
package org.xmlsmartdoc.SmartDoc.javahelp;

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
import org.xmlsmartdoc.SmartDoc.html3.HTML3Generator;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.IGeneratorParameter;

/**
 * JavaHelpGenerator
 *
 * @since   Apr. 26, 1999
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class JavaHelpGenerator extends AbstractSmartDocGenerator {
    protected SmartDocConfig config_;
    protected JavaHelpConfig javahelpConfig_;
    protected HTML3Generator html3Generator_;

    public void init(SmartDocConfig config, SmartDocFormatConfig fconfig) {
        super.init(config, fconfig);
        config_ = config;
        javahelpConfig_ = (JavaHelpConfig)fconfig;
        html3Generator_ = javahelpConfig_.getHTML3Generator();
    }

    // AbstractYaGenerator
    public GeneratorResult generate(IGeneratorParameter iparam) {
        GeneratorParameter param = (GeneratorParameter)iparam;
        GeneratorResult result = html3Generator_.generate(param);
        Doc doc = param.doc;
        String project = param.project;
        String post = UDoc.getFilenamePostString(doc);
        _allocMapID(doc, project, param.deploy);
        result.addArtifact(
            project + post + ".hs",
            _generateHelpSet(doc)
        );
        result.addArtifact(
            "Map" + post + ".jhm",
            _generateHelpMap(doc)
        );
        if (javahelpConfig_.makeToc()) {
            result.addArtifact(
                "TOC" + post + ".xml",
                _generateHelpTOC(doc)
            );
        }
        if (javahelpConfig_.makeIndex()) {
            result.addArtifact(
                "Index" + post + ".xml",
                _generateHelpIndex(doc)
            );
        }
        return (result);
    }

    protected void _allocMapID(Doc doc, String project, String deploy) {
        String alloc = USmartDoc.getAlloc(deploy);
        String fileID = doc.getFileID(alloc);
        String url = project + fileID + ".html";
        doc.setProperty("javahelp.mapid", "main");
        doc.setProperty("javahelp.target", url);
        TOCNode root = doc.getTOC().getTOCRoot();
        Indexdef indexdef = doc.getIndexdef();
        _allocMapID(root, project, deploy);
        _allocMapID(indexdef, project, deploy);
    }

    protected void _allocMapID(
        TOCNode node,
        String project,
        String alloc
    ) {
        int size = node.getChildCount();
        for (int i = 0;i < size;i++) {
            TOCNode child = node.getTOCNode(i);
            TitledBlock heading = child.getHeading();
            String fileID = heading.getFileID(alloc);
            String id = _getID(heading);
            String url = project + fileID + ".html#" + id;
            String mapid = project + fileID + "." + id;
            heading.setProperty("javahelp.mapid", mapid);
            heading.setProperty("javahelp.target", url);
            _allocMapID(child, project, alloc);
        }
    }

    protected void _allocMapID(
        Indexdef indexdef,
        String project,
        String alloc
    ) {
        String[] words = indexdef.getIndexWords();
        for (int i = 0;i < words.length;i++) {
            String word = words[i];
            Anchor def = indexdef.getDefAnchor(word);
            if (def != null) {
                String fileID = def.getFileID(alloc);
                String id = _getID(def);
                String url = project + fileID + ".html#" + id;
                String mapid = project + fileID + "." + id;
                def.setProperty("javahelp.mapid", mapid);
                def.setProperty("javahelp.target", url);
            }
        }
    }

    protected String _generateHelpSet(Doc doc) {
        Locale locale = doc.getDocContext().getLocale();
        Title docTitle = doc.getHead().getDocTitle();
        String title;
        if (docTitle != null) {
            title = docTitle.getText();
        } else {
            title = "";
        }
        String post = UDoc.getFilenamePostString(doc);
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version='1.0' encoding='UTF-8' ?>\n");
        buffer.append("<!DOCTYPE helpset\n");
        buffer.append("  PUBLIC \"-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 1.0//EN\"\n");
        buffer.append("         \"http://java.sun.com/products/javahelp/helpset_1_0.dtd\">\n");
        buffer.append("\n");
        buffer.append("<helpset version=\"1.0\"");
        if (locale != null) {
            buffer.append(" xml:lang=\"");
            buffer.append(locale.toString());
            buffer.append("\"");
        }
        buffer.append(">\n");
        buffer.append("  <title>");
        buffer.append(title);
        buffer.append("</title>\n");
        buffer.append("  <maps>\n");
        buffer.append("    <homeID>");
        buffer.append("main");
        buffer.append("</homeID>\n");
        buffer.append("    <mapref location=\"Map");
        buffer.append(post);
        buffer.append(".jhm\"/>\n");
        buffer.append("  </maps>\n");
        buffer.append("\n");
        if (javahelpConfig_.makeToc()) {
            buffer.append("  <view>\n");
            buffer.append("    <name>TOC</name>\n");
            buffer.append("    <label>Table of Contents</label>\n");
            buffer.append("    <type>javax.help.TOCView</type>\n");
            buffer.append("    <data>TOC");
            buffer.append(post);
            buffer.append(".xml</data>\n");
            buffer.append("  </view>\n");
            buffer.append("\n");
        }
        if (javahelpConfig_.makeIndex()) {
            buffer.append("  <view>\n");
            buffer.append("    <name>Index</name>\n");
            buffer.append("    <label>Index</label>\n");
            buffer.append("    <type>javax.help.IndexView</type>\n");
            buffer.append("    <data>Index");
            buffer.append(post);
            buffer.append(".xml</data>\n");
            buffer.append("  </view>\n");
            buffer.append("\n");
        }
        if (javahelpConfig_.makeSearch()) {
            buffer.append("  <view>\n");
            buffer.append("    <name>Search</name>\n");
            buffer.append("    <label>Search</label>\n");
            buffer.append("    <type>javax.help.SearchView</type>\n");
            buffer.append("    <data engine=\"com.sun.java.javahelp.search.DefaultSearchEngine\">");
            buffer.append("    JavaHelpSearch\n");
            buffer.append("    </data>\n");
            buffer.append("  </view>\n");
            buffer.append("\n");
        }
        buffer.append("</helpset>\n");
        return (new String(buffer));
    }

    protected String _generateHelpMap(Doc doc) {
        TOCNode root = doc.getTOC().getTOCRoot();
        Indexdef indexdef = doc.getIndexdef();
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version='1.0' encoding='UTF-8' ?>\n");
        buffer.append("<!DOCTYPE map\n");
        buffer.append("  PUBLIC \"-//Sun Microsystems Inc.//DTD JavaHelp Map Version 1.0//EN\"\n");
        buffer.append("         \"http://java.sun.com/products/javahelp/map_1_0.dtd\">\n");
        buffer.append("\n");
        buffer.append("<map version=\"1.0\">\n");

        buffer.append("  <mapID target=\"");
        buffer.append((String)doc.getProperty("javahelp.mapid"));
        buffer.append("\" url=\"");
        buffer.append((String)doc.getProperty("javahelp.target"));
        buffer.append("\"/>\n");
        _makeMap(root, buffer);
        _makeMap(indexdef, buffer);
        buffer.append("</map>\n");
        return (new String(buffer));
    }

    protected void _makeMap(TOCNode node, StringBuffer buffer) {
        int size = node.getChildCount();
        for (int i = 0;i < size;i++) {
            TOCNode child = node.getTOCNode(i);
            TitledBlock heading = child.getHeading();
            String mapid = (String)heading.getProperty("javahelp.mapid");
            String url = (String)heading.getProperty("javahelp.target");
            buffer.append("  <mapID target=\"");
            buffer.append(mapid);
            buffer.append("\" url=\"");
            buffer.append(url);
            buffer.append("\"/>\n");
            _makeMap(child, buffer);
        }
    }

    protected void _makeMap(Indexdef indexdef, StringBuffer buffer) {
        String[] words = indexdef.getIndexWords();
        for (int i = 0;i < words.length;i++) {
            String word = words[i];
            Anchor def = indexdef.getDefAnchor(word);
            if (def != null) {
                String mapid = (String)def.getProperty("javahelp.mapid");
                String url = (String)def.getProperty("javahelp.target");
                buffer.append("  <mapID target=\"");
                buffer.append(mapid);
                buffer.append("\" url=\"");
                buffer.append(url);
                buffer.append("\"/>\n");
            }
        }
    }

    protected String _generateHelpTOC(Doc doc) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version='1.0' encoding='UTF-8' ?>\n");
        buffer.append("<!DOCTYPE toc\n");
        buffer.append("  PUBLIC \"-//Sun Microsystems Inc.//DTD JavaHelp TOC Version 1.0//EN\"\n");
        buffer.append("         \"http://java.sun.com/products/javahelp/toc_1_0.dtd\">\n");
        buffer.append("\n");
        buffer.append("<toc version=\"1.0\">\n");
        buffer.append("  <tocitem text=\"");
        buffer.append(doc.getHead().getDocTitle().getText());
        buffer.append("\" target=\"");
        buffer.append((String)doc.getProperty("javahelp.mapid"));
        buffer.append("\">\n");
        TOCNode root = doc.getTOC().getTOCRoot();
        _makeTOC(root, buffer);
        buffer.append("  </tocitem>\n");
        buffer.append("</toc>\n");
        return (new String(buffer));
    }

    protected void _makeTOC(TOCNode node, StringBuffer buffer) {
        int size = node.getChildCount();
        for (int i = 0;i < size;i++) {
            TOCNode child = node.getTOCNode(i);
            TitledBlock heading = child.getHeading();
            buffer.append("  <tocitem text=\"");
            buffer.append(child.getHeading().getTitle());
            buffer.append("\" target=\"");
            buffer.append((String)heading.getProperty("javahelp.mapid"));
            buffer.append("\">\n");
            _makeTOC(child, buffer);
            buffer.append("  </tocitem>\n");
        }
    }

    protected String _generateHelpIndex(Doc doc) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version='1.0' encoding='UTF-8' ?>\n");
        buffer.append("<!DOCTYPE index\n");
        buffer.append("  PUBLIC \"-//Sun Microsystems Inc.//DTD JavaHelp Index Version 1.0//EN\"\n");
        buffer.append("         \"http://java.sun.com/products/javahelp/index_1_0.dtd\">\n");
        buffer.append("\n");
        buffer.append("<index version=\"1.0\">\n");
        _makeIndex(doc.getIndexdef(), buffer);
        buffer.append("</index>\n");
        return (new String(buffer));
    }

    protected void _makeIndex(Indexdef indexdef, StringBuffer buffer) {
        String[] words = indexdef.getIndexWords();
        for (int i = 0;i < words.length;i++) {
            String word = words[i];
            Anchor def = indexdef.getDefAnchor(word);
            if (def != null) {
                buffer.append("  <indexitem text=\"");
                buffer.append(def.getText());
                buffer.append("\" target=\"");
                buffer.append((String)def.getProperty("javahelp.mapid"));
                buffer.append("\">\n");
                buffer.append("  </indexitem>\n");
            }
        }
    }

    protected String _getID(Content content) {
        return (UDoc.getAbsoluteId(content));
    }
}
