public class RecursiveQuickSort {

	public void quickSort(int[] array, int lb, int ub) {

		if (ub <= lb)
			return;

		int pivot = partition(array, lb, ub);
		quickSort(array, lb, pivot - 1);
		quickSort(array, pivot + 1, ub);
	}

	/*
	 * @array - array to sorted
	 * 
	 * @lb - lower bound
	 * 
	 * @ub - upper bound
	 */
	public int partition(int[] array, int lb, int ub) {
		int pivot = array[lb];
		int down = lb;
		int up = ub;

		while (down < up) {
			while (array[down] <= pivot && down < up)
				down++;

			while (array[up] > pivot)
				up--;

			if (up > down) {
				int temp = array[up];
				array[up] = array[down];
				array[down] = temp;
			}
		}
		array[lb] = array[up];
		array[up] = pivot;
		return up;
	}

	public int[] sort(int[] array) {
		quickSort(array, 0, array.length - 1);
		return array;
	}
}
