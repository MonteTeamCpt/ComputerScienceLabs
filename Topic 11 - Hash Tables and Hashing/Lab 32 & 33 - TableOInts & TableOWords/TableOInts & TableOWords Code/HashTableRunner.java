
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HashTableRunner
{
  public static void main ( String[] args ) throws FileNotFoundException
  {
		try{
			//make a new table	
			HashTable table = new HashTable();
			
			//read from the file
			
			Scanner scan = new Scanner(new File("words.dat"));
			//Scanner scan = new Scanner(new File("numbers.dat"));
			
			int runs = scan.nextInt();
			
			//load stuff into the table			
			for(int i = 0; i < runs; i++)
			{
				table.add(scan.next());
			}
			
			//print out the table
			System.out.println(table.toString());
			
		}
		catch(Exception e)
		{
			System.out.println("Houston, we have a problem!");
		}
  }
}