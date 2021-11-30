import java.util.*;

public class Disk implements Comparable<Disk>
{
	private int remSpace;
	private int diskNumber;
	Queue<Integer> hardDrive;
	
	public Disk(int num)
	{
		diskNumber = num;
		remSpace = 1000000; //1,000,000 KB = 1GB
		hardDrive = new PriorityQueue<Integer>();
	}
	
	public void add(Integer file)
	{
		hardDrive.add(file);
		remSpace -= file;
	}
	
	public int getDiskNumber()
	{
		return diskNumber;
	}
	
	public int getRemSpace()
	{
		return remSpace;
	}

	public int compareTo(Disk other)
	{
		if(other.getRemSpace() == remSpace)
			return 0;
		else if(other.getRemSpace() > remSpace)
			return 1;
		return -1;
	}
	
	public String toString()
	{
		String str = "";
		
		Queue<Integer> temp = new PriorityQueue<Integer>();
		temp.addAll(hardDrive);
		
		while(!temp.isEmpty())
		{
			str += temp.poll() + " ";
		}
		
		return str;
	}
}
