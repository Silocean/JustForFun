import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**

��ĳЩӦ���У�Ϊ��֧������ԣ������õ��Զ���Ĺ�ʽ��

���磬�����µ�ԭʼ��ʽ���ϣ�
	
	int add(int x, int y):  ����x��y�ĺ�
	
	int add(int x, int y, int z):  ����x,y,z�������ĺ�
	
	int min(int x, int y):  ����x,y�н�С��ֵ
	
	int max(int x, int y):  ����x,y�нϴ��ֵ

	int doubleMe(int x):  ���� x ��2��

����һ���Զ��幫ʽ��

add(min(5,3),max(2,8),add(1,doubleMe(1)))

ͨ���ֹ�������Եó����Ϊ��14

����������ǣ���дһ�����������ܹ���������ԭʼ��ʽ������ϳ����Ĺ�ʽ����������
Ҳ��������һ���Զ��幫ʽ����������ļ����������Բ��������빫ʽ�������﷨������������

����Ĺ�ʽ���п��Ժ��ж���Ŀո����ƣ�

add( min(5, 3) , max(2 , 8) )  Ҳ�ǺϷ��Ĺ�ʽ��


�������룺��ʽ��
����������ù�ʽ�ļ���ֵ

 */
public class Test��ʽ���� {
	
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
					stack.pop();	// ��")"ȥ��
					String tempStr = stack.pop();
					while(!tempStr.equals("(")) {
						tempList.add(tempStr);
						tempStr = stack.pop();
					}
					tempStr = stack.pop(); // ��"("ȥ��
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
