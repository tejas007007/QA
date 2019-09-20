package Actions.Login;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import Locators.Login.LoginPage;
import Utilities.OutPut.AllOutPut;
import Utilities.Report.ExtentReporting;

public class LoginPageActions extends ExtentReporting {

	LoginPage obj_LoginPage = new LoginPage();
	AllOutPut AllOutPut_obj= new AllOutPut();
	//JavScriptExecutor Js_obj = new JavScriptExecutor();

	public static String section="";

	public boolean VerifyLoginPageLoad(WebDriver driver,WebDriverWait wt,ExtentTest test) throws IOException
	{
		boolean flag=true;

		try {
			Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.FromCity,test);

			Assert.assertTrue(driver.findElement(obj_LoginPage.mmtlogo).isDisplayed());

			AllOutPut.PASS(driver, test, "Successfully Loaded Login Page");

		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
			AllOutPut.FAIL(driver, test, "Login Page Load Failed");
		}
		return flag;
	}


	public  boolean ClickFromCity(WebDriver driver,WebDriverWait wt,ExtentTest test) throws IOException
	{
		boolean flag=true;
		try {
			Utilities.Common.AllActions.MoveToElementAction(driver, obj_LoginPage.FromCity);
			AllOutPut.PASS(driver, test, "Successfully Clicked on : From City Field");

		} catch (Exception e) {
			System.out.println("Unable to find element: "+obj_LoginPage.FromCity);
			flag= false;
			AllOutPut.FAIL(driver, test, "ClickFromCity() Failed");
		}
		return flag;
	}

	public boolean ClickToCity(WebDriver driver,WebDriverWait wt,ExtentTest test) throws IOException
	{
		boolean flag=true;
		try {
			Utilities.Common.AllActions.MoveToElementAction(driver, obj_LoginPage.ToCity);
			AllOutPut.PASS(driver, test, "Successfully Clicked on : To City Field");
		}
		catch (Exception e) 
		{
			System.out.println("Unable to find element: "+ obj_LoginPage.ToCity);
			flag= false;
			AllOutPut.FAIL(driver, test, "ClickToCity Failed");
		}
		return flag;
	}

	public  void ClickToFromTextField(WebDriver driver,WebDriverWait wt,ExtentTest test) throws InterruptedException, IOException
	{
		try {
			Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.FromCityText, test);
			driver.findElement(obj_LoginPage.FromCityText).click();
			AllOutPut.PASS(driver, test, "Successfully Clicked on From City Textfield");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AllOutPut.FAIL(driver, test, " Failed to Click on From City Textfield : ClickToFromTextField");
		}
	}


	public  void ClickToTextField(WebDriver driver,WebDriverWait wt,ExtentTest test) throws InterruptedException, IOException
	{
		try {
			Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.ToCityText,test);
			driver.findElement(obj_LoginPage.ToCityText).click();
			AllOutPut.PASS(driver, test, "Successfully Clicked To Text Field");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AllOutPut.FAIL(driver, test, "ClickToTextField() Failed");
		}
	}

	public  void AddTextToFromCity(WebDriver driver,WebDriverWait wt,String text,ExtentTest test) throws IOException
	{
		try {
			Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.FromCityText,test);
			driver.findElement(obj_LoginPage.FromCityText).sendKeys(text);
			AllOutPut.PASS(driver, test, "Successfully Added Text To : From City Field");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AllOutPut.FAIL(driver, test, "AddTextToFromCity() Failed");
		}
	}

	public  void AddTextToCity(WebDriver driver,WebDriverWait wt,String text,ExtentTest test) throws IOException
	{
		try {
			Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.ToCityText,test);
			driver.findElement(obj_LoginPage.ToCityText).sendKeys(text);
			AllOutPut.PASS(driver, test, "Successfully Added Text To : To City Field");
		} catch (Exception e) {
			e.printStackTrace();
			AllOutPut.FAIL(driver, test,"AddTextToCity() Failed");
		}
	}


	public  boolean SelectFromList(WebDriver driver,WebDriverWait wt,String text,ExtentTest test) throws InterruptedException, IOException
	{

		boolean flag=true;
		Utilities.Common.AllWaitMethods.WaitForSpecificTime(4000);

		if(Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.SelectFromList(text),test))
		{
			driver.findElement(obj_LoginPage.SelectFromList(text)).click();
			AllOutPut.PASS(driver, test, "Successfully Selected Code From The list");
		}
		else
		{
			AllOutPut.FAIL(driver, test,"SelectFromList() Failed");
			flag=false;
		}
		return flag;
	}

	public  boolean ClicktoDeparture(WebDriver driver,WebDriverWait wt,ExtentTest test) throws IOException
	{
		boolean flag=true;

		Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.DepartureDate,test);

		if(Utilities.Common.AllActions.MoveToElementAction(driver, obj_LoginPage.DepartureDate))
			AllOutPut.PASS(driver, test, "Successfully Clicked on Departure Date Field");
		else
		{
			AllOutPut.FAIL(driver, test,"ClicktoDeparture() Failed");
			flag=false;
		}
		return flag;
	}

	public  boolean ClicktoReturn(WebDriver driver,WebDriverWait wt,ExtentTest test) throws IOException
	{
		boolean flag=true;

		Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.ReturnDate,test);

		if(Utilities.Common.AllActions.MoveToElementAction(driver, obj_LoginPage.ReturnDate))
			AllOutPut.PASS(driver, test, "Successfully Clicked on Return Date Field");
		else
		{
			AllOutPut.FAIL(driver, test,"ClicktoReturn() Failed");
			flag=false;
		}
		return flag;
	}

	public  boolean NavigateToMonth(WebDriver driver,WebDriverWait wt,String month,ExtentTest test) throws InterruptedException, IOException
	{
		boolean flag=true;
		Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.MonthSelectorLeft,test);
		try
		{
			if(!driver.findElement(obj_LoginPage.MonthSelectorLeft).getText().toString().replaceAll(" ","").equals(month.replaceAll(" ",""))||
					!driver.findElement(obj_LoginPage.MonthSelectorRight).getText().toString().replaceAll(" ","").equals(month.replaceAll(" ","")))
			{
				if(!driver.findElement(obj_LoginPage.MonthSelectorLeft).getText().toString().replaceAll(" ","").equals(month.replaceAll(" ","")))
				{
					while(!driver.findElement(obj_LoginPage.MonthSelectorRight).getText().toString().replaceAll(" ","").equals(month.replaceAll(" ","")))
					{
						driver.findElement(obj_LoginPage.NextMonthArrow).click();
						Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.MonthSelectorRight,test);
						Utilities.Common.AllWaitMethods.WaitForSpecificTime(1000);
						section="right";
					}
				}
				else
				{
					section="left";
					Utilities.Common.AllWaitMethods.WaitForSpecificTime(2000);
				}
			}
			else
			{
				section="left";
				Utilities.Common.AllWaitMethods.WaitForSpecificTime(2000);
			}

			AllOutPut.PASS(driver, test, "Successfully Navigated to the Month :"+month);
		}
		catch (Exception e) {
			flag=false;
			e.printStackTrace();
			AllOutPut.FAIL(driver, test, "Mentioned Month not found :"+month);

		}
		System.out.println("SECTION WAS :"+ section);
		return flag;
	}

	public boolean SelectDepartureDate(WebDriver driver,WebDriverWait wt,int date,ExtentTest test) throws IOException
	{
		boolean flag=true;
		Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.MonthDateSelector(date,section),test);
		if(Utilities.Common.AllActions.MoveToElementAction(driver, obj_LoginPage.MonthDateSelector(date,section)))
			AllOutPut.PASS(driver, test, "Successfully Selected Departure Date");
		else
		{
			AllOutPut.FAIL(driver, test, "SelectDepartureDate() Failed");
			flag=false;
		}
		return flag;
	}

	public boolean SelectReturnDate(WebDriver driver,WebDriverWait wt,int date,ExtentTest test) throws IOException
	{
		boolean flag=true;
		Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.MonthDateSelector(date,section),test);
		if(Utilities.Common.AllActions.MoveToElementAction(driver, obj_LoginPage.MonthDateSelector(date,section)))
			AllOutPut.PASS(driver, test, "Successfully Selected Return Date");
		else
		{
			AllOutPut.FAIL(driver, test, "SelectDepartureDate() Failed");
			flag=false;
		}
		return flag;
	}

	public boolean ClickToSearchButton(WebDriver driver,WebDriverWait wt,ExtentTest test) throws IOException
	{
		boolean flag=true;
		Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.SearchButton,test);
		if(Utilities.Common.AllActions.MoveToElementAction(driver, obj_LoginPage.SearchButton)
				&& Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.FlightsListFooter, test))
			AllOutPut.PASS(driver, test, "Successfully Clicked on SearchButton");

		else
		{
			AllOutPut.FAIL(driver, test, "ClickToSearchButton() Failed");
			flag=false;
		}
		return flag;
	}

	public boolean SelectCheapFlight(WebDriver driver,WebDriverWait wt,ExtentTest test) throws IOException
	{
		boolean flag=true;
		int index=0;

		Utilities.Common.AllWaitMethods.WaitUntilVisible(wt, obj_LoginPage.FlightsListFooter,test);

		List<WebElement> list = driver.findElements(obj_LoginPage.FlightListCost);

		System.out.println("FlightListCost List Size:"+list.size());

		Integer []linkText =new Integer[list.size()];
		int i=0;

		for(WebElement a: list)
		{
			linkText[i]=Integer.parseInt(a.getText().replaceAll("[^0-9]", ""));
			i++;
		}

		Arrays.sort(linkText);

		for(Integer value: linkText)
		{
			System.out.println(value);
		}		

		//		index=Utilities.Common.AllActions.getMinValue(linkText);
		//		
		//	System.out.println("Index is :"+index);
		return flag;
	}
}
