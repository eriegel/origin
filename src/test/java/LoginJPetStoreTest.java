import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class LoginJPetStoreTest {


		@Test
		public void test() throws MalformedURLException {
			//WebDriver browser=null;  
			RemoteWebDriver browser;
			String nav =  System.getProperty("browser");
			//Firefox's geckodriver requires you to specify its location.  
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName(nav);
			
			cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			URL url_hub = new URL("http://localhost:4444/wd/hub");

			browser = new RemoteWebDriver(url_hub,cap);
			/*
			if(nav.equals("chrome")) {
				browser = new ChromeDriver();  			
			}
			if(nav.equals("firefox")) {
				FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
				options.addPreference("browser.tabs.remote.autostart",  false);
				System.setProperty("webdriver.gecko.driver","C:\\FORMATION\\installeurs\\Selenium\\geckodriver.exe");   
				browser = new FirefoxDriver(options);  			
			}		*/	
 
			//browser = new ChromeDriver();    
			browser.get("http://localhost:8082/jpetstore/");   
			
			browser.findElement(By.linkText("Enter the Store")).click();
			
			WebElement header = browser.findElement(By.id("LogoContent"));   
			assertTrue((header.isDisplayed()));  
			String animal ="reptiles";
			browser.findElement(By.xpath("//img[@ src='../images/" + animal + "_icon.gif']")).click();
			
			
			WebElement iguana = browser.findElement(By.linkText("RP-LI-02"));
			assertTrue((iguana.isDisplayed())); 
			
			//browser.close();
			//browser.quit();
		}

	}

