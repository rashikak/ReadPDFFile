package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactsStepDefinition {
	
	WebDriver driver;

	
	@Given("^The User is on login page$")
	public void The_User_is_on_login_page()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Driver_Server\\exefiles\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
	}
	@When("^the title of login page is CRM PRO$")
	public void the_title_of_login_page_is_CRM_PRO()
	{
	String title=driver.getTitle();	
	System.out.println("Title is"+title);
	Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
	}
	
		@Then("^user enters details \"(.*)\" and \"(.*)\"$")
		public void user_enters_details_username_and_password(String username,String password) {
			
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);  
		
		}
		

		

		@Then("^the user clicks on login button$")
		public void the_user_clicks_on_login_button() {
			WebElement btn=driver.findElement(By.xpath("//input[@type='submit']"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", btn);
		}
		
		@Then("^user is already in homepage$")
		public void user_is_already_in_homepage() {
			String title=driver.getTitle();	
			System.out.println("Title is"+title);
			Assert.assertEquals("CRMPRO", title);	
		   
		}
		@Then("^user enters contact details \"(.*)\" and \"(.*)\"$")
		public void user_enters_contact_details_username_and_password(String username,String password) {
			
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);  
		
		}
		
		@Then("^user close the browser$")
		public void user_close_the_browser()
		{
			driver.quit();
		}


}
