package Test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Day2 {

	@Parameters({"URL"})
	@Test
	public void demo3(String URL)
	{
		System.out.println("TO print");
		System.out.println(URL);
		
	} 
	@Test
	public void demo4()
	{
		System.out.println("I am printing the data");
		
	}
	@BeforeSuite
	public void demo9()
	{
		System.out.println("Printign before suite");
		
	}
	
}
