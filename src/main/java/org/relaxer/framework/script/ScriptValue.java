/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.relaxer.framework.datatype.DatatypeFactory;
import org.relaxer.framework.datatype.IDatatype;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * ScriptValue
 *
 * @since   Jan.  9, 2004
 * @version Feb. 13, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptValue {
    private IDatatype datatype_;
    private List objects_ = null;
    private List texts_ = null;
    private List xmls_ = null;

    public ScriptValue() {
        datatype_ = DatatypeFactory.getStringDatatype();
    }

    public ScriptValue(Object object) {
        if (object == null) {
            throw (new IllegalArgumentException("null object"));
        }
        datatype_ = DatatypeFactory.getStringDatatype();
        objects_ = new ArrayList();
        objects_.add(object);
        assertInvariants_();
    }

    public ScriptValue(Object[] objects) {
        datatype_ = DatatypeFactory.getStringDatatype();
        objects_ = new ArrayList();
        objects_.addAll(Arrays.asList(objects));
        assertInvariants_();
    }

    public ScriptValue(Object object, IDatatype datatype) {
        datatype_ = datatype;
        objects_ = new ArrayList();
        objects_.add(object);
        assertInvariants_();
    }

    public ScriptValue(Object[] objects, IDatatype datatype) {
        datatype_ = datatype;
        objects_ = new ArrayList();
        objects_.addAll(Arrays.asList(objects));
        assertInvariants_();
    }

    public ScriptValue(String text, IDatatype datatype) {
        datatype_ = datatype;
        texts_ = new ArrayList();
        texts_.add(text);
        assertInvariants_();
    }

    public ScriptValue(String[] texts, IDatatype datatype) {
        datatype_ = datatype;
        texts_ = new ArrayList();
        texts_.addAll(Arrays.asList(texts));
        assertInvariants_();
    }

    public ScriptValue(Node xml, IDatatype datatype) {
        datatype_ = datatype;
        xmls_ = new ArrayList();
        xmls_.add(xml);
        assertInvariants_();
    }

    public ScriptValue(Node[] xmls, IDatatype datatype) {
        datatype_ = datatype;
        xmls_ = new ArrayList();
        xmls_.addAll(Arrays.asList(xmls));
    }

    public Object[] getObjects() {
        syncObjects_();
        return (objects_.toArray());
    }

    public Object getObject() {
        syncObjects_();
        if (objects_.isEmpty()) {
            return (null);
        } else {
            return (objects_.get(0));
        }
    }

    public String[] getTexts() {
        syncTexts_();
        String[] result = new String[texts_.size()];
        return ((String[])texts_.toArray(result));
    }

    public String getText() {
        syncTexts_();
        if (texts_.isEmpty()) {
            return (null);
        } else {
            return ((String)texts_.get(0));
        }
    }

    public Node[] getXmls(Document factory) {
        syncXmls_(factory);
        Node[] result = new Node[xmls_.size()];
        return ((Node[])xmls_.toArray(result));
    }

    public Node getXml(Document factory) {
        syncXmls_(factory);
        if (xmls_.isEmpty()) {
            return (null);
        } else {
            return ((Node)xmls_.get(0));
        }
    }

    public Node[] checkXmls() {
        if (xmls_ != null) {
            Node[] result = new Node[xmls_.size()];
            return ((Node[])xmls_.toArray(result));
        } else {
            return (null);
        }
    }

    public Node checkXml() {
        if (xmls_ != null) {
            if (xmls_.isEmpty()) {
                return (null);
            } else {
                return ((Node)xmls_.get(0));
            }
        } else {
            return (null);
        }
    }

    private void syncObjects_() {
        assertInvariants_();
        if (objects_ != null) {
            return;
        }
        if (xmls_ != null) {
            objects_ = new ArrayList();
            Object[] array = xmls_.toArray();
            for (int i = 0; i < array.length; i++) {
                Node node = (Node)array[i];
                objects_.add(datatype_.getObjectByXml(node));
            }
        } else if (texts_ != null) {
            objects_ = new ArrayList();
            Object[] array = texts_.toArray();
            for (int i = 0; i < array.length; i++) {
                String text = (String)array[i];
                objects_.add(datatype_.getObjectByText(text));
            }
        }
        assertInvariants_();
    }

    private void syncTexts_() {
        assertInvariants_();
        if (texts_ != null) {
            return;
        }
        if (objects_ != null) {
            texts_ = new ArrayList();
            Object[] array = objects_.toArray();
            for (int i = 0; i < array.length; i++) {
                Object object = array[i];
                texts_.add(datatype_.getTextByObject(object));
            }
        } else if (xmls_ != null) {
            texts_ = new ArrayList();
            Object[] array = xmls_.toArray();
            for (int i = 0; i < array.length; i++) {
                Node node = (Node)array[i];
                texts_.add(datatype_.getTextByXml(node));
            }
        }
        assertInvariants_();
    }

    private void syncXmls_(Document factory) {
        assertInvariants_();
        if (xmls_ != null) {
            return;
        }
        if (objects_ != null) {
            xmls_ = new ArrayList();
            Object[] array = objects_.toArray();
            for (int i = 0; i < array.length; i++) {
                Object object = (Object)array[i];
                texts_.add(datatype_.getXmlByObject(object, factory));
            }
        } else if (texts_ != null) {
            xmls_ = new ArrayList();
            Object[] array = texts_.toArray();
            for (int i = 0; i < array.length; i++) {
                String text = (String)array[i];
                xmls_.add(datatype_.getXmlByText(text, factory));
            }
        }
        assertInvariants_();
    }

    public ScriptValue makePopedData() throws ScriptException {
        assertInvariants_();
        ScriptValue newData;
        newData = new ScriptValue();
        newData.datatype_ = datatype_;
        if (objects_ != null) {
            if (objects_.size() == 0) {
                throw (new ScriptException("Poped from empty data."));
            }
            newData.objects_ = new ArrayList(objects_);
            newData.objects_.remove(0);
        }
        if (texts_ != null) {
            if (texts_.size() == 0) {
                throw (new ScriptException("Poped from empty data."));
            }
            newData.texts_ = new ArrayList(texts_);
            newData.texts_.remove(0);
        }
        if (xmls_ != null) {
            if (xmls_.size() == 0) {
                throw (new ScriptException("Poped from empty data."));
            }
            newData.xmls_ = new ArrayList(xmls_);
            newData.xmls_.remove(0);
        }
        newData.assertInvariants_();
        return (newData);
    }

    private void assertInvariants_() {
        if (objects_ != null) {
            int size = objects_.size();
            if (texts_ != null){
                if (texts_.size() != size) {
                    throw (new InternalError());
                }
            }
            if (xmls_ != null) {
                if (xmls_.size() != size) {
                    throw (new InternalError());
                }
            }
        } else if (texts_ != null) {
            if (xmls_ != null) {
                if (xmls_.size() != texts_.size()) {
                    throw (new InternalError());
                }
            }
        } else if (xmls_ != null) {
            // do nothing
        } else {
            throw (new InternalError());
        }
/*
        if (values_ != null && values_.isEmpty()) {
            throw (new InternalError());
        }
        if (texts_ != null && texts_.isEmpty()) {
            throw (new InternalError());
        }
        if (xmls_ != null && xmls_.isEmpty()) {
            throw (new InternalError());
        }
*/
    }

    public IDatatype getDatatype() {
        return (datatype_);
    }
}
