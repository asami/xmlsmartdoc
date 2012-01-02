/*
 * Created on 2004/11/08
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.relaxer.framework.runtime.models.smartdoc;

import java.util.Map;

import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.RTreeModelVisitorBase;
import org.relaxer.framework.runtime.value.ICursor;
import org.relaxer.framework.runtime.value.IRTable;
import org.relaxer.framework.runtime.value.IRTree;
import org.relaxer.framework.runtime.value.IRTreeNode;
import org.relaxer.framework.runtime.value.IRTreeVisitor;
import org.relaxer.vocabulary.smartdoc_1_0.ISDClassContentMixed;
import org.relaxer.vocabulary.smartdoc_1_0.SDBodyTr;
import org.relaxer.vocabulary.smartdoc_1_0.SDCol;
import org.relaxer.vocabulary.smartdoc_1_0.SDColgroup;
import org.relaxer.vocabulary.smartdoc_1_0.SDDd;
import org.relaxer.vocabulary.smartdoc_1_0.SDDl;
import org.relaxer.vocabulary.smartdoc_1_0.SDDlEntry;
import org.relaxer.vocabulary.smartdoc_1_0.SDDt;
import org.relaxer.vocabulary.smartdoc_1_0.SDHeadTr;
import org.relaxer.vocabulary.smartdoc_1_0.SDLi;
import org.relaxer.vocabulary.smartdoc_1_0.SDTable;
import org.relaxer.vocabulary.smartdoc_1_0.SDTbody;
import org.relaxer.vocabulary.smartdoc_1_0.SDTd;
import org.relaxer.vocabulary.smartdoc_1_0.SDTh;
import org.relaxer.vocabulary.smartdoc_1_0.SDThead;
import org.relaxer.vocabulary.smartdoc_1_0.SDUl;

import com.AsamiOffice.util.D2Array;
import com.AsamiOffice.util.TreeTable;
import com.AsamiOffice.util.TreeTable.Cursor;

/**
 * USmartDoc
 *
 * @since   Nov.  8, 2004
 * @version Jan. 24, 2006
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class USmartDoc {
    public static SDTable makeTable(IRTree head, IRTable body) {
        D2Array bodyTable = new D2Array();
        int height = body.getHeight();
        int width = body.getWidth();
        for (int y = 0;y < height;y++) {
            for (int x = 0; x < width;x++) {
                bodyTable.put(x, y, body.get(x, y));
            }
        }
        if (head == null || head instanceof TreeTable) {
            System.out.println("head = " + head);
            return makeTable((TreeTable)head, bodyTable);
        } else {
            TreeTableMaker maker = new TreeTableMaker();
            head.traverse(maker);
            TreeTable headTable = maker.getTreeTable();
            return makeTable(headTable, bodyTable);
        }
    }

    public static class TreeTableMaker implements IRTreeVisitor {
        private TreeTable tree_ = new TreeTable();
        private final Cursor cursor_;

        public TreeTableMaker() {
            cursor_ = tree_.getCursor();
        }

        public TreeTable getTreeTable() {
            return tree_;
        }

        public boolean start(IRTreeNode node) {
            return true;
        }

        public void end(IRTreeNode node) {
        }

        public boolean enter(IRTreeNode node) {
            cursor_.add(node.getContent());
            cursor_.enter();
            return true;
        }

        public boolean stay(IRTreeNode node, int index, IRTreeNode prev, IRTreeNode next) {
            return true;
        }

        public void leave(IRTreeNode node) {
            cursor_.leave();
        }
    }

    // remains in util.
    public static SDTable makeTable(String[] header, D2Array body) {
        SDTable table = new SDTable();
        SDThead thead = new SDThead();
        table.setThead(thead);
        SDHeadTr tr = new SDHeadTr();
        thead.setHeadTr(tr);
        for (int i = 0; i < header.length; i++) {
            SDTh th = new SDTh();
            th.setContent(header[i]);
            tr.addTh(th);
        }
        buildTableBody_(body, table);
        return (table);
    }

    public static SDTable makeTable(TreeTable head, D2Array body) {
        SDTable table = new SDTable();
        buildTableHead_(head, table);
        buildTableBody_(body, table);
        return table;
    }

    private static void buildTableHead_(TreeTable head, SDTable table) {
        if (head == null) {
            return;
        }
        SDThead thead = new SDThead();
        table.setThead(thead);
        if (head.getHeight() > 1) {
            System.out.println("buildTableHead_");
        }
        D2Array data = head.getCoarseTable();
        D2Array rowspans = head.getRowSpanTable();
        D2Array colspans = head.getColSpanTable();
        int width = data.getWidth();
        int height = data.getHeight();
        for (int y = 0;y < height;y++) {
            SDHeadTr tr = new SDHeadTr();
            thead.addHeadTr(tr);
            for (int x = 0;x < width;x++) {
                Integer rowValue = (Integer)rowspans.get(x, y);
                Integer colValue = (Integer)colspans.get(x, y);
                if (rowValue != null && colValue != null) {
                    SDTh th = new SDTh();
                    tr.addTh(th);
                    int rowspan = rowValue.intValue();
                    int colspan = colValue.intValue();
                    if (rowspan != 1) {
                        th.setRowspan(rowspan);
                    }
                    if (colspan != 1) {
                        th.setColspan(colspan);
                    }
                    String value = (String)data.get(x, y);
                    if (value == null) {
                        throw new UnsupportedOperationException();
                    }
                    th.setContent(value);
                } else if (rowValue == null && colValue == null) {
                    continue;
                } else {
                    throw new UnsupportedOperationException();
                }
            }
        }
    }

    private static void buildTableBody_(D2Array body, SDTable table) {
        SDTbody tbody = new SDTbody();
        table.setTbody(tbody);
        int height = body.getHeight();
        int width = body.getWidth();
        for (int y = 0;y < height;y++) {
            SDBodyTr bodyTr = new SDBodyTr();
            tbody.addBodyTr(bodyTr);
            for (int x = 0;x < width;x++) {
                SDTd td = new SDTd();
                bodyTr.addContent(td);
                Object value = body.get(x, y);
                if (value == null) {
                    td.setContent("N/A");
                } else if (value instanceof String) {
                    td.setContent((String)value);
                } else {
                    td.setContent((ISDClassContentMixed[])value);
                }
            }
        }
    }

    public static void setColumnWidth(SDTable table, int[] widths) {
        SDColgroup colgroup = new SDColgroup();
        table.addColgroup(colgroup);
        colgroup.setFormat("plain");
        for (int i = 0;i < widths.length;i++) {
            int width = widths[i]; 
            SDCol col = new SDCol();
            colgroup.addCol(col);
            if (width > 0) {
                col.setWidth(width + "ex");
            }
        }
    }

    public static SDDl makeDl(Map map) {
        SDDl sDl = new SDDl();
        Object[] entries = map.entrySet().toArray();
        for (int i = 0;i < entries.length;i++) {
            Map.Entry entry = (Map.Entry)entries[i];
            String key = entry.getKey().toString();
            String value = getValue_(entry.getValue()); 
            SDDlEntry seq = new SDDlEntry();
            SDDt sDt = new SDDt();
            sDt.setContent(key);
            seq.setDt(sDt);
            SDDd sDd = new SDDd();
            sDd.setContent(value);
            seq.setDd(sDd);
            sDl.addDlEntry(seq);
        }
        return (sDl);
    }

    private static String getValue_(Object value) {
        if (value == null) {
            return "N/A";
        } else {
            return value.toString();
        }
    }

    public static SDUl makeUl(String[] list) {
        SDUl sUl = new SDUl();
        for (int i = 0;i < list.length;i++) {
            SDLi sLi = new SDLi();
            sLi.setContent(list[i]);
            sUl.addListContent(sLi);
        }
        return (sUl);
    }

    public static String makeCommaListText(String[] tokens) {
        StringBuffer sb = new StringBuffer();
        if (tokens.length > 0) {
            sb.append(tokens[0]);
            for (int i = 1;i < tokens.length;i++) {
                sb.append(", ");
                sb.append(tokens[i]);
            }
        }
        return sb.toString();
    }
}
