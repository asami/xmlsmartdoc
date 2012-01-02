package org.relaxer.framework.auth.rAccount;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * A data manipulation object for a table 'account'.
 *
 * @version account.rng 1.0 (Tue Sep 09 05:58:16 GMT+09:00 2003)
 * @author  Relaxer 1.0rc3b (http://www.relaxer.org)
 */
public class AccountTable implements IAccountTableView {
    private Connection conn_;
    private String selectClause_;
    private String tableName_;
    private PreparedStatement insertStatement_;
    private PreparedStatement updateStatement_;
    private boolean jdbc2 = true;
    private String quoteId = "\"";
    private String quoteWhere = "";
    private String quoteIdInWhere = "";

    /**
     * Creates a <code>AccountTable</code>.
     *
     * @param url
     * @param tableName
     * @exception SQLException
     */
    public AccountTable(String url, String tableName) throws SQLException {
        conn_ = DriverManager.getConnection(url);
        tableName_ = tableName;
    }

    /**
     * Creates a <code>AccountTable</code>.
     *
     * @param url
     * @param tableName
     * @param username
     * @param password
     * @exception SQLException
     */
    public AccountTable(String url, String tableName, String username, String password) throws SQLException {
        conn_ = DriverManager.getConnection(url, username, password);
        tableName_ = tableName;
    }

    /**
     * Creates a <code>AccountTable</code>.
     *
     * @param url
     * @param tableName
     * @param properties
     * @exception SQLException
     */
    public AccountTable(String url, String tableName, java.util.Properties properties) throws SQLException {
        conn_ = DriverManager.getConnection(url, properties);
        tableName_ = tableName;
    }

    /**
     * Creates a <code>AccountTable</code> by a Connection.
     *
     * @param connection
     * @param tableName
     */
    public AccountTable(Connection connection, String tableName) {
        conn_ = connection;
        tableName_ = tableName;
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
     * Gets a name of table.
     *
     * @exception SQLException
     * @return String
     */
    public String getTableName() throws SQLException {
        return (tableName_);
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
        if (selectClause_ == null) {
            selectClause_ = "SELECT * FROM " + getQuoteId() + tableName_ + getQuoteId();
        }
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
        if (insertStatement_ != null) {
            insertStatement_.close();
            insertStatement_ = null;
        }
        if (updateStatement_ != null) {
            updateStatement_.close();
            updateStatement_ = null;
        }
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
     * Creates a table.
     *
     * @exception SQLException
     */
    public void createTable() throws SQLException {
        Statement st = conn_.createStatement();
        try {
            st.execute(
                "CREATE TABLE " + getQuoteId() + tableName_ + getQuoteId() + " (" + getQuoteId() + "name" + getQuoteId() + " VARCHAR(32) PRIMARY KEY, " + getQuoteId() + "password" + getQuoteId() + " VARCHAR(32) NOT NULL, " + getQuoteId() + "otherAnyElement" + getQuoteId() + " VARCHAR(512))"
            );
        } finally {
            st.close();
        }
    }

    /**
     * Drops the table.
     *
     * @exception SQLException
     */
    public void dropTable() throws SQLException {
        Statement st = conn_.createStatement();
        try {
            st.execute(
                "DROP TABLE " + getQuoteId() + tableName_ + getQuoteId()
            );
        } finally {
            st.close();
        }
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
     * @return RAccount[]
     */
    public RAccount[] select() throws SQLException {
        Document[] docs = selectAsDocuments();
        RAccount[] result = new RAccount[docs.length];
        for (int i = 0;i < docs.length;i++) {
            result[i] = new RAccount(docs[i]);
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
     * @return RAccount[]
     */
    public RAccount[] select(String where) throws SQLException {
        Document[] docs = selectAsDocuments(where);
        RAccount[] result = new RAccount[docs.length];
        for (int i = 0;i < docs.length;i++) {
            result[i] = new RAccount(docs[i]);
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
     * @param name
     * @exception SQLException
     * @return Document
     */
    public Document getByNameAsDocument(String name) throws SQLException {
        Statement st = conn_.createStatement();
        try {
            ResultSet rs = st.executeQuery(getSelectClause() + " WHERE " + getQuoteWhere() + getQuoteIdInWhereCooked() + "name" + getQuoteIdInWhereCooked() + " = " + "'" + name + "'" + getQuoteWhere());
            if (!rs.next()) {
                return (null);
            } {
                return (makeDocument(rs));
            }
        } finally {
            st.close();
        }
    }

    /**
     * Getds contents of the table.
     *
     * @param name
     * @exception SQLException
     * @return RAccount
     */
    public RAccount getByName(String name) throws SQLException {
        Document doc = getByNameAsDocument(name);
        if (doc == null) {
            return (null);
        }
        return (new RAccount(doc));
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
     * @return RAccount[]
     */
    public RAccount[] selectByExpression(String expression) throws SQLException {
        Document[] docs = selectByExpressionAsDocuments(expression);
        RAccount[] result = new RAccount[docs.length];
        for (int i = 0;i < docs.length;i++) {
            result[i] = new RAccount(docs[i]);
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
     * @return AccountList
     */
    public AccountList selectAsList() throws SQLException {
        Statement st = _getStatement();
        ResultSet rs = st.executeQuery(getSelectClause());
        return (new AccountList(rs, st));
    }

    /**
     * Gets contents of the table.
     *
     * @param where
     * @exception SQLException
     * @return AccountList
     */
    public AccountList selectAsList(String where) throws SQLException {
        Statement st = _getStatement();
        ResultSet rs = st.executeQuery(getSelectClause() + " WHERE " + getQuoteWhere() + where + getQuoteWhere());
        return (new AccountList(rs, st));
    }

    /**
     * Gets contents of the table.
     *
     * @param expression
     * @exception SQLException
     * @return AccountList
     */
    public AccountList selectByExpressionAsList(String expression) throws SQLException {
        Statement st = _getStatement();
        ResultSet rs = st.executeQuery(getSelectClause() + " " + expression);
        return (new AccountList(rs, st));
    }

    /**
     * Insert a Document.
     *
     * @param doc
     * @exception SQLException
     */
    public void insert(Document doc) throws SQLException {
        insert(doc.getDocumentElement());
    }

    /**
     * Insert Documents by array.
     *
     * @param docs
     * @exception SQLException
     */
    public void insert(Document[] docs) throws SQLException {
        boolean autoCommit = conn_.getAutoCommit();
        if (autoCommit) {
            conn_.setAutoCommit(false);
        }
        for (int i = 0;i < docs.length;i++) {
            insert(docs[i]);
        }
        if (autoCommit) {
            conn_.commit();
            conn_.setAutoCommit(true);
        }
    }

    /**
     * Insert a Element.
     *
     * @param element
     * @exception SQLException
     */
    public void insert(Element element) throws SQLException {
        if (insertStatement_ == null) {
            insertStatement_ = conn_.prepareStatement(
                "INSERT INTO " + getQuoteId() + tableName_ + getQuoteId() + " (" + getQuoteId() + "name" + getQuoteId() + ", " + getQuoteId() + "password" + getQuoteId() + ", " + getQuoteId() + "otherAnyElement" + getQuoteId() + ")" + " VALUES (?, ?, ?)"
            );
        }
        PreparedStatement st = insertStatement_;
        st.setString(1, USQLNS.getPropertyAsString(element, "@name"));
        st.setString(2, USQLNS.getPropertyAsString(element, "@password"));
        st.setString(3, USQLNS.getHedgePropertyAsXMLString(element, "<http://www.relaxer.org/xmlns/framework/account><anyName><except><nsName></nsName></except></anyName>"));
        st.execute();
    }

    /**
     * Insert Elements by array.
     *
     * @param elements
     * @exception SQLException
     */
    public void insert(Element[] elements) throws SQLException {
        boolean autoCommit = conn_.getAutoCommit();
        if (autoCommit) {
            conn_.setAutoCommit(false);
        }
        for (int i = 0;i < elements.length;i++) {
            insert(elements[i]);
        }
        if (autoCommit) {
            conn_.commit();
            conn_.setAutoCommit(true);
        }
    }

    /**
     * Insert Elements by DocumentFragment.
     *
     * @param frag
     * @exception SQLException
     */
    public void insert(DocumentFragment frag) throws SQLException {
        insert(USQL.getElements(frag));
    }

    /**
     * Insert a Object.
     *
     * @param object
     * @exception SQLException
     */
    public void insert(RAccount object) throws SQLException {
        try {
            Document doc = object.makeDocument();
            insert(doc);
        } catch (ParserConfigurationException e) {
            throw (new SQLException(e.getMessage()));
        }
    }

    /**
     * Insert objects by array.
     *
     * @param objects
     * @exception SQLException
     */
    public void insert(RAccount[] objects) throws SQLException {
        boolean autoCommit = conn_.getAutoCommit();
        if (autoCommit) {
            conn_.setAutoCommit(false);
        }
        for (int i = 0;i < objects.length;i++) {
            insert(objects[i]);
        }
        if (autoCommit) {
            conn_.commit();
            conn_.setAutoCommit(true);
        }
    }

    /**
     * Insert collection of documents by collection.
     *
     * @param collection
     * @exception SQLException
     */
    public void insert(Collection collection) throws SQLException {
        boolean autoCommit = conn_.getAutoCommit();
        if (autoCommit) {
            conn_.setAutoCommit(false);
        }
        Iterator iter = collection.iterator();
        while (iter.hasNext()) {
            Object object = iter.next();
            if (object instanceof Document) {
                insert((Document)object);
            } else if (object instanceof Element) {
                insert((Element)object);
            } else if (object instanceof RAccount) {
                insert((RAccount)object);
            } else {
                throw (new IllegalArgumentException(object.toString()));
            }
        }
        if (autoCommit) {
            conn_.commit();
            conn_.setAutoCommit(true);
        }
    }

    /**
     * Insert collection of documents by URI.
     *
     * @param uri
     * @exception SQLException
     * @exception ParserConfigurationException
     * @exception IOException
     * @exception SAXException
     */
    public void insert(String uri) throws SQLException, ParserConfigurationException, IOException, SAXException {
        Document doc = USQLNS.makeDocument(USQL.makeupUri(uri));
        insert(doc);
    }

    /**
     * Insert Documents by URI array.
     *
     * @param uris
     * @exception SQLException
     * @exception ParserConfigurationException
     * @exception IOException
     * @exception SAXException
     */
    public void insert(String[] uris) throws SQLException, ParserConfigurationException, IOException, SAXException {
        boolean autoCommit = conn_.getAutoCommit();
        if (autoCommit) {
            conn_.setAutoCommit(false);
        }
        for (int i = 0;i < uris.length;i++) {
            insert(uris[i]);
        }
        if (autoCommit) {
            conn_.commit();
            conn_.setAutoCommit(true);
        }
    }

    /**
     * Insert collection of documents by URL.
     *
     * @param url
     * @exception SQLException
     * @exception ParserConfigurationException
     * @exception IOException
     * @exception SAXException
     */
    public void insert(URL url) throws SQLException, ParserConfigurationException, IOException, SAXException {
        Document doc = USQLNS.makeDocument(url);
        insert(doc);
    }

    /**
     * Insert Documents by URL array.
     *
     * @param urls
     * @exception SQLException
     * @exception ParserConfigurationException
     * @exception IOException
     * @exception SAXException
     */
    public void insert(URL[] urls) throws SQLException, ParserConfigurationException, IOException, SAXException {
        boolean autoCommit = conn_.getAutoCommit();
        if (autoCommit) {
            conn_.setAutoCommit(false);
        }
        for (int i = 0;i < urls.length;i++) {
            insert(urls[i]);
        }
        if (autoCommit) {
            conn_.commit();
            conn_.setAutoCommit(true);
        }
    }

    /**
     * Insert collection of documents by File.
     *
     * @param file
     * @exception SQLException
     * @exception ParserConfigurationException
     * @exception IOException
     * @exception SAXException
     */
    public void insert(File file) throws SQLException, ParserConfigurationException, IOException, SAXException {
        Document doc = USQLNS.makeDocument(file);
        insert(doc);
    }

    /**
     * Insert Documents by File array.
     *
     * @param files
     * @exception SQLException
     * @exception ParserConfigurationException
     * @exception IOException
     * @exception SAXException
     */
    public void insert(File[] files) throws SQLException, ParserConfigurationException, IOException, SAXException {
        boolean autoCommit = conn_.getAutoCommit();
        if (autoCommit) {
            conn_.setAutoCommit(false);
        }
        for (int i = 0;i < files.length;i++) {
            insert(files[i]);
        }
        if (autoCommit) {
            conn_.commit();
            conn_.setAutoCommit(true);
        }
    }

    /**
     * Insert collection of documents by InputStream.
     *
     * @param in
     * @exception SQLException
     * @exception ParserConfigurationException
     * @exception IOException
     * @exception SAXException
     */
    public void insert(InputStream in) throws SQLException, ParserConfigurationException, IOException, SAXException {
        Document doc = USQLNS.makeDocument(in);
        insert(doc);
    }

    /**
     * Insert Documents by InputStream array.
     *
     * @param ins
     * @exception SQLException
     * @exception ParserConfigurationException
     * @exception IOException
     * @exception SAXException
     */
    public void insert(InputStream[] ins) throws SQLException, ParserConfigurationException, IOException, SAXException {
        boolean autoCommit = conn_.getAutoCommit();
        if (autoCommit) {
            conn_.setAutoCommit(false);
        }
        for (int i = 0;i < ins.length;i++) {
            insert(ins[i]);
        }
        if (autoCommit) {
            conn_.commit();
            conn_.setAutoCommit(true);
        }
    }

    /**
     * Insert collection of documents by InputSource.
     *
     * @param in
     * @exception SQLException
     * @exception ParserConfigurationException
     * @exception IOException
     * @exception SAXException
     */
    public void insert(InputSource in) throws SQLException, ParserConfigurationException, IOException, SAXException {
        Document doc = USQLNS.makeDocument(in);
        insert(doc);
    }

    /**
     * Insert Documents by InputSource array.
     *
     * @param ins
     * @exception SQLException
     * @exception ParserConfigurationException
     * @exception IOException
     * @exception SAXException
     */
    public void insert(InputSource[] ins) throws SQLException, ParserConfigurationException, IOException, SAXException {
        boolean autoCommit = conn_.getAutoCommit();
        if (autoCommit) {
            conn_.setAutoCommit(false);
        }
        for (int i = 0;i < ins.length;i++) {
            insert(ins[i]);
        }
        if (autoCommit) {
            conn_.commit();
            conn_.setAutoCommit(true);
        }
    }

    /**
     * Insert collection of documents by Reader.
     *
     * @param in
     * @exception SQLException
     * @exception ParserConfigurationException
     * @exception IOException
     * @exception SAXException
     */
    public void insert(Reader in) throws SQLException, ParserConfigurationException, IOException, SAXException {
        Document doc = USQLNS.makeDocument(in);
        insert(doc);
    }

    /**
     * Insert Documents by Reader array.
     *
     * @param ins
     * @exception SQLException
     * @exception ParserConfigurationException
     * @exception IOException
     * @exception SAXException
     */
    public void insert(Reader[] ins) throws SQLException, ParserConfigurationException, IOException, SAXException {
        boolean autoCommit = conn_.getAutoCommit();
        if (autoCommit) {
            conn_.setAutoCommit(false);
        }
        for (int i = 0;i < ins.length;i++) {
            insert(ins[i]);
        }
        if (autoCommit) {
            conn_.commit();
            conn_.setAutoCommit(true);
        }
    }

    /**
     * Update a Document.
     *
     * @param doc
     * @exception SQLException
     * @return int
     */
    public int update(Document doc) throws SQLException {
        return (update(doc.getDocumentElement()));
    }

    /**
     * Update a Element.
     *
     * @param element
     * @exception SQLException
     * @return int
     */
    public int update(Element element) throws SQLException {
        if (updateStatement_ == null) {
            updateStatement_ = conn_.prepareStatement(
                "UPDATE " + getQuoteId() + tableName_ + getQuoteId() + " SET " + getQuoteId() + "password" + getQuoteId() + " = ?, " + getQuoteId() + "otherAnyElement" + getQuoteId() + " = ? WHERE " + getQuoteWhere() + getQuoteIdInWhereCooked() + "name" + getQuoteIdInWhereCooked() + " = ? "+ getQuoteWhere()
            );
        }
        PreparedStatement st = updateStatement_;
        st.setString(1, USQLNS.getPropertyAsString(element, "@password"));
        st.setString(2, USQLNS.getHedgePropertyAsXMLString(element, "<http://www.relaxer.org/xmlns/framework/account><anyName><except><nsName></nsName></except></anyName>"));
        st.setString(3, USQLNS.getPropertyAsString(element, "@name"));
        return (st.executeUpdate());
    }

    /**
     * Update a Element.
     *
     * @param object
     * @exception SQLException
     * @return int
     */
    public int update(RAccount object) throws SQLException {
        try {
            Document doc = object.makeDocument();
            return (update(doc));
        } catch (ParserConfigurationException e) {
            throw (new SQLException(e.getMessage()));
        }
    }

    /**
     * Deletes the record of the table specified by a primary key.
     *
     * @param name
     * @exception SQLException
     * @return int
     */
    public int deleteByName(String name) throws SQLException {
        Statement st = conn_.createStatement();
        try {
            int count = st.executeUpdate("DELETE FROM " + getQuoteId() + tableName_ + getQuoteId() + " WHERE " + getQuoteWhere() + getQuoteIdInWhereCooked() + "name" + getQuoteIdInWhereCooked() + " = " + "'" + name + "'" + getQuoteWhere());
            return (count);
        } finally {
            st.close();
        }
    }

    /**
     * Deletes the record of the table specified by a where expression.
     *
     * @param where
     * @exception SQLException
     * @return int
     */
    public int delete(String where) throws SQLException {
        Statement st = conn_.createStatement();
        try {
            int count = st.executeUpdate("DELETE FROM " + getQuoteId() + tableName_ + getQuoteId() + " WHERE " + getQuoteWhere() + where + getQuoteWhere());
            return (count);
        } finally {
            st.close();
        }
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
            Document doc = USQLNS.makeNewDocument("http://www.relaxer.org/xmlns/framework/account","account");
            Element element = doc.getDocumentElement();
            USQLNS.setProperty(rs, "name", "@name", element);
            USQLNS.setProperty(rs, "password", "@password", element);
            USQLNS.setHedgePropertyZeroOne(rs, "otherAnyElement", "<http://www.relaxer.org/xmlns/framework/account><anyName><except><nsName></nsName></except></anyName>", element);
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
            Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework/account","account");
            USQLNS.setProperty(rs, "name", "@name", element);
            USQLNS.setProperty(rs, "password", "@password", element);
            USQLNS.setHedgePropertyZeroOne(rs, "otherAnyElement", "<http://www.relaxer.org/xmlns/framework/account><anyName><except><nsName></nsName></except></anyName>", element);
            return (element);
    }

    /**
     * Command interface.
     *
     * @param args
     * @exception Exception
     */
    public static void main(String[] args) throws Exception {
        String url = USQL.getUrl(args);
        String username = USQL.getUsername(args);
        String password = USQL.getPassword(args);
        String tableName = USQL.getTableName(args);
        String command = USQL.getCommand(args);
        String[] uris = USQL.getUris(args);
        AccountTable table = new AccountTable(url, tableName, username, password);
        if ("create".equals(command)) {
            table.createTable();
        } else if ("drop".equals(command)) {
            table.dropTable();
        } else if ("dump".equals(command)) {
            Document[] docs = table.selectAsDocuments();
            for (int i = 0;i < docs.length;i++) {
                USQL.printXMLDocument(docs[i]);
            }
        } else if ("find".equals(command)) {
            String key = USQL.getKey(args);
            String where = USQL.getWhere(args);
            if (key != null) {
                String[] keys = USQL.key2Keys(key);
                Document doc = table.getByNameAsDocument(keys[0]);
                USQL.printXMLDocument(doc);
            } else if (where != null) {
                Document[] docs = table.selectAsDocuments(where);
                for (int i = 0;i < docs.length;i++) {
                    USQL.printXMLDocument(docs[i]);
                }
            } else {
                throw (new IllegalArgumentException());
            }
        } else if ("insert".equals(command)) {
            for (int i = 0;i < uris.length;i++) {
                Document doc = USQLNS.makeDocument(uris[i]);
                table.insert(doc.getDocumentElement());
            }
        } else if ("update".equals(command)) {
            for (int i = 0;i < uris.length;i++) {
                Document doc = USQLNS.makeDocument(uris[i]);
                table.update(doc.getDocumentElement());
            }
        } else if ("delete".equals(command)) {
            String key = USQL.getKey(args);
            String where = USQL.getWhere(args);
            if (key != null) {
                String[] keys = USQL.key2Keys(key);
                table.deleteByName(keys[0]);
            } else if (where != null) {
                table.delete(where);
            } else {
                throw (new IllegalArgumentException());
            }
        }
        table.close();
    }
}
