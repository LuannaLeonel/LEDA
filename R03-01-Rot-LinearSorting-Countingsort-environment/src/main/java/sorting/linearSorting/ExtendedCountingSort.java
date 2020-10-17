package sorting.linearSorting;

import sorting.AbstractSorting;

import java.util.Arrays;

import static util.Util.*;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length > 0) {
			int max = getMax(array, leftIndex, rightIndex);
			int min = getMin(array, leftIndex, rightIndex);
			int range = (max - min) + 1;

			Integer[] counting = new Integer[range];
			populaArray(counting);
			Integer[] sorted = new Integer[array.length];
			populaArray(sorted);

			for(int i = leftIndex;i <= rightIndex; i++){
				counting[array[i] - min]++;
			}
			for (int i = 1; i < counting.length; i++) {
				counting[i] += counting[i-1];
			}
			for (int i = rightIndex; i >= leftIndex; i--) {
				sorted[counting[array[i] - min] + leftIndex - 1] = array[i];
				counting[array[i] - min]--;
			}

			replace(array,sorted,leftIndex,rightIndex);
		}
	}
}
