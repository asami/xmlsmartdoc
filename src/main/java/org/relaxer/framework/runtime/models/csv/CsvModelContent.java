package org.relaxer.framework.runtime.models.csv;

import org.relaxer.framework.runtime.model.content.AbstractRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;

/**
 * CsvModelContent
 *
 * @since   Aug. 15, 2005
 * @version Aug. 16, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class CsvModelContent extends AbstractRModelContent { // XXX : unused?
    private final CsvModel model_;

    protected CsvModelContent(CsvModel model, IRDataSource ds, IRModelContext context) {
        super(ds, context);
        model_ = model;
    }

    public boolean isValue() {
        return false;
    }

    public Object getValue() {
        return null;
    }

    public boolean isBinary() {
        return true;
    }

/*
    public InputStream openInputStream() throws RModelException {
        return model_.openInputStream();
    }
*/

    public Object getSource() {
        return model_;
    }
}
