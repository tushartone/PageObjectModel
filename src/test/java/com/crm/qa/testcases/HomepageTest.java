package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;

public class HomepageTest extends TestBase{
	LoginPage loginpage;
	 Homepage homepage;
	public HomepageTest() {
		super();	
		}
	
	@BeforeMethod
	public void setUP() throws Exception
	{
		initialization();
		loginpage = new LoginPage();
		homepage =loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void verifyhomepageTitleTest()
	{
		String homepagetitle = homepage.verifyHomepageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Title is not correct");
	}
	
	@Test
	public void verifyusernameLabelTest()
	{
		boolean b = homepage.verifyusernameLabel();
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
