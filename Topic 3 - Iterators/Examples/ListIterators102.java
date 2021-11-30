import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIterators102
{
	public static List<Integer> convertToIntegerList(String input)
	{
		// An easy way to transfer elements from a String to an ArrayList

		// .split of the String class will use <space> as the delimiter to separate
		// elements
		// "," and "-" are other common delimiters.
		String[] stringArray = input.split(" ");
		List<Integer> numList = new ArrayList<Integer>();
		
		for(int i = 0; i < stringArray.length; i++)
		{
			numList.add(Integer.parseInt(stringArray[i]));
		}
		
		return numList;
		
	}
	
	
	public static void printForwardsThenBackwards(List<Integer> inputList)
	{
		ListIterator<Integer> here = inputList.listIterator();
		
		//even stranger for loops
		//You don't need any of the 3 major parts of a for loop
		for(       ;here.hasNext() ;      )
		{
			System.out.print(here.next() + " ");
		}

		System.out.println("\n");
		
		for(       ;here.hasPrevious() ;      )
		{
			System.out.print(here.previous() + " ");
		}
		
	}

	public static void main(String[] args)
	{
		String input = "15 25 23 18 21 16";
		List<Integer> list = convertToIntegerList(input);
		printForwardsThenBackwards(list);		
	}
}
