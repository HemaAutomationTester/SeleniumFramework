package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ForgotPasswordPageTest extends BaseTest {
	
	@BeforeClass
	public void setUp() {
		forgotPwdPage = logPage.toGoToForgotPassword();
	}

	@Description("To gets the title of the page")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void forgotPasswordPageTitleTest() {
		String actualTitle = forgotPwdPage.getPagetitle();
		ChainTestListener.log("Forgot Password Page Title" + actualTitle);
		System.out.println("Actual Message from Brand: " + actualTitle);
		Assert.assertEquals(actualTitle, "Forgot Your Password?");
	}

	@Description("To check positive forgot password complete sceanrio ")
	@Test
	public void ForgotPasswordSuccesTest() {
		String msg = forgotPwdPage.doForgotPassword(prop.getProperty("forgotPasswordEmail"));
		Assert.assertEquals(msg, " An email with a confirmation link has been sent your email address.");
	}
	
	
	@Description("To check positive forgot password complete sceanrio ")
	@Test
	public void ForgotPasswordFaliureTest() {
		String msg = forgotPwdPage.doForgotPassword(prop.getProperty("forgotPasswordEmail"));
		Assert.assertEquals(msg, " An email with a confirmation link has been sent your email address.");
	}

}
