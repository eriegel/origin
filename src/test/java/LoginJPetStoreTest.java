import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class LoginJPetStoreTest {


		@Test
		public void test() {
			WebDriver browser=null;  
			//Firefox's geckodriver requires you to specify its location.  
			
			String nav =  System.getProperty("browser");
			
			if(nav.equals("chrome")) {
				browser = new ChromeDriver();  			
			}
			if(nav.equals("firefox")) {
				FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
				options.addPreference("browser.tabs.remote.autostart",  false);
				System.setProperty("webdriver.gecko.driver","C:\\FORMATION\\installeurs\\Selenium\\geckodriver.exe");   
				browser = new FirefoxDriver(options);  			
			}			
 
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

