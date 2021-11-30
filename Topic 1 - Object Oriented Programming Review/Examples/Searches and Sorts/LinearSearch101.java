import java.util.Arrays;

public class LinearSearch101
{
	public static void main(String args[])
	{
		//Linear (aka Sequential) search with primitives
		
		int[] nums = {3,1,4,1,5,9};
		
		boolean found = false;
		
		int key = 4;
		
		System.out.println("Elements checked");
		
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i] + " ");
			if(nums[i] == key)
			{
				found = true;
				break;
				//continue; //Ends the current iteration of the loop
			}
		}
		
		System.out.println("\n\n" + Arrays.toString(nums));
		
		if(found == true)
			System.out.println("\nThe Array contains " + key);
		else
			System.out.println("\nThe Array does not contain " + key);

	}
	
	
}
