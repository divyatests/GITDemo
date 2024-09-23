import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class LatestFeatures {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.driver.chromedriver", "C:\\Users\\divya.jain\\chrome-win64");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		
 // relative locators
		   WebElement Name=driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
		   System.out.println(driver.findElement(with(By.tagName("label")).above(Name)).getText());
		   
		   WebElement date=driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		   driver.findElement(with(By.tagName("input")).below(date)).click();   
		   
		   WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		   driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

		   WebElement rdb = driver.findElement(By.id("inlineRadio1"));
		   System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
		
//  multiple windows
		   driver.switchTo().newWindow(WindowType.WINDOW);
            Set<String> WD= driver.getWindowHandles();
            Iterator<String> it = WD.iterator();
            String ParentID=it.next();
            String ChildID=it.next();
            
            driver.switchTo().window(ChildID);
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
            
            String Topic= driver.findElement(By.className("redLogo")).getText();
            
            driver.switchTo().window(ParentID);
            Name.sendKeys(Topic);
            
                                   		   		   
		   
 // partial screenshot
            
           File file =Name.getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(file, new File("test.png"));
            
 // height and width of element
		//  WebElement name=driver.findElement(By.className("name"));
          System.out.println(Name.getRect().getDimension().getHeight());
          System.out.println(Name.getRect().getDimension().getWidth());
		
          
          driver.close();
	}

   

}
