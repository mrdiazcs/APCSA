package Unit1;
import java.util.Scanner;
public class CastingAndRangeOfVariables {

	public static void main(String[] args) {
		int a = 5;
		int b = 2;
		
		//casting
		double c = (double) a / b; //temporarily treats a as a double
		
		System.out.println(c);
		
		//this does not work because the casting happens too late
		c = (double) (a / b); //a / b = 2, (double) 2 = 2.0
		
		//PUMMDAS = order of operations
		//The U is for Unary Operators
		
		//(int) truncates in the same way that int division does
		//truncation means that it always rounds down
		System.out.println((int) (2.9 + 3.9)); //6
		
		//but there is a way to round properly
		
		Scanner input = new Scanner(System.in);
		
		//rounding positive values
		System.out.println("Enter a positive double value: ");
		double v1 = input.nextDouble();
		System.out.println("Enter another positive double value: ");
		double v2 = input.nextDouble();
		
		int roundedDouble = (int) (v1 + v2 + 0.5);
		
		System.out.println("Rounded Answer: " + roundedDouble);
	
		//rounding negative values
		System.out.println("Enter a negative double value: ");
		double v3 = input.nextDouble();
		System.out.println("Enter another negative double value: ");
		double v4 = input.nextDouble();
		
		int roundedDouble2 = (int) (v3 + v4 - 0.5);
		
		System.out.println("Rounded Answer: " + roundedDouble2);
		
		//---------------------------------------------------------
		//Range of Variables:
		
		int test = Integer.MAX_VALUE;
		System.out.println("Maximum integer value: " + test); //max value of an integer
		
		//integer overflow - adding to the maximum possible value makes the negative extreme
		System.out.println(test + 1); 
		
		System.out.println("Minimum integer value: " + Integer.MIN_VALUE); //minimum value of an integer
	}

}
