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

import java.io.UnsupportedEncodingException;

import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.w3c.dom.Node;

import com.AsamiOffice.xml.XMLMaker;

/**
 * XmlContent
 *
 * @since   Aug.  7, 2004
 * @version Aug. 20, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class XmlContent extends AbstractRModelContent {
    private final Node node_;
	private boolean isVisual_ = false;

    public XmlContent(Node node, IRModelContext context) {
        super(context);
        node_ = node;
    }

    public boolean isValue() {
        return false;
    }

    public Object getValue() {
        return null;
    }

    public boolean isBinary() {
        return (true);
    }

/*
    public InputStream openInputStream() throws RModelException {
        return (new ByteArrayInputStream(getBinary()));
    }
*/
/*
    public InputStream getInputStream(String encoding) throws RModelException {
        return (new ByteArrayInputStream(getBinary(encoding)));
    }
*/

    protected byte[] _getBinary() throws RModelException {
        String encoding = getEncoding_();
        String text = getText_(encoding);
        try {
            return (text.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            throw (new RModelException(e));
        }
    }

/*
    public byte[] getBinary(String encoding) throws RModelException {
        encoding = getEncoding_(encoding);
        String text = getText_(encoding);
        try {
            return (text.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            throw (new RModelException(e));
        }
    }
*/

    public Boolean _isText() {
        return (Boolean.TRUE);
    }

/*
    public Reader openReader() {
        String text = getText_(getEncoding_());
        return (new StringReader(text));
    }
*/

    protected String _getText() {
        return (getText_(getEncoding_()));
    }

    private String getEncoding_() {
        return _dataSource.getTextEncoding();
    }

/*
    private String getEncoding_() {
        if (_encoding != null) {
            return (_encoding);
        } else {
            return ("UTF-8");
        }
    }

    private String getEncoding_(String encoding) {
        if (_encoding != null) {
            return (_encoding);
        } else {
            return (encoding);
        }
    }
*/  

    private String getText_(String encoding) {
        XMLMaker maker = new XMLMaker();
        maker.setVisual(isVisual_);
        maker.setEncoding(encoding);
        XMLMaker.traverse(node_, maker);
        return (maker.getText());
    }

    public Boolean _isXml() {
        return (Boolean.TRUE);
    }

    public Object getSource() {
        return (node_);
    }

	public void setVisual(boolean visual) {
		isVisual_ = visual;
	}
}
