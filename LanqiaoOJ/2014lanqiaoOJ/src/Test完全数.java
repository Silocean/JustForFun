import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test完全数 {

	public static void main(String[] args) {
		// method1();
		method2();
	}

	private static void method1() {

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 2; i <= 1000; i++) {
			int sum = 1;
			for (int j = 2; j < i / 2; j++) {
				if (i % j == 0) {
					set.add(j);
					set.add(i / j);
				}
			}
			Iterator<Integer> it = set.iterator();
			while (it.hasNext()) {
				sum += it.next();
			}
			if (sum == i) {
				System.out.println(i);
			}
			set.removeAll(set);
		}
	}

	private static void method2() {

		System.out.println("1到1000的完数有： ");
		for (int i = 1; i < 1000; i++) {
			int t = 0;
			for (int j = 1; j <= i / 2; j++) {
				if (i % j == 0) {
					t = t + j;
				}
			}
			if (t == i) {
				System.out.print(i + "     ");
			}
		}
	}

}
