package testCases;

import com.github.javafaker.Faker;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pagesObjects.AccountRegistrationPage;
import pagesObjects.HomePage;

public class TC01_AccountRegistrationTest extends BaseTest {
//	HomePage hp = new HomePage(driver);
//	AccountRegistrationPage accRegPage = new AccountRegistrationPage(driver);
	String password = generateRandomAlphaNumric() + "@";

	@Test(groups = "sanity")
	public void verifyAccountCreated() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		//Assert.assertTrue(hp.isLogoPresent());
		AccountRegistrationPage accRegPage = new AccountRegistrationPage(driver);
		logger.debug("Debug");
		try {
			hp.clickMyAccountLink();
		//Thread.sleep(15000);
		//hp.clickMyAccountLink();
		hp.clickRegisterLink();
		logger.info("Register link clicked");
		//accRegPage.enterFirstName(generateRandomString());
		accRegPage.enterFirstName(firstName);
		//accRegPage.enterLastName(generateRandomString());
		accRegPage.enterLastName(lastName);
		//accRegPage.enterEmail(generateRandomString() + "@yopmail.com");
		accRegPage.enterEmail(yopMail);
		accRegPage.enterTelephone(generateRandomNumber());
		accRegPage.enterPassword(password);
		accRegPage.enterConfirmPassword(password);
		accRegPage.clickAgreeCheckBox();
		Thread.sleep(3000);
		accRegPage.clickBtnContinue();
		Assert.assertEquals(accRegPage.getSuccessMsg(), "Your Account Has Been Created!");
		}
		catch (Exception e) {
			logger.error("Test Failed!!!!!!!!!!!!!!!!!!!!!!!");
			logger.debug("Debug logs........................");
			Assert.fail();
		} 		
		logger.info("Finished testing TC01_AccountRegistrationTest");
	}
}
