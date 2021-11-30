//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static java.lang.System.*;

public class MathSet
{
	private Set<Integer> one;
	private Set<Integer> two;

	/**
	 * Instantiates Set one and two
	 */
	public MathSet()
	{
		one = new TreeSet<Integer>();
		two = new TreeSet<Integer>();
	}

	
	/**
	 * Instantiates the variables one and two with the values from o and t 
	 * respectively using .split and parseInt.
	 * @param o
	 * @param t
	 */
	public MathSet(String o, String t)
	{
		this();
		String[] setOne = o.split(" ");
		String[] setTwo = t.split(" ");
		
		for(int i = 0; i < setOne.length; i++)
		{
			one.add(Integer.parseInt(setOne[i]));
		}
		
		for(int i = 0; i < setTwo.length; i++)
		{
			two.add(Integer.parseInt(setTwo[i]));
		}
		
	}

	/**
	 * Adds all of Sets one and two together
	 * @return - A TreeSet with both values from one and two
	 */
	public Set<Integer> union()
	{
		Set<Integer> union = new TreeSet<Integer>();
		
		union.addAll(one);
		union.addAll(two);
		
		return union;
	}

	/**
	 * Uses an Iterator of one to compare all values of one to two to find
	 * if "two contains one" is true then adds it to intersections
	 * @return - the values of the intersected points of one and two
	 */
	public Set<Integer> intersection()
	{
		Set<Integer> intersection = new TreeSet<Integer>();
		
		Iterator<Integer> first = one.iterator();
		int num;
		
		while(first.hasNext())
		{
			num = first.next();
			if(two.contains(num))
				intersection.add(num);
		}
		
		return intersection;
	}

	/**
	 * Uses an Iterator of one to compare all values of one to two to find
	 * if "two contains one" is false then adds it to DifferenceAMinusB
	 * @return - the difference of set one from set two
	 */
	public Set<Integer> differenceAMinusB()
	{
		Set<Integer> differenceAMinusB = new TreeSet<Integer>();
		
		Iterator<Integer> first = one.iterator();
		int num;

		while(first.hasNext())
		{
			num = first.next();
			if(two.contains(num) == false)
				differenceAMinusB.add(num);
		}
		
		return differenceAMinusB;
	}

	/**
	 * Uses an Iterator of two to compare all values of two to one to find
	 * if "one contains two" is false then adds it to DifferenceBMinusA
	 * @return - the difference of set two from set one
	 */
	public Set<Integer> differenceBMinusA()
	{
		Set<Integer> differenceBMinusA = new TreeSet<Integer>();
		
		Iterator<Integer> second = two.iterator();
		int num;

		while(second.hasNext())
		{
			num = second.next();
			if(one.contains(num) == false)
				differenceBMinusA.add(num);
		}
		return differenceBMinusA;
	}
	
	/**
	 * adds the values of differenceAMinusB and differenceBMinusA into 
	 * symmetricDifference
	 * @return - the values of differenceAMinusB and differenceBMinusA
	 */
	public Set<Integer> symmetricDifference()
	{		
		Set<Integer> symmetricDifference = new TreeSet<Integer>();
		
		symmetricDifference.addAll(this.differenceAMinusB());
		symmetricDifference.addAll(this.differenceBMinusA());
		
		return symmetricDifference;
	}	
	
	/**
	 * A toString properly displays the values in Set one and Set Two
	 */
	public String toString()
	{
		return "Set one " + one + "\n" +	"Set two " + two +  "\n";
	}
}