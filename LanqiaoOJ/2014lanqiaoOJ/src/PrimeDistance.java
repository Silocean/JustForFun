import java.util.ArrayList;
import java.util.Scanner;

/**
���p1��p2��p1< p2����Ϊ����������������p��p1< p< p2����������������˵����p1��p2�����ڵģ�
����������֮��ľ���Ϊd= p2 - p1������������L��U���������[L, U]�о�����С��������������C1��C2�;�������������������D1��D2��
���磬L=2��U=17ʱ��C1=2��C2=3��D1=7��D2=11��
 */
public class PrimeDistance {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int c1 = 0;
		int c2 = 0;
		int d1 = 0;
		int d2 = 0;
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int L = Integer.parseInt(str.split(" ")[0]);
		int R = Integer.parseInt(str.split(" ")[1]);
		for (int i = L; i <= R; i++) {
			if (isPrime(i)) {
				list.add(i);
			}
		}
		for (int i = 1; i < list.size(); i++) {
			if ((list.get(i) - list.get(i - 1)) > max) {
				max = list.get(i) - list.get(i - 1);
				d1 = list.get(i - 1);
				d2 = list.get(i);
			}
			if ((list.get(i) - list.get(i - 1)) < min) {
				min = list.get(i) - list.get(i - 1);
				c1 = list.get(i - 1);
				c2 = list.get(i);
			}
		}
		System.out
				.println("c1=" + c1 + ",c2=" + c2 + ",d1=" + d1 + ",d2=" + d2);
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
