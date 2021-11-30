import java.util.*;

public class MyStack implements StackADT
{
	private Square[] stack;
	private int size;
	
	/**
	 * Initializes size and Stack with 10 Square slots
	 */
	public MyStack()
	{
		stack = new Square[100];
		size = 0;
	}
	
	/**
	 * Initializes size and Stack with initCap Square slots
	 * @param initCap - The amount of values in the stack
	 */
	public MyStack(int initCap)
	{
		stack = new Square[initCap];
		size = 0;
	}
	
	/**
	 * Checks to see if the stack is empty or not
	 * @return - the boolean value of if the stack is empty or not
	 */
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	/**
	 * Checks the last value in the stack and returns it without removing it
	 * @return - the last value of the stack
	 * @throws EmptyStackException - if stack is empty
	 */
	public Square peek() throws EmptyStackException
	{
		if(size<=0)
			throw new EmptyStackException();
		return stack[size];
		
	}
	
	/**
	 * Gets the last value of the stack and then decreasing the size of the
	 * stack by one
	 * @return - the last value of the stack
	 * @throws EmptyStackException - if stack is empty 
	 */
	public Square pop() throws EmptyStackException
	{
		if(size == 0)
			throw new EmptyStackException();
		Square popped = stack[size];
		size--;
		return popped;
	}
	
	/**
	 * Inserts an item into the stack if stack is full it multiplies its 
	 * capacity by two
	 * @param item - Integer being added to stack
	 */
	public void push(Square item)
	{
		if(size == stack.length)
			doubleCapacity();
		size++;
		stack[size] = item;
	}
	
	/**
	 * Doubles the capacity of current stack
	 */
	private void doubleCapacity()
	{
		Square[] dub = new Square[stack.length*2];
		for(int i = 0; i < stack.length; i++)
			dub[i] = stack[i];
		stack = dub;
	}
	
	/**
	 * Properly formats the outputted toString in Console
	 */
	@Override
	public String toString()
	{
		String str = "[";
		for(int i = 1; i <= size; i++)
		{
			if(i < size)
				str += stack[i] + ", ";
			else
				str += stack[i];
		}
		return str + "]";		
	}

	/**
	 * returns the size of the stack
	 */
	public int size()
	{
		return stack.length;
	}

	/**
	 * Goes through each row and clears it with null
	 */
	public void clear()
	{
		for(int i = 0; i < stack.length; i++)
		{
			stack[i] = null;
		}
	}
}
	
