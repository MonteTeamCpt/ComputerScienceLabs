import java.util.Queue;
import java.util.LinkedList; //crtl + shift + "L" : auto-imports

public class Queues102
{
	public static void main(String[] args)
	{
		Queue<String> names = new LinkedList<String>();
		
		names.add("vincent");
		names.add("Syed");
		System.out.println(names.add("Anthony"));
		System.out.println(names.add("Emma"));
		System.out.println(names.add("Ravi"));
		
		System.out.println("\nNumber of Elements: " + names.size());
		
		System.out.println("\nPrinting Queue with loop: ");
		
		//Cant use a basic for loop becuase is no get() method in the Queue interface
		//for(int i = 0; i < names.size(); i++)
			//System.out.println(i + ". " + names);
		
		for(String name : names)
			System.out.println(name);
		System.out.println();
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//peek() - Will return the element at the front of the Queue but does not remove it
		System.out.print("The element at the head of the Queue (index 0) is: ");
		System.out.println(names.peek());
		System.out.println("\n");
		
		//isEmpty() return true if there is there is nothing in the Queue
		System.out.println("-* Dequeuing until (isEmpty() == true) *-\n");
		while(!names.isEmpty())
		{
			System.out.println("Removing " + names.remove() + " from the head of the Queue." + "\nEmpty Queue : " + names.isEmpty() + "\n");
		}
		
		//Empty queue
		System.out.println("\n" + names + "\n");
		
		//peek() returns null if this Queue is empty
		System.out.print("The elements at the front of the Queue is : ");
		System.out.println(names.peek());
		System.out.println("\n");
		
		//remove() throws an exception if the queue is empty
		//System.out.println(names.remove());
		
	}
}
