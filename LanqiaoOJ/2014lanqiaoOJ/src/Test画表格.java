import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
�����

��ͼ�λ����к���������Ư���ı�񡣵��ڿ���̨�����оͱȽ������ˡ��е�ʱ�������һЩ���Ŵ��Ե�ģ�⣺
��word�ĵ��п��ܲ����룬���������±��п���
+-------+------+
|abc    |xyz=tt|
+-------+------+
|hellomm|t2    |
+-------+------+

����ĿҪ�����һ�����򣬰��û���������������֡�׼��񡱵ķ�ʽչ�ֳ����������Ҫ���ǣ�
�û�����ĵ�һ����һ����������ʾ�������ж�������Ϣ����������ÿ�������ɵ�Ԫ��ɡ���Ԫ���ö��ŷֿ���
����������ñ��ʽ����չ�ֵ��������ݡ�
���磺

�û����룺
3
cat,dog,good-luck
1,2,5
do not use,,that
������������word�ĵ��п��ܲ����룬���������±��п���
+----------+---+---------+
|cat       |dog|good-luck|
+----------+---+---------+
|1         |2  |5        |
+----------+---+---------+
|do not use|   |that     |
+----------+---+---------+
���в��ѿ�����
���������Ķ��ű�ʾ�м���һ������Ϊ�յĵ�Ԫ
�е���Ŀ�����ĵ�Ԫ�������о���
�еĿ����ͬ�е����ĵ�Ԫ����
��Ԫ���е���Ϣ�����

���Լ��裺�û�������������Ϊ30�����ܵ��������Ϊ40��
 */
public class Test����� {
	
	public static List<List<String>> list = new ArrayList<List<String>>();
	
	public static int[] length;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int index = 0;
		int max = 0;
		while(index<n) {
			List<String> strList = new ArrayList<String>();
			String str = scan.nextLine();
			String[] split = str.split(",");
			if(split.length > max) {
				max = split.length;
			}
			for(int i=0; i<split.length; i++) {
				strList.add(split[i]);
			}
			list.add(strList);
			index ++;
		}
		length = new int[max];
		for(int i=0; i<list.size(); i++) {
			while(list.get(i).size()<max) {
				list.get(i).add("");
			}
		}
		getMaxLength(0);
		drawTable();
	}

	private static void drawTable() {
		String string = "+";
		for(int i=0; i<length.length; i++) {
			String str = "";
			for(int k=0; k<length[i]; k++) {
				str += "-";
			}
			string += str+"+";
		}
		System.out.println(string);
		for(int i=0; i<list.size(); i++) {
			String strWord = "|";
			for(int j=0; j<list.get(i).size(); j++) {
				String str = "";
				for(int k=0; k<length[j]-list.get(i).get(j).length(); k++) {
					str += " ";
				}
				strWord += list.get(i).get(j)+str+"|";
			}
			System.out.println(strWord);
			System.out.println(string);
		}
	}

	private static void getMaxLength(int index) {
		if(index>=length.length) {
			return;
		}
		length[index] = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).get(index).length() > length[index]) {
				length[index] = list.get(i).get(index).length();
			}
		}
		getMaxLength(index+1);
	}

}
