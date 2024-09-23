
public class CoreJava2 {

	public static void main(String[] args) {
		int[] number= {154,323,6456,3423,21321,867,4234,242,7658,453,6753};
		
		for(int i=0; i<number.length;i++)
		{
			
			int[] even=new int[15];
			int[] odd=new int[15];
			
			if(number[i] % 2 == 0)
			{
				
					even[i]=number[i];
					System.out.println(even[i]+ "even"); 			
			}
			else
			{
				
					odd[i]=number[i];
					System.out.println(odd[i]+ "odd"); 					
				
			}	
			
	
			
			
			
		}
			
	
	}

	public void methodcheck() {
		System.out.println("to call methods from outside class");
		
	}

}
