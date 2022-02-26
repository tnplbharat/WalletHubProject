package configuration;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	
	public WebDriver driver;
	/**
	 * This function will execute before each Test tag in testng.xml
	 * @param browser
	 * @throws Exception
	 */
	@BeforeClass
	@Parameters({"browser","url"})
	
	public void invokeBrowser(String browser,String url) throws Exception
	{
		//Check if parameter passed from TestNG is 'firefox'
			if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ File.separator + "drivers" + File.separator + "src"+File.separator+"main" + File.separator+"resources"+File.separator+"geckodriver.exe");
				driver = new FirefoxDriver();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+  File.separator + "src"+File.separator+"main" + File.separator+"resources"+File.separator+"chromedriver.exe");
				//create chrome instance
				driver = new ChromeDriver();
			}
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	}
		@AfterClass
    public void afterClass()
    {
        driver.close();
    }
	
	}

