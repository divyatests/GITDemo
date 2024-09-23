package Test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {

	
	@Test
	public void demo5()
	{
		System.out.println("learning TestNG");
		
	} 
	@Parameters({"URL"})
	@Test
	public void demo6(String URL)
	{
		System.out.println("learning selenium");
		System.out.println(URL);
	}
	@AfterTest
	public void afterTest()
	{
		
		System.out.println("after test annotation");
		
	}
	@AfterSuite(groups= {"Smoke"})
	public void demo9()
	{
		System.out.println("Printign after suite");
		
	}
	
	
}
