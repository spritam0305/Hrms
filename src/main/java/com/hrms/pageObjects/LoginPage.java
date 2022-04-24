package com.hrms.pageObjects;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.base.Base;

public class LoginPage extends Base{
	
   
	
	public LoginPage(){
		
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(name="txtUserName")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@src,'orange_new_02.gif')]")
	WebElement hrmslogo;
	
	public HomePage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLogo()
	{
		return hrmslogo.isDisplayed();
	}
	
	

}
