import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Chrome driver is a class and driver is a object of that class.
		 			////ChromeDriver driver=new ChromeDriver();
		 
		//Now we may need to write code for each browser like firefox or safari and create
		//classes and methods for all of them to resolve this there is an interface avaiable
		//called WebDriver.Webdriver have methods for all the browsers but with empty bodies
		//Each Browser has to call the implements WebDriver in order to use those methods.
		
		
		
		
		   //WebDriver driver =new ChromeDriver();
		   //WebDriver driver=new FirefoxDriver();
		 	WebDriver driver= new EdgeDriver();
		 
		 	// System.setProperty("webdriver.driver.chromedriver","C:\\Users\\divya.jain\\chrome-win64\\chrome-win64");
			//	System.setProperty("webdriver.driver.firefoxdriver","C:\\Users\\divya.jain\\geckodriver-v0.35.0-win64");
		 	System.setProperty("webdriver.driver.edgedriver", "C:\\Users\\divya.jain\\edgedriver_win64");
		  
		  driver.get("https://adc-rms-qat1.ttekglobal.com/");	
		
		  System.out.println(driver.getPageSource());
		  
		  System.out.println(driver.getTitle());
		  System.out.println(driver.getCurrentUrl());
		  driver.close();
		

	}

}
