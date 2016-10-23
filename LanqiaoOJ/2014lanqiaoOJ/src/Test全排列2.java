import java.util.ArrayList;
import java.util.Arrays;

public class Test»´≈≈¡–2 {

	public static StringBuffer sb = new StringBuffer();
	public static int n = 0;

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("1", "2",
				"3", "4", "5"));
		go(list);
		System.out.println(n);
	}
/*
	public static void go(ArrayList<String> list) {
		if (list.size() == 0) {
			n++;
			System.out.println(sb.toString());
		} else {
			for (int i = 0; i < list.size(); i++) {
				ArrayList<String> temp = new ArrayList<String>(list);
				sb.append(temp.get(i));
				temp.remove(i);
				go(temp);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
*/
	public static void go(ArrayList<String> list) {
		if (list.size() == 0) {
			n++;
			System.out.println(sb.toString());
		} else {
			for (int i = 0; i < list.size(); i++) {
				String temp = list.get(i);
				sb.append(temp);
				list.remove(i);
				go(list);
				list.add(i, temp);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

}
