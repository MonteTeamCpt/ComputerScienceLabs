import java.util.Stack;

public class SyntaxChecker
{
	private String exp;
	private Stack<Character> symbols;
	private Stack<Character> ref;

	/**
	 * Initializes exp, symbols, and ref
	 */
	public SyntaxChecker()
	{
		exp = "";
		symbols = new Stack<Character>();
		ref = new Stack<Character>();
	}

	/**
	 * Using this() to initalize all private variables and sets exp as String s
	 * Calls setExpression with the parameter of s to find the brackets of s
	 * @param s - inputted String
	 */
	public SyntaxChecker(String s)
	{
		this();
		exp = s;
		setExpression(exp);
	}
	
	/**
	 * Goes through s and puts all the  brackets into symbol and then
	 * reverses the order of symbol.
	 * @param s - inputted String
	 */
	public void setExpression(String s)
	{
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('||
			   s.charAt(i) == '<' || s.charAt(i) == ']' || s.charAt(i) == '}'|| 
			   s.charAt(i) == '>' || s.charAt(i) == ')')
			{
				symbols.push(s.charAt(i));
			}
		}
		
		Stack<Character> rev = new Stack<Character>();
		int size = symbols.size();
		for(int i = 0; i < size; i++)
			rev.push(symbols.pop());
		symbols.clear();
		symbols.addAll(rev);
		 
	}

	/**
	 * Goes through the Stack<Character> symbol and checks if the order of the
	 * syntax brackets are ordered properly and if there is any error in the
	 * syntax of the brackets the method will imediately return false; otherwise
	 * the method will return true if fully passed or both empty.
	 * @return - Boolean value if the expression had correct syntax or not
	 */
	public boolean checkExpression()
	{
		while(!symbols.isEmpty() || ref.isEmpty())
		{
			char sym = symbols.pop();
			
			if(sym == '{' || sym == '[' || sym == '(' || sym == '<' )
				ref.push(sym);
			else if(sym == '}' || sym == ']' || sym == ')' || sym == '>')
			{
				if(ref.isEmpty() && symbols.isEmpty())
					return false;
				if(!ref.isEmpty())
				{
					char check = ref.pop();
					if(check == '(' && sym != ')' || check == '{' && sym != '}' ||
					   check == '[' && sym != ']' || check == '<' && sym != '>')
						return false;						
				}
			}
			if(symbols.isEmpty() && ref.isEmpty())
				return true;
			else if(symbols.isEmpty() && !ref.isEmpty())
				return false;
			
		}
		
		return true;
	}

	/**
	 * Properly formatted toString console output of SyntaxChecker
	 * @return - The output of exp to see if its correct or not
	 */
	public String toString()
	{
		if(checkExpression() == false)
			return exp + " is incorrect";
		return exp + " is correct";
	}
}