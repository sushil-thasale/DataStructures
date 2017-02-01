public class InsertionSort {

	public int[] sort(int array[]) {

		int i = 0, j = 0;
		for (i = 1; i < array.length; i++) {
			int y = array[i];
			for (j = i - 1; j >= 0 && y < array[j]; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = y;
		}

		return array;
	}
}
