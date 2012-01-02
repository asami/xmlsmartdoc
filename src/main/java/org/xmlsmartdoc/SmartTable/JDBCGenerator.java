/*
 * SmartTable
 *  Copyright (C) 1999-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
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

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.IGeneratorParameter;
import com.AsamiOffice.util.D2Array;

/**
 * JDBCGenerator
 *
 * @since   Jul. 29, 1999
 * @version Jan.  7, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class JDBCGenerator extends AbstractSmartTableGenerator {
    protected URL url_;
    protected String driverName_;
    protected String userName_;
    protected String password_;
    protected String tableName_;

    public String getID() {
        return ("jdbc");
    }

    public String getName() {
        return ("JDBC Generator");
    }

    public GeneratorResult generate(IGeneratorParameter param) {
        Metadata metadata = model_.getMetadataOut();
        D2Array d2 = model_.getData();
        try {
            Connection con =
                DriverManager.getConnection(
                    url_.toExternalForm(),
                    userName_,
                    password_);
            Statement sm = con.createStatement();
            String[] names = metadata.getColumnNames();
            int primaryIndex = 0; // XXX
            int width = d2.getWidth();
            int height = d2.getHeight();
            for (int y = 0; y < height; y++) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("UPDATE ");
                buffer.append(tableName_);
                buffer.append(" SET");
                for (int x = 0; x < width; x++) {
                    if (x == primaryIndex) {
                        continue;
                    }
                    buffer.append(names[0]);
                    buffer.append(" = '");
                    buffer.append(d2.get(x, y).toString());
                    buffer.append("'");
                }
                buffer.append(" WHERE ");
                buffer.append(names[primaryIndex]);
                buffer.append(" = '");
                buffer.append(d2.get(primaryIndex, y).toString());
                buffer.append("'");
            }
            sm.close();
            con.close();
        } catch (SQLException e) {
            throw (new InternalError());
        }

        // XXX : temporary, should integrate the Packager mechanism
        return (null);
    }
}
