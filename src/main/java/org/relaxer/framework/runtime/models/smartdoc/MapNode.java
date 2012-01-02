package org.relaxer.framework.runtime.models.smartdoc;

import java.util.Map;

import org.relaxer.framework.runtime.model.IRTreeModel;

import com.AsamiOffice.util.ArrayMap;

/**
 * MapNode
 *
 * @since   Sep. 28, 2005
 * @version Sep. 29, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class MapNode extends ContentNode {
    ArrayMap map_ = new ArrayMap();

    public MapNode(IRTreeModel model) {
        super("map" + ++counter__, model);
    }

    public void add(String key, String value) {
        map_.put(key, value);
    }

    public Map getMap() {
        return map_;
    }

    private static int counter__ = 0;
}
