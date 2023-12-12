import java.security.SecureRandom;

public class App {
	
	/**
	 * Creates an array of unique integers from a minimum to maximum.
	 * @param from Minimum integer value in the array.
	 * @param to Maximum integer value in the array.
	 * @return result The array of unique unsorted integers.
	 */
	static int[] createUniqueRandomNumbers(int from, int to) {
		int n = to - from;
		int[] a = new int[n];
		for(int i = 1; i <= n; i++)
		{
		    a[i - 1] = i;
		}

		// an array to store the result
		int[] result = new int[n];

		SecureRandom rd = new SecureRandom();
		int x = n;
		for(int i = 1; i <= n; i++)

		{
		    // k is a random index in [0, x]
			// System.out.println(x);
		    int k = rd.nextInt(x);

		    result[i - 1] = a[k];

		    a[k] = a[x - 1];

		    x--;
		}
		
		return result;
	}
	
	/**
	 * Compares the selection sort algorithm with the quick sort algorithm.
	 * @param n The integer value for determining the size of the unsorted array.
	 */
	static void compareSorts(int n) {
		System.out.println("n: " + n);
		
		long systemTime;
		
		// Get Random List
		int[] intList = createUniqueRandomNumbers(0, n);
		// Print Unsorted List
		System.out.println("Unsorted: ");
		for (int listInt: intList) {
			System.out.print(listInt + ", ");
		}
		System.out.println("\n");
		
		// Selection Sort
		IntSelectionSort selectionSort = new IntSelectionSort();
		// Get Start Time
		systemTime = System.nanoTime();
		// Sort
		int[] intListSelectionSort = selectionSort.Sort(intList);
		// Print Wall Time
		System.out.println("Selection Sort Wall Time: " + (System.nanoTime()-systemTime));
		// Print Sorted List
		System.out.println("Selection Sorted: ");
		for (int listInt: intListSelectionSort) {
			System.out.print(listInt + ", ");
		}
		System.out.println("\n");

		// Quick Sort
		IntQuickSort quickSort = new IntQuickSort();
		// Get Start Time
		systemTime = System.nanoTime();
		// Sort
		int[] intListQuickSort = quickSort.Sort(intList);
		// Print Complexity
		System.out.println("Quick Sort Complexity: " + quickSort.runtime);
		// Print Wall Time
		System.out.println("Quick Sort Wall Time: " + (System.nanoTime()-systemTime));
		// Print Sorted List
		System.out.println("Quick Sorted: ");
		for (int listInt: intListQuickSort) {
			System.out.print(listInt + ", ");
		}
		System.out.println("\n");
		System.out.println("---\n");
	}
	
	public static void main(String[] args) {
		int[] nList = {5, 25, 100, 1000};
		for (int n: nList) {
			compareSorts(n);
		}
	}
}
