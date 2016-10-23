
public class Test数量周期 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = Math.random();
		double r = 3.62;
		while(true) {
			x = x*(1-x)*r;
			System.out.println(x);
		}
	}

}
