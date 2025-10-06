package abhi.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import abhi.generic.baseclassutility.BaseClassForAbhiTek;

public class ListenerImplementingClass implements ITestListener, ISuiteListener {
	
	ExtentReports report;
	ExtentTest test;
	String testName;
	String time = new Date().toString().replace(" ", "_").replace(":", "_");
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("On Start Method");
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("vtiger");
		spark.config().setReportName("crm");
		spark.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "window 11");
		report.setSystemInfo("browser", "chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("On Finish Method");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start Method");
		
		testName = result.getMethod().getMethodName();
		test = report.createTest(testName);
		test.log(Status.INFO, testName + " get started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Success Method");
		
		test.log(Status.PASS, testName + " got pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure Method");
		
		TakesScreenshot tks = (TakesScreenshot)BaseClassForAbhiTek.sdriver;
		String filePath = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath + "_" + time);
		
		test.log(Status.FAIL, testName + " got fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped Method");
		
		test.log(Status.SKIP, testName + " got skipp");
	}
	
}
