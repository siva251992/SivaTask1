package org.test.Cucumber1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Map;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.ast.DataTable;
import junit.framework.Assert;

public class Addcustomer {
static WebDriver driver;
	@Given("the user is in guru demo page")
	public void the_user_is_in_guru_demo_page() {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Udhaya\\eclipse-workspace\\Cucumber1\\driver\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get("http://demo.guru99.com/telecom/index.html");
	}

	@Given("he clicks Add customer to redirect to Add customer page")
	public void he_clicks_Add_customer_to_redirect_to_Add_customer_page() {
		
	    driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	    
	    
	}

	

	@When("the user fills the details")
	public void the_user_fills_the_details(io.cucumber.datatable.DataTable table) throws InterruptedException {
	   Thread.sleep(300);
	   
		Map<String, String> value = table.asMap(String.class, String.class);
		driver.findElement(By.xpath("//label[text()='Done']")).click();
		driver.findElement(By.id("fname")).sendKeys(value.get("first Name"));
driver.findElement(By.id("lname")).sendKeys(value.get("last Name"));
driver.findElement(By.id("email")).sendKeys(value.get("email"));
driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(value.get("address"));
driver.findElement(By.id("telephoneno")).sendKeys(value.get("phone"));


	}

	public void clicks_the_submit_button() {
	    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}

	@Then("a custome Id should be generated")
	public void a_custome_Id_should_be_generated() {
	    WebElement cusId = driver.findElement(By.xpath("//section[@id='main']//table//tr[1]/td[2]"));
	String text = cusId.getText();
	System.out.println(text);
	
	//cus id = 820838
	
	
	}

	
	
	
}
