package org.relaxer.framework.runtime.models.excel;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.relaxer.framework.RelaxerFrameworkErrorException;
import org.relaxer.framework.runtime.model.AbstractRTableModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.value.IRTree;

import com.AsamiOffice.util.D2Array;

/**
 * ExcelSheetModel
 *
 * @since   Aug. 12, 2005
 * @version Sep.  7, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ExcelSheetModel extends AbstractRTableModel {
    private static final int CHARACTER_UNIT_NUMBER = 256;
    private final ExcelBookModel bookModel_;
    private final HSSFWorkbook workbook_;
    private final HSSFSheet sheet_;

    public ExcelSheetModel(ExcelBookModel book, IRModelContext context) throws RModelException {
        this(book, null, context);
    }

    public ExcelSheetModel(ExcelBookModel book, Map properties, IRModelContext context) throws RModelException {
        this(null, book, properties, context);
    }

    public ExcelSheetModel(HSSFSheet sheet, ExcelBookModel book, IRModelContext context) throws RModelException {
        this(sheet, book, null, context);
    }

    public ExcelSheetModel(HSSFSheet sheet, ExcelBookModel book, Map properties, IRModelContext context) throws RModelException {
        super(properties, context);
        bookModel_ = book;
        workbook_ = book.getWorkbook();
        if (sheet != null) {
            sheet_ = sheet;
        } else {
            sheet_ = workbook_.createSheet();
        }
        setName(getSheetName_());
    }

    public ExcelSheetModel(String tableName, ExcelBookModel book, IRModelContext context) throws RModelException {
        this(null, book, null, context);
        setName(tableName); // TODO setName should change the name in the workbook.
    }

    protected void _open_table() throws RModelException {
        setName(getSheetName_());
        int nRows = sheet_.getPhysicalNumberOfRows();
        int y = 0;
        while (nRows > 0) {
            HSSFRow row = sheet_.getRow(y);
            if (row != null) {
                nRows--;
                int nColumns = row.getPhysicalNumberOfCells(); 
                short x = 0;
                while (nColumns > 0) {
                    HSSFCell cell = row.getCell(x);
                    if (cell != null) {
                        nColumns--;
                        String value = cell.getStringCellValue(); // XXX
                        setString(x, y, value); // XXX non dirty
                    }
                    x++;
                }
            }
            y++;
        }
    }

    protected void _commitDirty_table() throws RModelException {
        _flushTable();
//        bookModel_.commit();
    }

    protected void _rollback() throws RModelException {
    }

    protected void _close_table() throws RModelException {
    }

    public void flush() throws RModelException {
        _flushTable();
    }

    protected void _flushTable() throws RModelException {
        String sheetName = getName();
        String currentName = getSheetName_();
        if (!currentName.equals(sheetName)) {
            workbook_.setSheetName(getSheetNumber_(), sheetName);
        }
        short width = (short)getWidth();
        int height = getHeight();
        int[] spans = new int[width];
        D2Array array = new D2Array();
        boolean[] emptyRows = new boolean[height];
        for (int y = 0;y < height;y++) {
            emptyRows[y] = true;
            for (int x = 0;x < width;x++) {
                IRModelNode node = get(x, y);
                if (node != null) {
                    IRModelContent content = node.getContent();
                    if (content != null) {
                        String string = content.getText();
                        array.put(x, y, string);
                        int length = string.length();
                        spans[x] = Math.max(spans[x], length);
                        emptyRows[y] = false;
                    }
                }
            }
        }
        for (short x = 0;x < width;x++) {
            short span = calcColumnWidth_(spans[x]);
            if (span > 0) {
//                sheet_.setColumnWidth(x, calcColumnWidth_(span));
            }
//            sheet_.setColumnWidth(x, sheet_.getColumnWidth(x));
        }
        for (int y = 0;y < height;y++) {
            HSSFRow row = sheet_.getRow(y);
            if (emptyRows[y]) {
                if (row != null) {
                    sheet_.removeRow(row);
                }
                continue;
            }
            if (row == null) {
                row = sheet_.createRow(y);
            }
            for (short x = 0;x < width;x++) {
                String value = (String)array.get(x, y);
                HSSFCell cell = row.getCell(x);
                if (value != null) {
                    if (cell == null) {
                        cell = row.createCell(x);
                    }
                    cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                    cell.setCellValue(value);
                } else {
                    if (cell != null) {
                        row.removeCell(cell);
                    }
                }
            }
        }
    }

    private int getSheetNumber_() {
        int length = workbook_.getNumberOfSheets();
        for (int i = 0;i < length;i++) {
            HSSFSheet target = workbook_.getSheetAt(i);
            if (target == sheet_) {
                return i;
            }
        }
        throw new RelaxerFrameworkErrorException("???");
    }

    private String getSheetName_() {
        return workbook_.getSheetName(getSheetNumber_());
    }

    private short calcColumnWidth_(int length) {
        if (length <= 5) {
            return 0;
        }
//        return (short)length;
//        return (short)(length * CHARACTER_UNIT_NUMBER);
        return 0; // XXX
    }

    public void setHead(IRTree head) throws RModelException {
        throw new UnsupportedOperationException("ExcelSheetModel.setHead");
    }
}
