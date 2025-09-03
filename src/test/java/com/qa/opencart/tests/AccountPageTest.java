package com.qa.opencart.tests;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("Account Page") // Allure Annotation to add at Test Class level
@Feature("Account Page Components")  // Allure Annotation
@Story("Do search")  // Allure Annotation
public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accPageSteUp() {
		accPage = logPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Description("To perform search test") // Allure Annotation to add at test level
	@Owner("Hemlata QA") // Allure Annotation
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void doSearchTest() {
		searchResultPage = accPage.doSearch(AppConstants.SEARCH_KEYWORD);
		List<String> SearchedProductTitleList = searchResultPage.getSearchResultProductTitleList();
		Assert.assertTrue(SearchedProductTitleList.contains(AppConstants.SEARCH_KEYWORD));
	}

	
	@Description("To validate the sidebar menu list") // Allure Annotation to add at test level
	@Owner("Hemlata QA") // Allure Annotation
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void getsidebarMenuListTest() {
		List<String> sideMenuList = accPage.getSideMenuItems();
		for (String a : sideMenuList) {
			System.out.println("Retrived side menu listed: " + a);
		}
		Assert.assertEquals(sideMenuList, AppConstants.ACC_PAGE_SIDEBAR_MENU_LIST);
	}

	
	@Description("To validate the navigation menu list") // Allure Annotation to add at test level
	@Owner("Hemlata QA") // Allure Annotation
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void getNavMenuList() {
		List<String> navMenuList = accPage.getNavMenuItems();
		for (String a : navMenuList) {
			System.out.println("Retrived nav menu listed: " + a);
		}

		Assert.assertEquals(navMenuList, AppConstants.ACC_PAGE_NAVIGATION_MENU_LIST);
	}
}
