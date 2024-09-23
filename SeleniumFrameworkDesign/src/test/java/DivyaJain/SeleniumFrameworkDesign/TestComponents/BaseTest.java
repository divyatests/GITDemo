package DivyaJain.SeleniumFrameworkDesign.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import DivyaJain.SeleniumFrameworkDesign.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingpage;

	public void initializeDriver() throws IOException {
		// load globalData.properties file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//DivyaJain//SeleniumFrameworkDesign//resources//GlobalData.properties");
		prop.load(fis);
         
		String browserName =System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");				

		if (browserName.contains("Chrome")) {
			ChromeOptions options= new ChromeOptions();
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			System.setProperty("webdriver.driver.chromedriver", "C:\\Users\\divya.jain\\chrome-win64\\chrome-win64");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("firefox"))

		{
			System.setProperty("webdriver.driver.firefoxdriver", "C:\\Users\\divya.jain\\geckodriver-v0.35.0-win64");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.driver.edgedriver", "C:\\Users\\divya.jain\\edgedriver_win64");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {

		initializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.goTo("https://rahulshettyacademy.com/client");
		return landingpage;

	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {

		driver.close();
	}

	public List<HashMap<String, String>> getjsonData(String FileName) throws IOException {

		// convert json to string
		String jsoncontent = FileUtils.readFileToString(new File(FileName),StandardCharsets.UTF_8);

		// covert string to map
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsoncontent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}
	
	public String getScreenshot(String testcasename,WebDriver driver) throws IOException
	{
		
		 TakesScreenshot ts= (TakesScreenshot)driver;
		 File source= ts.getScreenshotAs(OutputType.FILE);
		 File file= new File(System.getProperty("user.dir")+ "//reports//"+ testcasename +".png");
		 FileUtils.copyFile(source, file);		
		 return System.getProperty("user.dir")+ "//reports//"+ testcasename +".png";
		 
		
	}
}
