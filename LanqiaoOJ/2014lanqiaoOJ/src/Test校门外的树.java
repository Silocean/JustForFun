import java.util.Scanner;

/**
[��Ŀ����]:
  ĳУ�����ⳤ��ΪL����·����һ������ÿ�������ڵ���֮��ļ������1�ס����ǿ��԰���·����һ�����ᣬ
  ��·��һ��������0��λ�ã���һ����L��λ�ã������ϵ�ÿ�������㣬��0��1��2��������L��������һ������
  ��·����һЩ����Ҫ��������������Щ�����������������ϵ���ʼ�����ֹ���ʾ��
  ��֪��һ�������ʼ�����ֹ������궼������������֮��������غϵĲ��֡�
����Ҫ����Щ�����е�������������˵㴦�������������ߡ���������Ǽ��㽫��Щ�������ߺ���·�ϻ��ж��ٿ�����

[�������]:
���� 
  ����ĵ�һ������������L��1 <= L <= 10000���� M��1 <= M <= 100����L������·�ĳ��ȣ�M�����������Ŀ��
  L��M֮����һ���ո��������������M��ÿ�а���������ͬ����������һ���ո��������ʾһ���������ʼ�����ֹ������ꡣ 
��� 
�������һ�У���һ��ֻ����һ����������ʾ��·��ʣ���������Ŀ�� 

[����]:	
�������� 
500 3
150 300
100 200
470 471
������� 
298
 */
public class TestУ������� {
	
	public static int[] tree;
	
	public static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String[] split = str1.split(" ");
		int total = Integer.parseInt(split[0]);
		int n = Integer.parseInt(split[1]);
		tree = new int[total+1];
		for(int i=0; i<tree.length; i++) {
			tree[i] = 1;
		}
		for(int i=0; i<n; i++) {
			String str = sc.nextLine();
			calc(str);
		}
		for(int i=0; i<tree.length; i++) {
			if(tree[i]==1) {
				count ++;
			}
		}
		System.out.println(count);
	}

	private static void calc(String str) {
		String[] split = str.split(" ");
		int a = Integer.parseInt(split[0]);
		int b = Integer.parseInt(split[1]);
		for(int i=a; i<=b; i++) {
			tree[i] = 0;
		}
	}

}
