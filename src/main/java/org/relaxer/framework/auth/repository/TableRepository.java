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

import java.io.IOException;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.relaxer.framework.auth.rAccount.*;

/**
 * TableRepository
 *
 * @since   Sep.  5, 2002
 * @version Aug. 30, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class TableRepository extends AbstractRepository {
    private AccountTable accounts_;

    public TableRepository(
        String uri,
        String tableName,
        String userName,
        String password)
        throws IOException, SAXException, ParserConfigurationException {
        try {
            if (userName != null) {
                accounts_ =
                    new AccountTable(uri, tableName, userName, password);
            } else {
                accounts_ = new AccountTable(uri, tableName);
            }
        } catch (SQLException e) {
            throw (new IOException(e.getMessage()));
        }
    }

    public RAccount getAccount(String name) throws IOException {
        try {
            return (accounts_.getByName(name));
        } catch (SQLException e) {
            throw (new IOException(e.getMessage()));
        }
    }

    public void setAccount(RAccount account) throws IOException {
        try {
            accounts_.update(account);
        } catch (SQLException e) {
            throw (new IOException(e.getMessage()));
        }
    }

    public void flush() throws IOException {
        // do nothing
    }

    public void close() throws IOException {
        // do nothing
    }
}
