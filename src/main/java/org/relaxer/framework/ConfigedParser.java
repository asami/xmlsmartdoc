/*
 * Created on 2004/09/07
 */
package org.relaxer.framework;

import org.relaxer.framework.logger.IRFrameworkLogger;
import org.relaxer.framework.rConfig.FCConfig;
import org.relaxer.framework.rConfig.FCSlot;
import org.relaxer.framework.rConfig.IFCSlotMixed;

/**
 * ConfigedParser
 *
 * @since   Sep.  7, 2004
 * @version Sep.  8, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ConfigedParser implements IParameterParser {
    private final FCConfig config_;
    private final IParameterParser parser_;

    public ConfigedParser(FCConfig config, IParameterParser parser) {
        config_ = config;
        parser_ = parser;
    }
    
    private String getConfigProperty_(String key) {
        FCSlot slot = config_.getSlotByName(key);
        if (slot == null) {
            return (null);
        }
        IFCSlotMixed content = slot.getContent();
        return (content.getContentAsString());
    }

    public boolean isFrameworkProperty(String key) {
        if (parser_.isFrameworkProperty(key)) {
            return (true);
        }
        return (getConfigProperty_(key) != null);
    }

    public String getFrameworkProperty(String key) {
        String value = parser_.getFrameworkProperty(key);
        if (value != null) {
            return (value);
        }
        value = getConfigProperty_(key);
        return (value);
    }

    public boolean isProperty(String key) {
        return (parser_.isProperty(key));
    }

    public String getProperty(String key) {
        return (parser_.getProperty(key));
    }

    public Entry[] getProperties() {
        return (parser_.getProperties());
    }

    public String getService() {
        return (parser_.getService());
    }

    public String[] getParameters() {
        return (parser_.getParameters());
    }

    public void logConfig(IRFrameworkLogger logger) {
        parser_.logConfig(logger);
    }
}
