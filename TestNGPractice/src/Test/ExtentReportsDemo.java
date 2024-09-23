package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	ExtentReports extent;
	
	@BeforeMethod
	public void config()
	{
		//create object of class extentReports and extectSparkReporter
		String path= System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Practice Report");
		reporter.config().setDocumentTitle("Test Results");
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA","Divya");
		
		
	}
	
	@Test
	public void baseTest()
	{		
		ExtentTest test= extent.createTest("Demo Test");
		WebDriver driver= new ChromeDriver();
		 
	 	System.setProperty("webdriver.driver.chromedriver","C:\\Users\\divya.jain\\chrome-win64\\chrome-win64");
	 	driver.get("https://adc-rms-qat1.ttekglobal.com/");
	 	System.out.println(driver.getTitle());
        extent.flush();
       
	}

}
