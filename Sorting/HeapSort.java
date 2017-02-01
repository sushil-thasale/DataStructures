public class HeapSort {

	public void heapSort(int[] array) {
		for (int i = array.length / 2; i >= 0; i--) {
			heapify(array, array.length, i);
		}

		for (int i = array.length - 1; i >= 0; i--) {
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			heapify(array, i, 0);
		}
	}

	private void heapify(int[] array, int length, int parent) {
		int leftSon = parent * 2 + 1;
		int rightSon = parent * 2 + 2;
		int largest = parent;

		// make sure you always compare with array[largest] and not
		// array[parent]
		if (leftSon < length && array[leftSon] > array[largest]) {
			largest = leftSon;
		}

		// make sure you always compare with array[largest] and not
		// array[parent]
		// else it would cause problem when leftSon is the largest, but largest
		// would contain rightSon
		if (rightSon < length && array[rightSon] > array[largest]) {
			largest = rightSon;
		}

		if (largest != parent) {
			int temp = array[parent];
			array[parent] = array[largest];
			array[largest] = temp;
			heapify(array, length, largest);
		}
	}
}