package org.relaxer.framework.runtime.models.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.relaxer.framework.runtime.model.AbstractRMapModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.IRTableModel;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;
import org.relaxer.framework.runtime.models.workspace.WorkspaceBag;
import org.relaxer.framework.runtime.models.workspace.WorkspaceContent;

import com.AsamiOffice.util.ArrayMap;

/**
 * ExcelBookModel
 *
 * @since   Aug. 10, 2005
 * @version Aug. 17, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ExcelBookModel extends AbstractRMapModel {
    private HSSFWorkbook workbook_ = null;
    private ArrayMap sheets_ = new ArrayMap();

    public ExcelBookModel(IRModelContext context) throws RModelException {
        super(context);
    }

    public ExcelBookModel(IRModelContent content, IRModelContext context) throws RModelException {
        super(content, context);
    }

    public ExcelBookModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

    public ExcelBookModel(File file, IRModelContext context) throws RModelException {
        super(context);
        setProperty(PROPERTY_FILE, file);
    }

    public ExcelBookModel(Map properties, IRModelContext context) throws RModelException {
        super(properties, context);
    }

    protected void _open() throws RModelException {
        InputStream in = null;
        try {
            IRDataSource ds = _getDataSource();
            if (!ds.isExist()) {
                workbook_ = new HSSFWorkbook();
            } else {
                in = _getDataSource().openInputStream();
                workbook_ = new HSSFWorkbook(in);
                int nSheets = workbook_.getNumberOfSheets();
                for (int i = 0;i < nSheets;i++) {
                    ExcelSheetModel sheet = new ExcelSheetModel(workbook_.getSheetAt(i), this, _context);
                    sheet.open();
                    sheets_.put(sheet.getName(), sheet);
                }
            }
        } catch (FileNotFoundException e) {
            throw open_error_(e);
        } catch (IOException e) {
            throw open_error_(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private RModelException open_error_(Exception e) {
        return new RModelException(e);
    }

    protected void _close() throws RModelException {
//        System.out.println("should close excel book model");
        /* XXX
        int nSheets = workbook_.getNumberOfSheets();
        for (int i = 0;i < nSheets;i++) {
            ExcelSheetModel sheet = new ExcelSheetModel(workbook_.getSheetAt(i), this, _context);
            sheet.close();
        }*/
        workbook_ = null;
    }

    protected void _commitDirty_map() throws RModelException {
        commitSheets_();
        OutputStream out = null;
        try {
            out = _getDataSource().openOutputStream();
            workbook_.write(out);
            out.flush();
        } catch (FileNotFoundException e) {
            throw commit_error_(e);
        } catch (IOException e) {
            throw commit_error_(e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
            }
        }
    }

    private void commitSheets_() throws RModelException {
        Object[] sheets = sheets_.toValueArray();
        for (int i = 0;i < sheets.length;i++) {
            ExcelSheetModel sheet = (ExcelSheetModel)sheets[i];
            sheet.commit();
        }
    }

    private void flushSheets_() throws RModelException {
        Object[] sheets = sheets_.toValueArray();
        for (int i = 0;i < sheets.length;i++) {
            ExcelSheetModel sheet = (ExcelSheetModel)sheets[i];
            sheet.flush();
        }
    }

    private RModelException commit_error_(Exception e) {
        return new RModelException(e);
    }

    protected void _create() throws RModelException {
        try {
            _getDataSource().create();
            workbook_ = new HSSFWorkbook();
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

    protected void _delete() throws RModelException {
        // TODO
    }

    protected boolean _isDirty() {
        Object[] sheets = sheets_.toValueArray();
        for (int i = 0;i < sheets.length;i++) {
            ExcelSheetModel sheet = (ExcelSheetModel)sheets[i];
            if (sheet.isDirty()) {
                return true;
            }
        }
        return false;
    }

/*
    protected void _addExcelSheet(ExcelSheetModel sheet) {
        // TODO
    }
*/
    

    public void addTableModel(IRTableModel table) throws RModelException {
        String tableName = table.getName();
        if (tableName != null) {
            ExcelSheetModel sheet = createSheetModel(tableName);
            sheet.setTable(table);
        } else {
            ExcelSheetModel sheet = createSheetModel();
            sheet.setTable(table);
        }
    }
/*
        String sheetName = table.getName();
        HSSFSheet sheet;
        if (sheetName != null) {
            sheet = workbook_.createSheet(sheetName);
        } else {
            sheet = workbook_.createSheet();
        }
        short width = (short)table.getWidth();
        int height = table.getHeight();
        int[] spans = new int[width];
        D2Array array = new D2Array();
        for (int y = 0;y < height;y++) {
            for (int x = 0;x < width;x++) {
                IRModelNode node = table.get(x, y);
                if (node != null) {
                    IRModelContent content = node.getContent();
                    if (content != null) {
                        String string = content.getString();
                        array.put(x, y, string);
                        int length = string.length();
                        spans[x] = Math.max(spans[x], length); 
                    }
                }
            }
        }
        for (short x = 0;x < width;x++) {
            short span = calcColumnWidth_(spans[x]);
            if (span > 0) {
                sheet.setColumnWidth(x, calcColumnWidth_(span));
            }
        }
        for (int y = 0;y < height;y++) {
            HSSFRow row = sheet.createRow(y);
            for (short x = 0;x < width;x++) {
                String value = (String)array.get(x, y);
                if (value != null) {
                    HSSFCell cell = row.createCell(x);
                    cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                    cell.setCellValue(value);
                }
            }
        }
    }

    private short calcColumnWidth_(int length) {
        if (length <= 5) {
            return 0;
        }
        return (short)(length * CHARACTER_UNIT_NUMBER);
    }
*/

    public void set(Object key, IRModelNode value) throws RModelException {
        throw new UnsupportedOperationException();
    }

    public IRModelNode get(Object key) throws RModelException {
        throw new UnsupportedOperationException();
    }

    public void setTableModel(IRTableModel tableModel) throws RModelException {
        // TODO : clear sheets list
        addTableModel(tableModel);
    }

    protected IRModelContent _getModelContent_map() throws RModelException {
        flushSheets_();
        WorkspaceBag bag = new WorkspaceBag();
        OutputStream out = null;
        try {
            out = bag.openOutputStream();
            workbook_.write(out);
            out.flush();
        } catch (IOException e) {
            throw new RModelException(e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        WorkspaceContent content = new WorkspaceContent(bag, _context);
        return content;
//        return new ExcelBookContent(this, _getDataSource(), _context);
    }

/*
    // XXX : IRModel(?)
    public InputStream openInputStream() throws RModelException {
        commit();
         try {
             ByteArrayOutputStream out = new ByteArrayOutputStream();
             workbook_.write(out);
             byte[] bytes = out.toByteArray();
             ByteArrayInputStream in = new ByteArrayInputStream(bytes);
             return in;
         } catch (IOException e) {
             throw new RModelException(e);
         }
    }
*/

    public HSSFWorkbook getWorkbook() {
        return workbook_;
    }

    public ExcelSheetModel getFirstSheet() {
        if (sheets_.size() == 0) {
            return null;
        }
        return (ExcelSheetModel)sheets_.get(0);
    }

    public ExcelSheetModel createSheetModel() throws RModelException {
        ExcelSheetModel sheet = new ExcelSheetModel(this, _context);
        sheets_.put(sheet.getName(), sheet);
        _setDirty();
        return sheet;
    }

    public ExcelSheetModel createSheetModel(String tableName) throws RModelException {
        ExcelSheetModel sheet = new ExcelSheetModel(tableName, this, _context);
        sheets_.put(sheet.getName(), sheet);
        _setDirty();
        return sheet;
    }
}
