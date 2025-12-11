package Unit1;

public class VariablesAndDataTypes {

	public static void main(String[] args) {
		/*
		 * Data Types:
		 * 
		 * int - whole numbers
		 * double - decimals
		 * String - words/text
		 * boolean - true/false
		 * 
		 */
		
		//declaration - creating variables
		double wage;
		int population;
		String title;
		boolean clicked;
		
		
		//initialization - giving a variable its initial value
		wage = 1000000000.01;
		population = 400;
		title = "AP Computer Science A";
		clicked = false;
		
		//declaration and initialization can happen on the same line
		int classSize = 19;
		
		double integer = 5; //this works
//		int decimal = 10.5; //this does not
		
		
		//Concatenation with variables
		System.out.println("The title of this course is " + title + ".");
	}
}
