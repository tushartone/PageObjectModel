package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//page factory : OR 
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[contains(@value,'Login')]")
	WebElement lgnButton;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signButton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	
	//now we have to initliaze the all this object repo with help of page factory . now to crate the condstuctor
	//iniliaze the page object 
	public LoginPage()
	{
		PageFactory.initElements(driver, this);  // this means poinitng to current class object
	}
	
	//Actions --diff feature availbale ibn loginpage
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public Homepage login(String un , String pwd) throws Exception
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(1000);
		lgnButton.click();
		
		return new Homepage();  // it return the homepage class object
	}
	
}
