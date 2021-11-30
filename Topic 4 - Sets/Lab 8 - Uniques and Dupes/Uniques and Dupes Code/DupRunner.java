//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Oscar Montealegre

import java.util.*;

public class DupRunner
{
	public static void main( String args[] )
	{
		UniquesDupes test = new UniquesDupes();
		String strOne = "a b c d e f g h a b c d e f g h i j k";
		System.out.println("Original List : " + strOne);
		System.out.println("Uniques : " + test.getUniques(strOne));
		System.out.println("Dupes : " + test.getDupes(strOne));
		
		System.out.println();
		
		String strTwo = "one two three one two three six seven one two";
		System.out.println("Original List : " + strTwo);
		System.out.println("Uniques : " + test.getUniques(strTwo));
		System.out.println("Dupes : " + test.getDupes(strTwo));

		System.out.println();
		
		String strThree = "1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6";
		System.out.println("Original List : " + strThree);
		System.out.println("Uniques : " + test.getUniques(strThree));
		System.out.println("Dupes : " + test.getDupes(strThree));		
	}
}