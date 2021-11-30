//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

import java.io.File;

public class OddEvenSets
{
	private Set<Integer> odds;
	private Set<Integer> evens;

	/**
	 * Instantiates odds and evens
	 */
	public OddEvenSets()
	{
		odds = new TreeSet<Integer>();
		evens = new TreeSet<Integer>();
	}

	/**
	 * using this() to instantiate odds and evens. Splits given line into Strings.
	 * parseInts the Strings to find if they are odds or even. Inserts each string
	 * into their respective Set, odds or even.
	 * @param line - input String of numbers with spaces
	 */
	public OddEvenSets(String line)
	{
		this();
		String[] set = line.split(" ");
		
		for(int i = 0; i < set.length; i++)
		{
			if(Integer.parseInt(set[i])%2 == 1)
			{
				odds.add(Integer.parseInt(set[i]));
			}
			else
				evens.add(Integer.parseInt(set[i]));
		}
	}

	/**
	 * Prints out the toString properly formatted for this lab
	 */
	public String toString()
	{
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
	}
}