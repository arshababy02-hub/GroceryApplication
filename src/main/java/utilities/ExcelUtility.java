package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.util.Constants;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Contants;

public class ExcelUtility {
	static FileInputStream f; // excel file
	static XSSFWorkbook w; // Book1
	static XSSFSheet s;// sheets

	public static String getStringData(int a, int b, String sheet) throws IOException // a is row ,b is column or cell
	{
		String filepath = Contants.TESTDATAFILE;
		f = new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(a);
		XSSFCell c = r.getCell(b);
		return c.getStringCellValue(); // inbuilt method for excelsheet connection
	}

	public static String getIntegerData(int a, int b, String sheet) throws IOException {
		String filepath = Contants.TESTDATAFILE;
		f = new FileInputStream(filepath);

		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(a);
		XSSFCell c = r.getCell(b);// 10
		int y = (int) c.getNumericCellValue();// string - integer = typecasting
		return String.valueOf(y);
	}

}
