/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.jdbc;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.relaxer.framework.jdbc.rModel.JmJdbcModel;
import org.relaxer.framework.jdbc.rModel.JmXmlDatatype;
import org.relaxer.framework.runtime.IJdbcConfig;
import org.xml.sax.SAXException;

/**
 * JdbcConfig
 *
 * @since   2004/03/10
 * @version 2004/03/10
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class JdbcConfig implements IJdbcConfig {
    private JmJdbcModel config_;
    private JmJdbcModel profile_;

    public JdbcConfig(String configName, String profileName) 
      throws IOException, SAXException, ParserConfigurationException {
        config_ = getModel_(configName);
        profile_ = getModel_(profileName);
    }

    private JmJdbcModel getModel_(String modelName) 
      throws IOException, SAXException, ParserConfigurationException {
        if (modelName == null) {
            return (null);
        }
        URL url = getClass().getResource(
            "/org/relaxer/framework/jdbc/lib/" + modelName + ".xml"
        );
        if (url == null) {
            return (null);
        }
        return (new JmJdbcModel(url));
    }

    public String getQuoteId() {
        return (config_.getQuoteId());
    }

    public String getQuoteWhere() {
        return (config_.getQuoteWhere());
    }

    public String getQuoteIdInWhere() {
        return (config_.getQuoteIdInWhere());
    }

    public Map getTypeMappings() {
        Map map = new HashMap();
        JmXmlDatatype[] datatypes = config_.getXmlDatatype();
        for (int i = 0;i < datatypes.length;i++) {
            JmXmlDatatype datatype = datatypes[i];
            map.put(datatype.getName(), datatype.getSql());
        }
        return (map);
    }
}
