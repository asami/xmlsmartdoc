/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.datatype;

import java.util.HashMap;
import java.util.Map;

import org.relaxer.framework.*;
import org.relaxer.framework.RelaxerFramework;

/**
 * DatatypeFactory
 *
 * @since   Jan.  1, 2004
 * @version Feb. 23, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class DatatypeFactory {
    private static final String LIST_PREFIX = "list.";

    private static DatatypeFactory factory__;
    private static IDatatype stringDatatype__;

    public static DatatypeFactory getFactory() {
        return (factory__);
    }
    
    public static void setFactory(DatatypeFactory factory) {
        factory__ = factory;
    }

    public static IDatatype getStringDatatype() {
        if (stringDatatype__ == null) {
            stringDatatype__ = new StringDatatype();
        }
        return (stringDatatype__);
    }

    private RelaxerFramework framework_;
    private Map datatypes_ = new HashMap();

    public DatatypeFactory(RelaxerFramework framework) {
        if (framework == null) {
            throw (new IllegalArgumentException());
        }
        framework_ = framework;
        IDatatype stringType = getStringDatatype(); 
        addDatatype(stringType);
        addDatatype("String", stringType);
        addDatatype("java.lang.String", stringType);
        IDatatype booleanType = new BooleanDatatype(); 
        addDatatype(booleanType);
        addDatatype("Boolean", booleanType);
        addDatatype("java.lang.Boolean", booleanType);
        IDatatype byteType = new ByteDatatype(); 
        addDatatype(byteType);
        addDatatype("Byte", byteType);
        addDatatype("java.lang.Byte", byteType);
        IDatatype shortType = new ShortDatatype(); 
        addDatatype(shortType);
        addDatatype("short", shortType);
        addDatatype("java.lang.Short", shortType);
        IDatatype intType = new IntDatatype(); 
        addDatatype(intType);
        addDatatype("Integer", intType);
        addDatatype("java.lang.Integer", intType);
        IDatatype longType = new LongDatatype(); 
        addDatatype(longType);
        addDatatype("Long", longType);
        addDatatype("java.lang.Long", longType);
        IDatatype floatType = new FloatDatatype(); 
        addDatatype(floatType);
        addDatatype("Float", floatType);
        addDatatype("java.lang.Float", floatType);
        IDatatype doubleType = new DoubleDatatype();
        addDatatype(doubleType);
        addDatatype("Double", doubleType);
        addDatatype("java.lang.Double", doubleType);
        IDatatype parcelType = new ParcelDatatype(); 
        addDatatype(parcelType);
        addDatatype("parcel", parcelType);
    }

    public IDatatype getDatatype(String name) throws ClassNotFoundException {
        IDatatype datatype = (IDatatype)datatypes_.get(name);
        if (datatype != null) {
            return (datatype);
        }
        Class type = framework_.getJavaClass(name);
        datatype = new RelaxerObjectDatatype(name, type);
        addDatatype(datatype);
        return (datatype);
    }

    public IDatatype getListDatatype(String name) {
        return ((IDatatype)datatypes_.get(LIST_PREFIX + name));
    }

    public IDatatype getDatatypeByObject(Object object) {
        Class source = object.getClass();
        Object[] datatypes = datatypes_.values().toArray();
        for (int i = 0; i < datatypes.length; i++) {
            IDatatype datatype = (IDatatype)datatypes[i];
            Class target = datatype.getJavaClass();
            if (source.equals(target)) {
                return (datatype);
            }
        }
        try {
            return (getDatatype("string"));
        } catch (ClassNotFoundException e) {
            throw (new RelaxerFrameworkErrorException());
        }
    }

    public void addDatatype(IDatatype datatype) {
        addDatatype(datatype.getName(), datatype);
    }
    
    public void addDatatype(String name, IDatatype datatype) {
        datatypes_.put(name, datatype);
        ListDatatype listDatatype 
            = new ListDatatype(LIST_PREFIX + name, datatype);
        datatypes_.put(listDatatype.getName(), listDatatype);
    }
}
