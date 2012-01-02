/*
 * SmartTable
 *  Copyright (C) 1999-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartTable;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.AsamiOffice.jaba2.j2fw.translator.AbstractImporter;
import com.AsamiOffice.jaba2.j2fw.translator.TranslatorModel;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.util.PropertyList;
import com.AsamiOffice.util.D2Array;

import com.AsamiOffice.io.UURL;

/**
 * JDBCImporter
 *
 * @since   Aug. 10, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class JDBCImporter extends AbstractImporter {
    protected String driverName_;
    protected String classpath_;
    protected String userName_;
    protected String password_;
    protected String tableName_;

    public void setup(TranslatorModel model) {
        super.setup(model);
        SmartTableModel smodel = (SmartTableModel)model;
        Metadata metadata = smodel.getMetadataIn();
        driverName_ = UString.checkNull(metadata.getProperty("driver"));
        classpath_ = UString.checkNull(metadata.getProperty("classpath"));
        userName_ = metadata.getProperty("username");
        if (userName_ == null) {
            userName_ = "";
        }
        password_ = metadata.getProperty("password");
        if (password_ == null) {
            password_ = "";
        }
        tableName_ = metadata.getProperty("tablename");
    }

    public String getID() {
        return ("jdbc");
    }

    public String getName() {
        return ("JDBC Importer");
    }

    public boolean canImport(URL url) {
        return ("jdbc".equals(url.getProtocol()));
    }

    public void importSource(URL url) throws IOException {
        String target = url.toExternalForm();
        String jdbcURL;
        String tableName;
        String userName = userName_;
        String password = password_;
        int index = target.indexOf("#");
        if (index == -1) {
            jdbcURL = target;
            tableName = tableName_;
        } else {
            jdbcURL = target.substring(0, index);
            PropertyList properties = new PropertyList(
                target.substring(index + 1)
            );
            tableName = (String)properties.getPrimary();
            tableName = properties.getString("table", tableName);
            userName = properties.getString("id", userName);
            password = properties.getString("pwd", password);
        }
        SmartTableModel model = (SmartTableModel)model_;
        Metadata metadata = model.getMetadataIn();
        try {
            if (driverName_ != null) {
                if (classpath_ != null) {
                    ClassLoader loader = new URLClassLoader(
                        new URL[] {
                            UURL.getURLFromFileOrURLName(classpath_)
                        }
                    );
                    Class.forName(driverName_, true, loader);
                } else {
                    Class.forName(driverName_);
                }
            }
            Connection con = DriverManager.getConnection(
                jdbcURL,
                userName,
                password
            );
            String[] names = metadata.getColumnNames();
            StringBuffer buffer = new StringBuffer();
            buffer.append("SELECT ");
            if (names.length > 0) {
                buffer.append(names[0]);
                for (int i = 1;i < names.length;i++) {
                    buffer.append(", ");
                    buffer.append(names[i]);
                }
            }
            buffer.append(" FROM ");
            buffer.append(tableName);
            String query = new String(buffer);
            Statement sm = con.createStatement();
            ResultSet rs = sm.executeQuery(query);
            D2Array array = new D2Array();
            int y = 0;
            while (rs.next()) {
                for (int x = 0;x < names.length;x++) {
                    array.put(x, y, rs.getString(names[x]));
                }
                y++;
            }
            model.setData(array);
            rs.close();
            sm.close();
            con.close();
        } catch (ClassNotFoundException e) {
            throw (new InternalError());
        } catch (SQLException e) {
            throw (new InternalError());
        }
    }
}
