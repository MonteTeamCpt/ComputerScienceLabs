
import java.util.LinkedList;
import java.util.Scanner;

public class HashTable
{
	@SuppressWarnings("rawtypes")
	private LinkedList[] table;
	private boolean isNum;
	
	/**
	 * Completely initializes the array
	 */
	@SuppressWarnings("rawtypes")
	public HashTable( )
	{
		table = new LinkedList[10];
		
		for(int i = 0; i < table.length; i++)
		{
			table[i] = new LinkedList();
		}
	}

	/**
	 * Adds object to the table by casting into number
	 * @param obj
	 */
	public void add(Object obj)
	{
		
		isNum = false;
		
		try 
		{
			int num = Integer.parseInt(obj + "");
			isNum = true;
		}
		catch(Exception e){}
		
		if(isNum)
		{
			Number test = new Number(Integer.parseInt(obj+""));
			int i = test.hashCode()%10;
			
			if(!table[i].contains(test.getValue()))
				table[i].add(test.getValue());
		}
		else
		{
			Word test = new Word(obj +"");
			
			int i = test.hashCode()%10;

			if(!table[i].contains(test))
				table[i].add(test);

		}

	}

	/**
	 * Properly formats the Hashtable
	 */
	public String toString()
	{
		String output="HASHTABLE\n";
		
		if(isNum)
		{
			for(int i = 0; i < table.length; i++)
			{
				output += "bucket " + i + ": " + table[i] + "\n";
			}
		}
		else 
		{
			for(int i = 0; i < table.length; i++)
			{
				output += "bucket " + i + " " + table[i].toString().substring(1, table[i].toString().length()-1) + "\n";
			}
			output = output.replace(",", "");
		}
		return output;
	}
}