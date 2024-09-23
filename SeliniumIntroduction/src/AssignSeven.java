import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignSeven {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chromedriver","C:\\Users\\divya.jain\\chrome-win64\\chrome-win64");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption2")).click();
		String optionValue= driver.findElement(By.xpath("(//div[@id='checkbox-example']//label)[2]")).getText();
		//System.out.println(optionValue);
		
		String optionValue1= optionValue.toLowerCase();
		WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
		Select d1 = new Select(dropdown);
		d1.selectByValue(optionValue1);
		
		driver.findElement(By.id("name")).sendKeys(optionValue1);
		driver.findElement(By.id("alertbtn")).click();
        String alertMessage=driver.switchTo().alert().getText();
        String[] Value=alertMessage.split(" ");
        System.out.println(Value[1]);
        
				
		
	}

}
