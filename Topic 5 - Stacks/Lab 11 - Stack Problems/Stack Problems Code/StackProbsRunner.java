import java.util.Stack;

public class StackProbsRunner
{
	public static void main(String[] args)
	{
		Stack<Integer> testStack = new Stack<Integer>();
		StackProbs test = new StackProbs();
		
		testStack.add(1);
		testStack.add(3);
		testStack.add(5);
		testStack.add(0);
		testStack.add(-1);
		
		System.out.println(testStack + " >>> " + test.doubleUp(testStack) +"\n");
		
		testStack.clear();
		testStack.add(2);
		testStack.add(9);
		testStack.add(-4);
		testStack.add(3);
		testStack.add(-1);
		testStack.add(0);
		testStack.add(-6);
		
		System.out.println(testStack + " >>> " + test.posAndNeg(testStack) +"\n");
		
		testStack.clear();
		testStack.add(7);
		testStack.add(23);
		testStack.add(-7);
		testStack.add(0);
		testStack.add(22);
		testStack.add(-8);
		testStack.add(4);
		testStack.add(5);
		
		System.out.println(testStack + ", 3 >>> " + test.shiftByN(testStack, 3) +"\n");
		
		String str = "hello how are you";
		
		System.out.println(str + " >>> " + test.reverseVowels(str));
		
	}
	
	public static Stack<Integer> makeStack(int[] nums)
	{
		Stack<Integer> stack = new Stack<>();
		for(int num : nums)
			stack.push(num);
		return stack;
	}
	
	
}
