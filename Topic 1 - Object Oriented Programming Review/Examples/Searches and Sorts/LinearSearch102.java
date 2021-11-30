import java.util.Arrays;

public class LinearSearch102
{
	public static void main(String args[])
	{
		//Linear (aka Sequential) search with primitives
		
		int[] nums = {3,1,4,1,5,9};
		
		int loc = -1;
		int key = 4; 
				
		System.out.println("Elements checked");
		
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i] + " ");
			if(nums[i] == key)
			{
				loc = i;
				break;
				//continue; //Ends the current iteration of the loop
			}
		}
		
		System.out.println("\n\n" + Arrays.toString(nums));
		
		if(loc != -1)
			System.out.println("\nThe Array contains " + key + " at index " + loc);
		else
			System.out.println("\nThe Array does not contain " + key + " at index " + loc);
		
	}
}

		