import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**

    匪警请拨110,即使手机欠费也可拨通！

    为了保障社会秩序，保护人民群众生命财产安全，警察叔叔需要与罪犯斗智斗勇，因而需要经常性地进行体力训练和智力训练！

    某批警察叔叔正在进行智力训练：

    1 2 3 4 5 6 7 8 9 = 110;

    请看上边的算式，为了使等式成立，需要在数字间填入加号或者减号（可以不填，但不能填入其它符号）。
    之间没有填入符号的数字组合成一个数，例如：12+34+56+7-8+9 就是一种合格的填法；123+4+5+67-89 是另一个可能的答案。

    请你利用计算机的优势，帮助警察叔叔快速找到所有答案。

    每个答案占一行。形如：

12+34+56+7-8+9
123+4+5+67-89
......

    已知的两个答案可以输出，但不计分。
    
    各个答案的前后顺序不重要。
 */
public class Test警察110 {
	
	public static List<StringBuffer> list = new ArrayList<StringBuffer>();
	
	public static String[] operator = {"+", "-", " "};
	
	public static StringBuffer str = new StringBuffer("123456789");
	
	public static void main(String[] args) {
		go(1, str);
	}
	
	public static void go(int index, StringBuffer str) {
		if(index == 17) {
			isEquals110(str);
			return;
		} else {
			for(int i=0; i<operator.length; i++) {
				// 如果不在此复制一个新的字符串，那必须在递归方法之后恢复现场，也就是把加在字符串上的字符再去掉
				StringBuffer sb = new StringBuffer(str);
				sb.insert(index, operator[i]);
				go(index + 2, sb);
				//str.delete(index, index+1);
			}
		}
	}
	
	public static void isEquals110(StringBuffer str) {
		String string = "";
		int num = 0;
		boolean isAdd = true;
		StringTokenizer st = new StringTokenizer(str.toString(), "+-", true);
		while(st.hasMoreElements()) {
			String tempStr = st.nextToken();
			if(tempStr.equals("+")) {
				isAdd = true;
				string += "+";
			} else if(tempStr.equals("-")) {
				isAdd = false;
				string += "-";
			} else {
				String[] splitStr = tempStr.split(" ");
				int a = 0;
				if(splitStr.length > 1) {
					String temp = "";
					for(int i=0; i<splitStr.length; i++) {
						temp += splitStr[i];
					}
					a = Integer.parseInt(temp);
					if(isAdd) {
						num += a;
					} else {
						num -= a;
					}
					string += temp;
				} else {
					a = Integer.parseInt(tempStr);
					if(isAdd) {
						num += a;
					} else {
						num -= a;
					}
					string += tempStr;
				}
			}
		}
		if(num == 110) {
			System.out.println(string);
		}
	}

}
