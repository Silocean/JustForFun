import java.util.ArrayList;
import java.util.List;

/**
看这个算式：
☆☆☆ + ☆☆☆ = ☆☆☆
如果每个五角星代表 1 ~ 9 的不同的数字。
这个算式有多少种可能的正确填写方法？
173 + 286 = 459
295 + 173 = 468
173 + 295 = 468
183 + 492 = 675
以上都是正确的填写法！
注意：
111 + 222 = 333 是错误的填写法！
因为每个数字必须是不同的！ 
也就是说：1~9中的所有数字，每个必须出现且仅出现一次！
注意：
不包括数字“0”！
注意：
满足加法交换率的式子算两种不同的答案。
所以答案肯定是个偶数！

 */
public class Test填写算式 {
	
	public static List<Integer> list = new ArrayList<Integer>();
	
	public static StringBuffer str = new StringBuffer();
	
	public static int count = 0;

	public static void main(String[] args) {
		for(int i=1; i<=9; i++) {
			list.add(i);
		}
		go(1);
		System.out.println(count);
	}
	
	public static void go(int index) {
		if(index == 10) {
			// System.out.println(str);
			calculate(str);
			return;
		} else {
			for(int i=0; i<list.size(); i++) {
				int m = list.get(i);
				str.append(m);
				list.remove(i);
				go(index+1);
				list.add(i, m);
				str.deleteCharAt(str.length()-1);
			}
		}
	}

	private static void calculate(StringBuffer str) {
		int num1 = Integer.parseInt(str.substring(0, 3));
		int num2 = Integer.parseInt(str.substring(3, 6));
		int result = Integer.parseInt(str.substring(6, str.length()));
		if(num1+num2 == result) {
			System.out.println(num1+"+"+num2+"="+result);
			count ++;
		}
	}

}
