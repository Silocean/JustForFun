package 蓝桥练习;

import java.util.ArrayList;
import java.util.Scanner;

public class 十六进制转八进制 {
	
	public static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			parse(str);
		}
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		sc.close();
	}

	private static void parse(String str) {
		str = Integer.toOctalString(Integer.valueOf(str, 16));
		list.add(str);
	}

}
