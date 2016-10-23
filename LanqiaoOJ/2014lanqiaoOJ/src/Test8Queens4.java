
public class Test8Queens4 {
	
	public static StringBuffer result = new StringBuffer();
	
	public static int[][] map = new int[8][8];
	
	public static int count = 0;
	
	public static char[][] ditu = new char[8][8];

	public static void main(String[] args) {
		int index = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				map[i][j] = -1;
			}
		}
		for(int i=0; i<ditu.length; i++) {
			for(int j=0; j<ditu[i].length; j++) {
				ditu[i][j] = '*';
			}
		}
		go(index);
		System.out.println(count);
	}

	private static void go(int index) {
		
		if(index == 8) {
			//System.out.println(result);
			for(int i=0; i<ditu.length; i++) {
				for(int j=0; j<ditu[i].length; j++) {
					System.out.print(ditu[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("===============");
			// µØÍ¼¸´Ô­
			for(int i=0; i<ditu.length; i++) {
				for(int j=0; j<ditu[i].length; j++) {
					ditu[i][j] = '*';
				}
			}
			
			count ++;
			return;
		}
		for(int i=0; i<8; i++) {
			if(map[index][i] == -1) {
				//result.append(i+1);
				ditu[index][i] = 'M';
				
				for(int k=0; k<8; k++) {
					for(int r=0; r<8; r++) {
						if(map[k][r] == -1 && (k==index || r==i || Math.abs(k-index)==Math.abs(r-i))) {
							map[k][r] = index;
						}
					}
				}
				
				go(index+1);
				//result.deleteCharAt(result.length()-1);
				ditu[index][i] = '*';
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
