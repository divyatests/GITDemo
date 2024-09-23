package DivyaJain.SeleniumFrameworkDesign.tests;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import DivyaJain.SeleniumFrameworkDesign.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StandAloneTest2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		LandingPage landingpage= new LandingPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("divya1707@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Anaisha@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']//b")));
		List<WebElement> products= driver.findElements(By.xpath("//div[@class='card-body']//b"));
		String item="ZARA COAT 3";
	//	System.out.println(products.getFirst().getText());
	//	WebElement prod= products.stream().filter(Product->Product.findElement(By.xpath("//b"))
			//	.getText().equalsIgnoreCase("ZARA COAT 3")).findFirst().orElse(null);
		
	
		for(int i =0;i<products.size();i++)
			
		{
			String itemName = products.get(i).getText();
			
			//item.equals(itemName)
			if(itemName.equals("ZARA COAT 3"))
			{
				driver.findElement(By.xpath("//*[contains(text(),' Add To Cart')]")).click();	
			}
			
			
		}
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[contains(text(),'Cart')]")).click();
	
		
		List<WebElement> CartItems= driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
		
        Boolean match =  CartItems.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(item));
       
        	Assert.assertTrue(match);
        	
        	
        	JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(500,1700)");
            
        	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("toast-container"))));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Checkout')]")));
            
            driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
         
         driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
          
         List<WebElement> country= driver.findElements(By.xpath("//section//span[@class='ng-star-inserted']"));
         for(int i=0;i<country.size();i++)
         {
        	 
        	     String CountryName= country.get(i).getText();
        	     if(CountryName.equalsIgnoreCase("India"))
        	     {
        	    	 
        	    	country.get(i).click();
        	    	break;
            	    	 
        	     }
        	 
         }
         
         driver.findElement(By.cssSelector(".action__submit")).click();
         String message= driver.findElement(By.cssSelector(".hero-primary")).getText();
         Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
      driver.close();
         
         
//	WebElement prod= products.stream().filter(product->
	//	product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		
	//  prod.findElement(By.xpath("//div[@class='card-body']//button[contains(text(),' Add To Cart')]")).click();		
	//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();	
		
	}

}
