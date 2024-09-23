import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class LocatorsPractice2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.driver.chromedriver", "C:\\Users\\divya.jain\\edgedriver_win64");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com");
		driver.navigate().back();
		driver.navigate().forward();
		//driver.get("https://rahulshettyacademy.com/locatorspractice/");	
        /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String name="Divya";		
			
		LocatorsPractice2 lp= new LocatorsPractice2();
		String password= lp.getPassword(driver);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'login')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("inputUsername")).sendKeys(name);	
		System.out.println(password);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
	    //System.out.println(driver.findElement(By.xpath("//h2")).getText());
	    Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Hello "+ name+ ",");
	    driver.findElement(By.xpath("//button[text()='Log Out']")).click();
	    driver.close();*/
	}

	
	public String getPassword(WebDriver driver) throws InterruptedException
	{
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		 driver.findElement(By.className("reset-pwd-btn")).click();
		 String newPassword= driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		 //Please use temporary password 'rahulshettyacademy' to Login.
		 String[] firstPart= newPassword.split("'");	
		 //firstPart[0]=Please use temporary password '
		 //firstPart[1]=rahulshettyacademy' to Login.
		 
		 String[] secondPart= firstPart[1].split(",");
		 //secondPart[0]=rahulshettyacademy
		 //secondPart[1]=' to Login.
		 
		 String passwordValue=secondPart[0];
			
		 return passwordValue;
	
		
		
		
	}
	
	
	
}
