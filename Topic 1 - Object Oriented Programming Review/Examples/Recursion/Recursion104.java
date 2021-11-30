/*
 * This program compares the differences between 
 * Post-recursive calls and pre-recursive calls
 * (aka tail recursion vs head recursion)
 */
public class Recursion104
{
	/**
	 * Post-Recursive count
	 * @param a starting value
	 * @param b ending value
	 */
	public static void count1(int a, int b)
	{
		if(a <= b)
		{
			System.out.print(a + " ");
			count1(++a, b);
		}
	}
	
	/**
	 * Pre-Recursive count
	 * @param a start value
	 * @param b end value
	 */
	public static void count2(int a, int b)
	{
		if(a <= b)
		{
			count2(a+1, b);
			System.out.print(a + " ");
		}
	}
	
	public static void main(String args[])
	{
		System.out.println("Calling Post-Recursive Count Method :: ");
		count1(10, 20);
		System.out.println("\n\nCalling Pre-Recursive Count Method :: ");
		count2(10, 20);
	}
	
}
