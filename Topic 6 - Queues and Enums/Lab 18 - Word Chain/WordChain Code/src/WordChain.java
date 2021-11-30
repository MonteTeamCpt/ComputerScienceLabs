import java.io.*;
import java.util.*;

public class WordChain
{
	private String start, end;
	public  HashSet<String> dictionary;
	
	/**
	 * Retrieve the .txt from the package explorer and adds each word from it 
	 * into the HashSet<String> dictionary
	 * @param dict - a .txt file containing all the words in the dictionary
	 */
	public WordChain(File dict)
	{
		dictionary = new HashSet<String>();
		try
		{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(dict);
			
			while(scan.hasNext())
			{
				dictionary.add(scan.next().toLowerCase());
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Dictionary file not found!");
		}
	}
	
	/**
	 * Initialized start and end with their respective parameters
	 * @param start - The first word of the chain
	 * @param end - The wanted last word of the chain
	 */
	public void setStartEnd(String start, String end)
	{
		this.start = start;
		this.end = end;
	}
	
	/**
	 * This method will use the word start and find all the words that are one
	 * letter off and add them into a stack of queues. However before adding it
	 * to the array it is checked to see if it is a newly occurring word. Once 
	 * checked it fills in all the needed checkers into the other data structures
	 * to prevent duplicates and infinite from occurring.
	 * @return
	 */
	public Queue<Stack<String>> getChain()
	{
		if (!dictionary.contains(start) || !dictionary.contains(end) || start.length() != end.length())
			return null;
		
		Map<String, List<String>> startNode = new HashMap<>();
		Queue<String> queue = new LinkedList<>();
		Set<String> stateChecked = new HashSet<>();
		Set<String> checked = new HashSet<>();
		Queue<Stack<String>> chain = new LinkedList<>();

		startNode.put(start, null);
		queue.offer(start);
		checked.add(start);
		boolean foundDestination = false;
		
		while (!queue.isEmpty())
		{
			
			String word = queue.poll();
			
			for (int i = 0; i < word.length(); i++)
			{
				char wordArray[] = word.toCharArray();
				for (char let = 'a'; let <= 'z'; let++)
				{
					
					if (wordArray[i] == let)
						continue;
					
					wordArray[i] = let;
					String newWord = new String(wordArray);

					if (!end.equals(newWord) && (!dictionary.contains(newWord) || checked.contains(newWord)))
						continue;
					
					List<String> startNodes = startNode.get(newWord);
					if (startNodes == null)
					{
						startNodes = new ArrayList<>();
						startNode.put(newWord, startNodes);
					}
					startNodes.add(word);
					stateChecked.add(newWord);
					if (end.equals(newWord))
					{
						foundDestination = true;
						break;
					}
					
				}
			}
			if (!queue.isEmpty())
			{continue;}		
			if (foundDestination)
			{break;}
			
			for (String wordTwo : stateChecked)
			{
				queue.offer(wordTwo);
				checked.add(wordTwo);		
			}
			
			stateChecked.clear();
		}
		
		if (!foundDestination)
			return null;
		else 
			setNode(startNode, start, new Stack<>(), end, chain);
	
		for(Stack<String> item: chain)
			Collections.reverse(item);
		
		return chain;
	}
	
	/**
	 * This method will reset chain in order find the shortest path of chain
	 * from start to end  
	 * 
	 * @param startNode - The list of the current stack
	 * @param startWord - the first word of the stack
	 * @param path - The stack of the current stack
	 * @param currentWord - the top word of the stack
	 * @param chain - The whole chain
	 */
	private void setNode(Map<String, List<String>> startNode, String startWord, Stack<String> path,
			String currentWord, Queue<Stack<String>> chain)
	{
		path.add(currentWord);
		if (startWord.equals(currentWord))
		{
			Stack<String> temp = new Stack<String>();
			temp.addAll(path);
			chain.add(temp);
			path.remove(path.size() - 1);
			return;
		}
		
		for (String n : startNode.get(currentWord))
		{setNode(startNode, startWord, path, n, chain);}
		path.remove(path.size() - 1);
	}
	
	/**
	 * Prints out if ladder is found or not in the console while also giving 
	 * the ladder from the start to end word if chain worked.
	 */
	public String toString()
	{
		if (getChain() != null)
			return "Found a ladder! >>> " + getChain().peek().toString();
		return "No ladder between " + start + " and " + end;
	}
}
