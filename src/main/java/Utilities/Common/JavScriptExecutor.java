package Utilities.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavScriptExecutor {

	public static void Highlight(WebDriver driver,By elem) throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		Thread.sleep(1000);
	}
}
