import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**

5������

����ƽ����ʱ������ϣ���þ������ٵ�������ϳƳ������ܶ��������
���ֻ��5�����룬�����ֱ���1��3��9��27��81�������ǿ�����ϳƳ�1��121֮��������������������������������������У���
����ĿҪ����ʵ�֣����û�����������������������Ϸ�����
���磺
�û����룺
5
���������
9-3-1
�û����룺
19
���������
27-9+1

Ҫ����������������Ǵ�����ǰС���ں�
���Լ����û�����������ַ��Ϸ�Χ1~121��

 */
public class Test������� {
	
	public static void main(String[] args) {
		int m = new Scanner(System.in).nextInt();
		for(int a=1; a>=-1; a--) {
			for(int b=1; b>=-1; b--) {
				for(int c=1; c>=-1; c--) {
					for(int d=1; d>=-1; d--) {
						for(int e=1; e>=-1; e--) {
							if(a*81+b*27+c*9+d*3+e*1 == m) {
								List<Integer> list = new ArrayList<Integer>();
								String str = "";
								if(a*81!=0) list.add(a*81);
								if(b*27!=0) list.add(b*27);
								if(c*9!=0) list.add(c*9);
								if(d*3!=0) list.add(d*3);
								if(e*1!=0) list.add(e*1);
								for(int i=0; i<list.size()-1; i++) {
									if(list.get(i+1)>0) {
										str += list.get(i)+"+";
									} else {
										str += list.get(i);
									}
								}
								str += list.get(list.size()-1);
								System.out.println(str);
							}
						}
					}
				}
			}
		}
	}

}
