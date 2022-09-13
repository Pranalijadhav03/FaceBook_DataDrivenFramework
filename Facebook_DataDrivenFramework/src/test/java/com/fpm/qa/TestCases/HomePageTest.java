package com.fpm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fpm.qa.base.TestBase;
import com.fpm.qa.pages.HomePage;
import com.fpm.qa.pages.LoginPage;
import com.fpm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	HomePage homeLink;
	
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUpHomePage() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}

	@Test(priority = 2)
	public void fpmTitleTest() {
		boolean flag = homePage.validateFPMTitle();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void fpmEventsTest() {
		boolean flag = homePage.validateFPMEvents();
		Assert.assertTrue(flag);
	}

	@Test(priority = 4)
	public void fpmWatchTest() {
		boolean flag = homePage.validateFPMWatch();
		Assert.assertTrue(flag);
	}

	@Test(priority = 5)
	public void fpmMessengerTest() {
		boolean flag = homePage.validateFPMMessenger();
		Assert.assertTrue(flag);
	}

	@Test(priority = 6)
	public void fpmNotificationsTest() {
		boolean flag = homePage.validateFPMNotifications();
		Assert.assertTrue(flag);
	}

	@Test(priority = 7)
	public void fpmfindfirendsTest() {
		boolean flag = homePage.validateFPMfindfirends();
		Assert.assertTrue(flag);
	}

	@Test(priority = 8)
	public void fpmserachTest() {
		boolean flag = homePage.validateFPMserach();
		Assert.assertTrue(flag);
	}

	@Test(priority = 9)
	public void fpmNameLableTest() {
		boolean flag = homePage.validateFPMNameLable();
		Assert.assertTrue(flag);
	}

	@Test(priority = 10)
	public void fpmAddPictureBtnTest() {
		boolean flag = homePage.validateFPMFAddPictureBtn();
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
