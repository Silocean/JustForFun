import java.io.IOException;
import java.util.Scanner;

public class TestÂİĞı¾ØÕó {
	private static int[][] store = new int[101][101];

	public static void f(int row, int length, int start) {
		int i;
		for (i = 0; i < length; i++) {
			store[row][row + i] = start;
			start++;
		}
		for (i = 1; i < length; i++) {
			store[row + i][row + length - 1] = start;
			start++;
		}
		for (i = length - 2; i >= 0; i--) {
			store[row + length - 1][row + i] = start;
			start++;
		}
		for (i = length - 2; i > 0; i--) {
			store[row + i][row] = start;
			start++;
		}
		if (length == 1 || length == 2)
			return;
		f(row + 1, length - 2, start);
	}

	public static void print(int[][] store, int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				System.out.printf("%4d", store[i][j]);
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner br = new Scanner(System.in);
		String str = br.nextLine();
		int n = Integer.parseInt(str);
		f(1, n, 1);
		print(store, n);
	}
}
