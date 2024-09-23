package Test;

public class PS3 extends PS4{


	public PS3(int a) {
		super(a);
		this.a=a;
		// TODO Auto-generated constructor stub
	}

	int a;
	
	

	public int Add()
	{
		a=a+1;
		return a;
		
	}

	public int Subtract()
	{
		a=a-1;
		return a;
		
	}

}
