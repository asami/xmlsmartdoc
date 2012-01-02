/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

import java.io.IOException;

/**
 * IRepository
 *
 * @since   Dec. 27, 2003
 * @version Dec. 27, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRRepository {
    void create() throws IOException;
    void load() throws IOException;
    void save() throws IOException;
    void destroy() throws IOException;
}
