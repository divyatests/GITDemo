import java.util.ArrayList;

public class PracticeArray {

	public static void main(String[] args) 
{
		int[] numbers = {1,2,3,4,5};
		int count=0;
		//System.out.println(numbers[0]);
		//System.out.println(numbers[4]);
		
		for(int i=numbers.length-1; i>=0; i--)
		{
			
			System.out.println(numbers[i]);
			count++;
			
		}
		
		System.out.println(count);
		
		
	    ArrayList<String> a=new ArrayList();
	    a.add("my");
	    a.add("name");
	    a.add("is");
	    a.add("Divya");
	    a.remove(2);
	    
	    System.out.println(a.contains("name"));
	    
	    for(int i=0;i<a.size();i++)
	    {
	    	
	    	System.out.println(a.get(i));
	    	
	    }
	}
	
	
	     

}
