	package utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ReadExcelData {

	/*public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub				//main method here just to test if it can read the data , otherwise remove method method from here iin framwrok

		
		ReadExcelData rd=new ReadExcelData();		
		rd.getData("login");}
*/

	@DataProvider(name="amzdata")
 	public String[][] getData( Method m) throws EncryptedDocumentException,IOException, InterruptedException
	{
		String excelsheetname= m.getName();
		Thread.sleep(5000);
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
	// Workbook wb=new WorkbookFactory.create(fis);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheetname=wb.getSheet(excelsheetname);
		
		int rownum=sheetname.getLastRowNum();
		System.out.println(rownum);
		Row rowcell=sheetname.getRow(0);	
		
		int colmncount=rowcell.getLastCellNum();
		System.out.println(colmncount);
		DataFormatter db=new DataFormatter();
		
		String testData[][]=new String[rownum][colmncount];
		for(int i=1;i<=rownum;i++) {
			
			for(int j=0;j<colmncount;j++) {
				testData[i-1][j]=db.formatCellValue(sheetname.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}	
		}	
		return testData;
	}


}
