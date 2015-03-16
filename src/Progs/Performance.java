package Progs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

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
	/*
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
	}*/
	@Test
	public void afterResult(/*WebDriver d,String url*/)
	{
		WebDriver d = new FirefoxDriver();
		String URL="https://www.proptiger.com";
		d.get("http://www.webpagetest.org/result/150316_QE_GHE/");
		
		List<WebElement> fv= d.findElements(By.xpath("//table[@id='tableResults']/tbody/tr[3]/td"));
		List<WebElement> rv= d.findElements(By.xpath("//table[@id='tableResults']/tbody/tr[4]/td"));
		System.out.println(fv.size() + "    " + rv.size());
		//String FVloadtime = d.findElement(By.id("fvLoadTime")).getText();
		//String FVfirstbyte = d.findElement(By.id("fvTTFB")).getText();
		
		
		//String RVloadtime = d.findElement(By.id("rvLoadTime")).getText();
		
		//System.out.println("Page Load time for first View " + FVTime + "\n" + "Repeat View Load Time " + RVTime);
		
		
		try
		{
		FileInputStream filein = new FileInputStream("performance.xls");
	    HSSFWorkbook workbookr = new HSSFWorkbook(filein);
	    HSSFSheet sheetr = workbookr.getSheetAt(1);
	    int last_row=sheetr.getLastRowNum();
	    System.out.println("Last row is " + last_row);
	    HSSFRow rown = sheetr.createRow(last_row+1);
	    HSSFCell cellA1 = rown.createCell(0);
	    cellA1.setCellValue(URL);
	    int n = 1;
	    for (WebElement e : fv)
	    {
	    	HSSFCell x = rown.createCell(n);
	    	x.setCellValue(e.getText());
	    	n+=1;
	    }
	    HSSFCell cellA4 = rown.createCell(n);
	    cellA4.setCellValue(d.getCurrentUrl());
	    HSSFRow rown2 = sheetr.createRow(last_row+2);
	    HSSFCell cellB1 = rown2.createCell(0);
	    cellB1.setCellValue("");
	    n = 1;
	    for (WebElement e : rv)
	    {
	    	HSSFCell x = rown2.createCell(n);
	    	x.setCellValue(e.getText());
	    	n+=1;
	    }
	    HSSFCell cellB4 = rown2.createCell(n);
	    cellB4.setCellValue(d.getCurrentUrl());
	    
	    /*HSSFCell cellA2 = rown.createCell(1);
	    cellA2.setCellValue(FVTime);
	    HSSFCell cellA3 = rown.createCell(2);
	    cellA3.setCellValue(RVTime);
	    
	    */
	    FileOutputStream fileout = new FileOutputStream("performance.xls");
	    workbookr.write(fileout);    
	    fileout.flush();
	    fileout.close();
	    filein.close();	
	    d.close();
		}catch(Exception E){System.out.println("File na mili");}
	}
}
	