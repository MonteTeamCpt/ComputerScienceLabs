

public class Runner
{
	public static void main(String args[])
	{
		WelcomeBack test = new WelcomeBack();
		
		String strOne = "Oscar";
		String strTwo = "GT";
		String strThree = "ABCD";
		String strFour = "ABCDEF";
		
		int numOne = 5;
		int numTwo = 12;
		int numThree = 25;
		int numFour = 100;		
		int numFive = 1;
		int numSix = 125;
		int numSeven = 358;
		int numEight = 999999999;		
		int numNine = 546;
		int numTen = 5981;
		int numEleven = 95743;
		
		int[] arrayOne = {1,2,3,4,5}; 
		int[] arrayTwo = {5,3,4,3,1};
		int[] arrayThree = {1,5,3,4};
		int[] arrayFour = {6,7,9,13};		
		int[] arrayFive = {1,13,1,10,5};
		int[] arraySix = {5,4,3,2,1};
		
		
		System.out.println(test.getMiddle(strOne));
		System.out.println(test.getMiddle(strTwo));
		System.out.println(test.getMiddle(strThree));
		System.out.println(test.getMiddle(strFour));
		
		System.out.println();
		
		System.out.println(test.printSumNumbers(test.sumNumbers(numOne).length, test.sumNumbers(numOne)));
		System.out.println(test.printSumNumbers(test.sumNumbers(numTwo).length, test.sumNumbers(numTwo)));
		System.out.println(test.printSumNumbers(test.sumNumbers(numThree).length, test.sumNumbers(numThree)));
		System.out.println(test.printSumNumbers(test.sumNumbers(numFour).length, test.sumNumbers(numFour)));

		System.out.println();
		
		System.out.println("sumDigits(" + numFive + ") >>> " + test.sumDigits(numFive));
		System.out.println("sumDigits(" + numSix + ") >>> " + test.sumDigits(numSix));
		System.out.println("sumDigits(" + numSeven + ") >>> " + test.sumDigits(numSeven));
		System.out.println("sumDigits(" + numEight + ") >>> " + test.sumDigits(numEight));
		
		System.out.println();
		
		System.out.println(test.keepSummingDigits(numFive));
		System.out.println(test.keepSummingDigits(numSix));
		System.out.println(test.keepSummingDigits(numSeven));
		System.out.println(test.keepSummingDigits(numEight));	
		
		System.out.println();
		
		System.out.println("getIntersection(new int[] = {1,2,3,4,5}, new int[] = {5,3,4,3,1}) >>> " + test.getIntersection(arrayOne, arrayTwo));
		System.out.println("getIntersection(new int[] = {1,2,3,4,5}, new int[] = {1,5,3,4}) >>> " + test.getIntersection(arrayOne, arrayThree));
		System.out.println("getIntersection(new int[] = {1,2,3,4,5}, new int[] = {6,7,9,13}) >>> " + test.getIntersection(arrayOne, arrayFour));
		System.out.println("getIntersection(new int[] = {5,3,4,3,1}, new int[] = {1,5,3,4}) >>> " + test.getIntersection(arrayTwo, arrayThree));
		
		System.out.println();
		
		System.out.println("sumDigitsRecur(" + numFive + ") >>> " + test.sumDigitsRecur(numFive));
		System.out.println("sumDigitsRecur(" + numSix + ") >>> " + test.sumDigitsRecur(numSix));
		System.out.println("sumDigitsRecur(" + numSeven + ") >>> " + test.sumDigitsRecur(numSeven));
		System.out.println("sumDigitsRecur(" + numEight + ") >>> " + test.sumDigitsRecur(numEight));
		
		System.out.println();
		
		System.out.println("sumWithoutCarry(" + numSeven + ", " + numSix + ") >>> " + test.sumWithoutCarry(numSeven, numSix));
		System.out.println("sumWithoutCarry(" + numTen + ", " + numSix + ") >>> " + test.sumWithoutCarry(numTen, numSix));
		System.out.println("sumWithoutCarry(" + numEleven + ", " + numSeven + ") >>> " + test.sumWithoutCarry(numEleven, numSeven));
		System.out.println("sumWithoutCarry(" + numSeven + ", " + numNine + ") >>> " + test.sumWithoutCarry(numSeven, numNine));
		
		System.out.println();
		
		System.out.println("buySell1([1,2,3,4,5]) >>> " + test.buySell1(arrayOne));
		System.out.println("buySell1([1,5,3,4]) >>> " + test.buySell1(arrayThree));
		System.out.println("buySell1([1,13,1,10,5]) >>> " + test.buySell1(arrayFive));
		System.out.println("buySell1([5,4,3,2,1]) >>> " + test.buySell1(arraySix));
	}
}