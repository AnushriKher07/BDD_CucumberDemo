package StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchOnGoogle {
	public WebDriver driver;
	private Hooks hooks;
	
	
@Before
public void setup() {
//hooks = new Hooks(driver);
}

//@After
//public void tearDown() {
//    if (driver != null) {
//        driver.quit();
//    }
//}

	
@Given("User launch browser")
public void user_launch_browser() {
    //WebDriver driver = new FirefoxDriver();
    
   System.setProperty("webdriver.gecko.driver", "C:\\Automation\\geckodriver-v0.33.0-win64\\geckodriver.exe");
   driver = new FirefoxDriver();
   driver.manage().window().maximize();
    driver.get("https://www.google.co.in/");
   //hooks = new Hooks(driver); // Pass the driver instance to Hooks

    
}
@When("User enter Bdd in search box")
public void user_enter_Bdd_in_search_box() {
	driver.findElement(By.id("APjFqb")).sendKeys("BDD");
}
@Then("User click on Search button")
public void user_click_on_Search_button() throws InterruptedException {
	Thread.sleep(200);
	driver.findElement(By.xpath("//input[@aria-label='Google Search']")).click();
}
@Then("User close the browser")
public void user_close_the_browser() {
	driver.quit();
}

}