
/**
在 5*5 格的棋盘上，有一个国家象棋的马，从（1,1）
点出发，按日字跳马，它可以朝 8 个方向跳，但不允许出界或跳到已跳过
的格子上，要求在跳遍整个棋盘后再条回出发点。 
输出前 5 个方案及总方案数。 
输出格式示例： 
1   16   21   10   25 
20  11   24   15   22 
17  2    19   6    9 
12  7    4    23   14 
3   18   13   8    5 
 */
public class Test跳马问题 {
	
	public static int[][] map = new int[5][5];
	
	public static boolean [][] isVisited = new boolean[5][5];
	
	public static int[] incrementX = {
		1, 2, 2, 1, -1, -2, -2, -1
	};
	
	public static int[] incrementY = {
		2, 1, -1, -2, -2, -1, 1, 2
	};
	
	public static int count = 0;

	public static void main(String[] args) {
		for(int i=0; i<isVisited.length; i++) {
			for(int j=0; j<isVisited[i].length; j++) {
				isVisited[i][j] = true;
			}
		}
		map[0][0] = 1;
		isVisited[0][0] = false;
		go(0, 0, 2);
		System.out.println("总共有" + count + "种走法");
	}
	
	public static void go(int i, int j, int n) {
		int x, y;
		if(n>25) {
			print();
			return;
		}
		for(int k=0; k<8; k++) {
			x = i + incrementX[k];
			y = j + incrementY[k];
			if(x>=0 && x<5 && y>=0 && y<5 && isVisited[x][y]) {
				map[x][y] = n;
				isVisited[x][y] = false;
				go(x, y, n+1);
				//  将各个位置的可访问性再设为true
				isVisited[x][y] = true;
				map[x][y] = 0;
			}
		}
	}
	
	public static void print() {
		count ++;
		if(count<=5) {
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[i].length; j++) {
					System.out.print(map[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println("==================================");
		}
	}

}
