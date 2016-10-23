public class TestReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString("abcde"));
	}

	public static String reverseString(String x) {
		if (x == null || x.length() < 2)
			return x;
		return reverseString(x.substring(1)) + x.charAt(0);
	}

}
