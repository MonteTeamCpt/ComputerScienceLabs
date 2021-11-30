import static java.lang.System.*;

import java.util.*;

public class JavaLinkedList
{
	private LinkedList<Integer> list;

	/**
	 * Instantiates the list
	 */
	public JavaLinkedList()
	{
		list = new LinkedList<Integer>();
	}

	/**
	 * Instanitates and enters all numbers into the linkedList
	 * @param nums - list of numbers
	 */
	public JavaLinkedList(int[] nums)
	{
		list = new LinkedList<Integer>();
		for(int num : nums)
		{
			list.add(num);
		}
	}

	/**
	 * Gets sum of all the numbers in the linkedList
	 * @return - sum of all the numbers in the LinkedList
	 */
	public double getSum(  )
	{
		double total=0;
		
		for(int num : list)
		{
			total += num;
		}
		
		return total;
	}

	/**
	 * Calls the getSum() and divides it by the number of elements in the list
	 * @return
	 */
	public double getAvg(  )
	{
		return (Double)getSum()/list.size();
	}

	/**
	 * Goes through the list and finds the largest value in the List
	 * @return - Largest value in the Array
	 */
	public int getLargest()
	{
		int largest=Integer.MIN_VALUE;
		for(int num : list)
		{
			if(num > largest)
				largest = num;
		}
		return largest;
	}

	/**
	 * Goes through the list and finds the smallest value in the List
	 * @return - smallest value in the array
	 */
	public int getSmallest()
	{
		int smallest = smallest=Integer.MAX_VALUE;
		
		for(int num : list)
		{
			if(num < smallest)
				smallest = num;
		}
		
		return smallest;
	}

	/**
	 * Properly formates the output
	 */
	public String toString()
	{
		String str = "";
		
		str += "\nSUM:: " + getSum();
		str += "\nAVERAGE:: " + getAvg();
		str += "\nSMALLEST:: " + getSmallest();
		str += "\nLARGEST:: " + getLargest() + "\n";
		
		return str;
	}
}