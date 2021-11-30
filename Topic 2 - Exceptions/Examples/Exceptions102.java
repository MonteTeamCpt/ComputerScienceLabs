import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * All exceptions ultimately derive from the Throwable class.
 * The immediate sub classes of Throwable are Error and Exception
 * Common Exceptions are IOException and RunTimeException
 * IOExceptions are use for exceptions beyond your control (e.g., the disk is full)
 * RunTimeExceptions indicate programmer error (e.g., you tired to write past the end of an array)
 */

public class Exceptions102
{
	/**
	 * IOExceptions are considered "checked exception"
	 * "Checked" refers to the fact that the compiler will check
	 * to ensure that the exceptions are caught. Checked exceptions
	 * are not monitored by a try/catch block.
	 * 
	 * You must mark your method to indicate that is throws this exception.
	 */
	
	public static void readFile1() throws IOException
	{
		File file = new File("mystery.txt");
		Scanner scan = new Scanner(file);
	}
	
	public static void readFile2()
	{
		try
		{
			File file = new File("mystery.txt");
			Scanner scan = new Scanner(file);
		}
		catch(IOException e)
		{
			System.out.println("No file found");
		}
	}
	
	//Any method that share the stack with an IOException must indicate that it throws this exception
	public static void main(String[] args) //throws IOException
	{
		//readFile1();
		readFile2();
	} 
	
}
