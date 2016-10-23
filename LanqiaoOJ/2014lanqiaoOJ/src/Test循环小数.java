import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**

1/7 = 0.142857142... 是个无限循环小数。
任何有理数都可以表示为无限循环小数的形式。

本题目要求即是：给出一个数字的循环小数表示法。

例如：
输入：
1,5
则输出：
0.2

输入：
1,7
则输出：
0.[142857]

输入：
7,6
则输出:
1.1[6]

用户输入的格式是：
整数,整数

每个整数范围均为：1~1000

程序输出两个整数做除法产生的小数或无限循环小数（循环节用方括号括起）。

 */
public class Test循环小数 {
	
	public static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] split = scan.nextLine().split(",");
		int m = Integer.parseInt(split[0]);
		int n = Integer.parseInt(split[1]);
		StringBuffer s1 = new StringBuffer();
		StringBuffer s2 = new StringBuffer();
		s1.append(m/n + ".");
		int yushu = m%n;
		list.add(yushu);
		int index = 0;
		boolean flag = true;
		while(flag) {
			while(yushu<n) {
				yushu = yushu * 10;
			}
			s2.append(yushu/n);
			yushu = yushu%n;
			for(int i=0; i<list.size(); i++) {
				if(yushu == list.get(i)) {
					index = i;
					flag = false;
				}
			}
			list.add(yushu);
		}
		s2.insert(index, "[");
		s2.append("]");
		System.out.println(s1.append(s2));
	}

}
