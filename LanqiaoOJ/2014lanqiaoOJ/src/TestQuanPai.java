

public class TestQuanPai {
	public static void main(String[] args) {
		String s = "123456789";// 这里是要用到的所有数组成的一个字符串,其它字符同样适用
		char[] c = s.toCharArray();
		new TestQuanPai().zuhe(c, c.length, 0);
		System.out.println("可能的组合数：" + kk);
	}

	static int kk = 0;

	private void zuhe(char[] array, int n, int k) {
		if (n == k) {
			String str = new String(array);
			System.out.println(str);
			++kk;
		} else {
			for (int i = k; i < n; i++) {
				swap(array, k, i);
				zuhe(array, n, k + 1);
				swap(array, i, k);
			}
		}
	}

	private void swap(char[] a, int x, int y) {
		char temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
