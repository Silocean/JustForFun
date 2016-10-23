import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**

在某些应用中，为了支持灵活性，往往用到自定义的公式。

比如，有如下的原始公式集合：
	
	int add(int x, int y):  返回x与y的和
	
	int add(int x, int y, int z):  返回x,y,z三个数的和
	
	int min(int x, int y):  返回x,y中较小的值
	
	int max(int x, int y):  返回x,y中较大的值

	int doubleMe(int x):  返回 x 的2倍

给出一个自定义公式串

add(min(5,3),max(2,8),add(1,doubleMe(1)))

通过手工计算可以得出结果为：14

本题的任务是：编写一个解析程序，能够对由上述原始公式任意组合出来的公式计算其结果。
也就是输入一个自定义公式串，输出它的计算结果（可以不考虑输入公式本身有语法错误的情况）。

输入的公式串中可以含有多余的空格，类似：

add( min(5, 3) , max(2 , 8) )  也是合法的公式。


程序输入：公式串
程序输出：该公式的计算值

 */
public class Test公式解析 {
	
	public static Stack<String> stack = new Stack<String>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		split(str);
		System.out.println(stack.pop());
	}

	private static void split(String str) {
		StringTokenizer st = new StringTokenizer(str, "(,) ", true);
		while(st.hasMoreElements()) {
			String string = st.nextToken();
			if(!string.equals(" ") && !string.equals(",")) {
				stack.push(string);
				if(string.equals(")")) {
					List<String> tempList = new ArrayList<String>();
					int num = 0;
					stack.pop();	// 把")"去掉
					String tempStr = stack.pop();
					while(!tempStr.equals("(")) {
						tempList.add(tempStr);
						tempStr = stack.pop();
					}
					tempStr = stack.pop(); // 把"("去掉
					if(tempStr.equals("add")) {
						for(int i=0; i<tempList.size();i++) {
							num += Integer.parseInt(tempList.get(i));
						}
						stack.push(num+"");
					} else if(tempStr.equals("min")){
						int a = Integer.parseInt(tempList.get(0));
						int b = Integer.parseInt(tempList.get(1));
						if(a<b) {
							stack.push(""+a);
						} else {
							stack.push(""+b);
						}
					} else if(tempStr.equals("max")){
						int a = Integer.parseInt(tempList.get(0));
						int b = Integer.parseInt(tempList.get(1));
						if(a>b) {
							stack.push(""+a);
						} else {
							stack.push(""+b);
						}
					} else if(tempStr.equals("doubleMe")) {
						stack.push(Integer.parseInt(tempList.get(0)) * 2 + "");
					}
				}
			}
		}
	}

}
