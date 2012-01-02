/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2001  ASAMI, Tomoharu (asami@zeomtech.com)
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

package org.xmlsmartdoc.SmartDoc;

import java.util.*;
import org.w3c.dom.Element;

import com.AsamiOffice.util.D2Array;

import org.xmlsmartdoc.SmartDoc.adapter.CSVAdapter;

/**
 * Table
 *
 * @since   Sep. 29, 1998
 * @version Jun. 13, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class Table extends FloatingObject {
    protected D2Array head_ = new D2Array();
    protected D2Array data_ = new D2Array();
    protected D2Array foot_ = new D2Array();
    protected List colgroups_ = new ArrayList(); // List<Colgroup>
    protected List rowgroups_ = new ArrayList(); // List<Colgroup>
    protected List cols_ = new ArrayList(); // List<Col>
    protected THead thead_;
    protected TFoot tfoot_;
    protected TBody tbody_;
    protected Tnote tnote_;
    protected PTable ptable_;
    transient protected int ty_ = 0;
    transient protected int y_ = 0;
    protected String src_;
    protected String srctype_;

    public Table() {
    }

    public Table(Element element) {
	super(element);
	if (sequenceNumber_ == null) {
	    sequenceNumber_ = new SequenceNumber("table");
	}
    }

    // Content
    public int getEntityType() {
	return (ENTITY_BLOCK);
    }

    // Container
    public void format() {
	super.format();
	_buildTable();
	_adjustTableHead();
	_adjustTableFoot();
	_adjustTableData();
	_rebuildTHeadTree();	// for index
	_rebuildTFootTree();	// for index
	_rebuildTDataTree();	// for index
	_buildMetaInfo();
	_setupData();
	if (rowgroups_.size() > 1) {
	    _buildPTable();
	}
    }

    public Rowgroup[] getRowgroups() {
	Rowgroup[] rowgroups = new Rowgroup[rowgroups_.size()];
	return ((Rowgroup[])rowgroups_.toArray(rowgroups));
    }

    public Colgroup[] getColgroups() {
	Colgroup[] colgroups = new Colgroup[colgroups_.size()];
	return ((Colgroup[])colgroups_.toArray(colgroups));
    }

    public Col[] getCols() {
	Col[] cols = new Col[cols_.size()];
	return ((Col[])cols_.toArray(cols));
    }

    public THead getTHead() {
	return (thead_);
    }

    public TFoot getTFoot() {
	return (tfoot_);
    }

    public TBody getTBody() {
	return (tbody_);
    }

    /**
     * This method is available after format().
     */
    public int getWidth() {
	return (data_.getWidth());
    }

    /**
     * This method is available after format().
     */
    public int getHeight() {
	return (data_.getHeight());
    }

    /**
     * This method is available after format().
     */
    public Tnote getTnote() {
	return (tnote_);
    }

    /**
     * This method is available after format().
     */
    public PTable getPTable() {
	return (ptable_);
    }

    public D2Array getHeadData() {
	if (head_.getHeight() > 0) {
	    return (head_);
	} else {
	    return (null);
	}
    }

    public D2Array getFootData() {
	if (foot_.getHeight() > 0) {
	    return (foot_);
	} else {
	    return (null);
	}
    }

    public D2Array getBodyData() {
	if (data_.getHeight() > 0) {
	    return (data_);
	} else {
	    return (null);
	}
    }

    /**
     * @deprecated
     */
    public Th getTh(int x, int y) {
	if (x >= head_.getWidth()) {
	    return (null);
	}
	if (y >= head_.getHeight()) {
	    return (null);
	}
	return ((Th)head_.get(x, y));
    }

    /**
     * @deprecated
     */
    public Td getTd(int x, int y) {
	if (x >= data_.getWidth()) {
	    return (null);
	}
	if (y >= data_.getHeight()) {
	    return (null);
	}
	return ((Td)data_.get(x, y));
    }

    public TrContent getCell(int x, int y) {
	if (x >= data_.getWidth()) {
	    return (null);
	}
	if (y >= data_.getHeight()) {
	    return (null);
	}
	return ((TrContent)data_.get(x, y));
    }

    public String getClazz(int x, int y) {
	TrContent cell = getCell(x, y);
	if (cell != null) {
	    String type = cell.getClazz();
	    if (type != null) {
		return (type);
	    }
	}
	Col col = (Col)cols_.get(x);
	return (col.getClazz());
    }

    public String getAlign(int x, int y) {
	TrContent cell = getCell(x, y);
	if (cell != null) {
	    String type = cell.getAlign();
	    if (type != null) {
		return (type);
	    }
	}
	Col col = (Col)cols_.get(x);
	return (col.getAlign());
    }

    protected void _buildTable() {
	Content[] contents = getContents();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    content.format();
	    if (content instanceof Rowgroup) {
		Rowgroup rowgroup = (Rowgroup)content;
		rowgroup.setTable(this);
		rowgroups_.add(rowgroup);
	    } else if (content instanceof Colgroup) {
		Colgroup colgroup = (Colgroup)content;
		colgroup.setTable(this);
		colgroups_.add(colgroup);
	    } else if (content instanceof THead) {
		_buildTHead((THead)content);
	    } else if (content instanceof TFoot) {
		_buildTFoot((TFoot)content);
	    } else if (content instanceof TBody) {
		_buildTBody((TBody)content);
	    } else if (content instanceof Tnote) {
		_buildTnote((Tnote)content);
	    } else if (content instanceof CharBlock) {
		// do nothing
	    } else {
		_warning("bad tag : " + content.toString());
	    }
	}
    }

/*
    protected void _buildTableFromSrc(String src, IAdapter adapter) {
	throw (new UnsupportedOperationException());
    }

    protected void _buildHeadFromSrc(String src, IAdapter adapter) {
	if (adapter == null) {
	    return;
	}
	SmartDocTableModel model = adapter.getTable(src, null);
	_buildHeadFromTableModel(model);
    }

    protected void _buildHeadFromText(String text, Adapter adapter) {
	if (adapter == null) {
	    return;
	}
	SmartDocTableModel model = adapter.parseTable(text, null);
	_buildHeadFromTableModel(model);
    }

    protected void _buildHeadFromTableModel(SmartDocTableModel model) {
	int width = model.getColumnCount();
	int height = model.getRowCount();
	for (int y = 0;y < height;y++) {
	    for (int x = 0;x < width;x++) {
		Object head = model.getValueAt(y, x);
		if (head != null) {
		    Th th = new Th(head.toString());
		    head_.put(x, y, th);
		}
	    }
	    ty_++;
	}
    }
*/

    protected void _adjustTableHead() {
	head_ = _adjustData(head_);
    }

    protected void _adjustTableFoot() {
	foot_ = _adjustData(foot_);
    }

    protected void _adjustTableData() {
	data_ = _adjustData(data_);
    }

    /**
     * adjust position of TrContent using rowspan.
     */
    protected D2Array _adjustData(D2Array data) {
	D2Array newData = new D2Array();
	int width = data.getWidth();
	int height = data.getHeight();
	int tableWidth = 0;	// XXX : more precisely
	for (int y = 0;y < height;y++) {
	    int w = 0;
	    for (int x = 0;x < width;x++) {
		TrContent cell = (TrContent)data.get(x, y);
		if (cell == null) {
		    w++;
		} else {
		    w += cell.getColSpan();
		}
	    }
	    tableWidth = Math.max(tableWidth, w);
	}
	int tableHeight = 0;	// XXX : more precisely
	for (int x = 0;x < width;x++) {
	    int h = 0;
	    for (int y = 0;y < height;y++) {
		TrContent cell = (TrContent)data.get(x, y);
		if (cell == null) {
		    h++;
		} else {
		    h += cell.getRowSpan();
		}
	    }
	    tableHeight = Math.max(tableHeight, h);
	}
	int[] currentYs = new int[tableWidth];
	Arrays.fill(currentYs, 0);
	for (int y = 0;y < height;y++) {
	    int currentX = 0;
	    for (int x = 0;x < width;x++) {
		for (;;) {
		    if (currentX != tableWidth &&
			currentYs[currentX] > y) {
			    currentX++;
		    } else {
			break;
		    }
		}
		if (currentX == tableWidth) {
		    break;
		}
		TrContent cell = (TrContent)data.get(x, y); // XXX : TrContent
		if (cell == null) {
		    continue;
		}
		int rowSpan = cell.getRowSpan();
		int colSpan = cell.getColSpan();
		newData.put(currentX, y, cell);
		int last = currentX + colSpan;
		for (int i = currentX;i < last;i++) {
		    currentYs[i] += rowSpan;
		}
		currentX += colSpan;
	    }
	}
	return (newData);
    }

/*
    protected void _buildDataFromSrc(String src, Adapter adapter) {
	if (adapter == null) {
	    return;
	}
	SmartDocTableModel model = adapter.getTable(src, null);
	_buildDataFromTableModel(model);
    }

    protected void _buildDataFromText(String text, Adapter adapter) {
	if (adapter == null) {
	    return;
	}
	SmartDocTableModel model = adapter.parseTable(text, null);
	_buildDataFromTableModel(model);
    }

    protected void _buildDataFromTableModel(SmartDocTableModel model) {
	int width = model.getColumnCount();
	int height = model.getRowCount();
	for (int y = 0;y < height;y++) {
	    for (int x = 0;x < width;x++) {
		Object data = model.getValueAt(y, x);
		if (data != null) {
		    Td td = new Td(data.toString());
		    data_.put(x, y, td);
		}
	    }
	    y_++;
	}
    }
*/

    /**
     * adjust position of TrContent using rowspan.
     */
    protected void _adjustTableData0() {
	D2Array data = new D2Array();
	int width = data_.getWidth();
	int height = data_.getHeight();
	int tableWidth = 0;	// XXX : more precisely
	for (int y = 0;y < height;y++) {
	    int w = 0;
	    for (int x = 0;x < width;x++) {
		Td td = (Td)data_.get(x, y);
		if (td == null) {
		    w++;
		} else {
		    w += td.getColSpan();
		}
	    }
	    tableWidth = Math.max(tableWidth, w);
	}
	int tableHeight = 0;	// XXX : more precisely
	for (int x = 0;x < width;x++) {
	    int h = 0;
	    for (int y = 0;y < height;y++) {
		Td td = (Td)data_.get(x, y);
		if (td == null) {
		    h++;
		} else {
		    h += td.getRowSpan();
		}
	    }
	    tableHeight = Math.max(tableHeight, h);
	}
	int[] currentYs = new int[tableWidth];
	Arrays.fill(currentYs, 0);
	for (int y = 0;y < height;y++) {
	    int currentX = 0;
	    for (int x = 0;x < width;x++) {
		for (;;) {
		    if (currentX != tableWidth &&
			currentYs[currentX] > y) {
			    currentX++;
		    } else {
			break;
		    }
		}
		if (currentX == tableWidth) {
		    break;
		}
		Td td = (Td)data_.get(x, y); // XXX : TrContent
		if (td == null) {
		    continue;
		}
		int rowSpan = td.getRowSpan();
		int colSpan = td.getColSpan();
		data.put(currentX, y, td);
		int last = currentX + colSpan;
		for (int i = currentX;i < last;i++) {
		    currentYs[i] += rowSpan;
		}
		currentX += colSpan;
	    }
	}
	data_ = data;
//System.out.println(data_);
    }

    protected void _rebuildTHeadTree() {
	if (head_.getWidth() > 0) {
	    if (thead_ == null) {
		thead_ = new THead();
	    }
	    _rebuildTree(thead_, head_);
	}
    }

    protected void _rebuildTFootTree() {
	if (foot_.getWidth() > 0) {
	    if (tfoot_ == null) {
		tfoot_ = new TFoot();
	    }
	    _rebuildTree(tfoot_, foot_);
	}
    }

    protected void _rebuildTDataTree() {
	if (data_.getWidth() > 0) {
	    if (tbody_ == null) {
		tbody_ = new TBody();
	    }
	    _rebuildTree(tbody_, data_);
	}
    }

    protected void _rebuildTree(Container parent, D2Array data) {
	if (parent == null) {
	    return;
	}
	parent.clearContents();
	if (data == null) {
	    return;
	}
	int width = data.getWidth();
	int height = data.getHeight();
	for (int y = 0;y < height;y++) {
	    Tr tr = null;
	    for (int x = 0;x < width;x++) {
		TrContent cell = (TrContent)data.get(x, y);
		if (cell != null) {
		    tr = (Tr)cell.getParent();
		    if (tr != null) {
			break;
		    }
		}
	    }
	    if (tr == null) {
		tr = new Tr();
	    }
	    tr.clearContents();
	    for (int x = 0;x < width;x++) {
		TrContent cell = (TrContent)data.get(x, y);
		if (cell != null) {
		    tr.addContent(cell);
		}
	    }
	    parent.addContent(tr);
	}
    }

    protected void _buildTHead(THead thead) {
	thead_ = thead;
	D2Array data = new D2Array();
	Content[] contents = thead.getContents();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Tr) {
		_buildRecord((Tr)content, data);
	    } else if (content instanceof Ul) {
		_buildTree((Ul)content, data, Th.class);
//_debugData(data);
		data = data.transpose(); // XXX : really append
		int width = data.getWidth();
		int height = data.getHeight();
		for (int y = 0;y < height;y++) {
		    for (int x = 0;x < width;x++) {
			TrContent cell = (TrContent)data.get(x, y);
			if (cell != null) {
			    int colspan = cell.getColSpan();
			    int rowspan = cell.getRowSpan();
			    cell.setColSpan(rowspan);
			    cell.setRowSpan(colspan);
			}
		    }
		}
//_debugData(data);
	    } else if (content instanceof CharBlock) {
		// do nothing
	    } else {
		_warning("bad tag : " + content.toString());
	    }
	}
	head_ = data;
    }

    protected void _debugData(D2Array data) {
	int width = data.getWidth();
	int height = data.getHeight();
	for (int y = 0;y < height;y++) {
	    for (int x = 0;x < width;x++) {
		TrContent cell = (TrContent)data.get(x, y);
		if (cell == null) {
		    System.out.print("null");
		} else {
		    if (cell instanceof Th) {
			System.out.print("th[");
		    } else if (cell instanceof Td) {
			System.out.print("td[");
		    } else {
			throw (new InternalError());
		    }
		    System.out.print(cell.getColSpan());
		    System.out.print("/");
		    System.out.print(cell.getRowSpan());
		    System.out.print("]");
		}
		System.out.print(",");
	    }
	    System.out.println();
	}
    }

    protected void _buildRecord(Tr tr, D2Array data) {
	Content[] contents = tr.getContents();
	int x = 0;
	int y = data.getHeight(); // append
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof TrContent) {
		data.put(x++, y, content);
	    } else if (content instanceof CharBlock) {
		// do nothing
	    } else {
		_warning("bad tag : " + content.toString());
	    }
	}
    }

    protected void _buildTree(Ul ul, D2Array data, Class cellType) {
	_buildTree(ul, 0, data.getHeight(), data, cellType);
	// adjust tree
	int width = data.getWidth();
	int height = data.getHeight();
	for (int y = 0;y < height;y++) {
	    TrContent prev = null;
	    for (int x = 0;x < width;x++) {
		TrContent cell = (TrContent)data.get(x, y);
		if (cell == null) {
		    if (prev != null) {
			int span = prev.getColSpan();
			span += width - (x - 1 + span);
			prev.setColSpan(span);
			break;
		    }
		} else {
		    prev = cell;
		}
	    }
	}
    }

    protected int _buildTree(
	Ul ul,
	int x,
	int y,
	D2Array data,
	Class cellType
    ) {
	Content[] contents = ul.getContents();
	int span = 0;
	TrContent cell = null;
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Li) {
		cell = _buildTree((Li)content, x, y, data, cellType);
		int subspan = cell.getRowSpan();
		span = span + subspan;
		y = y + subspan;
	    } else if (content instanceof Tr) {
		// assume tr doesn't have ul entry.
		Content[] cells = ((Tr)content).getContents();
		for (int j = 0;j < cells.length;j++) {
		    if (cells[j] instanceof TrContent) {
			cell = (TrContent)cells[j];
			data.put(x + j, y, cell);
		    }
		}
		y++;
		span++;
	    } else if (content instanceof Ul) {
		// ul is appeared in ul only if followed li and li has no ul
		if (y == 0) {	// pre-condition
		    throw (new InternalError());
		}
		int subspan
		    = _buildTree((Ul)content, x + 1, y - 1, data, cellType);
		cell.setRowSpan(subspan);
		if (subspan > 0) {
		    span = span + subspan - 1;
		    y = y + subspan - 1;
		}
	    } else if (content instanceof CharBlock) {
		// do nothing
	    } else {
		_warning("bad tag : " + content.toString());
	    }
	}
	return (span);
    }

    protected TrContent _buildTree(
	Li li,
	int x,
	int y,
	D2Array data,
	Class cellType
    ) {
	Content[] contents = li.getContents();
	int span = 0;
	TrContent cell = _getCell(cellType);
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Ul) {
		int subspan
		    = _buildTree((Ul)content, x + 1, y, data, cellType);
		cell.setRowSpan(subspan);
		span = span + subspan - 1;
	    } else if (content instanceof CharBlock) {
		cell.addContent(content);
	    } else if (content instanceof Sentence) {
		cell.addContent(content);
	    } else {
		_warning("bad tag : " + content.toString());
	    }
	}
	data.put(x, y, cell);
	return (cell);
    }

    protected TrContent _getCell(Class cellType) {
	try {
	    return ((TrContent)cellType.newInstance());
	} catch (IllegalAccessException e) {
	    throw (new InternalError());
	} catch (InstantiationException e) {
	    throw (new InternalError());
	}
    }

/*
    protected int _buildHeadTree0(Ul ul, int x) { // XXX : should correct
	Content[] contents = ul.getContents();
	int span = 0;
	Th th = null;
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Ul) {
		ty_--;
		int subspan = _buildHeadTree((Ul)content, x + 1);
		th.setRowSpan(subspan);
		span = span + subspan - 1;
	    } else if (content instanceof Li) {
		span++;
		th = new Th();
		th.addContents(((Li)content).getContents());
		head_.put(x, ty_++, th);
	    } else if (content instanceof Tr) {
		span++;
		// assume tr doesn't have ul entry.
		Content[] ths = ((Tr)content).getContents();
		for (int j = 0;j < ths.length;j++) {
		    if (ths[j] instanceof Th) {
			th = (Th)ths[j];
			head_.put(x + j, ty_, th);
		    }
		}
		ty_++;
	    } else if (content instanceof CharBlock) {
		// do nothing
	    } else {
		_warning("bad tag : " + content.toString());
	    }
	}
	return (span);
    }
*/

    protected void _buildTFoot(TFoot tfoot) {
	tfoot_ = tfoot;
	D2Array data = new D2Array();
	Content[] contents = tfoot.getContents();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Tr) {
		_buildRecord((Tr)content, data);
	    } else if (content instanceof Ul) {
		_buildTree((Ul)content, data, Th.class);
		data = data.rotateLeft(); // XXX : really append
		int width = data.getWidth();
		int height = data.getHeight();
		for (int y = 0;y < height;y++) {
		    for (int x = 0;x < width;x++) {
			TrContent cell = (TrContent)data.get(x, y);
			if (cell != null) {
			    int colspan = cell.getColSpan();
			    int rowspan = cell.getRowSpan();
			    cell.setColSpan(rowspan);
			    cell.setRowSpan(colspan);
			}
		    }
		}
	    } else if (content instanceof CharBlock) {
		// do nothing
	    } else {
		_warning("bad tag : " + content.toString());
	    }
	}
	foot_ = data;
    }

    protected void _buildTBody(TBody tbody) {
	tbody_ = tbody;
	D2Array data = new D2Array();
	Content[] contents = tbody.getContents();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Tr) {
		_buildRecord((Tr)content, data);
	    } else if (content instanceof Ul) {
		_buildTree((Ul)content, data, Td.class);
	    } else if (content instanceof CharBlock) {
		// do nothing
	    } else {
		_warning("bad tag : " + content.toString());
	    }
	}
	data_ = data;
    }

    // XXX : re-make for more precise rendering
    protected void _buildTBody0(TBody tbody) {
	tbody_ = tbody;
/*	String src = tbody.getSrc();
	Adapter adapter = tbody.getAdapter();
	if (src != null) {
	    _buildDataFromSrc(src, adapter);
	    }*/
	Content[] contents = tbody.getContents();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Tr) {
		_buildDataRecord((Tr)content);
	    } else if (content instanceof Ul) {
		_buildDataTree((Ul)content);
	    } else if (content instanceof CharBlock) {
		// do nothing
	    } else {
		_warning("bad tag : " + content.toString());
	    }
	}
/*	String inlineText = tbody.getInlineText();
	if (inlineText != null) {
	    _buildDataFromText(inlineText, adapter);
	    }*/
    }

    protected void _buildDataRecord(Tr tr) {
	Content[] contents = tr.getContents();
	int x = 0;
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Td) {
		data_.put(x++, y_, content);
	    } else {
		_warning("bad tag : " + content.toString());
	    }
	}
	y_++;
    }

    protected void _buildDataTree(Ul ul) {
	Content[] contents = ul.getContents();
	int x = 0;
	Td td = null;
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Ul) {
		y_--;		// adjust for previous li
		td.setRowSpan(_buildDataTree((Ul)content, x + 1));
	    } else if (content instanceof Li) {
		td = new Td();
		td.addContents(((Li)content).getContents());
		data_.put(x, y_++, td);
	    } else if (content instanceof Tr) {
		// assume tr doesn't have ul entry.
		Content[] tds = ((Tr)content).getContents();
		for (int j = 0;j < tds.length;j++) {
		    if (tds[j] instanceof Td) {
			td = (Td)tds[j];
			data_.put(x + j, y_, td);
		    }
		}
		y_++;
	    } else {
		_warning("bad tag : " + content.toString());
	    }
	}
    }

    protected int _buildDataTree(Ul ul, int x) {
	Content[] contents = ul.getContents();
	int span = 0;
	Td td = null;
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Ul) {
		y_--;
		int subspan = _buildDataTree((Ul)content, x + 1);
		td.setRowSpan(subspan);
		span = span + subspan - 1;
	    } else if (content instanceof Li) {
		span++;
		td = new Td();
		td.addContents(((Li)content).getContents());
		data_.put(x, y_++, td);
	    } else if (content instanceof Tr) {
		span++;
		// assume tr doesn't have ul entry.
		Content[] tds = ((Tr)content).getContents();
		for (int j = 0;j < tds.length;j++) {
		    if (tds[j] instanceof Td) {
			td = (Td)tds[j];
			data_.put(x + j, y_, td);
		    }
		}
		y_++;
	    } else if (content instanceof CharBlock) {
		// do nothing
	    } else {
		_warning("bad tag : " + content.toString());
	    }
	}
	return (span);
    }

    protected void _buildTnote(Tnote tnote) {
	tnote_ = tnote;
    }

    protected void _buildMetaInfo() {
	int nColgroups = colgroups_.size();
	for (int i = 0;i < nColgroups;i++) {
	    Colgroup colgroup = (Colgroup)colgroups_.get(i);
	    Col[] cols = colgroup.getCols();
	    for (int j = 0;j < cols.length;j++) {
		cols_.add(cols[j]);
	    }
	}
	int width = Math.max(
	    _calcTabularWidth(data_),
	    _calcTabularWidth(head_)
	);
	width = Math.max(width, _calcTabularWidth(foot_));
	int nCols = cols_.size();
	if (nCols >= width) {
	    return;
	}
	Colgroup stub = new Colgroup();
	stub.setTable(this);
	for (int i = nCols;i < width;i++) {
	    Col col = new Col();
	    stub.addCol(col);
	    cols_.add(col);
	}
	colgroups_.add(stub);
    }

    private int _calcTabularWidth(D2Array tabular) {
	int width = tabular.getWidth();
	int height = tabular.getHeight();
	int result = width;
	for (int y = 0;y < height;y++) {
	    for (int x = width - 1;x >= 0;x--) {
		TrContent cell = (TrContent)tabular.get(x, y);
		if (cell != null) {
		    int recordWidth = x + cell.getColSpan();
		    result = Math.max(result, recordWidth);
		    break;
		}
	    }
	}
	return (result);
    }

    protected void _setupData() {
	_setupData(head_);
	_setupData(foot_);
	_setupData(data_);
    }

    protected void _setupData(D2Array data) {
	int width = data.getWidth();
	int height = data.getHeight();
	for (int y = 0;y < height;y++) {
	    for (int x = 0;x < width;x++) {
		TrContent cell = (TrContent)data.get(x, y);
		if (cell != null) {
		    cell.setCol((Col)cols_.get(x));
		}
	    }
	}
    }

    protected void _buildPTable() {
	ptable_ = new PTable(this);
    }
}
