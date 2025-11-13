package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	WebDriver driver;
	ElementUtil eleUtil;

	// Constructor to initialize the driver and elementUtil.
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	// Page locators
	By email_filed = By.id("input-email");
	By password_field = By.id("input-password");
	By forgot_password = By.linkText("Forgotten Password");
	By login_button = By.xpath("//input[@type='submit']");
	By register_link = By.linkText("Register");
	By forgot_passwordLink = By.linkText("Forgotten Password");

	// Actions on element

	// getLoginPageTitle
	public String getLoginPageTitle() {
		String pageTitle = eleUtil.getPageTitle();
		System.out.println("Login page title " + pageTitle);
		return pageTitle;
	}

	// getLoginPageURL
	public String getPageURL() {
		String currentURL = eleUtil.getPageCurrentURL();
		System.out.println("Current page URL is: " + currentURL);
		return currentURL;
	}

	// To do login on openCart application
	public AccountPage doLogin(String email, String password) {
		eleUtil.doSendKeys(email_filed, email);
		eleUtil.doSendKeys(password_field, password);
		eleUtil.doClick(login_button);
		return new AccountPage(driver);
	}
	
	// Function to check forgot password link 
	public ForgotPasswordPage clickForgotPasswordLink() {
		eleUtil.doClick(forgot_passwordLink);
		return new ForgotPasswordPage(driver);
	}

	// Function to go to the register page from login page. 
	public RegisterPage goToRegister() {
		eleUtil.getElement(register_link).click();
		return new RegisterPage(driver);
	}
	
	// Function to go to the ForgotPassword page from login page. 
	public ForgotPasswordPage toGoToForgotPassword() {
		eleUtil.doClick(forgot_passwordLink);
		return new ForgotPasswordPage(driver);
	}
	
	
}
