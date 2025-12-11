package Unit2;
/*
 * Leap year happens every 4 years
 * Except every 100 years it is skipped
 * Except every 400 years it actually isn't skipped
 * 
 * This program contains three methods that use different
 * techniques to determine if a given year is or is not a 
 * leap year. 
 */
public class LeapYear {

	public static void main(String[] args) {
		System.out.println(/* put leap year method call here */);
	}
	
	public static boolean leapYearNestedIfs(int year) {
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean leapYearIfElse(int year) {
		if(year % 400 == 0) {
			return true;
		}
		else if(year % 100 == 0) {
			return false;
		}
		else if(year % 4 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean leapYearNoIfs(int year) {
		return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
	}

}
