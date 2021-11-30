
public class MinHeapGeneric<T extends Comparable<T>> 
{
    public T[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;

    /**
	 * Basic constructor that instantiates heap and size
	 */
    public MinHeapGeneric()
    {
    	heap = (T[]) new Comparable[DEFAULT_CAPACITY + 1];
    }

    /**
	 * Size constructor that instantiates heap and size with a parameter
	 */
    public MinHeapGeneric(T... vals)
    {
        heap = (T[]) new Comparable[vals.length+1];
        for (int i = 0; i < vals.length; i++)
        {
            heap[i + 1] = vals[i];
        }
        buildHeap();
    }
    
    /**
	 * Creates and properly orders the array using heapify(int i)
	 */
    private void buildHeap() 
    {
		for(int i = heap.length/2; i >= 1; i--) 
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
		if(inBounds(getLeftChildIndex(index)) && heap[(index * 2)] != null && heap[getLeftChildIndex(index)].compareTo(heap[temp]) < 0) 
		{
			temp = getLeftChildIndex(index);
		}
		if(inBounds(getRightChildIndex(index)) && heap[(index * 2) + 1] != null && heap[getRightChildIndex(index)].compareTo(heap[temp]) < 0) 
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
	 * Checks the first number inside of the array and removes it
	 * @return - the first number/smallest number in the array
	 */
    public T popMinimum() 
    {
        T pop = peekMinimum();
        T lastVal = heap[size];
        heap[size] = null;
        size--;
        heap[1] = lastVal;
        siftDown(1);
        return pop;
    }

    /**
	 * Checks the first number inside of the array
	 * @return - the first number/smallest number in the array
	 */
    public T peekMinimum() 
    {
        return heap[1];
    }
    
    /**
	 * Calculates the left child of the heap using current index
	 * @param index - current index
	 * @return - left child index
	 */
    private int getLeftChildIndex(int index) 
    {
        return index * 2;
    }

    /**
	 * Calculates the right child of the heap using current index
	 * @param index - current index
	 * @return - right child index
	 */
    private int getRightChildIndex(int index)
    {
        return index * 2 + 1;
    }

    /**
	 * Calculates the Parent of the heap using current index
	 * @param index - current index
	 * @return - Parent index
	 */
    private int getParentIndex(int index) 
    {
        return index / 2;
    }

    private void doubleCapacity() 
    {
    	  T[] dubArr = (T[]) new Comparable[heap.length * 2];
        for (int i = 1; i < heap.length; i++) 
        {
        	dubArr[i] = heap[i];
        }
        heap = dubArr;
    }
    
    /**
	 * Inserts an item into the array
	 * @param i
	 */
    public void insert(T i) 
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
	 * Checks to see if the Parent node is smaller then swaps
	 * @param index - current node
	 */
    private void bubbleUp(int index) {
        if (heap[getParentIndex(index)] == null) 
        {
        	return;
        }
        if (heap[index].compareTo(heap[getParentIndex(index)]) < 0)
        {
            swap(index, getParentIndex(index));
            bubbleUp(getParentIndex(index));
        }
    }

    /**
	 * Checks to see if the child nodes is larger then swaps
	 * @param index - current node
	 */
    private void siftDown(int index) {
    	 if (heap[getLeftChildIndex(index)] == null && heap[getRightChildIndex(index)] == null) 
    	{
    		return;
    	}
         if (heap[getLeftChildIndex(index)] != null && heap[getRightChildIndex(index)] == null) 
         {
             if (heap[index].compareTo(heap[getLeftChildIndex(index)]) > 0)
             {
                 swap(index, getLeftChildIndex(index));
             }
             return;
         } else if (heap[getLeftChildIndex(index)] == null && heap[getRightChildIndex(index)] != null) 
         {
             if (heap[index].compareTo(heap[getRightChildIndex(index)]) > 0)
             {
                 swap(index, getRightChildIndex(index));
             }
             return;
         }
         if (heap[index].compareTo((heap[getLeftChildIndex(index)].compareTo(heap[getRightChildIndex(index)]) < 0 ? heap[getLeftChildIndex(index)] : heap[getRightChildIndex(index)])) > 0) {
             int swapIndex = heap[getLeftChildIndex(index)].compareTo(heap[getRightChildIndex(index)]) < 0 ? getLeftChildIndex(index) : getRightChildIndex(index);
             swap(index, swapIndex);
             siftDown(swapIndex);
         }
    }
    
    /**
	 * Swaps two values inside the array with each other
	 * @param indexOne
	 * @param indexTwo
	 */
    private void swap(int index1, int index2)
    {
        T temp = heap[index2];
        heap[index2] = heap[index1];
        heap[index1] = temp;
    }

    /**
	 * Properly makes the syntax for the output
	 */
    public void display() {
        int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
        String dots = "...............................";
        System.out.println(dots + dots);
        while (j <= this.getSize()) {
            if (column == 0)
                for (int k = 0; k < nBlanks; k++)
                    System.out.print(' ');
            System.out.print((heap[j] == null) ? "" : heap[j]);
            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(' ');
            j++;
        }
        System.out.println("\n" + dots + dots);
    }
    
    /**
	 * Gets the toString for the array
	 */
    public String toString() {
        String output = "";
        for (int i = 1; i <= getSize(); i++)
            output += heap[i] + ", ";
        return output.substring(0, output.lastIndexOf(","));
    }
}