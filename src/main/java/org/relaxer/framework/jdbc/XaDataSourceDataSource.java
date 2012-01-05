/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.sql.XAConnection;
import javax.sql.XADataSource;

/**
 * XaDataSourceDataSource
 *
 * @since   2004/03/10
 *  version 2004/03/10
 * @version Jan.  3, 2012
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class XaDataSourceDataSource implements DataSource {
    private XADataSource xaDatasource_;

    public XaDataSourceDataSource(XADataSource source) {
        xaDatasource_ = source;
    }

    public Connection getConnection() throws SQLException {
        XAConnection connection = xaDatasource_.getXAConnection();
        return (connection.getConnection());
    }

    public Connection getConnection(String username, String password)
      throws SQLException {
        XAConnection connection = xaDatasource_.getXAConnection(
            username,
            password
        );
        return (connection.getConnection());
    }

    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void setLogWriter(PrintWriter out) throws SQLException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void setLoginTimeout(int seconds) throws SQLException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public boolean isWrapperFor(Class<?> iface) {
        throw (new UnsupportedOperationException());
    }

    public <T> T unwrap(Class<T> iface) {
        throw (new UnsupportedOperationException());
    }
}
