import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
小明这些天一直在思考这样一个奇怪而有趣的问题：
在1~N的某个全排列中有多少个连号区间呢？这里所说的连号区间的定义是：
如果区间[L, R] 里的所有元素（即此排列的第L个到第R个元素）递增排序后能得到一个长度为R-L+1的“连续”数列，则称这个区间连号区间。
当N很小的时候，小明可以很快地算出答案，但是当N变大的时候，问题就不是那么简单了，现在小明需要你的帮助。
输入格式：
第一行是一个正整数N (1 <= N <= 50000), 表示全排列的规模。
第二行是N个不同的数字Pi(1 <= Pi <= N)， 表示这N个数字的某一全排列。
输出格式：
输出一个整数，表示不同连号区间的数目。

示例：
用户输入：
4
3 2 4 1
程序应输出：
7
用户输入：
5
3 4 2 5 1
程序应输出：
9
 */
public class 连号区间数 {

	public static List<Integer> list = new ArrayList<Integer>();

	public static List<Integer> list2 = new ArrayList<Integer>();

	public static int m = 0;

	public static StringBuffer sb = new StringBuffer();

	public static int count = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		m = Integer.parseInt(scan.nextLine());
		Scanner s = new Scanner(scan.nextLine());
		while (s.hasNextInt()) {
			list.add(s.nextInt());
		}
		list2 = new ArrayList<Integer>(list);
		go(0);
		System.out.println(count + m);
	}

	public static void go(int index) {
		if (index == 2) {
			if (sb.charAt(0) < sb.charAt(1)) {
				judge(sb);
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				int temp = list.get(i);
				sb.append(temp);
				list.remove(i);
				go(index + 1);
				list.add(i, temp);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	private static void judge(StringBuffer sb) {
		int L = sb.charAt(0) - 48;
		int R = sb.charAt(1) - 48;
		getMinAndMax(L, R);
	}

	private static void getMinAndMax(int L, int R) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = L - 1; i <= R - 1; i++) {
			if (list2.get(i) < min) {
				min = list2.get(i);
			}
			if (list2.get(i) > max) {
				max = list2.get(i);
			}
		}
		if ((max - min) == (R - L)) {
			count++;
		}
	}

}
