import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
[��������]
������ N ��ֽ�ƣ���ŷֱ�Ϊ 1��2����, N��ÿ�����������ţ���ֽ��������Ϊ N �ı�������������һ����ȡ������ֽ�ƣ�Ȼ���ƶ���
�������ƹ���Ϊ���ڱ��Ϊ 1 ����ȡ��ֽ�ƣ�ֻ���Ƶ����Ϊ 2 �Ķ��ϣ��ڱ��Ϊ N �Ķ���ȡ��ֽ�ƣ�ֻ���Ƶ����Ϊ N-1 �Ķ��ϣ���������ȡ��ֽ�ƣ������Ƶ�������߻��ұߵĶ��ϡ�
��������Ҫ���ҳ�һ���ƶ������������ٵ��ƶ�����ʹÿ����ֽ������һ���ࡣ
�������� N=4��4 ��ֽ�����ֱ�Ϊ��
�����١�9���ڡ�8���ۡ�17���ܡ�6
�����ƶ�3�οɴﵽĿ�ģ�
������ �� ȡ 4 ���Ʒŵ� �� ��9 8 13 10�� -> �� �� ȡ 3 ���Ʒŵ� �ڣ�9 11 10 10��-> �� �� ȡ 1 ���Ʒŵ��٣�10 10 10 10����
[�� ��]��
�������������ļ������ļ���ʽ��
����N��N ��ֽ�ƣ�1 <= N <= 100��
����A1 A2 �� An ��N ��ֽ�ƣ�ÿ��ֽ�Ƴ�ʼ����l<= Ai <=10000��
[�� ��]��
�����������Ļ����ʽΪ��
�������жѾ��ﵽ���ʱ�������ƶ���������
[�����������]
a.in��
��4
��9 8 17 6

��Ľ��ʾ��
��3
 */
public class ����ֽ�� {

	public static List<Integer> list = new ArrayList<Integer>();
	
	public static int sum = 0;
	
	public static int count = 0;

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 int n = Integer.parseInt(scan.nextLine());
		 String str = scan.nextLine();
		 String[] strs = str.split(" ");
		 for(int i=0; i<strs.length; i++) {
			 sum += Integer.parseInt(strs[i]);
		 }
		 for(int i=0; i<n; i++) {
			 list.add(Integer.parseInt(strs[i]) - sum/n);
		 }
		 for(int i=1; i<n; i++) {
			 if(list.get(i-1) != 0) {
				 list.set(i, list.get(i)-(0-list.get(i-1)));
				 count ++;
			 }
		 }
		 System.out.println(count);
	}
}
