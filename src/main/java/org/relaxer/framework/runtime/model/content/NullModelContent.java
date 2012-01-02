package org.relaxer.framework.runtime.model.content;

import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.context.NullModelContext;

/**
 * NullModelContent
 *
 * @since   Aug. 12, 2005
 * @version Aug. 20, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class NullModelContent extends AbstractRModelContent {
    protected NullModelContent() {
        super(NullModelContext.getContext());
    }

    public NullModelContent(IRModelContext context) {
        super(context);
    }

/*
    public NullModelContent(String encoding, IRModelContext context) {
        super(encoding, context);
    }
*/

    public boolean isValue() {
        return false;
    }

    public Object getValue() {
        return null;
    }

    public boolean isBinary() {
        return false;
    }
    
    protected Boolean _isText() {
        return Boolean.FALSE;
    }

    protected Boolean _isXml() {
        return Boolean.FALSE;
    }

    public Object getSource() {
        return null;
    }

    //
    private static Object shared__;

    public static IRModelContent getContent() {
        if (shared__ == null) {
            shared__ = new NullModelContent();
        }
        return null;
    }
}
