package Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day1 {

	
	@Test(dataProvider="getdata")
	public void demo(String username,String password)
	{
		System.out.println("Hello");
		System.out.println(username);
		System.out.println(password);
		
	} 
	@Test(groups= {"Smoke"})
	public void demo1()
	{
		System.out.println("Bye");
		
	}
	@BeforeTest
	public void demo6()
	{
		System.out.println("This is before test example");
		
	}
	
	@DataProvider
	public Object[][] getdata() 
	{
		
		Object[][] multiarray=new Object[3][2];
		
		multiarray[0][0]="usernameOne";
		multiarray[0][1]="passwordOne";
		
		multiarray[1][0]="usernameTwo";
		multiarray[1][1]="passwordTwo";
		
		multiarray[2][0]="usernameThird";
		multiarray[2][1]="passwordThird";
		return multiarray;
		
	}
}
