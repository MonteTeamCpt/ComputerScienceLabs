import java.util.*;

public class PriorityQueue101
{
	public static void main(String[] args)
	{
		Queue<Integer> pQueue = new PriorityQueue<Integer>();
		
		pQueue.offer(2);
		pQueue.offer(3);
		pQueue.offer(6);
		pQueue.offer(1);
		pQueue.offer(8);
		pQueue.offer(4);
		pQueue.offer(5);
		pQueue.offer(9);
		
		System.out.println("Head: " + pQueue.peek());
		System.out.println("Head: " + pQueue.element() + "\n");

		//Not "PQ Order"
		System.out.println(pQueue);
		
		//not "PQ Order"
		for(Integer num : pQueue)
			System.out.print(num + " ");
		
		System.out.println();
		
		//"PQ Order"
		while(!pQueue.isEmpty())
			System.out.print(pQueue.poll() + " ");
		
	}
}
