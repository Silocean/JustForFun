public class Test���� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(f(2, 2));
	}
	/*
	 * ����m��A��n��B�����ж��������е�����      AAABB
	 */
	public static int f(int m, int n) {
		if (m == 0 || n == 0) {
			return 1;
		}
		return f(m, n - 1) + f(m - 1, n);
	}

}
