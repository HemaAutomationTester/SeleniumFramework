package com.qa.opencart.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductPage {

	WebDriver driver;
	Map<String, String> productMap;
	ElementUtil eleUtil;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private final By productImage = By.xpath("//ul[@class='thumbnails']/li");
	private final By productTitle = By.xpath("//h1");
	private final By productInfo = By.xpath("(//div[@class='col-sm-4']/ul[@class='list-unstyled'])[1]/li");
	private final By productPricingInfo = By.xpath("(//div[@class='col-sm-4']/ul[@class='list-unstyled'])[2]/li");

	//This product is used to get the image count of the product.
	
	public int getProductImageCount() {
		List<WebElement> productImages = eleUtil.getElements(productImage);
		int productImagesCount = productImages.size();
		return productImagesCount;
	}
	
	// This method will get the product details like Brand/Product Code/ Availability etc from product page. 
	// Here we have used String's Spilt method and stored the values in HashMap.
	
	public Map<String, String> getProductDetails() {
		List<WebElement> productDetails = eleUtil.getElements(productInfo);

		for (WebElement e : productDetails) {
			String[] productData = e.getText().split(":");
			String ProductKey = productData[1];
			String ProductValue = productData[2].trim();
			productMap.put(ProductKey, ProductValue);
		}
		return productMap;
	}
	
	
	//This method is used to get the product price from the product page like real price and ex price. 
	
	public Map<String, String> getProductPricing() {
		List<WebElement> productPricingDetails = eleUtil.getElements(productPricingInfo);
		String productPrice = productPricingDetails.get(0).getText();
		String productExPrice = productPricingDetails.get(1).getText().split(":")[1].trim();
		productMap.put("Ex Price", productExPrice);
		productMap.put("Real Price", productPrice);
		return productMap;
	}

	public String getProductHeader() {
		String productHeaderTitle = eleUtil.getElement(productTitle).getText();
		return productHeaderTitle;
	}

}
