package org.relaxer.framework.runtime.model.datasource;

import java.io.IOException;

import org.relaxer.framework.runtime.model.context.NullModelContext;


/**
 * NullDataSource
 *
 * @since   Aug. 12, 2005
 * @version Aug. 16, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class NullDataSource extends AbstractRDataSource {
    protected NullDataSource() {
        super(NullModelContext.getContext());
    }

    protected boolean _isExist() throws IOException {
        return false;
    }

    //
    private static NullDataSource shared__;

    public static IRDataSource getDataSource() {
        if (shared__ == null) {
            shared__ = new NullDataSource();
        }
        return shared__;
    }
}
