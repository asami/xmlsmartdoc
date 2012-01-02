/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.framework.auth.repository;

import java.io.InputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.relaxer.framework.auth.rAccount.*;

/**
 * StreamRepository
 *
 * @since   Sep.  5, 2002
 * @version Aug. 30, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class StreamRepository extends AbstractRepository {
    private RAccounts accounts_;

    public StreamRepository(InputStream in)
	throws IOException, SAXException, ParserConfigurationException {

	accounts_ = new RAccounts(in);
    }

    public RAccount getAccount(String name) {
	return (accounts_.getAccountByName(name));
    }

    public void setAccount(RAccount account)
	throws UnsupportedOperationException {

	throw (new UnsupportedOperationException());
    }

    public void flush() throws IOException {
	// do nothing
    }

    public void close() throws IOException {
	// do nothing
    }
}
