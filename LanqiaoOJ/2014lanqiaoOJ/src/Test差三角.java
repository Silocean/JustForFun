import java.util.ArrayList;
import java.util.List;

/**
标题：计算差三角

仔细观察下面的数字组成的三角形：

    3
   1 4
  5 6 2

看出什么特征吗？
首先，它包含了1~6的连续整数。
重要的是：每个数字都是其下方相邻的两个数字的差（当然是大数减去小数）
满足这样特征的三角形，称为：差三角。

你的任务是找出1~15的整数组成的一个更大的差三角。其形如：

      ?
     4 ?
    ? ? ?
   * ? ? ?
  ? ? ? ? ?

其中，只给出了一个确定的数字：4
请确定出“*” 代表的是哪个一个数字。
 */
public class Test差三角 {
	
	public static int[][] map = new int[5][5];
	
	public static boolean[] appear = new boolean[16];
	
	public static List<Integer> list = new ArrayList<Integer>();
	
	public static List<Integer> bottomList = new ArrayList<Integer>();

	public static void main(String[] args) {
		restore();
		for(int i=0; i<15; i++) {
			list.add(i+1);
		}
		go(0);
	}
	
	private static void restore() {
		for(int i=0; i<appear.length; i++) {
			appear[i] = false;
		}
	}

	private static void go(int index) {
		if(index == 5) {
			deal(bottomList);
			restore();
			return;
		} else {
			for(int i=0; i<list.size(); i++) {
				int m = list.get(i);
				list.remove(i);
				bottomList.add(m);
				go(index+1);
				bottomList.remove(bottomList.size()-1);
				list.add(i, m);
			}
		}
	}

	private static void deal(List<Integer> bottomList) {
		for(int i=0; i<bottomList.size(); i++) {
			map[4][i] = bottomList.get(i);
			appear[bottomList.get(i)] = true;
		}
		for(int i=3; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				int m = Math.abs(map[i+1][j] - map[i+1][j+1]);
				if(appear[m] == false) {
					map[i][j] = m;
					appear[m] = true;
				} else {
					return;
				}
			}
		}
		if(map[1][0] == 4) {
			System.out.println(map[3][0]);
		}
	}

}
