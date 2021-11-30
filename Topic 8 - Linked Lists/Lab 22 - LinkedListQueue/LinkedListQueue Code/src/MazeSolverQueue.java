import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MazeSolverQueue extends MazeSolver
{
	public MyQueue<Square> workList;
	public ArrayList<Square> path;
	
	/**
	 * Instantiates path and workList(with maze)
	 * @param maze - given maze to solve
	 * @throws FileNotFoundException - if file is not found
	 */
	public MazeSolverQueue(Maze maze)throws FileNotFoundException
	{
		super(maze);
		path = new ArrayList<Square>();
		workList = new MyQueue<Square>(maze.getStart());
	}
	/**
	 * creates a new queue to clear it
	 */
	public void makeEmpty()
	{
		workList = new MyQueue<Square>();
	}

	/**
	 * checks if the queue is empty
	 * @return if empty
	 */
	public boolean isEmpty()
	{
		return workList.isEmpty();
	}

	/**
	 * offers s to the queue
	 */
	public void add(Square s)
	{
		workList.offer(s);
	}

	/**
	 * polls from queue
	 * @return polled queue
	 */
	public Square next()
	{
		return workList.poll();
	}

	/**
	 * polls from queue
	 * @return polled queue
	 */
	public Square remove()
	{
		return workList.poll();
	}
	
	/**
	 * polls from queue
	 * @return polled queue
	 */
	public Square getNext()
	{
		return workList.poll();
	}
	

	

}