package Utilities.OutPut;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.Report.ExtentReporting;

public class AllOutPut extends ExtentReporting{
	
	
	public static void PASS(WebDriver driver, ExtentTest test,String message)
	{
		test.log(LogStatus.PASS, message);
		System.out.println("CONSOLE INFO: "+message);
	}
	
	public static void FAIL(WebDriver driver, ExtentTest test,String message) throws IOException
	{
		test.log(LogStatus.FAIL, message);
		System.out.println("CONSOLE INFO: "+message);
		CaptureScreenshot(test, driver, message);;
	}

}
