import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
100 可以表示为带分数的形式：100 = 3 + 69258 / 714
还可以表示为：100 = 82 + 3546 / 197
注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。
类似这样的带分数，100 有 11 种表示法。
题目要求：
从标准输入读入一个正整数N (N<1000*1000)
程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
注意：不要求输出每个表示，只统计有多少表示法！

例如：
用户输入：
100
程序输出：
11
再例如：
用户输入：
105
程序输出：
6
 */
public class 带分数 {

	public static List<String> list = new ArrayList<String>();

	public static StringBuffer sb = new StringBuffer();

	public static int num1 = 0;
	public static int num2 = 0;
	public static int num3 = 0;

	public static int count = 0;

	public static int num = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		for (int i = 1; i < 10; i++) {
			list.add(i + "");
		}
		go(0);
		System.out.println(count);
	}

	public static void go(int index) {
		if (index == 9) {
			for (int i = 1; i < sb.length(); i++) {
				num1 = Integer.parseInt(sb.substring(0, i));
				if (num1 > num) {
					break;
				} else {
					for (int j = i + 1; j < sb.length(); j++) {
						num2 = Integer.parseInt(sb.substring(i, j));
						num3 = Integer.parseInt(sb.substring(j, sb.length()));
						if (num1 + num2 / num3 == num && num2 % num3 == 0) {
							count++;
							// System.out.println(num1 + " " + num2 + " " +
							// num3);
						}
					}
				}
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				String temp = list.get(i);
				sb.append(temp);
				list.remove(i);
				go(index + 1);
				list.add(i, temp);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

}
