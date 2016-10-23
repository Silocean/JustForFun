import java.util.ArrayList;
import java.util.List;

/**
ABCDE���˰��Ź����ճ̣�ÿ��ÿ���ڹ���5����Ϣ2��

1)        ������3�������˶�Ҫ�ϰ�

2)        ÿ���������ϰ಻����3�죬���յ���һ����������

3)        A��C�����������ϰ�

4)        B��D��E�����춼���ϰ�

5)        A��Cһ�������ټ�4��

6)        A��B��C��D��ÿ�����������2���ϰ�

������д�����һ����������ܵ������ÿ��������ÿ��и�����0�����ϰ࣬1�����ϰࡣ

����

1 0 1 1 1 0 1

1 1 0 1 1 1 0

1 0 1 1 1 0 1

1 1 0 1 1 1 0

1 1 0 1 1 1 0
 */
public class TestPaiBan2 {
	private static int count = 0;
	private static int startEndPoint;
	private static List<List<Integer>> usableData = new ArrayList<List<Integer>>();
	private static List<List<List<Integer>>> result = new ArrayList<List<List<Integer>>>();

	public static void init() {
		for (int i = 0; i < 7; i++)
			count = (count + 1) * 2 - 1;
		for (int i = 0; i < 5; i++) {
			startEndPoint = (startEndPoint + 1) * 2 - 1;
		}
		for (int i = startEndPoint; i < count; i++) {
			int tmp = i;
			List<Integer> turn = new ArrayList<Integer>();
			boolean flag = false;
			int counter = 0;
			for (int c = 0; c < 7; c++) {

				if ((15 & tmp) == 15) {
					flag = true;
					break;
				}
				if ((1 & tmp) == 1) {
					counter++;
					turn.add(1);
				} else
					turn.add(0);
				tmp = tmp >> (1);
				// System.out.println("test"+tmp);
			}

			if (!flag && counter == 5) {
				usableData.add(turn);
			}
		}
		/*for(int d=0;d<usableData.size();d++){
			for(Integer c :usableData.get(d)){
				System.out.print(c+ " ");
			}
			System.out.println();
		}*/
		getBestRange(usableData);
	}

	private static void getBestRange(List<List<Integer>> list) {
		for (int a = 0; a < list.size(); a++) {
			for (int b = 0; b < list.size(); b++) {
				for (int c = 0; c < list.size(); c++) {
					for (int d = 0; d < list.size(); d++) {
						for (int e = 0; e < list.size(); e++) {
							List<List<Integer>> tmp = new ArrayList<List<Integer>>();
							tmp.add(list.get(a));
							tmp.add(list.get(b));
							tmp.add(list.get(c));
							tmp.add(list.get(d));
							tmp.add(list.get(e));
							if (validData(tmp)) {
								result.add(tmp);
							}
						}
					}
				}
			}
		}
	}

	private static boolean validData(List<List<Integer>> list) {
		if (list.size() > 0) {
			int allworkday = 0;
			int meetDays = 0;
			for (int i = 0; i < list.get(0).size(); i++) {
				int peopleCount = 0;
				int count = 0;
				for (int c = 0; c < list.size(); c++) {
					if (((c == 1 || c == 3 || c == 4) && list.get(c).get(6) != 0)
							|| ((c == 2 || c == 0) && list.get(c).get(2) != 1))
						return false;
					peopleCount += list.get(c).get(i);
					if (c != 4)
						count += list.get(c).get(i);
				}
				if (count < 2)
					return false;
				if (list.get(0).get(i) == 1 && list.get(2).get(i) == 1)
					meetDays++;
				if (peopleCount == list.size()) {
					allworkday++;
				}
			}
			if (allworkday < 3 || meetDays < 4)
				return false;
			return true;
		}
		System.out.println("hehe");
		return false;
	}

	public static void showResult() {
		for (int i = 0; i < result.size(); i++) {
			System.out.println("��" + (i + 1) + "�����Ҫ��");
			for (List<Integer> list : result.get(i)) {
				for (Integer r : list) {
					System.out.print(r + " ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		// System.out.println(27&15);
		init();
		showResult();
	}
}