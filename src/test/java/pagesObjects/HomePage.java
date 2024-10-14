package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement linkMyAccount;

	public void clickMyAccountLink() {
		linkMyAccount.click();
	}

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement linkLogin;

	public void clickRegisterLink() {
		linkRegister.click();
	}

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement linkRegister;

	public void clickLoginLink() {
		linkLogin.click();
	}

	@FindBy(xpath = "//img[@title='Your Store']")
	WebElement logo;

	public boolean isLogoPresent() {
		return logo.isDisplayed();
	}

}
