import java.math.BigInteger;


public class Test21位水仙花数 {
	
	public static BigInteger[] num = new BigInteger[21];
	
	public static BigInteger[] pow = new BigInteger[10];
	
	public static int[] arr = new int[21];

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		init();
		for(int i=0; i<pow.length; i++) {
			go(0, i);
		}
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000 + "秒");
	}
	
	public static void init() {
		for(int i=0; i<pow.length; i++) {
			pow[i] = new BigInteger(String.valueOf(i)).pow(21);
		}
	}
	
	public static void go(int index, int m) {
		
		num[index] = pow[m];
		
		arr[index] = m;
		
		if(index == 20) {
			if(sum(num).equals(toChars(arr))) {
				System.out.println(toChars(arr));
			}
			return;
		} else {
			for(int i=0; i<pow.length; i++) {
				go(index+1, i);
			}
		}
	}
	
	public static String sum(BigInteger[] num) {
		BigInteger sum = new BigInteger("0");
		for(int i=0; i<num.length; i++) {
			sum = sum.add(num[i]);
		}
		return sum.toString();
	}
	
	public static String toChars(int[] arr) {
		String str = "";
		for(int i=0; i<arr.length; i++) {
			str += arr[i];
		}
		return str;
	}

}
