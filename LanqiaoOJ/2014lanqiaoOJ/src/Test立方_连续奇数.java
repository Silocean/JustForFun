import java.util.Scanner;

/**

任何一个自然数m的立方均可写成m个连续奇数之和
例如用户输入：7
程序输出：7^3=43+45+47+49+51+53+55

 */
public class Test立方_连续奇数 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		switchNum(n);
	}

	private static void switchNum(int n) {
		String str = n + "^3=";
		int middle = n*n;
		if(middle%2!=0) {
			for(int i=(-n/2); i<=n/2; i++) {
				str += (middle+(i*2)) + "+";
			}
		} else {
			for(int i=(-n+1); i<n; i+=2) {
				str += (middle+i) + "+";
			}
		}
		System.out.println(str.substring(0, str.length()-1));
	}

}
