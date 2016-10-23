import java.util.Scanner;

/**
 * 设定1900年1月1日为星期一 需要考虑闰年 输出该月份所对应的月历 日 一 二 三 四 五 六
 * 
 * @author 303931362
 * 
 */
public class 万年历 {
	private static boolean run = false;

	public static void main(String[] args) {
		System.out.println("请输入年份：");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		for (int i = 1; i < 13; i++) {
			outdays(str + " " + i);
		}
		
	}

	public static void outdays(String st) {
		String[] sts = st.split(" ");
		int year = Integer.valueOf(sts[0]);
		int mon = Integer.valueOf(sts[1]);
		if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
			run = true;
		} else {
			run = false;
		}
		System.out.println("----------------------" + year + "年" + mon
				+ "月----------------------");
		System.out.println("日	一	二	三	四	五	六");
		int days = get_no(mon);
		int thisday = 0;
		
		int weekday = getdays(year, mon);
		int o = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				o++;
				if (o > weekday) {
					thisday++;
					System.out.print(thisday + "	");
					if (thisday >= days) {
						break;
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
			if (thisday >= days) {
				break;
			}
		}
		System.out.println("---------------------------------------------------");
	}

	public static int getdays(int y, int m) {
		int weekday = 0;
		int days = 0;
		for (int i = 1900; i < y; i++) {
			if (i % 400 == 0 || i % 4 == 0 && i % 100 != 0) {
				days += 366;
			} else {
				days += 365;
			}
		}
		for (int j = 0; j < m; j++) {
			days += get_no(j);
		}
		days += 1;
		weekday = days % 7;
		return weekday;
	}

	public static int get_no(int i) {
		int shu = 0;
		switch (i) {
		case 1:
			shu = 31;
			break;
		case 2:
			if (run) {
				shu = 29;
			} else {
				shu = 28;
			}
			break;
		case 3:
			shu = 31;
			break;
		case 4:
			shu = 30;
			break;
		case 5:
			shu = 31;
			break;
		case 6:
			shu = 30;
			break;
		case 7:
			shu = 31;
			break;
		case 8:
			shu = 31;
			break;
		case 9:
			shu = 30;
			break;
		case 10:
			shu = 31;
			break;
		case 11:
			shu = 30;
			break;
		case 12:
			shu = 31;
			break;
		default:
			break;
		}
		return shu;
	}
}
