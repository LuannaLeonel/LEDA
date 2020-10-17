package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;

import java.util.Arrays;

import static util.Util.swap;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		Boolean troca = true;
		int inicio = leftIndex;
		int fim = rightIndex +1;

		while (troca){
			troca = false;

			for (int i = inicio; i < fim-1; i ++){
				if (array[i].compareTo(array[i+1]) == -1){
					swap(array,i,i+1);
					troca = true;
				}
			}
			if (troca = false) {
				break;
			}
			troca = false;
			fim = fim -1;

			for (int i = fim -1;i >= inicio; i--){
				if (array[i].compareTo(array[i+1]) == 1){
					swap(array,i+1,i);
					troca = true;
				}
			}
			inicio+= 1;
		}
	}
}
