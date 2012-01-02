/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
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
package org.relaxer.framework.runtime.model.content;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * UrlContent
 *
 * @since   Dec. 17, 2003
 * @version Aug. 20, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class UrlContent extends AbstractRModelContent {
    private final URL url_;

    public UrlContent(URL url, IRModelContext context) {
        super(context);
        url_ = url;
    }

/*
    public UrlContent(URL url, String encoding, IRModelContext context) {
        super(encoding, context);
        url_ = url;
    }
*/

    public boolean isValue() {
        return false;
    }

    public Object getValue() {
        return null;
    }

    public boolean isBinary() {
        return (true);
    }

    protected InputStream _openInputStream() throws RModelException {
        try {
            return (url_.openStream());
        } catch (IOException e) {
            throw (new RModelException(e));
        }
    }

/*
    public boolean isText() {
        return (false);
    }

    public boolean isXml() {
        return (false);
    }
*/

    public Object getSource() {
        return (url_);
    }

    public URL getUrl() {
        return url_;
    }
}
