package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;

public class ProductPageTest extends BaseTest {

	@BeforeClass
	public void productPageSetUp() {
		accPage = logPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}
 
	@DataProvider
	public Object[][] productImageData() {
		return new Object[][] { 
			{ "MacBook", "5" }, 
			{ "MacBook Air", "4" }, 
			{ "MacBook Pro", "4" }
			};
	}

	@Test(dataProvider = "productImageData")
	public void productImagesTest(String searchKey, String expectedImageCount) {
		searchResultPage = accPage.doSearch(searchKey);
		prodPage = searchResultPage.selectProduct(searchKey);
		int imageCount = prodPage.getProductImageCount();
		Assert.assertEquals(imageCount,Integer.parseInt(expectedImageCount));
	}
}
