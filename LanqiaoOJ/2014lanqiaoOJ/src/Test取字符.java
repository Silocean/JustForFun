import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * M选N问题的变种
 */
public class Test取字符 {
	
	public static List<Character> list = new ArrayList<Character>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		for(int i=0; i<str.length(); i++) {
			if(!list.contains(str.charAt(i))) {
				list.add(str.charAt(i));
			}
		}
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.size(); j++) {
				for(int k=0; k<list.size(); k++) {
					if(list.get(i)<list.get(j) && list.get(j)<list.get(k)) {
						System.out.println(list.get(i)+""+list.get(j)+""+list.get(k));
					}
				}
			}
		}
	} 
}
