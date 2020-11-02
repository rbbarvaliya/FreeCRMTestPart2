package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated- independent with each other
	//before each test case - launch the browser and login
	//@test- execute cases
	//after each test case - close browser
	

	@BeforeMethod 
	public void setUp() throws IOException {
		initialization ();
		log.info("launching browser for HomepageTest");
	    loginPage = new LoginPage();
	    contactsPage = new ContactsPage();
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    log.info("homepage is here");
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		log.info("homepage Titletest");
		String homePageTitle = homePage.verifyHomePageTititle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		log.info("contactverification test");
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifycontactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod 
	public void tearDown() {
		log.error("This is error for Homepagebrowser closing");
		driver.quit();
	}
	
	
	
	
}

