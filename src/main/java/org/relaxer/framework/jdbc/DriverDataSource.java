/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

/**
 * DriverDataSource
 *
 * @since   2004/03/10
 * @version 2004/03/10
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class DriverDataSource implements DataSource {
    private String url_;
    private Driver driver_;

    public DriverDataSource(String url, Driver driver) {
        url_ = url;
        driver_ = driver;
    }

    public Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        return (driver_.connect(url_, properties));
    }

    public Connection getConnection(String username, String password)
      throws SQLException {
        Properties properties = new Properties();
        properties.put("user", username);
        properties.put("password", password);
        return (driver_.connect(url_, properties));
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

}
