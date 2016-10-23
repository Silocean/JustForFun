import java.math.BigInteger;


public class Test阶乘中1的个数 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger sum = new BigInteger("1");
		for(int i=1; i<=1000; i++) {
			sum = sum.multiply(new BigInteger(i+""));
		}
		int count = 0;
		String str = sum+"";
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='1') {
				count ++;
			}
		}
		System.out.println(count);
	}

}
