package nostraAndroid.Project;

import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Nostra_Excel {
	public static Workbook book;
	public static Sheet sht;
	public static WritableWorkbook wbook;
	public static WritableSheet wsht;
	//Create folder path for Excel file
	public static String folderpath="";
	//Create connection to the Excel
	public static void createExcelConnection(String fileName,String sheetName)
	{
		try{
			FileInputStream fi=new FileInputStream(folderpath+fileName);
			book=Workbook.getWorkbook(fi);
			sht=book.getSheet(sheetName);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	//Read data from Excel File
	public static String readData(int cnum,int rnum)
	{
		try{
			return sht.getCell(cnum, rnum).getContents();
		}catch (Exception e)
		{
			
		}
		return null;
	}
	//Save data in Excel
	public static void saveworkbook()
	{
		try{
			wbook.write();
			wbook.close();
			book.close();
		}catch(Exception e)
		{
			System.out.println(e.getMessage()); 
		}
	}
	//get Row Count
	public static int getRowCount()
	{
		return sht.getRows();
	}
	//Get Column Count
	public static int getColumnCount()
	{
		return sht.getColumns();
	}
}
