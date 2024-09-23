import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkboxes {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chromedriver", "C:\\Users\\divya.jain\\edgedriver_win64");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Clicking on first checkbox and chekcing if it is selected or not
		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption1")).isSelected();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//unchekcing the checkbox and checking if it is unselected
		
		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption1")).isSelected();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		System.out.println(driver.findElements(By.xpath("//fieldset/label/input[@type='checkbox']")).size());
		driver.close();
	}

}
