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

public class OrderPage extends AbstractComponent{
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	
	@FindBy(xpath="//tr[@class=\"ng-star-inserted\"]//td[2]")
	private List<WebElement> orderitems;
		
	
	public Boolean toCheckIfOrderPresent(String item)
	{
			
		//GoToOrderPage();		
		Boolean match = orderitems.stream().anyMatch(orderproduct -> orderproduct.getText().equalsIgnoreCase(item));
        return match; 
		
	}
		
}	
	




	 
