package Unit1;
import java.util.Scanner;

public class EmailFRQ {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your email address: ");
		String email = input.nextLine();
		
		//Part a - get index of "." and "@"
		int firstPeriod = email.indexOf(".");
		int firstAt = email.indexOf("@");
		
		//Part b - create username1 (first_last)
		String firstName = email.substring(0, firstPeriod);
		String lastName = email.substring(firstPeriod + 1, firstAt);
		String username1 = firstName + "_" + lastName;
		
		//Part c - create username2 (firstInitial_last)
		String firstInitial = email.substring(0, 1);
		String username2 = firstInitial + "_" + lastName;
		
		//Part d - generate random numbers for username
		int firstRandom = (int) (Math.random() * firstName.length());
		int secondRandom = (int) (Math.random() * (lastName.length() - 2));;
		
		//Part e - create username3 (random1First_random3Last)
		String firstPart = firstName.substring(firstRandom, firstRandom + 1);
		String secondPart = lastName.substring(secondRandom, secondRandom + 3);
		String username3 = firstPart + "_" + secondPart;
		
		System.out.println(username1);
		System.out.println(username2);
		System.out.println(username3);
	}

}
