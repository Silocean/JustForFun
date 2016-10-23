import java.util.LinkedList;

/**
 * δ���
 * @author Administrator
 *
 */
public class BFS_����֮�����·�� {
	
	public static int matrix[][] = {{1,0,0,0,1,0,1,1},
									{0,1,1,1,1,0,1,1},
									{0,1,1,0,0,1,1,1},
									{0,1,0,1,1,1,0,1},
									{1,1,0,1,1,1,0,0},
									{0,0,1,1,1,1,1,0},
									{1,1,1,0,0,1,1,0},
									{1,1,1,1,0,0,0,1}};
	
	public static LinkedList<Character> list = new LinkedList<Character>();
	
	public static int visit[] = new int[8];

	public static void main(String[] args) {
		visit[0] = 1;
		list.add('A');
		while(!list.isEmpty()) {
			char top = list.getFirst();
			list.removeFirst();
			for(int i=0; i<8; i++) {
				if(visit[i] == 0 && matrix[top-64-1][i] == 0) {
					visit[i] = 1;
					list.add((char)(i+1+64));
				}
			}
		}
	}

}
 