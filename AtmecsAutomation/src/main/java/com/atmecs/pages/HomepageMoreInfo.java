package com.atmecs.pages;

import org.testng.Assert;

import com.atmecs.constants.Locators;
import com.atmecs.constants.ValidatingData;
import com.atmecs.helpers.WebUtility;

public class HomepageMoreInfo {

	static Locators loc = new Locators();
	ValidatingData data = new ValidatingData();

	/**
	 * In this method i'm validating the functionality of redirecting the page is
	 * correct.
	 * 
	 * @param driver
	 */
	public void isRedirectionCorrect(String getTitle) {

		String title = WebUtility.getTitle();
		Assert.assertEquals(title, getTitle, "Redirection is not on the correct page");
		System.out.println("Redirection is on the correct page");
	}

	public void validateBreadCrumbs(String getBreadCrumb) {
		WebUtility.explicitWait(Locators.getLocators("loc.moreInfoBtn.text.breadcrumb"));
		String breadCrumb = WebUtility.getText(Locators.getLocators("loc.moreInfoBtn.text.breadcrumb"));
		Assert.assertEquals(breadCrumb, getBreadCrumb, "Bread crumb is in the wrong format");
		System.out.println("Breadcrumb is right of the page");
	}

	public void validatePageTitle(String pagetitle) {
		String getPagetitle = WebUtility.getText(Locators.getLocators("loc.getPageTitle.text"));
		Assert.assertEquals(pagetitle, getPagetitle, "Redirection is on the wrong page");
		System.out.println("Page title is correct");
	}

}
