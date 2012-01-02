package org.relaxer.framework.auth.rAccount;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>RAccounts</b> is generated from account.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="accounts">
 *   <oneOrMore>
 *     <ref name="account"/>
 *   </oneOrMore>
 * </element>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;element name="accounts"&gt;
 *   &lt;oneOrMore&gt;
 *     &lt;ref name="account"/&gt;
 *   &lt;/oneOrMore&gt;
 * &lt;/element&gt;
 * </pre>
 *
 * @version account.rng (Tue Sep 09 05:58:15 GMT+09:00 2003)
 * @author  Relaxer 1.0rc3b (http://www.relaxer.org)
 */
public class RAccounts implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework/account");
    // List<RAccount>
    private java.util.List account_ = new java.util.ArrayList();
    private java.util.Map account_$map = new java.util.HashMap();
    private Element xmlElement;
    private IRNode parentRNode_;

    /**
     * Creates a <code>RAccounts</code>.
     *
     */
    public RAccounts() {
    }

    /**
     * Creates a <code>RAccounts</code>.
     *
     * @param source
     */
    public RAccounts(RAccounts source) {
        setup(source);
    }

    /**
     * Creates a <code>RAccounts</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public RAccounts(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>RAccounts</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public RAccounts(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>RAccounts</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public RAccounts(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>RAccounts</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RAccounts(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>RAccounts</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RAccounts(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>RAccounts</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RAccounts(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>RAccounts</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RAccounts(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>RAccounts</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RAccounts(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>RAccounts</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RAccounts(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>RAccounts</code> by the RAccounts <code>source</code>.
     *
     * @param source
     */
    public void setup(RAccounts source) {
        int size;
        this.account_.clear();
        size = source.account_.size();
        for (int i = 0;i < size;i++) {
            addAccount((RAccount)source.getAccount(i).clone());
        }
    }

    /**
     * Initializes the <code>RAccounts</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>RAccounts</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>RAccounts</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public void setup(RStack stack) {
        init(stack.popElement());
    }

    /**
     * @param element
     */
    private void init(Element element) {
        xmlElement = element;
        RStack stack = new RStack(element);
        rNSContext_.declareNamespace(element);
        account_.clear();
        while (true) {
            if (RAccount.isMatch(stack)) {
                addAccount(new RAccount(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new RAccounts(this));
    }

    /**
     * Creates a DOM representation of the object.
     * Result is appended to the Node <code>parent</code>.
     *
     * @param parent
     */
    public void makeElement(Node parent) {
        Document doc;
        if (parent instanceof Document) {
            doc = (Document)parent;
        } else {
            doc = parent.getOwnerDocument();
        }
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework/account", "accounts");
        rNSContext_.setupNamespace(element);
        int size;
        size = this.account_.size();
        for (int i = 0;i < size;i++) {
            RAccount value = (RAccount)this.account_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>RAccounts</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file.toURL());
    }

    /**
     * Initializes the <code>RAccounts</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(uri, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>RAccounts</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(url, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>RAccounts</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(in, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>RAccounts</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(is, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>RAccounts</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(reader, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Creates a DOM document representation of the object.
     *
     * @exception ParserConfigurationException
     * @return Document
     */
    public Document makeDocument() throws ParserConfigurationException {
        Document doc = UJAXP.makeDocument();
        makeElement(doc);
        return (doc);
    }

    /**
     * Gets the RNSContext property <b>RNSContext</b>.
     *
     * @return RNSContext
     */
    public final RNSContext rGetRNSContext() {
        return (rNSContext_);
    }

    /**
     * Sets the RNSContext property <b>RNSContext</b>.
     *
     * @param rNSContext
     */
    public final void rSetRNSContext(RNSContext rNSContext) {
        this.rNSContext_ = rNSContext;
    }

    /**
     * Gets the RAccount property <b>account</b>.
     *
     * @return RAccount[]
     */
    public final RAccount[] getAccount() {
        RAccount[] array = new RAccount[account_.size()];
        return ((RAccount[])account_.toArray(array));
    }

    /**
     * Sets the RAccount property <b>account</b>.
     *
     * @param account
     */
    public final void setAccount(RAccount[] account) {
        this.account_.clear();
        for (int i = 0;i < account.length;i++) {
            addAccount(account[i]);
        }
        for (int i = 0;i < account.length;i++) {
            account[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the RAccount property <b>account</b>.
     *
     * @param account
     */
    public final void setAccount(RAccount account) {
        this.account_.clear();
        addAccount(account);
        if (account != null) {
            account.rSetParentRNode(this);
        }
    }

    /**
     * Adds the RAccount property <b>account</b>.
     *
     * @param account
     */
    public final void addAccount(RAccount account) {
        Object $key$ = account.getName();
        Object $value$ = this.account_$map.get($key$);
        if ($value$ != null) {
            this.account_.remove($value$);
        }
        this.account_$map.put($key$, account);
        this.account_.add(account);
        if (account != null) {
            account.rSetParentRNode(this);
        }
    }

    /**
     * Adds the RAccount property <b>account</b>.
     *
     * @param account
     */
    public final void addAccount(RAccount[] account) {
        for (int i = 0;i < account.length;i++) {
            addAccount(account[i]);
        }
        for (int i = 0;i < account.length;i++) {
            account[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the RAccount property <b>account</b>.
     *
     * @return int
     */
    public final int sizeAccount() {
        return (account_.size());
    }

    /**
     * Gets the RAccount property <b>account</b> by index.
     *
     * @param index
     * @return RAccount
     */
    public final RAccount getAccount(int index) {
        return ((RAccount)account_.get(index));
    }

    /**
     * Sets the RAccount property <b>account</b> by index.
     *
     * @param index
     * @param account
     */
    public final void setAccount(int index, RAccount account) {
        Object $key$ = account.getName();
        Object $value$ = this.account_$map.get($key$);
        if ($value$ != null) {
            this.account_.remove($value$);
        }
        this.account_$map.put($key$, account);
        this.account_.set(index, account);
        if (account != null) {
            account.rSetParentRNode(this);
        }
    }

    /**
     * Adds the RAccount property <b>account</b> by index.
     *
     * @param index
     * @param account
     */
    public final void addAccount(int index, RAccount account) {
        Object $key$ = account.getName();
        Object $value$ = this.account_$map.get($key$);
        if ($value$ != null) {
            this.account_.remove($value$);
        }
        this.account_$map.put($key$, account);
        this.account_.add(index, account);
        if (account != null) {
            account.rSetParentRNode(this);
        }
    }

    /**
     * Remove the RAccount property <b>account</b> by index.
     *
     * @param index
     */
    public final void removeAccount(int index) {
        RAccount $value$ = (RAccount)account_.get(index);
        if ($value$ != null) {
            removeAccount($value$);
        }
        this.account_.remove(index);
    }

    /**
     * Remove the RAccount property <b>account</b> by object.
     *
     * @param account
     */
    public final void removeAccount(RAccount account) {
        Object $key$ = account.getName();
        this.account_$map.remove($key$);
        this.account_.remove(account);
    }

    /**
     * Clear the RAccount property <b>account</b>.
     *
     */
    public final void clearAccount() {
        this.account_$map.clear();
        this.account_.clear();
    }

    /**
     * Gets the RAccount property <b>account</b> by key.
     *
     * @param key
     * @return RAccount
     */
    public final RAccount getAccountByName(String key) {
        return ((RAccount)account_$map.get(key));
    }

    /**
     * Gets the element to be used in the object construction.
     *
     * @return Element
     */
    public Element rGetElement() {
        return (xmlElement);
    }

    /**
     * Makes an XML text representation.
     *
     * @return String
     */
    public String makeTextDocument() {
        StringBuffer buffer = new StringBuffer();
        makeTextElement(buffer);
        return (new String(buffer));
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(StringBuffer buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/account");
        buffer.append("<");
        URelaxer.makeQName(prefix, "accounts", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.append(">");
        size = this.account_.size();
        for (int i = 0;i < size;i++) {
            RAccount value = (RAccount)this.account_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "accounts", buffer);
        buffer.append(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/account");
        buffer.write("<");
        URelaxer.makeQName(prefix, "accounts", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.write(">");
        size = this.account_.size();
        for (int i = 0;i < size;i++) {
            RAccount value = (RAccount)this.account_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "accounts", buffer);
        buffer.write(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/account");
        buffer.print("<");
        URelaxer.makeQName(prefix, "accounts", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.print(">");
        size = this.account_.size();
        for (int i = 0;i < size;i++) {
            RAccount value = (RAccount)this.account_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "accounts", buffer);
        buffer.print(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(StringBuffer buffer) {
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextAttribute(Writer buffer) throws IOException {
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(PrintWriter buffer) {
    }

    /**
     * Returns a String representation of this object.
     * While this method informs as XML format representaion, 
     *  it's purpose is just information, not making 
     * a rigid XML documentation.
     *
     * @return String
     */
    public String toString() {
        try {
            return (makeTextDocument());
        } catch (Exception e) {
            return (super.toString());
        }
    }

    /**
     * Gets the IRNode property <b>parentRNode</b>.
     *
     * @return IRNode
     */
    public final IRNode rGetParentRNode() {
        return (parentRNode_);
    }

    /**
     * Sets the IRNode property <b>parentRNode</b>.
     *
     * @param parentRNode
     */
    public final void rSetParentRNode(IRNode parentRNode) {
        this.parentRNode_ = parentRNode;
    }

    /**
     * Gets child RNodes.
     *
     * @return IRNode[]
     */
    public IRNode[] rGetRNodes() {
        java.util.List classNodes = new java.util.ArrayList();
        classNodes.addAll(account_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>RAccounts</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework/account", "accounts")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!RAccount.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!RAccount.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>RAccounts</code>.
     * This mehtod is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     * @return boolean
     */
    public static boolean isMatch(RStack stack) {
        Element element = stack.peekElement();
        if (element == null) {
            return (false);
        }
        return (isMatch(element));
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>RAccounts</code>.
     * This method consumes the stack contents during matching operation.
     * This mehtod is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     * @return boolean
     */
    public static boolean isMatchHungry(RStack stack) {
        Element element = stack.peekElement();
        if (element == null) {
            return (false);
        }
        if (isMatch(element)) {
            stack.popElement();
            return (true);
        } else {
            return (false);
        }
    }
}
