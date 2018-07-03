package com.crm.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestBase{
	LoginPage loginpage;
	Homepage homepage;

	public LoginTest() {
	super();	
	}
	
	@BeforeMethod
	public void setUP()
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title,"Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void crmLoginTest() throws Exception
	{
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
