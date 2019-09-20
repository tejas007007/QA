package Utilities.Report;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.Common.IssueReporting;


public class ExtentReporting extends IssueReporting{

	static ExtentReports reports;
	static ExtentTest test;
	public static String CurrentRunPath;
	public static ExtentTest SetReport(String Reportname,String ReportDescription) {

		LocalDate date = java.time.LocalDate.now();

		reports = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\Run_"+getPropValueForProp()+" Date_"+date+"\\"+Reportname+"_Result.html", false);

		CurrentRunPath=System.getProperty("user.dir")+"\\Reports\\Run_"+getPropValueForProp()+" Date_"+date+"\\";
		
		test = reports.startTest(Reportname, ReportDescription);

		return test;
	} 

	public static void CaptureScreenshot(ExtentTest test,WebDriver driver,String screenShotName) throws IOException
	{
		String screenShotPath = IssueReporting.capture(driver, "screenShotName",CurrentRunPath);
		test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
	}

	public static String getPropValueForProp()
	{
		String value = null;
		try {
			String filepath = "./src/main/java/Utilities/Report/ReportConfig.properties";
			FileInputStream in = new FileInputStream(filepath);
			Properties props = new Properties();
			props.load(in);
			in.close();
			value=props.getProperty("Build_Run_Count");
			FileOutputStream out = new FileOutputStream(filepath);
			props.store(out, null);
			out.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void UpdateValueForProp() throws IOException
	{

		int currentvalue=Integer.parseInt(getPropValueForProp());

		String filepath = "./src/main/java/Utilities/Report/ReportConfig.properties";
		FileInputStream in = new FileInputStream(filepath);
		Properties props = new Properties();
		props.load(in);
		in.close();

		props.setProperty("Build_Run_Count", Integer.toString(currentvalue+1));
		FileOutputStream out = new FileOutputStream(filepath);
		props.store(out, null);
		out.close();
	}

	public static void CloseReport(ExtentTest test) throws IOException
	{
		UpdateValueForProp();
		reports.endTest(test);
		reports.flush();
	}
}