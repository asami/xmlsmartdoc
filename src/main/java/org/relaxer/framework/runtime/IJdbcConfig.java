/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime;

import java.util.Map;

/**
 * IJdbcConfig
 *
 * @since   2004/03/10
 * @version 2004/03/10
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IJdbcConfig {
    String getQuoteId();
    String getQuoteWhere();
    String getQuoteIdInWhere();
    Map getTypeMappings();
}
