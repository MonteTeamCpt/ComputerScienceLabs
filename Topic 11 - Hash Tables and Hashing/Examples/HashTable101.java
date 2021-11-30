
public class HashTable101
{
	public static void main(String[] args)
	{
		Object[] hashTable = new Object[10];
		
		Character c = '1';
		System.out.println("hashCode for 'c': " + c.hashCode());
		hashTable[c.hashCode()%10] = c;
		
		Character d = 'A';
		System.out.println("hashCode for 'd': " + d.hashCode());
		hashTable[d.hashCode()%10] = d;
		
		Integer num = 113;
		System.out.println("hashCode for 'num': " + num.hashCode());
		hashTable[num.hashCode()%10] = num;
		
		String s = "e";
		hashTable[s.hashCode()%10] = s;
		
		System.out.println(hashTable.toString());
		
		int index = 0;
		
		for(Object thing : hashTable)
		{
			System.out.println("Index " + index++ + ": " + thing);
		}
		
	}
}
