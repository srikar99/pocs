package shreekar.recursion;

public class BinarySearchRecursion {

	public static void main(String[] args) {
		int[] array = new int[]{1, 4, 5, 7, 9, 12, 23, 32, 45, 88};
		int target = 45;
		
		System.out.println(binarySearch(array, target));
	}
	
	public static boolean binarySearch(int[] array, int target) {
		int low = 0, high = array.length - 1;
		
		return binarySearch(array, target, low, high);
	}

	private static boolean binarySearch(int[] array, int target, int low, int high) {
		
		if(low > high) {
			return false;
		}
		
		int mid = (low + high) - low / 2;
		
		if(array[mid] == target) return true;
		
		if(array[mid] < target) {
			// recurse right
			return binarySearch(array, target, mid + 1, high);
		} else {
			return binarySearch(array, target, low, mid - 1);
		}
	}
}
