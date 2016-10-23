
public class TestCount1 {
	
	public static int count = 0;

	public static void main(String[] args) {
		for(int i=0; i<=1000; i++) {
			count(i+"");
		}
		System.out.println(count);
	}

	private static void count(String str) {
		for(int i=0; i<str.length(); i++) {
			if (str.charAt(i)=='1') {
				count ++;
			}
		}
	}

}
