
/**
�� 5*5 ��������ϣ���һ��������������ӣ�1,1��
����������������������Գ� 8 ��������������������������������
�ĸ����ϣ�Ҫ���������������̺������س����㡣 
���ǰ 5 ���������ܷ������� 
�����ʽʾ���� 
1   16   21   10   25 
20  11   24   15   22 
17  2    19   6    9 
12  7    4    23   14 
3   18   13   8    5 
 */
public class Test�������� {
	
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
		System.out.println("�ܹ���" + count + "���߷�");
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
				//  ������λ�õĿɷ���������Ϊtrue
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
