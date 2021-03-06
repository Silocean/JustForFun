import java.util.ArrayList;
import java.util.List;


class Test8Queens3 {
	
	public static StringBuffer result = new StringBuffer();
	
	public static List<Integer> list = new ArrayList<Integer>();
	
	public static int count = 0;
	
	public static char[][] map = new char[8][8];

	public static void main(String[] args) {
		for(int i=1; i<=8; i++) {
			list.add(i);
		}
		for(int i=0; i<map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = '*';
			}
		}
		go(0);
		System.out.println(count);
	}

	private static void go(int index) {
		if(index == 8) {
			if(check(result)) {
				count ++;
				//System.out.println(result);
				drawMap(result);
			}
			return;
		} else {
			for(int i=0; i<list.size(); i++) {
				int m = list.get(i);
				result.append(m);
				list.remove(i);
				go(index+1);
				list.add(i, m);
				result.deleteCharAt(result.length()-1);
			}
		}
	}
	
	private static void drawMap(StringBuffer sb) {
		for(int i=0; i<8; i++) {
			map[i][sb.charAt(i)-'1'] = 'M'; 
		}
		for(int i=0; i<map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===============");
		// 地图复原
		for(int i=0; i<map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = '*';
			}
		}
	}

	// 检查是否符合八皇后的位置要求
	private static boolean check(StringBuffer sb) {
		for(int i=0; i<sb.length(); i++) {
			for(int j=i+1; j<sb.length(); j++) {
				if((i-j)==sb.charAt(i)-sb.charAt(j) || ((j-i)==sb.charAt(i)-sb.charAt(j))) {
					return false;
				}
			}
		}
		return true;
	}

}
