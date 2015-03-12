package Progs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Login 
{
	@Test
	public void login()
	{
		WebDriver d = new FirefoxDriver();
		//d.get("https://www.proptiger.com");
		d.get("https://www.proptiger.com");
		d.findElement(By.xpath("//span[text()='Sign In']")).click();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//existing user sign in
		d.findElement(By.xpath("//input[@id='login-id']")).sendKeys("ankur.girdhar@proptiger.com");
		d.findElement(By.xpath("//input[@id='login-pass']")).sendKeys("demo@proptiger");
		d.findElement(By.xpath("//button[text()='Sign In']")).click();
		d.findElement(By.xpath("//span[text()='Account']")).click();
		if (d.findElement(By.xpath("//ul[@class='dropdown-menu']/li/span[text()='xc.kvj']")).isDisplayed())
		{
			System.out.println("User logged in by normal username and password, test case paxssed");
		}
	}
}
