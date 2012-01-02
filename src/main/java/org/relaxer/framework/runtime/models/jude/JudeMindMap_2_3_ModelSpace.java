package org.relaxer.framework.runtime.models.jude;

import org.relaxer.framework.runtime.model.AbstractRModelSpace;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * JudeMindMapModelSpace
 *
 * @since   Aug. 16, 2005
 * @version Aug. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class JudeMindMap_2_3_ModelSpace extends AbstractRModelSpace {
    public JudeMindMap_2_3_ModelSpace() {
        super();
    }

    public boolean isMatch(IRModelNode node) {
        try {
            if (!"xml".equals(node.getSuffix())) {
                return false;
            }
            IRModelContent content = node.getContent();
            if (content == null) {
                return false;
            }
            if (!content.isXml()) {
                return false;
            }
            Document doc = content.getDocument();
            Element root = doc.getDocumentElement();
            if (!"XMI".equals(root.getTagName())) {
                return false;
            }
            NodeList maps = root.getElementsByTagNameNS("http://objectclub.esm.co.jp/Jude/namespace/", "MindMap");
            if (maps.getLength() == 0) {
                return false;
            }
            return true;
        } catch (RModelException e) {
            return false;
        }
    }

    public IRModel getModel(IRModelNode node, IRModelContext context) throws RModelException {
        return new JudeMindMap_2_3_Model(node, context);
    }
}
