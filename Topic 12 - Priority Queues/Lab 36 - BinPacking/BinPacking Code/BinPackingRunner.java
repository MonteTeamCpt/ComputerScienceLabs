import java.io.File;
import java.io.IOException;
import java.util.*;

public class BinPackingRunner
{
	public static void main(String[] args) throws IOException
	{
		
		WorstFit test = new WorstFit();
		Scanner scan = new Scanner(new File("input20.txt"));
		
		while(scan.hasNext())
		{
			test.add(scan.nextInt());
		}
		
		System.out.println(test.toString());
		
		
		WorstFitDecreasing testDec = new WorstFitDecreasing();
		Scanner scanTwo = new Scanner(new File("input20.txt"));
		Queue<Integer> nums = new PriorityQueue<Integer>();
		
		while(scanTwo.hasNext())
		{
			nums.add(scanTwo.nextInt());
		}
		
		testDec.setAll(nums);
		
		System.out.println(testDec.toString());
		
		
	}
}
