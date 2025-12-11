package Unit2;
import java.util.Scanner;

public class CYOA {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your name?");
		String name = input.nextLine();
		
		System.out.println("You're in Mr. Diaz's AP Computer Science A class."
				+ "\nYou're struggling to stay awake listening to him go on and on about"
				+ "\nif statements and boolean expressions. All of a sudden, you feel "
				+ "\nyour phone vibrate in your pocket. The curiosity of what it could be"
				+ "\nnags at you like an itch that you can't scratch. Type 1 to try to sneak"
				+ "\na look at your phone. Type 2 to ignore the notification.");
		
		int choice = input.nextInt();
		
		if(choice == 1) {
			System.out.println("You try to sneak a look for a second, just to see what the "
					+ "\nnotification is. Oh, great, it's just Uber Eats asking if you're hungry."
					+ "\nNot worth it. You gaze up as you slide your phone back into your pocket."
					+ "\nJust when you think you might have gotten away with it, you hear from the"
					+ "\nfront of the classroom: \"" + name.toUpperCase() + "! Hand your phone over this instant!\" "
					+ "\nType 1 to turn your phone in. Type 2 to make a run for it.");
			choice = input.nextInt();
			
			if(choice == 1) {
				System.out.println("Ashamed and embarrassed, you turn your phone in. \"I'll give"
						+ "\nthis to Ms. Cerm and you can pick it up in a week,\" Mr. Diaz says."
						+ "\nYou start to feel like getting out of the classroom for a little while"
						+ "\nwill help you calm down. On the other hand, though, you don't want to "
						+ "\ndraw any more attention to yourself. Type 1 to ask to go to the bathroom. "
						+ "\nType 2 to stay seated.");
				choice = input.nextInt();
				if(choice == 1) {
					System.out.println("You ask to go to the bathroom and Mr. Diaz lets you go without"
							+ "\nany issue. Finally you've escaped. You hurry through the halls and into"
							+ "\na specific stall once you reach the bathroom. You stand on the toilet"
							+ "\nand reach up, moving a ceiling tile aside. You knew this day would come,"
							+ "\nand you're happy that you prepared for this. You've been stockpiling old"
							+ "\nphones up here since 1st grade. You grab a replacement, an old iPhone 3."
							+ "\nThis will do for a week. At least it's something.");
				}
				else {
					System.out.println("You stay seated, not wanting to cause a fuss. At the end of class,"
							+ "\nMr. Diaz asks you to stay for a minute. Ugh, he's probably going to give"
							+ "\nyou some lecture about being disrespectful in class. To your surprise, though,"
							+ "\nhe hands you back your phone and says \"Just don't let that happen again\"."
							+ "\nWow. What a cool teacher.");
				}
			}
			else {
				System.out.println("You're in fight or flight mode, and you've just chosen flight. Before"
						+ "\nyou have any more time to weigh your options, you instinctively dash out of the"
						+ "\nclassroom and into the hall. Type 1 to go left. Type 2 to go right.");
				choice = input.nextInt();
				
				if(choice == 1) {
					System.out.println("You make a sharp left out of the door and hurry up the "
							+ "\nstairwell around the corner. As you burst out of the door, you "
							+ "\nbump into a teacher who tells you to stop running. They chase after"
							+ "\nyou, and eventually you are caught. Now you have bigger problems"
							+ "\nthan your phone being taken away.");
				}
				else {
					System.out.println("You make a sharp right out of the door and hurry up the"
							+ "\nstairwell around the corner. Once you reach the main floor, you run"
							+ "\nout the back door into the parking lot. Frantically, you pull your"
							+ "\nkeys out of your pocket and hop into your car. You're driving off into"
							+ "\nthe sunset, unsure if you'll ever be able to return. But at least you"
							+ "\nhave your phone.");
				}
			}
		}
		else {
			System.out.println("You try your best to ignore the notification, but after a few more"
					+ "\nminutes, you feel your phone buzzing in rhythm. Oh no. Now you're getting a"
					+ "\ncall. This could be important. Type 1 to excuse yourself so you can check"
					+ "\nyour phone. Type 2 to keep ignoring it.");
			choice = input.nextInt();
			
			if(choice == 1) {
				System.out.println("You ask to go to the bathroom, and soon you're able to look at"
						+ "\nyour phone. You don't recognize the number that called, but they left"
						+ "\nyou a voicemail. Type 1 to listen. Type 2 to head back to class.");
				choice = input.nextInt();
				if(choice == 1) {
					System.out.println("You listen to the voicemail and hear a strange, monotone voice"
							+ "\non the other end. \"We're calling about your car's extended warranty,\""
							+ "\nthey start. This confuses you. You don't remember signing up for an extended"
							+ "\nwarranty. That's odd. But now you're worried. You'll just have to call back"
							+ "\nafter school.");
				}
				else {
					System.out.println("Worried about the time you have already missed, you head back to "
							+ "\nclass. It couldn't have been that important if you didn't even recognize "
							+ "\nthe number. As you return to class, Mr. Diaz has just finished his boring"
							+ "\nlesson. He tells you that you'll be starting a project soon and starts to "
							+ "\npull up an example on Eclipse.");
				}
			}
			else {
				System.out.println("You continue to ignore your phone, but the buzzing does not stop."
						+ "\nWhoever this is will not leave you alone. Type 1 to try to silence the call"
						+ "\nthrough your pocket. Type 2 to peek at the phone number.");
				choice = input.nextInt();
				
				if(choice == 1) {
					System.out.println("You try to silence your phone, but your hand slips. Before you know it,"
							+ "\nyou hear a voice on the other end. Not only did you accidentally answer the call,"
							+ "\nbut you also accidentally turned on speaker. The voice says loudly, in a robotic"
							+ "\ntone, \"WE'RE CALLING ABOUT YOUR CAR'S EXTENDED WARRANTY\". Mr. Diaz's eyes dart"
							+ "\nacross the classroom, trying to pinpoint the source of the disruption. Finally,"
							+ "\nhis eyes meet yours. It's no use hiding it. The sound came from your phone. It's"
							+ "\nobvious. You turn your phone in and sit through the rest of the class thinking:"
							+ "\nWhat could you have done differently?");
				}
				else {
					System.out.println("You try to sneak a peek at the phone number. Gracefully, at an opportune "
							+ "\nmoment, you pull just the top of your phone out of your pocket. Oh, good! It's a"
							+ "\nnumber you don't recognize, so you quickly slide your phone back in again. Looking"
							+ "\naround, it seems like nobody caught you. The rest of the class goes smoothly, and"
							+ "\neveryone lives happily ever after.");
				}
			}
		}
		
		input.close();
	}
}