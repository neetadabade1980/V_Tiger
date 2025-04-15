package Generic_Utilities;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener {
	
	ExtentReports report;
	
	ExtentTest test;	
	

	@Override
	public void onTestStart(ITestResult result) {
		
		test = report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getMethod().getMethodName());
		
		test.log(Status.PASS, result.getThrowable());
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL, result.getMethod().getMethodName());
		
		test.log(Status.FAIL, result.getThrowable());
		
		String screenShot = null;
		try {
			
			screenShot =WebDriver_Utility.takeScreenShotEx(BaseClass.sdriver, result.getMethod().getMethodName());
			
		} catch(Throwable e) {
			
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenShot);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP, result.getMethod().getMethodName());
		
		test.log(Status.SKIP, result.getThrowable());
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		String dateAndTime = new Date().toString().replace(" "," ").replace(":","_");
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/report.html"+dateAndTime);
		
		spark.config().setTheme(Theme.STANDARD);
		
		spark.config().setDocumentTitle("VTigerReport");
		
		spark.config().setReportName("Neeta");
		
		// system configure
		
		report = new ExtentReports();
		
		report.attachReporter(spark);
		
		report.setSystemInfo("platform", "windows");
		report.setSystemInfo("executed by ", "neets");
		report.setSystemInfo("reviewed", "smith");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
		
	}

	
	
	
	
	
	
	
	
	
	
}
