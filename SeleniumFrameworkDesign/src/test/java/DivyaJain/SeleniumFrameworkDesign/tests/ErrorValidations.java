package DivyaJain.SeleniumFrameworkDesign.tests;
//package DivyaJain.SeleniumFrameworkDesign.TestComponenets;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import DivyaJain.SeleniumFrameworkDesign.TestComponents.BaseTest;
import DivyaJain.SeleniumFrameworkDesign.TestComponents.retry;
import DivyaJain.SeleniumFrameworkDesign.pageobjects.CartandCheckout;
import DivyaJain.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import DivyaJain.SeleniumFrameworkDesign.pageobjects.LandingPage;
import DivyaJain.SeleniumFrameworkDesign.pageobjects.ProductCatalouge;
import DivyaJain.SeleniumFrameworkDesign.pageobjects.placeOrder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidations extends BaseTest {
	
	@Test(groups= {"LoginValidationError"},retryAnalyzer=retry.class)
	public void StandAloneTest() throws IOException {	
		
		
			
		 landingpage.LoginApplication("divya1707@gmail.com", "Anaiisha@123");
		 String ErrorMessage=landingpage.getErrorMessage();
		// System.out.println(ErrorMessage);
		 Assert.assertEquals(ErrorMessage, "Incorrect email or password.");
		 
			
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {

	
		String item="ZARA COAT 3";		
		ProductCatalouge productCatalouge = landingpage.LoginApplication("jainvishal055@gmail.com", "Anaisha@123");		
		List<WebElement> products = productCatalouge.getProductList();
		CartandCheckout cartandCheckout =productCatalouge.addProductToCart(item); 					
        Boolean match=cartandCheckout.toCheckIfItemAddedtoCart(item);
		Assert.assertTrue(match);
		

	}

}
