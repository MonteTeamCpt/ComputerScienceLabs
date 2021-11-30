
public class Enum102
{
	public static void main(String[] args)
	{
		//Calling values()
		Element arr[] = Element.values();
		
		//enum with enhanced loop
		for(Element col : arr)
		{
			//calling ordinal()
			System.out.println(col + " at index " + col.ordinal());
		}
		
		//Calling valueOf()
		//Returns an object of Element with given constant
		//Second line cause an IllegalArgumentException
		System.out.println(Element.valueOf("FIRE"));
		System.out.println(Element.valueOf("LOVE"));
		
		
	}
}
