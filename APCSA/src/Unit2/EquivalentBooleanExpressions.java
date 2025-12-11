package Unit2;

public class EquivalentBooleanExpressions {

	public static void main(String[] args) {
		Card a = new Card(1, "Spades");
		Card b = new Card(1, "Spades");
		
		//a = b;
		//a = null;
		
		a.flip();
		b.flip();
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(a == b); //comparing memory addresses of a and b
		System.out.println(a.equals(b)); //comparing properties of the card objects
	
		System.out.println(a == null); //true if a is not instantiated
										//false if a has been instantiated
		
		//comparing a to null to make sure it has been instantiated
		//before trying to get its value
		if(a != null && a.getValue() > 10) {
			System.out.println("Face card");
		}
		else if(a == null){
			System.out.println("a has not yet been instantiated");
		}
	}
}