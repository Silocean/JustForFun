import java.util.Scanner;


public class TestĞ¡ÇòÏÂÂä_¶ş²æÊ÷ {
	
	public static int[] a;
	
	public static boolean[] open;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		for(int i=0; i<n; i++) {
			String str = scan.nextLine();
			calc(str);
		}
	}

	private static void calc(String str) {
		int k = 1;
		String[] split = str.split(" ");
		int depth = Integer.parseInt(split[0]);
		int num = Integer.parseInt(split[1]);
		a = new int[(int)Math.pow(2, depth)-1];
		open = new boolean[(int)Math.pow(2, depth)-1];
		for(int i=0; i<a.length; i++) {
			a[i] = i+1;
			open[i] = false;
		}
		for(int i=0; i<num; i++) {
			k = 1;
			while(true) {
				open[k-1] = !open[k-1];
				k = open[k-1] ? k*2 : k*2+1;
				if(k>a.length) {
					break;
				}
			}
		}
		System.out.println(k/2);
	}

}
