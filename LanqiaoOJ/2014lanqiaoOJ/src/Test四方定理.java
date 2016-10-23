import java.util.Scanner;


public class Test四方定理 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = new Scanner(System.in).nextInt();
		int[] a = {0, 0, 0, 0};
		go(m, a, 0);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static boolean go(int m, int[] a, int i) {
		if(m == 0) return true;
		if(i == 4) return false;
		for(int k=(int)Math.sqrt(m); k>=1; k--) {
			a[i] = k;
			if(go(m-k*k, a, i+1)) {
				return true;
			}
		}
		return false;
	}
	
}
