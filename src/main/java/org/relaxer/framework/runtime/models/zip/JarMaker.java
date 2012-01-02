package org.relaxer.framework.runtime.models.zip;

import java.io.IOException;
import java.io.OutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.RTreeModelVisitorBase;
import org.relaxer.framework.runtime.model.content.IRModelContent;

/**
 * JarMaker
 *
 * @since   Aug. 20, 2005
 * @version Aug. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class JarMaker extends RTreeModelVisitorBase {
    private JarOutputStream jar_;

    public JarMaker(OutputStream out) throws RModelException {
        try {
            jar_ = new JarOutputStream(out);
        } catch (IOException e) {
            throw new RModelException(e);
        } 
    }
    
    public void close() throws RModelException {
        try {
            jar_.close();
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

    //
    public boolean start(IRTreeModelNode root) throws RModelException {
        return true;
    }

    public void end(IRTreeModelNode root) throws RModelException {
        try {
            jar_.flush();
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

    public boolean enter(IRTreeModelNode node) throws RModelException {
        try {
            JarEntry entry = new JarEntry(getJarEntryName_(node));
            if (node.isContainer()) {
                jar_.putNextEntry(entry);
                return true;
            } else {
                IRModelContent content = node.getContent();
                if (content == null) {
                    return false;
                }
                entry.setSize(content.getSize());
                jar_.putNextEntry(entry);
                content.writeBinary(jar_);
                return false;
            }
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

    private String getJarEntryName_(IRTreeModelNode node) throws RModelException {
        return node.getPathName().substring(1);
    }
 }
