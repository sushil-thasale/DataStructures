public class NonRecursiveQuickSort {

	public void quickSort(int[] array, int lb, int ub) {

		DoubleStack stack = new DoubleStack(1000);
		stack.push(lb);
		stack.push(ub);
		while (!stack.isEmpty()) {

			int up = stack.pop().intValue();
			int down = stack.pop().intValue();

			if (down <= up) {
				int pivot = partition(array, down, up);
				stack.push(down);
				stack.push(pivot - 1);
				stack.push(pivot + 1);
				stack.push(up);
			}
		}
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
