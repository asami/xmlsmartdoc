/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2002  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.framework.auth;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.net.URL;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.relaxer.framework.auth.RAuthPrincipal;
import org.relaxer.framework.auth.repository.IRepository;
import org.relaxer.framework.auth.repository.FileRepository;
import org.relaxer.framework.auth.repository.StreamRepository;
import org.relaxer.framework.auth.repository.TableRepository;
import org.relaxer.framework.auth.rAccount.RAccount;
import com.AsamiOffice.io.UURL;

/**
 * RAuthFactory
 *
 * @since   Sep.  1, 2002
 * @version Aug. 31, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RAuthFactory {
    private IRepository repository_;

    public RAuthFactory(String uri)
	throws IOException, SAXException, ParserConfigurationException {

	URL url = UURL.getURLFromUri(uri);
	String protocol = url.getProtocol();
	if ("jdbc".equals(protocol)) {
	    throw (new UnsupportedOperationException());
	} else if ("file".equals(protocol)) {
	    _init(new File(url.getFile()));
	} else {
	    _init(url.openStream());
	}
    }

    public RAuthFactory(
	String uri,
	String tableName,
	String userName,
	String password
    ) throws IOException, SAXException, ParserConfigurationException {
	_init(uri, tableName, userName, password);
    }

    public RAuthFactory(File file)
	throws IOException, SAXException, ParserConfigurationException {

	_init(file);
    }

    private void _init(File file)
	throws IOException, SAXException, ParserConfigurationException {

	repository_ = new FileRepository(file);
    }

    private void _init(InputStream in)
	throws IOException, SAXException, ParserConfigurationException {

	repository_ = new StreamRepository(in);
    }

    private void _init(
	String uri,
	String tableName,
	String userName,
	String password
    ) throws IOException, SAXException, ParserConfigurationException {
	repository_ = new TableRepository(
	    uri,
	    tableName,
	    userName,
	    password
	);
    }

    public RAuthPrincipal getPrincipal(String name) throws IOException {
	RAccount account = repository_.getAccount(name);
	if (account == null) {
	    return (null);
	}
	return (new RAuthPrincipal(account));
    }
}
