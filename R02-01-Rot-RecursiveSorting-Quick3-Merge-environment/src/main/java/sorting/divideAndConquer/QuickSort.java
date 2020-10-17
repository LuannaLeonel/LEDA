package sorting.divideAndConquer;

import sorting.AbstractSorting;

import java.util.Arrays;
import java.util.Random;

import static util.Util.swap;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (!(leftIndex >= array.length ||rightIndex > array.length || leftIndex < 0 || leftIndex > rightIndex)){
			if (leftIndex < rightIndex) {
				int p = partition(array, leftIndex, rightIndex);

				sort(array, leftIndex, p);
				sort(array, p + 1, rightIndex);
			}
		}

	}
	private int partition(T[] array, int low, int high){
		rand(array,low,high);
		T pivot = array[low];
		int i = low -1;
		int j = high+1;

		while (true){
			do {
				i++;
			} while (array[i].compareTo(pivot) < 0);
			do {
				j--;
			} while (array[j].compareTo(pivot) > 0);
			if (i>=j)
				return j;
			swap(array,i,j);
		}
	}
	private void rand(T[] array, int l, int r){
		Random random = new Random();
		int pivot = random.nextInt(r-l)+l;
		swap(array,pivot,r);
	}

}
