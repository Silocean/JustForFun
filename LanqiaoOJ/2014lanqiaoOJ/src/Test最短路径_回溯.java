import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test×î¶ÌÂ·¾¶_»ØËİ {
	
	public static int[][] map;
	
	public static boolean[][] isVisited;
	
	public static int sum = 0;
	
	public static int minDis = 78;
	
	public static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		map = new int[n][n];
		isVisited = new boolean[n][n];
		for(int i=0; i<isVisited.length; i++) {
			for(int j=0; j<isVisited[i].length; j++) {
				isVisited[i][j] = true;
			}
		}
		for(int i=0; i<n; i++) {
			String str = sc.nextLine();
			initMap(str, i);
		}
		// testPrint();
		go(0);
		System.out.println(minDis);
		
	}

	private static void go(int index) {
		if(index == 9) {
			if(sum < minDis) {
				minDis = sum;
			}
			// System.out.println(sum);
			System.out.println(list);
			return;
		} else {
			for(int i=0; i<map[0].length; i++) {
				if(map[index][i] > 0 && isVisited[index][i]) {
					isVisited[index][i] = false;
					sum += map[index][i];
					list.add(map[index][i]);
					go(index+1);
					isVisited[index][i] = true;
					sum -= map[index][i];
					list.remove(list.size()-1);
				}
			}
		}
	}

	private static void initMap(String str, int i) {
		String[] split = str.split(" ");
		int[] a = new int[split.length];
		for(int k=0; k<a.length; k++) {
			map[i][k] = Integer.parseInt(split[k]);
		}
	}
	
	private static void testPrint() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
