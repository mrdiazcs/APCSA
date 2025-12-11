package Unit2;
import java.util.Scanner;

public class BooleanExpressions {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		boolean fact = 2 + 3 != 5;
		
		System.out.println(fact);
		
		/*
		 * Comparison Operators:
		 * 
		 * == Equal to
		 * > Greater than
		 * < Less than
		 * >= Greater than or equal to
		 * <= Less than or equal to
		 * != Not equal to
		 * 
		 * Try changing the numbers and comparison operators to 
		 * the right of the boolean variable 'fact' being declared
		 * 
		 */
		
		System.out.println("Enter two String values: ");
		String a = input.nextLine();
		String b = input.nextLine();
		
		System.out.println(a);
		System.out.println(b);
		
		//to compare strings, we must use .equals
		System.out.println(a.equals(b));
		System.out.println(!a.equals(b)); //a is not equal to b
		
	}

}
