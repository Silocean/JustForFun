public class Test第一个数字 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getFirstNum("abc494us43"));
	}

	public static int getFirstNum(String s) {
		if (s == null || s.length() == 0)
			return -1;

		char c = s.charAt(0);
		if (c >= '0' && c <= '9') {
			return c-48; // 填空
		} else {
			return getFirstNum(s.substring(1)); // 填空
		}

	}

}
