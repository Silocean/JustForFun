import java.util.Scanner;

/**
��������һ��������k,�ҵ����е�������x>=y,ʹ��1/k=1/x+1/y.

 
����
��һ������һ������n,������n��������ݡ�
������n��ÿ������һ��������k
���
��˳�������Ӧÿ�е�k�ҵ�������������1/k=1/x+1/y�����
��������
2
2 
12
�������
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
public class Test������� {

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
