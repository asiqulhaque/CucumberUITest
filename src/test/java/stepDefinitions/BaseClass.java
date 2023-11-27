package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public final static int timeOut =10;

    @Before
    public static void initialization(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    driver.manage().window().maximize();
    driver.get("https://www.orlandohealth.com/");
   }

    @After
    public static void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final   byte[] screenHot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenHot, "image/png", scenario.getName());
        }
        driver.quit();
    }


}
