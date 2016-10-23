import java.util.Scanner;


public class Test自定义加减乘除 {
	
	public static int length;
	
	public static int a[], b[];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		length = str1.length()>=str2.length()?str1.length():str2.length();
		a = new int[length];
		b = new int[length];
		
		add(str1, str2);
		substract(str1, str2);
	}

	private static void add(String str1, String str2) {
		for(int i=0; i<str1.length(); i++) {
			a[i] = Integer.parseInt(str1.charAt(i)+"");
		}
		for(int i=0; i<str2.length(); i++) {
			b[i] = Integer.parseInt(str2.charAt(i)+"");
		}
		int c[] = new int[length];
		for(int i=length-1; i>=0; i--) {
			c[i] = a[i] + b[i];
			if(i>0) {
				if(c[i]>=10) {
					a[i-1] += 1;
					c[i] = c[i] % 10;
				}
			}
		}
		String result = "";
		for(int i=0; i<c.length; i++) {
			result += c[i];
		}
		System.out.println("和为：" + result);
	}
	
	private static void substract(String str1, String str2) {
		for(int i=0; i<str1.length(); i++) {
			a[i] = Integer.parseInt(str1.charAt(i)+"");
		}
		for(int i=0; i<str2.length(); i++) {
			b[i] = Integer.parseInt(str2.charAt(i)+"");
		}
		boolean isMinus = false;
		if(a[0]<b[0]) {
			int temp[];
			temp = a;
			a = b;
			b = temp;
			isMinus = true;
		}
		int[] c = new int[length];
		for(int i=length-1; i>=0; i--) {
			if(a[i]<b[i]) {
				a[i] += 10;
				a[i-1] -= 1;
				c[i] = a[i] - b[i];
			} else {
				c[i] = a[i] - b[i];
			}
		}
		String result = "";
		if(isMinus) result += "-";
		for(int i=0; i<c.length; i++) {
			result += c[i];
		}
		System.out.println("差为：" + result);
	}

}
