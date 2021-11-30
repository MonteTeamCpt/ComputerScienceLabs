//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class OddRunner
{
	public static void main( String args[] ) throws IOException
	{
		
		Scanner input = new Scanner(new File("oddeven.dat")); 
		
		while(input.hasNextLine())
		{
			String line = input.nextLine();
			OddEvenSets test = new OddEvenSets(line);
			System.out.println(test);
		}
		
				
	}
}