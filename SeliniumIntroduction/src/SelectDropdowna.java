import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdowna {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chromedriver", "C:\\Users\\divya.jain\\edgedriver_win64");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement dropdown =driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select staticDropdown =new Select(dropdown);
		
		staticDropdown.selectByIndex(2);
		System.out.println(staticDropdown.getFirstSelectedOption().getText());
		staticDropdown.selectByValue("AED");
		System.out.println(staticDropdown.getFirstSelectedOption().getText());
		staticDropdown.selectByVisibleText("INR");
		System.out.println(staticDropdown.getFirstSelectedOption().getText());
		
		

	}

}
