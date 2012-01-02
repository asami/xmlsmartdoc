package org.relaxer.framework.runtime.model;

/**
 * PlainRecord
 *
 * @since   Aug. 10, 2005
 * @version Aug. 10, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRModelRecord implements IRModelRecord {
    protected final IRModel _model;

    protected AbstractRModelRecord(IRModel model) {
        _model = model;
    }
}
