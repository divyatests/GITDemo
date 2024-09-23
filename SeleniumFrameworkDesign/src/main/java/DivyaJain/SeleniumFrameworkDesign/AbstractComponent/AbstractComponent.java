package DivyaJain.SeleniumFrameworkDesign.AbstractComponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DivyaJain.SeleniumFrameworkDesign.pageobjects.OrderPage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
	}
	
	@FindBy(xpath="//button[@routerlink=\"/dashboard/myorders\"]")
	WebElement orderbutton;

	public void waitforElementsToAppear(List<WebElement> list) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated((By) list));
	}
	
	public void waitforElementToAppearBy(By findBy) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated((By) findBy));
	}
	
	public void waitforElementToAppear(WebElement Element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf((WebElement)Element));
	}
	
	public void waitforElementToDisappear(WebElement Element) throws InterruptedException 
	{
		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOf(Element));
	}
	
	public OrderPage GoToOrderPage()
	{
		
		orderbutton.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
		
		
	}


}
