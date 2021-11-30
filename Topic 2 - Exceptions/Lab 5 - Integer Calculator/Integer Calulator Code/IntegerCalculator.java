import java.util.*;

public class IntegerCalculator
{
	private int operand1;
	private int operand2;
	private int result;

	/**
	 * runs method mainMenu()
	 */
	public IntegerCalculator()
	{
		mainMenu();
	}

	/**
	 * calls getInfo and runs an operator method depending on the output that 
	 * getInfo called.
	 */
	public void mainMenu()
	{
		int ans = 0;

		do
		{
			ans = getInfo();

			if(ans == 1)
               add();
			if(ans == 2)
               subtract();
			if(ans == 3)
               multiply();
			if(ans == 4)
			   divide();

			System.out.println();
		}
		while(ans != 5);
	}

	// Postcondition:Retrieves calculator input from the user.
	//   Asks the user to select from a menu which operation they wish
	//   to perform 1) add 2) subtract 3) multiply 4) divide.
	//   It then asks the user to enter in two operands. If either of
	//   the two operands are not valid integers it displays an error
	//   message and asks the user for the information again.
	//   The method returns an integer representing operation selected
	//   by the user
	public int getInfo()
	{
		Scanner keyboard = new Scanner(System.in);
	    
	    int num = 0;
	    
	    System.out.print("1)Add 2)Subtract 3)Multiply 4)Divide 5)Quit --> ");
	   
	    try
		{
			num = keyboard.nextInt();
		}
	    catch(InputMismatchException e)
	    {
	    	System.out.println("\nNot a valid number, try again.");
	    	return 0;
	    }
	    
	    if(num < 0 || num > 5)
	    {
	    	System.out.println("\nNot a valid number, try again.");
	    	return num;
	    }
	    else if(num == 5)
	    	return num;

	    System.out.print("\nOperator 1 -->  ");
	    try
		{
			operand1 = keyboard.nextInt();
		}
	    catch(InputMismatchException e)
	    {
	    	System.out.println("\nNot a valid number, try again.");
	    	return 0;
	    }	    
	    
	    System.out.print("Operator 2 -->  ");
	    
	    try
		{
			operand2 = keyboard.nextInt();
		}
	    catch(InputMismatchException e)
	    {
	    	System.out.println("\nNot a valid number, try again.");
	    	return 0;
	    }
	    
	    return num;
	  
	}

	/**
	 * Operator method that adds and prints operand1 and operand2
	 */
	public void add()
	{
		result = operand1 + operand2;
		System.out.println("\n" + operand1 + " + " + operand2 + " = " + result);
	}

	/**
	 * Operator method that subtracts and prints operand1 and operand2
	 */
	public void subtract()
	{
		result = operand1 - operand2;
		System.out.println("\n" + operand1 + " - " + operand2 + " = " + result);
	}

	/**
	 * Operator method that multiplies and prints operand1 and operand2
	 */
	public void multiply()
	{
		result = operand1 * operand2;
		System.out.println("\n" + operand1 + " * " + operand2 + " = " + result);

	}

	// Precondition:  two valid operands
	// Postcondition: performs the division operation on the two
	//    operands and displays the results. If a division by zero
	//    error occurs it displays an error message and does not
	//    display any results.
	public void divide()
	{
		boolean flag = true;
		try 
    	{
    		result =  operand1 / operand2; 
    		System.out.println("\n" + operand1 + " / " + operand2 + " = " + result);
    	}
    	catch (ArithmeticException e) 
    	{
    		System.out.println("\nError: You cannot divide by zero!");
      	}
		
	}

	/**
	 * Runner instantiates an object of IntegerCalculator
	 * @param args - args is something i dont know
	 */
	public static void main(String[] args)
	{
		IntegerCalculator app = new IntegerCalculator();
	}
}