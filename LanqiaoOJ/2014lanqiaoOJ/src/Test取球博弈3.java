import java.util.Scanner;
/*
 * ²»¶®
 */
public class TestÈ¡Çò²©ÞÄ3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int m = sc.nextInt();
			System.out.println(fun(m));
		}

	}

	public static boolean fun(int n) {
		n %= 15;
		if (n == 0)
			return true;
		return ((n >= 8 && !fun(n - 8)) || (n >= 7 && !fun(n - 7))
				|| (n >= 3 && !fun(n - 3)) || (n >= 1 && !fun(n - 1)));
	}
}
