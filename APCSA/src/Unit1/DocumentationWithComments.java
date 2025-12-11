package Unit1;

public class DocumentationWithComments {

	/**
	 * This is a javadoc comment.
	 * 
	 * These are very special comments that can be exported
	 * into documentation that looks like the String class
	 * documentation that we looked at last week.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//this is a single line comment
		
		/*
		 * this is a 
		 * multi-line 
		 * comment
		 */
		
		/*
		 * A precondition is something that is assumed to be true
		 * about a method in order for it to function properly.
		 * 
		 * A postcondition is the state of your program after
		 * the method is run.
		 */
		
		printDiv(10, 5);
		
	}
	
	//precondition: int denom is not equal to 0
	public static void printDiv(int num, int denom) {
		int quotient = num / denom;
		System.out.println(num + " / " + denom + " = " + quotient);
	}
	/* postcondition: the equation formed by the parameters will be
	 * 				printed to the console with an answer
	 */

}
