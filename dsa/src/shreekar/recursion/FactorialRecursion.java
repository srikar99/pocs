package shreekar.recursion;

public class FactorialRecursion {

	/**
	 * A recursive function to calculate n!
	 */
	public static int fact(int n) {
		if(n == 0) return 1;
		
		return n * fact(n - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(fact(5));
		System.out.println(fact(15));
	}
}
