
public class TestEgg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double x_price, y_price;
		
		for(int i=1; i<=150; i++) {
			/*x_price = 24.5/(150-i);
			y_price = 32/i;*/
			if(i*24.5/(150-i) == (150-i)*32/i) {
				System.out.println(i + "," + (150-i));
			}
		}
	}

}
