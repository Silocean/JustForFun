import java.util.Scanner;


public class Test放球 {
	
	static StringBuffer str = new StringBuffer("");
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int k = scan.nextInt();
		if(m<Math.pow(2, k)) {
			toBinary(m);
			playBall(str);
		} else {
			System.out.println("不符合条件，请重新输入");
		}
		// System.out.println(str.reverse());
	}
	
	private static void toBinary(int m) {
		while(m/2 != 0) {
			str.append(m%2);
			m = m/2;
		}
		str.append(1);
	}
	
	private static void playBall(StringBuffer str) {
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '1') {
				System.out.print(i + "号盒子放" +(int)Math.pow(2, i) + "只球   ");
			} else {
				System.out.print(i + "号盒不放   ");
			}
		}
	}
	
}
