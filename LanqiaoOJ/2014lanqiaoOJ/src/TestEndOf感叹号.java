import java.util.Scanner;


public class TestEndOf¸ÐÌ¾ºÅ {

	private static String str = new Scanner(System.in).nextLine();
	
	public static void main(String[] args) {
		diGui(0);
	}
	
	private static void diGui(int i) {
		if(str.charAt(i) == '!') {
			System.out.print(str.charAt(i));
		} else {
			diGui(i+1);
			System.out.print(str.charAt(i));
		}
	}

}
