package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityFunctions.UtilityFunctions;

/**
 * @author Bharat 
 * This class contains locators for Facebook homepage and related verification methods
 */

public class FaceBookHomePage {
	private WebDriver driver;
	private static Logger logger = LogManager.getLogger(FaceBookHomePage.class);

	public FaceBookHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'on your mind')]")
	WebElement createPostLink;

	@FindBy(css = "div[aria-describedby*='placeholder']")
	private WebElement addPostTxt;

	@FindBy(xpath = "//span[text()='Post']")
	private WebElement postLink;

	UtilityFunctions utlFun;

	/**
	 * This method use to create post on facebook based on parameter
	 * 
	 * @author Bharat
	 * @param postMsg message to be post on FaceBook
	 */
	public void createPost(String postMsg) {
		utlFun = new UtilityFunctions(driver);
		utlFun.waiForElementToClickable(createPostLink);
		createPostLink.click();
		logger.info("Click on Create Post button");

		utlFun.waiForElementToClickable(addPostTxt);
		addPostTxt.click();
		addPostTxt.sendKeys(postMsg);
		logger.info("Review comment entered");

		postLink.isEnabled();
		postLink.click();
		logger.info("Click on Post button");
	}

}
