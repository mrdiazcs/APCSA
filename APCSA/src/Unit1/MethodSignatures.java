package Unit1;
/*
 * Libraries are collections of classes that define specific 
 * attributes and behaviors. Application Programming Interfaces 
 * (APIs) inform users via documentation how to use those classes.
 * 
 * In this program, we will look at the String class, which is
 * part of the built-in Java library. The String class defines 
 * the attributes and behaviors of String objects.
 * 
 * "Attributes" refer to the data related to the class stored in 
 * the form of variables.
 * 
 * "Behaviors" refer to what instances of the class can do, or what
 * can be done with them. In other words, they are actions that can
 * be performed with objects of the class. These are defined by 
 * methods.
 */

import java.util.Scanner;

public class MethodSignatures {
	
	/*
	 * Today, we will explore the String methods. These are actions
	 * that can be performed on/with String objects. Documentation
	 * for these methods can be found online. Documentation for the
	 * specific String methods that are on the AP exam can be found
	 * on the Java Quick Reference.
	 * 
	 * Methods are blocks of code that only run when they are called.
	 * Defining a method is like teaching your program how to do a
	 * task (like a mini algorithm). Calling a method is asking your
	 * program to do that task.
	 * 
	 * Method Signatures:
	 * 
	 * [return type] [name] ([parameters])
	 * 
	 * A method's return type refers to the output of that method. 
	 * Some methods do not return a value. These are called void 
	 * methods and contain the word "void" in place of any return type.
	 * 
	 * int length() returns an int equal to the String's length
	 * "September".length() returns 9
	 * 
	 * 
	 * A method's name can be anything that does not start with a
	 * special character. Methods are usually written in lower camel
	 * case, like variables.
	 * 
	 * 
	 * A method's parameters are its input(s). A method can have no
	 * parameters, one parameter, or many parameters. Parameters are
	 * written as a comma separated list with data types and names.
	 * 
	 * String substring(int from, int to) takes two parameters, both
	 * ints. These parameters represent the start and end of the
	 * substring that is returned.
	 * 
	 * "Monday".substring(2, 4) returns "nd"
	 * 
	 * When parameters get actual values, they are called arguments.
	 * The arguments 2 and 4 were passed into the substring method here.
	 */

	public static void main(String[] args) {
		
		//the String methods are defined in the String class
		//they can be called (executed) in any Java class
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please type your first and last name: ");
		String fullName = input.nextLine();
		
		//represents the index of the space in the full name
		int space = fullName.indexOf(" ");
		
		//first name is everything from index 0 up until the space
		String firstName = fullName.substring(0, space); //substring with 2 parameters
		
		//last name is everything after the space
		String lastName = fullName.substring(space + 1); //substring with 1 parameter
		
		System.out.println("First name: " + firstName);
		System.out.println("Last name: " + lastName);

		/*
		 * The substring method in the String class is 'overloaded' 
		 * because there are two ways to call it depending on the 
		 * parameters passed into the method.
		 */		
	}
}