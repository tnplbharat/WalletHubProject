package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityFunctions.UtilityFunctions;

/**
 * This class contains locator and method for wallethub login page
 * @author Bharat
 * 
 */
public class WalletLoginPage {
	
	private WebDriver driver;
	UtilityFunctions utlFun;
	private static Logger logger = LogManager.getLogger(WalletLoginPage.class);
	
	public WalletLoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "em")
	private WebElement userNameTxtField;
	
	@FindBy(name = "pw")
	private WebElement passwordTxtField;
	
	@FindBy(xpath = "//button[@type='button']/span")
	private WebElement loginBtn;
	
	/**
	 * This method use to login into application
	 * @author Bharat
	 * @param uname user need to supply username
	 * @param upassword user need to supply password
	 */
	public void loginToApp(String uname, String upassword)
	{
		utlFun = new UtilityFunctions(driver);
		
		utlFun.waiForElementToVisible(userNameTxtField);
		userNameTxtField.isEnabled();
		
		userNameTxtField.clear();
		userNameTxtField.sendKeys(uname);
		logger.info("Entered user name");
		
		utlFun.waiForElementToVisible(passwordTxtField);
		passwordTxtField.isEnabled();
		passwordTxtField.clear();
		passwordTxtField.sendKeys(upassword);
		logger.info("Entered user password");
		
		utlFun.waiForElementToClickable(loginBtn);
		loginBtn.click();
		logger.info("Click on Login button");
	}

}
