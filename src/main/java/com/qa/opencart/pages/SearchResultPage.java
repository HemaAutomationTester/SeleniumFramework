package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {

	WebDriver driver;
	ElementUtil eleUtil;

	private final By searchResultKeyword = By.xpath("//div[@class='caption']//a");
	private final By searchHeader = By.xpath("//h1");
	private final By searchSubHeader = By.xpath("//h2");

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public List<String> getSearchResultProductTitleList() {
		List<WebElement> prodTitleElement = eleUtil.getElements(searchResultKeyword);
		List<String> productTitleList = new ArrayList<String>();
		for (WebElement e : prodTitleElement) {
			String title = e.getText().trim().toLowerCase();
			productTitleList.add(title);
		}
		return productTitleList;
	}

	public String getSearchPageHeader() {
		return eleUtil.getElement(searchHeader).getText();
	}

	public String getSearchPageSubHeader() {
		return eleUtil.getElement(searchSubHeader).getText();
	}
	
	
	public ProductPage selectProduct(String productName) {
		System.out.println("Product Searched for -- " + productName);
		eleUtil.doClick(By.linkText(productName));
		return new ProductPage(driver);
	}
}
