import java.io.*;
import java.util.*;

public class PhoneBookRunner 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		PhoneBook tester = new PhoneBook();
		Scanner scan = new Scanner(new File("White Pages.txt"));
		
		while(scan.hasNextLine()) 
		{
			String[] data = scan.nextLine().split(",");
			Person person = new Person(data[0] + ", " +  data[1]);
			PhoneNumber num = new PhoneNumber(data[2]);
			tester.put(person, num);
		}
		System.out.println(tester);
	}
}
