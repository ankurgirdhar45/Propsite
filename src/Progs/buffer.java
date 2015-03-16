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
	public void foo()
	{
		System.out.println("inside foo");
		WebDriver d = new FirefoxDriver();
		d.get("http://www.webpagetest.org/result/150316_63_CYS/");
		List<WebElement> ele= d.findElements(By.xpath("//table[@id='tableResults']/tbody/tr/td"));
		System.out.println(ele.size());
		for (WebElement e : ele)
		{
			System.out.println(e.getText());
		}
	}
	public void bar()
	{
		System.out.println("inside bar");
	}
}
