
public class Recursion101
{
	//private static int j = 0; //This is an instance variable
	
	//Iterative Count
	public static void count1()
	{
		for(int k = 1; k <= 50; k++)
		{
			System.out.print(k + " ");
		}
	}
	
	//Recursive Count
	public static void count2(int j)
	{
		//int j = 0;
		
		j++;
		System.out.print(j + " ");
		
		if(j < 50) //Exit condition: this is used to terminate the recursive calls
			count2(j);
	
	}
	
	public static void main(String args[])
	{
		// TODO Auto-generated method stub
		System.out.println("Calling Iterative Method :: ");
		count1();
		System.out.println("\n\nCalling Recursive Method :: ");
		count2(0);
		
	}
}
