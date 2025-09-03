package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class AccountPage {

	WebDriver driver;
	ElementUtil eleUtil;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private final By navmenu = By.xpath("//div[@class='navbar-header']//following-sibling::div/ul/li");
	private final By sideMenuList = By.xpath("//div[@class='list-group']//a");
	private final By logout = By.linkText("Logout");
	private final By search = By.xpath("//input[@name='search']");
	private final By searchButton = By.xpath("//div[@id='search']//button");

	
	@Step("Fetching the list of nav menu items..")
	// To get the NavMenu- headerMenu links text
	public List<String> getNavMenuItems() {
		List<WebElement> navElement = eleUtil.getElements(navmenu);
		List<String> navMenuLinks = new ArrayList<String>();
		for (WebElement e : navElement) {
			String navMenuText = e.getText();
			navMenuLinks.add(navMenuText);
		}
		return navMenuLinks;
	}

	@Step("Searching using the supplied keyword...")
	// To do the search
	public SearchResultPage doSearch(String keyword) {
		eleUtil.doSendKeys(search, keyword.trim().toLowerCase());
		eleUtil.doClick(searchButton);
		return new SearchResultPage(driver);
		
	}

	@Step("Fetching the sidemenu links...")
	// To get the list of sideMenu items
	public List<String> getSideMenuItems() {
		List<WebElement> sideMenuItemList = eleUtil.getElements(sideMenuList);
		List<String> sideMenuLinks = new ArrayList<String>();
		for (WebElement e : sideMenuItemList) {
			String sideMenuLinkText = e.getText();
			sideMenuLinks.add(sideMenuLinkText);
		}
		return sideMenuLinks;
	}

	@Step("Logging out of the site...")
	public void doLogout() {
		eleUtil.doClick(logout);
	}

	@Step("Checking if logout link is visible...	")
	public boolean isLogoutVisible() {
		return driver.findElement(logout).isDisplayed();
	}
}
