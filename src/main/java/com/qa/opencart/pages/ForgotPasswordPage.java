package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ForgotPasswordPage {

	WebDriver driver;
	ElementUtil eleUtil;

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Page Locators
	By forgotPassworPageHeader = By.xpath("//h1");
	By forgotPasswordPageInfoMessage = By.xpath("//div[@id='content']/p");
	By forgotPasswordLegendText = By.xpath("//fieldset/legend");
	By forgotPasswordEmailAddressField = By.xpath("//input[@id='input-email']");
	By backButton = By.linkText("Back");
	By continueButton = By.xpath("//input[@value='Continue']");
	By forgotPasswordSuccessMessage = By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]");

	// Actions on locators
	public String doForgotPassword(String email) {
		eleUtil.doSendKeys(forgotPasswordEmailAddressField, email);
		eleUtil.doClick(continueButton);
		WebElement successMessage = eleUtil.getElement(forgotPasswordSuccessMessage);
		String successMsg = successMessage.getText();
		return successMsg;
	}

	public String getforgotPasswordInfoMessage() {
		WebElement forgotPasswordInfoMessage = eleUtil.getElement(forgotPasswordPageInfoMessage);
		String infoMessage = forgotPasswordInfoMessage.getText();
		return infoMessage;
	}

	public String getLegendText() {
		WebElement forgotPasswordLegentTest = eleUtil.getElement(forgotPasswordLegendText);
		String legendText = forgotPasswordLegentTest.getText();
		return legendText;
	}

	public String clickBackButton() {
		eleUtil.doClick(backButton);
		String pageTitle = eleUtil.getPageTitle();
		return pageTitle;
	}

	public String getPageHeader() {
		WebElement forgotPasswordHeader = eleUtil.getElement(forgotPassworPageHeader);
		String pageHeader = forgotPasswordHeader.getText();
		return pageHeader;
	}

	public String getPagetitle() {
		return eleUtil.getPageTitle();
	}
	
	

}
