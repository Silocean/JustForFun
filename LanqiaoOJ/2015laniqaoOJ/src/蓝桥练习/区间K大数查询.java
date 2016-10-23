package 蓝桥练习;

import java.util.Arrays;
import java.util.Scanner;

public class 区间K大数查询 {

	public static int arr[];

	public static int result[];

	public static int l, r, k;

	public static int max;

	public static int temp[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		result = new int[m];
		for (int i = 0; i < m; i++) {
			l = sc.nextInt();
			r = sc.nextInt();
			k = sc.nextInt();
			calculate(l, r, k, i);
		}
		sc.close();
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}

	private static void calculate(int l, int r, int k, int index) {
		temp = new int[r - l + 1];
		int t = 0;
		for (int i = l - 1; i <= r - 1; i++) {
			temp[t] = arr[i];
			t++;
		}
		Arrays.sort(temp);
		result[index] = temp[temp.length - k];
	}

}
