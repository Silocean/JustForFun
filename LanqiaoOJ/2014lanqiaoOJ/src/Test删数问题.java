import java.util.Scanner;

/**
��������һ���߾��ȵ�������N����������û�С�0������ȥ����������S �����ֺ�ʣ��
�����ְ�ԭ���Ҵ������һ���µ�����������̶Ը�����N ��S��Ѱ��һ�ַ���ʹ��ʣ��
��������ɵ�������С��
���Ӧ������ȥ�������ֵ�λ�ú���ɵ��µ�����������N ������240λ��
�������ݾ������д�
�����롿
n
s
����������ʣ�µ���С����
���������롿
175438
4
�����������
13
 */
public class Testɾ������ {
	
	static int len = 0;
	
	static int n = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		StringBuffer sb = new StringBuffer(str);
		len = sb.length();
		n = scan.nextInt();
		deleteStr(sb);
	}

	private static void deleteStr(StringBuffer sb) {
		if(sb.length() == len-n) {
			System.out.println(sb);
			return;
		} else {
			int i=0;
			while(sb.charAt(i)<sb.charAt(i+1)) {
				i ++;
			}
			sb.deleteCharAt(i);
			deleteStr(sb);
		}
	}

}
