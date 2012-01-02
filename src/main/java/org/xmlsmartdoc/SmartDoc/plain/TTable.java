/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.xmlsmartdoc.SmartDoc.plain;

import java.util.ArrayList;
import java.util.List;

import org.xmlsmartdoc.SmartDoc.CSSLength;
import org.xmlsmartdoc.SmartDoc.CharBlock;
import org.xmlsmartdoc.SmartDoc.Col;
import org.xmlsmartdoc.SmartDoc.Container;
import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.Paragraph;
import org.xmlsmartdoc.SmartDoc.Table;
import org.xmlsmartdoc.SmartDoc.TrContent;
import org.xmlsmartdoc.SmartDoc.UDoc;

import com.AsamiOffice.jaba2.text.cui.CPanel;
import com.AsamiOffice.jaba2.text.cui.CTD;
import com.AsamiOffice.jaba2.text.cui.CTable;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.D2Array;

/**
 * TTable
 *
 * @since   Oct. 12, 1999
 * @version Spe.  2, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class TTable extends AbstractTElement {
    protected Table table_;
    protected ITKeisen keisen_;
    protected String keisenStyle_;

    public TTable(Table table) {
        super("ttable");
        table_ = table;
        keisen_ = new TAsciiKeisen();
    }

    public void setKeisenStyle(String style) {
        keisenStyle_ = style;
        if ("jis".equals(style)) {
            keisen_ = new TJisKeisen();
        } else {
            keisen_ = new TAsciiKeisen();
        }
    }

    public int getTopGap() {
        return (0);
    }

    public int getBottomGap() {
        return (0);
    }

    public void format(StringBuffer buffer) {
        int width = table_.getWidth();
        ColumnInfo[] info = _getColumnInfo(table_);
        int size;
        // top
        buffer.append(_getTopLeft());
        if (width > 0) {
            size = info[0].width;
            while (size-- > 0) {
                buffer.append(_getTop());
            }
            for (int x = 1;x < width;x++) {
                buffer.append(_getTopThinJoint()); // XXX
                size = info[x].width;
                while (size-- > 0) {
                    buffer.append(_getTop());
                }
            }
        }
        buffer.append(_getTopRight());
        buffer.append("\n");

        D2Array head = table_.getHeadData();
        D2Array body = table_.getBodyData();
        D2Array foot = table_.getFootData();
        // head
        if (head != null) {
            _formatChunk(info, head, buffer);
            if (body != null || foot != null) {
                _formatThickHLine(info, head, -1, buffer);
            }
        }
        // body
        if (body != null) {
            _formatChunk(info, body, buffer);
            if (foot != null) {
                _formatThickHLine(info, body, -1, buffer);
            }
        }
        // foot
        if (foot != null) {
            _formatChunk(info, foot, buffer);
        }
        // bottom
        buffer.append(_getBottomLeft());
        if (width > 0) {
            size = info[0].width;
            while (size-- > 0) {
                buffer.append(_getBottom());
            }
            for (int x = 1;x < width;x++) {
                buffer.append(_getBottomThinJoint()); // XXX
                size = info[x].width;
                while (size-- > 0) {
                    buffer.append(_getBottom());
                }
            }
        }
        buffer.append(_getBottomRight());
        buffer.append("\n");
    }

    public void format(CPanel node) {
        CTable ctable = new CTable(keisenStyle_);
        ColumnInfo[] info = _getColumnInfo(table_);
        for (int x = 0;x < info.length;x++) {
            ctable.setColumnWidth(x, info[x].width);
            ctable.setColumnAlign(x, info[x].align);
        }
        D2Array head = table_.getHeadData();
        if (head != null) {
            int width = head.getWidth();
            int height = head.getHeight();
            for (int y = 0;y < height;y++) {
                for (int x = 0;x < width;x++) {
                    TrContent cell = (TrContent)head.get(x, y);
                    if (cell != null) {
                        String string = getText_(cell);
                        CTD cCell = new CTD(string);
                        cCell.setRowSpan(cell.getRowSpan());
                        cCell.setColSpan(cell.getColSpan());
                        ctable.setHead(x, y, cCell);
                    }
                }
            }
        }
        D2Array foot = table_.getFootData();
        if (foot != null) {
            int width = foot.getWidth();
            int height = foot.getHeight();
            for (int y = 0;y < height;y++) {
                for (int x = 0;x < width;x++) {
                    TrContent cell = (TrContent)foot.get(x, y);
                    if (cell != null) {
                        String string = getText_(cell);
                        CTD cCell = new CTD(string);
                        cCell.setRowSpan(cell.getRowSpan());
                        cCell.setColSpan(cell.getColSpan());
                        ctable.setFoot(x, y, cCell);
                    }
                }
            }
        }
        D2Array body = table_.getBodyData();
        if (body != null) {
            int width = body.getWidth();
            int height = body.getHeight();
            for (int y = 0;y < height;y++) {
                for (int x = 0;x < width;x++) {
                    TrContent cell = (TrContent)body.get(x, y);
                    if (cell != null) {
                        String string = getText_(cell);
                        String align = table_.getAlign(x, y);
                        CTD cCell = new CTD(string);
                        cCell.setRowSpan(cell.getRowSpan());
                        cCell.setColSpan(cell.getColSpan());
                        if (align != null) {
                            cCell.setAlign(align);
                        }
                        ctable.setBody(x, y, cCell);
                    }
                }
            }
        }
        node.append(ctable);
    }

	private String getText_(TrContent cell) {
		StringBuffer sb = new StringBuffer();
		Content[] contents = cell.getContents();
		for (int i = 0;i < contents.length;i++) {
			Content content = contents[i];
			if (content instanceof Paragraph) {
				sb.append(UDoc.distillText((Paragraph)content));
				sb.append("\n");
            } else if (content instanceof Container) {
                sb.append(UDoc.distillText((Container)content));
            } else if (content instanceof CharBlock) {
                sb.append(content.getText());
			} else {
                sb.append(content.getText());
			}
		}
		return (new String(sb));
	}

	protected void _formatChunk(
        ColumnInfo[] info,
        D2Array chunk,
        StringBuffer buffer
    ) {
        int width = chunk.getWidth();
        int height = chunk.getHeight();
        if (height > 0) {
            D2Array row = _makeRow(info, chunk, 0);
            _formatRow(info, row, buffer);
            for (int y = 1;y < height;y++) {
                if (width > 0) {
                    buffer.append(_getLeft());
                    int size = info[0].width;
                    while (size-- > 0) {
                        buffer.append(_getThinHLine());        // XXX
                    }
                    for (int x = 1;x < width;x++) {
                        buffer.append(_getHThinVThinJoint()); // XXX
                        size = info[x].width;
                        while (size-- > 0) {
                            buffer.append(_getThinHLine()); // XXX
                        }
                    }
                    buffer.append(_getRight());
                    buffer.append("\n");
                }
                row = _makeRow(info, chunk, y);
                _formatRow(info, row, buffer);
            }
        }
    }

    protected void _formatRow(
        ColumnInfo[] info,
        D2Array row,
        StringBuffer buffer
    ) {
        int width = row.getWidth();
        int height = row.getHeight();
        for (int y = 0;y < height;y++) {
            buffer.append(_getLeft());
            if (width > 0) {
                buffer.append(row.get(0, y).toString());
                for (int x = 1;x < width;x++) {
                    buffer.append(_getThinVLine());
                    buffer.append(row.get(x, y).toString());
                }
            }
            buffer.append(_getRight());
            buffer.append("\n");
        }
    }

    protected void _formatThickHLine(
        ColumnInfo[] info,
        D2Array data,                // XXX
        int y,                        // XXX
        StringBuffer buffer
    ) {
        int width = data.getWidth();
        if (width > 0) {
            buffer.append(_getLeftThickJoint());
            int size = info[0].width;
            while (size-- > 0) {
                buffer.append(_getThickHLine());
            }
            for (int x = 1;x < width;x++) {
                buffer.append(_getHThickVThinJoint());
                size = info[x].width;
                while (size-- > 0) {
                    buffer.append(_getThickHLine());
                }
            }
            buffer.append(_getRightThickJoint());
            buffer.append("\n");
        }
    }

    protected void _formatThinHLine(
        ColumnInfo[] info,
        D2Array data,                // XXX
        int y,                        // XXX
        StringBuffer buffer
    ) {
        int width = data.getWidth();
        if (width > 0) {
            buffer.append(_getLeftThinJoint());
            int size = info[0].width;
            while (size-- > 0) {
                buffer.append(_getThinHLine());
            }
            for (int x = 1;x < width;x++) {
                buffer.append(_getHThinVThinJoint());
                size = info[x].width;
                while (size-- > 0) {
                    buffer.append(_getThinHLine());
                }
            }
            buffer.append(_getRightThinJoint());
            buffer.append("\n");
        }
    }

    protected ColumnInfo[] _getColumnInfo(Table table) {
        int width = table.getWidth();
        D2Array head = table_.getHeadData();
        D2Array foot = table_.getFootData();
        D2Array body = table_.getBodyData();
        ColumnInfo[] info = new ColumnInfo[width];
        for (int x = 0;x < width;x++) {
            int size = _getMaxWidth(0, head, x);
            size = _getMaxWidth(size, foot, x);
            size = _getMaxWidth(size, body, x);
            info[x] = new ColumnInfo();
            info[x].width = size;
        }
        Col[] cols = table_.getCols();
//        if (cols.length != width) {
//            throw (new InternalError());
//        }
        for (int x = 0;x < width;x++) {
            CSSLength colWidth = cols[x].getWidthFinal();
            if (colWidth != null) {
                switch (colWidth.getUnit()) {

                case CSSLength.EM:
                    info[x].width = (int)((colWidth.getValue() * 2.0) + 0.5);
                    break;
                case CSSLength.EX:
                    info[x].width = (int)(colWidth.getValue() + 0.5);
                    break;
                default:
                }
            }
        }
        return (info);
    }

    protected int _getMaxWidth(int size, D2Array data, int x) {
        if (data == null) {
            return (size);
        }
        int height = data.getHeight();
        for (int y = 0;y < height;y++) {
            TrContent cell = (TrContent)data.get(x, y);
            if (cell != null) {
                String string = UDoc.distillText(cell);
                size = Math.max(
                    size,
                    UString.getHalfLength(string)
                );
                size = _adjustWidth(size);
            }
        }
        return (size);
    }

    protected D2Array _makeRow(ColumnInfo[] info, D2Array data, int y) {
        int width = data.getWidth();
        String[] row = new String[width];
        for (int x = 0;x < width;x++) {
            TrContent cell = (TrContent)data.get(x, y);
            row[x] = UDoc.distillText(cell);
        }
        return (_makeRow(info, row));
    }

    protected D2Array _makeRow(ColumnInfo[] info, String[] row) {
        D2Array data = new D2Array();
        for (int x = 0;x < row.length;x++) {
            String[] lines = info[x].makeData(row[x]);
            for (int i = 0;i < lines.length;i++) {
                data.put(x, i, lines[i]);
            }
        }
        int height = data.getHeight();
        for (int x = 0;x < row.length;x++) {
            int width = UString.getHalfLength(data.get(x, 0).toString());
            for (int y = 1;y < height;y++) {
                if (data.get(x, y) == null) {
                    StringBuffer pad = new StringBuffer();
                    for (int i = 0;i < width;i++) {
                        pad.append(" ");
                    }
                    data.put(x, y, new String(pad));
                }
            }
        }
        return (data);
    }

    private int _adjustWidth(int width) {
        if (!"jis".equals(keisenStyle_)) {
            return (width);
        }
        return (width + (width % 2));
    }

    protected String _getTopLeft() {
        return (keisen_.getTopLeft());
    }

    protected String _getTopRight() {
        return (keisen_.getTopRight());
    }

    protected String _getBottomLeft() {
        return (keisen_.getBottomLeft());
    }

    protected String _getBottomRight() {
        return (keisen_.getBottomRight());
    }

    protected String _getTop() {
        return (keisen_.getTop());
    }

    protected String _getBottom() {
        return (keisen_.getBottom());
    }

    protected String _getLeft() {
        return (keisen_.getLeft());
    }

    protected String _getRight() {
        return (keisen_.getRight());
    }

    protected String _getLeftThickJoint() {
        return (keisen_.getLeftThickJoint());
    }

    protected String _getRightThickJoint() {
        return (keisen_.getRightThickJoint());
    }

    protected String _getLeftThinJoint() {
        return (keisen_.getLeftThinJoint());
    }

    protected String _getRightThinJoint() {
        return (keisen_.getRightThinJoint());
    }

    protected String _getThickHLine() {
        return (keisen_.getThickHLine());
    }

    protected String _getThickVLine() {
        return (keisen_.getThickVLine());
    }

    protected String _getThinHLine() {
        return (keisen_.getThinHLine());
    }

    protected String _getThinVLine() {
        return (keisen_.getThinVLine());
    }

    protected String _getTopThickJoint() {
        return (keisen_.getTopThickJoint());
    }

    protected String _getBottomThickJoint() {
        return (keisen_.getBottomThickJoint());
    }

    protected String _getTopThinJoint() {
        return (keisen_.getTopThinJoint());
    }

    protected String _getBottomThinJoint() {
        return (keisen_.getBottomThinJoint());
    }

    protected String _getHThickVThickJoint() {
        return (keisen_.getHThickVThickJoint());
    }

    protected String _getHThickVThinJoint() {
        return (keisen_.getHThickVThinJoint());
    }

    protected String _getHThinVThickJoint() {
        return (keisen_.getHThinVThickJoint());
    }

    protected String _getHThinVThinJoint() {
        return (keisen_.getHThinVThinJoint());
    }

    static class ColumnInfo {
        int width;
        String align = "left";

        public String[] makeData(String data) {
            List list = new ArrayList();
            StringBuffer buffer = new StringBuffer();
            String[] lines = UString.makeStringList(data);
            int curWidth = 0;
            for (int i = 0;i < lines.length;i++) {
                String string = lines[i];
                int size = string.length();
                for (int j = 0;j < size;j++) {
                    char c = string.charAt(j);
                    if (UString.isWideCharacter(c)) {
                        if (curWidth + 1 == width) {
                            buffer.append(" ");
                            list.add(new String(buffer));
                            buffer = new StringBuffer();
                            buffer.append(c);
                            curWidth = 2;
                        } else {
                            buffer.append(c);
                            if (curWidth + 2 == width) {
                                list.add(new String(buffer));
                                buffer = new StringBuffer();
                                curWidth = 0;
                            } else {
                                curWidth += 2;
                            }
                        }
                    } else {
                        buffer.append(c);
                        if (curWidth + 1 == width) {
                            list.add(new String(buffer));
                            buffer = new StringBuffer();
                            curWidth = 0;
                        } else {
                            curWidth++;
                        }
                    }
                }
                int curSize = UString.getHalfLength(new String(buffer));
                if (curSize > 0) {
                    int count = width - curSize;
                    while (count-- > 0) {
                        buffer.append(" ");
                    }
                    list.add(new String(buffer));
                    buffer = new StringBuffer();
                    curWidth = 0;
                }
            }
            String[] result = new String[list.size()];
            return ((String[])list.toArray(result));
        }
    };
}
