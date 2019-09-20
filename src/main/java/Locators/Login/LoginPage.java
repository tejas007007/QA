package Locators.Login;

import org.openqa.selenium.By;

public class LoginPage {
	

	public  By mmtlogo=By.xpath("//a[@class='mmtLogo makeFlex']/img");

	public  By FromCity= By.xpath("//label[@for='fromCity']//input[@id='fromCity']");
	public  By ToCity= By.xpath("//label[@for='toCity']//input[@id='toCity']");

	public  By FromCityText= By.xpath("//div[@class='react-autosuggest__container react-autosuggest__container--open']/input[@type='text' and @placeholder='From']");
	public  By ToCityText= By.xpath("//div[@class='react-autosuggest__container react-autosuggest__container--open']/input[@type='text' and @placeholder='To']");

	public  By SelectFromList(String listname){
		return By.xpath("(//div[@class='pushRight font14 lightGreyText latoBold'][text()='"+listname+"'])[1]");}

	public  By DepartureDate=By.xpath("//label[@for='departure']");
	
	public  By ReturnDate=By.xpath("//div[@class='fsw_inputBox dates reDates inactiveWidget ']/div/label");
	
	public  By NextMonthArrow=By.xpath("//div[@class='DayPicker-NavBar']//span[@aria-label='Next Month']");
	
	public  By MonthSelectorLeft=By.xpath("(//div[@class='DayPicker-Month']//div[@class='DayPicker-Caption']/div)[1]");
	public  By MonthSelectorRight=By.xpath("(//div[@class='DayPicker-Month']//div[@class='DayPicker-Caption']/div)[2]");
	
	public By MonthDateSelector(int date,String section)
	{
		if(section=="left")
			return By.xpath("(//div[@class='dateInnerCell']/p[text()='"+date+"'])[1]");
		else
			return By.xpath("(//div[@class='dateInnerCell']/p[text()='"+date+"'])[2]");
	}
	
	public By SearchButton =By.xpath("//p[@class='makeFlex vrtlCenter ']/a[@class='primaryBtn font24 latoBlack widgetSearchBtn ']");
	
	public By FlightsListFooter =By.xpath("//div[@class='splitVw-footer slideUp']");
	
	public By FlightListCost=By.xpath("//div[@class='fli-list-body-section clearfix']//span[@class='actual-price']");
	
}