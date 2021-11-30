
import java.util.*;

public class MyLinkedList
{
	private ListNode head;
	private ListNode tail;
	private int size;
	
	/**
	 * Creates the object ListNode which is the basis of my LinkedList
	 */
	private class ListNode
	{
		int val; //does a private inner class need private instance variables?
		ListNode next;
		
		public ListNode(int val) 
		{
			this.val = val; 
		}
		@Override
		public String toString() 
		{ 
			return "" + this.val; 
		} //for printing / debug
	}
	
	/*
	 * Initializes head, tail, and size
	 */
	public MyLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/*
	 * Initializes head, tail, and size
	 */
	public MyLinkedList(int val)
	{
		head = new ListNode(val);
		head.next = null;
		tail = null;
		size++;
	}
	
	/**
	 * Adds newVal into the end of the LinkedList while amending head and tail
	 * @param newVal - new Value added to linked list
	 */
	public void add(int newVal)
	{
		ListNode newNode = new ListNode(newVal);
		
		
		if(head == null)
		{
			head = newNode;
			tail = null;
			head.next = null;
		}
		else
		{
			ListNode boomer = head;
			while(boomer.next != null)
			{
				boomer = boomer.next;
			}
			boomer.next = newNode;
		}
		size++;
		
	}
	
	/**
	 * Check if linkedlist contains target
	 * @param target - value being searched in the linked list
	 * @return - if target is contained in the linked list
	 */
	public boolean contains(int target)
	{
		if(indexOf(target) > -1)
			return true;
		return false;
	}
	
	/**
	 * returns the value of requested index
	 * @param index - given index
	 * @return - value at given index
	 */
	public int get(int index)
	{
		if(index > size || 0 > index)
			throw new IndexOutOfBoundsException();
		else
		{
			ListNode nodeChecked = head;
			for(int i = 0; i < index; i++)
			{
				nodeChecked = nodeChecked.next;
			}
			return nodeChecked.val;
		}
	}
	
	/**
	 * Goes through LinkedList to find if then where target is located in the list
	 * @param target - the wanted value to be found in the LinkedList
	 * @return - the index of where target is(-1 if nonexistant)
	 */
	public int indexOf(int target)
	{
		ListNode nodeChecked = head;
		for(int i = 0; i < size; i++)
		{
			if(nodeChecked.val == target)
			{
				return i;
			}
			nodeChecked = nodeChecked.next;
		}
		return -1;
	}
	
	/**
	 * Goes to given index and replaces it with newVal
	 * @param newVal - The new value that replaces old value
	 * @param index - index where replace will happen
	 */
	public void set(int newVal, int index)
	{
		ListNode setNode = head;
		for(int i = 0; i < index; i++)
		{
			setNode = setNode.next;
		}
		setNode.val = newVal;
		
	}
	
	/*
	 * Uses while loop to check the size of the LinkedList
	 * @return - the size of the LinkedList 
	 */
	public int size()
	{
		ListNode findSize = head;
		int count = 1;
		
		if(findSize == null)
			return 0;
		
		while(findSize.next != null)
		{			
			findSize = findSize.next;
			count++;
		}
		return count;
	}
	
	public ListNode head() {return head;} 
	
	/**
	 * Uses recursion to check to the size of the LinkedList
	 * @param node - the returned linkedList
	 * @param count - the amount of time Linkedlist is recursed
	 * @return - the size of the LinkedList
	 */
	@SuppressWarnings("unused")
	public int sizeRecursive(ListNode node, int count)
	{
		if(node.next != null)
		{
			return sizeRecursive(node.next, count+1);
		}
		if(node != null)
			return count +1;
		return count;
	}
	
	/**
	 * Checks if my LinkedList is empty
	 * @return if linkedList is empty
	 */
	public boolean isEmpty()
	{
		return head == null;
	}
	
	/**
	 * removes the value at the given index and amends the linkedList
	 * @param index - the index of value removed
	 * @return the value of the index removed
	 */
	public int remove(int index)
	{
		if(isEmpty())
		{
			throw new NullPointerException();
		}
		
		ListNode remover = head;
		
		if (index == 0)
		{
			head = head.next;
			size--;
			return remover.val;
		}
		else if (index == size - 1) 
		{
			size = 0;
			return remover.val;
		}
		else 
		{	
			for (int i = 1; i < index; i++) 
				remover = remover.next;
	
			ListNode current = remover.next;
			remover.next = current.next;
			size--;
			return current.val;
		}
	}
	
	/**
	 * Adds newVal in the given linkedList at the given index. Checks to 
	 * see if index exists before adding and increments size
	 * @param newVal
	 * @param index
	 */
	public void add(int newVal, int index)
	{
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		
		ListNode current = head;
		
		for (int i = 1; i < index; i++)
		{
			current = current.next;
		}
		
		ListNode temp = current.next;
		current.next = new ListNode(newVal);
		current.next.next = temp;
		
		size++;
	}
	
	/**
	 * Properly displays toString
	 */
	public String toString()
	{
		String str = "[";
		
		ListNode print = head;
		
		while(print != null)
		{
			if(print.next != null)
			{
				str += print.val + ",";
			}
			else 
			{
				str += print.val;
			}
			print = print.next;
		}
		
		return str + "]";
	}
}
