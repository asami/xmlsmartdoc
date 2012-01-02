package org.relaxer.framework.auth.rAccount;

import java.sql.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * A data view object for a table 'accounts'.
 *
 * @version account.rng 1.0 (Tue Sep 09 05:58:16 GMT+09:00 2003)
 * @author  Relaxer 1.0rc3b (http://www.relaxer.org)
 */
public class AccountsTableView implements IAccountsTableView {
    private Connection conn_;
    private String selectClause_;
    private boolean jdbc2 = true;
    private String quoteId = "\"";
    private String quoteWhere = "";
    private String quoteIdInWhere = "";

    /**
     * Creates a <code>AccountsTableView</code>.
     *
     * @param url
     * @param selectClause
     * @exception SQLException
     */
    public AccountsTableView(String url, String selectClause) throws SQLException {
        conn_ = DriverManager.getConnection(url);
        selectClause_ = selectClause;
    }

    /**
     * Creates a <code>AccountsTableView</code>.
     *
     * @param url
     * @param selectClause
     * @param username
     * @param password
     * @exception SQLException
     */
    public AccountsTableView(String url, String selectClause, String username, String password) throws SQLException {
        conn_ = DriverManager.getConnection(url, username, password);
        selectClause_ = selectClause;
    }

    /**
     * Creates a <code>AccountsTableView</code>.
     *
     * @param url
     * @param selectClause
     * @param properties
     * @exception SQLException
     */
    public AccountsTableView(String url, String selectClause, java.util.Properties properties) throws SQLException {
        conn_ = DriverManager.getConnection(url, properties);
        selectClause_ = selectClause;
    }

    /**
     * Creates a <code>AccountsTableView</code> by a Connection.
     *
     * @param connection
     * @param selectClause
     */
    public AccountsTableView(Connection connection, String selectClause) {
        conn_ = connection;
        selectClause_ = selectClause;
    }

    /**
     * Gets the boolean property <b>jdbc2</b>.
     *
     * @return boolean
     */
    public final boolean getJdbc2() {
        return (jdbc2);
    }

    /**
     * Sets the boolean property <b>jdbc2</b>.
     *
     * @param jdbc2
     */
    public final void setJdbc2(boolean jdbc2) {
        this.jdbc2 = jdbc2;
    }

    /**
     * Gets the String property <b>quoteId</b>.
     *
     * @return String
     */
    public final String getQuoteId() {
        return (quoteId);
    }

    /**
     * Sets the String property <b>quoteId</b>.
     *
     * @param quoteId
     */
    public final void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    /**
     * Gets the String property <b>quoteWhere</b>.
     *
     * @return String
     */
    public final String getQuoteWhere() {
        return (quoteWhere);
    }

    /**
     * Sets the String property <b>quoteWhere</b>.
     *
     * @param quoteWhere
     */
    public final void setQuoteWhere(String quoteWhere) {
        this.quoteWhere = quoteWhere;
    }

    /**
     * Gets the String property <b>quoteIdInWhere</b>.
     *
     * @return String
     */
    public final String getQuoteIdInWhere() {
        return (quoteIdInWhere);
    }

    /**
     * Sets the String property <b>quoteIdInWhere</b>.
     *
     * @param quoteIdInWhere
     */
    public final void setQuoteIdInWhere(String quoteIdInWhere) {
        this.quoteIdInWhere = quoteIdInWhere;
    }

    /**
     * Gets a quote symbol for id in where clause.
     *
     * @return String
     */
    public String getQuoteIdInWhereCooked() {
        if (quoteWhere == null || "".equals(quoteWhere)) {
            return (quoteId);
        } else {
            return (quoteIdInWhere);
        }
    }

    /**
     * Gets a database connection.
     *
     * @exception SQLException
     * @return Connection
     */
    public Connection getConnection() throws SQLException {
        return (conn_);
    }

    /**
     * Gets a core select clause.
     *
     * @return String
     */
    public String getSelectClause() {
        return (selectClause_);
    }

    /**
     * Sets auto-commit mode.
     *
     * @param autoCommit
     * @exception SQLException
     */
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        conn_.setAutoCommit(autoCommit);
    }

    /**
     * Gets auto-commit mode.
     *
     * @exception SQLException
     * @return boolean
     */
    public boolean getAutoCommit() throws SQLException {
        return (conn_.getAutoCommit());
    }

    /**
     * Commits transaction.
     *
     * @exception SQLException
     */
    public void commit() throws SQLException {
        conn_.commit();
    }

    /**
     * Rollbacks transaction.
     *
     * @exception SQLException
     */
    public void rollback() throws SQLException {
        conn_.rollback();
    }

    /**
     * Sets transaction isolation level.
     *
     * @param level
     * @exception SQLException
     */
    public void setTransactionIsolation(int level) throws SQLException {
        conn_.setTransactionIsolation(level);
    }

    /**
     * Gets transaction isolation level.
     *
     * @exception SQLException
     * @return int
     */
    public int getTransactionIsolation() throws SQLException {
        return (conn_.getTransactionIsolation());
    }

    /**
     * Relases the resources.
     *
     * @exception SQLException
     */
    public void dispose() throws SQLException {
    }

    /**
     * Closes the connection.
     *
     * @exception SQLException
     */
    public void close() throws SQLException {
        dispose();
        conn_.close();
    }

    /**
     * Checks if connection is closed.
     *
     * @exception SQLException
     * @return boolean
     */
    public boolean isClosed() throws SQLException {
        return (conn_.isClosed());
    }

    /**
     * Gets contents of the table.
     *
     * @exception SQLException
     * @return Document[]
     */
    public Document[] selectAsDocuments() throws SQLException {
        Statement st = conn_.createStatement();
        try {
            ResultSet rs = st.executeQuery(getSelectClause());
            return (makeDocuments(rs));
        } finally {
            st.close();
        }
    }

    /**
     * Gets contents of the table.
     *
     * @exception SQLException
     * @return RAccounts[]
     */
    public RAccounts[] select() throws SQLException {
        Document[] docs = selectAsDocuments();
        RAccounts[] result = new RAccounts[docs.length];
        for (int i = 0;i < docs.length;i++) {
            result[i] = new RAccounts(docs[i]);
        }
        return (result);
    }

    /**
     * Gets contents of the table.
     *
     * @param doc
     * @exception SQLException
     * @return Element[]
     */
    public Element[] selectAsElements(Document doc) throws SQLException {
        Statement st = conn_.createStatement();
        try {
            ResultSet rs = st.executeQuery(getSelectClause());
            return (makeElements(rs, doc));
        } finally {
            st.close();
        }
    }

    /**
     * Gets contents of the table.
     *
     * @exception SQLException
     * @return Document
     */
    public Document selectAsDocument() throws SQLException {
        try {
            Document doc = USQLNS.makeDocument();
            return (USQL.makeListDocument(selectAsElements(doc)));
        } catch (ParserConfigurationException e) {
            throw (new SQLException(e.getMessage()));
        }
    }

    /**
     * Gets contents of the table.
     *
     * @param where
     * @exception SQLException
     * @return Document[]
     */
    public Document[] selectAsDocuments(String where) throws SQLException {
        Statement st = conn_.createStatement();
        try {
            ResultSet rs = st.executeQuery(getSelectClause() + " WHERE " + getQuoteWhere() + where + getQuoteWhere());
            return (makeDocuments(rs));
        } finally {
            st.close();
        }
    }

    /**
     * Gets contents of the table.
     *
     * @param where
     * @exception SQLException
     * @return RAccounts[]
     */
    public RAccounts[] select(String where) throws SQLException {
        Document[] docs = selectAsDocuments(where);
        RAccounts[] result = new RAccounts[docs.length];
        for (int i = 0;i < docs.length;i++) {
            result[i] = new RAccounts(docs[i]);
        }
        return (result);
    }

    /**
     * Gets contents of the table.
     *
     * @param where
     * @param doc
     * @exception SQLException
     * @return Element[]
     */
    public Element[] selectAsElements(String where, Document doc) throws SQLException {
        Statement st = conn_.createStatement();
        try {
            ResultSet rs = st.executeQuery(getSelectClause() + " WHERE " + getQuoteWhere() + where + getQuoteWhere());
            return (makeElements(rs, doc));
        } finally {
            st.close();
        }
    }

    /**
     * Gets contents of the table.
     *
     * @param where
     * @exception SQLException
     * @return Document
     */
    public Document selectAsDocument(String where) throws SQLException {
        try {
            Document doc = USQLNS.makeDocument();
            return (USQL.makeListDocument(selectAsElements(where, doc)));
        } catch (ParserConfigurationException e) {
            throw (new SQLException(e.getMessage()));
        }
    }

    /**
     * Gets contents of the table.
     *
     * @param expression
     * @exception SQLException
     * @return Document[]
     */
    public Document[] selectByExpressionAsDocuments(String expression) throws SQLException {
        Statement st = conn_.createStatement();
        try {
            ResultSet rs = st.executeQuery(getSelectClause() + " " + expression);
            return (makeDocuments(rs));
        } finally {
            st.close();
        }
    }

    /**
     * Gets contents of the table.
     *
     * @param expression
     * @exception SQLException
     * @return RAccounts[]
     */
    public RAccounts[] selectByExpression(String expression) throws SQLException {
        Document[] docs = selectByExpressionAsDocuments(expression);
        RAccounts[] result = new RAccounts[docs.length];
        for (int i = 0;i < docs.length;i++) {
            result[i] = new RAccounts(docs[i]);
        }
        return (result);
    }

    /**
     * Gets contents of the table.
     *
     * @param expression
     * @param doc
     * @exception SQLException
     * @return Element[]
     */
    public Element[] selectByExpressionAsElements(String expression, Document doc) throws SQLException {
        Statement st = conn_.createStatement();
        try {
            ResultSet rs = st.executeQuery(getSelectClause() + " " + expression);
            return (makeElements(rs, doc));
        } finally {
            st.close();
        }
    }

    /**
     * Gets contents of the table.
     *
     * @param expression
     * @exception SQLException
     * @return Document
     */
    public Document selectByExpressionAsDocument(String expression) throws SQLException {
        try {
            Document doc = USQLNS.makeDocument();
            return (USQL.makeListDocument(selectByExpressionAsElements(expression, doc)));
        } catch (ParserConfigurationException e) {
            throw (new SQLException(e.getMessage()));
        }
    }

    /**
     * Gets contents of the table via list.
     *
     * @exception SQLException
     * @return AccountsList
     */
    public AccountsList selectAsList() throws SQLException {
        Statement st = _getStatement();
        ResultSet rs = st.executeQuery(getSelectClause());
        return (new AccountsList(rs, st));
    }

    /**
     * Gets contents of the table.
     *
     * @param where
     * @exception SQLException
     * @return AccountsList
     */
    public AccountsList selectAsList(String where) throws SQLException {
        Statement st = _getStatement();
        ResultSet rs = st.executeQuery(getSelectClause() + " WHERE " + getQuoteWhere() + where + getQuoteWhere());
        return (new AccountsList(rs, st));
    }

    /**
     * Gets contents of the table.
     *
     * @param expression
     * @exception SQLException
     * @return AccountsList
     */
    public AccountsList selectByExpressionAsList(String expression) throws SQLException {
        Statement st = _getStatement();
        ResultSet rs = st.executeQuery(getSelectClause() + " " + expression);
        return (new AccountsList(rs, st));
    }

    /**
     * Gets a Statement.
     *
     * @exception SQLException
     * @return Statement
     */
    private Statement _getStatement() throws SQLException {
        if (getJdbc2()) {
            return (conn_.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
        } else {
            return (conn_.createStatement());
        }
    }

    /**
     * Make documents from a ResultSet <code>rs</code>.
     *
     * @param rs
     * @exception SQLException
     * @return Document[]
     */
    public static Document[] makeDocuments(ResultSet rs) throws SQLException {
        List list = new ArrayList();
        while (rs.next()) {
            Document doc = makeDocument(rs);
            list.add(doc);
        }
        Document[] result = new Document[list.size()];
        return ((Document[])list.toArray(result));
    }

    /**
     * Make a document from a current record of a ResultSet
     * <code>rs</code>.
     *
     * @param rs
     * @exception SQLException
     * @return Document
     */
    public static Document makeDocument(ResultSet rs) throws SQLException {
        try {
            Document doc = USQLNS.makeNewDocument("http://www.relaxer.org/xmlns/framework/account","accounts");
            Element element = doc.getDocumentElement();
            USQLNS.setHedgePropertyZeroOne(rs, "account", "<http://www.relaxer.org/xmlns/framework/account>account", element);
            return (doc);
        } catch (ParserConfigurationException e) {
            throw (new SQLException(e.getMessage()));
        }
    }

    /**
     * Make elements from a ResultSet <code>rs</code>.
     *
     * @param rs
     * @param doc
     * @exception SQLException
     * @return Element[]
     */
    public static Element[] makeElements(ResultSet rs, Document doc) throws SQLException {
        List list = new ArrayList();
        while (rs.next()) {
            Element element = makeElement(rs, doc);
            list.add(element);
        }
        Element[] result = new Element[list.size()];
        return ((Element[])list.toArray(result));
    }

    /**
     * Make a element from a current record of a ResultSet
     * <code>rs</code>.
     *
     * @param rs
     * @param doc
     * @exception SQLException
     * @return Element
     */
    public static Element makeElement(ResultSet rs, Document doc) throws SQLException {
            Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework/account","accounts");
            USQLNS.setHedgePropertyZeroOne(rs, "account", "<http://www.relaxer.org/xmlns/framework/account>account", element);
            return (element);
    }
}
