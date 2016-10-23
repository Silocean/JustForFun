import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class TestÈË»ú²ÂÊı {
	
	public static int num = 0;
	
	public static boolean isEnd = false;

	public static void main(String[] args) {
		Random r = new Random();
		num = 1234;
		Scanner sc = new Scanner(System.in);
		String str = "";
		while(isEnd == false) {
			str = sc.nextLine();
			guess(str);
		}
	}

	private static void guess(String str) {
		int count1 = 0;
		String result = num + "";
		List<Integer> temp = new ArrayList<Integer>();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == result.charAt(i)) {
				count1 ++;
			}
			temp.add(str.charAt(i)-'0');
		}
		int count2 = 0;
		for(int i=0; i<result.length(); i++) {
			if(temp.contains(result.charAt(i)-'0')) {
				count2 ++;
			}
		}
		System.out.println(str + " " + count2 + " " + count1);
		if(count2 ==4 && count1 ==4) {
			isEnd = true;
		}
	}

}
