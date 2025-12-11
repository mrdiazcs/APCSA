package Unit2;
/*
 * 2 types of loops: while & for
 * 
 * while - used when we do not know how many times to repeat
 * 
 * for - used when we do know exactly how many times to repeat
 */

public class WhileLoops {

	public static void main(String[] args) {
		int random = (int) (Math.random() * 2); //either 0 or 1
		
		int count = 1; //keeping track of # of flips
		
		//0 = heads
		//1 = tails
		
		//new stuff
		while(random == 1) {
			System.out.println("Tails");
			random = (int) (Math.random() * 2); //flip again
			count++; //number of flips goes up by 1
		}
		
		//at this point, we know random will be 0
		System.out.println("Heads");
		System.out.println("Took " + count + " flip(s) to get heads");
	}

}
