
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Zeckendorf
{
	/**
	 * This method will receive a String(txt file) full of integer values and 
	 * will use a scanner to read each line of the String through a for loop 
	 * until all the numbers are read, entered into an array, and ran through the
	 * method printNums. The first number of the @param fileName will indicate the 
	 * number of tests that will be done. All the numbers after the first will be test cases.
	 * Lastly this will print the results of the Fibonacci calculations.
	 * 
	 * @param fileName carries the numbers that are inside of the .txt files
	 * @throws IOException
	 */
	void zeck(String fileName) throws IOException
	{
		//Creates a Scanner that will be able to obtain the integer values from the file it receives
		Scanner input = new Scanner(new File(fileName)); 
		 //Initializing an integer array to input all of the incoming integers from Scanner input
		int[] arrayZeck = new int[input.nextInt()];
		
		/**
		 * Creates a for loop that starts @0 that increments in value of one
		 * until it reaches the length of arrayZeck. This loop will add integer
		 * value line by line from Scanner input and then run them through printNums.
		 */
		for(int i = 0; i < arrayZeck.length; i++) 
		{
			 //Using scanner to fill array with their respective Scanner input value
			arrayZeck[i] = input.nextInt();
			//This will use the latest 
			System.out.println(printNums(arrayZeck[i])); 
		}
	}
	
	/**
	 * This method will create all the fibonacci numbers from least to greatest
	 * starting at 0 and 1 until it is equal to or greater than @param num. 
	 * They will use variables first and second as the two current largest 
	 * fibonacci numbers as test cases to see if they are the greatest fibonacci 
	 * numbers for @param num
	 * 
	 * @param num	: Will be used to see what is the biggest fib number inside of it
	 * @return		: The largest fibonacci number that could fit inside of num
	 */
	int findLargestFib(int num)
	{
		int first = 0; //first fibonacci number
		int second = 1;//second fibonacci number
		int count = 0; // count is used to see if second or first should be incremented
		
		//boolean are purposely initialized as false for the do while loop
		boolean unstoppable = false;
		
		//do while loop is used to continuously count fib numbers until
		//a fib number equal are greater than num is found
		do 
		{
			if(num == first || num < second) 
			{
				return first;
			}
			else if(num == second || num < first)
			{
				return second;
			}
			else
			{
				//reason for count is so that only one number can be added at once 
				if(count % 2 == 0) 
				{
					second = second + first;
				}
				else
				{
					first = second + first;
				}
				/*
				 * count increments so that next time the loop run the other 
				 * variable(either first or second) will increment instead 
				 * of the on the ran previously.
				 */
				count++;
			}
		}
		//repeats the loop infinitely until largest fib is found 
		while(unstoppable == false);
		
		return 0;
	}
	
	/**
	 * This method will print out @param num and find all the fibonacci numbers
	 * use to create it after the equals sign. This method will implement
	 * the method findLargestFib in order to find the largest fib num
	 * 
	 * @param num	: Integar value
	 * @return		: A string with the num and all of its inner fib numbers
	 * 				  used to create it(no fib number repeats)
	 */
	String printNums(int num)
	{
		//sets up and formats the return string with the original num
		String str = num + " = "; 
		boolean flag = false;
		
		do
		{
			/*
			 * The first if() is to check if the num is already a fib num 
			 * if true it will add the number to the string and end the loop
			 * The Second else will find the greatest fib inside of fib 
			 * and add it to the string then subtracting it from num 
			 * This will keep running until num is a fib num
			 */
			if(findLargestFib(num) == num)
			{
				str += "" + num;
				flag = true;
			}
			else
			{
				str += findLargestFib(num) + " + ";
				num = num - findLargestFib(num);
			}
				
		}while(flag == false);
			
		return str;
	}
	
	/**
	 * Main method: this method will initialize an object of this class 
	 * to call on zeck using the parameter of the project file "zeck.txt"
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException
	{
		Zeckendorf Zeck = new Zeckendorf();
		Zeck.zeck("zeck.txt");
	}
}