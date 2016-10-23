import java.math.BigInteger;


public class TestÃ·É­ËØÊı {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String str = new BigInteger("2").pow(11213).subtract(new BigInteger("1")).toString();
		 System.out.println(str.substring(str.length()-100, str.length()));
	}

}
