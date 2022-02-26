package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains locators for FaceBook Menu bar
 * @author Bharat
 *
 */

public class FaceBookHorizontalMenuBar {
	
	private WebDriver  driver;
	private static Logger logger = LogManager.getLogger(FaceBookHorizontalMenuBar.class);
	
	public FaceBookHorizontalMenuBar(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@aria-label='Account']")
	private WebElement logOutMenu;

	@FindBy(xpath="//span[text()='Log Out']")
	private WebElement logoutTxt;
	
	@FindBy(xpath="//button[text()='Log In']")
	private WebElement loginTxt;

	/**
	 * This method is use to logout from FaceBook account
	 * @author Bharat
	 *
	 */
	public void logOutFaceBok()
	{
		logOutMenu.isDisplayed();
		logOutMenu.click();
		logger.info("Click on Logout link");
		logoutTxt.isDisplayed();
		logoutTxt.click();
		logger.info("Click on Logout Button");
		  
	}
	/**
	 * This method returns login text from page
	 * @author Bharat
	 * @return login text from page
	 */
	public String loginStr()
	{
		return loginTxt.getText();
	}

}
