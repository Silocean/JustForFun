import java.awt.Rectangle;
import java.util.Scanner;

/**

    �ڱ�дͼ�ν��������ʱ�򣬾��������������������εĹ�ϵ��

    ��ͼ��1.jpg����ʾ�����εĽ���ָ���ǣ����������ص����ľ��Σ���ȻҲ���ܲ����ڣ��ο���2.jpg�������������εĲ���ָ���ǣ��ܰ������������ε���С���Σ���һ���Ǵ��ڵġ�

    ����Ŀ��Ҫ����ǣ����û������������ε����꣬����������ǵĽ����Ͳ������Ρ�

    ��������������ʽ�����������Խǵ����꣬ע�⣬����֤���ĸ��Խǣ�Ҳ����֤˳����������һ�£����������϶���������Σ�4�����򶼿��Եģ���

    �������ݸ�ʽ��
x1,y1,x2,y2
x1,y1,x2,y2
    
    ���ݹ����У�ÿ�б�ʾһ�����Ρ�ÿ��������������ꡣx��������y�������ҡ�����ϵͳ�ǣ���Ļ���Ͻ�Ϊ(0,0)��x����ˮƽ��������y���괹ֱ��������

    Ҫ����������ʽ��
x1,y1,����,�߶�
x1,y1,����,�߶�

    Ҳ���������ݣ��ֱ��ʾ�����Ͳ�����������������ڣ�������������ڡ�

    ǰ�����������Ͻǵ����ꡣ����Ǿ��εĳ��Ⱥ͸߶ȡ�

    ���磬�û����룺
100,220,300,100	
150,150,300,300

    ����������
150,150,150,70
100,100,200,200	

    ���磬�û����룺
10,10,20,20
30,30,40,40

    ����������
������
10,10,30,30


 */
public class Test�������� {

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
		if(rects[0].intersects(rects[1])) { // ����㽶
			r = rects[0].intersection(rects[1]);
			System.out.println(r.x+","+r.y+","+r.width+","+r.height);
		} else {
			System.out.println("������");
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
