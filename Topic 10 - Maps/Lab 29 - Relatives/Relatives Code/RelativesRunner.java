import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class RelativesRunner
{
	public static void main( String args[] ) throws IOException
	{
		Relatives test = new Relatives();
		Scanner scan = new Scanner(new File("relatives.dat"));
		int runs = scan.nextInt();
		scan.nextLine();
		
		for(int i = 0; i < runs; i++)
		{
			test.setPersonRelative(scan.nextLine());
		}
		
		System.out.println(test.toString());
		
	}
}