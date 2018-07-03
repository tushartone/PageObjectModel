package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Homepage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'User: Tushar Tone')]")
	WebElement usernameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//initilazinfg the page objects
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomepageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyusernameLabel()
	{
		return usernameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealslink.click();
		return new DealsPage();
	}
}
