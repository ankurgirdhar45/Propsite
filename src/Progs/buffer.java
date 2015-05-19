package Progs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//comment

public class buffer 
{	
	WebDriver d;
	Object[][] ob;
	FileInputStream fin;
	HSSFWorkbook wb;
	HSSFSheet sh;
	HSSFCell cell,cell2;
	HSSFRow row;
	
	/*public void getURLStatus()
	{
		WebDriver d = new FirefoxDriver();
		d.get("https://www.proptiger.com");
		List<WebElement> s = d.findElements(By.tagName("a"));
		for (WebElement e:s)
		{
			System.out.println(e.getAttribute("href") + "text is " + e.getText());
		}
	}*/
	
	
	
	
}
