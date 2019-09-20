package Utilities.Common;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AllActions {

	public static boolean MoveToElementAction(WebDriver driver,By loc)
	{
		boolean flag=true;
		try
		{
			WebElement element = driver.findElement(loc);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Move To Element Action Failed on Element :"+ loc);
			flag=false;
		}
		System.out.println("MoveToElementAction Flag value :" +flag);
		return flag;
	}

	public static int getMinValue(Integer[] a)
	{
		Arrays.sort(a);
		int min = a[0];
	       int index=0;

	       for(int i = 0; i < a.length; i++)
	       {
	            if(min <= a[i])
	            {
	                min = a[i];
	                index=i;
	            }
	        }
		return index;
	} 
}
