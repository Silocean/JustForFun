import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
100 ���Ա�ʾΪ����������ʽ��100 = 3 + 69258 / 714
�����Ա�ʾΪ��100 = 82 + 3546 / 197
ע���������������У�����1~9�ֱ������ֻ����һ�Σ�������0����
���������Ĵ�������100 �� 11 �ֱ�ʾ����
��ĿҪ��
�ӱ�׼�������һ��������N (N<1000*1000)
�������������������1~9���ظ�����©����ɴ�������ʾ��ȫ��������
ע�⣺��Ҫ�����ÿ����ʾ��ֻͳ���ж��ٱ�ʾ����

���磺
�û����룺
100
���������
11
�����磺
�û����룺
105
���������
6
 */
public class ������ {

	public static List<String> list = new ArrayList<String>();

	public static StringBuffer sb = new StringBuffer();

	public static int num1 = 0;
	public static int num2 = 0;
	public static int num3 = 0;

	public static int count = 0;

	public static int num = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		for (int i = 1; i < 10; i++) {
			list.add(i + "");
		}
		go(0);
		System.out.println(count);
	}

	public static void go(int index) {
		if (index == 9) {
			for (int i = 1; i < sb.length(); i++) {
				num1 = Integer.parseInt(sb.substring(0, i));
				if (num1 > num) {
					break;
				} else {
					for (int j = i + 1; j < sb.length(); j++) {
						num2 = Integer.parseInt(sb.substring(i, j));
						num3 = Integer.parseInt(sb.substring(j, sb.length()));
						if (num1 + num2 / num3 == num && num2 % num3 == 0) {
							count++;
							// System.out.println(num1 + " " + num2 + " " +
							// num3);
						}
					}
				}
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				String temp = list.get(i);
				sb.append(temp);
				list.remove(i);
				go(index + 1);
				list.add(i, temp);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

}
