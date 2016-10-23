public class Test找雷算法 {

	public static int[][] a = { { 0, 1, 0, 1, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0, 0, 0, 1 },
			{ 0, 1, 0, 1, 0, 0, 1, 0 } };

	public static int count = 0;

	public static int max = 0;

	public static void main(String[] args) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				// System.out.print(a[i][j] + " ");
				findMines(i, j);
				if (count > max) {
					max = count;
				}
			}
		}

		System.out.println(max);
	}

	private static void findMines(int i, int j) {
		if (a[i][j] == 0) {
			// 如果此处为零，将其设为1，避免往外找的时候，重复计算，造成死循环
			a[i][j] = 1;
			count++;
			if (i >= 1 && a[i - 1][j] == 0) {
				findMines(i - 1, j);
			}
			if (j < a[0].length - 1 && a[i][j + 1] == 0) {
				findMines(i, j + 1);
			}
			if (i < a.length - 1 && a[i + 1][j] == 0) {
				findMines(i + 1, j);
			}
			if (j >= 1 && a[i][j - 1] == 0) {
				findMines(i, j - 1);
			}
		} else {
			count = 0;
			return;
		}
	}

}
