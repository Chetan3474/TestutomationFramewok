package base;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String excelsheetname) throws IOException {
		
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "C:\\Users\\Admin\\Desktop\\testdata.xls");
		XSSFWorkbook wb=new XSSFWorkbook(fis);		
		XSSFSheet sheetname=wb.getSheet(excelsheetname);	
		
				int rownum=sheetname.getLastRowNum();
				XSSFRow rowcell = sheetname.getRow(0);
				
			int	cellcount=rowcell.getLastCellNum();
		DataFormatter dt=new DataFormatter();	
		String testdata[][]=new String [rownum][cellcount];
		
		for(int i=1;i<=rownum;i++) {
			
			for(int j=0;j<=cellcount;j++) {
				
				testdata[i-1][j]=dt.formatCellValue(sheetname.getRow(rownum).getCell(cellcount));
			
				System.out.println(testdata[i-1][j]);
				
			}
		}
	}

}
