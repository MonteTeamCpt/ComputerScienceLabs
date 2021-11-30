import java.util.Arrays;

public class BinarySearch101
{

	public static void main(String[] args)
	{
		// Binary Search with primitive
		
		int[] nums = {3,1,4,1,5,9};
		
		System.out.println("Unsorted: " + Arrays.toString(nums));
		
		Arrays.sort(nums);

		System.out.println("Sorted: " + Arrays.toString(nums));
		
		int key = 5;
		int loc = -1;
		int min = 0;
		int max = nums.length-1;
		

		System.out.println("\nElements checked:");
		
		while(min <= max)
		{
			int mean = (min+max/2);

			System.out.print(nums[mean] + " ");

			if(nums[mean] == key)
			{
				loc = mean;
				break;
			}
			else
			{
				if(key < nums[mean])
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
