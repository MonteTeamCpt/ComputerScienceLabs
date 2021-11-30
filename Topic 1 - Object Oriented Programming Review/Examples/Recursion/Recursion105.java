/**
 * This program demonstrates a linear search of a
 * sorted array both iteratively and recursively
 * @author lo12041430
 *
 */
public class Recursion105
{
	public static void assign(int list[])
	{
		for(int i = 0; i < list.length; i++)
		{
			list[i] = 100 + i*5;
		}
	}
	
	public static void display(int list[])
	{
		for(int num : list)
			System.out.print(num + " ");
	}
	
	/**
	 * Iterative linear search
	 * @param list array to be search
	 * @param key value it is looking for
	 * @return index if found, -1 if not
	 */
	public static int linear1(int list[], int key)
	{
		for(int i = 0; i < list.length; i++)
		{
			if(list[i] == key)
				return i;
		}
		return -1;
	}
	/**
	 * Recursive Linear Search
	 * @param list	list to be searched
	 * @param key	value to be found
	 * @param i		current index
	 * @return		return index if found, -1 if not
	 */
	public static int linear2(int list[], int key, int i)
	{
		if(i == list.length) //base case
			return -1;
		if(list[i] == key) //base case
			return i;		
		else 
			return linear2(list, key, i+1);
	}	
	
	public static void main(String[] args)
	{
		int list[] = new int[100];
		assign(list);
		display(list);
		
		System.out.println("\n\nCalling Iterative Linear Search Method");
		System.out.println("Number 420 is located at index " + linear1(list, 420));
		System.out.println("Number 311 is located at index " + linear1(list, 311));
		

		System.out.println("\n\nCalling Recursive Linear Search Method");
		System.out.println("Number 420 is located at index " + linear2(list, 420, 0));
		System.out.println("Number 311 is located at index " + linear2(list, 311, 0));
	}
}
