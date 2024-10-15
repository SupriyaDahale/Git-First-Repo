package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility
{
	public static void takeScreenShot(WebDriver driver, String fileName) throws IOException
	{
	  File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  String timeStamp = new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
	  //File dest = new File("C:\\Users\\Akshay\\eclipse-workspace\\Automation_Selenium\\ScreenShotOfSelenium"+fileName+timeStamp+".png");
	  File dest = new File(System.getProperty("user.dir")+"\\ScreenShotOfSelenium"+fileName+timeStamp+".png");
	  FileHandler.copy(source, dest);
	}
	
	public static String readDataFromExcel(String excelpath, String sheetName, int rowName, int cellname) throws EncryptedDocumentException, IOException 
	{
		FileInputStream myfile = new FileInputStream(excelpath);
		String value = WorkbookFactory.create(myfile).getSheet(sheetName).getRow(rowName).getCell(cellname).getStringCellValue();
		return value;
	}
	
	public static String readDataFromPropertyFile(String key) throws IOException 
	{
		Properties properties = new Properties();
		FileInputStream myFile = new FileInputStream("C:\\Users\\Akshay\\eclipse-workspace\\Automation_Selenium\\src\\config.properties");
		properties.load(myFile);
		String value=properties.getProperty(key);
		return value;
	}


}
