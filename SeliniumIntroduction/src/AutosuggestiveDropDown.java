import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutosuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.driver.chromedriver","C:\\Users\\divya.jain\\chrome-win64\\chrome-win64");
		
		
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));
		
		String SelectedCountry="United Arab Emirates";
		
		driver.findElement((By.id("autocomplete"))).sendKeys("Uni");
		
		//WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(5));
		//w.until(ExpectedConditions.visibilityOfElementLocated(null));
		Thread.sleep(5000);
        List<WebElement> options= driver.findElements(By.className("ui-menu-item"));
				
        for(int i=0; i<options.size();i++)
        {
        	     
          String Country = options.get(i).getText();
          
           if(Country.equalsIgnoreCase(SelectedCountry))
           {
        	   
        	   options.get(i).click();
        	   
           }
        	
        }
      
	}

}

