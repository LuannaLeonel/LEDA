package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;

import java.util.Arrays;

import static util.Util.swap;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (!(leftIndex >= array.length ||rightIndex > array.length || leftIndex < 0 || leftIndex > rightIndex)){
			if (leftIndex < rightIndex) {
				int p = partition(array, leftIndex, rightIndex);

				sort(array, leftIndex, p);
				sort(array, p + 1, rightIndex);
			}
		}

	}
	public int partition(T[] array, int low, int high){

		mediana(array,low,high);
		T pivot = array[high -1];
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
	public void mediana(T[] arr, int left, int right){
		int middle = (left + right)/2;
		T [] three = (T[]) new Comparable[3];
		three[0] = arr[left];
		three[1] = arr[right];
		three[2] = arr[middle];
		Arrays.sort(three);
		int x = right;
		if (three[1] == arr[left] )
			x = left;
		else if (three[1] == arr[middle])
			x = middle;
		swap(arr,right-1,x);

	}

}
