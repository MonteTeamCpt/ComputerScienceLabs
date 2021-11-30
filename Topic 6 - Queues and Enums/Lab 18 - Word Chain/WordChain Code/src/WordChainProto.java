import java.io.*;
import java.util.*;

public class WordChainProto
{
	private String start, end;
	private static HashSet<String> dictionary;
	
	public WordChainProto(File dict)
	{
		dictionary = new HashSet<String>();
		try
		{
			Scanner scan = new Scanner(dict);
			
			while(scan.hasNext())
			{
				dictionary.add(scan.next().toLowerCase());
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Dictionary file not found");
		}
	}
	public void setStartEnd(String start, String end)
	{
		this.start = start;
		this.end = end;
	}
	
	public void resetDictionary(File dict)
	{
		dictionary.clear();
		try
		{
			Scanner scan = new Scanner(dict);
			
			while(scan.hasNext())
			{
				dictionary.add(scan.next().toLowerCase());
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Dictionary file not found");
		}
	}
	
	public Stack<String> oneOffWords(String word)
	{
		Stack<String> words = new Stack<String>();
		
		for(int i = 0; i < word.length(); i++)
		{
			for(int j = 0; j < 26; j++)
			{
				String comp = word.substring(0,i) + (char)(97+j) + word.substring(i+1,word.length());
				if(dictionary.contains(comp))
				{
					dictionary.remove(comp);
					words.add(comp);
				}
			}
		}
		
		return words;
	}
	
	public void clearOthers()
	{
		Iterator clear = dictionary.iterator();
		HashSet<String> cleared = new HashSet<String>();
		while(clear.hasNext())
		{
			String str = "";
			str = (String) clear.next();
			if(str.length() == start.length())
				cleared.add(str);
		}
		dictionary.clear();
		dictionary.addAll(cleared);
	}
	
	public Stack<String> findChain()
	{
		clearOthers();
		if(!dictionary.contains(end))
				return null;
		
		Queue<Stack<String>> chain = new LinkedList<>();
		chain.offer(oneOffWords(start));
		Boolean found = false;
		
		while(found == false && !dictionary.isEmpty())
		{
			if(chain.isEmpty())
			{
				Stack<String> sim = oneOffWords(start);
				
				while(!sim.empty())
				{
					Stack<String> enter = new Stack<String>();
					enter.add(start);
					enter.add(sim.pop());
					if(enter.peek() == end)
						return enter;
					chain.add(enter);
				}
			}
			else
			{
				Stack<String> stack = chain.poll();
				Stack<String> sim = oneOffWords(stack.peek());
				
				while(!sim.empty())
				{
					Stack<String> enter = new Stack<String>();
					enter.addAll(stack);
					enter.add(sim.pop());
					if(enter.peek() == end)
						return enter;
					chain.add(enter);
				}
			}
			
			System.out.println(chain);
				
		}
		
		
		return chain.poll();
	}
	
	public String toString()
	{
		Stack yep = findChain();
		if(yep == null)
			return "No ladder between " + start + " and " + end;
		return "ESkfn";
	}
	public static void main(String[] args)
	{
		WordChain test = new WordChain(new File("dictionary.txt"));
		test.setStartEnd("car" , "bat");
		System.out.println(test);
		

		/*
		try
		{
			Scanner scan = new Scanner(new File ("input.txt"));
			
			while(scan.hasNext())
			{
				WordChain test = new WordChain(scan.next(), scan.next());
				System.out.println(test.findChain());	
				test.resetDictionary(new File("dictionary.txt"));			
			}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}*/
	}
	
}
