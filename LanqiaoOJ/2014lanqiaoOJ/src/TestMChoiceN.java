import java.util.Scanner;

public class TestMChoiceN {

	public static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		// f1();
		// f2();
		Scanner sc = new Scanner(System.in);
		int m = Integer.parseInt(sc.nextLine());
		int n = Integer.parseInt(sc.nextLine());
		f3(0, m, n);
		//f4(0, m, n, 0);
	}

	/*
	 * 递归解法2
	 */
	private static void f4(int index, int m, int n, int k) {
		if (index == n) {
			System.out.println(sb);
			return;
		} else {
			for (int i = 1 + k; i <= m - n + 1 + index; i++) {
				sb.append(i);
				f4(index + 1, m, n, i);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	/*
	 * 递归解法1
	 */
	private static void f3(int index, int m, int n) {
		if (index == n) {
			boolean flag = true;
			for (int i = 0; i < n - 1; i++) {
				if (sb.charAt(i) >= sb.charAt(i + 1)) {
					flag = false;
				}
			}
			if (flag) {
				System.out.println(sb);
			}
			return;
		} else {
			for (int i = 1; i <= m; i++) {
				sb.append(i);
				f3(index + 1, m, n);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	/**
	 * 方法不具有拓展性
	 */
	private static void f1() {
		for (int i = 5; i > 0; i--) {
			for (int j = 5; j > 0; j--) {
				for (int k = 5; k > 0; k--) {
					if (i > j && j > k) {
						System.out.println("" + i + j + k);
					}
				}
			}
		}
	}

	/**
	 * 方法不具有拓展性
	 */
	private static void f2() {
		for (int i = 1; i <= 3; i++) {
			for (int j = i + 1; j <= 4; j++) {
				for (int k = j + 1; k <= 5; k++) {
					System.out.println("" + i + j + k);
				}
			}
		}
	}

}
