/**
 * This example compares iterative and recursive methods of counting
 * @author Lo12041430
 *
 */
public class Recursion103
{
	/**
	 * Counts from a start value to an end value (inclusive) iteratively
	 * @param a start value
	 * @param b end value
	 */
	
	//Iterative Count
	public static void count1(int a, int b)
	{
		for(int k = a; k <= b; k++)
		{
			System.out.print(k + " ");
		} 
	}
	
	/**
	 * Counts from a start value to an end value (inclusive) recursively
	 * @param a start value 
	 * @param b end value
	 */
	public static void count2(int a, int b)
	{
		/*if(a <= b)
		{
			System.out.print(a + " ");
			count2(++a,b);
		}*/
		
		System.out.print(a + " ");
		if(a < b)
			count2(++a,b);
		
	}
	
	public static void main(String[] args)
	{
		System.out.println("Calling Iterative Method :: ");
		count1(10,25);
		System.out.println("\n\nCalling Recursive Method :: ");
		count2(10,25);
		
	}

}
