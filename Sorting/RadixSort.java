import java.util.ArrayList;

public class RadixSort {

	ArrayList<ArrayList<Integer>> bucketList;

	public RadixSort() {
		bucketList = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			bucketList.add(new ArrayList<Integer>());
	}

	public int[] radixSort(int[] array) {
		int d = 0;
		for (int i = 0; i < array.length; i++) {
			if (("" + array[i]).length() > d)
				d = ("" + array[i]).length();
		}

		for (int digit = 1; digit <= d; digit++) {
			for (int i = 0; i < array.length; i++) {
				int x = getDigit(array[i], digit);
				bucketList.get(x).add(array[i]);
			}

			int k = 0;
			for (ArrayList<Integer> list : bucketList) {
				for (int num : list)
					array[k++] = num;
			}

			for (ArrayList<Integer> list : bucketList)
				list.clear();
		}

		return array;
	}

	private int getDigit(int number, int digit) {
		String num = String.valueOf(number);

		if (num.length() < digit)
			return 0;
		else
			return Integer.parseInt((new StringBuffer(num)).reverse().charAt(
					digit - 1)
					+ "");
	}
}
