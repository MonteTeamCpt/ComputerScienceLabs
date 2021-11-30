import static java.lang.System.*;
import java.util.Scanner;

public class Exceptions104
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(in);
		out.print("Enter an integer: ");
		int num = scan.nextInt();
		int answer = 0;
		
		try
		{
			if(num == 0)
				throw new Exception("Dividing by zero again I see.");
			else 
				answer=42/num;
		}
		catch(NullPointerException e)
		{
			out.println(e + "\nNull Pointer Exception");
		}
		catch(ClassCastException e)
		{
			out.println(e + "\nClass Cast Exception");
		}
		catch(Exception e)
		{
			out.println(e + "\nGeneral Stupid Exception");
		}
		//Code placed in the finally block is guaranteed to run whether or not an exception is caught
		finally
		{
			out.println("this always happens");
			scan.close();
		}
		
		System.out.println("The answer is " + answer);
	}
}
