
public class Recursion102
{

	//Iterative Skip
	public static void skip1(int n) //static means it instantiates a object for you automatically
	{
		for(int k = 1; k<= n; k++)
		{
			System.out.println("<skip>");
		}
	}
	
	//Recursive Skip
	public static void skip2(int n)
	{
		if(n>0) //Exit Condition
		{
			System.out.println("<skip>");
			System.out.println("Pushing " + n + " onto the stack");
			skip2(n-1);
			System.out.println("Popping " + n + " off the stack");
		}
	}
	
	public static void main(String args[])
	{
		System.out.println("Calling Iterative method :: ");
		skip1(4);
		System.out.println("\n\nCalling Recurive method :: ");
		skip2(3);
	}
	
}
