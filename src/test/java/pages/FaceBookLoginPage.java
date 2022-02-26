package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains locators for FaceBook login page and methods
 * @author Bharat
 * 
 */
public class FaceBookLoginPage {
	
	private WebDriver driver;
	private static Logger logger = LogManager.getLogger(FaceBookLoginPage.class);
	
	public FaceBookLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn;
	
	/**
	 * This methos use to login into Facebook account
	 * @author Bharat
	 * @param loginName it requires to supply login name
	 * @param loginPassword  it requires to supply password
	 */ 
	
	public void loginFacebook(String loginName, String loginPassword)
	{
		userName.clear();
		userName.sendKeys(loginName);
		logger.info("User name entered");
		
		password.clear();
		password.sendKeys(loginPassword);
		logger.info("User password entered");
		
		loginBtn.isDisplayed();
		loginBtn.click();
		logger.info("Click on login button");
	
	}
}
