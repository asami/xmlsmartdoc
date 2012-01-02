/*
 * The Relaxer artifact
 * Copyright (c) 2000-2004, ASAMI Tomoharu, All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer. 
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.xmlsmartdoc.goldenport.config;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import org.xmlsmartdoc.goldenport.lib.*;

/**
 * <b>GcGoldenportConfig</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="goldenport-config">
 *       <zeroOrMore>
 *         <ref name="filter"/>
 *       </zeroOrMore>
 *       <zeroOrMore>
 *         <ref name="adapter"/>
 *       </zeroOrMore>
 *       <zeroOrMore>
 *         <ref name="normalizer"/>
 *       </zeroOrMore>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="goldenport-config"&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="filter"/&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="adapter"/&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="normalizer"/&gt;
 *       &lt;/zeroOrMore&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Fri Jul 29 11:55:13 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class GcGoldenportConfig implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.xmlsmartdoc.org/xmlns/goldenport");
    // List<GcFilter>
    private java.util.List filter_ = new java.util.ArrayList();
    // List<GcAdapter>
    private java.util.List adapter_ = new java.util.ArrayList();
    // List<GcNormalizer>
    private java.util.List normalizer_ = new java.util.ArrayList();
    private Element xmlElement;
    private IRNode parentRNode_;

    /**
     * Creates a <code>GcGoldenportConfig</code>.
     *
     */
    public GcGoldenportConfig() {
    }

    /**
     * Creates a <code>GcGoldenportConfig</code>.
     *
     * @param source
     */
    public GcGoldenportConfig(GcGoldenportConfig source) {
        setup(source);
    }

    /**
     * Creates a <code>GcGoldenportConfig</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public GcGoldenportConfig(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>GcGoldenportConfig</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public GcGoldenportConfig(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>GcGoldenportConfig</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public GcGoldenportConfig(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>GcGoldenportConfig</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcGoldenportConfig(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>GcGoldenportConfig</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcGoldenportConfig(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>GcGoldenportConfig</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcGoldenportConfig(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>GcGoldenportConfig</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcGoldenportConfig(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>GcGoldenportConfig</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcGoldenportConfig(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>GcGoldenportConfig</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcGoldenportConfig(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>GcGoldenportConfig</code> by the GcGoldenportConfig <code>source</code>.
     *
     * @param source
     */
    public void setup(GcGoldenportConfig source) {
        int size;
        this.filter_.clear();
        size = source.filter_.size();
        for (int i = 0;i < size;i++) {
            addFilter((GcFilter)source.getFilter(i).clone());
        }
        this.adapter_.clear();
        size = source.adapter_.size();
        for (int i = 0;i < size;i++) {
            addAdapter((GcAdapter)source.getAdapter(i).clone());
        }
        this.normalizer_.clear();
        size = source.normalizer_.size();
        for (int i = 0;i < size;i++) {
            addNormalizer((GcNormalizer)source.getNormalizer(i).clone());
        }
    }

    /**
     * Initializes the <code>GcGoldenportConfig</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>GcGoldenportConfig</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>GcGoldenportConfig</code> by the Stack <code>stack</code>
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
        filter_.clear();
        while (true) {
            if (GcFilter.isMatch(stack)) {
                addFilter(new GcFilter(stack));
            } else {
                break;
            }
        }
        adapter_.clear();
        while (true) {
            if (GcAdapter.isMatch(stack)) {
                addAdapter(new GcAdapter(stack));
            } else {
                break;
            }
        }
        normalizer_.clear();
        while (true) {
            if (GcNormalizer.isMatch(stack)) {
                addNormalizer(new GcNormalizer(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new GcGoldenportConfig((GcGoldenportConfig)this));
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
        Element element = doc.createElementNS("http://www.xmlsmartdoc.org/xmlns/goldenport", "goldenport-config");
        rNSContext_.setupNamespace(element);
        int size;
        size = this.filter_.size();
        for (int i = 0;i < size;i++) {
            GcFilter value = (GcFilter)this.filter_.get(i);
            value.makeElement(element);
        }
        size = this.adapter_.size();
        for (int i = 0;i < size;i++) {
            GcAdapter value = (GcAdapter)this.adapter_.get(i);
            value.makeElement(element);
        }
        size = this.normalizer_.size();
        for (int i = 0;i < size;i++) {
            GcNormalizer value = (GcNormalizer)this.normalizer_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>GcGoldenportConfig</code> by the File <code>file</code>.
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
     * Initializes the <code>GcGoldenportConfig</code>
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
     * Initializes the <code>GcGoldenportConfig</code> by the URL <code>url</code>.
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
     * Initializes the <code>GcGoldenportConfig</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>GcGoldenportConfig</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>GcGoldenportConfig</code> by the Reader <code>reader</code>.
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
    public RNSContext rGetRNSContext() {
        return (rNSContext_);
    }

    /**
     * Sets the RNSContext property <b>RNSContext</b>.
     *
     * @param rNSContext
     */
    public void rSetRNSContext(RNSContext rNSContext) {
        this.rNSContext_ = rNSContext;
    }

    /**
     * Gets the GcFilter property <b>filter</b>.
     *
     * @return GcFilter[]
     */
    public GcFilter[] getFilter() {
        GcFilter[] array = new GcFilter[filter_.size()];
        return ((GcFilter[])filter_.toArray(array));
    }

    /**
     * Sets the GcFilter property <b>filter</b>.
     *
     * @param filter
     */
    public void setFilter(GcFilter[] filter) {
        this.filter_.clear();
        for (int i = 0;i < filter.length;i++) {
            addFilter(filter[i]);
        }
        for (int i = 0;i < filter.length;i++) {
            filter[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the GcFilter property <b>filter</b>.
     *
     * @param filter
     */
    public void setFilter(GcFilter filter) {
        this.filter_.clear();
        addFilter(filter);
        if (filter != null) {
            filter.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcFilter property <b>filter</b>.
     *
     * @param filter
     */
    public void addFilter(GcFilter filter) {
        this.filter_.add(filter);
        if (filter != null) {
            filter.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcFilter property <b>filter</b>.
     *
     * @param filter
     */
    public void addFilter(GcFilter[] filter) {
        for (int i = 0;i < filter.length;i++) {
            addFilter(filter[i]);
        }
        for (int i = 0;i < filter.length;i++) {
            filter[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the GcFilter property <b>filter</b>.
     *
     * @return int
     */
    public int sizeFilter() {
        return (filter_.size());
    }

    /**
     * Gets the GcFilter property <b>filter</b> by index.
     *
     * @param index
     * @return GcFilter
     */
    public GcFilter getFilter(int index) {
        return ((GcFilter)filter_.get(index));
    }

    /**
     * Sets the GcFilter property <b>filter</b> by index.
     *
     * @param index
     * @param filter
     */
    public void setFilter(int index, GcFilter filter) {
        this.filter_.set(index, filter);
        if (filter != null) {
            filter.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcFilter property <b>filter</b> by index.
     *
     * @param index
     * @param filter
     */
    public void addFilter(int index, GcFilter filter) {
        this.filter_.add(index, filter);
        if (filter != null) {
            filter.rSetParentRNode(this);
        }
    }

    /**
     * Remove the GcFilter property <b>filter</b> by index.
     *
     * @param index
     */
    public void removeFilter(int index) {
        this.filter_.remove(index);
    }

    /**
     * Remove the GcFilter property <b>filter</b> by object.
     *
     * @param filter
     */
    public void removeFilter(GcFilter filter) {
        this.filter_.remove(filter);
    }

    /**
     * Clear the GcFilter property <b>filter</b>.
     *
     */
    public void clearFilter() {
        this.filter_.clear();
    }

    /**
     * Gets the GcAdapter property <b>adapter</b>.
     *
     * @return GcAdapter[]
     */
    public GcAdapter[] getAdapter() {
        GcAdapter[] array = new GcAdapter[adapter_.size()];
        return ((GcAdapter[])adapter_.toArray(array));
    }

    /**
     * Sets the GcAdapter property <b>adapter</b>.
     *
     * @param adapter
     */
    public void setAdapter(GcAdapter[] adapter) {
        this.adapter_.clear();
        for (int i = 0;i < adapter.length;i++) {
            addAdapter(adapter[i]);
        }
        for (int i = 0;i < adapter.length;i++) {
            adapter[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the GcAdapter property <b>adapter</b>.
     *
     * @param adapter
     */
    public void setAdapter(GcAdapter adapter) {
        this.adapter_.clear();
        addAdapter(adapter);
        if (adapter != null) {
            adapter.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcAdapter property <b>adapter</b>.
     *
     * @param adapter
     */
    public void addAdapter(GcAdapter adapter) {
        this.adapter_.add(adapter);
        if (adapter != null) {
            adapter.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcAdapter property <b>adapter</b>.
     *
     * @param adapter
     */
    public void addAdapter(GcAdapter[] adapter) {
        for (int i = 0;i < adapter.length;i++) {
            addAdapter(adapter[i]);
        }
        for (int i = 0;i < adapter.length;i++) {
            adapter[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the GcAdapter property <b>adapter</b>.
     *
     * @return int
     */
    public int sizeAdapter() {
        return (adapter_.size());
    }

    /**
     * Gets the GcAdapter property <b>adapter</b> by index.
     *
     * @param index
     * @return GcAdapter
     */
    public GcAdapter getAdapter(int index) {
        return ((GcAdapter)adapter_.get(index));
    }

    /**
     * Sets the GcAdapter property <b>adapter</b> by index.
     *
     * @param index
     * @param adapter
     */
    public void setAdapter(int index, GcAdapter adapter) {
        this.adapter_.set(index, adapter);
        if (adapter != null) {
            adapter.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcAdapter property <b>adapter</b> by index.
     *
     * @param index
     * @param adapter
     */
    public void addAdapter(int index, GcAdapter adapter) {
        this.adapter_.add(index, adapter);
        if (adapter != null) {
            adapter.rSetParentRNode(this);
        }
    }

    /**
     * Remove the GcAdapter property <b>adapter</b> by index.
     *
     * @param index
     */
    public void removeAdapter(int index) {
        this.adapter_.remove(index);
    }

    /**
     * Remove the GcAdapter property <b>adapter</b> by object.
     *
     * @param adapter
     */
    public void removeAdapter(GcAdapter adapter) {
        this.adapter_.remove(adapter);
    }

    /**
     * Clear the GcAdapter property <b>adapter</b>.
     *
     */
    public void clearAdapter() {
        this.adapter_.clear();
    }

    /**
     * Gets the GcNormalizer property <b>normalizer</b>.
     *
     * @return GcNormalizer[]
     */
    public GcNormalizer[] getNormalizer() {
        GcNormalizer[] array = new GcNormalizer[normalizer_.size()];
        return ((GcNormalizer[])normalizer_.toArray(array));
    }

    /**
     * Sets the GcNormalizer property <b>normalizer</b>.
     *
     * @param normalizer
     */
    public void setNormalizer(GcNormalizer[] normalizer) {
        this.normalizer_.clear();
        for (int i = 0;i < normalizer.length;i++) {
            addNormalizer(normalizer[i]);
        }
        for (int i = 0;i < normalizer.length;i++) {
            normalizer[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the GcNormalizer property <b>normalizer</b>.
     *
     * @param normalizer
     */
    public void setNormalizer(GcNormalizer normalizer) {
        this.normalizer_.clear();
        addNormalizer(normalizer);
        if (normalizer != null) {
            normalizer.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcNormalizer property <b>normalizer</b>.
     *
     * @param normalizer
     */
    public void addNormalizer(GcNormalizer normalizer) {
        this.normalizer_.add(normalizer);
        if (normalizer != null) {
            normalizer.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcNormalizer property <b>normalizer</b>.
     *
     * @param normalizer
     */
    public void addNormalizer(GcNormalizer[] normalizer) {
        for (int i = 0;i < normalizer.length;i++) {
            addNormalizer(normalizer[i]);
        }
        for (int i = 0;i < normalizer.length;i++) {
            normalizer[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the GcNormalizer property <b>normalizer</b>.
     *
     * @return int
     */
    public int sizeNormalizer() {
        return (normalizer_.size());
    }

    /**
     * Gets the GcNormalizer property <b>normalizer</b> by index.
     *
     * @param index
     * @return GcNormalizer
     */
    public GcNormalizer getNormalizer(int index) {
        return ((GcNormalizer)normalizer_.get(index));
    }

    /**
     * Sets the GcNormalizer property <b>normalizer</b> by index.
     *
     * @param index
     * @param normalizer
     */
    public void setNormalizer(int index, GcNormalizer normalizer) {
        this.normalizer_.set(index, normalizer);
        if (normalizer != null) {
            normalizer.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcNormalizer property <b>normalizer</b> by index.
     *
     * @param index
     * @param normalizer
     */
    public void addNormalizer(int index, GcNormalizer normalizer) {
        this.normalizer_.add(index, normalizer);
        if (normalizer != null) {
            normalizer.rSetParentRNode(this);
        }
    }

    /**
     * Remove the GcNormalizer property <b>normalizer</b> by index.
     *
     * @param index
     */
    public void removeNormalizer(int index) {
        this.normalizer_.remove(index);
    }

    /**
     * Remove the GcNormalizer property <b>normalizer</b> by object.
     *
     * @param normalizer
     */
    public void removeNormalizer(GcNormalizer normalizer) {
        this.normalizer_.remove(normalizer);
    }

    /**
     * Clear the GcNormalizer property <b>normalizer</b>.
     *
     */
    public void clearNormalizer() {
        this.normalizer_.clear();
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
        String prefix = rNSContext_.getPrefixByUri("http://www.xmlsmartdoc.org/xmlns/goldenport");
        buffer.append("<");
        URelaxer.makeQName(prefix, "goldenport-config", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.append(">");
        size = this.filter_.size();
        for (int i = 0;i < size;i++) {
            GcFilter value = (GcFilter)this.filter_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.adapter_.size();
        for (int i = 0;i < size;i++) {
            GcAdapter value = (GcAdapter)this.adapter_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.normalizer_.size();
        for (int i = 0;i < size;i++) {
            GcNormalizer value = (GcNormalizer)this.normalizer_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "goldenport-config", buffer);
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
        String prefix = rNSContext_.getPrefixByUri("http://www.xmlsmartdoc.org/xmlns/goldenport");
        buffer.write("<");
        URelaxer.makeQName(prefix, "goldenport-config", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.write(">");
        size = this.filter_.size();
        for (int i = 0;i < size;i++) {
            GcFilter value = (GcFilter)this.filter_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.adapter_.size();
        for (int i = 0;i < size;i++) {
            GcAdapter value = (GcAdapter)this.adapter_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.normalizer_.size();
        for (int i = 0;i < size;i++) {
            GcNormalizer value = (GcNormalizer)this.normalizer_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "goldenport-config", buffer);
        buffer.write(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("http://www.xmlsmartdoc.org/xmlns/goldenport");
        buffer.print("<");
        URelaxer.makeQName(prefix, "goldenport-config", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.print(">");
        size = this.filter_.size();
        for (int i = 0;i < size;i++) {
            GcFilter value = (GcFilter)this.filter_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.adapter_.size();
        for (int i = 0;i < size;i++) {
            GcAdapter value = (GcAdapter)this.adapter_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.normalizer_.size();
        for (int i = 0;i < size;i++) {
            GcNormalizer value = (GcNormalizer)this.normalizer_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "goldenport-config", buffer);
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
    public IRNode rGetParentRNode() {
        return (parentRNode_);
    }

    /**
     * Sets the IRNode property <b>parentRNode</b>.
     *
     * @param parentRNode
     */
    public void rSetParentRNode(IRNode parentRNode) {
        this.parentRNode_ = parentRNode;
    }

    /**
     * Gets child RNodes.
     *
     * @return IRNode[]
     */
    public IRNode[] rGetRNodes() {
        java.util.List classNodes = new java.util.ArrayList();
        classNodes.addAll(filter_);
        classNodes.addAll(adapter_);
        classNodes.addAll(normalizer_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>GcGoldenportConfig</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.xmlsmartdoc.org/xmlns/goldenport", "goldenport-config")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        while (true) {
            if (!GcFilter.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (!GcAdapter.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (!GcNormalizer.isMatchHungry(target)) {
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
     * is valid for the <code>GcGoldenportConfig</code>.
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
     * is valid for the <code>GcGoldenportConfig</code>.
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
