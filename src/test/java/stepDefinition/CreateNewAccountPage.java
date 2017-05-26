package stepDefinition;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.Locators;

public class CreateNewAccountPage extends AbstractPage {

	WebDriver driver = LoginPage.driver;

	@When("^User fills the \"([^\"]*)\" and \"([^\"]*)\" name fields$")
	public void User_fills_the_and_name_fields(String firstname, String lastname)
			throws Throwable {
		getElement(loc.txtRegFirstName).sendKeys(firstname);
		getElement(loc.txtRegLastName).sendKeys(lastname);
	}

	@When("^User fills the register email$")
	public void User_fills_the_register_email() throws Throwable {
		Random random = new Random();
		int n = random.nextInt(10000);
		getElement(loc.txtRegEmail).sendKeys(
				"automationdemo" + n + "@gmail.com");
	}

	@When("^User fills the \"([^\"]*)\" and \"([^\"]*)\" password fields$")
	public void User_fills_the_and_password_fields(String pwd, String pwdcnf)
			throws Throwable {
		getElement(loc.txtRegPwd).sendKeys(pwd);
		getElement(loc.txtRegPwdConfirm).sendKeys(pwdcnf);
	}

	@When("^Uset sets the subcriber to \"([^\"]*)\" value$")
	public void Uset_sets_the_subcriber_to_value(String value) throws Throwable {
		boolean isSubcribe = stringToBool(value);
		if (isSubcribe == true) {
			getElement(loc.chkSubscribed).click();
		}
	}

	@When("^User clicks on Register button$")
	public void User_clicks_on_Register_button() throws Throwable {
		getElement(loc.btnRegister).click();
	}

	@Then("^User see welcome message$")
	public void User_see_welcome_message() throws Throwable {
		waitForPageLoad();
		String msg = getElement(loc.txtWelcome).getText();
		Assert.assertEquals(msg,
				"Thank you for registering with Main Website Store.");
	}

	@Then("^User see the message that \"([^\"]*)\"$")
	public void User_see_the_message_that(String name) throws Throwable {
		waitForPageLoad();
		String msg = getElement(loc.txtSubcribed).getText();
		Assert.assertEquals(msg, name);
	}

	@When("^User fills the \"([^\"]*)\" into the email field$")
	public void User_fills_the_into_the_email_field(String email)
			throws Throwable {
		getElement(loc.txtRegEmail).sendKeys(email);
	}
	@After
	public void closeBrowser(){
		driver.quit();
	}
}
