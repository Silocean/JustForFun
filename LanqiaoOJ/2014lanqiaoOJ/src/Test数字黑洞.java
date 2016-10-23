import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**

任意一个5位数，比如：34256，把它的各位数字打乱，重新排列，可以得到一个最大的数：65432，一个最小的数23456。
求这两个数字的差，得：41976，把这个数字再次重复上述过程（如果不足5位，则前边补0）。
如此往复，数字会落入某个循环圈（称为数字黑洞）。
比如，刚才的数字会落入：[82962, 75933, 63954, 61974] 这个循环圈。

请编写程序，找到5位数所有可能的循环圈，并输出，每个循环圈占1行。其中5位数全都相同则循环圈为 [0]，这个可以不考虑。

循环圈的输出格式仿照：
[82962, 75933, 63954, 61974]

其中数字的先后顺序可以不考虑。

 */
public class Test数字黑洞 {

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
		System.out.println("总共有：" + set.size() + "组");
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
