import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**

某财务部门结账时发现总金额不对头。很可能是从明细上漏掉了某1笔或几笔。如果已知明细账目清单，
能通过编程找到漏掉的是哪1笔或几笔吗？
如果有多种可能，则输出所有可能的情况。
我们规定：用户输入的第一行是：有错的总金额。
接下来是一个整数n，表示下面将要输入的明细账目的条数。
再接下来是n行整数，分别表示每笔账目的金额。
要求程序输出：所有可能漏掉的金额组合。每个情况1行。金额按照从小到大排列，中间用空格分开。
比如：

用户输入：
6
5
3
2
4
3
1
表明：有错的总金额是6；明细共有5笔。
此时，程序应该输出：
1 3 3
1 2 4
3 4

为了方便，不妨假设所有的金额都是整数；每笔金额不超过1000，金额的明细条数不超过100。

 */
public class Test漏掉的张目明细 {
	
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
