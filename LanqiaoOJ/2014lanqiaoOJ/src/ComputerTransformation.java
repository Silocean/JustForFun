import java.util.Scanner;

/**
 ��ʼʱ�̣�ֻ��һ����1����ɵ��ַ������洢��������С����Ժ��ÿһ��ʱ�̣�
 ������Ὣ��ǰ�ַ����е�ÿһ����0����Ϊ��10����ÿһ����1����Ϊ��01�������磬�ڵ�һ��ʱ�̣��ַ�������Ϊ��01����
 �ڵڶ���ʱ�̣��ַ�������Ϊ��1001�����ڵ�����ʱ�̣��ַ�������Ϊ��01101001����
 ��������ǣ�����ڵ�n��ʱ�̣��ַ������ж��ٸ�������0�ԡ����磬�ڵ�3��ʱ�̣��ַ�������1��������0�ԡ�
 */
public class ComputerTransformation {

	public static int count = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		f(1, new StringBuilder("1"), n);
	}

	/**
	 * �ݹ����滻֮����ַ���
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
	 * �����ַ���������0�ĸ���
	 * 
	 * @param sb
	 */
	private static void calculate(StringBuilder sb) {
		boolean start = false; // ��ʱ�����������ж��Ƿ�������0����
		boolean end = false; // ��ʱ�����������ж��Ƿ�����0�ѽ���
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
