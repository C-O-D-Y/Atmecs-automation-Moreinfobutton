package com.atmecs.testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.constants.Locators;
import com.atmecs.constants.ValidatingData;
import com.atmecs.dataProvider.TestDataProvider;
import com.atmecs.helpers.WebUtility;
import com.atmecs.logReports.LogReport;
import com.atmecs.pages.HomepageMoreInfo;
import com.atmecs.testBase.TestBase;
import com.atmecs.testflow.HomePageFlowMoreInfo;

public class HomePageMoreInfotestscripts extends TestBase {
	Logger log;
	Locators locators = new Locators();
	HomepageMoreInfo home = new HomepageMoreInfo();
	HomePageFlowMoreInfo flow = new HomePageFlowMoreInfo();
	ValidatingData data = new ValidatingData();
	int counter = 1;

	/*
	 * Test validates the homepage redirection of the atmecs.com
	 */
	@Test(priority = 27)
	public void clickExplorenow() {
		log = Logger.getLogger(HomePageMoreInfotestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("explore Now btn redirection");
		log.info("Starting Redirection validation");
		flow.clickExploreNow();
		home.isRedirectionCorrect(ValidatingData.getValidatingData("titleExploreNow"));
		log.info("Redirection is on the correct page");
		log.info("Starting the MoreInfo buttons testing");
		driver.navigate().back();
		WebUtility.explicitWait(Locators.getLocators("loc.btn.home"));
	}

	@Test(priority = 28, dataProvider = "breadcrumbAndTitle", dataProviderClass = TestDataProvider.class)
	public void clickMoreInfo(String title, String breadcrumb) {

		log = Logger.getLogger(HomePageMoreInfotestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("moreInfo button redirection");
		log.info("Starting Redirection validation");
		flow.clickMoreinfo(counter);
		home.validateBreadCrumbs(breadcrumb);
		home.isRedirectionCorrect(title);
		driver.navigate().back();
		log.info("page navigate Back");
		counter++;
		WebUtility.explicitWait(Locators.getLocators("loc.btn.home"));
	}
}
