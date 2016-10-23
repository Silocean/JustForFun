package 蓝桥练习;

import java.util.Scanner;

public class 特殊回文数 {

	public static String str;

	public static int start, end;

	public static int flag;

	public static int sum;

	public static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 10000; i <= 999999; i++) {
			if (judge(i)) {
				System.out.println(i);
			}
		}
		sc.close();
	}

	private static boolean judge(int i) {
		sum = 0;
		flag = 0;
		str = String.valueOf(i);
		for (int j = 0; j < str.length(); j++) {
			sum += str.charAt(j) - '0';
		}
		if (sum == n) {
			start = 0;
			end = str.length()-1;
			while (start < end) {
				if (str.charAt(start) != str.charAt(end)) {
					flag = 1;
				}
				start++;
				end--;
			}
			if (flag == 0) {
				return true;
			}
		}
		return false;
	}

}
