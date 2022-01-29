/**
 *		Login two page here 2 web elements we need to locate 
 */
package module1_Login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author lakhan_babar
 *		responsible for second login only
 *
 */
public class LoginTwoPage 
{
	//declaration
	@FindBy(xpath="//input[@type='password']") private WebElement pin;
	@FindBy(xpath="//button[@type='submit']") private WebElement continueButton;
	
	//initialization
	public LoginTwoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//usage
	public void login2(String pin) throws IOException
	{
		this.pin.sendKeys(pin);
		continueButton.click();
	}
}
