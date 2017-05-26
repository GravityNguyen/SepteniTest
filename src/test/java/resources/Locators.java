package resources;

import org.openqa.selenium.By;

public class Locators {
	// Login Page
	public static String txtEmail = "id=email";
	public static String txtPwd = "id=pass";
	public static String linkForgotPassword = "link=Forgot Your Password?";
	public static String btnLogin = "id=send2";
	public static String btnCreate = "xpath=//span[.='Create an Account']";
	// Error Msgs
	public static String txtInvalidCredential = "xpath=//span[.='Invalid login or password.']";
	public static String txtInvalidEmail = "id=advice-validate-email-email";
	public static String txtInvalidPwd = "id=advice-validate-password-pass";
	public static String txtEmptyEmail = "id=advice-required-entry-email";
	public static String txtEmptyPwd = "id=advice-required-entry-pass";
	// Create Account
	public static String txtRegFirstName = "id=firstname";
	public static String txtRegLastName = "id=lastname";
	public static String txtRegEmail = "id=email_address";
	public static String txtRegPwd = "id=password";
	public static String txtRegPwdConfirm = "id=confirmation";
	public static String chkSubscribed = "id=is_subscribed";
	public static String btnRegister = "xpath=//*[@type='submit'][@title='Register']";
	public static String linkBackToLogin = "link=Back";
	public static String txtWelcome  = "xpath=//*[@class='success-msg']";
	public static String txtSubcribed  = "xpath=//*[@class='col-2']/div/div/p";
	public static String txtExistingEmail = "xpath=//*[@class='error-msg']/ul/li/span";
	
	//Error Msgs
	public static String txtRegEmptyFirstname = "id=advice-required-entry-firstname";
	public static String txtRegEmptyLastname = "id=advice-required-entry-lastname";
	public static String txtRegEmptyEmail = "id=advice-required-entry-email_address";
	public static String txtRegEmptyRegPwd = "id=advice-required-entry-password";
	public static String txtRegEmptyRegPwdConfirm = "id=advice-required-entry-confirmation";
	public static String txtInvalidRegEmail = "id=advice-validate-email-email_address";
	public static String txtInvalidRegPwd = "id=advice-validate-password-password";
	public static String txtInvalidRegPwdConfirm = "id=advice-validate-cpassword-confirmation";
	
}
