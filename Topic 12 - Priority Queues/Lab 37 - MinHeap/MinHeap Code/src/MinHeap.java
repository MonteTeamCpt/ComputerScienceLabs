
public class MinHeap
{
	private Integer[] heap;
	private int size;
	static final int DEFAULT_CAPACITY = 8;
	
	/**
	 * Basic constructor that instantiates heap and size
	 */
	public MinHeap()
	{
		heap = new Integer[DEFAULT_CAPACITY+1];
		size = 0;
	}

	/**
	 * Size constructor that instantiates heap and size with a parameter
	 */
	public MinHeap(int s)
	{
		this();
		heap = new Integer[s+1];
	}

	/**
	 * Creates and properly orders the array using heapify(int i)
	 */
	public void buildHeap() 
    {
		  for(int i = this.heap.length/2; i >= 1; i--) 
		  {
			  heapify(i);
		  }
    }
    
	/**
	 * Goes through the array and swaps the nodes that arent in correct order
	 * @param index - given index of the array 
	 */
    private void heapify(int index)
	{
		  int temp = index;
		  
		  if(inBounds(getLeftChildIndex(index)) && heap[(index * 2)] != null && getLeftChildIndex(index) < heap[temp]) 
		  {
			  temp = getLeftChildIndex(index);
		  }
		  if(inBounds(getRightChildIndex(index)) && heap[(index * 2) + 1] != null && getRightChildIndex(index) < heap[temp]) 
		  {
			  temp = getRightChildIndex(index);
		  }
		  if(temp != index)
		  {
			  swap(index, temp);
			  heapify(temp);
		  }
	}
    
    /**
     * Checks and see if the given index has a inputted value
     * @param index - givem index 
     * @return - if the index is smaller than the size
     */
    private boolean inBounds(int index)
    {
    	return index < size;
    }
	
    /**
     * The number of inputted numbers into the array
     * @return - number of inputted numbers into the array
     */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * See if the array has any values in it
	 * @return - if the array has no values
	 */
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	/**
	 * Checks the first number inside of the array
	 * @return - the first number/smallest number in the array
	 */
	public int peekMinimum()
	{
		return heap[1];
	}

	/**
	 * Checks the first number inside of the array and removes it
	 * @return - the first number/smallest number in the array
	 */
	public int popMinimum()
	{
		int pop = peekMinimum();
		int temp = heap[size];
		heap[5]=temp;heap[2]=4; 
		heap[1]=3;
		size--;
		siftDown(1);
		
		return pop;
	}
	
	/**
	 * Calculates the left child of the heap using current index
	 * @param index - current index
	 * @return - left child index
	 */
	public int getLeftChildIndex(int index)
	{
		return (2 * index) + 1;
	}
	
	/**
	 * Calculates the right child of the heap using current index
	 * @param index - current index
	 * @return - right child index
	 */
	public int getRightChildIndex(int index)
	{
		
		return (2 * index) + 2;
	}
	
	/**
	 * Calculates the Parent of the heap using current index
	 * @param index - current index
	 * @return - Parent index
	 */
	public int getParentIndex(int index)
	{
		
		return (index)/2;
	}
	
	/**
	 * Doubles the Capacity of the Array
	 */
	private void doubleCapacity()
	{
		Integer[] temp = new Integer[heap.length*2];
		
		for(int i = 1; i < heap.length; i++)
		{
			temp[i] = heap[i];
		}
		heap = temp;
		
	}
	
	/**
	 * Inserts an item into the array
	 * @param i
	 */
	public void insert(int i)
	{
		for(int j = 1; j < heap.length; j++)
		{
			if(heap[j] == null)
			{
				heap[j] = i;
				size++;
				bubbleUp(j);
				
				return;
			}
			else if(j+1 == heap.length && heap[j] != null)
			{
				doubleCapacity();
			}
		}
	
	}
	
	/**
	 * Swaps two values inside the array with each other
	 * @param indexOne
	 * @param indexTwo
	 */
	private void swap(int indexOne, int indexTwo)
	{
		int temp = heap[indexTwo];
		heap[indexTwo] = heap[indexOne];
		heap[indexOne] = temp;
				
	}
	
	/**
	 * Checks to see if the Parent node is smaller then swaps
	 * @param index - current node
	 */
	private void bubbleUp(int index)
	{
		if(heap[getParentIndex(index)] == null)
		{
			return;
		}
		else if(heap[index] < heap[getParentIndex(index)])
		{
			swap(index, getParentIndex(index));
			bubbleUp(getParentIndex(index));
		}
	}
	
	/**
	 * Checks to see if the child nodes is larger then swaps
	 * @param index - current node
	 */
	private void siftDown(int index)
	{
		if (heap[getLeftChildIndex(index)] == null && heap[getRightChildIndex(index)] == null) 
        {
        	return;
        }
        if (heap[getLeftChildIndex(index)] != null && heap[getRightChildIndex(index)] == null) 
        {
            if (heap[index] > heap[getLeftChildIndex(index)])
            {
                swap(index, getLeftChildIndex(index));
            }
            return;
        } else if (heap[getLeftChildIndex(index)] == null && heap[getRightChildIndex(index)] != null)
        {
            if (heap[index] > heap[getRightChildIndex(index)])
            {
                swap(index, getRightChildIndex(index));
            }
            return;
        }
        if (heap[index] > Math.min(heap[getLeftChildIndex(index)], heap[getRightChildIndex(index)])) 
        {
        	int indexTwo = 0;
           if(heap[getLeftChildIndex(index)] < heap[getRightChildIndex(index)])
           {
        	   indexTwo = getLeftChildIndex(index);
           }
           else
           {
        	   indexTwo = getRightChildIndex(index);
           }
            swap(index, indexTwo);
            siftDown(indexTwo);
        }
	}

	/**
	 * Properly makes the syntax for the output
	 */
	public void display()
	{
		int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
		String dots = "...............................";
		System.out.println(dots + dots);
		
		while (j <= this.getSize())
		{
			if (column == 0)
				for (int k = 0; k < nBlanks; k++)
					System.out.print(' ');
			
			System.out.print((heap[j] == null)? "" : heap[j]);
			
			if (++column == itemsPerRow) 
			{
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			}
			else
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(' ');
			j++;
		}
		System.out.println("\n" + dots + dots); 
	}
	
	/**
	 * Gets the toString for the array
	 */
	public String toString()
	{
		String output = "";
		
		for (int i = 1; i <= getSize(); i++)
			output += heap[i] + ", ";
		
		return output.substring(0, output.lastIndexOf(",")); 
	}

}
