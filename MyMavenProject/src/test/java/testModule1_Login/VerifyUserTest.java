/**
 * 		please run suit because we used @parameters
 * 
 *  	test fail keli ahe
 */
package testModule1_Login;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import libraryFiles.BaseClass;
import libraryFiles.UtilityClass;
import module1_Login.HomePage;
import module1_Login.LoginOnePage;
import module1_Login.LoginTwoPage;

/**
 * @author lakhan_babar
 *
 */
public class VerifyUserTest extends BaseClass
{
	LoginOnePage login1;
	LoginTwoPage login2;
	HomePage home;
	int TCID;
	
	@Parameters("browserName")
	@BeforeClass
	public void startBrowser(String browserName) throws IOException
	{
		initializeBrowser(browserName);
		
		login1 = new LoginOnePage(driver);
		login2 = new LoginTwoPage(driver);
		home = new HomePage(driver);
	}
	
	@BeforeMethod
	public void login() throws IOException, InterruptedException
	{
		login1.login1(UtilityClass.getTestDataFromPF("UN"), UtilityClass.getTestDataFromPF("PASS"));
		Thread.sleep(2000);
		login2.login2(UtilityClass.getTestDataFromPF("PIN"));
		Thread.sleep(2000);
	}
	
	@Test
	public void verifyUserID() throws IOException, InterruptedException
	{
		TCID = 1542;
		String actualUserID = home.verifyUserID();
		String expectedUserID = UtilityClass.getTestDataFromPF("UN");
		
		Assert.assertEquals(actualUserID, expectedUserID, "Failed : Both are different");
		Reporter.log("Correct User logged in", true);
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void screenShot(ITestResult reuslt) throws IOException
	{
		if(reuslt.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreenShot(driver, TCID);
		}
		
		home.logout();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		login1 = null;
		login2 = null;
		home = null;
	}
	
	
}
