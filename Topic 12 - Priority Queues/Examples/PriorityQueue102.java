import java.util.PriorityQueue;

public class PriorityQueue102
{
	public static void main(String[] args)
	{
		Student jim = new Student(10011, "Jim", 11, 3.5);
		Student bob = new Student(10042, "Bob", 9, 3.5);
		Student sally = new Student(10069, "Sally", 10, 3.5);
		
		PriorityQueue<Student> pQueue = new PriorityQueue<Student>();
		
		pQueue.offer(jim);
		pQueue.offer(bob);
		pQueue.offer(sally);
		
		int count = 1;
		
		while(!pQueue.isEmpty())
		{
			System.out.println("Dequeued " + count++ + " ---> " + pQueue.poll().toString());
		}
		
	}
}
