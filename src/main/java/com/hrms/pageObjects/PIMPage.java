package com.hrms.pageObjects;

import com.hrms.base.Base;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class PIMPage extends Base{
	
	PIMPage(){
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='txtEmpFirstName']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='txtEmpLastName']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name='txtEmpMiddleName']")
	private WebElement middleName;
	
	@FindBy(xpath="//input[@name='txtEmpNickName']")
	private WebElement nickName;
	
	@FindBy(xpath="//input[@name='photofile']")
	private WebElement chooseFile;
	
	@FindBy(xpath="//input[@id='btnEdit']")
	private WebElement saveButton;
	
	
	public void addEmployee(String FName,String MName,String LName,String NicName){
		
		firstName.sendKeys(FName);
		middleName.sendKeys(MName);
		lastName.sendKeys(LName);
		nickName.sendKeys(NicName);
		saveButton.click();
      
		
	}
	
	
	
	
	
	

}
