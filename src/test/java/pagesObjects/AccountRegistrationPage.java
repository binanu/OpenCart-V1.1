package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtBoxFirstName;
	
	public void enterFirstName(String firstName) {
		txtBoxFirstName.sendKeys(firstName);
	}
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtBoxLastName;
	
	public void enterLastName(String lastName) {
		txtBoxLastName.sendKeys(lastName);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtBoxEmail;
	
	public void enterEmail(String email) {
		txtBoxEmail.sendKeys(email);
	}
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtBoxTelephone;
	
	public void enterTelephone(String telephone) {
		txtBoxTelephone.sendKeys(telephone);
	}
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtBoxPassword;
	
	public void enterPassword(String password) {
		txtBoxPassword.sendKeys(password);
	}
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtBoxConfirmPassword;
	
	public void enterConfirmPassword(String password) {
		txtBoxConfirmPassword.sendKeys(password);
	}
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkBoxAgree;
	
	public void clickAgreeCheckBox() {
		checkBoxAgree.click();
	}
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	
	public void clickBtnContinue() {
		btnContinue.click();
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement successMsg;
	
	public String getSuccessMsg() {
		try {
			return successMsg.getText();
		}
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	
	
	
	
}
