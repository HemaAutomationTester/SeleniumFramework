package com.qa.opencart.pages;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class CartPage {

	public WebDriver driver;
	ElementUtil eleUtil;

	public CartPage(WebDriver driver) {
		driver = this.driver;
		eleUtil = new ElementUtil(driver);
	}

	
	
	
	
}
