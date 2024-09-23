package DivyaJain.SeleniumFrameworkDesign.pageobjects;

import java.util.List;
//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;


import DivyaJain.SeleniumFrameworkDesign.AbstractComponent.AbstractComponent;

public class CartandCheckout extends AbstractComponent{
	
	WebDriver driver;
	
	public CartandCheckout(WebDriver driver)
	{		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//div[@class='cartSection']//h3")
	List<WebElement> CartItems; 
	
	@FindBy(id="toast-container")
	WebElement toastMessage;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement button;
	
	public Boolean toCheckIfItemAddedtoCart(String item)
	{

		Boolean match = CartItems.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(item));
          return match;          				
	}
	
	
	public placeOrder clickonCheckout() throws InterruptedException
	{		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(500,1700)");		
		waitforElementToDisappear(toastMessage);
		//waitforElementToAppear(button);		
		button.click();
		placeOrder PlaceOrder=new placeOrder(driver);
		return PlaceOrder;
	}	
}	
	




	 
