
public class TestStringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ÄãºÃ";
		/*
		char[] c = new char[2];
		s.getChars(0, s.length(), c, 0);
		for(int i=c.length-1; i>=0; i--) {
			System.out.print(c[i]);
		}
		*/
		
		char[] c = s.toCharArray();
		for(int i=c.length-1; i>=0; i--) {
			System.out.print(c[i]);
		}
		System.out.print(c.length);
	}

}
