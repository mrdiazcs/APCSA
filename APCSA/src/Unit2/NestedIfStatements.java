package Unit2;
import java.util.Scanner;

public class NestedIfStatements {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a word: ");
		String word = input.nextLine();
		
		System.out.println("Enter a number: ");
		int num = input.nextInt();
		
		/*
		 * Disclaimer: Below is an example of a set of nested if statements
		 * I know that I could achieve the same result in fewer lines of
		 * code without nested if statements, but the code below does a good
		 * job of illustrating how nested if statements work. So, although
		 * the code below is certainly not optimized, it is a good example
		 * for educational purposes. 
		 */
		
		//A nested if statement is an if statement within an if statement
		if(word.length() > 7) { //if the word is long
			
			System.out.println("That's a long word");
			
			if(num % 2 == 0) { //long word and even number
				System.out.println("And an even number");
			}
			else { //long word and odd number
				System.out.println("And an odd number");
			}
		}
		else if(word.length() >= 5 && word.length() <= 7) { //if the word is medium length
			
			System.out.println("That's a medium length word");
			
			if(num % 2 == 0) { //medium word and even number
				System.out.println("And an even number");
			}
			else { //medium word and odd number
				System.out.println("And an odd number");
			}
		}
		else { //if the word is short
			
			System.out.println("That's a short word");
			
			if(num % 2 == 0) { //short word and even number
				System.out.println("And an even number");
			}
			else { //short word and odd number
				System.out.println("And an odd number");
			}
		}
	}

}
