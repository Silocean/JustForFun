import java.text.DecimalFormat;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*char a = '4';
		if(a>='0'&&a<='9') {
			System.out.println(a);
		}*/
		
		/*int a = 0; 
		int b = 2;
		if(a == 0) {
			if(b == 9) {
				System.out.println("you are right!");
			}
		} else {
			System.out.println("+++++++++++++++++++");
		}*/
		String pattern = "#.##";
		DecimalFormat df = new DecimalFormat(pattern);
		//System.out.println(df.format(3.4));
		//System.out.println(String.format("%.2f", 100.0, 25.368));
		System.out.println(2.0/7);
	}
}
