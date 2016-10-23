package 蓝桥练习;

import java.util.Scanner;

public class 十进制转十六进制 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(Integer.toHexString(n));
	}

}
