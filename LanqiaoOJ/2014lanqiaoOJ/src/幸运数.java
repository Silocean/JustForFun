import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 未完成
 * 
 * @author Administrator
 * 
 */

public class 幸运数 {

	public static int start = 0;
	public static int end = 0;

	public static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner s = new Scanner(scan.nextLine());
		while (s.hasNextInt()) {
			start = s.nextInt();
			end = s.nextInt();
		}
		for (int i = 1; i <= 20; i++) {
			list.add(i);
		}
		go(1);
	}

	public static void go(int n) {
		int m = list.get(n);
		if (n > end) {
			System.out.println(list);
		} else {
			for (int i = 1; i < list.size(); i++) {
				if ((i + 1) % m == 0) {
					list.set(i, 0);
					System.out.println(list);
				}
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == 0) {
					list.remove(i);
				}
			}
			System.out.println(list);
			go(n + 1);
		}
	}

}
