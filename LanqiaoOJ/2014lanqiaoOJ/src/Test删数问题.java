import java.util.Scanner;

/**
键盘输入一个高精度的正整数N（此整数中没有‘0’），去掉其中任意S 个数字后剩下
的数字按原左右次序将组成一个新的正整数。编程对给定的N 和S，寻找一种方案使得剩下
的数字组成的新数最小。
输出应包括所去掉的数字的位置和组成的新的正整数。（N 不超过240位）
输入数据均不需判错。
【输入】
n
s
【输出】最后剩下的最小数。
【样例输入】
175438
4
【样例输出】
13
 */
public class Test删数问题 {
	
	static int len = 0;
	
	static int n = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		StringBuffer sb = new StringBuffer(str);
		len = sb.length();
		n = scan.nextInt();
		deleteStr(sb);
	}

	private static void deleteStr(StringBuffer sb) {
		if(sb.length() == len-n) {
			System.out.println(sb);
			return;
		} else {
			int i=0;
			while(sb.charAt(i)<sb.charAt(i+1)) {
				i ++;
			}
			sb.deleteCharAt(i);
			deleteStr(sb);
		}
	}

}
