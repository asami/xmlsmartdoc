/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import org.relaxer.framework.runtime.model.AbstractRTableModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;
import org.relaxer.framework.runtime.models.workspace.WorkspaceBag;
import org.relaxer.framework.runtime.models.workspace.WorkspaceContent;
import org.relaxer.framework.runtime.value.IRTree;

import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.TreeTable;

/**
 * CsvFileNode
 *
 * @since   Aug. 23, 2004
 * @version Nov. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class CsvModel extends AbstractRTableModel {
    public CsvModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

	public CsvModel(String fileName, IRModelContext context) throws RModelException {
		super(context);
		setProperty(PROPERTY_FILE, fileName);
	}

    protected void _open_table() throws RModelException {
        try {
            open_(_getDataSource());
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

    private void open_(IRDataSource source) throws IOException {
        if (source.isExist()) {
            open_(source.openBufferedReader());
        }
    }

    private void open_(BufferedReader reader) throws IOException {
        int y = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] items = UString.makeStringListFromCSVLine(line);
            for (int x = 0;x < items.length;x++) {
                setString(x, y, items[x]);
            }
            y++;
        }
    }

    protected void _commitDirty_table() throws RModelException {
        IRDataSource ds = _getDataSource();
        BufferedWriter writer = null;
        try {
            writer = ds.openBufferedWriter();
            writeTable_(writer);
        } catch (IOException e) {
            throw new RModelException(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private void writeTable_(BufferedWriter writer) throws RModelException, IOException {
        int height = getHeight();
        int width = getWidth();
        if (width == 0) {
            return;
        }
        for (int y = 0;y < height;y++) {
            writeNode_(get(0, y), writer);
            for (int x = 1;x < width;x++) {
                writer.write(',');
                writeNode_(get(x, y), writer);
            }
            writer.append(_context.getNewLine());
        }
        writer.flush();
    }

    private void writeNode_(IRModelNode node, BufferedWriter writer) throws IOException {
        if (node == null) {
            return;
        }
        IRModelContent content = node.getContent();
        if (content == null) {
            return;
        }
        String string = content.getText();
        if (string.indexOf(',') == -1 &&
                string.indexOf('"') == -1 &&
                string.indexOf('\n') == -1 &&
                string.indexOf('\r') == -1 &&
                string.indexOf('\t') == -1) {
            writer.append(string);
        } else {
            char[] chars = string.toCharArray();
            writer.append('"');
            for (int i = 0;i < chars.length;i++) {
                char c = chars[i];
                if (c == '"') {
                    writer.append("\"\"");
/*
                } else if (c == '\n') {
                    writer.append("\\n");
                } else if (c == '\r') {
                    writer.append("\\r");
                } else if (c == '\t') {
                    writer.append("\\t");
*/
                } else {
                    writer.append(c);
                }
            }
            writer.append('"');
        }
    }

    protected IRModelContent _getModelContent_table() throws RModelException {
        WorkspaceBag bag = new WorkspaceBag();
        BufferedWriter writer = null;
        try {
            writer = bag.openBufferedWriter();
            writeTable_(writer);
        } catch (IOException e) {
            throw new RModelException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
            }
        }
        return new WorkspaceContent(bag, _context);
    }

    public void setHead(IRTree head) throws RModelException {
        throw new UnsupportedOperationException("CsvModel.setHead");
    }
}
