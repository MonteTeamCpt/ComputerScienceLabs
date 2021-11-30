public class SyntaxCheckRunner
{
	public static void main ( String[] args )
	{
		SyntaxChecker test = new SyntaxChecker("(abc(*def)");
		System.out.println(test + "\n");
		
		SyntaxChecker test2 = new SyntaxChecker("[{}]");
		System.out.println(test2 + "\n");
		
		SyntaxChecker test3 = new SyntaxChecker("[");
		System.out.println(test3 + "\n");
		
		SyntaxChecker test4 = new SyntaxChecker("[{<()>}]");
		System.out.println(test4 + "\n");

		SyntaxChecker test5 = new SyntaxChecker("{<html[value=4]*(12)>{$x}}");
		System.out.println(test5 + "\n");
		
		SyntaxChecker test6 = new SyntaxChecker("[one]<two>{three}(four)");
		System.out.println(test6 + "\n");
		
		SyntaxChecker test7 = new SyntaxChecker("car(cdr(a)(b)))");
		System.out.println(test7 + "\n");
	
		SyntaxChecker test8 = new SyntaxChecker("(abc(*def))");
		System.out.println(test8 + "\n");
		
	}
}