/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

import java.util.HashMap;
import java.util.Map;

/**
 * ModelRepository
 *
 * @since   Dec. 27, 2003
 * @version Aug.  9, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ModelRepository {
    private Map models_ = new HashMap();

    public ModelRepository() {
    }

    public IRModel openModel(String name) {
        return ((IRModel)models_.get(name));
    }
}
