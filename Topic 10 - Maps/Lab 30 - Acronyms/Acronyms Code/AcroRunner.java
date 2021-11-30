import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class AcroRunner
{
	public static void main( String args[] ) throws IOException
	{
		Acronyms test = new Acronyms();
		Scanner scan = new Scanner(new File("acro.dat"));
		int runs = scan.nextInt();
		scan.nextLine();
		
		System.out.println("====    MAP CONTENTS    ====\n\n");
		for(int i = 0; i < runs; i++)
		{
			test.putEntry(scan.nextLine());
		}
		
		System.out.println(test.toString()+"\n");

		System.out.println("\n====     READ LINES     ====\n\n");
		while(scan.hasNextLine())
		{
			System.out.println(test.convert(scan.nextLine()));
		}
		
	}
}