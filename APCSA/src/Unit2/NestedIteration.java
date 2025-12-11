package Unit2;
public class NestedIteration {

	public static void main(String[] args) {
		
		//nested for loops to make a multiplication table
		for(int i = 1; i <= 12; i++) {
			for(int j = 1; j <= 12; j++) {
				System.out.print(i * j + "\t");
			}
			System.out.println();
		}
		
		//nested for loops to draw a rectangle of stars
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//nested for loops to print every possible time on a clock
		for(int hours = 1; hours <= 12; hours++) {
			for(int minutes = 0; minutes < 60; minutes++) {
				String output = "";
				if(hours < 10) {
					output += "0";
				}
				output += (hours + ":");
				if(minutes < 10) {
					output += "0";
				}
				output += minutes;
				System.out.println(output);
			}
		}
	}
}