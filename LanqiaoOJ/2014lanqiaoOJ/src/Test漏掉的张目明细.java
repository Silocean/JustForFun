import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**

ĳ�����Ž���ʱ�����ܽ���ͷ���ܿ����Ǵ���ϸ��©����ĳ1�ʻ򼸱ʡ������֪��ϸ��Ŀ�嵥��
��ͨ������ҵ�©��������1�ʻ򼸱���
����ж��ֿ��ܣ���������п��ܵ������
���ǹ涨���û�����ĵ�һ���ǣ��д���ܽ�
��������һ������n����ʾ���潫Ҫ�������ϸ��Ŀ��������
�ٽ�������n���������ֱ��ʾÿ����Ŀ�Ľ�
Ҫ�������������п���©���Ľ����ϡ�ÿ�����1�С����մ�С�������У��м��ÿո�ֿ���
���磺

�û����룺
6
5
3
2
4
3
1
�������д���ܽ����6����ϸ����5�ʡ�
��ʱ������Ӧ�������
1 3 3
1 2 4
3 4

Ϊ�˷��㣬�����������еĽ���������ÿ�ʽ�����1000��������ϸ����������100��

 */
public class Test©������Ŀ��ϸ {
	
	public static int sum = 0;
	
	public static List<Integer> list = new ArrayList<Integer>();
	
	public static int m=0, n=0;
	
	public static int total = 0;
	
	public static List<String> sbList = new ArrayList<String>();
	
	public static List<String> result = new ArrayList<String>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		total = Integer.parseInt(scan.nextLine());
		int n = Integer.parseInt(scan.nextLine());
		for(int i=0; i<n; i++) {
			int m = Integer.parseInt(scan.nextLine());
			sum += m;
			list.add(m);
		}
		m = n;                                                                                                                                                                                  
		for(int i=0; i<list.size(); i++) {
			for(int j=i+1; j<list.size(); j++) {                                                                                                                                                                                                                                                           
				int a = list.get(i);
				int b = list.get(j);
				if(a>b) {
					list.set(i, b);
					list.set(j, a);
				}
			}
			
		}
		//System.out.println(list);
		for(int i=1; i<=m; i++) {
			MChoiceN(0, -1, i);
		}
	}

	private static void MChoiceN(int index, int k, int n) {
		if(index == n) {
			//System.out.println(sbList);
			calc(sbList);
			return;
		} else {
			for(int i=k+1; i<=m-n+index; i++) {
				String str = list.get(i)+"";
				sbList.add(str);
				MChoiceN(index+1, i, n);
				sbList.remove(sbList.size()-1);
			}
		}
	}

	private static void calc(List<String> sbList) {
		int num = 0;
		for(int i=0; i<sbList.size(); i++) {
			num += Integer.parseInt(sbList.get(i));
		}
		if(num == sum-total) {
			String str = "";
			for(int i=0; i<sbList.size(); i++) {
				str += sbList.get(i)+" ";
			}
			if(!result.contains(str)) {
				result.add(str);
				System.out.println(str);
			}
			
		}
	}

}
