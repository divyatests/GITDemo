import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentFour {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.driver.chromedriver", "C:\\Users\\divya.jain\\edgedriver_win64");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		//implicit wait
		
//Questions:If both explixit and implicit wait is present then which one will be applicable?		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
	
          //Explicit wait
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();		
		//driver.switchTo().alert().accept();
		
		WebElement dropdown= driver.findElement(By.xpath("//select[@class='form-control']"));
		Select s1 = new Select(dropdown);
		s1.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
	     //Explicit wait
		WebDriverWait w1=new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'ProtoCommerce Home')]"))));
		//String test= driver.findElement(By.xpath("//a[contains(text(),'ProtoCommerce Home')]")).getText();
		//System.out.println(test);
		String[] itemsNeeded = {"iphone X","Samsung","Nokia","Blackberry"};
		
		
		
		List<WebElement> Products= driver.findElements(By.xpath("(//h4[@class='card-title'])"));
		                           
		
		for (int i=0;i<Products.size();i++)
		{
			List a1=Arrays.asList(itemsNeeded);
			
			if(a1.contains(Products))
			{		
			
				driver.findElements(By.xpath("(//button[@class='btn btn-info'])")).get(i).click();
			}
			
		}
		
		
		
		

		
		
	
		
	
		
	}

}
