
public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer("hao");
		add(str);
		System.out.println(str);
	}
	
	public static void add(StringBuffer s) {
		s = s.append("123");
	}

}

