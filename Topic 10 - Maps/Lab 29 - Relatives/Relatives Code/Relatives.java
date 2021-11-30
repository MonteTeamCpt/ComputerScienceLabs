import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Scanner;
import static java.lang.System.*;

public class Relatives
{
	private Map<String,Set<String>> map;

	/**
	 * Instatiates the map
	 */
	public Relatives()
	{
		map = new TreeMap<String,Set<String>>();
	}

	/**
	 * Gets a given line and places the first String into the Map and add the second
	 * String as a value that can continue adding out
	 * @param line - First String is a person, second String is their relative
	 */
	public void setPersonRelative(String line)
	{
		String[] personRelative = line.split(" ");

		
		if(map.get(personRelative[0]) == null) //map does not contain key
		{
			Set<String> setTree = new TreeSet<String>();
			setTree.add(personRelative[1]);
			map.put(personRelative[0], setTree);
		}
		else
		{
			Set<String> setTree = map.get(personRelative[0]);
			setTree.add(personRelative[1]);
			
			map.put(personRelative[0], setTree);
		}
	}

	/**
	 * Gets all of the relatives of a single person
	 * @param person - person to check relatives
	 * @return - relatives of person
	 */
	public String getRelatives(String person)
	{
		return map.get(person).toString().substring(1, map.get(person).toString().length()-1);
	}

	/**
	 * Properly formats the output so that it looks proper on the console
	 * @return String - A String of the whole code
	 */
	public String toString()
	{
		String output = "";

		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext())
		{
			String key = it.next();
			output += key + " is related to " + getRelatives(key) + "\n";
		}

		return output + "\n";
	}
}