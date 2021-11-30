import java.util.*;

public class EvensFirst
{
	private Queue<Integer> queue;
	
	/**
	 * Instantiates private Queue<Integer> queue
	 */
	public EvensFirst() 
	{
		queue = new LinkedList<Integer>();
	}
	
	/**
	 * Adds the given integer into the queue
	 * @param num - inputted integer
	 */
	public void addQueue(int num)
	{
		queue.add(num);
	}
	
	/**
	 * Retrieves the value of queue
	 * @return - queue
	 */
	public Queue<Integer> getQueue()
	{
		return queue;
	}
	
	/**
	 * Goes through the given queue and then sorts them either odds or even
	 * and then adds them together starting with evens first
	 * @param nums - an queue of Integers
	 * @return nums but sorted with evens first and then odds second
	 */
	public Queue<Integer> putEvensFirst(Queue<Integer> nums)
	{
		Queue<Integer> evens = new LinkedList<Integer>();
		Queue<Integer> odds = new LinkedList<Integer>();
		Queue<Integer> sorted = new LinkedList<Integer>();
		
		while(!nums.isEmpty())
		{
			int num = nums.poll();
			if(num % 2 == 0)
				evens.add(num);
			else 
				odds.add(num);
		}
		
		sorted.addAll(evens);
		sorted.addAll(odds);
		
		return sorted;
	}
}
