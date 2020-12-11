 package com.crm.qa.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();	
	}
	
	@BeforeMethod (alwaysRun = true)
	public void setUp() throws IOException {
		initialization();
		log.info("******************launching browser for LoginPageTest Test****************");
	    loginPage = new LoginPage();
		log.info("entering in to application");
	}
	
	@Test (groups="sanity") 
	public void loginPageTitleTest() {
		log.info("LoginpageTitleTest");
		String title = loginPage.validateLoginPageTitle(); 
		log.warn("This is warning for login title");
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test (groups= {"smoke"})
	public void loginTest() {
		log.info("LoginTest");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.fatal("this is fatal for id and password");
	}
	

	@AfterMethod (alwaysRun = true)
	public void tearDown() {
		log.error("This is error for loginpagebrowser closing");
		driver.quit();
		
	}
}
 