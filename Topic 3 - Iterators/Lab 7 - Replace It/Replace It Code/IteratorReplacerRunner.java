import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class IteratorReplacerRunner
{
	public static void main ( String[] args )
	{
		IteratorReplacer testOne = new IteratorReplacer("1 2 3 1 2 4", "1", "5");
		System.out.println("Test Case: " + testOne.toString() + ", [1], [5] ");
		testOne.replace();
		System.out.println("Output:    " + testOne.toString() + "\n");
		
		IteratorReplacer testTwo = new IteratorReplacer("1 2 3 4 5 6 7 8 9 10 -1 -1 -1", "-1", "42");
		System.out.println("Test Case: " + testTwo.toString() + ", [-1], [42]");
		testTwo.replace();
		System.out.println("Output:    " + testTwo.toString() + "\n");

		IteratorReplacer testThree = new IteratorReplacer("3 1 4 1 5 9 33 72 -3 2 3 6 ", "3", "0");
		System.out.println("Test Case: " + testThree.toString() + ", [3], [0]");
		testThree.replace();
		System.out.println("Output:    " + testThree.toString() + "\n");
	}
}