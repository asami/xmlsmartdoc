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

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.xmlsmartdoc.SmartDoc.control.*;

/**
 * DocContext
 * 
 * @since   Feb. 20, 1999
 * @version Jun. 10, 2005
 * @author ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class DocContext {
    protected String id_;
    protected SmartDocConfig config_;
    protected String project_;
    protected Locale locale_;
    protected String format_;
    protected String key_;
    protected SmartDocFormatConfig formatConfig_;
    protected SmartDocGenerator generator_;
    protected BibliographyDatabase bibDB_;
    protected int noteNumber_ = 0;
    protected AtomFactory atoms_ = new AtomFactory();
    protected Stack macroContexts_ = new Stack();
    protected String baseDirectory_;

    protected DocContext() {
        id_ = __makeId();
    }

    public DocContext(SmartDocConfig config) {
        this();
        if (config == null) {
            throw (new InternalError());
        }
        config_ = config;
    }

    public void setup(Content content) {
        //	id_ = __makeId(content);
        throw (new InternalError());
    }

    public void setProject(String project) {
        project_ = project;
    }

    public void setLocale(Locale locale) {
        locale_ = locale;
    }

    public void setFormat(String format) {
        format_ = format;
        formatConfig_ = config_.getFormatConfig(format);
        generator_ = (SmartDocGenerator)formatConfig_.getGenerator();
    }

    public void setKey(String key) {
        key_ = key;
    }

    public void setBibliographyDatabase(BibliographyDatabase bibDB) {
        bibDB_ = bibDB;
    }

    public String getID() {
        return (id_);
    }

    public String getProject() {
        return (project_);
    }

    public String getDeploy() {
        return (config_.getDeploy()); // XXX
    }

    public Locale getLocale() {
        return (locale_);
    }

    public String getFormat() {
        return (format_);
    }

    public String getKey() {
        return (key_);
    }

    public String getFormatName() {
        return (formatConfig_.getName());
    }

    public SmartDocGenerator getGenerator() {
        return (generator_);
    }

    public SmartDocConfig getConfig() {
        return (config_);
    }

    public SmartDocFormatConfig getFormatConfig() {
        return (formatConfig_);
    }

    public BibliographyDatabase getBibliographyDatabase() {
        return (bibDB_);
    }

    public int getNextNoteNumber() {
        return (++noteNumber_);
    }

    public String[] getImageCandidates() {
        return (formatConfig_.getImageCandidates());
    }

    public Atom createAtom(String name) {
        return (atoms_.create(name));
    }

    public Atom getAtom(String name) {
        return (atoms_.get(name));
    }

    public void pushMacroContext(Content content) {
        macroContexts_.push(content);
    }

    public Content popMacroContext() {
        return ((Content)macroContexts_.pop());
    }

    public Content getMacroContext() {
        if (macroContexts_.empty()) {
            return (null);
        }
        return ((Content)macroContexts_.peek());
    }

    public String getBaseDirectory() {
        return (baseDirectory_);
    }

    public void setBaseDirctory(String xmlBase) {
        //	if (xmlBase.endsWith("/")) {
        //	    throw (new InternalError());
        //	}
        baseDirectory_ = xmlBase;
    }

    public String getRootXmlBase() {
        return (baseDirectory_);
    }

    public String resolveSiteLink(String href) {
        // TODO
        return null;
    }

    public String getSubContextAgainstRootXmlBase() {
        if (baseDirectory_ != null) {
            try {
                String root = new java.io.File(".").getCanonicalFile()
                        .toString();
                root = root + File.separator;
                File file;
                try {
                    URL baseUrl = new URL(baseDirectory_);
                    if (!"file".equals(baseUrl.getProtocol())) {
                        return (null);
                    }
                    file = new File(baseUrl.getFile());
                } catch (IOException e) {
                    file = new File(baseDirectory_);
                }
                String base = file.getCanonicalFile().toString();
                if (base.startsWith(root)) {
                    return (base.substring(root.length()));
                }
            } catch (java.io.IOException e) {
            }
        }
        return (null);
    }

    public DocContext makeSubContext(String subContext) {
        DocSubContext context = new DocSubContext(this, subContext);
        return (context);
    }

    private static String __makeId() {
        return ("doc" + (++idCount__));
    }

    private static String __makeId(Content content) { // XXX
        String id = content.getExplicitID();
        if (id != null) {
            return (id);
        } else {
            return ("doc" + (++idCount__));
        }
    }

    private static int idCount__ = 0;
}