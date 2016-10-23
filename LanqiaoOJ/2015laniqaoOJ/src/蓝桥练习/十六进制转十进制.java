package 蓝桥练习;

import java.util.Scanner;

public class 十六进制转十进制 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(Integer.valueOf(str, 16).toString());
		sc.close();
	}

}
