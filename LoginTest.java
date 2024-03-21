package StepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginTest {
	WebDriver driver;
	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
	}
	@Given("I am on Hotel App Login Page")
	public void i_am_on_hotel_app_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://adactinhotelapp.com/");
	    //throw new io.cucumber.java.PendingException();
	}

	@When("I enter credentials to Login")
	public void i_enter_credentials_to_login(DataTable usercredentials) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<List<String>> data = usercredentials.cells();
	    driver.findElement(By.id("username")).sendKeys(data.get(0).get(0));
	    driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));
    driver.findElement(By.id("login")).click();
	
	   // throw new io.cucumber.java.PendingException();
	}
	@When("I click login")
	public void i_click_login() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		driver.findElement(By.id("login")).click();
	}


	@Then("I am Logged in Successfully")
	public void i_am_logged_in_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@After
	public void dispose() {
		driver.quit();
	}


}
