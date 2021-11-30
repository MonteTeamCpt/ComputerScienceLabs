import java.io.*;
import java.util.*;

public class WordChainRunner
{
	
	public static void main(String[] args)
	{
		WordChain test = new WordChain(new File("dictionary.txt"));
		Scanner scan = new Scanner("");
		
		try{scan = new Scanner(new File("input.txt"));}
		catch (FileNotFoundException e1){}
		
		for (int i = 0; i < test.dictionary.size(); i++)
		{
			try {test.setStartEnd(scan.next(), scan.next());}
			catch(NoSuchElementException e) {System.exit(i);};
			System.out.println(test.toString());
		}
		
	}
}
