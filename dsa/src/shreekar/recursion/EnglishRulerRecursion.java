package shreekar.recursion;

/*
 * 
 * A class to print the English Ruler using recursion
 */
public class EnglishRulerRecursion {

	public static void printRuler(int inches, int majorLength) {
		printLine(majorLength, 0);
		
		for(int i = 1; i <= inches; i++) {
			printInterval(majorLength - 1);
			printLine(majorLength, i);
		}
	}
	
	private static void printInterval(int length) {
		if(length >= 1) {
			printInterval(length - 1);
			printLine(length);
			printInterval(length - 1);
		}
	}
	
	private static void printLine(int length) {
		for(int i = 1; i <= length; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	private static void printLine(int majorLength, int label) {
		for(int i = 1; i <= majorLength; i++) {
			System.out.print("-");
		}
		System.out.println(" " + label);
	}
	
	public static void main(String[] args) {
		printRuler(2, 4);
	}
}
