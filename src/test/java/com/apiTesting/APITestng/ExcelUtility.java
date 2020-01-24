package com.apiTesting.APITestng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static void main(String args[]) throws IOException {
		Iterator<Object[]> itr =ExcelUtility.getExcelData();
		while(itr.hasNext()) {
			System.out.println(Arrays.toString(itr.next()));
		}
	}

	public static ArrayList<Object[]> excelData() throws IOException {

		// String path = System.getProperty("user.dir"+"/APITestng/TestDataFile.xlsx");
		String path = "/Users/vsingh/Documents/eclipseSetup/javaLearning/APITestng/TestDataFile.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
		XSSFSheet sheet = workbook.getSheetAt(0);

		String Name = null;
		String Salary = null;
		String Age = null;
		ArrayList<Object[]> al = new ArrayList();

		DataFormatter formatter = new DataFormatter();
		for (int j = 0; j < sheet.getLastRowNum(); j++) {
			XSSFRow row = sheet.getRow(j);
			for (int i = 1; i <row.getLastCellNum(); i++) {
				Name = row.getCell(0).getStringCellValue();
				Salary = formatter.formatCellValue(row.getCell(1));
				Age = formatter.formatCellValue(row.getCell(2));
			}
			al.add(new Object[] { Name, Salary, Age });
			//System.out.println(Name + " " + Salary + " " + Age);
	
		}
		return al;
	}
	
	  public static Iterator<Object []> getExcelData() throws IOException {
		  ArrayList<Object[]> al = ExcelUtility.excelData();
		  return al.iterator();
	  }
}
