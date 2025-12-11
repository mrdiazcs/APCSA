package Unit2;

public class NumberPuzzlesAnswers {

	public static void main(String[] args) {
		System.out.print("Puzzle 1: ");
		
		/*
		 * Find a pair of two-digit numbers whose 
		 * sum is 60 and whose difference is 14
		 */
		
		for(int i = 10; i <= 99; i++) { //all 2 digit #s
			for(int j = 10; j <= 99; j++) { //all 2 digit #s
				if(i + j == 60 && i - j == 14) { //condition
					System.out.println(i + " " + j);
				}
			}
		}
		
		System.out.print("Puzzle 2: ");
		
		/*
		 * Find all two digit numbers <= 56 whose digits
		 * add to be > 10
		 */
		for(int i = 1; i <= 9; i++) { //10s place
			for(int j = 0; j <= 9; j++) { //1s place
				if(i * 10 + j <= 56 && i + j > 10) { //condition
					System.out.print(i * 10 + j + " ");
				}
			}
		}
		
		System.out.println();
		
		System.out.print("Puzzle 3: ");
		
		/*
		 * Find a two-digit number such that:
		 * the original # - the # reversed = the sum of the digits
		 */
		
		for(int i = 1; i < 10; i++) { //10s place
			for(int j = 0; j < 10; j++) { //1s place
				int number = i * 10 + j; //putting digits together
				int reversed = j * 10 + i; //reversed version
				if(number - reversed == i + j) { //condition
					System.out.println(number);
				}
			}
		}
		
		System.out.print("Puzzle 4: ");
		
		/*
		 * Find all 3-digit Armstrong #s
		 * (An Armstrong # is one such that the sum
		 * of each digit cubed = the original number)
		 */
		
		for(int i = 1; i < 10; i++) { //100s place
			for(int j = 0; j < 10; j++) { //10s place
				for(int k = 0; k < 10; k++) { //1s place
					
					int number = i * 100 + j * 10 + k; //putting digits together
					
					//condition
					if(Math.pow(i, 3) + Math.pow(j, 3) + Math.pow(k, 3) == number) {
						System.out.print(number + " ");
					}
				}
			}
		}
		
		System.out.println();
		
		/*Find 4 numbers that add to 45 and
		 * A + 2 = B - 2 = C * 2 = D / 2
		 */
		
		System.out.print("Puzzle 5: ");
		for(int i = 0; i < 45; i++) { //first number possibilities
			for(int j = 0; j < 45; j++) { //second number possibilities
				for(int k = 0; k < 45; k++) { //third number possibilities
					for(int l = 0; l < 45; l++) { //fourth number possibilities
						
						//condition
						if(i + j + k + l == 45 && i + 2 == j - 2 && j - 2 == k * 2 && k * 2 == l / 2) {
							System.out.println(i + " " + j + " " + k + " " + l);
						}
					}
				}
			}
		}
	}

}
