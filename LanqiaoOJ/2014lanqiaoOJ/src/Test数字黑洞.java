import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**

����һ��5λ�������磺34256�������ĸ�λ���ִ��ң��������У����Եõ�һ����������65432��һ����С����23456��
�����������ֵĲ�ã�41976������������ٴ��ظ��������̣��������5λ����ǰ�߲�0����
������������ֻ�����ĳ��ѭ��Ȧ����Ϊ���ֺڶ�����
���磬�ղŵ����ֻ����룺[82962, 75933, 63954, 61974] ���ѭ��Ȧ��

���д�����ҵ�5λ�����п��ܵ�ѭ��Ȧ���������ÿ��ѭ��Ȧռ1�С�����5λ��ȫ����ͬ��ѭ��ȦΪ [0]��������Բ����ǡ�

ѭ��Ȧ�������ʽ���գ�
[82962, 75933, 63954, 61974]

�������ֵ��Ⱥ�˳����Բ����ǡ�

 */
public class Test���ֺڶ� {

	static int index = 0;
	static List<String> list = new ArrayList<String>();
	static Set<String> set = new HashSet<String>();

	public static void main(String[] args) {
		/*for (int i = 10000; i <= 99999; i++) {
			f("" + i);
		}*/
		f("34256");
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("�ܹ��У�" + set.size() + "��");
	}

	public static void print() {
		String str = "[";
		for (int i = index; i < list.size(); i++) {
			if (i == list.size() - 1) {
				str += list.get(i);
			} else {
				str += list.get(i) + ",";
			}
		}
		str += "]";
		set.add(str);
	}

	public static void f(String num) {
		String s = num;
		String sMax = "", sMin = "";
		int arrInt[] = new int[s.length()];
		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = Integer.parseInt(s.split("")[i]);
		}
		for (int i = 0; i < arrInt.length; i++) {
			for (int j = i + 1; j < arrInt.length; j++) {
				if (arrInt[j] < arrInt[i]) {
					int temp = arrInt[i];
					arrInt[i] = arrInt[j];
					arrInt[j] = temp;
				}
			}
		}
		for (int i = 0; i < arrInt.length; i++) {
			sMin += arrInt[i];
		}
		int min = Integer.parseInt(sMin);
		for (int i = 0; i < arrInt.length; i++) {
			for (int j = i + 1; j < arrInt.length; j++) {
				if (arrInt[j] > arrInt[i]) {
					int temp = arrInt[i];
					arrInt[i] = arrInt[j];
					arrInt[j] = temp;
				}
			}
		}
		for (int i = 0; i < arrInt.length; i++) {
			sMax += arrInt[i];
		}
		int max = Integer.parseInt(sMax);

		String result = "" + (max - min);

		for (int k = 0; k < list.size(); k++) {
			if (result.equals(list.get(k))) {
				index = k;
				print();
				index = 0;
				list.removeAll(list);
				return;
			}
		}

		list.add(result);
		f(result);

	}

}
