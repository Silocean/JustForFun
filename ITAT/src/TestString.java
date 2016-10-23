
public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestString ts = new TestString();
		ts.compare("I am a student", "I am an angle");
		ts.judge("22030219851022024", "220302");
		ts.compareChinese("我", "你");
		ts.changeType("100", "198.236");
		ts.toChar("FEDBCA");
	}
	
	public void compare(String s1, String s2) {
		if(s1.equals(s2)) {
			System.out.println("两个字符串相同");
		} else {
			System.out.println("两个字符串不同");
		}
	}
	
	public void judge(String s1, String s2) {
		if(s1.substring(0, 6).equals(s2)) {
			System.out.println("匹配");
		} else {
			System.out.println("不匹配");
		}
	}
	
	public void compareChinese(String s1, String s2) {
		if(s1.compareTo(s2) < 0) {
			System.out.println(s1 + " " + s2);
		} else {
			System.out.println(s2 + " " + s1);
		}
	}
	
	public void changeType(String s1, String s2) {
		int m = Integer.parseInt(s1);
		double n = Double.parseDouble(s2);
		System.out.print(s1 +" " + s2);
		System.out.println();
	}
	
	public void toChar(String s) {
		char[] c = s.toCharArray();
		for(int i=0; i<c.length; i++) {
			System.out.print(c[i]);
		}
	}

}
