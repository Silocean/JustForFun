import java.util.Scanner;


public class Test���� {
	
	static StringBuffer str = new StringBuffer("");
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int k = scan.nextInt();
		if(m<Math.pow(2, k)) {
			toBinary(m);
			playBall(str);
		} else {
			System.out.println("����������������������");
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
				System.out.print(i + "�ź��ӷ�" +(int)Math.pow(2, i) + "ֻ��   ");
			} else {
				System.out.print(i + "�źв���   ");
			}
		}
	}
	
}
