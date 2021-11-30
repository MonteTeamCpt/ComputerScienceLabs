
public class EvensFirstRunner
{
	public static void main(String[] args)
	{
		EvensFirst test = new EvensFirst();
		
		test.addQueue(3);
		test.addQueue(5);
		test.addQueue(4);
		test.addQueue(17);
		test.addQueue(6);
		test.addQueue(83);
		test.addQueue(1);
		test.addQueue(84);
		test.addQueue(16);
		test.addQueue(37);
		
		System.out.print(test.getQueue() + " >>> head");
		System.out.print(test.putEvensFirst(test.getQueue()) + "tail");
		
	}
}
