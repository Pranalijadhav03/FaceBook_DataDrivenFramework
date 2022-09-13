package com.fpm.qa.BaseClass;

import org.openqa.selenium.chrome.ChromeDriver;

import com.fpm.qa.util.TestUtil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	 public static WebDriver driver;

	    public void setProperties(){
	System.setProperty("webdriver.chrome.driver",  "C:\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("https://www.facebook.com/");
     driver.manage().window().maximize();
     driver.manage().deleteAllCookies();
 	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
     driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
 }
}
