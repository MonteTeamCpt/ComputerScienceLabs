import java.util.Arrays;

public class LinearSearch103
{
	public static void main(String args[])
	{
		//Linear (aka Sequential) search with object
		
		Comparable[] list = {"Vincent", "Ty", "Ravi", "Teja", "Rayyon", "Leia"};
		
		int loc = -1;
		String key = "Ty"; 
				
		System.out.println("Elements checked");
		
		for(int i = 0; i < list.length; i++)
		{
			System.out.print(list[i] + " ");
			if(list[i].compareTo(key) == 0)
			{
				loc = i;
				break;
				//continue; //Ends the current iteration of the loop
			}
		}
		
		System.out.println("\n\n" + Arrays.toString(list));
		
		if(loc != -1)
			System.out.println("\nThe Array contains " + key + " at index " + loc);
		else
			System.out.println("\nThe Array does not contain " + key + " at index " + loc);
		
	}
}

		