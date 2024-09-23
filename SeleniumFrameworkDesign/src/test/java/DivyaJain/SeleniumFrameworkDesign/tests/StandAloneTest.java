package DivyaJain.SeleniumFrameworkDesign.tests;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DivyaJain.SeleniumFrameworkDesign.TestComponents.BaseTest;
import DivyaJain.SeleniumFrameworkDesign.pageobjects.CartandCheckout;
import DivyaJain.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import DivyaJain.SeleniumFrameworkDesign.pageobjects.LandingPage;
import DivyaJain.SeleniumFrameworkDesign.pageobjects.OrderPage;
import DivyaJain.SeleniumFrameworkDesign.pageobjects.ProductCatalouge;
import DivyaJain.SeleniumFrameworkDesign.pageobjects.placeOrder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest {

	//String item = "ZARA COAT 3";

	@Test(dataProvider="getData",groups={"Purchase"})
	//public void StandAloneTest(String Username,String Password,String item) throws IOException {
	
	public void StandAloneTest(HashMap<String,String> input) throws IOException, InterruptedException {

		// LandingPage landingpage= launchApplication();

		ProductCatalouge productCatalouge = landingpage.LoginApplication(input.get("Username"),input.get("Password"));

		List<WebElement> products = productCatalouge.getProductList();
		CartandCheckout cartandCheckout = productCatalouge.addProductToCart(input.get("item"));

		Boolean match = cartandCheckout.toCheckIfItemAddedtoCart(input.get("item"));
		Assert.assertTrue(match);
		placeOrder PlaceOrder = cartandCheckout.clickonCheckout();

		ConfirmationPage confirmationPage = PlaceOrder.chooseCountry("India");
		String message = confirmationPage.confirmation();

		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		// driver.close();

	}

	// To check if order is present on orders page or not
	@Test(dependsOnMethods = { "StandAloneTest" },dataProvider="getData")
	public void orderpage(String item) {

		ProductCatalouge productCatalouge = landingpage.LoginApplication("anaisha123@gmail.com", "Anaisha@123");
		OrderPage orderpage = productCatalouge.GoToOrderPage();
		Boolean match = orderpage.toCheckIfOrderPresent(item);
		Assert.assertTrue(match);

	}

	/*
	@DataProvider
	public Object[][] getData()
	{
		
		return new Object[][] {{"divya1707@gmail.com", "Anaisha@123","ZARA COAT 3"},{"anaisha123@gmail.com", "Anaisha@123","ADIDAS ORIGINAL"}};
	}*/
	
/*	@DataProvider
	public Object[][] getData()
	{
		//instead of sending data in array use hash map to send any number of data
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("Username", "divya1707@gmail.com");
		map.put("Password", "Anaisha@123");
		map.put("item", "ZARA COAT 3");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("Username", "anaisha123@gmail.com");
		map1.put("Password", "Anaisha@123");
		map1.put("item", "ADIDAS ORIGINAL");
		
		return new Object[][] {{map},{map1}};
	}
	
	*/
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
	 String	Filename= System.getProperty("user.dir")
				+ "//src//test//java//DivyaJain//SeleniumFrameworkDesign//Data//PurchaseOrder";
		List<HashMap<String, String>> data= getjsonData(Filename);
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	
	
}
