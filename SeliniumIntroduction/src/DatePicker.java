import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DatePicker {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chromedriver","C:\\Users\\divya.jain\\chrome-win64\\chrome-win64");
		WebDriver driver= new ChromeDriver();
		driver.get("https://webdriveruniversity.com/Datepicker/index.html");
		
		String Month= "Oct";
		String Day="12";
		String Year="2028";
		String[] DateNeeded= {Month,Day,Year};
		
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).click();
		driver.findElement(By.xpath("//div[@class='datepicker-months']//th[@class='datepicker-switch']")).click();
		driver.findElement(By.xpath("//tbody//span[contains(text(),'"+Year+"')]")).click();
		driver.findElement(By.xpath("//tbody//span[contains(text(),'"+Month+"')]")).click();
		driver.findElement(By.xpath("//tbody//td[contains(text(),'"+Day+"')]")).click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String Date=(String)js.executeScript( "return someCalendarVariable;");
        
        
      System.out.println(Date);
      

	}

}
