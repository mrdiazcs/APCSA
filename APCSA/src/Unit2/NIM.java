package Unit2;
import java.util.Scanner;

public class NIM {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("There will be a pile of 20-30 paper clips. One at");
		System.out.println("a time, you and a computer player will alternate");
		System.out.println("removing 1-3 paper clips from the pile. The last player");
		System.out.println("to remove a paper clip wins.");
		System.out.println();
		System.out.println("Enter 1 to go first. Enter 2 to go second.");
		
		int currentTurn = input.nextInt();
		
		int paperClips = (int) (Math.random() * 11) + 20;
		
		while(paperClips > 0) {
			System.out.println();
			System.out.println("There are " + paperClips + " paper clips remaining.");
			
			if(currentTurn % 2 == 1) {
				System.out.println("You may remove 1-3 paper clips.");
				System.out.println("Enter a number 1-3 to remove that many paper clips: ");
				int remove = input.nextInt();
				while(remove > 3 || remove > paperClips || remove < 1) {
					System.out.println("You may not remove " + remove + " paper clips");
					System.out.println("Enter a number 1-3: ");
					remove = input.nextInt();
				}
				System.out.println("You removed " + remove + " paper clip(s).");
				paperClips -= remove;
			}
			else {
				int remove = paperClips % 4;
				if(remove == 0) {
					remove = (int) (Math.random() * 3) + 1;
				}
				paperClips -= remove;
				System.out.println("The computer removes " + remove + " paper clip(s).");
			}
			currentTurn++;
		}
		
		input.close();
		
		if(currentTurn % 2 == 0) {
			System.out.println("You win!!!");
		}
		else {
			System.out.println("The computer wins...");
		}
	}

}
