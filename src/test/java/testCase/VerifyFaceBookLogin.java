package testCase;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import configuration.BaseTest;
import constants.Constants;
import pages.FaceBookHomePage;
import pages.FaceBookHorizontalMenuBar;
import pages.FaceBookLoginPage;

public class VerifyFaceBookLogin extends BaseTest {
	FaceBookLoginPage fcBokPage;
	FaceBookHorizontalMenuBar fcBokHrizontalMnu;
	FaceBookHomePage fcBokHomePage;
	SoftAssert asrt = new SoftAssert();

	/**
	 * This test case verifies FaceBook login and logout functionality with valid user name and password
	 * 
	 * @author Bharat
	 * @param user name and password need to pass from Constant file
	 */
	@Test
	public void validateFcBokLoginAndLogOut() {
		fcBokPage = new FaceBookLoginPage(driver);
		fcBokHrizontalMnu = new FaceBookHorizontalMenuBar(driver);

		fcBokPage.loginFacebook(Constants.FCBKUSERNAME, Constants.FCBKPASSWORD);

		fcBokHrizontalMnu.logOutFaceBok();

		asrt.assertEquals(fcBokHrizontalMnu.loginStr(), Constants.LOGIN_TEXT, "Verify Login text on home page");
		asrt.assertAll();
	}

	/**
	 * This test case verifies FaceBook post created by user
	 * @author Bharat
	 * @param user name and password need to pass from Constant file
	 * @param user need to pass post message from Constant file
	 */
	@Test
	public void validatePostMsg() {
		fcBokPage = new FaceBookLoginPage(driver);
		fcBokHrizontalMnu = new FaceBookHorizontalMenuBar(driver);
		fcBokHomePage = new FaceBookHomePage(driver);

		fcBokPage.loginFacebook(Constants.FCBKUSERNAME, Constants.FCBKPASSWORD);

		fcBokHomePage.createPost(Constants.FCBK_POST_MESSAGE);

		fcBokHrizontalMnu.logOutFaceBok();

		asrt.assertEquals(fcBokHrizontalMnu.loginStr(), Constants.LOGIN_TEXT, "Verify Login text on home page");
		asrt.assertAll();
	}
}
