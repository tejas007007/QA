package Login;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Actions.Login.LoginPageActions;
import Data.ApplicationCredentials.*;
import Utilities.Report.ExtentReporting;

public class LoginToMakeMyTrip extends MakeMyTripLoginCredential{

	String str_url= MakeMyTripLoginCredential.str_url;
	String str_from_city=Data.Login.LoginData.str_from_city;
	String str_to_city=Data.Login.LoginData.str_to_city;
	String str_from_code=Data.Login.LoginData.str_from_city_code;
	String str_to_code=Data.Login.LoginData.str_to_city_code;
	String ExecutionBrowserName="firefox";

	public WebDriver driver= Utilities.Driver.InitiateSeleniumDriver.GetDriver(ExecutionBrowserName);
	WebDriverWait wt = new WebDriverWait(driver, 30);

	String ExtentReportName="Login";
	String ExtentReportDesc="Login Reporting";

	String DepartureMonth="November 2019";
	int DepartureDate=1;
	
	String ReturnMonth="December 2019";
	int ReturnDate=15;

	ExtentTest ExtentTest_Obj_test = Utilities.Report.ExtentReporting.SetReport(ExtentReportName,ExtentReportDesc);
	LoginPageActions LoginPageActions_obj = new LoginPageActions();

	@Test(priority = 1)
	public void VerifyLogin() throws InterruptedException, IOException
	{
		try {
			driver.get(str_url);
			ExtentTest_Obj_test.log(LogStatus.PASS,"URL "+str_url+" is loaded");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("URL "+str_url+" is not loaded");
			ExtentTest_Obj_test.log(LogStatus.FAIL,"URL "+str_url+" is not loaded");
		}

		Assert.assertTrue(LoginPageActions_obj.VerifyLoginPageLoad(driver, wt, ExtentTest_Obj_test), "Login Page Load Failed");
	}

	@Test(priority = 2)
	public void SelectFromAndToOnLoginPage() throws InterruptedException, IOException
	{

		// From City Code
		Assert.assertTrue(LoginPageActions_obj.ClickFromCity(driver,wt,ExtentTest_Obj_test),"Method : ClickToFrom() Failed");

		LoginPageActions_obj.ClickToFromTextField(driver, wt,ExtentTest_Obj_test);

		LoginPageActions_obj.AddTextToFromCity(driver,wt,str_from_city,ExtentTest_Obj_test);

		LoginPageActions_obj.SelectFromList(driver,wt,str_from_code,ExtentTest_Obj_test);

		//  City Code

		Assert.assertTrue(LoginPageActions_obj.ClickToCity(driver,wt,ExtentTest_Obj_test), "Method : ClickToCity() Failed");

		LoginPageActions_obj.ClickToTextField(driver, wt,ExtentTest_Obj_test);

		LoginPageActions_obj.AddTextToCity(driver,wt,str_to_city,ExtentTest_Obj_test);

		LoginPageActions_obj.SelectFromList(driver,wt,str_to_code,ExtentTest_Obj_test);

	}

	@Test(priority = 3)
	public  void SelectDepartureDate () throws IOException, InterruptedException
	{
		Assert.assertTrue(LoginPageActions_obj.ClicktoDeparture(driver, wt,ExtentTest_Obj_test),"Click to DepartureFieldFailed");

		Assert.assertTrue(LoginPageActions_obj.NavigateToMonth(driver, wt, DepartureMonth, ExtentTest_Obj_test), "Mentioned Month not found");

		Assert.assertTrue(LoginPageActions_obj.SelectDepartureDate(driver, wt, DepartureDate, ExtentTest_Obj_test),"SelectDepartureDate() Failed");
	}
	
	@Test(priority = 4)
	public  void SelectReturnDate () throws IOException, InterruptedException
	{
		Assert.assertTrue(LoginPageActions_obj.ClicktoReturn(driver, wt,ExtentTest_Obj_test),"Click to Return Field Failed");

		Assert.assertTrue(LoginPageActions_obj.NavigateToMonth(driver, wt, ReturnMonth, ExtentTest_Obj_test), "Mentioned Month not found");

		Assert.assertTrue(LoginPageActions_obj.SelectReturnDate(driver, wt, ReturnDate, ExtentTest_Obj_test),"SelectReturnDate() Failed");
	}
	
	
	@Test(priority = 5)
	public  void SearchFlights () throws IOException, InterruptedException
	{
		Assert.assertTrue(LoginPageActions_obj.ClickToSearchButton(driver, wt, ExtentTest_Obj_test),"SearchFlights Failed");
		
		LoginPageActions_obj.SelectCheapFlight(driver, wt, ExtentTest_Obj_test);

	}
	
	@Test(priority = 6)
	public  void CloseTest () throws IOException
	{
		ExtentReporting.CloseReport(ExtentTest_Obj_test);
		//driver.close();
	}
}
