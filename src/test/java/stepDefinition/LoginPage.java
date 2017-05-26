package stepDefinition;

import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage extends AbstractPage {

	@Given("^User opens \"([^\"]*)\" using \"([^\"]*)\"$")
	public void User_opens_using(String url, String browser) throws Throwable {
		try {
			openPage(url, browser);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Then("^User stays at \"([^\"]*)\" page$")
	public void User_stays_at_page(String page) throws Throwable {
		waitForPageLoad();
		String title = driver.getTitle();
		Assert.assertEquals(title, page);
	}

	@When("^User login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void User_login_with_email_and_password(String email, String pwd)
			throws Throwable {
		getElement(loc.txtEmail).sendKeys(email);
		getElement(loc.txtPwd).sendKeys(pwd);
		getElement(loc.btnLogin).click();
	}

	@Then("^User is redirected to \"([^\"]*)\" page$")
	public void User_is_redirected_to_page(String page) throws Throwable {
		waitForPageLoad();
		String title = driver.getTitle();
		Assert.assertEquals(title, page);
	}

	@Then("^User receives error message \"([^\"]*)\"$")
	public void User_receives_error_message(String ermsg) throws Throwable {
		String msg = getElement(loc.txtInvalidCredential).getText();
		Assert.assertEquals(msg, ermsg);
	}

	@Then("^User receives error message \"([^\"]*)\" at \"([^\"]*)\"$")
	public void User_receives_error_message_at(String msg, String name)
			throws Throwable {
		String ermsg = getElement(name).getText();
		Assert.assertEquals(msg, ermsg);
	}

	@Given("^User clicks on Create An Account button$")
	public void User_clicks_on_Create_An_Account_button() throws Throwable {
		getElement(loc.btnCreate).click();
		;
	}

	@After
	public void closeBrowser(){
		driver.quit();
	}
	
	
}
