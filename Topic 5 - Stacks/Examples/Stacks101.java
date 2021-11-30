import java.awt.Color;
import java.util.Stack;

public class Stacks101
{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args)
	{
		//Here's the old way using Stacks (which still works, but you may get a warning message):
		Stack myStack = new Stack();
		
		//push() adds a item to the stack
		System.out.println("-*Pushing*-");
		
		System.out.println("Color.PINK");
		myStack.push(Color.PINK);
		
		System.out.println("abcde");
		myStack.push("abcde");
		
		System.out.println("409");
		myStack.push(409); //Autoboxing
		
		System.out.println("\nPrinting stack with toString: ");
		System.out.println(myStack + "\n");
		
		//pop() remove an item from the stack
		System.out.println("-*Popping*-");
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		//Color r = myStack.pop();
		Color r = (Color) myStack.pop();
		System.out.println(r);

	}

}
