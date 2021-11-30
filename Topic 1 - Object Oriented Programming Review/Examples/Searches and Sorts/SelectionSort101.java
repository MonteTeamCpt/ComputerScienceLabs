import java.util.Arrays;

public class SelectionSort101
{

	public static void main(String[] args)
	{
		//Selection Sort with primitives 
		int[] nums = new int[10];
			
		//fill the array with 10 random ints [5-20] inclusive
		for(int i = 0; i < nums.length; i++)
			nums[i] = (int)(Math.random()*16)+5;
		
		//print Array
		System.out.println("Unsorted: " + Arrays.toString(nums));
		
		for(int i = 0; i < nums.length-1; i++) //first index of unsorted array
		{
			int min = i;
			//check the unsorted portion of the array for the smallest element
			for(int j = i+1; j < nums.length; j++)
			{
				if(nums[j] < nums[min])
					min = j;
			}
			if(min != i)
			{
				//swap: put smallest in position 'i' if not already in position 'i'
				int temp = nums[min];
				nums[min] = nums[i];
				nums[i] = temp;
			}
		}
		System.out.println("Sorted: " + Arrays.toString(nums));

	}

}
