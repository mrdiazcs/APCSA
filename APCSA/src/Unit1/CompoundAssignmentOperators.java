package Unit1;
import java.util.Scanner;

public class CompoundAssignmentOperators {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//assignment operator -> =
		double accountBalance = 1000000000;
		
		System.out.println("Enter an amount to withdraw");
		int withdrawal = input.nextInt();
		
		//this does NOT change accountBalance
		System.out.println(accountBalance - withdrawal);
		
		//System.out.println(accountBalance);
		
		//permanently change accountBalance
		//accountBalance = accountBalance - withdrawal;
		
		accountBalance -= withdrawal; //does the same thing as line 21
		System.out.println("Account $ after withdrawal: " + accountBalance);
		
		System.out.println("Enter an amount to deposit");
		double deposit = input.nextDouble();
		
		accountBalance += deposit;
		System.out.println("Account $ after deposit: " + accountBalance);

		System.out.println("What is your interest rate?");
		double interest = input.nextDouble();
		
		accountBalance *= interest;
		System.out.println("Account $ after interest: " + accountBalance);
		
		// /= and %= also work
		// a op= b means the same thing as a = a op b
		
		int x = 25;
		
		//increment
		x++; //same thing as x += 1 or x = x + 1
		
		System.out.println(x);
		
		//decrement
		x--;
		
		System.out.println(x);
	}

}
