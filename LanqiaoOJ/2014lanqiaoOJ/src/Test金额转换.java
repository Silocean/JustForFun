import java.util.Scanner;


public class Test���ת�� {

	public static void main(String[] args) {
		char[] num = {'��','Ҽ','��','��','��','��','½','��','��','��','ʰ'};
		char[] unit = {'Ԫ','ʰ','��','Ǫ','��','ʰ','��','Ǫ','��','ʰ','��','Ǫ','��','ʰ','��','Ǫ','Ǫ'};
		char[] unit2 = {'��','��'};
		StringBuffer sb = new StringBuffer();
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		if(str.indexOf("\\.") == -1) {
			str += ".00";
		}
		String[] splitStr = str.split("\\.");
		for(int i=0; i<splitStr[0].length(); i++) {
			char c = splitStr[0].charAt(i);
			sb.append(num[c-'0']);
			sb.append(unit[splitStr[0].length()-i-1]);
		}
		for(int i=0; i<splitStr[1].length(); i++) {
			char c = splitStr[1].charAt(i);
			sb.append(num[c-'0']);
			sb.append(unit2[i]);
		}
		System.out.println(sb);
	}

}
