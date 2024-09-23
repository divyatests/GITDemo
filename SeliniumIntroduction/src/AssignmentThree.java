import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//to select form dynamic dropdowns
public class AssignmentThree {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.driver.chromedriver", "C:\\Users\\divya.jain\\edgedriver_win64");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//li/a[@value='IXB']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//li/a[@value='JAI']")).click();
		driver.findElement(By.xpath("//td[contains(@class, 'ui-datepicker-today')]")).click();
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		for(int i=0;i<4;i++)
		{
				driver.findElement(By.id("hrefIncAdt")).click();
		}
	    
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		WebElement currencyDrop= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdown= new Select(currencyDrop);
		dropdown.selectByValue("AED");
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		driver.close();
		
		
		
			
		
		
		
		
				
				
				//li/a[@value="IXB"]
		

	}

}
