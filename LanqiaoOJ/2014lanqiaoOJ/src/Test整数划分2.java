import java.util.ArrayList;
import java.util.List;


public class Test整数划分2 {
	
	public static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		int input = 6;
		integerDivide(input, input);
	}
	
	public static void integerDivide(int m, int n) {
		if(n==1) {
			list.add(1);
			formatResult(list);
			list.remove(list.get(list.size()-1));
			return;
		}
		if(n==0) {
			formatResult(list);
			return;
		}
		for(int i=m; i>=1; i--) {
			if(i<=n) {
				list.add(i);
				integerDivide(i, n-i);
				list.remove(list.get(list.size()-1));
			}
		}
	}
	
	public static void formatResult(List<Integer> list) {
		System.out.print(list.get(0));
		for(int i=1; i<list.size(); i++) {
			System.out.print("+" + list.get(i));
		}
		System.out.println();
	}

}
