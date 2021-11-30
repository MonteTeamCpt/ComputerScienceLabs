import java.util.Stack;

public class Stacks103
{

	public static void main(String[] args)
	{
		Stack<String> myStack = new Stack<String>();
		myStack.push("Arsal");
		myStack.push("Arjun");
		myStack.push("Ricky");
		myStack.push("Randy");
		myStack.push("Kevin");

		System.out.println(myStack + "\n");
		
		//peek() returns the top object of the stack but does not remove from the stack
		System.out.println("-* Peeking *-");
		System.out.println(myStack.peek());
		
		System.out.println("\n" + myStack + "\n");
		
		//isEmpty() returns true if there is nothing on the stack
		System.out.println("-* Popping until (isEmpty() == true) *-");
		while(!myStack.isEmpty())
		{
			System.out.println(myStack.pop() + "\t\tEmpty Stack: " + myStack.isEmpty());
		}
		
		System.out.println("\n" + myStack + "\n");
	}

}
