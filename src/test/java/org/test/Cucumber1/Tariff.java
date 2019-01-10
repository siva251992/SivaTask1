package org.test.Cucumber1;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class Tariff {
	static WebDriver driver;

	@Given("the user is in  guru demo page")
	public void the_user_is_in_guru_demo_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Udhaya\\eclipse-workspace\\Cucumber1\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("http://demo.guru99.com/telecom/index.html");
	}

	@Given("he clicks Add Tariff button")
	public void he_clicks_Add_Tariff_button() {
		 driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
	}
	@When("the user enters required details")
	public void the_user_enters_required_details(DataTable table) {
		
		Map<String, String> m = table.asMap(String.class, String.class);
	  driver.findElement(By.xpath("//input[@name='rental']")).sendKeys(m.get("mRental"));
	  driver.findElement(By.xpath("//input[@name='local_minutes']")).sendKeys(m.get("freeLoc"));
	  driver.findElement(By.xpath("//input[@name='inter_minutes']")).sendKeys(m.get("freeInt"));
	  driver.findElement(By.xpath("//input[@name='sms_pack']")).sendKeys(m.get("freeSms"));
	  driver.findElement(By.xpath("//input[@name='minutes_charges']")).sendKeys(m.get("locChg"));
	  driver.findElement(By.xpath("//input[@name='inter_charges']")).sendKeys(m.get("intChg"));
	  driver.findElement(By.xpath("//input[@name='sms_charges']")).sendKeys(m.get("smsChg"));
	  
	}


	@When("clicks the submit button")
	public void clicks_the_submit_button() {
	    driver.findElement(By.xpath("//input[@name='submit']")).click();
	}


	
	
	@Then("a congratulation message is displayed")
	public void a_congratulation_message_is_displayed() {
	    String done = driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).getText();
	System.out.println(done);
	}
	
}
