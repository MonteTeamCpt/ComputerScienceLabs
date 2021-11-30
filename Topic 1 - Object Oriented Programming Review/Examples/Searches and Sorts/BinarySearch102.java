import java.util.Arrays;

public class BinarySearch102
{
	public static void main(String args[])
	{
		Comparable[] list = {"Vincent", "Ty", "Ravi", "Teja", "Rayyon", "Leia"};
		

		System.out.println("Unsorted: " + Arrays.toString(list));
		
		Arrays.sort(list);

		System.out.println("Sorted: " + Arrays.toString(list));
		
		String key = "Ty";
		int loc = -1;
		int min = 0;
		int max = list.length-1;
		

		System.out.println("\nElements checked:");
		
		while(min <= max)
		{
			int mean = (min+max)/2;

			System.out.print(list[mean] + " ");

			if(list[mean].compareTo(key) == 0)
			{
				loc = mean;
				break;
			}
			else
			{
				if(list[mean].compareTo(key) > 0)
					max = mean-1;
				else
					min = mean+1;
			}
		}
		
		if(loc != -1)
			System.out.println("\nThe Array contains " + key + " at index " + loc);
		else
			System.out.println("\nThe Array does not contain " + key + " at index " + loc);
		
	}
}
