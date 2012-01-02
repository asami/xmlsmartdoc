package org.relaxer.framework.runtime.models.zip;

import java.util.Enumeration;
import java.util.jar.JarFile;

import org.relaxer.framework.runtime.model.IRTreeModelNode;

/**
 * JarBuilder
 *
 * @since   Aug. 20, 2005
 * @version Aug. 20, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class JarBuilder {
    private final JarFile jarFile_;
    private final IRTreeModelNode root_;

    public JarBuilder(JarFile jarFile, IRTreeModelNode root) {
        jarFile_ = jarFile;
        root_ = root;
    }

    public void build() {
        Enumeration entries = jarFile_.entries();
    }
}
