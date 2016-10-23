
public class Test阶乘中1的个数2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[] f = new int[1000];
		int i, j;
		f[0] = 1;
		for (i = 2; i <= n; i++) { /* 乘以i */
			int c = 0;
			for (j = 0; j < 10; j++) {
				int s = f[j] * i + c;
				f[j] = s % 10;
				c = s / 10;
			}
		}
		for (j = 1000 - 1; j >= 0; j--) {
			if(f[j]==0){
				continue;
			}
			for(i=j; i>=0; i--) {
				System.out.print(f[i]);
			}
			break;
		}

	}

}
