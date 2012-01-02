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

package org.xmlsmartdoc.SmartDoc.adapter;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.xmlsmartdoc.SmartDoc.CharBlock;
import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.DocContext;
import org.xmlsmartdoc.SmartDoc.TBody;
import org.xmlsmartdoc.SmartDoc.TFoot;
import org.xmlsmartdoc.SmartDoc.THead;
import org.xmlsmartdoc.SmartDoc.Table;
import org.xmlsmartdoc.SmartDoc.Tr;
import org.xmlsmartdoc.SmartDoc.UDoc;
import org.xmlsmartdoc.SmartDoc.USmartDoc;
import com.AsamiOffice.text.UString;

import com.AsamiOffice.io.UURL;

/**
 * JDBCAdapter
 *
 * @since   Jun. 30, 2001
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class JDBCAdapter extends AbstractAdapter {
    protected Content[] _expand(
        String[] srcs,
        String param,
        Content parent,
        Content[] contents,
        DocContext context
    ) {
        String uri = srcs[0];
        String sql = UString.checkNull(
            parent.getAttribute("jdbcSql")
        );
        String username = parent.getAttribute("jdbcUsername");
        String password = parent.getAttribute("jdbcPassword");
        String driverName = UString.checkNull(
            parent.getAttribute("jdbcDriver")
        );
        String classpath = UString.checkNull(
            parent.getAttribute("jdbcClasspath")
        );
        ClassLoader loader = context.getConfig().getClassLoader();
        Driver driver = _loadDriver(driverName, classpath, loader);
        try {
            ResultSet rs = _query(uri, driver, username, password, sql);
            if (parent instanceof THead) {
                return (UDoc.resultSet2TrTh(rs));
            } else if (parent instanceof TFoot) {
                return (UDoc.resultSet2TrTh(rs));
            } else if (parent instanceof TBody) {
                return (UDoc.resultSet2TrTd(rs));
            } else if (parent instanceof Table) {
                return (UDoc.resultSet2THeadTBody(rs));
            } else if (parent instanceof Tr) {
                return (UDoc.resultSet2Tds(rs));
            } else {
                return (new Content[] { UDoc.resultSet2Table(rs) });
            }
        } catch (SQLException e) {
            USmartDoc.warningMessage(e.getMessage());
            return (new Content[] { new CharBlock(e.getMessage()) });
        }
    }

    private Driver _loadDriver(
        String driverName,
        String classpath,
        ClassLoader defaultLoader
    ) {
        if (driverName == null) {
            return (null);
        }
        Class clazz = null;
        try {
            if (classpath != null) {
                URL[] urls = _makeUrls(classpath);
                ClassLoader loader = new URLClassLoader(urls);
                clazz = Class.forName(driverName, true, loader);
            } else if (defaultLoader != null) {
                clazz = Class.forName(driverName, true, defaultLoader);
            } else {
                clazz = Class.forName(driverName);
            }
        } catch (MalformedURLException e) {
            USmartDoc.warningMessage(e.getMessage());
            return (null);
        } catch (ClassNotFoundException e) {
            USmartDoc.warningMessage(e.getMessage());
            return (null);
        }
        try {
            Driver driver = (Driver)clazz.newInstance();
            System.out.println("L+" + driver);
            return (driver);
        } catch (InstantiationException e) {
            USmartDoc.warningMessage(e.getMessage());
            return (null);
        } catch (IllegalAccessException e) {
            USmartDoc.warningMessage(e.getMessage());
            return (null);
        }
    }

    private ResultSet _query(
        String uri,
        Driver driver,
        String username,
        String password,
        String sql
    ) throws SQLException {
        Connection con = _getConnection(uri, driver, username, password);
        Statement sm = con.createStatement();
        ResultSet rs = sm.executeQuery(sql);
        return (rs);
    }

    private Connection _getConnection(
        String uri,
        Driver driver,
        String username,
        String password
    ) throws SQLException {
        Properties info = new Properties();
        if (username != null) {
            info.put("user", username);
            info.put("password", password);
        }
        if (driver == null) {
            return (DriverManager.getConnection(uri, info));
        } else {
            return (driver.connect(uri, info));
        }
    }

    private URL[] _makeUrls(String classpath) throws MalformedURLException {
        String[] tokens = UString.getTokens(classpath, ";");
        URL[] urls = new URL[tokens.length];
        for (int i = 0;i < tokens.length;i++) {
            String token = tokens[i];
            urls[i] = UURL.getURLFromFileOrURLName(token);
        }
        return (urls);
    }
}
