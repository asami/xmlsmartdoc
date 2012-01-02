package org.relaxer.framework.auth.rAccount;

import java.util.*;
import java.io.*;
import java.sql.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;

/**
 * RJDBCList
 *
 * @since   Feb.  5, 2001
 * @version Oct.  8, 2002
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RJDBCList extends AbstractList {
    private ResultSet result_;
    private Statement st_;
    private int index_;

    public RJDBCList(ResultSet result, Statement st) {
	result_ = result;
	st_ = st;
	index_ = -1;
    }

    public final ResultSet getResultSet() {
	return (result_);
    }

    // AbstractCollection
    public int size() {
	try {
	    int index = result_.getRow();
	    if (!result_.last()) {
		return (0);
	    }
	    int lastIndex = result_.getRow();
	    if (index == 0) {
		try {
//		    result_.first();
		    result_.beforeFirst();
		} catch (Exception e) {	// InstantDB
		    result_.absolute(0);
		}
	    } else {
		result_.absolute(index);
	    }
	    return (lastIndex);
	} catch (SQLException e) {
	    throw (new IllegalArgumentException(e.getMessage()));
	}
    }

    // AbstractList
    public Object get(int index) {
	try {
	    return (getObject(index));
	} catch (SQLException e) {
	    throw (new IllegalArgumentException(e.getMessage()));
	}
    }

    public Object getObject(int index) throws SQLException {
	if (!_setIndex(index)) {
	    return (null);
	}
	return (_getObject(result_));
    }

    public Element getElement(int index) throws SQLException {
	Document doc = getDocument(index);
	if (doc == null) {
	    return (null);
	}
	return (doc.getDocumentElement());
    }

    public Document getDocument(int index) throws SQLException {
	if (!_setIndex(index)) {
	    return (null);
	}
	return (_getDocument(result_));
    }

    public void close() throws SQLException {
	result_.close();
	st_.close();
    }

    protected boolean _setIndex(int index) throws SQLException {
	if (index_ == index) {
	    return (true);
	} else if (index_ + 1 == index) {
	    boolean ok = result_.next();
	    if (ok) {
		index_ = index;
		return (true);
	    } else {
		return (false);
	    }
	} else {
	    boolean ok = result_.absolute(index + 1);
	    if (ok) {
		index_ = index;
		return (true);
	    } else {
		return (false);
	    }
	}
    }

    protected Document _getDocument(ResultSet result) throws SQLException {
	try {
	    String text = result.getString("document");
	    Reader reader = new StringReader(text);
	    return (USQL.makeDocument(reader));
	} catch (ParserConfigurationException e) {
	    throw (new SQLException(e.getMessage()));
	} catch (SAXException e) {
	    throw (new SQLException(e.getMessage()));
	} catch (IOException e) {
	    throw (new SQLException(e.getMessage()));
	}
    }

    protected Object _getObject(ResultSet result) throws SQLException {
	return (_getDocument(result));
    }
}
