/*
 * org.xmlsmartdoc.goldenport
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
package org.xmlsmartdoc.goldenport.engine;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlsmartdoc.goldenport.GoldenportContext;
import org.xmlsmartdoc.goldenport.adapter.IAdapter;
import org.xmlsmartdoc.goldenport.converter.IConverter;
import org.xmlsmartdoc.goldenport.filter.IFilter;
import org.xmlsmartdoc.goldenport.normalizer.INormalizer;
import org.xmlsmartdoc.goldenport.config.GcAdapter;
import org.xmlsmartdoc.goldenport.config.GcFilter;
import org.xmlsmartdoc.goldenport.config.GcGoldenportConfig;
import org.xmlsmartdoc.goldenport.config.GcNormalizer;
import org.xmlsmartdoc.goldenport.config.GcProperty;
import org.xmlsmartdoc.goldenport.config.GcSelecter;
import org.xmlsmartdoc.goldenport.selecter.ISelecter;
import org.xmlsmartdoc.goldenport.selecters.AllSelecter;
import org.xmlsmartdoc.goldenport.selecters.ElementNameSelecter;
import org.xmlsmartdoc.goldenport.selecters.OrSelecter;

/**
 * PortConfig
 *
 * @since   Apr.  7, 2004
 * @version Apr. 12, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class PortConfig {
    private GoldenportContext context_;
    private List systemFilters_ = new ArrayList();
    private List systemAdapters_ = new ArrayList();
    private List systemMacros_ = new ArrayList();
    private List systemNormalizers_ = new ArrayList();
    private List systemConvertors_ = new ArrayList();
    private List userFilters_ = new ArrayList();
    private List userAdapters_ = new ArrayList();
    private List userMacros_ = new ArrayList();
    private List userNormalizers_ = new ArrayList();
    private List userConvertors_ = new ArrayList();

    public PortConfig(GoldenportContext context) {
        context_ = context;
    }

    public void setSystemConfig(GcGoldenportConfig config) 
      throws GoldenportException {
        if (config == null) {
            return;
        }
        try {
            GcFilter[] filters = config.getFilter();
            for (int i = 0;i < filters.length;i++) {
                GcFilter filter = filters[i];
                systemFilters_.add(makeFilter_(filter));
            }
            GcAdapter[] adapters = config.getAdapter();
            for (int i = 0;i < adapters.length;i++) {
                GcAdapter adapter = adapters[i];
                systemAdapters_.add(makeAdapter_(adapter));
            }
            GcNormalizer[] normalizers = config.getNormalizer();
            for (int i = 0;i < normalizers.length;i++) {
                GcNormalizer normalizer = normalizers[i];
                systemNormalizers_.add(makeNormalizer_(normalizer));
            }
            // TODO converters
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
    }

    public void setUserConfig(GcGoldenportConfig config) 
      throws GoldenportException {
        if (config == null) {
            return;
        }
        try {
            GcFilter[] filters = config.getFilter();
            for (int i = 0;i < filters.length;i++) {
                GcFilter filter = filters[i];
                userFilters_.add(makeFilter_(filter));
            }
            GcAdapter[] adapters = config.getAdapter();
            for (int i = 0;i < adapters.length;i++) {
                GcAdapter adapter = adapters[i];
                userAdapters_.add(makeAdapter_(adapter));
            }
            GcNormalizer[] normalizers = config.getNormalizer();
            for (int i = 0;i < normalizers.length;i++) {
                GcNormalizer normalizer = normalizers[i];
                userNormalizers_.add(makeNormalizer_(normalizer));
            }
            // TODO converters
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
    }

    private IFilter makeFilter_(GcFilter gcFilter) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        IPort port = (IFilter)makePort_(
            gcFilter.getName(),
            gcFilter.getJavaClass(),
            gcFilter.getSelecter(),
            gcFilter.getProperty(),
            gcFilter.rGetElement()
        );
        if (!(port instanceof IFilter)) {                         
            // TODO
        }
        return ((IFilter)port);
    }

    private IAdapter makeAdapter_(GcAdapter gcAdapter) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        IPort port = (IAdapter)makePort_(
            gcAdapter.getName(),
            gcAdapter.getJavaClass(),
            gcAdapter.getSelecter(),
            gcAdapter.getProperty(),
            gcAdapter.rGetElement()
        );
        if (!(port instanceof IAdapter)) {                         
            // TODO
        }
        return ((IAdapter)port);
    }

    private INormalizer makeNormalizer_(GcNormalizer gcNormalizer) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        IPort port = (INormalizer)makePort_(
            gcNormalizer.getName(),
            gcNormalizer.getJavaClass(),
            gcNormalizer.getSelecter(),
            gcNormalizer.getProperty(),
            gcNormalizer.rGetElement()
        );
        if (!(port instanceof INormalizer)) {                         
            // TODO
        }
        return ((INormalizer)port);
    }

    private IPort makePort_(
        String name, 
        String javaClass, 
        GcSelecter[] selecters, 
        GcProperty[] properties,
        Element element
    ) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = context_.getClassLoader().loadClass(javaClass);
        Object object = clazz.newInstance();
        if (!(object instanceof IPort)) {
            // TODO
        }
        IPort port = (IPort)object;
        if (selecters == null || selecters.length == 0) {
            if (port.getSelecter() == null) {
                port.setSelecter(AllSelecter.getSingleton());
            }
        } else {
            port.setSelecter(makeSelecter_(selecters));
        }
        for (int i = 0;i < properties.length;i++) {
            GcProperty property = properties[i];
            port.setProperty(property.getName(), property.getValue());
        }
        port.setup(element);
        return (port);
    }

    private ISelecter makeSelecter_(GcSelecter[] selecters) {
        ISelecter[] result = new ISelecter[selecters.length];
        for (int i = 0;i < selecters.length;i++) {
            result[i] = makeSelecter_(selecters[i]);
        }
        if (selecters.length == 1) {
            return (result[0]);
        } else {
            return (new OrSelecter(result));
        }
    }

    private ISelecter makeSelecter_(GcSelecter selecter) {
        String name = selecter.getName();
        String ns = selecter.getNamespace();
        return (new ElementNameSelecter(ns, name));
    }

    public void addSystemMacro(Document macro) {
        systemMacros_.add(macro);
    }

    public void addUserMacro(Document macro) {
        userMacros_.add(macro);
    }

    public IFilter[] getSystemFilters() {
        IFilter[] result = new IFilter[systemFilters_.size()];
        return ((IFilter[])systemFilters_.toArray(result));
    }
    
    public IAdapter[] getSystemAdapters() {
        IAdapter[] result = new IAdapter[systemAdapters_.size()];
        return ((IAdapter[])systemAdapters_.toArray(result));
    }
    
    public INormalizer[] getSystemNormalizers() {
        INormalizer[] result = new INormalizer[systemNormalizers_.size()];
        return ((INormalizer[])systemNormalizers_.toArray(result));
    }

    public IConverter[] getSystemConverters() {
        IConverter[] result = new IConverter[systemConvertors_.size()];
        return ((IConverter[])systemConvertors_.toArray(result));
    }

    public IFilter[] getUserFilters() {
        IFilter[] result = new IFilter[userFilters_.size()];
        return ((IFilter[])userFilters_.toArray(result));
    }
    
    public IAdapter[] getUserAdapters() {
        IAdapter[] result = new IAdapter[userAdapters_.size()];
        return ((IAdapter[])userAdapters_.toArray(result));
    }
    
    public INormalizer[] getUserNormalizers() {
        INormalizer[] result = new INormalizer[userNormalizers_.size()];
        return ((INormalizer[])userNormalizers_.toArray(result));
    }

    public IConverter[] getUserConverters() {
        IConverter[] result = new IConverter[userConvertors_.size()];
        return ((IConverter[])userConvertors_.toArray(result));
    }

    public Node[] getMacros() {
        List list = new ArrayList();
        
        Node[] result = new Node[list.size()];
        return ((Node[])list.toArray(result));
    }
}
