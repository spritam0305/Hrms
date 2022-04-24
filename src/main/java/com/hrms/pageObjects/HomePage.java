package com.hrms.pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.base.Base;
import com.hrms.utilities.Utility;

public class HomePage extends Base{
	
	public HomePage(){
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//div[@id='companyLogoHeader']")
	private WebElement companyLogo; 
	
	@FindBy(linkText="Admin")
	private WebElement adminLink;
	
	@FindBy(linkText="Company Info")
	private WebElement companyinfoLink;
	
	@FindBy(linkText="General")
	private WebElement generalLink;
	
	@FindBy(xpath="//*[contains(text(),'PIM')]")
	private WebElement pimLink;
	
	@FindBy(linkText="Add Employee")
	private WebElement addEmployee;
	
	@FindBy(xpath="//a[@href='./index.php?menu_no_top=leave']")
	private WebElement LeaveLink;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement LogoutButton;
	
	public String validateTitle(){
		return driver.getTitle();
	}
	
	public String validateLogo()
	{
		return companyLogo.getText();
	}
	
	public AdminPage clickAdminLink()
	{
		adminLink.click();
		return new AdminPage();
	}
	public PIMPage clickPimLink()
	{
		pimLink.click();
		return new PIMPage();
	}
	
	public LeavePage clickLeaveLink()
	{
		LeaveLink.click();
		return new LeavePage();
	}
	
	public WebElement logout(){
	   	
		return LogoutButton;
	}
	public void clickGeneralLink(){
		
		
		
		Utility.mouseOver(adminLink);
		Utility.mouseOver(companyinfoLink);
		Utility.mouseOver(generalLink);
		
		
		
	}
	
    public void clickaddEmployeeLink(){
    	
    	Utility.mouseOver(pimLink).build().perform();
    	Utility.mouseOver(addEmployee).click().build().perform();
    }
	
    public void Logout(){
    	LogoutButton.click();
    }
	
	
	
	
	
}
