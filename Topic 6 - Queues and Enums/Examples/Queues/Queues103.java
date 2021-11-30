import java.util.LinkedList;
import java.util.Queue;

public class Queues103
{
	public static void main(String[] args)
	{
		Queue<String> names = new LinkedList<String>();		

		names.offer("vincent");
		names.offer("Syed");
		System.out.println(names.offer("Anthony"));
		System.out.println(names.offer("Emma"));
		System.out.println(names.offer("Ravi"));
		
		System.out.println("\n" + names);
		
		//poll() return and removes elements in FIFO order
		//This method differs from remove() only in that it returns null if the queue is empty
		names.poll(); 

		System.out.println("\n" + names);
		
		//element() will return the element at the front of the queue but does not remove it
		//This method differs from peek only in that it throws an exception if the queue is empty
		System.out.println(names.element());
		
		
	}		
}
