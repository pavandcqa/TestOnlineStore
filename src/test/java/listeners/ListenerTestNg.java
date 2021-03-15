package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.TestBase;

public class ListenerTestNg extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		System.out.println("********** Test Execution Started *********");
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("**** Test Passed *****" +  result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("**** Test Failed *****" + result.getName());
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		Date d = new Date();
		
		long time = d.getTime();
		
		System.out.println(time);
		
		File dest = new File("./ScreenShots/" + result.getName() + time + ".png");
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("**** Test Skipped *****");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("**** onTestFailedButWithinSuccessPercentage *****");
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("**** Started Test Execution **** ");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("**** Finised Test Execution **** ");
		
	}

}
