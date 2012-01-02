package org.relaxer.framework.runtime.models.workspace;

import java.io.IOException;
import java.io.InputStream;

import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.content.AbstractRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * WorkspaceContent
 *
 * @since   Aug. 16, 2005
 * @version Aug. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class WorkspaceContent extends AbstractRModelContent {
    private final WorkspaceBag data_;

    public WorkspaceContent(WorkspaceBag data, IRModelContext context) {
        super(context);
        data_ = data;
    }

    protected void _close() throws RModelException {
        try {
            data_.dispose();
        } catch (IOException e) {
            throw new RModelException(e);
        }
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
    
    protected long _getSize() {
        return data_.getSize();
    }

    protected InputStream _openInputStream() throws RModelException {
        try {
            return data_.openInputStream();
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

    public Object getSource() {
        return null;
    }
}
