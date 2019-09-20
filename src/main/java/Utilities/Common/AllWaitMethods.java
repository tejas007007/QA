package Utilities.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AllWaitMethods {

	public static boolean WaitUntilVisible(WebDriverWait wt, By element, ExtentTest test)
	{
		boolean flag=true;
		try
		{
			wt.until(ExpectedConditions.visibilityOfElementLocated(element));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			flag=false;
			test.log(LogStatus.FAIL, "Element Not Found :"+element+" ");
		}	
		return flag;
	}

	public static boolean WaitUntilElementClickable(WebDriverWait wt, By element,ExtentTest test)
	{
		boolean flag=true;
		try
		{
			wt.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			flag=false;
			test.log(LogStatus.FAIL, "Element Not Found :"+element+" ");
		}	
		return flag;
	}

	public static void WaitForSpecificTime(long time) throws InterruptedException
	{
		Thread.sleep(time);
	}

}
