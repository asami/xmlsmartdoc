/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@relaxer.org)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.relaxer.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.relaxer.framework.logger.IRFrameworkLogger;

/**
 * IParameterParser
 *
 * @since   May.  3, 2003
 * @version Mar. 14, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractParameterParser implements IParameterParser {
    private String service_;
    private List params_ = new ArrayList();
    private Map properties_ = new HashMap();
    private List propertyKeys_ = new ArrayList();
    private Set consumedKeys_ = new HashSet();
    private Map frameworkProperties_ = new HashMap();
    private List frameworkPropertyKeys_ = new ArrayList();
    private Set consumedFrameworkKeys_ = new HashSet();

    public String getService() {
        return (service_);
    }

    public String[] getParameters() {
        String[] params = new String[params_.size()];
        return ((String[])params_.toArray(params));
    }

    public String[] getPropertyKeys() {
        String[] keys = new String[propertyKeys_.size()];
        return ((String[])propertyKeys_.toArray(keys));
    }

    public boolean isProperty(String key) {
        return (properties_.containsKey(key) &&
                !"false".equals(properties_.get(key)));
    }

    public String getProperty(String key) {
        consumedKeys_.add(key);
        return ((String)properties_.get(key));
    }
    
    public Entry[] getProperties() {
        return getProperties_(properties_);
    }

    public String[] getFrameworkPropertyKeys() {
        String[] keys = new String[propertyKeys_.size()];
        return ((String[])frameworkPropertyKeys_.toArray(keys));
    }

    public boolean isFrameworkProperty(String key) {
        return (frameworkProperties_.containsKey(key) &&
                !"false".equals(frameworkProperties_.get(key)));
    }

    public String getFrameworkProperty(String key) {
        consumedFrameworkKeys_.add(key);
        return ((String)frameworkProperties_.get(key));
    }

    protected Entry[] getFrameworkProperties() {
        return (getProperties_(frameworkProperties_));
    }

    private Entry[] getProperties_(Map properties) {
        Object[] mapEntries = properties.entrySet().toArray();
        Entry[] entries = new Entry[mapEntries.length];
        for (int i = 0;i < mapEntries.length;i++) {
            Map.Entry entry = (Map.Entry)mapEntries[i];
            entries[i] = new Entry(
                (String)entry.getKey(), 
                (String)entry.getValue()
            );
        }
        return (entries);
    }

    protected final void _setService(String service) {
        service_ = service;
    }

    protected final void _addParameter(String param) {
        params_.add(param);
    }

    protected final void _setProperty(String key, String value) {
        if (propertyKeys_.contains(key)) {
            throw (new IllegalArgumentException());
        }
        properties_.put(key, value);
        propertyKeys_.add(key);
    }
    
    protected final void _setProperties(Map properties) {
        properties_.putAll(properties);
    }

    protected final void _setFrameworkProperty(String key, String value) {
        if (frameworkPropertyKeys_.contains(key)) {
            throw (new IllegalArgumentException());
        }
        frameworkProperties_.put(key, value);
        frameworkPropertyKeys_.add(key);
    }
    
    protected final void _setFrameworkProperties(Map properties) {
        frameworkProperties_.putAll(properties);
    }

    public void logConfig(IRFrameworkLogger logger) {
    }
}
