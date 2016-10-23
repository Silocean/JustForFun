import java.util.ArrayList;
import java.util.List;

/**

标题: 振兴中华

    小明参加了学校的趣味运动会，其中的一个项目是：跳格子。

    地上画着一些格子，每个格子里写一个字，如下所示：（也可参见p.jpg）

从我做起振
我做起振兴
做起振兴中
起振兴中华


    比赛时，先站在左上角的写着“从”字的格子里，可以横向或纵向跳到相邻的格子里，但不能跳到对角的格子或其它位置。
    一直要跳到“华”字结束。


    要求跳过的路线刚好构成“从我做起振兴中华”这句话。

    请你帮助小明算一算他一共有多少种可能的跳跃路线呢？
 */
public class 从我做起振兴中华 {
	
	public static String[][] map = {{"从","我","做","起","振"},
									{"我","做","起","振","兴"},
									{"做","起","振","兴","中"},
									{"起","振","兴","中","华"}};
	
	public static int[] incrementX = {0, 1};
	public static int[] incrementY = {1, 0};
	
	public static int count = 0;
	
	public static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		go(0, 0);
		System.out.println(count);
	}
	
	public static void go(int x, int y) {
		int a, b;
		if(x == 4 && y == 3) {
			count ++;
			return;
		} else {
			for(int i=0; i<2; i++) {
				a = x + incrementX[i];
				b = y + incrementY[i];
				if(a>=0 && a<=4 && b>=0 && b<=3) {
					go(a, b);
				}
			}
		}
	}

}
