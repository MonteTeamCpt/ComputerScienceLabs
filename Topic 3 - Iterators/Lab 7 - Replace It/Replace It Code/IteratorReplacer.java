import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

@SuppressWarnings("unused")
public class IteratorReplacer
{
	private ArrayList<Integer> list;
	private int toRemove, replaceWith;

	/**
	 * uses method setTest to initialize list and toRemove
	 * @param line - line of words
	 * @param rem - what string to remove
	 * @param rep - what string to replace rem with
	 */
	public IteratorReplacer(String line, String rem, String rep)
	{
		setEmAll(line, rem, rep);
	}
	
	/**
	 * Initializes list by splitting line into words and converting them into
	 * integers and inserting them into list using an ArrayList. Then iniializes
	 * toRemove with rem and replaceWith with rep using parseInt.
	 * 
	 * @param line - line of words
	 * @param rem - what string to remove
	 * @param rep - what string to replace rem with
	 */
	public void setEmAll(String line, String rem, String rep)
	{
		String[] words = line.split(" "); 
		list = new ArrayList<Integer>();
		for(int i = 0; i < words.length; i++)
		{
			list.add(Integer.parseInt(words[i]));
		}
		toRemove = Integer.parseInt(rem);
		replaceWith = Integer.parseInt(rep);
		
	}

	/**
	 * Goes through list using an iterator and replaces toRemove w/ replaceWith
	 */
	public void replace()
	{
		ListIterator<Integer> it = list.listIterator();
		while(it.hasNext())
		{
			if(it.next().equals(toRemove))
			{
				it.set(replaceWith);
			}
		}
		
	}

	/**
	 * Prints out the array
	 */
	public String toString()
	{
		return list.toString();
	}
}