import java.util.*;

/**
 * 
 * @author oscar
 * lol xd, i need to sleep 2 am gang lmao. i really want to sleep but i have to do gem matcher, please end me 
 * @param <T>
 */
public class MyLinkedList<T>
{
	private ListNode<T> head;
	private ListNode<T> tail;
	private int size;

	/**
	 * Creates the object ListNode which is the basis of my LinkedList
	 */
	private class ListNode<T>
	{
		T val;
		ListNode<T> next;

		public ListNode(T val)
		{
			this.val = val;
		}

		@Override
		public String toString()
		{
			return "" + this.val;
		}
	}

	/*
	 * Initializes head, tail, and size
	 */
	public MyLinkedList()
	{
		head = null;
		tail = this.head;
		size = 0;
	}
	
	/*
	 * adds all values val into a listLink
	 */
	public MyLinkedList(T... val)
	{
		for (int i = 0; i < val.length; i++)
		{
			add(val[i]);
			size++;
		}
	}
	
	/**
	 * Adds newVal into the end of the LinkedList while amending head and tail
	 * @param newVal - new Value added to linked list
	 */
	public void add(T newVal)
	{
		if (tail != null)
		{
			tail.next = new ListNode<T>(newVal);
			tail = tail.next;
		} else
		{
			head = new ListNode<T>(newVal);
			tail = head;
		}
		size++;
	}

	/**
	 * Check if linkedlist contains target
	 * @param target - value being searched in the linked list
	 * @return - if target is contained in the linked list
	 */
	public boolean contains(T target)
	{
		return indexOf(target) >= 0;
	}


	/**
	 * returns the value of requested index
	 * @param index - given index
	 * @return - value at given index
	 */
	public T get(int index)
	{
		ListNode<T> gotNode = head;
		for (int i = 0; i < index; i++)
		{
			gotNode = gotNode.next;
		}
		return (T)gotNode.val;
	}

	/**
	 * Goes through LinkedList to find if then where target is located in the list
	 * @param target - the wanted value to be found in the LinkedList
	 * @return - the index of where target is(-1 if nonexistant)
	 */
	public int indexOf(T target)
	{
		int index = 0;
		ListNode<T> indexNode = head;
		while (indexNode != null)
		{
			if (indexNode.val.equals(target))
			{
				return index;
			}
			indexNode = indexNode.next;
			index++;
		}
		return -1;
	}

	/**
	 * Goes to given index and replaces it with newVal
	 * @param newVal - The new value that replaces old value
	 * @param index - index where replace will happen
	 */
	public void set(T newVal, int index)
	{
		ListNode<T> setNode = head;
		for (int i = 0; i < index; i++)
		{
			setNode = setNode.next;
		}
		setNode.val = newVal;
	}

	/**
	 * Gets the size of the Linked list
	 * @return
	 */
	public int size()
	{
		return size;
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
	public T remove(int index)
	{
		if (index < 0 || size == 0 || index >= size)
		{
			return null;
		}
		if (index == 0)
		{
			T first = head.val;
			if (tail == head)
			{
				head = null;
				tail = null;
			} else
				head = head.next;
			size--;
			return first;
		}
		ListNode<T> remove = head;
		int count = 0;
		
		while (count != index - 1)
		{
			count++;
			remove = remove.next;
		}
		remove.next = remove.next.next;

		if (index == size - 1)
		{
			tail = remove;
		}
		size--;
		return tail.val;
	}

	/**
	 * Adds newVal in the given linkedList at the given index. Checks to 
	 * see if index exists before adding and increments size
	 * @param newVal
	 * @param index
	 */
	public void add(T newVal, int index)
	{

		if (index < 0 || index > size)
			return;
		
		ListNode<T> newNode = new ListNode<T>(newVal);

		if (index == 0)
		{
			newNode.next = head;
			head = newNode;
			if (tail == null)
			{
				tail = newNode;
				size++;
				return;
			}
		}
		
		int count = 0;
		ListNode<T> add = head;
		
		while (count != index - 1)
		{
			add = add.next;
			count++;
		}

		newNode.next = add.next;
		add.next = newNode;
		
		if (index == size)
			tail = newNode;
		
		size++;

	}

	/**
	 * Properly displays toString
	 */
	public String toString()
	{
		if (head == null)
			return "[]";
		else
		{
			String result = "[" + head.val;
			ListNode<T> current = head.next;
			while (current != null)
			{
				result += ", " + current.val;
				current = current.next;
			}
			result += "]";
			return result;

		}
	}

}