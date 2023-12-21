package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;
 

	/*public static FileInputStream f;
	   public static XSSFWorkbook w;
	   public static XSSFSheet s;
	   
	   
	   public static String readStringData(int i,int j) throws IOException
	   {
		   f=new FileInputStream(Constant.EXCEL_FILE_PATH);
		   w= new XSSFWorkbook(f);
		   System.out.println("excel");
		   s=w.getSheet("Logintest");
		   System.out.println("excel1");
		   Row r = s.getRow(i);
		   Cell c =r.getCell(j);
		   return c.getStringCellValue();
				    }
	   public static double readIntData(int i,int j) throws IOException 
	   {
		   f=new FileInputStream(Constant.EXCEL_FILE_PATH);
		   w= new XSSFWorkbook(f);
		   s=w.getSheet("Logintest");
		   Row r = s.getRow(i);
		   Cell c =r.getCell(j);
		   return c.getNumericCellValue();
	   }
	}*/
public class ExcelUtilities {
    private XSSFSheet sheet;
    private XSSFWorkbook workbook;

    public ExcelUtilities(String path, String sheetName) throws IOException {
        File src = new File(path);
        FileInputStream fi = new FileInputStream(src);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
    }
    
    
    public String getCellData(int row, int columnNo)
    {
        XSSFCell cell = sheet.getRow(row).getCell(columnNo);
      //  if (cell == null) {
       //     return "Cell is empty or null"; // Change this to any specific string you want
      //  }

        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cell.getNumericCellValue());
        } else {
        	//return "Unknown cell type";
        	return null;
        }
    }}

    
    




  /*  @DataProvider(name = "logdata")
    public String[][] getData(Method m) {
        String[][] testData = null;

        try {
            String excelSheetName = m.getName();
            File file = new File(Constant.EXCEL_FILE_PATH);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(excelSheetName);

            if (sheet != null) {
                int totalRows = sheet.getLastRowNum() + 1;
                Row headerRow = sheet.getRow(0);
                int totalCols = headerRow.getLastCellNum();

                DataFormatter formatter = new DataFormatter();
                testData = new String[totalRows - 1][totalCols];

                for (int i = 1; i < totalRows; i++) {
                    Row row = sheet.getRow(i);
                    if (row != null) {
                        for (int j = 0; j < totalCols; j++) {
                            if (row.getCell(j) != null) {
                                testData[i - 1][j] = formatter.formatCellValue(row.getCell(j));
                                System.out.println(testData[i - 1][j]);
                            } else {
                                testData[i - 1][j] = "";
                            }
                        }
                    }
                }
            }
            workbook.close();
        } catch (IOException | EncryptedDocumentException e) {
            e.printStackTrace();
        }
        if (testData == null) {
            testData = new String[0][0]; // Provide an empty 2D array if data retrieval fails
        }
        return testData;
    }
}*/
	