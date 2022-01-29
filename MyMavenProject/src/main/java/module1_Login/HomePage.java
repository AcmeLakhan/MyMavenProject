/**
 *		Login two page here 2 web elements we need to locate 
 */
package module1_Login;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author lakhan_babar
 *		responsible for get user and logout only
 *
 */
public class HomePage 
{
	//declaration
	@FindBy(xpath="//span[@class='user-id']") private WebElement getUser;
	@FindBy(xpath="//a[@target='_self']") private WebElement logoutButton;
	
	//initialization
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//usage
	public String verifyUserID()
	{
		String actualUserID = getUser.getText();
		return actualUserID;
	}
	
	public void logout()
	{
		getUser.click();
		logoutButton.click();
	}
}
