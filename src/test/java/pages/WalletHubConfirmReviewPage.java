package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityFunctions.UtilityFunctions;
/**
 * This class contains locators for WalletHub Confirmation Review Page
 * @author Bharat
 *
 */
public class WalletHubConfirmReviewPage {
	
	private WebDriver driver;
	UtilityFunctions utlFun;
	private static Logger logger = LogManager.getLogger(WalletHubConfirmReviewPage.class);
	
	public WalletHubConfirmReviewPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h4[text()='Your review has been posted.']")
	private WebElement confirmMsg;
	
	@FindBy(xpath = "//div[@class='rvc-body-middle']/p")
	private WebElement reviewMsg;
	
	@FindBy(xpath = "//div[@class='btn rvc-continue-btn']")
	private WebElement continueBtn;
	
	/**
	 * This method return confirmation message once user post review
	 * @author Bharat
	 * @return confirMsg this returns confirmation message
	 */
	public String verifyConfirmMessage()
	{
		return confirmMsg.getText();
	}
	
	/**
	 * This methos use to get review message posted by user
	 * @author Bharat
	 * @return reviewMsg it returns review message posted by user
	 */
	public String verifyReviewMessage()
	{
		return reviewMsg.getText();
	}
	
	/**
	 * This methos use to click on continue button once user receive review confirmation message
	 * @author Bharat
	 *
	 */
	public void clickContinueBtn()
	{
		utlFun = new UtilityFunctions(driver);
		utlFun.waiForElementToClickable(continueBtn);
		continueBtn.click();
		logger.info("Click on Continue Button");
	}
}
