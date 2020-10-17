package util;

import java.util.Arrays;

/**
 * Class containing useful methods for arrays manipulation.
 */
public class Util {

	/**
	 * Swaps the contents of two positions in an array.
	 *
	 * @param array
	 *            The array to be modified, not null
	 * @param i
	 *            One of the target positions
	 * @param j
	 *            The other target position
	 */
	public static void swap(Object[] array, int i, int j) {
		if (array == null)
			throw new IllegalArgumentException();

		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * It says if a specific number is prime or not.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(long n) {
		boolean result = true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0){
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	 * populates an array with zeros.
	 * @param array
	 * 			the array to be populated.
	 */
	public static void populaArray(Integer[] array) {
		Arrays.fill(array, 0);
	}

	/**
	 * gets the maximum numeric value in an integer array.
	 * @param array
	 * 			array to be searched
	 * @param leftIndex
	 * 			origin index
	 * @param rightIndex
	 * 			end index
	 * @return
	 * 			returns the index of maximum value.
	 */
	public static int getMax(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}

	/**
	 * gets the minimum numeric value in an integer array.
	 * @param array
	 * 			array to be searched
	 * @param leftIndex
	 * 			origin index
	 * @param rightIndex
	 * 			end index
	 * @return
	 * 			returns the index of minimum value.
	 */
	public static int getMin(Integer[] array, int leftIndex, int rightIndex) {
		int min = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}

	/**
	 * replaces array's elements for elements of another.
	 * @param A
	 * 			array to be modified
	 * @param B
	 * 			array to be copied
	 * @param leftIndex
	 * 			origin index
	 * @param rightIndex
	 * 			end index
	 */
	public static void replace(Integer[] A, Integer[] B, int leftIndex, int rightIndex){
		for (int i = leftIndex; i <= rightIndex; i++) {
			A[i] = B[i];
		}
	}
}