package DivyaJain.SeleniumFrameworkDesign.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import DivyaJain.SeleniumFrameworkDesign.AbstractComponent.AbstractComponent;

public class placeOrder extends AbstractComponent{
	
	WebDriver driver;
	
	public placeOrder(WebDriver driver)
	{		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(xpath="//section//span[@class='ng-star-inserted']")
	List<WebElement> country;
	
	@FindBy(css=".action__submit")
	WebElement placeorderbutton;
	
	public ConfirmationPage chooseCountry(String Country)
	{
		
		selectCountry.sendKeys(Country);
		
		for (int i = 0; i < country.size(); i++) {

			String CountryName = country.get(i).getText();
			if (CountryName.equalsIgnoreCase(Country)) {
				country.get(i).click();
				break;

			}
	}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(1000,1700)");
	    //waitforElementToAppear(placeorderbutton);
		placeorderbutton.click();
		ConfirmationPage confirmationPage =new ConfirmationPage(driver);
		return confirmationPage;
	

	}


	


	
}	
	




	 
