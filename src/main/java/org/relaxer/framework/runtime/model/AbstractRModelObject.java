package org.relaxer.framework.runtime.model;

import org.relaxer.framework.logger.IRFrameworkLogger;
import org.relaxer.framework.runtime.messager.IRFrameworkMessager;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.reporter.IRFrameworkReporter;

/**
 * AbstractRModelobject
 *
 * @since   Oct. 16, 2005
 * @version Oct. 16, 2005
 * @author  ASAMI, Tomoharu (asami@AsamOffice.com)
 */
public class AbstractRModelObject {
    protected final IRModel model_;
    protected final IRModelContext context_;
    protected final IRFrameworkLogger logger_;
    protected final IRFrameworkMessager messager_;
    protected final IRFrameworkReporter reporter_;

    public AbstractRModelObject(IRModel model) {
        model_ = model;
        context_ = model.getModelContext();
        logger_ = context_.getLogger();
        messager_ = context_.getMessager();
        reporter_ = context_.getReporter();
    }

    public final IRModelContext getModelContext() {
        return context_;
    }

}
