package org.test.Cucumber1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
static WebDriver driver;
static String data;
 public static WebDriver getDriver() {
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\Udhaya\\eclipse-workspace\\Seleniumtest\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		return driver;
	
}
 public static void loadUrl(String name) {
	driver.get(name);
}
 
 public static void sendKey(WebElement element,String name) {
	element.sendKeys(name);
}
 public static void sendKeyExcel(WebElement element,String name,int i,int j) throws IOException {
	
	 element.sendKeys(getData(i, j));
}
 public static void click(WebElement element) {
element.click();
}
 public static void quitBrowser() {
driver.quit();
}
 public static void rightClick(WebElement element) {
	 Actions acc=new Actions(driver);
	acc.contextClick(element).perform();
 }
 public static void doubleClick(WebElement element) {
	 Actions acc=new Actions(driver);
	 acc.doubleClick(element).perform();

}
 public static void mouseOver(WebElement element) {
	 Actions acc=new Actions(driver);
	 acc.moveToElement(element).perform();
}
	public static void dropDown(WebElement element,int a) {
		Select s=new Select(element);
		s.selectByIndex(a);

	}
	public static void enter(WebElement element) {
		 Actions acc=new Actions(driver);
		 acc.keyDown(element, Keys.ENTER).keyUp(element, Keys.ENTER).perform();

	}
	public static String getData(int i,int j) throws IOException {
		File loc=new File("C:\\Users\\Udhaya\\eclipse-workspace\\Cucumber1\\Excel\\Siva_test.xlsx");
		FileInputStream stream=new FileInputStream(loc);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s = w.getSheet("sheet1");
		Row r = s.getRow(i);
		Cell c = r.getCell(j);
	String	data=null;
		int cellType = c.getCellType();
		if(cellType==1) {
			 data = c.getStringCellValue();
		}
			if(cellType==0) {
				if(DateUtil.isCellDateFormatted(c)) {
					Date d = c.getDateCellValue();
					SimpleDateFormat si=new SimpleDateFormat("dd-MM-yyyy");
					 data = si.format(d);
					
				}
				else {
					double d = c.getNumericCellValue();
					long l=(long)d;
					 data=String.valueOf(l);
				}
			
		}
return data;
	}
}
