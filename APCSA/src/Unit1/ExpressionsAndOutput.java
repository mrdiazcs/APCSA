package Unit1;

public class ExpressionsAndOutput {

	public static void main(String[] args) {
		System.out.println("Six seven"); //print the text *and then* go to the next line
		System.out.println("Eight nine"); //because of the 'ln' at the end
		
		System.out.print("ten eleven"); //print the text without going onto the next line
		System.out.print(" twelve thirteen"); //because there is no 'ln'
		
		System.out.println();
		
		//Escape Sequences
		System.out.println("\""); //esc seq for quote
		System.out.println("\\"); //esc seq for backslash
		System.out.println("new\nline"); //esc seq for new line
		
		/* Arithmetic Expressions
		 * 
		 * Math Operators: + - * / %
		 */
		
		System.out.println(2 + 2); //4
		System.out.println(10 - 4); //6
		System.out.println(3 * 9); //27
		
		//weird division
		System.out.println(99 / 10); //division with ints results in truncated answer
		System.out.println(5 / 2.0); //only need one double in the expression to get a double result
		
		//remainder examples
		System.out.println(19 % 3); //1 because the remainder of 19 / 3 is 1
		System.out.println(3 % 3); //0 because there is no remainder
		System.out.println(6 % 2); //same as above
		System.out.println(5 % 25); //5 because 5 / 25 = 0 R5
		
		/*
		 * PMMDAS
		 * modulus (the remainder operator) happens at the same 
		 * level of precedence as multiplication and division
		 */
		System.out.println(2 + 3 * 6 % 4); //4
		
		//Dividing by 0 gives an ArithmeticException
//		System.out.println(3 / 0);
	}

}
