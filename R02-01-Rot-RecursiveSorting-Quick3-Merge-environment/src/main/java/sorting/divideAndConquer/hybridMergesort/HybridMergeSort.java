package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (!(leftIndex>= array.length || rightIndex > array.length || leftIndex < 0 || leftIndex > rightIndex)) {
			MERGESORT_APPLICATIONS = 0;
			INSERTIONSORT_APPLICATIONS = 0;
			int n = rightIndex - leftIndex;
			if (n <= SIZE_LIMIT) {
				insertion(array, leftIndex, rightIndex);

			} else {
				mergeSort(array, leftIndex, rightIndex);

			}
		}
	}

	private void insertion(T[] arr, int leftIndex, int rightIndex) {
		for (int i = leftIndex+1; i < rightIndex+1; i++) {
			int j = i;
			while (j > leftIndex && arr[j].compareTo(arr[j-1]) <= 0){
				T aux = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = aux;
				j -= 1;

			}
		}
	}
	public void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if (!(leftIndex >= array.length ||rightIndex > array.length || leftIndex < 0 || leftIndex > rightIndex)){
			if (leftIndex < rightIndex) {
				int middle = (leftIndex + rightIndex) / 2;

				mergeSort(array, leftIndex, middle);
				mergeSort(array, middle + 1, rightIndex);
				int n = rightIndex - leftIndex;
				if (n <= SIZE_LIMIT) {
					insertion(array, leftIndex, rightIndex);
				} else {
					merge(array, leftIndex, middle, rightIndex);
				}
			}
		}

	}

	private void merge(T[] array,int leftIndex, int middle, int rightIndex) {
		T[] aux = (T[]) new Comparable[array.length];
		for (int i = leftIndex; i <= rightIndex; i++) {
			aux[i] = array[i];
		}

		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;

		while (i <= middle && j <= rightIndex) {
			if (aux[i].compareTo(aux[j]) < 0) {
				array[k] = aux[i];
				i++;
			} else {
				array[k] = aux[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			array[k] = aux[i];
			i++;
			k++;
		}
		while (j <= rightIndex) {
			array[k] = aux[j];
			j++;
			k++;
		}

	}
}
