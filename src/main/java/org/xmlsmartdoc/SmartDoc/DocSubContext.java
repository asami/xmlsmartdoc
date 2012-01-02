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
import org.xmlsmartdoc.SmartDoc.control.*;

/**
 * DocSubContext
 * 
 * @since   Sep. 16, 2001
 * @version Apr.  8, 2005
 * @author ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class DocSubContext extends DocContext {
    private DocContext parent_;

    private String subContext_;

    public DocSubContext(DocContext parent, String subContext) {
        parent_ = parent;
        subContext_ = subContext;
    }

    public void setProject(String project) {
        parent_.setProject(project);
    }

    public void setLocale(Locale locale) {
        parent_.setLocale(locale);
    }

    public void setFormat(String format) {
        parent_.setFormat(format);
    }

    public void setBibliographyDatabase(BibliographyDatabase bibDB) {
        parent_.setBibliographyDatabase(bibDB);
    }

    public String getProject() {
        return (parent_.getProject());
    }

    public String getDeploy() {
        return (parent_.getDeploy());
    }

    public Locale getLocale() {
        return (parent_.getLocale());
    }

    public String getFormat() {
        return (parent_.getFormat());
    }

    public String getFormatName() {
        return (parent_.getFormatName());
    }

    public SmartDocGenerator getGenerator() {
        return (parent_.getGenerator());
    }

    public SmartDocConfig getConfig() {
        return (parent_.getConfig());
    }

    public SmartDocFormatConfig getFormatConfig() {
        return (parent_.getFormatConfig());
    }

    public BibliographyDatabase getBibliographyDatabase() {
        return (parent_.getBibliographyDatabase());
    }

    public int getNextNoteNumber() {
        return (parent_.getNextNoteNumber());
    }

    public String[] getImageCandidates() {
        return (parent_.getImageCandidates());
    }

    public Atom createAtom(String name) {
        return (parent_.createAtom(name));
    }

    public Atom getAtom(String name) {
        return (parent_.getAtom(name));
    }

    public void pushMacroContext(Content content) {
        parent_.pushMacroContext(content);
    }

    public Content popMacroContext() {
        return (parent_.popMacroContext());
    }

    public Content getMacroContext() {
        return (parent_.getMacroContext());
    }

    public String getBaseDirectory() {
        String base = parent_.getBaseDirectory();
        if (base == null) {
            return (subContext_);
        }
        if (subContext_ != null) {
            return (base + "/" + subContext_);
        } else {
            return (base);
        }
    }

    public void setBaseDirctory(String xmlBase) {
        throw (new InternalError());
    }

    public String getRootXmlBase() {
        return (parent_.getRootXmlBase());
    }

    public String getSubContext() {
        return (subContext_);
    }

    public String getSubContextAgainstRootXmlBase() {
        String root = getRootXmlBase();
        String uri = getBaseDirectory();
        if (root == null) {
            return (uri);
        } else {
            if (uri == null) {
                return (null);
            }
            if (uri.indexOf(root) == -1) {
                throw (new InternalError());
            }
            uri = uri.substring(root.length());
            if (uri.startsWith("/")) {
                return (uri.substring(1));
            } else {
                return (uri);
            }
        }
    }

    public DocContext makeSubContext(String xmlBase, String subContext) {
        DocSubContext context = new DocSubContext(this, subContext);
        return (context);
    }
}