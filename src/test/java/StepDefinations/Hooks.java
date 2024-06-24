package StepDefinations;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private WebDriver driver;

  public Hooks(WebDriver driver) {
       this.driver = driver;
    }
    public Hooks() {
    }

    @Before
    public void setUp() {
    	System.setProperty("webdriver.gecko.driver", "C:\\Automation\\geckodriver-v0.33.0-win64\\geckodriver.exe");
    	   driver = new FirefoxDriver();
    }
//    @After
//    public void tearDown(Scenario scenario) {
//        if (driver != null) {
//            captureScreenshot(scenario);
//            driver.quit();
//        }
//    }
//    

    
    @After
    public void afterScenario(Scenario scenario) {
        captureScreenshot(scenario);
    }

    private void captureScreenshot(Scenario scenario) {
        if (driver != null ) {
            try {
                
                // Capture screenshot

                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Define file name with timestamp
                String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
                String fileName = "screenshot_" + timestamp + ".png";

                // Define file path
                String filePath = "C:\\Users\\anush\\eclipse-workspace\\BDD_CucumberDemo\\src\\Screenshot\\" + fileName;

                // Copy screenshot file to destination path
                FileUtils.copyFile(screenshotFile, new File(filePath));

                // Attach the screenshot to the Cucumber report
                scenario.attach(Files.readAllBytes(Paths.get(filePath)), "image/png", fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } //else {
            //System.out.println("WebDriver is null, cannot capture screenshot.");
        //}
    }
    
    
}

	
	
	
	
	
	

//	 WebDriver driver;
//	    //private String screenshotFolderPath = "C:\\Users\\anush\\eclipse-workspace\\BDD_CucumberDemo\\src\\Screenshot";
//
//	    public Hooks() {
//	        // Default constructor
//	    }
//
//	    public Hooks(WebDriver driver) {
//	        this.driver = driver;
//	    }
//	    
//
//	    public void onTestFailure(ITestResult arg0){
//	    	System.out.println("Failure detected...");
//	        String fileName = String.format("Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
//	        WebDriver driver = (WebDriver)arg0.getTestContext().getAttribute("webDriver");
//	        TakesScreenshot ts = (TakesScreenshot)driver;
//        File srcFile = ts.getScreenshotAs(OutputType.FILE);
//	        File destFile = new File("C:\\Users\\anush\\eclipse-workspace\\BDD_CucumberDemo\\src\\Screenshot" +fileName);
//	        try{
//	            FileUtils.copyFile(srcFile, destFile);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	        System.out.println("Screenshot taken");
//	    }
//	}
//



	    
