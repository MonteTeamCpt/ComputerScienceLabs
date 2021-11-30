import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanRunner
{
	public static void main( String args[] ) throws IOException
	{
		SpanishToEnglish test = new SpanishToEnglish();
		
		Scanner scan = new Scanner(new File("spantoeng.dat"));
		int words = scan.nextInt();
		scan.nextLine();
		
		
		for(int i = 0; i < words; i++)
		{
			test.putEntry(scan.nextLine());
		}
		
		System.out.println(test.toString() + "\n\n");
		
		System.out.println(test.translate(scan.nextLine()));
		System.out.println(test.translate(scan.nextLine()));
		System.out.println(test.translate(scan.nextLine()));
		System.out.println(test.translate(scan.nextLine()));
		System.out.println(test.translate(scan.nextLine()));
		
	}
}