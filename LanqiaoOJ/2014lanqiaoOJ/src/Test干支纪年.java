
public class Test��֧���� {

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
		String x[] = {"��","��","��","��","��","��","��","��","��","��"};
		String y[] = {"��","��","��","î","��","��","��","δ","��","��","��","��"};
		int n = year - 1984;
		while(n<0) {
			n = n + 60;
		}
		System.out.println(x[n%10] + y[n%12]);
	}

}
