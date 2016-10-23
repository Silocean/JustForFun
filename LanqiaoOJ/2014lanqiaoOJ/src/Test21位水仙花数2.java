import java.math.BigInteger;


public class Test21位水仙花数2 {
	
	public static int[] count = new int[10];
	
	public static int[] count2 = new int[10];
	
	public static BigInteger[] number = new BigInteger[10];

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		init();
		go(0, 0, 0);
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000 + "秒");
	}
	
	public static void init() {
		for(int i=0; i<number.length; i++) {
			number[i] = new BigInteger(String.valueOf(i)).pow(21);
		}
	}
	
	/*
	 * 递归方法找出0~9每个数可能出现的次数
	 */
	public static void go(int index, int use, int num) {
		if(index == 9) {
			count[index] = 21 - use;
			/*for(int i=0; i<count.length; i++) {
				System.out.print(count[i] + " ");
			}
			System.out.println();*/
			judge(number, count);
			for(int i=0; i<10; i++) {
				count2[i] = 0;
			}
			return;
		} else {
			for(int i=0; i<=21-use; i++) {
				count[index] = i;
				go(index+1, use+i, i);
			}
		}
	}
	
	public static void judge(BigInteger[] number, int[] count) {
		boolean flag = true;
		BigInteger sum = BigInteger.ZERO;
		for(int i=0; i<10; i++) {
			sum = sum.add(number[i].multiply(new BigInteger(String.valueOf(count[i]))));
		}
		String str = String.valueOf(sum);
		if(str.length() != 21) {
			return;
		} else {
			for(int i=0; i<str.length(); i++) {
				int m = str.charAt(i) - '0';
				for(int j=0; j<10; j++) {
					if(m==j) {
						count2[j] ++;
					}
				}
			}
			for(int i=0; i<10; i++) {
				if(count[i] != count2[i]) {
					flag = false;
					return;
				}
			}
			if(flag) {
				System.out.println(str);
			}
		}
	}

}
