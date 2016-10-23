import java.awt.Rectangle;
import java.util.Scanner;

/**

    在编写图形界面软件的时候，经常会遇到处理两个矩形的关系。

    如图【1.jpg】所示，矩形的交集指的是：两个矩形重叠区的矩形，当然也可能不存在（参看【2.jpg】）。两个矩形的并集指的是：能包含这两个矩形的最小矩形，它一定是存在的。

    本题目的要求就是：由用户输入两个矩形的坐标，程序输出它们的交集和并集矩形。

    矩形坐标的输入格式是输入两个对角点坐标，注意，不保证是哪个对角，也不保证顺序（你可以体会一下，在桌面上拖动鼠标拉矩形，4个方向都可以的）。

    输入数据格式：
x1,y1,x2,y2
x1,y1,x2,y2
    
    数据共两行，每行表示一个矩形。每行是两个点的坐标。x坐标在左，y坐标在右。坐标系统是：屏幕左上角为(0,0)，x坐标水平向右增大；y坐标垂直向下增大。

    要求程序输出格式：
x1,y1,长度,高度
x1,y1,长度,高度

    也是两行数据，分别表示交集和并集。如果交集不存在，则输出“不存在”

    前边两项是左上角的坐标。后边是矩形的长度和高度。

    例如，用户输入：
100,220,300,100	
150,150,300,300

    则程序输出：
150,150,150,70
100,100,200,200	

    例如，用户输入：
10,10,20,20
30,30,40,40

    则程序输出：
不存在
10,10,30,30


 */
public class Test矩形运算 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rectangle []rects = new Rectangle[2];
		rects[0] = getRect();
		rects[1] = getRect();
		calculate(rects);
	}

	private static void calculate(Rectangle[] rects) {
		Rectangle r, rr;
		if(rects[0].intersects(rects[1])) { // 如果香蕉
			r = rects[0].intersection(rects[1]);
			System.out.println(r.x+","+r.y+","+r.width+","+r.height);
		} else {
			System.out.println("不存在");
		}
		rr = rects[0].union(rects[1]);
		System.out.println(rr.x+","+rr.y+","+rr.width+","+rr.height);
	}

	private static Rectangle getRect() {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String[] s = str.split(",");
		int x1 = Integer.parseInt(s[0]);
		int y1 = Integer.parseInt(s[1]);
		int x2 = Integer.parseInt(s[2]);
		int y2 = Integer.parseInt(s[3]);
		return new Rectangle(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
	}

}
