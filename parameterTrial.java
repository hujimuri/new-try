package freshstart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Mydemo_hujimuri.Mydemo_hujimuri.utility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import junit.framework.Assert;

public class parameterTrial {
	WebDriver driver=null;
	@Given("launching the page")
	public void launching_the_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		driver=utility.configureDriver("chrome");
		  driver.manage().window().maximize();
		  driver.get("http://demowebshop.tricentis.com/");
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("check for login button")
	public void check_for_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
		
	}

	@When("entering the username {string} and password {string}")
	public void entering_the_username_and_password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		//System.out.println("the current user name is:"+string+"password is:"+string2);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(string);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(string2);
		
	}

	@When("click on login")
	public void click_on_login() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
	}

	@Then("vefify for the account status")
	public void vefify_for_the_account_status() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		String msg=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).getText();
		Assert.assertEquals(msg, "Log out");
		driver.close();
	}
}
