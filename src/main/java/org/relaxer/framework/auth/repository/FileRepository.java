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

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.relaxer.framework.auth.rAccount.*;
import com.AsamiOffice.xml.UDOM;

/**
 * FileRepository
 *
 * @since   Aug. 29, 2002
 * @version Aug. 30, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class FileRepository extends AbstractRepository {
    private File file_;
    private RAccounts accounts_;

    public FileRepository(String filename)
        throws IOException, SAXException, ParserConfigurationException {

        _init(new File(filename));
    }

    public FileRepository(File file)
        throws IOException, SAXException, ParserConfigurationException {

        _init(file);
    }

    private void _init(File file)
        throws IOException, SAXException, ParserConfigurationException {

        file_ = file;
        accounts_ = new RAccounts(file_);
    }

    public RAccount getAccount(String name) {
        return (accounts_.getAccountByName(name));
    }

    public void setAccount(RAccount account) {
        accounts_.addAccount(account);
    }

    public void flush() throws IOException {
        try {
            UDOM.saveDocument(file_, accounts_.makeDocument());
        } catch (ParserConfigurationException e) {
            throw (new IOException(e.getMessage()));
        }
    }

    public void close() throws IOException {
        flush();
        file_ = null;
        accounts_ = null;
    }
}
