package Unit2;

public class ForLoops {

	public static void main(String[] args) {
		
		/*
		 * Prints every prime number from 1 - 500
		 */
		
		int count = 1; //starting value
		
		while(count < 500) { //condition = what keeps the loop going?
			//what happens with each repetition
			if(isPrime(count)) {
				System.out.println(count);
			}
			count++;
		}
		
		System.out.println("---------------------------");
		
		/*
		 * for loops use this exact step-by-step process
		 * in a different syntax/form
		 */
		
		//for(declare/init; condition; increment) {
		//	body of the loop
		//}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		
		System.out.println(factorial(8));
	}
	
	public static int factorial(int n) {
		int result = 1;
		
		for(int i = n; i > 1; i--) {
			result *= i;
		}
		
		return result;
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