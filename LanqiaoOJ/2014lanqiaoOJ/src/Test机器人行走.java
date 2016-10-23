import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
    ĳ���깬������һ��������С�������Խ���Ԥ�������ָ���ָ���ж���С���Ļ��������ܼ򵥣�ֻ��3�֣���ת����ΪL������ת����ΪR������ǰ���������ף�ֱ�Ӽ����֣���

    ���磬���ǿ��Զ�С���������µ�ָ�

    15L10R5LRR10R20

    ��С����ֱ��15���ף���ת������10���ף�����ת��...

    ���ѿ��������ڴ�ָ���С���ֻص��˳����ء�

    ��������ǣ���д�������û�����ָ��������ÿ��ָ��ִ�к�С��λ����ָ��ִ��ǰС��λ�õ�ֱ�߾��롣

�����롢�����ʽҪ��

    �û�������һ������n��n<100������ʾ����������n��ָ�

    ����������n��ָ�ÿ��ָ��ֻ��L��R��������ɣ�������0~100֮���������

    ÿ��ָ��ĳ��Ȳ�����256���ַ���

    ���������n�н����

    ÿ�������ʾС��ִ����Ӧ��ָ��ǰ��λ�õ�ֱ�߾��롣Ҫ���������뵽С����2λ��

    ���磺�û����룺
5
L100R50R10
3LLL5RR4L12
LL
100R
5L5L5L5

    ����������
102.96
9.06
0.00
100.00
0.00

 */
public class Test���������� {
	
	public static List<String> list = new ArrayList<String>();
	
	public static int m = 0;
	
	public static double distance = 0d;
	
	public static char dirNow = 'U';
	
	public static int x = 0, y = 0;
	
	public static List<String> result = new ArrayList<String>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int count = 0;
		while(count<n) {
			String str = scan.nextLine();
			walk(str);
			count ++;
			restore();
		}
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	/*
	 * ��ԭ���б���
	 */
	private static void restore() {
		list.removeAll(list);
		m = 0;
		distance = 0d;
		dirNow = 'U';
		x = 0;
		y = 0;
	}
	
	/*
	 * �����������ܷ���
	 */
	private static void walk(String str) {
		dealWithString(str);
		go(list);
		//System.out.println(x +" " + y);
		distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		/*String pattern = "#.##";		// ���ַ�ʽ��100.0��˵����ת����100��������
		DecimalFormat df = new DecimalFormat(pattern);*/
		result.add(String.format("%.2f", distance));
		//System.out.println(df.format(distance));
	}
	
	private static void go(List<String> list) {
		for(int i=0; i<list.size(); i++) {
			char c = list.get(i).charAt(0);
			if(c=='L' || c=='R') {
				turn(c);
			} else {
				m = Integer.parseInt(list.get(i));
				switch(dirNow) {
				case 'U':
					y += m;
					break;
				case 'L':
					x -= m;
					break;
				case 'R':
					x += m;
					break;
				case 'D':
					y -= m;
					break;
				}
			}
		}
	}
	
	/*
	 * ���ݵ�ǰ�������
	 */
	private static void turn(char c) {
		if(c=='L') {
			switch(dirNow) {
			case 'U':
				dirNow = 'L';
				break;
			case 'L':
				dirNow = 'D';
				break;
			case 'R':
				dirNow = 'U';
				break;
			case 'D':
				dirNow = 'R';
				break;
			}
		} else {
			switch(dirNow) {
			case 'U':
				dirNow = 'R';
				break;
			case 'L':
				dirNow = 'U';
				break;
			case 'R':
				dirNow = 'D';
				break;
			case 'D':
				dirNow = 'L';
				break;
			}
		}
	}
	
	/*
	 * ���ַ��������ֺͷ�����
	 */
	private static void dealWithString(String str) {
		int start = 0;
		int end = 0;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c=='L' || c=='R') {
				list.add(c+"");
				end ++;
				start = end;
			} else {
				int temp = i+1;
				end ++;
				if(temp == str.length()) {
					list.add(str.substring(start, end));
				} else if(str.charAt(temp)=='L' || str.charAt(temp)=='R') {
					list.add(str.substring(start, end));
					start = end;
				}
			}
		}
	}

}
