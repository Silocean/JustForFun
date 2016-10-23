import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TestÌøÂíÎÊÌâ2 {
	
	public static int c = 0;
	
	public static int[] incrementX = {
		1, 2, 2, 1
	};
	
	public static int[] incrementY = {
		2, 1, -1, -2
	};
	
	public static List<Point> list = new ArrayList<Point>();
	
	public static int num1, num2;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		list.add(new Point(0, 0));
		go(0, 0);
		System.out.println(c);
	}
	
	public static void go(int x, int y) {
		int a, b;
		Point p = new Point(x, y);
		if(p.x==num1 && p.y==num2) {
			print();
			return;
		} else {
			for(int i=0; i<4; i++) {
				a = x + incrementX[i];
				b = y + incrementY[i];
				if(a>=0&&a<=num1&&b>=0&&b<=num2) {
					list.add(new Point(a, b));
					go(a, b);
					list.remove(list.size()-1);
				}
			}
		}
	}
	
	public static void print() {
		String str = "";
		for(int i=0; i<list.size(); i++) {
			str += "(" + list.get(i).x + "," + list.get(i).y + ")" + "-->";
		}
		c ++;
		System.out.println(str.substring(0, str.length()-3));
	}

}
