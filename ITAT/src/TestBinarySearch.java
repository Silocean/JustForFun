public class TestBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 9, 5, 3, 2, 1, 7, 6, 4, 0, 2 };
		int i = 4;
		System.out.println(binarySearch(arr, i));
	}

	public static int binarySearch(int[] arr, int num) {
		int startPos = 0;
		int endPos = arr.length - 1;
		int m = (startPos + endPos) / 2;
		while(startPos<=endPos) {
			if (num == arr[m]) {
				return m;
			}
			if (num > arr[m]) {
				startPos = m + 1;
			}
			if (num < arr[m]) {
				endPos = m - 1;
			}
			m = (startPos + endPos) / 2;
		}
		return -1;
		
	}

}