package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends BaseTest {
	
	//TestNG will execute all tests in alphabetical order. 

	@Description("Validating the login page title...")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void LoginPageTitleTest() {
		String actualTitle = logPage.getLoginPageTitle();
		ChainTestListener.log("Fetched actual title" + actualTitle);
		Assert.assertEquals(actualTitle, "Account Login");
	}

	@Description("Validating the login page URL...")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void LoginPageURLTest() {
		String actualURL = logPage.getPageURL();
		System.out.println("The login page title is : " + actualURL);
		ChainTestListener.log("Fetched actual URL" + actualURL);
		Assert.assertTrue(actualURL.contains("route=account/login"));
	}

	
	@Test
	@Description("Validating the login feature...")
	@Severity(SeverityLevel.BLOCKER)
	public void LoginTest() {
		/* 
		 * This is used to send the username from .xml file as parameters.
		 * 
		 * prop.setProperty("username", username); prop.setProperty("password",
		 * password);
		 */
		accPage = logPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutVisible());
		System.out.println("The user has logged in successfully!!");
	}
	
	
}
