package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

import static util.Util.swap;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int min = leftIndex;
		if (array.length < 1){
			return;
		}
		for (int j = leftIndex+1; j < rightIndex +1 ; j++){
			if (array[j].compareTo(array[min]) == -1){
				min = j;
			}
		}
		swap(array, min, leftIndex);
		if (leftIndex +1 < rightIndex){
			sort(array, leftIndex + 1, rightIndex);
		}

	}

}
