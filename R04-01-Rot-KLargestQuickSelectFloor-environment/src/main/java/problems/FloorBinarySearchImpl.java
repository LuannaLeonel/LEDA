package problems;

import util.Util;

import static util.Util.swap;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if(array.length > 0) {
			quickSortM3(array,0,array.length-1);

			return recursiveFloor(array,x,null,0,array.length - 1);
		}
		return null;
	}

	private Integer recursiveFloor(Integer[] array, Integer x, Integer floor, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex) {
			int middleIndex = (leftIndex + rightIndex)/2;

			if (array[middleIndex].compareTo(x) > 0) {
				return recursiveFloor(array, x,floor,leftIndex,middleIndex-1);
			} else if (array[middleIndex].compareTo(x) < 0) {
				return recursiveFloor(array, x, array[middleIndex], middleIndex +1,rightIndex);
			}
			return array[middleIndex];

		}
		return floor;
	}



	private void quickSortM3(Integer[] array, int leftIndex, int rightIndex) {
		if (!(leftIndex >= array.length ||rightIndex > array.length || leftIndex < 0 || leftIndex > rightIndex)){
			if (leftIndex < rightIndex) {
				int p = partition(array, leftIndex, rightIndex);

				quickSortM3(array, leftIndex, p);
				quickSortM3(array, p + 1, rightIndex);
			}
		}

	}
	public int partition(Integer[] array, int low, int high){
		mediana(array,low,high);
		Integer pivot = array[high -1];
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
	public void mediana(Integer[] arr, int left, int right){
		int meio = (left+right)/2;
		if(arr[left].compareTo(arr[meio]) > 0) {
			Util.swap(arr,left, meio);
		}
		if(arr[left].compareTo(arr[right]) > 0) {
			Util.swap(arr, left, right);
		}
		if(arr[meio].compareTo(arr[right]) > 0) {
			Util.swap(arr,meio ,right );
		}
	}

}
