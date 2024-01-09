package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import constant.Constant;
public class DataProviderExcel {
	 @DataProvider(name = "logdata")
	    public String[][] getData(Method m)throws EncryptedDocumentException, IOException {
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
	}

