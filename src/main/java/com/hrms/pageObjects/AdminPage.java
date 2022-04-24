package com.hrms.pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.hrms.base.Base;
import com.hrms.utilities.Utility;

public class AdminPage extends Base {
	
	public AdminPage(){
		
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(xpath="//*[contains(text(),'Company Info : General')]")
    private WebElement adminPageLabel;
	
	@FindBy(id="txtCompanyName")
	private WebElement txt_Company;
	
	@FindBy(id="txtTaxID")
	private WebElement txt_TaxID;
	
	@FindBy(id="txtPhone")
	private WebElement txt_Phone;
	
	@FindBy(id="cmbCountry")
	private WebElement drop_Country;
	
	@FindBy(xpath="//input[@class='editbutton']")
	private WebElement btn_Edit;
	
	@FindBy(xpath="//input[@class='savebutton']")
	private WebElement btn_Save;
	
    public boolean verifyPageLabel(){
    	
    	return adminPageLabel.isDisplayed();
    }
    
 
    
    public void addCompanyInfo(String CompanyName,String TaxID,String Phone,String Country){
    	
    	
    	Utility.enterFrame();
    	Reporter.log("Entered intot Frame");
    	btn_Edit.click();
    	txt_Company.clear();
    	txt_Company.sendKeys(CompanyName);
    	txt_TaxID.clear();
    	txt_TaxID.sendKeys(TaxID);
    	txt_Phone.clear();
    	txt_Phone.sendKeys(Phone);
    	Select s=new Select(drop_Country);
    	s.selectByVisibleText(Country);
    	btn_Save.click();
    	
    }
    
    
    
    
    
	
    
}
