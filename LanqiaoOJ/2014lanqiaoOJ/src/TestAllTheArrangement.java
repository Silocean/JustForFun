import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class TestAllTheArrangement {
	public static int n = 0;

	public static void main(String[] args) {
		List<String> list = new LinkedList<String>(Arrays.asList("1", "2", "3", "4", "5"));
		listAll(list, "" );
		System.out.println(n);
	}

	public static void listAll(List<String> list, String strNum) {
		if (list.isEmpty()) {
			n++;
			System.out.println(strNum);
		}
		for (int i = 0; i < list.size(); i++) {
			int len = strNum.length();
			List<String> tmp = new LinkedList<String>(list);
			String c = tmp.remove(i);
			/*if (len == 2 && c.charAt(0) == '4' // 第三个位置不能为4
					|| (len > 0 && c.charAt(0) == '3' && strNum.charAt(strNum
							.length() - 1) == '5') // 3和5不相连
					|| (len > 0 && c.charAt(0) == '5' && strNum.charAt(strNum
							.length() - 1) == '3')) {
				continue;
			}*/
			listAll(tmp, strNum + c);
		}
	}

}
