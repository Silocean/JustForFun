import java.util.Scanner;
/*
 * C代码改编而来，正确性未知
 */
public class Test取球博弈2 {
	public static void main(String[] args) {
		int n, i;
		int[] ball = new int[10001];
		int[] s = new int[100];
		int temp;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (i = 0; i < n; i++)
			s[i] = sc.nextInt();
		ball[1] = 0;
		ball[2] = 1;
		for (i = 3; i <= 10000; i++) {
			if (ball[i - 1] == 0 || ball[i - 3] == 0 || ball[i - 7] == 0
					|| ball[i - 8] == 0)
				ball[i] = 1;
			else
				ball[i] = 0;
		}
		for (i = 0; i < n; i++) {
			temp = s[i];
			System.out.printf("%d\n", ball[temp]);
		}
	}

}
