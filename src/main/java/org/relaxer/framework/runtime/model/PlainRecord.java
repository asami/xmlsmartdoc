package org.relaxer.framework.runtime.model;

import java.util.ArrayList;
import java.util.List;

/**
 * PlainRecord
 *
 * @since   Aug.  8, 2005
 * @version Aug. 13, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class PlainRecord extends AbstractRModelRecord {
    private List columns_ = new ArrayList();

    public PlainRecord(IRModel model) {
        super(model);
    }

    public PlainRecord(List list, IRModel model) {
        super(model);
        columns_.addAll(list);
    }

    public int getWidth() {
        return columns_.size();
    }

    public Object get(int x) throws RModelException {
        return columns_.get(x);
/*
        SimpleRModelNode node = new SimpleRModelNode(_model);
        Object value = columns_.get(x);
        if (value != null) {
            node.setContent(new ObjectContent(value, _model.getModelContext()));
        }
        return node;
*/
    }

    public void set(int x, Object value) {
        columns_.add(x, value);
    }
    
    public void add(Object value) {
        columns_.add(value);
    }
}
