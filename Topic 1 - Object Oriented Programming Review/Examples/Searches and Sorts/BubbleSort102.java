import java.util.Arrays;

public class BubbleSort102
{
	public static void main(String[] args)
	{
		//Bubble Sort with primitives
		
		Comparable[] nums = new Comparable[10];
		
		//fill the array with 10 random ints [2-11] inclusive
		for(int i = 0; i < nums.length; i++)
			nums[i] = (int)(Math.random()*10)+2;
		
		//print Array
		System.out.println("Unsorted: " + Arrays.toString(nums));
		
		int count = 0;
		do
		{
			count = 0;
			for(int i = 0; i < nums.length-1; i++)
			{
				if(nums[i].compareTo(nums[i+1]) > 0)
				{
					swap(nums, i, i+1);
					count++;
				}
			}
		}while(count > 0);
		
		System.out.println("Sorted: " + Arrays.toString(nums));
	}
	
	private static void swap(Comparable nums[], int pos1, int pos2)
	{
		Comparable temp = nums[pos1];
		nums[pos1] = nums[pos2];
		nums[pos2] = temp;
	}
}
