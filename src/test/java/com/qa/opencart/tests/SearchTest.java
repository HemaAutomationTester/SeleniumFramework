package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class SearchTest extends BaseTest {


	@BeforeClass
	public void SetUp() {
		accPage = logPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		searchResultPage = accPage.doSearch(AppConstants.SEARCH_KEYWORD);
	}
	
	@Test
	public void searchPageHeaderTest() {
	String header =	searchResultPage.getSearchPageHeader();
	System.out.println("Search Page Header: " + header);
	Assert.assertEquals(header, "Search - " + AppConstants.SEARCH_KEYWORD );
	}
	
	@Test
	public void searchPageSubHeaderTest() {
		String subHeader = searchResultPage.getSearchPageSubHeader();
		System.out.println("Search Page Sub-Header: " + subHeader);
		Assert.assertEquals(subHeader, "Products meeting the search criteria");
	}

}
