import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
画表格

在图形环境中很容易做出漂亮的表格。但在控制台环境中就比较困难了。有的时候可以用一些符号大略地模拟：
（word文档中可能不整齐，拷贝到记事本中看）
+-------+------+
|abc    |xyz=tt|
+-------+------+
|hellomm|t2    |
+-------+------+

本题目要求设计一个程序，把用户输入的内容用这种“准表格”的方式展现出来。具体的要求是：
用户输入的第一行是一个整数，表示接下来有多少行信息。接下来的每行由若干单元组成。单元间用逗号分开。
程序输出：用表格方式重新展现的输入内容。
例如：

用户输入：
3
cat,dog,good-luck
1,2,5
do not use,,that
则程序输出：（word文档中可能不整齐，拷贝到记事本中看）
+----------+---+---------+
|cat       |dog|good-luck|
+----------+---+---------+
|1         |2  |5        |
+----------+---+---------+
|do not use|   |that     |
+----------+---+---------+
从中不难看出：
两个连续的逗号表示中间有一个内容为空的单元
列的数目由最大的单元数的那行决定
列的宽度由同列的最宽的单元决定
单元格中的信息左对齐

可以假设：用户输入的最大行数为30，可能的最多列数为40。
 */
public class Test画表格 {
	
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
