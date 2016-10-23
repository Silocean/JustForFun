import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
С����Щ��һֱ��˼������һ����ֶ���Ȥ�����⣺
��1~N��ĳ��ȫ�������ж��ٸ����������أ�������˵����������Ķ����ǣ�
�������[L, R] �������Ԫ�أ��������еĵ�L������R��Ԫ�أ�����������ܵõ�һ������ΪR-L+1�ġ����������У������������������䡣
��N��С��ʱ��С�����Ժܿ������𰸣����ǵ�N����ʱ������Ͳ�����ô���ˣ�����С����Ҫ��İ�����
�����ʽ��
��һ����һ��������N (1 <= N <= 50000), ��ʾȫ���еĹ�ģ��
�ڶ�����N����ͬ������Pi(1 <= Pi <= N)�� ��ʾ��N�����ֵ�ĳһȫ���С�
�����ʽ��
���һ����������ʾ��ͬ�����������Ŀ��

ʾ����
�û����룺
4
3 2 4 1
����Ӧ�����
7
�û����룺
5
3 4 2 5 1
����Ӧ�����
9
 */
public class ���������� {

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
