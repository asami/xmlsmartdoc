package org.relaxer.framework.auth.rAccount;

import java.sql.*;
import org.w3c.dom.*;

public interface IAccountsTableView {
    /**
     * @return boolean
     */
    boolean getJdbc2();

    /**
     * @param jdbc2
     */
    void setJdbc2(boolean jdbc2);

    /**
     * @return String
     */
    String getQuoteId();

    /**
     * @param quoteId
     */
    void setQuoteId(String quoteId);

    /**
     * @return String
     */
    String getQuoteWhere();

    /**
     * @param quoteWhere
     */
    void setQuoteWhere(String quoteWhere);

    /**
     * @return String
     */
    String getQuoteIdInWhere();

    /**
     * @param quoteIdInWhere
     */
    void setQuoteIdInWhere(String quoteIdInWhere);

    /**
     * @return String
     */
    String getQuoteIdInWhereCooked();

    /**
     * @exception SQLException
     * @return Connection
     */
    Connection getConnection() throws SQLException;

    /**
     * @return String
     */
    String getSelectClause();

    /**
     * @param autoCommit
     * @exception SQLException
     */
    void setAutoCommit(boolean autoCommit) throws SQLException;

    /**
     * @exception SQLException
     * @return boolean
     */
    boolean getAutoCommit() throws SQLException;

    /**
     * @exception SQLException
     */
    void commit() throws SQLException;

    /**
     * @exception SQLException
     */
    void rollback() throws SQLException;

    /**
     * @param level
     * @exception SQLException
     */
    void setTransactionIsolation(int level) throws SQLException;

    /**
     * @exception SQLException
     * @return int
     */
    int getTransactionIsolation() throws SQLException;

    /**
     * @exception SQLException
     */
    void dispose() throws SQLException;

    /**
     * @exception SQLException
     */
    void close() throws SQLException;

    /**
     * @exception SQLException
     * @return boolean
     */
    boolean isClosed() throws SQLException;

    /**
     * @exception SQLException
     * @return Document[]
     */
    Document[] selectAsDocuments() throws SQLException;

    /**
     * @exception SQLException
     * @return RAccounts[]
     */
    RAccounts[] select() throws SQLException;

    /**
     * @param doc
     * @exception SQLException
     * @return Element[]
     */
    Element[] selectAsElements(Document doc) throws SQLException;

    /**
     * @exception SQLException
     * @return Document
     */
    Document selectAsDocument() throws SQLException;

    /**
     * @param where
     * @exception SQLException
     * @return Document[]
     */
    Document[] selectAsDocuments(String where) throws SQLException;

    /**
     * @param where
     * @exception SQLException
     * @return RAccounts[]
     */
    RAccounts[] select(String where) throws SQLException;

    /**
     * @param where
     * @param doc
     * @exception SQLException
     * @return Element[]
     */
    Element[] selectAsElements(String where, Document doc) throws SQLException;

    /**
     * @param where
     * @exception SQLException
     * @return Document
     */
    Document selectAsDocument(String where) throws SQLException;

    /**
     * @param expression
     * @exception SQLException
     * @return Document[]
     */
    Document[] selectByExpressionAsDocuments(String expression) throws SQLException;

    /**
     * @param expression
     * @exception SQLException
     * @return RAccounts[]
     */
    RAccounts[] selectByExpression(String expression) throws SQLException;

    /**
     * @param expression
     * @param doc
     * @exception SQLException
     * @return Element[]
     */
    Element[] selectByExpressionAsElements(String expression, Document doc) throws SQLException;

    /**
     * @param expression
     * @exception SQLException
     * @return Document
     */
    Document selectByExpressionAsDocument(String expression) throws SQLException;

    /**
     * @exception SQLException
     * @return AccountsList
     */
    AccountsList selectAsList() throws SQLException;

    /**
     * @param where
     * @exception SQLException
     * @return AccountsList
     */
    AccountsList selectAsList(String where) throws SQLException;

    /**
     * @param expression
     * @exception SQLException
     * @return AccountsList
     */
    AccountsList selectByExpressionAsList(String expression) throws SQLException;
}
