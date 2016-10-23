
public class Test¸ÉÖ§¼ÍÄê {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f(1911);
		f(1985);
		f(2012);
	}
	
	public static void f(int year) {
		String x[] = {"¼×","ÒÒ","±û","¶¡","Îì","¼º","¸ı","ĞÁ","ÈÉ","¹ï"};
		String y[] = {"×Ó","³ó","Òú","Ã®","³½","ËÈ","Îç","Î´","Éê","ÓÏ","Ğç","º¥"};
		int n = year - 1984;
		while(n<0) {
			n = n + 60;
		}
		System.out.println(x[n%10] + y[n%12]);
	}

}
