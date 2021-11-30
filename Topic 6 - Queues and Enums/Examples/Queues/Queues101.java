import java.util.Queue;
import java.util.LinkedList;

public class Queues101
{
	public static void main(String[] args)
	{
		
		//Queue is an interface
		Queue<Integer> queue;
		
		//LinkedList implements the Queue interface (A Queue reference to a linkedList)
		queue = new LinkedList<Integer>();
		
		//Elements are added at the tail(back) of the Queue 
		//To add an element is to "enqueue" it
		queue.add(42);
		queue.add(23);
		queue.add(90);
		queue.add(13);
		queue.add(21);
		
		System.out.println(queue);
		
		//removing elements - First in First out (FIFO) order
		//remove() returns the element that was removed
		//Elements are removed from the head(front)
		System.out.println("Removing: " + queue.remove());
		
		System.out.println(queue);
		
		//To remove an element is to "dequeue" it
		queue.remove();
		queue.remove();
		
		System.out.println(queue);
		
		queue.add(1);
		
		System.out.println(queue);

		
	}
}
