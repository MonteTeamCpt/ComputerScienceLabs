import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class IteratorRemover
{
	private ArrayList<String> list;
	private String toRemove;

	/**
	 * uses method setTest to initialize list and toRemove
	 * @param line - line of words
	 * @param rem - what string to remove
	 */
	public IteratorRemover(String line, String rem)
	{
		setTest(line,rem);
	}

	/**
	 * Initializes list by splitting line into words and inserting them into 
	 * list. Then iniializes toRemove with rem.
	 * @param line - line of words
	 * @param rem - what string to remove
	 */
	public void setTest(String line, String rem)
	{
		String[] words = line.split(" "); 
		list = new ArrayList<String>(Arrays.asList(words));
		toRemove = rem;	
	}

	/**
	 * initializes an iterator using list and goes throught it removing
	 * any values of list that equals toRemove.
	 */
	public void remove()
	{
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			if(it.next().equals(toRemove))
				it.remove();
		}
	}

	/**
	 * Prints out list
	 */
	public String toString()
	{ 
		return list.toString();
	}
}