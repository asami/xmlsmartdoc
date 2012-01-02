package org.relaxer.framework.auth.rAccount;

import java.sql.*;
import org.w3c.dom.Document;

public class AccountsList extends RJDBCList {

    /**
     * Creates a <code>AccountsList</code>.
     *
     * @param result
     * @param st
     */
    public AccountsList(ResultSet result, Statement st) {
        super(result, st);
    }

    /**
     * gets a <code>RAccounts</code>.
     *
     * @param index
     * @exception SQLException
     * @return RAccounts
     */
    public RAccounts getRAccounts(int index) throws SQLException {
        return ((RAccounts)getObject(index));
    }

    /**
     * gets a <code>RAccounts</code>.
     *
     * @param result
     * @exception SQLException
     * @return Object
     */
    protected Object _getObject(ResultSet result) throws SQLException {
        return (new RAccounts(_getDocument(result)));
    }

    /**
     * gets a document from a ResultSet <code>rs</code>.
     *
     * @param rs
     * @exception SQLException
     * @return Document
     */
    protected Document _getDocument(ResultSet rs) throws SQLException {
        return (AccountsTable.makeDocument(rs));
    }
}
