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

import java.util.*;
import org.w3c.dom.*;
import com.AsamiOffice.jaba2.util.PropertyList;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.ULocale;

/**
 * Content
 *
 * @since   Sep. 19, 1998
 * @version Mar. 17, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class Content implements Cloneable {
    public final static int ENTITY_BLOCK = 1;
    public final static int ENTITY_INLINE = 2;
    public final static int ENTITY_CONTAINER = 3;
    public final static int ENTITY_CONTROL = 4;

    protected Element element_;
    protected DocContext context_;
    protected Container parent_;
    protected String lang_;
    protected String space_;
    protected String id_;
    protected String implicitID_;
    protected String clazz_;
    protected CSSStyle style_; // css
    protected String title_;
    private Title titleNode_;
    protected Map titlesPerLocale_ = new HashMap(); // Map<Locale, Title>
    protected String format_;
    protected Locale locale_ = null;
    protected String version_;
    protected String timestamp_;
    protected String key_;
    protected String src_;
    protected String[] srcList_;
    protected String idref_;
    protected Content link_;
    protected String text_ = null;
    protected String encoding_;
    protected Date date_;
    protected String note_;
    protected SequenceNumber sequenceNumber_;
    protected List referer_ = new ArrayList();
    protected Map attributes_ = new HashMap();
    protected Map properties_ = new HashMap();
    protected Map fileIDs_ = new HashMap(); // XXX : deprecated
    protected Map deployContexts_ = new HashMap();

    protected Content() {
        implicitID_ = __allocID();
    }

    protected Content(Element element) {
        element_ = element;
        lang_ = UString.checkNull(element.getAttribute("xml:lang"));
        space_ = UString.checkNull(element.getAttribute("xml:space"));
        id_ = UString.checkNull(element.getAttribute("id"));
        clazz_ = UString.checkNull(element.getAttribute("class"));
        String style = UString.checkNull(element.getAttribute("style"));
        if (style != null) {
            style_ = new CSSStyle(style);
        }
        title_ = UString.checkNull(element.getAttribute("title"));
        format_ = UString.checkNull(element.getAttribute("format"));
        String locale = UString.checkNull(element.getAttribute("locale"));
        if (locale != null) {
            locale_ = ULocale.makeLocale(locale);
        }
        version_ = UString.checkNull(element.getAttribute("version"));
        timestamp_ = UString.checkNull(element.getAttribute("timestamp"));
        key_ = UString.checkNull(element.getAttribute("key"));
        src_ = UString.checkNull(element.getAttribute("src"));
        if (src_ != null) {
            List list = new ArrayList();
            StringTokenizer st = new StringTokenizer(src_, " ,;"); // XXX
            while (st.hasMoreTokens()) {
                list.add(st.nextToken().trim());
            }
            srcList_ = new String[list.size()];
            list.toArray(srcList_);
        }
        idref_ = UString.checkNull(element.getAttribute("idref"));
        encoding_ = UString.checkNull(element.getAttribute("encoding"));
        String dateString = UString.checkNull(element.getAttribute("date"));
        if (dateString != null) {
            date_ = new Date(dateString); // XXX
        }
        note_ = UString.checkNull(element.getAttribute("note"));
        implicitID_ = __allocID();
        String sequenceName =
            UString.checkNull(element.getAttribute("sequenceName"));
        if (sequenceName != null) {
            sequenceNumber_ = new SequenceNumber(sequenceName);
        }
    }

    // Cloneable
    public Object clone() { // shallow clone
        try {
            return (super.clone());
        } catch (CloneNotSupportedException e) {
            throw (new InternalError("clone"));
        }
    }

    public Content deepClone() {
        return ((Content)clone());
    }

    public void setDocContext(DocContext context) {
        context_ = context;
        //	context.setup(this);
    }

    public void setParent(Container parent) {
        parent_ = parent;
    }

    public void setAttribute(String name, String value) {
        attributes_.put(name, value);
        if ("xml:lang".equals(name)) {
            lang_ = value;
        } else if ("xml:space".equals(name)) {
            space_ = value;
        } else if ("id".equals(name)) {
            id_ = value;
        } else if ("class".equals(name)) {
            clazz_ = value;
        } else if ("style".equals(name)) {
            style_ = new CSSStyle(value);
        } else if ("title".equals(name)) {
            title_ = value;
        } else if ("format".equals(name)) {
            format_ = value;
        } else if ("locale".equals(name)) {
            locale_ = ULocale.makeLocale(value);
        } else if ("src".equals(name)) {
            src_ = value;
            // XXX : more
        } else if ("encoding".equals(name)) {
            encoding_ = value;
        } else if ("date".equals(name)) {
            throw (new UnsupportedOperationException());
        } else if ("note".equals(name)) {
            note_ = value;
        } else if ("sequenceName".equals(name)) {
            sequenceNumber_ = new SequenceNumber(value);
        }
    }

    public abstract int getEntityType();

    public void setID(String id) {
        id_ = id;
    }

    public void setClazz(String clazz) {
        clazz_ = clazz;
    }

    public void setStyle(String style) {
        style_ = new CSSStyle(style);
    }

    public void setTitle(String title) {
        title_ = title;
    }

    public void setFormat(String format) {
        format_ = format;
    }

    public void setLanguage(String lang) {
        lang_ = lang;
    }

    public void setSpace(String space) {
        space_ = space;
    }

    public void setLocale(Locale locale) {
        locale_ = locale;
    }

    public void setSrc(String src) {
        src_ = src;
    }

    public void setIdref(String idref) {
        idref_ = idref;
    }

    public void setLink(Content link) {
        link_ = link;
        idref_ = link.getID();
    }

    public void setText(String text) {
        text_ = text;
    }

    public void setProperty(Object key, Object value) {
        properties_.put(key, value);
    }

    public void setFileID(String deploy, String fileID) {
        fileIDs_.put(deploy, fileID);
    }

    public void setDeployContext(String deploy, String fileID) {
        deployContexts_.put(deploy, fileID);
    }

    public void addReferer(Content ref) {
        referer_.add(ref);
    }

    public String getAttribute(String name) {
        String value = (String)attributes_.get(name);
        if (value != null) {
            return (value);
        }
        if (element_ == null) {
            return (null);
        }
        Attr attr = element_.getAttributeNode(name);
        if (attr == null) {
            return (null);
        } else {
            return (attr.getValue());
        }
    }

    public Container getParent() {
        return (parent_);
    }

    public String getID() {
        if (id_ == null) {
            return (implicitID_);
        }
        return (id_);
    }

    public String getExplicitID() {
        return (id_);
    }

    public String getImplicitID() {
        return (implicitID_);
    }

    public String getClazz() {
        return (clazz_);
    }

    public CSSStyle getStyle() {
        return (style_);
    }

    public String getTitle() {
        Locale locale = getLocale();
        if (locale == null) {
            if (titleNode_ != null) {
                return (titleNode_.getText());
            }
            return (title_);
        }
        return (getTitle(locale));
    }

    public String getTitle(Locale locale) {
        Title title = (Title)titlesPerLocale_.get(locale); // XXX
        if (title != null) {
            return (title.getText());
        } else if (titleNode_ != null) {
            return (titleNode_.getText());
        } else {
            return (title_);
        }
    }

    public Title getTitleNode() {
        Locale locale = getLocale();
        if (locale == null) {
            if (titleNode_ == null) {
                if (title_ == null) {
                    return (null); // XXX
                    //		    return (new Title("unknown"));
                } else {
                    Title title = new Title(title_);
                    title.setDocContext(getDocContext());
                    return (title);
                }
            } else {
                return (titleNode_);
            }
        } else {
            return (getTitleNode(locale));
        }
    }

    public Title getTitleNode(Locale locale) {
        Title title = (Title)titlesPerLocale_.get(locale); // XXX
        if (title != null) {
            return (title);
        }
        if (titleNode_ != null) {
            return (titleNode_);
        }
        if (title_ != null) {
            title = new Title(title_);
            title.setDocContext(getDocContext());
            return (title);
        }
        return (null); // XXX
        //	return (new Title("unkonwn(" + locale + ")"));
    }

    public Title[] getAllTitleNodes() {
        List list = new ArrayList();
        if (titleNode_ != null) {
            list.add(titleNode_);
        }
        Set keys = titlesPerLocale_.keySet();
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            Object locale = iter.next();
            list.add(titlesPerLocale_.get(locale));
        }
        Title[] result = new Title[list.size()];
        return ((Title[])list.toArray(result));
    }

    public void setTitle(Title title) {
        titleNode_ = title;
        title.setDocContext(getDocContext());
    }

    public void setTitle(Title title, Locale locale) {
        titlesPerLocale_.put(locale, title);
        title.setDocContext(getDocContext());
    }

    public String getFormat() {
        return (format_);
    }

    public String getVersion() {
        return (version_);
    }

    public String getTimestamp() {
        return (timestamp_);
    }

    public String getKey() {
        return (key_);
    }

    public Doc getDoc() {
        return (parent_.getDoc());
    }

    public DocContext getDocContext() {
        if (context_ != null) {
            return (context_);
        } else {
            return (parent_.getDocContext());
        }
    }

    public String getExplicitLanguage() {
        return (lang_);
    }

    public String getLanguage() {
        if (lang_ != null) {
            return (lang_);
        }
        if (parent_ != null) {
            return (parent_.getLanguage());
        }
        return (null);
    }

    public String getExplicitSpace() {
        return (space_);
    }

    public String getSpace() {
        if (space_ != null) {
            return (space_);
        }
        if (parent_ != null) {
            return (parent_.getSpace());
        }
        return (null);
    }

    public Locale getExplicitLocale() {
        return (locale_);
    }

    public Locale getLocale() {
        if (locale_ != null) {
            return (locale_);
        }
        if (parent_ != null) {
            return (parent_.getLocale());
        }
        return (null);
    }

    public Locale getLanguageLocale() {
        if (lang_ != null) {
            return (ULocale.makeLocale(lang_));
        }
        if (parent_ != null) {
            Locale locale = parent_.getLanguageLocale();
            if (locale != null) {
                return (locale);
            }
        }
        return (null);
    }

    public Locale getProcessLocale() {
        Locale locale = getLanguageLocale();
        if (locale != null) {
            return (locale);
        }
        locale = getLocale();
        if (locale != null) {
            return (locale);
        }
        locale = getDocContext().getLocale();
        if (locale != null) {
            return (locale);
        }
        return (Locale.ENGLISH);
    }

    public String getSrc() {
        return (src_);
    }

    public String[] getSrcList() {
        return (srcList_);
    }

    public String getIdref() {
        return (idref_);
    }

    public Content getLink() {
        return (link_);
    }

    public String getEncoding() {
        return (encoding_);
    }

    public String getText() {
        return (text_);
    }

    public String getNote() {
        return (note_);
    }

    public void setupSequenceNumber(String name) {
        sequenceNumber_ = new SequenceNumber(name);
    }

    public SequenceNumber getSequenceNumber() {
        return (sequenceNumber_);
    }

    public boolean enter(ISmartDocVisitor visitor) {
        return (visitor.enter(this));
    }

    public void leave(ISmartDocVisitor visitor) {
        visitor.leave(this);
    }

    public PropertyList getAttributes() {
        throw (new UnsupportedOperationException());
    }

    public PropertyList getPureAttributes() {
        throw (new UnsupportedOperationException());
    }

    // XXX : for I18N, should return more generic information
    public char getFirstChar() {
        return (0);
    }

    public char getLastChar() {
        return (0);
    }

    public Object getProperty(Object key) {
        return (properties_.get(key));
    }

    public String getFileID(String deploy) {
        String id = (String)fileIDs_.get(deploy);
        if (id == null) {
            return ("");
        } else {
            return (id);
        }
    }

    public String getDeployContext(String deploy) {
        String id = (String)deployContexts_.get(deploy);
        if (id == null) {
            return ("");
        } else {
            return (id);
        }
    }

    public boolean hasReferer() {
        return (referer_.size() > 0);
    }

    public Content[] expand(DocContext context) {
        return (new Content[] { this });
    }

    public Content[] metaEval(DocContext context) {
        return (new Content[] { this });
    }

    public Content[] macroExpand(DocContext context) {
        return (new Content[] { this });
    }

    public Content[] normalize(DocContext context) {
        return (new Content[] { this });
    }

    public Content[] eval(DocContext context) {
        if (!UDoc.isActiveContent(this, context)) {
            return (null);
        }
        return (new Content[] { this });
    }

    public void format() {
    }

    // helper methods
    protected void _info(String message) {
        USmartDoc.info(message);
    }

    protected void _warning(String message) throws SmartDocWarningException {
        USmartDoc.warning(message);
    }

    protected void _error(String message) throws SmartDocErrorException {
        USmartDoc.error(message);
    }

    protected static int idCount__ = 0;

    protected static String __allocID() {
        return ("id" + String.valueOf(++idCount__));
    }
}
