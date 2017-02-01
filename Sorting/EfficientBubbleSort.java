public class EfficientBubbleSort {

	public int[] sort(int[] array) {
		boolean swapped = false;
		for (int i = 0; i < array.length; i++) {
			swapped = false;
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					// check if array is already sorted
					swapped = true;
				}
			}
			// if array is already sorted then break
			if (!swapped)
				break;
		}
		return array;
	}
}
