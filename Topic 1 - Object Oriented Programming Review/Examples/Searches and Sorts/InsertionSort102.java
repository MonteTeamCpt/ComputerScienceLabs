import java.util.Arrays;

public class InsertionSort102
{

	public static void main(String[] args)
	{
		//Insertion Sort with primitives
		
		Comparable[] nums = new Comparable[10];
		
		//fill the array with 10 random ints [3-21] inclusive
		for(int i = 0; i < nums.length; i++)
			nums[i] = (int)(Math.random()*19)+3;
		
		//print Array
		System.out.println("Unsorted: " + Arrays.toString(nums));
	
		for(int i = 1; i < nums.length; i++)// i = is the first index of the array
		{
			Comparable temp = nums[i];
			int j = i;
			while(j > 0 && temp.compareTo(nums[j-1]) < 0)
			{
				nums[j] = nums[j-1]; //shift element to the right
				j--;
			}
			nums[j] = temp;
		}
		System.out.println("Sorted: " + Arrays.toString(nums));

	}

}
