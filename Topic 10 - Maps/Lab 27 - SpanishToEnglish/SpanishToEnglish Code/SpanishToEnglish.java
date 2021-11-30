
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanishToEnglish
{
	private Map<String,String> pairs;

	/**
	 * Instatiates the constructor
	 */
	public SpanishToEnglish()
	{
		pairs = new TreeMap<String,String>();
	}

	/**
	 * Gets a line of code from the dat file and adds it to pairs
	 * @param entry - a line of strings that has spanish word 
	 * 				  first and english second
	 */
	public void putEntry(String entry)
	{
		String[] list = entry.split(" ");
		
		pairs.put(list[0], list[1]);

	}

	/**
	 * Enters a String of Spanish words and translates it with the given
	 * pairs of spanish to english words in the Map
	 * @param sent - String of spanish words
	 * @return - String of english words
	 */
	public String translate(String sent)
	{
		Scanner chop = new Scanner(sent);
		String str;
		String output = "";
		
		while(chop.hasNext())
		{
			str = chop.next();
			output += pairs.get(str) + " ";
		}

		return output;
	}

	/**
	 * Properly prints out the Map according to the required format
	 * returns - A String of the Map Contents
	 */
	public String toString()
	{
		return "====   MAP CONTENTS   ====\n\n" + pairs.toString().replaceAll("\\,","\n");
	}
}