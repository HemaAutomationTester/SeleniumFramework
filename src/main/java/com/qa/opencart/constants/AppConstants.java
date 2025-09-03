package com.qa.opencart.constants;

import java.util.List;

public class AppConstants {

	public static final List<String> ACC_PAGE_SIDEBAR_MENU_LIST = List.of("My Account", "Edit Account", "Password",
			"Address Book", "Wish List", "Order History", "Downloads", "Recurring payments", "Reward Points", "Returns",
			"Transactions", "Newsletter", "Logout");

	public static final List<String> ACC_PAGE_NAVIGATION_MENU_LIST = List.of("Desktops", "Laptops & Notebooks",
			"Components", "Tablets", "Software", "Phones & PDAs", "Cameras", "MP3 Players");
	
	
	public static final String SEARCH_KEYWORD = "macbook";
	
	public static final String REGISTER_SUCCESS_MESSAGE = "Your Account Has Been Created!";
	public static final String REGISTER_SUCCESS_PARTIAL_URL = "?route=account/success";
}
