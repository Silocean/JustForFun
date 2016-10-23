import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
    某少年宫引进了一批机器人小车。可以接受预先输入的指令，按指令行动。小车的基本动作很简单，只有3种：左转（记为L），右转（记为R），向前走若干厘米（直接记数字）。

    例如，我们可以对小车输入如下的指令：

    15L10R5LRR10R20

    则，小车先直行15厘米，左转，再走10厘米，再右转，...

    不难看出，对于此指令串，小车又回到了出发地。

    你的任务是：编写程序，由用户输入指令，程序输出每条指令执行后小车位置与指令执行前小车位置的直线距离。

【输入、输出格式要求】

    用户先输入一个整数n（n<100），表示接下来将有n条指令。

    接下来输入n条指令。每条指令只由L、R和数字组成（数字是0~100之间的整数）

    每条指令的长度不超过256个字符。

    程序则输出n行结果。

    每条结果表示小车执行相应的指令前后位置的直线距离。要求四舍五入到小数后2位。

    例如：用户输入：
5
L100R50R10
3LLL5RR4L12
LL
100R
5L5L5L5

    则程序输出：
102.96
9.06
0.00
100.00
0.00

 */
public class Test机器人行走 {
	
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
	 * 还原所有变量
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
	 * 机器人行走总方法
	 */
	private static void walk(String str) {
		dealWithString(str);
		go(list);
		//System.out.println(x +" " + y);
		distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		/*String pattern = "#.##";		// 这种方式对100.0来说，会转换成100，不合适
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
	 * 根据当前方向拐弯
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
	 * 将字符串按数字和方向拆分
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
