
public class BackTracking101
{
	public void printBinary(int n)
	{
		if(n == 0)
			System.out.println();
		else
			printBinaryHelper(n, "");
	}

	private void printBinaryHelper(int n, String result)
	{
		if(result.length() == n)// String is the required length
			System.out.println(result);
		else
		{
			printBinaryHelper(n, result + 0);
			printBinaryHelper(n, result + 1);
		}
			
	}
	
	public static void main(String[] args)
	{
		BackTracking101 test = new BackTracking101();
		test.printBinary(13);
	}  
}
