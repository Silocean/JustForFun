import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**

��˾����ĳ�̵�Ĺ���ȯ1000Ԫ���޶�ֻ�ܹ�����е�m����Ʒ��ÿ����Ʒ�ļ۸�ֱ�Ϊm1,m2,������
Ҫ������г����е�������������ù���ȯ�Ĳ�ͬ���﷽����

�������룺
��һ����һ������m������ɹ������Ʒ����������
��������m��������ÿ��1�У��ֱ������m����Ʒ�ĵ���(0<m<1000)��
���������
	��һ����һ����������ʾ���ж����ַ���
	�ڶ��п�ʼ��ÿ�ַ���ռ1�У���ʾ��ÿ����Ʒ������������м��ÿո�ָ���
���磺

���룺
2
200
300
��Ӧ�����
2
2  2
5  0

���룺
2
500
800
��Ӧ�����
1
2  0

���룺
1
999
��Ӧ�����
0

����������˳����Ҫ��

 */
public class Test����ȯ {

	static int min = 1000;

	static int m = 0;

	static int[] arr;

	static int total = 0;

	static int count = 0;

	static List<Integer> result = new ArrayList<Integer>();

	static List<List<Integer>> list = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(scan.nextLine());
			arr[i] = num;
			if (num < min) {
				min = num;
			}
		}
		m = 1000 / min;
		fun(0);
		if (count == 0) {
			System.out.println(0);
		} else {
			System.out.println(count);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.get(i).size() - 1; j++) {
					System.out.print(list.get(i).get(j) + " ");
				}
				System.out.println(list.get(i).get(list.get(i).size() - 1));
			}
		}
	}

	private static void fun(int index) {
		if (index == arr.length) {
			if (total == 1000) {
				list.add(new ArrayList<Integer>(result));// ע��Ҫ����result
				count++;
			}
			return;
		} else
			for (int i = 0; i <= m; i++) {
				total += arr[index] * i;
				result.add(i);
				fun(index + 1);
				result.remove(result.size() - 1);
				total -= arr[index] * i;
			}
	}

}
