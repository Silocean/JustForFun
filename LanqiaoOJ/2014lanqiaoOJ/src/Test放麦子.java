
public class Test放麦子 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num = 0;
		for(int i=1; i<=64; i++) {
			num += Math.pow(2, i-1);
		}
		System.out.println(num);
		System.out.println((long)Math.pow(2, 64)-1); //失去精度
	}

}
