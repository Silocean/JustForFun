package À¶ÇÅÁ·Ï°;

import java.util.Scanner;

public class FibonacciÊıÁĞ {
	
	public static int arr[] = new int[1000001];

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		int n = new Scanner(System.in).nextInt();
		//System.out.println(fibonacci(n));
		arr[1] = arr[2] = 1;
		for(int i=3; i<=n; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 10007;
		}
		System.out.println(arr[n]);
	}
	
	/*private static int fibonacci(int index) {
		if(index == 1 || index == 2) {
			return 1;
		} else {
			return (fibonacci(index-1) + fibonacci(index-2)) % 10007;
		}
	}*/

}
