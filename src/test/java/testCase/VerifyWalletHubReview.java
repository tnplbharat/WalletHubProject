package testCase;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import configuration.BaseTest;
import constants.Constants;
import pages.WalletHubConfirmReviewPage;
import pages.WalletHubHomePage;
import pages.WalletLoginPage;

public class VerifyWalletHubReview extends BaseTest{
	
	WalletHubHomePage walletHubHomPage;
	WalletHubConfirmReviewPage walletHubConfirmRevPage;
	WalletLoginPage walletLoginPage;
	
	/**
	 * This test case verifies WalletHub ratings given by user and review comment
	 * @param user name and password and author ID need to pass from Constant file
	 * @author Bharat
	 *
	 */
	@Test
	public void vrifyMouseHourOnReviewStarAndSelectRating()
	{
		walletHubHomPage = new WalletHubHomePage(driver);
		walletHubConfirmRevPage = new WalletHubConfirmReviewPage(driver);
		walletLoginPage = new WalletLoginPage(driver);
		
		SoftAssert asrt = new SoftAssert();
		
		walletLoginPage.loginToApp(Constants.WALLETHUB_USERNAME, Constants.WALLETHUB_PASSWORD);
		
		driver.get(Constants.WALLETHUB_PROFILE_URL);	
		driver.manage().window().maximize();
		
		walletHubHomPage.clickReviewTab();
		
		asrt.assertEquals(walletHubHomPage.verifyReviewStarLightUp(),Constants.STAR_HIGHLIGHT,"Verify Review Star Highlighted");
		
		walletHubHomPage.selectReviewRatingStar(4,Constants.SELECT_DROP_DOWN_OPTION,Constants.REVIEW_COMMENT);
		
		asrt.assertEquals(walletHubConfirmRevPage.verifyConfirmMessage(),Constants.REVIEW_Post_CONFIRMATION_MESSAGE,"Verify Review Post Message");
		
		asrt.assertEquals(walletHubConfirmRevPage.verifyReviewMessage(),Constants.REVIEW_COMMENT,"Verify Review Comment");
		
		walletHubConfirmRevPage.clickContinueBtn();
		
		asrt.assertEquals(walletHubHomPage.getPageTitle(), Constants.PAGE_TITLE, "Verify Page title");
		
		asrt.assertEquals(walletHubHomPage.verifyAutherAndReviewContent(Constants.AUTHER_ID),Constants.AUTHER_ID,"Verify Review Comment");
		
		walletHubHomPage.logoutUser();
		
		asrt.assertAll();
	}

}
