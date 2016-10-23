import java.util.HashSet;
import java.util.Set;

/**
5.	除去次方数
自然数的平方数是：1 4 9 16 25 …
自然数的立方数是：1 8 27 64 125 …
自然数的4次方数是：1 16 81 256 …
…
这些数字都可以称为次方数。
1~10000中，去掉所有的次方数，还剩下多少个数字？

 */
public class Test除去次方数 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Double> set = new HashSet<Double>();
		for(int index=1; index<=100; index++) {
			for(int n=2; n<=100; n++) {
				double m = Math.pow(index, n);
				if(m<=10000) {
					set.add(m);
				}
			}
		}
		System.out.println(10000-set.size());
	}

}
