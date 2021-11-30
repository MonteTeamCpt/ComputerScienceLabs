import java.util.Stack;

public class StackProbs
{
	/**
	 * Retrives a Stack<Integer> and adds each element twice into a new Stack
	 * @param nums - Given Stack<Integer> of elements
	 * @return - nums but each element doubled
	 */
	public Stack<Integer> doubleUp(Stack<Integer> nums)
	{
		Stack<Integer> dub = new Stack<>();
		
		for(int i = 0; i < nums.size(); i++)
		{
			dub.add(nums.get(i));
			dub.add(nums.get(i));
		}
		
		return dub;
	}
	
	/**
	 * Sorts the stack from greatest to least, seperating negative
	 * and positive values
	 * @param nums - Given Stack<Integer> of elements
	 * @return - nums but sorted from greatest to least
	 */
	public Stack<Integer> posAndNeg(Stack<Integer> nums)
	{
		Stack<Integer> posNeg = new Stack<>();
		int num = 0;
		
		while(!nums.empty())
		{
			num = nums.peek();
			nums.pop();
			while(!posNeg.empty() && posNeg.peek() > num)
			{
				nums.push(posNeg.peek());
				posNeg.pop();
			}
			posNeg.push(num);		
		}
		
		return posNeg;
	}
	
	/**
	 * Shifts the Stack to the left by n, wrapping around itself
	 * @param num - Given Stack<Integer> of elements
	 * @param n - the number of shifts on num
	 * @return num but shifted and wrapped by n units to the left
	 */
	public Stack<Integer> shiftByN(Stack<Integer> num, int n)	
	{
		Stack<Integer> top = new Stack<Integer>();
		Stack<Integer> bot = new Stack<Integer>();
		
		for(int i = 0 ; i < n; i++)
		{
			bot.push(num.get(0));
			num.remove(0);
		}
		top.addAll(num);
		top.addAll(bot);
		
		return top;
	}
	
	/**
	 * Goes through str recording all of the vowel characters in str into 
	 * Stack<Characters> vowels. After all vowels are recorded it goes 
	 * through str again and pop()s the recorded vowels into the old 
	 * place of the values which reverses them. 
	 * @param str - inputted string of words
	 * @return - str but vowels throughout the whole string reversed
	 */
	public String reverseVowels(String str)
	{
		Stack<Character> vowels = new Stack<Character>();
		String rev = "";
		
		for(int i = 0; i < str.length();i++)
		{
			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' ||  str.charAt(i) == 'o' ||  str.charAt(i) == 'u')
			{
				vowels.add(str.charAt(i));
			}
		}
		
		for(int i = 0; i < str.length();i++)
		{
			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' ||  str.charAt(i) == 'o' ||  str.charAt(i) == 'u')
			{
				rev += vowels.pop();
			}
			else 
				rev += str.charAt(i);
		}
		
		return rev;
	}
}
