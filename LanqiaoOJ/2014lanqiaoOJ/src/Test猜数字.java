import java.util.Scanner;


public class Test������ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�����������һ�����֣�1~100����������");
		System.out.println("��ÿ��һ�����֣���Ҫ�������ǡ��´��ˡ�������С�ˡ������ǡ����С�");
		Scanner scan = new Scanner(System.in);
		int v1 = 1;
		int v2 = 100;
		for(;;)
		{
			int m = (v1 + v2)/2;
			System.out.println("�Ҳ��ǣ�" + m);
			System.out.println("1.�µ�̫����");
			System.out.println("2.�µ�̫С��");
			System.out.println("3.���У�");
			System.out.print("��ѡ��");
			int user = Integer.parseInt(scan.nextLine());
			if(user==3) break;
			if(user==1) v2 = m;
			if(user==2) v1 = m;
		}

	}

}
