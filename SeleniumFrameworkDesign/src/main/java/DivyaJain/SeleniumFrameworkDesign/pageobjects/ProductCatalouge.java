package DivyaJain.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DivyaJain.SeleniumFrameworkDesign.AbstractComponent.AbstractComponent;

public class ProductCatalouge extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalouge(WebDriver driver)
	{		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//div[@class='card-body']//b")
	List<WebElement> products; 
	
	@FindBy(xpath="//*[contains(text(),' Add To Cart')]")
	WebElement addToCartButton;
	
	By toastMessage= By.id("toast-container");
	
    @FindBy(css=".ng-animating")
    WebElement spinner;
	
    @FindBy(xpath="//button[contains(text(),'Cart')]") 
	WebElement CartButton;
    
	public List<WebElement> getProductList()
	{
		//waitforElementsToAppear(products);
		return products;
	}
	
	
	public CartandCheckout addProductToCart(String item) throws InterruptedException
	{
		
			for(int i =0;i<products.size();i++)
			
		{
			String itemName = products.get(i).getText();
			
			
			if(itemName.equals(item))
			{
				addToCartButton.click();	
			}
			
			
		}
			
			waitforElementToAppearBy(toastMessage);
			waitforElementToDisappear(spinner); 
			CartButton.click();
			CartandCheckout cartandCheckout=new CartandCheckout(driver);
			return cartandCheckout;
		 
	 }
		
}

	
	




	 
