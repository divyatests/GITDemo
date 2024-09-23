
public class stringlesson {

	public static void main(String[] args) {
		//string as object
		
		String s1="My name is divya jain";
		String s2="My name is divya jain";
		
		
		//String literal
		String s3=new String("My name is vishal jain");
		
		for(int i=0; i<s3.length();i++)
		{
			
			System.out.println(s3.charAt(i));
						
		}
		
		//Print string in reverse order
		
		for(int i=s1.length()-1;i>=0;i--)
		{
			
			System.out.println(s1.charAt(i));
			
		}
		
		
			System.out.println(s1.compareTo(s2));
			
			s1.replaceAll(s2, s3);
			
			
		 
		
		
		
		
		

	}

}
