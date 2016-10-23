import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TestÈ¡Çò²©ÞÄ {
	
	public static int[] arr = {1, 3, 7, 8};
	
	public static boolean isAwin = false;
	
	public static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(scan.nextLine());
			judge(num, 0);
			if(isAwin == true) {
				list.add(1);
			} else {
				list.add(0);
			}
			isAwin = false;
		}
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void judge(int num, int count) {
		if(num == 1) {
			if(count%2!=0) {
				isAwin = true;
			}
			return;
		} else {
			for(int i=0; i<arr.length; i++) {
				if(arr[i]<=num) {
					num -= arr[i];
					judge(num, count+1);
					num += arr[i];
				}
			}
		}
	}

}
