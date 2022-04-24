package com.hrms.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.base.Base;
import com.hrms.pageObjects.AdminPage;
import com.hrms.pageObjects.HomePage;
import com.hrms.pageObjects.LoginPage;
import com.hrms.utilities.Utility;

public class AdminPageTest extends Base{
	
	String sheetName="AdminGeneral";
	LoginPage loginpage;
	HomePage homepage;
	AdminPage adminpage;
	
	
	@BeforeMethod()
	public void setUp() throws IOException{
		
	
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		adminpage=homepage.clickAdminLink();
		
	}
	
	@Test(groups="Regression")
	public void verifyAdminPageLabelTest(){
		
		boolean flag=adminpage.verifyPageLabel();
		Assert.assertTrue(flag, "Page Label Doesnot Matched");
	}
	
	
	@DataProvider
	public Object[][] geTestData(){
		
		return Utility.getData(sheetName);
		
		
	}
	
	@Test(dataProvider="geTestData")
	public void verifyAddEmployeeTest(String CompanyName,String TaxID,String Phone,String Country)
	{
		homepage.clickGeneralLink();
		
		adminpage.addCompanyInfo(CompanyName,TaxID,Phone,Country);
	}
	
	

    @AfterMethod
    public void tearDown() throws InterruptedException
    {
    	
    	driver.quit();
    }
}
