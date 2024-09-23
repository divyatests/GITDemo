
public class CoreJava {

	public static void main(String[] args) 
{
	    int num=5;
		char letter= 'd';
		String name="Divyatest";
	    boolean flag=true;
	    double number1=5.99;
		
	    System.out.println(num);
	    System.out.println("name is " + name);
	    
	    String[] names = new String[5];
	    names[0]="test";
	    names[1]="test1";
	    System.out.println(names[0]);
	    System.out.println(names[1]);
	    
	    String[] names1 = {"Divya","Vishal","Anaisha","Nayo","noone"};
	    System.out.println(names1[0]+" "+ names[1]);
	    
	    int[] numarr= new int[3];
	    
	    numarr[0]=1;
	    numarr[1]=2;
	    numarr[2]=3;
	    
	    
	    
	    //For loop
	    
	    for(int i=0 ;i <names.length; i++)
	    {
	    
	       System.out.println(names[i]);
	       System.out.println(names1[i]);
		}
	    
	    for(int i=0; i<numarr.length; i++)
	    {
	    	
	    	System.out.println(++numarr[i]); 
	    }
	    
	    
	    	
 }
}
