/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.j2eecontainer.jndi;

import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.Properties;

import javax.sql.*;

import org.relaxer.j2eecontainer.J2eeContainer;
import org.relaxer.j2eecontainer.jndi.rConfig.*;

import com.AsamiOffice.io.UIO;

/**
 * RJFDataSource
 *
 * @since   May.  2, 2003
 *  version Sep.  7, 2004
 * @version Jan.  3, 2012
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RJFDataSource implements DataSource {
    private J2eeContainer container_; 
    private CDataSource ds_;
    private PrintWriter logger_ = null;
    private int timeout_;

    public RJFDataSource(CDataSource ds, J2eeContainer container) {
        ds_ = ds;
        container_ = container;
    }

    public Connection getConnection() throws SQLException {
        String url = ds_.getUrl();
        String username = ds_.getUserName();
        String password = ds_.getPassword();
        String driverName = ds_.getDriver();
        String classpath = ds_.getClasspath();
        try {
            Driver driver = null;
            if (driverName != null) {
                driver = getDriverJ2eeContainer_(driverName);
                if (driver != null) {
                    container_.config(
                        "JDBC driver '" + driver +
                        "' from container loader by name '" + driverName + "'."
                    );
                } else if (driver == null) {
                    ClassLoader loader;
                    String loaderInfo;
                    if (classpath != null) {
                        loader = UIO.makeClasspathClassLoader(classpath);
                        loaderInfo = "CLASSPATH [" + classpath + "]";
                    } else {
                        loader = ds_.getClass().getClassLoader();
                        loaderInfo = "system loader";
                    }
                    Class driverClass = loader.loadClass(driverName);
                    driver = (Driver)driverClass.newInstance();
                    container_.config(
                        "JDBC driver '" + driver +
                        "' from " + loaderInfo + " by name '" + driverName + "'."
                    );
                }
            } else {
                driver = DriverManager.getDriver(url);
            }
            Properties info = new Properties();
            if (username != null) {
                info.put("user", username);
            }
            if (password != null) {
                info.put("password", password);
            }
            return (driver.connect(url, info));
        } catch (MalformedURLException e) {
            throw (getConnection_error_(url, e));
        } catch (ClassNotFoundException e) {
            throw (getConnection_error_(url, e));
        } catch (InstantiationException e) {
            throw (getConnection_error_(url, e));
        } catch (IllegalAccessException e) {
            throw (getConnection_error_(url, e));
        } finally {
            container_.info(
                "Open '" + url + "' as DataSource '" + ds_.getName() + "'."
            );
        }
    }
    
    private SQLException getConnection_error_(String url, Throwable e) {
        container_.warning(
            "Can not open '" + url + "' for DataSource '" + ds_.getName() + "'.",
            e
        );
        return (new SQLException(e.getMessage()));
    }

    private Driver getDriverJ2eeContainer_(String driverName) {
        ClassLoader loader = container_.getConfigClassLoader();
        if (loader != null) {
        	Driver driver = loadDriver_(driverName, loader);
        	if (driver != null) {
        		return (driver);
        	}
        }
       	loader = container_.getDefaultClassLoader();
        if (loader != null) {
        	Driver driver = loadDriver_(driverName, loader);
        	if (driver != null) {
        		return (driver);
        	}
        }
        return (null);
    }

	private Driver loadDriver_(String driverName, ClassLoader loader) {
        try {
            return ((Driver)loader.loadClass(driverName).newInstance());
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
        return (null);
	}

	public Connection getConnection(String username, String password)
        throws SQLException {

        throw (new UnsupportedOperationException());
    }

    public java.io.PrintWriter getLogWriter() throws SQLException {
        return (logger_);
    }

    public void setLogWriter(java.io.PrintWriter out) throws SQLException {
        logger_ = out;
    }

    public void setLoginTimeout(int seconds) throws SQLException {
        timeout_ = seconds;
    }

    public int getLoginTimeout() throws SQLException {
        return (timeout_);
    }

    public boolean isWrapperFor(Class<?> iface) {
        throw (new UnsupportedOperationException());
    }

    public <T> T unwrap(Class<T> iface) {
        throw (new UnsupportedOperationException());
    }
}
