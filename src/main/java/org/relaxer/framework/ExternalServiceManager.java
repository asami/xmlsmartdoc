package org.relaxer.framework;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.ConstructorUtils;
import org.relaxer.framework.logger.IRFrameworkLogger;
import org.relaxer.framework.runtime.model.IRModel;

/**
 * ExternalServiceManager
 *
 * @since   Aug.  9, 2005
 * @version Aug.  9, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class ExternalServiceManager {
    private final IRFrameworkLogger logger_;
    private boolean loadedBeanUtils_ = false;

    public ExternalServiceManager(IRFrameworkLogger logger) {
        logger_ = logger;
    }

    public IRModel newInstance(
        Class modelClass, Object arg1, Object arg2
    ) throws NoSuchMethodException, IllegalAccessException, 
             InvocationTargetException, InstantiationException, ClassNotFoundException {
        ensureBeanUtils_();
        IRModel instance = (IRModel)ConstructorUtils.invokeConstructor(
            modelClass, new Object[] {arg1, arg2});
        return instance;
    }

    private void ensureBeanUtils_() throws ClassNotFoundException {
        if (loadedBeanUtils_) {
            return;
        }
        try {
            Class.forName("org.apache.commons.beanutils.ConstructorUtils");
        } catch (ClassNotFoundException e) {
            logger_.fatal("beanutils.jar is required.");
            throw e;
        }
    }
}
