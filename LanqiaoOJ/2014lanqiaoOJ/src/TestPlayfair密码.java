import java.util.Scanner;


public class TestPlayfair√‹¬Î {
	
	public static char[][] matrix = new char[5][5];
	
	public static StringBuffer result = new StringBuffer();
	
	public static String string;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		toMatrix(str1);
		dealWithStr2(str2);
	}

	private static void dealWithStr2(String str2) {
		for(int i=0; i<str2.length();) {
			String str = "";
			if(i+2>str2.length()) {
				str = str2.substring(i, i+1);
			} else {
				str = str2.substring(i, i+2);
			}
			i += 2;
			findCornerWords(str);
		}
		System.out.println(result);
	}

	private static void findCornerWords(String str) {
		if(str.length() == 2) {
			char c1 = str.charAt(0);
			char c2 = str.charAt(1);
			int x1=0, y1=0;
			int x2=0, y2=0;
			if(!(string.contains(c1+"")&&string.contains(c2+""))) {
				result.append(c1+""+c2);
			} else {
				for(int i=0; i<matrix.length; i++) {
					for(int j=0; j<matrix[i].length; j++) {
						if(matrix[i][j] == c1) {
							x1 = i;
							y1 = j;
						}
						if(matrix[i][j] == c2) {
							x2 = i;
							y2 = j;
						}
					}
				}
				char cc1, cc2;
				if(x1==x2 || y1==y2) {
					cc1 = matrix[x2][y2];
					cc2 = matrix[x1][y1];
				} else {
					cc1 = matrix[x1][y2];
					cc2 = matrix[x2][y1];
				}
				result.append(cc1+""+cc2);
			}
		} else {
			result.append(str);
		}
	}

	private static void toMatrix(String str1) {
		for(char c='a'; c<='z'; c++) {
			if(!str1.contains(c+"")) {
				str1 += c;
			}
			if(str1.length() == 25) {
				break;
			}
		}
		int index = 0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = str1.charAt(index);
				index ++;
			}
		}
		string = str1;
	}

}
