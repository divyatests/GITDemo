import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class ExtraTopics {

	public static void main(String[] args) throws IOException  {
		System.setProperty("webdriver.driver.chromedriver","C:\\Users\\divya.jain\\chrome-win64\\chrome-win64");
		/*
		ChromeOptions options1=new ChromeOptions();
		options1.setAcceptInsecureCerts(true);
	    */
		
		/*
		Proxy P1= new Proxy();
		P1.setHttpProxy("internet:1.2.3.4");
		options1.setCapability("Proxy", P1);
		WebDriver driver= new ChromeDriver(options1);
		*/
		
		WebDriver driver= new ChromeDriver();
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));
	/*	
        String url1 ="https://www.soapui.org/";
        
       
		URL url=new URL(url1);
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int responseCode= conn.getResponseCode();
        System.out.println(responseCode);*/
		
		
		
}}