/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.opendocument;

import java.util.Stack;

import org.relaxer.framework.runtime.model.AbstractRTreeModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.RTreeModelVisitorBase;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.models.opendocument.model.presentation.ODPBody;
import org.relaxer.framework.runtime.models.opendocument.model.presentation.ODPDocumentContent;
import org.relaxer.framework.runtime.models.opendocument.model.presentation.ODPFrame;
import org.relaxer.framework.runtime.models.opendocument.model.presentation.ODPList;
import org.relaxer.framework.runtime.models.opendocument.model.presentation.ODPListItem;
import org.relaxer.framework.runtime.models.opendocument.model.presentation.ODPP;
import org.relaxer.framework.runtime.models.opendocument.model.presentation.ODPPage;
import org.relaxer.framework.runtime.models.opendocument.model.presentation.ODPPresentation;
import org.relaxer.framework.runtime.models.opendocument.model.presentation.ODPTextBox;
import org.relaxer.framework.runtime.models.opendocument.model.presentation.RNSContext;
import org.relaxer.framework.runtime.models.zip.ZipModel;
import org.relaxer.vocabulary.opendocument_1_0.manifest.ODMFileEntry;
import org.relaxer.vocabulary.opendocument_1_0.manifest.ODMManifest;

/**
 * OpenDocument_1_0_PresentationModel
 *
 * @since   Aug. 19, 2005
 * @version Sep.  1, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class OpenDocument_1_0_PresentationModel extends AbstractRTreeModel {
    private ZipModel zip_;
    private ODMManifest manifest_;
    private ODPDocumentContent content_;
    private ODPPresentation presentation_;

    public OpenDocument_1_0_PresentationModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

	public OpenDocument_1_0_PresentationModel(String fileName, IRModelContext context) throws RModelException {
		super(context);
		setProperty(PROPERTY_FILE, fileName);
	}

    protected void _open_tree() throws RModelException {
        zip_ = new ZipModel(_getDataSource(), _context);
        zip_.open();
        IRTreeModelNode contentXml = zip_.getNode("content.xml");
        if (contentXml != null) {
            content_ = new ODPDocumentContent(contentXml.getContent().getDocument());
        } else {
            content_ = new ODPDocumentContent();
            RNSContext nsContext = content_.rGetRNSContext();
            nsContext.setPrefix("office");
            nsContext.declareNamespace("style", "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
            nsContext.declareNamespace("text", "urn:oasis:names:tc:opendocument:xmlns:text:1.0");
            nsContext.declareNamespace("draw", "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
            content_.setVersion("1.0");
            ODPBody body = new ODPBody();
            content_.setBody(body);
            presentation_ = new ODPPresentation();
            body.setPresentation(presentation_);
        }
    }

    protected void _commitDirty_tree() throws RModelException {
        zip_.commit();
    }

    protected void _close_tree() throws RModelException {
        zip_.close();
        zip_ = null;
    }

    protected IRModelContent _getModelContent_tree() throws RModelException {
        flush_();
        return zip_.getModelContent();
    }

    private void flush_() throws RModelException {
        IRTreeModelNode root = getRoot();
        IRTreeModelNode[] children = root.getChildren();
        for (int i = 0;i < children.length;i++) {
            IRTreeModelNode node = children[i];
            ODPPage page = new ODPPage();
            page.setName("page" + (i + 1));
            page.setStyleName("dp1");
            page.setPresentationPageLayoutName("AL2T1");
            ODPFrame title = new ODPFrame();
            title.setStyleName("pr1");
            title.setLayer("layout");
            title.setWidth("25.199cm");
            title.setHeight("3.256cm");
            title.setX("1.4cm");
            title.setY("0.962cm");
            title.setClassValue("title");
            title.setTextBox(makeParagraphTextBox_(node));
            page.addFrame(title);
            if (node.getLength() > 0) {
                ODPFrame body = new ODPFrame();
                body.setStyleName("pr4");
                body.setLayer("layout");
                body.setWidth("25.199cm");
                body.setHeight("13.609cm");
                body.setX("1.4cm");
                body.setY("4.914cm");
                body.setClassValue("outline");
                ODPTextBox textBox = new ODPTextBox();
                ODPList list = new ODPList();
                textBox.setContent(list);
                body.setTextBox(textBox);
                page.addFrame(body);
                ContentMaker builder = new ContentMaker(list);
                traverseChildren(node, builder);
                builder.build();
            }
            presentation_.addPage(page);
        }
        if (manifest_ == null) {
            manifest_ = new ODMManifest();
            ODMFileEntry entry = new ODMFileEntry();
            entry.setMediaType("application/vnd.oasis.opendocument.presentation");
            entry.setFullPath("/");
            manifest_.addFileEntry(entry);
            entry = new ODMFileEntry();
            entry.setMediaType("text/xml");
            entry.setFullPath("content.xml");
            manifest_.addFileEntry(entry);
            zip_.addNode("META-INF/manifest.xml", manifest_.makeTextDocument());
        }
        zip_.addNode("content.xml", content_.makeTextDocument());
    }

    private ODPTextBox makeParagraphTextBox_(IRTreeModelNode node) {
        ODPTextBox textBox = new ODPTextBox();
        ODPP p = makeParagraph_(node);
        textBox.setContent(p);
        return textBox;
    }

    private ODPP makeParagraph_(IRTreeModelNode node) {
        ODPP p = new ODPP();
        p.setContent(node.getName());
        return p;
    }

    class ContentMaker extends RTreeModelVisitorBase {
        private Stack stack_ = new Stack();

        ContentMaker(ODPList list) {
            stack_.push(list);
        }

        public boolean enter(IRTreeModelNode node) throws RModelException {
            ODPList parent = (ODPList)stack_.peek();
            ODPListItem listItem = new ODPListItem();
            listItem.setContent(makeParagraph_(node));
            parent.addListItem(listItem);
            if (node.getLength() > 0) {
                listItem = new ODPListItem();
                ODPList list = new ODPList();
                stack_.push(list);
                listItem.setContent(list);
                parent.addListItem(listItem);
            }
            return true;
        }

        public void leave(IRTreeModelNode node) throws RModelException {
            if (node.getLength() > 0) {
                stack_.pop();
            }
        }

        public void build() throws RModelException {
        }
    }
}
