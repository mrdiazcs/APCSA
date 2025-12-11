package Unit1;
import java.util.Scanner; //user input step 1: import the Scanner

public class AssignmentStatementsAndInput {

	public static void main(String[] args) {
		
		//one = is assignment operator
		//sets variables equal to values
		int x = 7; //x = 7
		int y = 3 * 2; //y = 6
		int z = y - 1; //z = 5
		
		double d = 5.9;
		d = 2.5;
		
		//d has only its most recently assigned value
		System.out.println(d);
		
		//declaration of t
		double t;
		
		//t cannot be used because it has not been initialized
//		System.out.println(t);
		
		//comparison operator - compares two values
		//returns a boolean value (in this case false)
		System.out.println(x == y);
		
		//user input step 2: create a Scanner object
		Scanner input = new Scanner(System.in);
		
		//user input step 3: prompt the user for input
		System.out.println("How old are you?");
		
		//user input step 4: use the Scanner to read proper data type
		int age = input.nextInt();
		
		System.out.println("You are " + age + " years old");
		
		//user input step 5: close the Scanner
		input.close();
	}
}