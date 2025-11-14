package com.qa.opencart.utils;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.exceptions.ElementException;
import com.qa.opencart.factory.DriverFactory;

import io.qameta.allure.Step;

public class ElementUtil {

	WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	// To get the page details like Title/URL etc
	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageCurrentURL() {
		return driver.getCurrentUrl();
	}

	public WebElement getElement(By by) {
		return driver.findElement(by);
	}
	
	public List <WebElement> getElements(By by) {
	List <WebElement> elements	= driver.findElements(by);
	return elements;
	}
	
	
	// Here {0} is denoting parameter By in doSendKeys method and {1} is denoting the parameter Charkey in below method.
	@Step("Sending the keys for: By {0} and CharKey: {1}")
	public void doSendKeys(By by, String charKeys) {
		getElement(by).clear();
		getElement(by).sendKeys(charKeys);
	}

	public void doClick(By by) {
		driver.findElement(by).click();
	}
	
	public boolean isElementDisplayed(By by) {
		try {
			return getElement(by).isDisplayed();
		}catch(NoSuchElementException e){
			throw new ElementException("===ELEMENT NOT FOUND===");
		}
		
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement waitForElementPresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement waitForElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}
	
	
	
}
