package org.relaxer.framework.auth.rAccount;

import java.sql.*;
import org.w3c.dom.Document;

public class AccountList extends RJDBCList {

    /**
     * Creates a <code>AccountList</code>.
     *
     * @param result
     * @param st
     */
    public AccountList(ResultSet result, Statement st) {
        super(result, st);
    }

    /**
     * gets a <code>RAccount</code>.
     *
     * @param index
     * @exception SQLException
     * @return RAccount
     */
    public RAccount getRAccount(int index) throws SQLException {
        return ((RAccount)getObject(index));
    }

    /**
     * gets a <code>RAccount</code>.
     *
     * @param result
     * @exception SQLException
     * @return Object
     */
    protected Object _getObject(ResultSet result) throws SQLException {
        return (new RAccount(_getDocument(result)));
    }

    /**
     * gets a document from a ResultSet <code>rs</code>.
     *
     * @param rs
     * @exception SQLException
     * @return Document
     */
    protected Document _getDocument(ResultSet rs) throws SQLException {
        return (AccountTable.makeDocument(rs));
    }
}
