import java.io.*;
import java.util.*;

public class WorstFit
{
	private int diskCounter;
	public int totalSize;
	private boolean makeNewDrive = false;;
	private Queue<Disk> drives;
	
	/**
	 * Initializes all the private variables inside of the class
	 */
	public WorstFit()
	{
		diskCounter = 0;
		totalSize = 0;
		drives = new PriorityQueue<Disk>();
	}

	/**
	 * Adds one element at a time into the Drives depending on their remaining
	 * space of all of the current drives
	 * @param num - the space required for the new file being added to the drive
	 */
	public void add(Integer num)
	{
		totalSize += num;
		
		if(drives.isEmpty())
		{
			Disk d = makeDisk();
			d.add(num);
			drives.add(d);
			return;
		}
		
		Queue<Disk> temp = new PriorityQueue<Disk>();
		int diskNum = largestMax(num);
		
		if(makeNewDrive)
		{
			Disk d = makeDisk();
			d.add(num);
			drives.add(d);
			makeNewDrive = false;
			return;
		}
		
		while(!drives.isEmpty())
		{
			Disk tempDisk = drives.poll();
			
			if(tempDisk.getDiskNumber() == diskNum)
			{
				tempDisk.add(num);
			}
			
			temp.add(tempDisk);
		}
		drives.addAll(temp);
	}
	
	/**
	 * Retrives the largest space within the Drive that fits a given Integer
	 * @param num - A file size to check to see where it can fit
	 * @return - the diskNumber with the largest available space where num can fit
	 */
	public int largestMax(int num)
	{
		sortQueue();
		if(drives.peek().getRemSpace() < num)
		{
			makeNewDrive = true;
			return -1;
		}
		return drives.peek().getDiskNumber();
	}
	
	/**
	 * Creates and counts the Number of Disks
	 * @return - The new Disk
	 */
	public Disk makeDisk()
	{
		Disk temp = new Disk(diskCounter++);
		
		return temp;
	}
	
	/**
	 * Sorts the Queue from least to smallest
	 */
	public void sortQueue()
	{
		Queue<Disk> temp = new PriorityQueue<Disk>();
		
		while(!drives.isEmpty())
		{
			temp.add(drives.poll());
		}
		
		drives.clear();
		drives.addAll(temp);
	}
	
	/**
	 * Returns all the important information about the drives into the console 
	 * in an organized and sorted order 
	 */
	public String toString()
	{
		
		String str = "";
		
		str += "Total size  = " + (((double)totalSize)/1000000) + " GB\n";
		str += "Disks req'd = " + diskCounter + "\n\n";
		
		if(drives.size() < 100)
		{
			Queue<Disk> temp = new PriorityQueue<Disk>();
			temp.addAll(drives);
			
			str += "     #  Avail" + "\n";
			
			while(!temp.isEmpty())
			{
				Disk tempDisk = temp.poll();
				str += "     " + tempDisk.getDiskNumber() + " ";
				if((tempDisk.getRemSpace()+"").length() == 4)
					str += "  " + tempDisk.getRemSpace();
				else if((tempDisk.getRemSpace()+"").length() == 5)
					str += " " + tempDisk.getRemSpace();
				else
					str += tempDisk.getRemSpace();
				str += ": " + tempDisk.toString() + "\n"; 
			}	
		}
		
		return str;
	}	
}
