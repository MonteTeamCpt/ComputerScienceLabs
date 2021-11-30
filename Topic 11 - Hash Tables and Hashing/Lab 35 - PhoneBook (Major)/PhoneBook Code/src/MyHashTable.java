public class MyHashTable<K, V> 
{
	class Entry<K, V>
	{
		K person;
		V pNumber;
		Entry<K, V> next;
		
		/**
		 * 
		 * @author oscar
		 * This class is the node of the Phonebook
		 */
		public Entry(K person, V pNumber)
		{
			this.person = person;
			this.pNumber = pNumber;
		}
		
		public String toString()
		{
			return "" + person + ": " + pNumber;
		}
	}
	private Entry<K, V>[] hashTable;
	public static int size;
	
	/**
	 * Initializes the array
	 */
	public MyHashTable()
	{
		size = 0;
		hashTable = new Entry[10000];
	}
	/**
	 * Initializes the array with a certain size given through the parameter
	 * @param size - given int value for size of the hashTable
	 */
	public MyHashTable(int size)
	{
		hashTable = new Entry[size];
		this.size = size;
	}
	/**
	 * Puts a person with their respective phone into the hashTable
	 * @param - A person's name and phone
	 * @return - the number
	 */
	public V put(K person, V phone)
	{
		try
		{
			int temp = person.hashCode();
			Entry<K, V> node = new Entry(person, phone);
			Entry<K, V> tempTwo = hashTable[temp];
			
			if(tempTwo != null)
			{
				while(tempTwo.next != null)
				{
					if(tempTwo.person.equals(person))
					{
						return tempTwo.pNumber;
					}
				}
				tempTwo.next = node;
				}
			else
			{
				hashTable[temp] = node;
			}	
			size++;
			return phone;
			
		}catch(Exception e){}
		
		return phone;
	}
	/**
	 * Retrieves the number of the given person
	 * @param person - passes Person object
	 * @return - the number of the given person
	 */
	public V get(K person)
	{
		int temp = person.hashCode();
		Entry<K, V> tempTwo = hashTable[temp];
		while(tempTwo != null)
		{
			if(tempTwo.person.equals(person))
			{
				return tempTwo.pNumber;
			}
			tempTwo = tempTwo.next;
		}
		return null;
	}
	/**
	 * Returns the size of the array
	 */
	public int size()
	{
		return size;
	}
	/**
	 * Removes a specific person from the HashTable
	 * @param - the person to remove
	 * @return - the person removed
	 */
	public V remove(K person)
	{
		int temp = person.hashCode();
		Entry<K, V> tempTwo = hashTable[temp];
		if(tempTwo.equals(person))
		{
			V back = tempTwo.pNumber;
			hashTable[temp] = tempTwo.next;
			size--;
			return back;
		}

		else
		{
			if(tempTwo.next.equals(person))
			{
				V back = tempTwo.pNumber;
				hashTable[temp] = tempTwo.next;
				size--;
				return back;
			}
		}
		return remove(person);
	}

	/**
	 * Properly creates the output of the hashTable
	 */
	public String toString()
	{
		String s = "";
		for (int i = 0; i < hashTable.length; i++) 
		{
			s += i + ":" + hashTable[i] + "\n";
		}
		return s;
	}
	
	

}