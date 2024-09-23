package DivyaJain.SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DivyaJain.SeleniumFrameworkDesign.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}
	//WebElement userEmail= driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(xpath="//div[@role='alert']")
	WebElement errorMessage;		
	
	public ProductCatalouge LoginApplication(String Username,String password)
	{		
			userEmail.sendKeys(Username);
			userPassword.sendKeys(password);
			submit.click();	
			ProductCatalouge productCatalouge=new ProductCatalouge(driver);
			return productCatalouge;
	}
	
	public void goTo(String URL)
	{
		
		driver.get(URL);
		
	}
	public String getErrorMessage()
	{
		
		waitforElementToAppear(errorMessage);
		String ErrorMessage =errorMessage.getText();
		return ErrorMessage;
		
	}
	
	
	

		
	


	        
}
