
public class PhoneBook implements IMap
{
	/**
	 * 
	 * @author oscar
	 * This class is the node of the Phonebook
	 */
	class Entry
	{
		Person person;
		PhoneNumber number;
		Entry next;
		
		public Entry(Person p, PhoneNumber num)
		{
			person = p;
			number = num;
		}

		public String toString()
		{
			return "" + person + ": " + number;
		}
	}
	private Entry[] hashTable;
	public static int size;
	
	/**
	 * Initializes the array
	 */
	public PhoneBook()
	{
		size = 0;
		hashTable = new Entry[12];
	}
	/**
	 * Initializes the array with a certain size given through the parameter
	 * @param size - given int value for size of the hashTable
	 */
	public PhoneBook(int size)
	{
		hashTable = new Entry[size];
		this.size = size;
	}
	
	/**
	 * Puts a person with their respective phone into the hashTable
	 * @param - A person's name and phone
	 * @return - the number
	 */
	public PhoneNumber put(Person person, PhoneNumber phone)
    {
        int temp = person.hashCode();
        Entry node = new Entry(person, phone);
        Entry tempTwo = hashTable[temp];
        if(tempTwo != null)
        {
            while(tempTwo.next != null)
            {
                if(tempTwo.person.equals(tempTwo.next.person))
                {
                    return tempTwo.number;
                }
                tempTwo = tempTwo.next;
            }
            tempTwo.next = node;
        }
        else
        {
            hashTable[temp] = node;
        }
        size++;
        return phone;
    }
	
	/**
	 * Retrieves the number of the given person
	 * @param person - passes Person object
	 * @return - the number of the given person
	 */
	public PhoneNumber get(Person person)
	{
		int temp = person.hashCode();
		Entry tempTwo = hashTable[temp];
		while(tempTwo != null)
		{
			if(tempTwo.person.equals(person))
			{
				return tempTwo.number;
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
	public PhoneNumber remove(Person person)
	{
		int temp = person.hashCode();
		Entry tempTwo = hashTable[temp];
		if(tempTwo.equals(person))
		{
			PhoneNumber back = tempTwo.number;
			hashTable[temp] = tempTwo.next;
			size--;
			return back;
		}

		else
		{
			if(tempTwo.next.equals(person))
			{
				PhoneNumber back = tempTwo.number;
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
        for(int i = 0;i< hashTable.length; i++)
        {
            s+= "Bucket "+ i + ": ";
            while(hashTable[i]!=null)
            {
                s+= hashTable[i] + ", ";
                hashTable[i] = hashTable[i].next;
            }
            s = s.substring(0,s.length()-2);
            s+="\n";
        }
        return s;
	}
}
