package Unit2;
import java.util.Scanner;

public class CompoundBooleanExpressions {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int num = input.nextInt();
		
		if(num % 2 == 0 && isPrime(num)) {
			System.out.println(num + " is even and prime");
		}
		else if(num % 2 == 0 || isPrime(num)) {
			System.out.println(num + " is even or prime");
		}
		else if(num % 2 == 0 || !isPrime(num)) {
			System.out.println(num + " is even or not prime");
		}
		
		//short circuit evaluation
		if(num % 2 == 0 || num / 0 == 1000000) {
			System.out.println("Test");
		}
		
	}
	
	public static boolean isPrime(int n) {
		for(int i = n - 1; i > 1; i--) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
