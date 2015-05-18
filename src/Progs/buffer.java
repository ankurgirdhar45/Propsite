package Progs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



public class buffer 
{	
	@Test
	public void getURLStatus()
	{
		WebDriver d = new FirefoxDriver();
		d.get("https://www.proptiger.com");
		List<WebElement> s = d.findElements(By.tagName("a"));
		for (WebElement e:s)
		{
			System.out.println(e.getAttribute("href") + "text is " + e.getText());
		}
	}
}
