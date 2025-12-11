package Unit2;

public class IfStatements {

	public static void main(String[] args) {
		double grade = Math.random() * 51 + 50;
		
		System.out.println("Grade: " + grade);
		
		String letterGrade = "";
		
		//order of if statements very much matters
		
		//if for the first condition
		if(grade >= 90) {
			letterGrade = "A";
		}
		else if(grade >= 80) { //otherwise check other conditions
			letterGrade = "B";
		}
		else if(grade >= 70) { //in descending order
			letterGrade = "C";
		}
		else if(grade >= 60) { //until one is found to be true, then skip all others
			letterGrade = "D";
		}
		else { //default if no condition before is found to be true
			letterGrade = "F";
		}
		
		System.out.println("Letter grade: " + letterGrade);
		
	}

}
