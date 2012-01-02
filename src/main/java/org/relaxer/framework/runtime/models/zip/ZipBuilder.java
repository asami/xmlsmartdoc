package org.relaxer.framework.runtime.models.zip;

import java.util.Enumeration;
import java.util.zip.ZipFile;

import org.relaxer.framework.runtime.model.IRTreeModelNode;

/**
 * ZipBuilder
 *
 * @since   Aug. 22, 2005
 * @version Aug. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ZipBuilder {
    private final ZipFile zipFile_;
    private final IRTreeModelNode root_;

    public ZipBuilder(ZipFile zipFile, IRTreeModelNode root) {
        zipFile_ = zipFile;
        root_ = root;
    }

    public void build() {
        Enumeration entries = zipFile_.entries();
    }
}
