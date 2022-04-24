package com.hrms.utilities;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.hrms.base.Base;

public class Listeners extends Base implements ITestListener {

	ExtentSparkReporter  reporter= new ExtentSparkReporter(Utility.getBasePath() + "\\TestReport\\report.html");
	ExtentReports extent = new ExtentReports();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentReport=new ThreadLocal<ExtentTest>();
	String ClassName;

	public void onTestStart(ITestResult result) {
		
		
		
		reporter.config().setDocumentTitle("Human Resource Management System");
		reporter.config().setReportName("Automation Testing Report");
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pritam Singh");
		test=extent.createTest(result.getMethod().getMethodName());
		extentReport.set(test);

	}

	public void onTestSuccess(ITestResult result) {

		

	}

	public void onTestFailure(ITestResult result) {
      
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(Utility.getBasePath() + "\\TestReport\\Screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//extentReport.get().addScreenCaptureFromPath();
		

	}
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
}
