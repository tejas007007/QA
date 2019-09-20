package Utilities.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class InitiateSeleniumDriver {


	public static WebDriver GetDriver(String browser)
	{
		String browsername=browser.toLowerCase();
		WebDriver driver = null;
		
			switch (browsername)
			{
			case "chrome":
				System.out.println("Chrome Browser Selected");
				System.setProperty("webdriver.chrome.driver", "D:\\G L V\\Automation\\drivers\\chromedriver.exe");

				driver= new ChromeDriver();
				driver.manage().window().maximize();
				break;
				
			case "firefox":
				System.out.println("FireFox Browser Selected");
				System.setProperty("webdriver.gecko.driver", "D:\\G L V\\Automation\\drivers\\geckodriver.exe");

				driver= new FirefoxDriver();
				driver.manage().window().maximize();
				break;

			default:
				System.out.println("Invalid Browser was specified \n");
				System.out.println("Specified Browser Driver Not Found! \n Please Select From \n 1.Chrome \n 2.Firefox");
				break;
			}
		return driver;
	}
}
