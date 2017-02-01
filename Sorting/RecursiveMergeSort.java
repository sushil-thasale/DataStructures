public class RecursiveMergeSort {

	public void mergeSort(int[] array, int lb, int ub) {

		if (ub <= lb)
			return;

		int mid = (int) Math.ceil((ub + lb) / 2);
		mergeSort(array, lb, mid);
		mergeSort(array, mid + 1, ub);
		merge(array, lb, mid, ub);
	}

	public void merge(int[] array, int lb, int mid, int ub) {

		int temp[] = new int[ub - lb + 1];
		int i = lb;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= ub) {
			if (array[i] <= array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}

		while (i <= mid) {
			temp[k++] = array[i++];
		}

		while (j <= ub)
			temp[k++] = array[j++];

		k = lb;
		for (i = 0; i < temp.length; i++)
			array[k++] = temp[i];
	}

	public void sort(int[] array) {
		mergeSort(array, 0, array.length-1);
	}

}
