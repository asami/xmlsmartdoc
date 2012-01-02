/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

import org.relaxer.framework.runtime.model.content.IRModelContent;

/*
 * SimpleRModelNode
 *
 * @since   Aug. 24, 2004
 * @version Aug. 25, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class SimpleRModelNode extends AbstractRModelNode implements IRModelNode {
    public SimpleRModelNode(IRModel model) {
        super(model);
    }

    public SimpleRModelNode(IRModelContent content, IRModel model) throws RModelException {
        super(model);
        setContent(content);
    }
}
