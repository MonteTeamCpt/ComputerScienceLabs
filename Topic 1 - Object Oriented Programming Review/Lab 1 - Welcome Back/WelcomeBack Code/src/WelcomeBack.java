import java.lang.Math;

public class WelcomeBack
{
	String getMiddle(String str)
	{
		System.out.print("getMiddle(" + str + ") >>> ");
		int stringLength;
		stringLength = str.length();
		if(stringLength % 2 == 1)
			return str.substring(stringLength/2,stringLength/2+1) ;
		else if (stringLength == 2)
			return str;
		else 
			return str.substring((stringLength/2)-1,(stringLength/2)+1); 
	}
	//Look I commented
	int[] sumNumbers(int n)
	{
		int sum = 0;
		int numbers[] = new int[n+1];
		for(int i = 0; i < n+1; i++)
		{
			sum += i;
			numbers[i] = sum;
		}
		return numbers;
	}
	
	String printSumNumbers(int n, int[] numArray)
	{
		String numbers = "";
		numbers += "sumNumbers(" + (n-1) + ") >>> ";
		
		for(int i = 0; i < n; i++)
		{
			if(i == 0)
				numbers += ("[" + sumNumbers(n)[i] + ", ");
			else if(i < sumNumbers(n).length-2)
				numbers += (sumNumbers(n)[i] + ", ");
			else 
				numbers += (sumNumbers(n)[i] + "]");	
		}
		
		return numbers;
	}
	
	int sumDigits(int num)
	{
		int sum = 0;
		int digit = 0;
		for(int i = 1; i < String.valueOf(num).length()+1; i++)
		{
			digit = num % (int)Math.pow(10, i);
			if(digit >= 10)
				do
				{
					digit = digit/10;
				}while(digit >= 10);
			
			sum += digit;
			num -= num % (int)Math.pow(10, i);
			digit = 0;	
		}
		return sum;
	}
	
	int keepSummingDigits(int num)
	{
		int sum = 0;
		boolean flag = false;
		System.out.print("keepSummingDigits(" + num + ") >>> ");
		do
		{
			int digit = 0;
			for(int i = 1; i < String.valueOf(num).length()+1; i++)
			{
				
				digit = num % (int)Math.pow(10, i);
				if(digit >= 10)
					do
					{
						digit = digit/10;
					}while(digit >= 10);
				sum += digit;
				num -= num % (int)Math.pow(10, i);
				digit = 0;	
			}
			if(sum >= 10)
			{
				num = sum; 
				sum = 0;
			}
			else 
				flag = true;
			
		}while(flag == false);
		
		return sum;
	}
	
	String getIntersection(int[] a, int[] b)
	{
		String intersections = "";
		boolean flag = false;
		boolean flag2 = false;
		
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < b.length; j++)
			{
				if(a[i] == b[j])
				{
					for(int s = 0; s < intersections.length(); s++)
					{
						if(a[i] == Integer.parseInt(intersections.substring(s, s+1)))
							flag2 = true;
					}
					if(flag2 == false)
					{
						intersections += a[i];	
						flag = true;
					}
					flag2 = false;
				}				
			}
		}
		
		if(flag == false)
			intersections += "No intersections";
		return intersections;
	}
	
	int sumDigitsRecur(int num)
	{
		int sum = sumDigits(num);
		
		if(sum >= 10)
			sum = sumDigitsRecur(sum);
		
		return sum;
	}
	
	int sumWithoutCarry(int a, int b)
	{
		int length = 0;
		int diff = 0;
		boolean aLarger = false;
		int sum = 0;
		
		if(("" + a).length() >= ("" + b).length())
		{
			length = ("" + a).length();
			diff = ("" + a).length() - ("" + b).length();
			aLarger = true;
		}
		else
		{
			length = ("" + b).length();
			diff = ("" + b).length() - ("" + a).length();
		}
		
		for(int i = length-1; i >= 0; i--)
		{
			if(diff > 0)
			{
				if(aLarger == true)
				{
					sum += a-(a % (int)Math.pow(10, i));
					diff--;
					a -= a-(a % (int)Math.pow(10, i));
				}
				else
				{
					sum += b-(b % (int)Math.pow(10, i));
					b -= b-(b % (int)Math.pow(10, i));
					diff--;
				}
			}
			else
			{
				if(((a-(a % (int)Math.pow(10, i))) + (b-(b % (int)Math.pow(10, i)))) < (int)Math.pow(10, i+1))
					sum += ((a-(a % (int)Math.pow(10, i))) + (b-(b % (int)Math.pow(10, i))));
				else	
					sum += (((a-(a % (int)Math.pow(10, i))) + (b-(b % (int)Math.pow(10, i))))-(int)Math.pow(10, i+1));
				a -= a-(a % (int)Math.pow(10, i));
				b -= b-(b % (int)Math.pow(10, i));
			}
		}
		
		return sum;
	}
	int buySell1(int[] stock)
	{
		int lowest = stock[0];
		int highest = stock[0];
		int diff = 0;
		
		for(int i = 0; i < stock.length; i++)
		{
			if(stock[i] < lowest)
			{
				lowest = stock[i];
				highest = stock[i];
			}
			if(stock[i] > highest)
			{
				highest = stock[i];
				if(highest-lowest > diff)
					diff = highest-lowest;
			}
		}
				
		return diff;
	}
}

