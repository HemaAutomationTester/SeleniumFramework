package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {

	public WebDriver driver;
	ElementUtil eleUtil;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	private final By pageHeader = By.xpath("//h1");
	private final By successHeader = By.xpath("//h1");
	private final By firstName = By.xpath("//input[@id='input-firstname']");
	private final By lastName = By.xpath("//input[@id='input-lastname']");
	private final By email = By.xpath("//input[@id='input-email']");
	private final By phone = By.xpath("//input[@id='input-telephone']");
	private final By password = By.xpath("//input[@id='input-password']");
	private final By confirmPassword = By.xpath("//input[@id='input-confirm']");
	private final By susbcribeNo = By.xpath("//label[@class='radio-inline']//input[@value='0']");
	private final By susbsribeYes = By.xpath("//label[@class='radio-inline']//input[@value='1']");
	private final By agree = By.xpath("//input[@name='agree']");
	private final By continueButton = By.xpath("//input[@value='Continue']");

	private final By logoutLink = By.linkText("Logout");
	private final By registerLink = By.linkText("Register");

	public String getPageHeader() {
		String headerText = eleUtil.getElement(pageHeader).getText();
		return headerText;
	}

	public void fillRegisterForm(String firstName, String lastName, String email, String phone, String password,
			 String susbscribe) {
		eleUtil.doSendKeys(this.firstName, firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.phone, phone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(confirmPassword, password);

		if (susbscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(susbsribeYes);
		} else {
			eleUtil.doClick(susbcribeNo);
		}

		eleUtil.doClick(agree);
		eleUtil.doClick(continueButton);

		String successMessage = eleUtil.getElement(successHeader).getText();
		System.out.println("User is successfully registered" + successMessage);

		if (successMessage.contains(AppConstants.REGISTER_SUCCESS_MESSAGE)) {
			eleUtil.doClick(logoutLink);
			eleUtil.doClick(registerLink);
		}

	}

}
