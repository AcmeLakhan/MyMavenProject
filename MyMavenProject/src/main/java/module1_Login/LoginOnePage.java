/**
 *		Login one page here 3 web elements we need to locate 
 */
package module1_Login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author lakhan_babar
 *		responsible for first login only
 *
 */
public class LoginOnePage 
{
	//declaration
	@FindBy(xpath="//input[@type='text']") private WebElement un;
	@FindBy(xpath="//input[@type='password']") private WebElement pass;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginButton;
	
	//initialization
	public LoginOnePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//usage
	public void login1(String userName, String password) throws IOException
	{
		un.sendKeys(userName);
		pass.sendKeys(password);
		loginButton.click();
	}
}
