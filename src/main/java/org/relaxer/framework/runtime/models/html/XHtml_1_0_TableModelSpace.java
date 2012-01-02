package org.relaxer.framework.runtime.models.html;

import org.relaxer.framework.runtime.model.AbstractRModelSpace;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;

import com.AsamiOffice.xml.XmlConstants;

/**
 * XHtmlTableModelSpace
 *
 * @since   Aug. 16, 2005
 * @version Sep. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class XHtml_1_0_TableModelSpace extends AbstractRModelSpace {
    public XHtml_1_0_TableModelSpace() {
        super();
    }

    public boolean isMatch(IRModelNode node) {
        try {
            String suffix = node.getSuffix();
            if ("xhtml".equals(suffix)) {
                return true;
            }
            if ("html".equals(suffix)) {
                IRModelContent content = node.getContent();
                if (content == null) {
                    return false;
                }
                if (!content.isXml()) {
                    return false;
                }
                String ns = content.getRootNamespace();
                if (XmlConstants.XHTML_NS.equals(ns) ||
                        XmlConstants.XHTML2_NS.equals(ns)) {
                    return true;
                }
            }
            return false;
        } catch (RModelException e) {
            return false;
        }
    }

    public IRModel getModel(IRModelNode node, IRModelContext context) throws RModelException {
        return new XHtml_1_0_TableModel(node, context);
    }
}
