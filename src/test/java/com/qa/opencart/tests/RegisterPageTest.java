package com.qa.opencart.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.ExcelUtil;


public class RegisterPageTest extends BaseTest {
	
	
	@BeforeTest
	public void goToRegister() {
		regPage = logPage.goToRegister();
	}
	
	@DataProvider
	public Object[][] getRegExcel(){
		return ExcelUtil.getTestData("register");
	}

	
	@Test(dataProvider="getRegExcel")
	public void doRegistrationTest(String firstName, String lastName, String phone, String password,
		 String susbscribe ) {
		regPage.fillRegisterForm(firstName, lastName, com.qa.opencart.utils.StringUtils.getRandomEMail(), phone, password, susbscribe);
	}

}
