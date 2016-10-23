import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test√‹‘øº”√‹ {
	
	public static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int index = 0;
		int n = Integer.parseInt(scan.nextLine());
		while(index < n) {
			String str1 = scan.nextLine();
			String str2 = scan.nextLine();
			deal(str1, str2);
			index ++;
		}
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void deal(String str1, String str2) {
		String result = "";
		char num[] = str1.toCharArray();
		for(int i=0; i<str2.length(); i++) {
			char c = str2.charAt(i);
			int m = c-48 + num[i%str1.length()];
			result += (char)(m);
		}
		list.add(result);
	}

}
