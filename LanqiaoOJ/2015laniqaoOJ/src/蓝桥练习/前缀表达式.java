package 蓝桥练习;

import java.util.Scanner;

public class 前缀表达式 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String s[] = str.split(" ");
		String op = s[0];
		int a = Integer.parseInt(s[1]);
		int b = Integer.parseInt(s[2]);
		System.out.println(calculate(op, a, b));
		sc.close();
	}

	private static int calculate(String op, int a, int b) {
		if(op.equals("+")) {
			return a + b;
		} else if(op.equals("-")) {
			return a - b;
		} else if(op.equals("*")) {
			return a * b;
		} else {
			return a / b;
		}
	}

}
