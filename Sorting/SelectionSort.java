public class SelectionSort {

	public int[] sort(int array[]) {

		int min = 0, min_index = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int temp = array[i];
			min = array[i];
			min_index = i;

			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
					min_index = j;
				}
			}
			array[i] = min;
			array[min_index] = temp;
		}

		return array;
	}
}
