package com.qa.opencart.utils;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.exceptions.ElementException;

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
}
