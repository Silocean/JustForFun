import java.util.Scanner;

/**
 初始时刻，只有一个“1”组成的字符串被存储到计算机中。在以后的每一个时刻，
 计算机会将当前字符串中的每一个“0”变为“10”，每一个“1”变为“01”。例如，在第一个时刻，字符串将变为“01”，
 在第二个时刻，字符串将变为“1001”，在第三个时刻，字符串将变为“01101001”。
 你的任务是，求出在第n个时刻，字符串中有多少个连续的0对。例如，在第3个时刻，字符串中有1个连续的0对。
 */
public class ComputerTransformation {

	public static int count = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		f(1, new StringBuilder("1"), n);
	}

	/**
	 * 递归求替换之后的字符串
	 * 
	 * @param index
	 * @param sb
	 * @param n
	 */
	private static void f(int index, StringBuilder sb, int n) {
		if (index == n + 1) {
			calculate(sb);
			System.out.println(count);
		} else {
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < sb.length(); i++) {
				char c = sb.charAt(i);
				if (c == '0') {
					temp.append("10");
				} else if (c == '1') {
					temp.append("01");
				}
			}
			f(index + 1, temp, n);
		}
	}

	/**
	 * 计算字符串中连续0的个数
	 * 
	 * @param sb
	 */
	private static void calculate(StringBuilder sb) {
		boolean start = false; // 临时变量，用于判断是否有连续0出现
		boolean end = false; // 临时变量，用于判断是否连续0已结束
		for (int i = 1; i < sb.length(); i++) {
			if (start == false
					&& (sb.charAt(i) == '0' && sb.charAt(i - 1) == '0')) {
				start = true;
			} else if (start == true && (sb.charAt(i) != sb.charAt(i - 1))) {
				count++;
				start = false;
				end = false;
			} else if (start == true
					&& (sb.charAt(i) == '0' && sb.charAt(i - 1) == '0')) {
				end = true;
			} else if (start = true && end == true
					&& (sb.charAt(i) != sb.charAt(i - 1))) {
				count++;
				start = false;
				end = false;
			}
		}
	}

}
