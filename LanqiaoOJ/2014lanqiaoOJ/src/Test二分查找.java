import java.util.Scanner;

public class Test¶ş·Ö²éÕÒ {

	public static int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int index = scan.nextInt();
		int min = arr[0];
		int max = arr[arr.length - 1];
		System.out.println(binarySearch(max, min, index));
	}

	public static int binarySearch(int max, int min, int index) {
		while (min < max) {
			int middle = (max + min) / 2;
			if (arr[index] < middle) {
				max = middle;
			} else if (arr[index] > middle) {
				min = middle;
			} else if (arr[index] == middle) {
				return arr[index];
			}
		}
		return -1;
	}

}
