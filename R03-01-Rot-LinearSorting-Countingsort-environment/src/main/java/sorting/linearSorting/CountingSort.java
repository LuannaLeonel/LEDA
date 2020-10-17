package sorting.linearSorting;

import sorting.AbstractSorting;

import java.util.Arrays;

import static util.Util.*;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (!(leftIndex >= array.length || rightIndex > array.length || leftIndex < 0 || leftIndex > rightIndex)) {
			int max = getMax(array, leftIndex, rightIndex);
			Integer[] counting = new Integer[max+1];
			populaArray(counting);

			// frequência
			for (int i = leftIndex; i <= rightIndex; i++) {
				counting[array[i]] ++;
			}


			// cumulativa
			for (int i = 1; i < counting.length; i++) {
				counting[i] += counting[i - 1];
			}

			Integer[] sortedArray = new Integer[array.length];
			populaArray(sortedArray);

			for (int i = rightIndex; i >= leftIndex; i--) {
				sortedArray[counting[array[i]] + leftIndex - 1] = array[i];
				counting[array[i]] -= 1;
			}

			replace(array,sortedArray,leftIndex,rightIndex);
		}
	}





}
