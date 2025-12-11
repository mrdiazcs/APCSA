package Unit2;
/*
 * Directions: The code below contains a main method as well
 * as five other methods that are intended to help you 
 * practice using for loops. Each method contains a description
 * of its intended function including its output and parameters.
 * 
 * Fill in the body of each method according to its 
 * specifications. Each method will use for loops in some way.
 * 
 * The code below contains errors because it is incomplete.
 * You may need to comment out certain portions in the testing
 * process. To comment multiple lines at once, use the Command
 * (or CTRL) key + /
 */
public class ForLoopMethods {
	
	/*
	 * Show that each method works by calling them 
	 * appropriately in the main method
	 */
	public static void main(String[] args) {
		System.out.println(sumFromOne(4));
		numPattern(3, 15, 4);
//		System.out.println(evenIndexLetters("wardlaw"));
//		System.out.println(count("supercalafragilisticexpialidocious", "a"));
//		System.out.println(reverse("dog"));
	}
	
	/*
	 * Returns the sum of all integers from 1 to 'x'
	 * 
	 * For example:
	 * 
	 * sumFromOne(5) -> 15 (1 + 2 + 3 + 4 + 5)
	 * sumFromOne(1) -> 1 (1)
	 * sumFromOne(2) -> 3 (1 + 2)
	 * 
	 * Precondition: x > 0
	 */
	public static int sumFromOne(int x) {
		int sum = 0;
		for(int i = 1; i <= x; i++) {
			sum += i;
		}
		return sum;
	}
	
	/*
	 * Prints a pattern of numbers all on the same line
	 * according to parameter values. Pattern starts at
	 * 'from', goes up to and includes 'to', and adds 'by'
	 * for each new number.
	 * 
	 * For example:
	 * 
	 * numPattern(0, 10, 2) prints 0 2 4 6 8 10
	 * numPattern(0, 50, 10) prints 0 10 20 30 40 50
	 * numPattern(13, 21, 4) prints 13 17 21
	 * 
	 * Preconditions: from < to, (to - from) % by == 0
	 */
	public static void numPattern(int from, int to, int by) {
		for(int i = from; i <= to; i += by) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	/*
	 * Returns a String that contains only the even-indexed
	 * letters of 'word' in the order in which they appear
	 * 
	 * For example:
	 * 
	 * evenIndexLetters("cat") -> "ct"
	 * evenIndexLetters("compute") -> "cmue"
	 * evenIndexLetters("types") -> "tps"
	 * 
	 * Precondition: word.length() % 2 == 1
	 */
	public static String evenIndexLetters(String word) {
		String result = "";
		for(int i = 0; i < word.length(); i++) {
			if(i % 2 == 0) {
				result += word.substring(i, i + 1);
			}
		}
		return result;
	}
	
	/*
	 * Returns the number of times 'letter' appears in 'word'
	 * 
	 * For example:
	 * 
	 * count("mississippi", "s") -> 4
	 * count("mississippi", "p") -> 2
	 * count("mississippi", "z") -> 0
	 * 
	 * Precondition: word contains only lower-case letters, letter is a lower-case letter
	 */
	public static int count(String word, String letter) {
		int count = 0;
		for(int i = 0; i < word.length(); i++) {
			if(word.substring(i, i + 1).equals(letter)) {
				count++;
			}
		}
		return count;
	}
	
	/*
	 * Returns a String that is the reverse of 'word'
	 * 
	 * For example:
	 * 
	 * reverse("abc") -> "cba"
	 * reverse("bob") -> "bob"
	 * reverse("testing") -> "gnitset"
	 * 
	 * Precondition: word contains only lower-case letters
	 */
	public static String reverse(String word) {
		String result = "";
		for(int i = word.length() - 1; i >= 0; i--) {
			result += word.substring(i, i + 1);
		}
		return result;
	}
}
