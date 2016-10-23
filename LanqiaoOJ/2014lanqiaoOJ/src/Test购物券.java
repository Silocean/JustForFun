import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**

公司发了某商店的购物券1000元，限定只能购买店中的m种商品。每种商品的价格分别为m1,m2,……，
要求程序列出所有的正好能消费完该购物券的不同购物方法。

程序输入：
第一行是一个整数m，代表可购买的商品的种类数。
接下来是m个整数，每个1行，分别代表这m种商品的单价(0<m<1000)。
程序输出：
	第一行是一个整数，表示共有多少种方案
	第二行开始，每种方案占1行，表示对每种商品购买的数量，中间用空格分隔。
例如：

输入：
2
200
300
则应输出：
2
2  2
5  0

输入：
2
500
800
则应输出：
1
2  0

输入：
1
999
则应输出：
0

多个方案间的顺序不重要。

 */
public class Test购物券 {

	static int min = 1000;

	static int m = 0;

	static int[] arr;

	static int total = 0;

	static int count = 0;

	static List<Integer> result = new ArrayList<Integer>();

	static List<List<Integer>> list = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(scan.nextLine());
			arr[i] = num;
			if (num < min) {
				min = num;
			}
		}
		m = 1000 / min;
		fun(0);
		if (count == 0) {
			System.out.println(0);
		} else {
			System.out.println(count);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.get(i).size() - 1; j++) {
					System.out.print(list.get(i).get(j) + " ");
				}
				System.out.println(list.get(i).get(list.get(i).size() - 1));
			}
		}
	}

	private static void fun(int index) {
		if (index == arr.length) {
			if (total == 1000) {
				list.add(new ArrayList<Integer>(result));// 注意要复制result
				count++;
			}
			return;
		} else
			for (int i = 0; i <= m; i++) {
				total += arr[index] * i;
				result.add(i);
				fun(index + 1);
				result.remove(result.size() - 1);
				total -= arr[index] * i;
			}
	}

}
