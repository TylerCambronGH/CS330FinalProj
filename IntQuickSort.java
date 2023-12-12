/**
 * 
 * Quick sorting for integers.
 *
 */
public class IntQuickSort {
	public int runtime;

	public IntQuickSort() {}
	
	/**
	 * Starts the sorting process.
	 * @param intArr An array of unsorted integers.
	 * @return arr An integer array of sorted integers based on intArr.
	 */
	public int[] Sort(int[] intArr) {
		int[] arr = intArr.clone();
		runtime = 0;
		quickSort(arr, 0, arr.length-1);
		return arr;
	}
	
	/**
	 * Quick sorting using recursion and partitioning.
	 * @param arr Unsorted array of integers
	 * @param begin Beginning index of the unsorted array section.
	 * @param end Ending index of the unsorted array section.
	 */
	public void quickSort(int[] arr, int begin, int end) {
		if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);

	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
	
	/**
	 * Partitioning algorithm for creating array subsets.
	 * @param arr The integer array being partitioned.
	 * @param begin Beginning index of the unsorted array section.
	 * @param end Ending index of the unsorted array section.
	 * @return The index of next pivot.
	 */
	private int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	    	runtime++;
	        if (arr[j] <= pivot) {
	            i++;
	            
	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}
}
