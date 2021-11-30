import java.io.File;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class PartList
{
	private TreeMap<Part, Integer> partsMap;

	//Instatiates the treemap
	public PartList()
	{
		partsMap = new TreeMap<Part, Integer>();
	}

	/**
	 * Takes in the file and inserts them into the TreeMap properly
	 * @param fileName - name of file
	 */
	public PartList(String fileName)
	{
		this();
		try
		{
			Scanner scan = new Scanner(new File(fileName));
			
			while(scan.hasNext())
			{
				String str = scan.nextLine();
				Part currentPart = new Part(str);
				
				if(partsMap.containsKey(currentPart))
				{
					partsMap.put(currentPart, partsMap.get(currentPart)+1);
				}
				else
				{
					partsMap.put(currentPart, 1);
				}
			}
		}
		catch( IOException e )  //Most specific exceptions must be listed 1st
		{
			out.println(e);
		}
		catch( RuntimeException e )
		{
			out.println(e);
		}
		catch( Exception e )
		{
			out.println(e);
		}
		finally
		{
			//no code needed here
		}
	}

	/**
	 * Proper notation of the code onto the console
	 */
	public String toString()
	{
		return " " + partsMap.toString().replaceAll("\\,","\n").substring(1, partsMap.toString().replaceAll("\\,","\n").length()-1);
	}
}