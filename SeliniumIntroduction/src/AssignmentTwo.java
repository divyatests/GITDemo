import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//
public class AssignmentTwo {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chromedriver", "C:\\Users\\divya.jain\\edgedriver_win64");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys("Divya");
		driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys("divya1709@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Test");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement gender= driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
		
		Select findGender= new Select(gender);
		
		findGender.selectByIndex(1);
		//findGender.getFirstSelectedOption();
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("1987-12-31");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert-success")).getText(), "Success! The Form has been submitted successfully!.");
		driver.close();
		
			

	}

}
