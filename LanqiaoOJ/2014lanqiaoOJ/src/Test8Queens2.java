import java.util.ArrayList;
import java.util.List;


class Test8Queens2 {
	
	public static StringBuffer result = new StringBuffer();
	
	public static List<Integer> list = new ArrayList<Integer>();
	
	public static int count = 0;

	public static void main(String[] args) {
		for(int i=1; i<=8; i++) {
			list.add(i);
		}
		go(0);
		System.out.println(count);
	}

	private static void go(int index) {
		if(index == 8) {
			if(check(result)) {
				count ++;
				System.out.println(result);
			}
			return;
		} else {
			for(int i=0; i<list.size(); i++) {
				int m = list.get(i);
				result.append(m);
				list.remove(i);
				go(index+1);
				list.add(i, m);
				result.deleteCharAt(result.length()-1);
			}
		}
	}
	
	// 检查是否符合八皇后的位置要求
	private static boolean check(StringBuffer sb) {
		for(int i=0; i<sb.length(); i++) {
			for(int j=i+1; j<sb.length(); j++) {
				if((i-j)==sb.charAt(i)-sb.charAt(j) || ((j-i)==sb.charAt(i)-sb.charAt(j))) {
					return false;
				}
			}
		}
		return true;
	}

}
