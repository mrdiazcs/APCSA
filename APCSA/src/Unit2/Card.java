package Unit2;
public class Card {
	
	//instance variables
	private String suit;
	private int value;
	private String label;
	private boolean hidden;
	
	//constructor with 2 parameters
	public Card(int v, String s) {
		suit = s;
		value = v;
		hidden = true;
		setLabel();
	}
	
	//constructor with no parameters
	//generates a random card
	public Card() {
		//random # 1-13 for value
		int rand1 = (int) (Math.random() * 13) + 1;
		//random # 1-4 for suit
		int rand2 = (int) (Math.random() * 4) + 1;
		value = rand1;
		setLabel();
		if(rand2 == 1) {
			suit = "Clubs";
		}
		else if(rand2 == 2) {
			suit = "Hearts";
		}
		else if(rand2 == 3) {
			suit = "Diamonds";
		}
		else if(rand2 == 4) {
			suit = "Spades";
		}
		hidden = true;
	}
	
	//private (internal) method meant for setting
	//a card's label according to its value
	private void setLabel() {
		if(value == 1) label = "A";
		else if(value == 2) label = "2";
		else if(value == 3) label = "3";
		else if(value == 4) label = "4";
		else if(value == 5) label = "5";
		else if(value == 6) label = "6";
		else if(value == 7) label = "7";
		else if(value == 8) label = "8";
		else if(value == 9) label = "9";
		else if(value == 10) label = "X";
		else if(value == 11) label = "J";
		else if(value == 12) label = "Q";
		else if(value == 13) label = "K";
		else if(value == 14) label = "?";
	}
	
	//returns a String representation of a card
	public String toString() {
		String disp = "";
		if(!hidden) {
			String suitDisp = "";
		if(suit.equals("Spades"))
			suitDisp = "\u2660";
		else if(suit.equals("Hearts"))
			suitDisp = "\u2661";
		else if(suit.equals("Diamonds"))
			suitDisp = "\u2662";
		else if(suit.equals("Clubs"))
			suitDisp = "\u2663";
		else if(suit.equals("Joker"))
			suitDisp = "\u263A";
			disp =    "┌───────┐\n"
					+ "│" + label + "      │\n"
					+ "│       │\n"
					+ "│   " + suitDisp + "   │\n"
					+ "│       │\n"
					+ "│      " + label + "│\n"
					+ "└───────┘\n";
		}
		else {
			disp = "┌───────┐\n"
				+ "│░░░░░░░│\n"
				+ "│░░░░░░░│\n"
				+ "│░░░░░░░│\n"
				+ "│░░░░░░░│\n"
				+ "│░░░░░░░│\n"
				+ "└───────┘\n";
		}
		return disp;
	}
	
	//hidden mutator
	public void flip() {
		hidden = !hidden;
	}
	
	//value accessor
	public int getValue() {
		return value;
	}
	
	//value mutator
	public void setValue(int newValue) {
		value = newValue;
		setLabel();
	}
	
	//returns the name of the card
	public String getName() {
		return label + " of " + suit;
	}
	
	public boolean getHidden() {
		return hidden;
	}
	
	//compares a card object to c
	//returns the name of the winning card (this or c)
	//returns "Nobody" if there is a tie
	public String compare(Card c) {
		if(value > c.getValue()) {
			return getName();
		}
		else if(value < c.getValue()) {
			return c.getName();
		}
		else {
			if(getSuitNumber() > c.getSuitNumber()) {
				return getName();
			}
			else if(getSuitNumber() < c.getSuitNumber()) {
				return c.getName();
			}
			else {
				return "Nobody";
			}
		}
	}
	
	private int getSuitNumber() {
		if(suit.equals("Spades")) return 4;
		else if(suit.equals("Hearts")) return 3;
		else if(suit.equals("Diamonds")) return 2;
		else return 1;
	}
	
	//equals method
	public boolean equals(Card other) {
		if(value == other.getValue() && getSuitNumber() == other.getSuitNumber()) {
			return true;
		}
		else {
			return false;
		}
	}
}