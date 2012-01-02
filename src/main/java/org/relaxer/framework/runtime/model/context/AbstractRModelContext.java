package org.relaxer.framework.runtime.model.context;

import java.io.IOException;

import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.RModelFactory;
import org.relaxer.framework.runtime.model.content.IRModelContent;

import com.AsamiOffice.util.CacheManager;
import com.AsamiOffice.xml.XmlChecker;

/**
 * AbstractRModelContext
 *
 * @since   Aug.  2, 2005
 * @version Sep. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRModelContext implements IRModelContext {
    private RModelFactory modelFactory_;
    private CacheManager cacheManager_;

    public void setModelFactory(RModelFactory factory) {
        modelFactory_ = factory;
    }

    public IRModel mount(IRModelNode node) throws RModelException {
        if (modelFactory_ == null) {
            return null;
        }
        return (modelFactory_.mount(node, this));
    }

    public boolean isTextSuffix(String suffix) {
        if (isXmlSuffix(suffix)) {
            return true;
        }
        if ("txt".equals(suffix)) {
            return true;
        }
        return false;
    }

    public boolean isTextContent(IRModelContent content) {
        return false;
    }

    public boolean isXmlSuffix(String suffix) {
        if ("xml".equals(suffix)) { // TODO
            return true;
        }
        return false;
    }

    public boolean maybeXmlSuffix(String suffix) {
        if ("html".equals(suffix)) { // TODO
            return true;
        } 
        return false;
    }

    public boolean isXmlContent(IRModelContent content) {
        try {
            XmlChecker checker = new XmlChecker(getXMLReader());
            return (checker.check(content.getDataSource().getInputSource()));
        } catch (RModelException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    //
    public final Object getCache(Object owner, String usage) {
        if (cacheManager_ == null) {
            return null;
        }
        return cacheManager_.get(owner, usage);
    }

    public final void addCache(Object owner, String usage, Object data) {
        if (cacheManager_ == null) {
            cacheManager_ = new CacheManager();
        }
        cacheManager_.add(owner, usage, data);
    }

    public final void clearCache(Object owner) {
        if (cacheManager_ == null) {
            return;
        }
        cacheManager_.clear(owner);
    }

    public final void commit() {
    }

    public final void abort() {
    }

    public final void dispose() {
        cacheManager_ = null;
    }
}
