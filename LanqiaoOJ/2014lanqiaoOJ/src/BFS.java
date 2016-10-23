import java.util.LinkedList;

/**
1.图的遍历（VC6.0/VS2005)

////////////////////////////////// 
//广度优先之节点遍历 
//1-----5----------9 
//|        |              | 
//|        |              |   
//2-----4----6-----8 
//|               |         | 
//|             |         | 
//3----------7-----10 
// 1 2 3 4 5 6 7 8 
//1 0 1 0 0 1 0 0 0 
//2 1 0 1 1 0 0 0 0 
//3 0 1 0 0 0 0 1 0 
//4 0 1 0 0 1 1 0 0 
//5 1 0 0 1 0 0 0 0 
//6 0 0 0 1 0 0 1 1 
//7 0 0 1 0 0 1 0 0 
//8 0 0 0 0 0 1 0 0
 */
public class BFS {
	
	public static final int M = 10;
	
	public static int matrix[][] = {{0,1,0,0,1,0,0,0,0,0},
									{1,0,1,1,0,0,0,0,0,0},
									{0,1,0,0,0,0,1,0,0,0},
									{0,1,0,0,1,1,0,0,0,0},
									{1,0,0,1,0,0,0,0,1,0},
									{0,0,0,1,0,0,1,1,0,0},
									{0,0,1,0,0,1,0,0,0,1},
									{0,0,0,0,0,1,0,0,1,1},
									{0,0,0,0,1,0,0,1,0,0},
									{0,0,0,0,0,0,1,1,0,0}};
	
	public static LinkedList<Integer> list = new LinkedList<Integer>();
	
	public static int visit[] = new int[M];

	public static void main(String[] args) {
		visit[0] = 1;
		list.add(1);
		while(!list.isEmpty()) {
			int top = list.getFirst();
			System.out.print(top+" ");
			list.removeFirst();
			for(int i=0; i<M; i++) {
				if(visit[i] == 0 && matrix[top-1][i] == 1) {
					visit[i] = 1;
					list.add(i+1);
				}
			}
		}
	}

}
