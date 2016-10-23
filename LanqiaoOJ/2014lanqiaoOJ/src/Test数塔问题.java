import java.util.Scanner;


public class TestÊıËşÎÊÌâ {
	
	public static int[][] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		a = new int[n][n];
		for(int i=0; i<n; i++) {
			String str = sc.nextLine();
			fillArray(str, i);
		}
		
		for(int i=n-2; i>=0; i--) {
			for(int j=0; j<i+1; j++) {
				a[i][j] = (a[i][j]+a[i+1][j]) > (a[i][j]+a[i+1][j+1]) ? (a[i][j]+a[i+1][j]) : (a[i][j]+a[i+1][j+1]);
			}
		}
		
		System.out.println(a[0][0]);
		
 	}

	private static void fillArray(String str, int i) {
		String split[] = str.split(" ");
		int[] arr = new int[split.length];
		for (int k = 0; k < arr.length; k++) {
			a[i][k] = Integer.parseInt(split[k]);
		}
	}

}
