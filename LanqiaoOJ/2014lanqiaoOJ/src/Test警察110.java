import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**

    �˾��벦110,��ʹ�ֻ�Ƿ��Ҳ�ɲ�ͨ��

    Ϊ�˱���������򣬱�������Ⱥ�������Ʋ���ȫ������������Ҫ���ﷸ���Ƕ��£������Ҫ�����Եؽ�������ѵ��������ѵ����

    ĳ�������������ڽ�������ѵ����

    1 2 3 4 5 6 7 8 9 = 110;

    �뿴�ϱߵ���ʽ��Ϊ��ʹ��ʽ��������Ҫ�����ּ�����ӺŻ��߼��ţ����Բ�������������������ţ���
    ֮��û��������ŵ�������ϳ�һ���������磺12+34+56+7-8+9 ����һ�ֺϸ�����123+4+5+67-89 ����һ�����ܵĴ𰸡�

    �������ü���������ƣ�����������������ҵ����д𰸡�

    ÿ����ռһ�С����磺

12+34+56+7-8+9
123+4+5+67-89
......

    ��֪�������𰸿�������������Ʒ֡�
    
    �����𰸵�ǰ��˳����Ҫ��
 */
public class Test����110 {
	
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
				// ������ڴ˸���һ���µ��ַ������Ǳ����ڵݹ鷽��֮��ָ��ֳ���Ҳ���ǰѼ����ַ����ϵ��ַ���ȥ��
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
