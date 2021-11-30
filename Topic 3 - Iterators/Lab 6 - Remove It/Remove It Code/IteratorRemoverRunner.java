

public class IteratorRemoverRunner
{
	public static void main ( String[] args )
	{
		IteratorRemover testOne = new IteratorRemover("a b c a b c a", "a");
		System.out.println("Test Case: " + testOne.toString() + ", a");
		testOne.remove();
		System.out.println("Output:    " + testOne.toString() + "\n");
		
		IteratorRemover testTwo = new IteratorRemover("a b c d e f g h i j x x x x", "x");
		System.out.println("Test Case: " + testTwo.toString() + ", x");
		testTwo.remove();
		System.out.println("Output:    " + testTwo.toString() + "\n");

		IteratorRemover testThree = new IteratorRemover("1 2 3 4 5 6 a b c a b c", "b");
		System.out.println("Test Case: " + testThree.toString() + ", b");
		testThree.remove();
		System.out.println("Output:    " + testThree.toString() + "\n");
	}
}