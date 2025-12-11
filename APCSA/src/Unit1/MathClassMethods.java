package Unit1;

public class MathClassMethods {

	public static void main(String[] args) {
		
		//call math class methods with Math.
		
		/*
		 * Math.abs(int) and Math.abs(double) return the
		 * absolute values of their inputs
		 */
		System.out.println("Absolute value of -3: " + Math.abs(-3));
		System.out.println("Absolute value of -3.9: " + Math.abs(-3.9));
		
		/*
		 * Math.pow(double, double) returns the first number
		 * raised to the power of the second. This output is
		 * always a double.
		 */
		System.out.println(Math.pow(2, 3)); //2^3 = 8.0
		System.out.println(Math.pow(2, -2)); //works for negative powers
		System.out.println(Math.pow(8, 1.0 / 3)); //works for fraction powers
		System.out.println(Math.pow(27, 0)); //works for 0 power
		
		/*
		 * Math.sqrt(double) returns the square root of its input.
		 * This output is always a double.
		 */
		System.out.println(Math.sqrt(16)); //4.0
		System.out.println(Math.sqrt(Math.sqrt(16))); //4th root of 16 = 2.0
		
		/*
		 * Math.random() on its own returns a random double on the range [0.0, 1.0)
		 * 
		 * This is not super useful by itself, so to generate a random int on the
		 * range [a, b] (a much more common situation), the formula is:
		 * 
		 * (int) (Math.random() * (b - a + 1)) + a
		 */
		System.out.println((int) (Math.random() * 10) + 1); //random int from 1-10
				
	}

}
