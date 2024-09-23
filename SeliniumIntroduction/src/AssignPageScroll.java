import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignPageScroll {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chromedriver", "C:\\Users\\divya.jain\\chrome-win64");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
          JavascriptExecutor js=(JavascriptExecutor) driver;
          js.executeScript("window.scrollTo(0,900)");
          
         List<WebElement> rows =driver.findElements(By.xpath("//table [@name='courses']//tr"));
         System.out.print(rows.size());
         List<WebElement> columns=driver.findElements(By.xpath("//table [@name='courses']//th"));
         System.out.println(columns.size());
         
         
         for(int i=0;i<columns.size();i++) {
        	 
        	   System.out.println( driver.findElements(By.xpath("//table [@name='courses']//tr[3]//td")).get(i).getText());
        	 
         }
         driver.close();
      
	}

}
