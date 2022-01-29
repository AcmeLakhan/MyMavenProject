/**
 *		base class here we write script to initialize browsers 
 */
package libraryFiles;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * @author lakhan_babar
 *	
 */
public class BaseClass 
{
	public WebDriver driver;
	public void initializeBrowser(String browserName) throws IOException
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lakha\\eclipse-workspaceTesting\\MyMavenProject\\Browsers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\lakha\\eclipse-workspaceTesting\\MyMavenProject\\Browsers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Mention correct browser name");
		}
		
		driver.manage().window().maximize();
		driver.get(UtilityClass.getTestDataFromPF("URL"));
	}
}
