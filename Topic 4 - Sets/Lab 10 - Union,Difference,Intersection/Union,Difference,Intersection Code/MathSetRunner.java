//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class MathSetRunner
{
	public static void main(String args[]) throws IOException
	{
		Scanner input = new Scanner(new File("mathsetdata.dat")); 
		
		while(input.hasNextLine())
		{
			String first = input.nextLine();
			String second = input.nextLine();
			MathSet test = new MathSet(first, second);
			System.out.println(test);
			System.out.println("Union - " + test.union());
			System.out.println("Intersection - " + test.intersection());			
			System.out.println("Difference A-B - " + test.differenceAMinusB());			
			System.out.println("Difference B-A - " + test.differenceBMinusA());			
			System.out.println("symmetric difference - " + test.symmetricDifference());			
			System.out.println("\n");
		}
	}
}
