import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**

1/7 = 0.142857142... �Ǹ�����ѭ��С����
�κ������������Ա�ʾΪ����ѭ��С������ʽ��

����ĿҪ���ǣ�����һ�����ֵ�ѭ��С����ʾ����

���磺
���룺
1,5
�������
0.2

���룺
1,7
�������
0.[142857]

���룺
7,6
�����:
1.1[6]

�û�����ĸ�ʽ�ǣ�
����,����

ÿ��������Χ��Ϊ��1~1000

���������������������������С��������ѭ��С����ѭ�����÷��������𣩡�

 */
public class Testѭ��С�� {
	
	public static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] split = scan.nextLine().split(",");
		int m = Integer.parseInt(split[0]);
		int n = Integer.parseInt(split[1]);
		StringBuffer s1 = new StringBuffer();
		StringBuffer s2 = new StringBuffer();
		s1.append(m/n + ".");
		int yushu = m%n;
		list.add(yushu);
		int index = 0;
		boolean flag = true;
		while(flag) {
			while(yushu<n) {
				yushu = yushu * 10;
			}
			s2.append(yushu/n);
			yushu = yushu%n;
			for(int i=0; i<list.size(); i++) {
				if(yushu == list.get(i)) {
					index = i;
					flag = false;
				}
			}
			list.add(yushu);
		}
		s2.insert(index, "[");
		s2.append("]");
		System.out.println(s1.append(s2));
	}

}
