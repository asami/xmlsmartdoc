package org.relaxer.framework.runtime.models.excel;

import org.relaxer.framework.runtime.model.content.AbstractRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;

/**
 * ExcelBookContent
 *
 * @since   Aug. 14, 2005
 * @version Aug. 16, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ExcelBookContent extends AbstractRModelContent { // XXX unused?
    private final ExcelBookModel model_;

    protected ExcelBookContent(ExcelBookModel model, IRDataSource ds, IRModelContext context) {
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
