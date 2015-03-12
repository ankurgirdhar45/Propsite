package Progs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



public class Performance 
{
	@Test
	public void checkPerformance() throws InterruptedException
	{
		WebDriver d = new FirefoxDriver();
		d.get("http://www.webpagetest.org");
		WebElement URL=d.findElement(By.id("url"));
		String urlc="www.proptiger.com";
		URL.sendKeys(urlc);
		WebElement startbutton = d.findElement(By.xpath("//input[@type='submit']"));
		startbutton.click();
		d.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		try
		{
			d.findElement(By.xpath("//input[@value='Re-run the test']"));
		}catch(Exception E){System.out.println("kuch mila");}
		System.out.println("loaded");
		afterResult(d,urlc);
	}
	public void afterResult(WebDriver d,String url)
	{
		/*WebDriver d = new FirefoxDriver();
		String URL="https://www.proptiger.com";
		d.get("http://www.webpagetest.org/result/150312_8D_191X/");*/
		String FVTime = d.findElement(By.id("fvLoadTime")).getText();
		String RVTime = d.findElement(By.id("rvLoadTime")).getText();
		System.out.println("Page Load time for first View " + FVTime + "\n" + "Repeat View Load Time " + RVTime);
		
		
		try
		{
		FileInputStream filein = new FileInputStream("performance.xls");
	    HSSFWorkbook workbookr = new HSSFWorkbook(filein);
	    HSSFSheet sheetr = workbookr.getSheetAt(0);
	    int last_row=sheetr.getLastRowNum();
	    System.out.println("Last row is " + last_row);
	    HSSFRow rown = sheetr.createRow(last_row+1);
	    HSSFCell cellA1 = rown.createCell(0);
	    cellA1.setCellValue(url);
	    HSSFCell cellA2 = rown.createCell(1);
	    cellA2.setCellValue(FVTime);
	    HSSFCell cellA3 = rown.createCell(2);
	    cellA3.setCellValue(RVTime);
	    HSSFCell cellA4 = rown.createCell(3);
	    cellA4.setCellValue(d.getCurrentUrl());
	    FileOutputStream fileout = new FileOutputStream("performance.xls");
	    workbookr.write(fileout);
	        
	    fileout.flush();
	    fileout.close();
	    filein.close();	
	    d.close();
		}catch(Exception E){System.out.println("File na mili");}
	}
}
	