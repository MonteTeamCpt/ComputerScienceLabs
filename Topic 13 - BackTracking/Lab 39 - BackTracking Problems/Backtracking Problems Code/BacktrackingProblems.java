import java.util.*;

public class BacktrackingProblems
{
	public void climbStairs(int steps)
	{
		System.out.println("\nclimbStairs(" + steps + "):");
		climbStairs(steps, 0, "   ");
	}
	
	public void climbStairs(int steps, int total, String out)
	{
		
		if(total == steps)
		{
			System.out.println(out.substring(0, out.length()-2));
			return;
		}
		else if(total > steps)
		{
			out = null;
			total = 0;
		}
		else
		{
			climbStairs(steps, total + 1, out + "1, ");
			climbStairs(steps, total + 2, out + "2, ");
		}
		
	}
	
	public void campSite(int x, int y)
	{
		System.out.println("\ncampsite(" + x + ", " + y + "):");
		campSite(x,y,0,0,"   ");
	}
	
	public void campSite(int x, int y, int cX, int cY, String str)
	{
		if(x == cX && y == cY)
		{
			System.out.println(str);
		}
		else if(x < cX || y < cY)
		{
			return;
		}
		else
		{
			campSite(x,y,cX+1,cY,str + "E ");
			campSite(x,y,cX,cY+1,str + "N ");
			campSite(x,y,cX+1,cY+1,str + "NE ");	
		}
	}
	
	public void getMax(List<Integer> nums, int limit)
	{
		Queue<Integer> q = new PriorityQueue<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		
		for(Integer num : nums)
		{
			q.offer(num);
		}
		
		while(!q.isEmpty())
		{
			s.add(q.poll());
		}
		
		System.out.print("\ngetMax(" + nums + ", " + limit + ") >>> ");
		getMax(s, limit, 0);	
	}
	
	public void getMax(Stack<Integer> nums, int limit, int total)
	{	
		int tempNum = nums.pop();
		
		if((total + tempNum) <= limit)
		{
			System.out.println("total " + total + " tempNum" + tempNum);
			getMax(nums, limit, total + tempNum);
		}
		else
			System.out.println(total + tempNum);
	
	}
	
	public static void main(String[] args)
	{
		BacktrackingProblems test = new BacktrackingProblems();
		test.climbStairs(4);
		test.climbStairs(6);
		
		test.campSite(2,1);
		test.campSite(3,2);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(30);
		list.add(2);
		list.add(8);
		list.add(22);
		list.add(6);
		list.add(4);
		list.add(20);
		
		test.getMax(list, 19);
		
		
	}
}
