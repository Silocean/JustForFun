import java.util.ArrayList;
import java.util.List;

/**
�������ʽ��
���� + ���� = ����
���ÿ������Ǵ��� 1 ~ 9 �Ĳ�ͬ�����֡�
�����ʽ�ж����ֿ��ܵ���ȷ��д������
173 + 286 = 459
295 + 173 = 468
173 + 295 = 468
183 + 492 = 675
���϶�����ȷ����д����
ע�⣺
111 + 222 = 333 �Ǵ������д����
��Ϊÿ�����ֱ����ǲ�ͬ�ģ� 
Ҳ����˵��1~9�е��������֣�ÿ����������ҽ�����һ�Σ�
ע�⣺
���������֡�0����
ע�⣺
����ӷ������ʵ�ʽ�������ֲ�ͬ�Ĵ𰸡�
���Դ𰸿϶��Ǹ�ż����

 */
public class Test��д��ʽ {
	
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
