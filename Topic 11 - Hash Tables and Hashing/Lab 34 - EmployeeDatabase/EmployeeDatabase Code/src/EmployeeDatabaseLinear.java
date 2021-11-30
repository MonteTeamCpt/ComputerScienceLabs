import java.util.*;

public class EmployeeDatabaseLinear
{
	private Entry[] hashTable;
	
	/**
	 * Initializes the Array of Entries(aka. hashTable)
	 * @param entries
	 */
	public EmployeeDatabaseLinear(int entries)
	{
		hashTable = new Entry[entries];
	}
	
	/**
	 * Inner class, the nodes of the HashTable
	 * contains Employee Information and ID
	 */
	private class Entry
	{
		Integer ID;
		Employee employee;
		public Entry()
		{
			ID = null;
			employee = null;
		}
		public Entry(Integer num, Employee e)
		{
			ID = num;
			employee = e;
		}
		public String toString()
		{
			return  ID + " - " + employee.toString();
		}
	}
	
	/**
	 * Puts the employee inside of the hashTable according to the hashCode
	 * of their ID
	 * @param key - Employee ID
	 * @param e - Employee Information
	 */
	public void put(Integer key, Employee e)
	{
		int keyHash = hashCode(key);
		
		try
		{
			while(hashTable[keyHash] != null)
			{
				keyHash++;	
			}
			hashTable[keyHash] = new Entry(key, e);
		} 
		catch(Exception ex){}
	
	}
	
	/**
	 * Collects the employee at the hashCode of key while checking their ID
	 * @param key - Employee ID
	 * @return - the employee at hashCode(key) || null if not found
	 */
	public Employee get(Integer key)
	{
		int keyHash = hashCode(key);
		
		try
		{
			while(hashTable[keyHash] == null || hashTable[keyHash].ID != key)
			{
				keyHash++;
				if(keyHash == hashTable.length)
					return null;
			}
			return hashTable[keyHash].employee;
		} 
		catch(Exception ex){}
		
		return null;
	}
	
	/**
	 * Hashcode algorithm
	 * @param num - given Integer to hashcode
	 * @return - hashcode value of given integer
	 */
	public int hashCode(int num)
	{	
		return (num * num + 7) % hashTable.length;
	}
	
	/**
	 * Properly formatted toString of hashTable
	 */
	public String toString()
	{
		String output = "";
		
		for(Entry e : hashTable)
		{
			if(e != null)
				output += e + "\n";
		}	
		
		return output; 
	}	
}
