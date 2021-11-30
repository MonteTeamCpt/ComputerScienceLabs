import java.util.NoSuchElementException;

public class MyQueue<T> implements QueueADT<T>
{
	MyLinkedList<T> queue;

	/**
	 * Instantiates queue
	 */
	public MyQueue()
	{
		queue = new MyLinkedList<T>();
	}

	/**
	 * Instantiates queue with val
	 * @param val - inputed value
	 */
	public MyQueue(T... val)
	{
		queue = new MyLinkedList<T>(val);
	}

	/**
	 * Add an item to the queue
	 * @param item the data item to add
	 */
	public void offer(T item)
	{
		queue.add((T) item);
	}

	/**
	 * Removes the first item from the queue
	 * @return first item in the queue
	 */
	public T poll()
	{
		try
		{
			if (queue.size() != 0)
			{
				return queue.remove(0);
			} else
			{
				throw new NoSuchElementException();
			}
		} catch (NoSuchElementException e)
		{
			System.out.println("The queue is empty!");
		}
		return null;
	}

	/**
	 * Returns the first item in the queue without removing it
	 * @return the first item in the queue
	 */
	public T peek()
	{
		return queue.get(0);
	}

	/**
	 * Gets the size of the queue
	 * @return the size of the queue
	 */
	public int size()
	{
		return queue.size();
	}

	/**
	 * Determine if the queue is empty
	 * @return if empty
	 */
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}

	/**
	 * Clears queue
	 */
	public void clear()
	{
		while (!queue.isEmpty())
		{
			queue.remove(0);
		}
	}

}