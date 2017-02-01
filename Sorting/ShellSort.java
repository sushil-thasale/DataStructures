public class ShellSort {

	public int[] shellSort(int[] array) {
		for (int span = array.length / 2; span > 0; span /= 2) {

			for (int k = span; k < array.length; k++) {

				int temp = array[k];
				int previous = k - span;
				while (previous >= 0 && temp < array[previous]) {
					array[previous + span] = array[previous];
					previous -= span;
				}
				array[previous + span] = temp;
			}
		}
		return array;
	}
}
