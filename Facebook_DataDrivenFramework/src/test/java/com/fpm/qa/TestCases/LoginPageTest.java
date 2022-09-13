package com.fpm.qa.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.fpm.qa.base.TestBase;
import com.fpm.qa.pages.HomePage;
import com.fpm.qa.pages.LoginPage;
import com.fpm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	Logger logger = Logger.getLogger(LoginPageTest.class);

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		 logger.info("lunch browser");
	}
	
	
	//----------------------------Data Driven Framework----------------
	
	@Test(dataProvider = "dataprovider1")
	public void  login(String email, String password) throws InterruptedException {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.quit();	
	}
	
	//Data Driven
		@DataProvider
		public Object[][] dataprovider1(){
			Object[][] data= new Object[3][2];
			data[0][0] = "jadhav.pranali2403@gmail.com";
			data[0][1] ="Pranalij@2403";
			
			data[1][0] = "jadhav.pranali24@gmail.com";
			data[1][1] ="Pranalij@24";
			
			data[2][0] = "jadhav.pranali03@gmail.com";
			data[2][1] ="Pranalij@03";
			return data;
		}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		logger.info("---------Start test run----------------------");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
		logger.info("----------------end log ---------------");
	}

	@Test(priority = 2)
	public void fpmLogoImageTest() {
		logger.info("---------Start test run----------------------");
		boolean flag = loginPage.validateFPMImage();
		Assert.assertTrue(flag);
		logger.info("----------------end log ---------------");
	}

	@Test(priority = 3)
	public void EnterEmailTest() {
		logger.info("---------Start test run----------------------");
		loginPage.EnterEmail(prop.getProperty("email"));
		logger.info("----------------end log ---------------");
	}

	@Test(priority = 4)
	public void EnterPasswordTest() {
		logger.info("---------Start test run----------------------");
		loginPage.EnterPassword(prop.getProperty("password"));
		logger.info("----------------end log ---------------");
	}

	@Test(priority = 5)
	public void loginTest() {
		logger.info("---------Start test run----------------------");
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		logger.info("----------------end log ---------------");
	}

	@Test(priority = 6)
	public void validateFPMLoginBtnTest() {
		logger.info("---------Start test run----------------------");
		boolean flag = loginPage.validateFPMLoginBtn();
		Assert.assertTrue(flag);
		logger.info("----------------end log ---------------");
	}

	@Test(priority = 7)
	public void fpmSignUpBtnTest() {
		logger.info("---------Start test run----------------------");
		boolean flag = loginPage.validateFPMsignUpBtn();
		Assert.assertTrue(flag);
		logger.info("----------------end log ---------------");
	}

	@Test(priority = 8)
	public void fpmForgotPaswordTest() {
		logger.info("---------Start test run----------------------");
		boolean flag = loginPage.validateFPMforgotpassword();
		Assert.assertTrue(flag);
		logger.info("----------------end log ---------------");
	}

	@Test(priority = 9)
	public void fpmMLableTest() {
		logger.info("---------Start test run----------------------");
		boolean flag = loginPage.validateFPMLable();
		Assert.assertTrue(flag);
		logger.info("----------------end log ---------------");
	}

	@Test(priority = 10)
	public void fpmSecondSLableTest() {
		logger.info("---------Start test run----------------------");
		boolean flag = loginPage.validateFPMSecondSLable();
		Assert.assertTrue(flag);
		logger.info("----------------end log ---------------");
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
