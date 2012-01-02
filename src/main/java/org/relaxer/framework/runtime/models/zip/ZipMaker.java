package org.relaxer.framework.runtime.models.zip;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.RTreeModelVisitorBase;
import org.relaxer.framework.runtime.model.content.IRModelContent;

import com.AsamiOffice.io.ContextOutputStream;

/**
 * ZipMaker
 *
 * @since   Aug. 22, 2005
 * @version Aug. 26, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ZipMaker extends RTreeModelVisitorBase {
    private ZipOutputStream zip_;

    public ZipMaker(OutputStream out) throws RModelException {
        out = new ContextOutputStream(out);
        zip_ = new ZipOutputStream(out);
//        try {
//            zip_ = new ZipOutputStream(new FileOutputStream("c:/tmp/SmartMind/junk.zip"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public boolean start(IRTreeModelNode root) throws RModelException {
        return true;
    }

    public void end(IRTreeModelNode root) throws RModelException {
        try {
            zip_.flush();
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

    public boolean enter(IRTreeModelNode node) throws RModelException {
        try {
            if (node.isContainer()) {
                ZipEntry entry = new ZipEntry(getZipEntryName_(node) + "/");
                zip_.putNextEntry(entry);
                return true;
            } else {
                ZipEntry entry = new ZipEntry(getZipEntryName_(node));
                IRModelContent content = node.getContent();
                if (content == null) {
                    return false;
                }
                entry.setSize(content.getSize());
                zip_.putNextEntry(entry);
                content.writeBinary(zip_);
                return false;
            }
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

    private String getZipEntryName_(IRTreeModelNode node) throws RModelException {
        return node.getPathName().substring(1);
    }

    public void close() throws RModelException {
        try {
            zip_.close();
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }
}
