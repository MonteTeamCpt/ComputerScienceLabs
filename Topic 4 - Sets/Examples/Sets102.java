import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Sets102
{

	public static void main(String[] args)
	{
		//Parsing words from a String to a Set via an Array and Collection (ArrayList)
		
		//.split of the String class will <space> as a the delimiter to separate elements. 
		//"," and "-" are other common delimiters.
		String[] words = "memes are dreams".split(" ");
		
		//.asList() acts as a bridge between array-based and collection-based APIs
		Set<String> set = new TreeSet<String>(Arrays.asList(words)); //Can use Collection.toArray() to go the other way
		System.out.println(set + "\n");
	}

}
