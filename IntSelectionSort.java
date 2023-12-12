/**
 * 
 * Selection sorting for integers.
 *
 */
public class IntSelectionSort {
	public IntSelectionSort() {}
	
	/**
	 * Sorts an array of integers using selection sorting.
	 * @param intArr An array of integers.
	 * @return arr The sorted version of intArr, an array of integers.
	 */
	public int[] Sort(int[] intArr) {  
		int[] arr = intArr.clone();
		int runtime = 0;
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j; 
                }  
                runtime++; // every comparison
            }  
            int smaller = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smaller;  
        }  
        System.out.println("Selection Sort Complexity: " + runtime);
        return arr;
    }
}
