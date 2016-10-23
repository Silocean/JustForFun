import java.util.Scanner;


public class Test½ð¶î×ª»» {

	public static void main(String[] args) {
		char[] num = {'Áã','Ò¼','·¡','Èþ','ËÁ','Îé','Â½','Æâ','°Æ','¾Á','Ê°'};
		char[] unit = {'Ôª','Ê°','°Û','Çª','Íò','Ê°','°Û','Çª','ÒÚ','Ê°','°Û','Çª','Õ×','Ê°','°Û','Çª','Çª'};
		char[] unit2 = {'½Ç','·Ö'};
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
