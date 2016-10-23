import java.util.Scanner;

/**
现在输入一个正整数k,找到所有的正整数x>=y,使得1/k=1/x+1/y.

 
输入
第一行输入一个整数n,代表有n组测试数据。
接下来n行每行输入一个正整数k
输出
按顺序输出对应每行的k找到所有满足条件1/k=1/x+1/y的组合
样例输入
2
2 
12
样例输出
1/2=1/6+1/3
1/2=1/4+1/4
1/12=1/156+1/13
1/12=1/84+1/14
1/12=1/60+1/15
1/12=1/48+1/16
1/12=1/36+1/18
1/12=1/30+1/20
1/12=1/28+1/21
1/12=1/24+1/24
 */
public class Test分数拆分 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		for(int i=0; i<n; i++) {
			String str = scan.nextLine();
			split(str);
		}
	}

	private static void split(String str) {
		int k = Integer.parseInt(str);
		for(int y=k+1; y<=2*k; y++) {
			if(check(k, y)) {
				System.out.println("1/"+k+"=1/"+k*y/(y-k)+"+"+"1/"+y);
			}
		}
	}

	private static boolean check(int k, int y) {
		if(y-k==1 || k*y%(y-k)==0) {
			return true;
		}
		return false;
	}

}
