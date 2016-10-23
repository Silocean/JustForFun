
public class Test8Queens {
	
	public static StringBuffer result = new StringBuffer();
	
	public static int[][] map = new int[8][8];
	
	public static int count = 0;

	public static void main(String[] args) {
		int index = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				map[i][j] = -1;
			}
		}
		go(index);
		System.out.println(count);
	}

	private static void go(int index) {
		
		if(index == 8) {
			System.out.println(result);
			count ++;
			return;
		}
		for(int i=0; i<8; i++) {
			if(map[index][i] == -1) {
				result.append(i+1);
				
				for(int k=0; k<8; k++) {
					for(int r=0; r<8; r++) {
						if(map[k][r] == -1 && (k==index || r==i || Math.abs(k-index)==Math.abs(r-i))) {
							map[k][r] = index;
						}
					}
				}
				
				go(index+1);
				result.deleteCharAt(result.length()-1);
				for(int k=0; k<8; k++) {
					for(int r=0; r<8; r++) {
						if(map[k][r] == index) {
							map[k][r] = -1;
						}
					}
				}
			}
		}
	}

}
