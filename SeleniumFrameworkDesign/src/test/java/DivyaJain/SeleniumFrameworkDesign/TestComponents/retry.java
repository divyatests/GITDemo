package DivyaJain.SeleniumFrameworkDesign.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		//if tests is failing it will come to this black and retry it to make sure it is not a false failure
		int count=0;
		int MaxTry=1;
		
		
		if(count<MaxTry)
		{
			count++;
			return true;			
		}
						
		return false;
	}
	
	
	

}
