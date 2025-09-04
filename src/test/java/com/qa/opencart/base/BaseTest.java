package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultPage;

import io.qameta.allure.Description;


@Listeners({TestAllureListener.class, ChainTestListener.class})
public class BaseTest {
	
	protected WebDriver driver;
	DriverFactory drvFac;
	protected Properties prop;
	
	protected LoginPage logPage;
	protected AccountPage accPage;
	protected SearchResultPage searchResultPage;
	protected ProductPage prodPage;
	protected RegisterPage regPage;

	@Description("launch the browser: {0} and url")
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(@Optional("Chrome") String browserName) {
		drvFac = new DriverFactory();
		prop = drvFac.initProperties();
		
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
		}
	
		driver = drvFac.initBrowser();
		logPage = new LoginPage(driver);
	}
	
	@AfterMethod // will be running after each @test method
	public void attachScreenshot(ITestResult result) {
		
		if (!result.isSuccess()) {// only for failure test cases -- true
			ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");
		}

		//ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Quiting the browser");
		driver.quit();
	}
}
