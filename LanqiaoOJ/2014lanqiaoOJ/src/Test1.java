import java.util.*;

public class Test1 {
	private static LinkedList<String> str = new LinkedList<String>();
	
	public static void main(String[] args) {
		int input = 6;
		Test1.integerDivide(input, input);
	}

	public static void integerDivide(int limit, int max) {
		if (1 == max) {
			str.add(String.valueOf(1));
			formatResult(str);
			str.removeLast();
			return;
		}
		if (0 == max) {
			formatResult(str);
			return;
		}
		for (int i = limit; i >= 1; --i) {
			if (i <= max) {
				str.add(String.valueOf(i));
				integerDivide(i, max - i);
				str.removeLast();
			}
		}
	}

	
	public static void formatResult(LinkedList<String> s) {
		System.out.print(s.getFirst());
		for (int i = 1; i < s.size(); i++)
			System.out.print("+" + s.get(i));
		System.out.println();
	}
}
