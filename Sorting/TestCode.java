public class TestCode {
	public static void main(String args[]) {
		int[] array = { 111, 3333, 44, 5555, 1000, 11, 19, 21, 31, 0 };

	 RadixSort h = new RadixSort();
	 h.radixSort(array);
	 
	 for(int i : array)
		 System.out.print(i+" ");	 
	}
}
