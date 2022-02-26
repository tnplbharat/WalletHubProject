package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilityFunctions.UtilityFunctions;

/**
 * This class contains locators and methods for Wallethub Home page
 * @author Bharat
 *
 */  
public class WalletHubHomePage {

	private WebDriver driver;
	UtilityFunctions utlFun;
	private static Logger logger = LogManager.getLogger(WalletHubHomePage.class);

	public WalletHubHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[text()='Reviews'])[1]")
	private WebElement reviewLink;

	@FindBy(xpath = "(//div[@class='rating-box-wrapper'])[3]//*[local-name()='svg'][4]")
	private WebElement fourthstr;

	@FindBy(xpath = "//span[text()='Select...']")
	private WebElement selDropDown;

	@FindBy(xpath = "//div[@class='android textarea-user']/textarea")
	private WebElement textareaToEnterComment;
	
	@FindBy(xpath = "//div[text()='Submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//h1[text()='Test Insurance Company']")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//div[@class='brgm-button brgm-user brgm-list-box']/span")
	private WebElement logoutBtn;
	
	
	SoftAssert asrt = new SoftAssert();

	/**
	 * This method use to click on review tab
	 * @author Bharat
	 *
	 */
	public void clickReviewTab() {
		utlFun = new UtilityFunctions(driver);
		utlFun.waiForElementToClickable(reviewLink);
		reviewLink.click();
		logger.info("Click on review tab");
	}

	/**
	 * This method use to select review star and checks selected stars are highlighted
	 * @author Bharat
	 * @param num user need to supply number of stars for review
	 * @param optToselect user need to supply option for policy
	 * @param reviewComment user need to supply review comment
	 */
	public void selectReviewRatingStar(int num, String optToselect, String reviewComment) {
		utlFun = new UtilityFunctions(driver);

		WebElement selReviewStr = driver
				.findElement(By.xpath("(//div[@class='rating-box-wrapper'])[3]//*[local-name()='svg'][" + num + "]"));
		selReviewStr.click();
		logger.info("Click on review stars");

		selDropDown.isDisplayed();
		selDropDown.click();
		logger.info("Click on dropdown");

		WebElement selOption = driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + optToselect + "']"));
		utlFun.waiForElementToClickable(selOption);
		selOption.click();
		logger.info("Policy option selected");

		textareaToEnterComment.isDisplayed();
		textareaToEnterComment.click();
		textareaToEnterComment.sendKeys(reviewComment);
		logger.info("Entered review comment");
		
		utlFun.waiForElementToClickable(submitBtn);
		submitBtn.click();
		logger.info("Click on Submit button");

	}

	/**
	 * This method use return home page title
	 * @author Bharat
	 * @return returns page title
	 */
	public String getPageTitle()
	{
		return pageTitle.getText();
	}

	/**
	 * This method use to verify review star are light up when mouse hover over on it
	 * @author Bharat
	 * @return verifyStrLightUP returns value for star attribute to check whether it is selected or not
	 */
	public String verifyReviewStarLightUp() {
		String verifyStrLightUP=null;
		try {
		Actions act = new Actions(driver);

		List<WebElement> reviewStr = driver
				.findElements(By.xpath("(//div[@class='rating-box-wrapper'])[3]//*[local-name()='svg']"));
		int totalStrCnt = reviewStr.size();
		for (int i = 1; i <= totalStrCnt; i++) {
			WebElement reviewStrtoLightUP = driver
					.findElement(By.xpath("(//div[@class='rating-box-wrapper'])[3]//*[local-name()='svg'][" + i + "]"));
			act.moveToElement(reviewStrtoLightUP).perform();
			logger.info("Selecting Review stars");
			verifyStrLightUP = reviewStrtoLightUP.getAttribute("aria-checked");
		}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
			return verifyStrLightUP;
	}
	

	/**
	 * This method use to verify auther id and their respective review comment
	 * @author Bharat
	 * @param AuthorName user need to supply user id here based on it review comment is verified
	 */
	public String verifyAutherAndReviewContent(String AuthorName)
	{
		String reviewCommentText = null;
		try {
			List<WebElement> getAutherIDCount = driver.findElements(By.xpath("//span[@class='rvtab-ci-nickname regular-font']"));
			int totalAuthCnt = getAutherIDCount.size();
			
			for(int i=1;i<=totalAuthCnt;i++)
			{
				WebElement authID = driver.findElement(By.xpath("(//span[@class='rvtab-ci-nickname regular-font'])["+i+"]"));
				if(authID.getText().contains(AuthorName))
				{
					WebElement reviewComment = driver.findElement(By.xpath("(//span[@class='rvtab-ci-nickname regular-font'])["+i+"]//..//../../child::div[@class='rvtab-ci-content with-links text-select']"));
					reviewCommentText= reviewComment.getText();
					logger.info("Review Author selected");
				}
			}
			
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		return reviewCommentText;
	}
	
	/**
	 * This method use to logout from application
	 * @author Bharat
	 * 
	 */
	public void logoutUser()
	{
		utlFun = new UtilityFunctions(driver);
		utlFun.waiForElementToClickable(logoutBtn);
		logoutBtn.click();
		logger.info("Click on Logout button");
	}

}
