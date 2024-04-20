package utilities.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{
    public static String read(int RowNumber, int ColumnNumber, String filePath) throws IOException
    {
        //Excel Initialization
        String Keyword = "2";
        String TCPath = System.getProperty("user.dir")+filePath;
        File Login = new File(TCPath);
        FileInputStream fip = new FileInputStream(Login);
        XSSFWorkbook wb = new XSSFWorkbook(fip); //HSSFWorkbook for xls format, XSSFWorkbook for xlsx format

        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(RowNumber);
        //Iterator<Row> rowIt = sheet.rowIterator();

        //while(rowIt.hasNext())
        //{
        //row = rowIt.next();
        Cell cell = row.getCell(ColumnNumber);
        //Iterator<Cell> cellIt = row.cellIterator();

        if (Keyword != null && cell != null) //for NullPoiterException
            Keyword = cell.getStringCellValue();
        //while(cellIt.hasNext())
        //{
        //cell = cellIt.next();
        //}
        //}
        return Keyword;
    }

    public static void main( String[] args ) throws IOException
    {
        ExcelReader ExcelObj = new ExcelReader();
        String KeywordValue = "1";
        for (int i = 2; i< 7; i++)
        {
            for (int j = 3; j< 5; j++)
            {
                KeywordValue = ExcelObj.read(2, j, "");
                System.out.println(KeywordValue);
            }
        }
    }
}