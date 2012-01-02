package com.AsamiOffice.text;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * I18nText
 *
 * @since   Aug. 29, 2005
 * @version Aug. 29, 2005
 * @author  ASAMI, Tomoharu (asami@AsamOffice.com)
 */
public class I18nText {
    private final String message_;
    private final Object[] params_;

    public I18nText(String message) {
        message_ = message;
        params_ = new Object[0];
    }

    public I18nText(String message, Object param) {
        message_ = message;
        params_ = new Object[] { param };
    }

    public I18nText(String message, Object param1, Object param2) {
        message_ = message;
        params_ = new Object[] { param1, param2 };
    }

    public I18nText(String message, Object param1, Object param2, Object param3) {
        message_ = message;
        params_ = new Object[] { param1, param2, param3 };
    }

    public I18nText(String message, Object[] params) {
        message_ = message;
        params_ = params;
    }
    
    public String getMessage() {
        return message_;
    }
    
    public Object[] getParams() {
        return params_;
    }

    public String getString(ResourceBundle resource) {
        String message = resource.getString(message_);
        MessageFormat formatter = new MessageFormat(message, resource.getLocale());
        return formatter.format(params_);
    }

    public String toString() {
        MessageFormat formatter = new MessageFormat(message_);
        return formatter.format(params_);
    }
}
