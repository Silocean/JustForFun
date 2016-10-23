public class Test信用卡校验 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "5432123456788881";
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				int m = Integer.parseInt(s.substring(i, i + 1)) * 2;
				if (m > 9) {
					m = m - 9;
				}
				sum1 = sum1 + m;
			} else {
				int n = Integer.parseInt(s.substring(i, i + 1));
				sum2 = sum2 + n;
			}
		}
		if ((sum1 + sum2) % 10 == 0) {
			System.out.println("成功");
		}
	}

}
