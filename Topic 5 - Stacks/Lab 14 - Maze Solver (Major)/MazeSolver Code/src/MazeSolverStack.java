
public class MazeSolverStack extends MazeSolver
{
	private MyStack workList;

	/**
	 * Instantiates workList
	 */
    public void makeEmpty() 
    {
        workList = new MyStack();
    }

    /**
     * Checks to see if workList is empty or not returning its
     * respective boolean value
     */
    public boolean isEmpty() 
    {
        return workList.isEmpty();
    }

    /**
     * Receives a square and pushes it into workList
     * @param sq - given Square
     */
    public void add(Square s) 
    {
        workList.push(s);
    }

    /**
     * Removes the last value of workList
     */
    public Square remove() 
    {
        return workList.pop();
    }
    
    /**
     * Goes to the nextValue in workList
     */
    public Square getNext() 
    {
        return workList.pop();
    }

    /**
     * Receives a maze and starts solving 
     * @param maze
     */
    public MazeSolverStack(Maze maze)
    {
        super(maze);
        workList = new MyStack();
        add(maze.getStart());
    }
}
