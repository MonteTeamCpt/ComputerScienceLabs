//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Oscar Montealegre

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import static java.lang.System.*;

public class UniquesDupes
{
	/**
	 * Get the inputed string and enters each element into the TreeSet
	 * 
	 * @param input - A string with spaces between the spaces
	 * @return - unique values in the inputed String
	 */
	public static Set<String> getUniques(String input)
	{
		String[] words = input.split(" ");
		Set<String> uniques = new TreeSet<String>(Arrays.asList(words));

		return uniques;
	}
	
	/**
	 * Gets the duplicated elements from the input and puts them into a set
	 * 
	 * @param input - A string with spaces between the spaces
	 * @return - The duplicates in the inputed String
	 */
	public static Set<String> getDupes(String input)
	{
		String[] words = input.split(" ");

		Set<String> first = new TreeSet<String>();
		Set<String> dupes = new TreeSet<String>();
		
		for(int i = 0; i < words.length; i++)
		{
			if(first.contains(words[i]))
				dupes.add(words[i]);
			first.add(words[i]);
			
		}
		return dupes;
	}
}