import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProduct 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver =new ChromeDriver();
		System.setProperty("webdriver.driver.chromedriver","C:\\Users\\divya.jain\\chrome-win64\\chrome-win64");
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       String[] itemsNeeded= {"Cucumber","Brinjal","Potato","Apple","Banana"};
        
       AddtoCart(driver, itemsNeeded);
       
       driver.findElement(By.xpath("//img[@alt='Cart']")).click();
       driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
       driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
       driver.findElement(By.className("promoBtn")).click();
       
     
	   
		
	}
	
	

	public static void AddtoCart(WebDriver driver, String [] itemsNeeded) throws InterruptedException
	{
		List<WebElement> products= driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		  for(int i=0;i<products.size();i++)
		  {		  
			  List a1= Arrays.asList(itemsNeeded);
			      
			    
			  String item=(products.get(i).getText());
			     String[] Vegname=item.split("-");
			      String CorrectVegname= Vegname[0].trim();
			 
		   if(a1.contains(CorrectVegname))
		   {		   
			   
			   Thread.sleep(3000);
			   driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			   		   
		   }
		  }	
		 //driver.close();
		  
	}
	
}