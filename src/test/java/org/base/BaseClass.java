package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.hc.client5.http.utils.DateUtils;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseClass {
	
public String getdata(int rowNumber,int cellNumber,String sheetName,String fileName) throws IOException {
	
	File f = new File("C:\\Users\\Admin\\eclipse\\MavenProject2\\File\\"+fileName+".xlsx");
	
	FileInputStream read = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(read);
	Sheet s = w.getSheet(sheetName);
	Row r = s.getRow(rowNumber);
	Cell c = r.getCell(3);
	String value ="";
	int k = c.getCellType();
	if (k==1) {
		value = c.getStringCellValue();
	}else if (DateUtil.isCellDateFormatted(c)) {
		Date d = c.getDateCellValue();
		
		SimpleDateFormat sim = new SimpleDateFormat("dd-MMM-yyyy");
		value = sim.format(d);
	}else {
		double d = c.getNumericCellValue();
		
		long l = (long)d;
		value = String.valueOf(l);
		System.out.println(l);
		System.out.println(l+1);
		System.out.println("Code Added");
	}
	
		return value;
	}
}