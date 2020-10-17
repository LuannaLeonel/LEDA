package sorting.simpleSorting;

import sorting.AbstractSorting;

import java.util.Arrays;

import static util.Util.swap;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		for (int i = leftIndex; i < rightIndex +1; i++){
			for (int j = i +1; j < rightIndex + 1 ; j++){
				if (array[j].compareTo(array[i]) == -1){
					swap(array,i,j);
				}
			}
		}

	}

}
