package Test;

import org.testng.annotations.Test;

public class PS1 extends PS
{
	
	
		@Test
	public void test()
	{
			
			int a=3;
				
			PS3 ps3=new PS3(a);
			//PS4 ps4=new PS4(a);
		
			testrun();
			System.out.println(ps3.Add());
			System.out.println(ps3.Subtract());
			System.out.println(ps3.MultiplyTwo());
			System.out.println(ps3.MultiplyThree());
	}
	
	
	

		 
}
