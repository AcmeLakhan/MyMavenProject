/**
 *		Utility class which have common method used frequently
 *		All methods are static 
 */
package libraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/**
 * @author lakhan_babar
 *	
 *		methods like capture screen shot, get test data from property file and excel, i frame handling etc 
 */
public class UtilityClass 
{
	//lakhan_babar
	// this method accept one parameter which is key in the property file and returns the value of that particular key
	
	public static String getTestDataFromPF(String key) throws IOException
	{
		Properties obj = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\lakha\\eclipse-workspaceTesting\\MyMavenProject\\TestData\\PropertyFile.Properties");
		obj.load(file);
		String value = obj.getProperty(key);
		return value;
	}
	
	//lakhan_babar
	//this method accept two parameter rowIndex and colIndex and return the particular string value from excel file 
	public static String getTestDataFromExcell(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException
	{
		File file = new File("C:\\Users\\lakha\\eclipse-workspaceTesting\\MyMavenProject\\TestData\\demo.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("POMwithDDF");
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
	}
	
	
	//lakhan_babar
	//this method accept webDriver and test case id and capture the screenshot and store it into screenshot folder
	public static void captureScreenShot(WebDriver driver, int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\lakha\\eclipse-workspaceTesting\\MyMavenProject\\ScreenShots\\TestCase"+TCID+".jpg");
		FileHandler.copy(src, dest);
	}
	
	
	
	
}
